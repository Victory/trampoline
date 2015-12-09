package trampoline;

public class Main {

    public static void main(String args[]) {
        System.out.println("Running trampoline");
        SumOfThunk sot = new SumOfThunk();
        System.out.println(sot.tramp(sot).getResult());
    }
}
