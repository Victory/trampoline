package trampoline;

public class EvenThunk extends Thunk {
    private Integer remainder;

    public EvenThunk(Integer i) {
        remainder = i;
    }

    class EvenThunkResult implements ThunkResult {
        @Override
        public Boolean getResult() {
            return remainder == 0;
        }
    }

    @Override
    public Thunk bounce () {
        remainder -= 2;
        if (remainder <= 0) {
            return done(new EvenThunkResult());
        }
        return cont(this);
    }
}
