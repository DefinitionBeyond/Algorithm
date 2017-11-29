package three_privi.zuochengyun;

public class hanoi {
    public static void main(String[] args) {
        System.out.println(new hanoi().hanoiProblem(5,"1","2","3"));
    }
    public int hanoiProblem(int num,String left,String mid,String right){
        if(num<1){//块不合规则
            return 0;
        }
        return process(num,left,mid,right,left,right);
    }

    private int process(int num, String left, String mid, String right, String from, String to) {//from，to为自己期望从哪移动的起点和终点
        if(num==1){
            if(from.equals(mid)||to.equals(mid)){//从中出发的，或者从到达中，也只要一步
                System.out.println("Move 1 "+from+" to " +to);
                return 1;
            }else{//无论在左或者右，移动到目的地，都要先到中间（自定义规则，必须经过mid）
                System.out.println("Move 1 "+from+" to " +mid);
                System.out.println("Move 1 "+mid+" to " +to);
                return 2;
            }
        }else {
            if(from.equals(mid)||to.equals(mid)){
                String temp = (from.equals(left)||to.equals(left)?right:left);
                int p1 = process(num-1,left,mid,right,from,temp);
                int p2 = 1;
                System.out.println("Move "+num+ " "+from+" to " +to);
                int p3 = process(num-1,left,mid,right,temp,to);
                return p1+p2+p3;
            }
            else {
                int p1 = process(num-1,left,mid,right,from,to);
                int p2 = 1;
                System.out.println("Move "+num+ " "+from+" to " +mid);
                int p3 = process(num-1,left,mid,right,to,from);
                int p4 =1;
                System.out.println("Move "+num+ " "+mid+" to " +to);
                int p5 = process(num-1,left,mid,right,from,to);
                return p1+p2+p3+p4+p5;
            }
        }
    }
}
