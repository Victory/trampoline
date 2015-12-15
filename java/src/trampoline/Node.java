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
        parent.innerAdd(child);
    }

    /**
     * returns Node with given value, if not found returns null
     * @param targetValue
     * @return
     */
    public Node find (Integer targetValue) {
        if (this.getValue().equals(targetValue)) {
            return this;
        }

        if (this.getValue() > targetValue) {
            if (rhs == null) {
                return null;
            }
            return rhs.find(targetValue);
        } else {
            if (lhs == null) {
                return null;
            }
            return lhs.find(targetValue);
        }
    }

    /**
     * adds a node to the tree
     *
     * @param child
     */
    public void add (Node child) {
        Node tempParent;
        Node lastParent =  this;
        Node parent = innerAdd(child);
        while (parent != lastParent) {
            tempParent = parent;
            parent = tempParent.innerAdd(child);
            lastParent = tempParent;
        }
    }

    public Node innerAdd (Node n) {
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
