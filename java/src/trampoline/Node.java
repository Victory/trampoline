package trampoline;

public class Node {
    private Node lhs;
    private Node rhs;

    private Integer value;

    public Node(Integer value)
    {
        this.value = value;
    }

    public void contAdd (Node parent, Node child) {
        parent.add(child);
    }

    public Boolean hasToAdd;

    public void bounce (Node child) {
        Node tempParent;
        Node lastParent =  this;
        Node parent = add(child);
        while (parent != lastParent) {
            tempParent = parent;
            parent = tempParent.add(child);
            lastParent = tempParent;
        }
    }

    public Node add (Node n) {
        if (n.getValue() > getValue()) {
            if (lhs == null) {
                lhs = n;
            } else {
                return lhs;
            }
        } else {
            if (rhs == null) {
                rhs = n;
            } else {
                return rhs;
            }
        }
        return this;
    }
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
