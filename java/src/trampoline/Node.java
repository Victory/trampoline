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
            if (lhs == null) {
                lhs = n;
            } else {
                lhs.add(n);
            }
        } else {
            if (rhs == null) {
                rhs = n;
            } else {
                rhs.add(n);
            }
        }
    }
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
