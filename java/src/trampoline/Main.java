package trampoline;

import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String args[]) {
        System.out.println("Running trampoline");
        SumOfThunk sot = new SumOfThunk();
        System.out.println(sot.tramp(sot).getResult());
        EvenThunk et = new EvenThunk(11);
        System.out.println(et.tramp(et).getResult());
        et = new EvenThunk(10);
        System.out.println(et.tramp(et).getResult());

        testNodes();

        System.out.println("Done");
    }

    public static void testNodes() {
        int ii;
        int rnd;
        ThreadLocalRandom rng = ThreadLocalRandom.current();
        Node root = new Node(0);
        Node n;
        for (ii = 0; ii < 10; ii++) {
            rnd = rng.nextInt(20);
            n = new Node(rnd);
            root.bounce(n);
        }
    }
}
