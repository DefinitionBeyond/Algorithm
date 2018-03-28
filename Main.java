import java.util.Scanner;

/**
 * Created by hasee-PC on 2017/5/11.
 */
public class Main {
    private int year;
    private int mon;
    private int day;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMon() {
        return mon;
    }

    public void setMon(int mon) {
        this.mon = mon;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Main(int year, int mon, int day) {
        this.year = year;
        this.mon = mon;
        this.day = day;
    }

    public boolean isRun(int year) {
        return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) ? true : false;
    }

    public int calYear_day() {//计算距1900年至输入年的天数
        int tot_day = 0;
        for (int i = 1900; i < getYear(); i++) {
            if (isRun(i)) tot_day += 366;
            else tot_day += 365;
        }
        return tot_day;
    }

    public int changeMon_day(int mon) {
        switch (mon) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (isRun(getYear())) return 29;
                else return 28;
            default:
                return -1;
        }
    }

    public int calMon_day() {
        int year_day = 0;
        for (int i = 1; i < getMon(); i++) {
            year_day += changeMon_day(i);
        }
        return year_day;
    }

    public int getTotday() {
        // System.out.println(calYear_day() + calMon_day()+"--------总天数");
        return calYear_day() + calMon_day();
    }

    public void print() {
        int t, week_day;
        t = getTotday() % 7 + 1;
        if (t == 7) {
            week_day = 0;
        } else {
            week_day = t;
        }
        System.out.println("星期日\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六\t");
        for (int k = 0; k < week_day; k++) {
            System.out.print("\t\t");
        }
        for (int i = 1; i <= changeMon_day(getMon()); i++) {
            if (i == getDay()) System.out.print(i + "*\t\t");
            else System.out.print(i + "\t\t");
            if ((getTotday() + i) % 7 == 6)
                System.out.println();
        }
        System.out.println();
    }
}

class Test3 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int year = cin.nextInt();
            int mon = cin.nextInt();
            int day = cin.nextInt();
            Main c = new Main(year, mon, day);
            c.print();
        }
    }
}

