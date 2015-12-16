package trampoline;

public class Node {
    private Node lhs;
    private Node rhs;

    private Integer value;

    public Node(Integer value)
    {
        this.value = value;
    }

    public void printTree () {
        if (this.lhs != null) {
            lhs.printTree();
        }
        if (this.getValue() != null) {
            System.out.println(this.getValue());
        }
        if (this.rhs != null) {
            rhs.printTree();
        }
    }

    /**
     * find a node, returns null if not found
     * @param targetValue
     * @return
     */
    public Node find (Integer targetValue) {
        Node found = this;
        Node lastFound = found;
        while (found != null) {
            found = found.innerFind(targetValue);
            lastFound = found;
            if (lastFound == null) {
                break;
            }
            if (lastFound.getValue().equals(targetValue)) {
                break;
            }
        }

        return lastFound;
    }

    /**
     * returns Node with given value, if not found returns null
     * @param targetValue
     * @return
     */
    private Node innerFind (Integer targetValue) {
        if (this.getValue().equals(targetValue)) {
            return this;
        }

        if (this.getValue() > targetValue) {
            if (rhs == null) {
                return null;
            }
            return rhs;
        } else {
            if (lhs == null) {
                return null;
            }
            return lhs;
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

    private Node innerAdd (Node n) {
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
