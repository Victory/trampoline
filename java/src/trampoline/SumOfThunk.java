package trampoline;

public class SumOfThunk extends Thunk {
    private Integer result;
    private Integer max = 10;

    class SumOfThunkResult implements ThunkResult {
        SumOfThunkResult(Integer lastResult) {
            result += lastResult;
        }

        @Override
        public Object getResult() {
            return result;
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
        return cont(this);
    }
}
