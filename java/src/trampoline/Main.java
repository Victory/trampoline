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

        testAddNodes();

        testFindNodes();

        System.out.println("Done");
    }

    public static void testFindNodes() {
        int ii = 0;
        ThreadLocalRandom rng = ThreadLocalRandom.current();
        Node root = new Node(rng.nextInt(20));
        Integer target = -1;
        for (ii = 0; ii < 10; ii++) {
            target = rng.nextInt(20);
            Node n = new Node(target);
            root.add(n);
        }

        Node found = root.find(target);
        if (found != null) {
            System.out.println("Found value: " + found.getValue());
        } else {
            System.out.println("Could not find value: " + target);
        }

    }


    public static void testAddNodes() {
        int ii;
        int rnd;
        ThreadLocalRandom rng = ThreadLocalRandom.current();
        Node root = new Node(rng.nextInt(20));
        for (ii = 0; ii < 10; ii++) {
            Node n = new Node(rng.nextInt(20));
            root.add(n);
        }
    }
}
