package homework11.part2;

public class MainClass {

    public static void main(String[] args) {

        ThreadD d = new ThreadD(15);
        ThreadA a = new ThreadA(d);
        ThreadB b = new ThreadB(d);
        ThreadC c = new ThreadC(d);
    }
}
