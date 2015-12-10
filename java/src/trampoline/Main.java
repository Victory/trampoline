package trampoline;

public class Main {

    public static void main(String args[]) {
        System.out.println("Running trampoline");
        SumOfThunk sot = new SumOfThunk();
        System.out.println(sot.tramp(sot).getResult());
        EvenThunk et = new EvenThunk(11);
        System.out.println(et.tramp(et).getResult());
        et = new EvenThunk(10);
        System.out.println(et.tramp(et).getResult());
    }
}
