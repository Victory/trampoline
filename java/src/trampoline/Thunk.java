package trampoline;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Thunk {
    private final boolean isDone;
    private ThunkResult result;

    public interface ThunkResult {
        public Object getResult();
    }
    protected Thunk () {
        isDone = false;
    }

    protected Thunk (ThunkResult result) {
        this.result = result;
        this.isDone = true;
    }

    public Thunk cont(Thunk t) {
        return t;
    }

    public Thunk done(ThunkResult tr) {
        return new Thunk(tr);
    }

    public ThunkResult tramp(Thunk b) {
        while (!b.isDone()) {
            b = b.bounce();
        }
        return b.getResult();
    }

    protected Thunk bounce() {
        throw new NotImplementedException();
    }

    public boolean isDone() {
        return isDone;
    }

    public ThunkResult getResult() {
        return result;
    }
}
