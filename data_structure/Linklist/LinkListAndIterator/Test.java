package data_structure.Linklist.LinkListAndIterator;

/**
 * @author liutao
 * @date 2018/3/29  12:53
 */
public class Test {
    public static void main(String[] args) {
        LinkList list = new LinkList();
        Iterator iterator = list.getItertor();
        iterator.insertAfter(1);
        iterator.insertAfter(2);
        iterator.insertAfter(3);
        iterator.insertAfter(4);
        iterator.insertBefore(5);
        iterator.insertAfter(8);
        iterator.insertBefore(6);
        iterator.insertBefore(7);
        iterator.insertAfter(9);
        list.display();
        iterator.reset();
        System.out.println();
        while (!iterator.atEnd()) {
            System.out.println(iterator.getCur().val);
            iterator.next();
        }
//        System.out.println(iterator.getCur().val);
    }
}
