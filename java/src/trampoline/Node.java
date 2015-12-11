package trampoline;

public class Node {
    private Node lhs;
    private Node rhs;

    private Integer value;

    public Node(Integer value)
    {
        this.value = value;
    }

    public void add (Node n) {
        if (n.getValue() > getValue()) {
            lhs = n;
        } else {
            rhs = n;
        }
    }
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
