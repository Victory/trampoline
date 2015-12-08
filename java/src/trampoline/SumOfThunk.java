package trampoline;

public class SumOfThunk extends Thunk {
    private Integer result;
    private Integer max = 10;

    class SumOfThunkResult implements ThunkResult {
        private Integer sum;

        SumOfThunkResult(Integer sum) {
            this.sum = sum;
        }

        @Override
        public Object getResult() {
            return sum;
        }
    }

    public SumOfThunk ()
    {
        result = 0;
    }

    @Override
    public Thunk bounce () {
        if (max <= 0) {
            return done(new SumOfThunkResult(0));
        }
        result += max;
        max -= 1;
        Thunk t = new Thunk(new SumOfThunkResult(result));
        return cont(t);
    }
}
