package trampoline;

import java.util.ArrayList;

public class Node {
    private Node lhs;
    private Node rhs;

    private Integer value;

    public Node(Integer value)
    {
        this.value = value;
    }

    private class SideAwareNode extends Node {
        final public String side;
        public SideAwareNode(Integer value, String side) {
            super(value);
            this.side = side;
        }
        public boolean isLhs () {
            return this.side.equals("lhs");
        }
        public boolean isRhs () {
            return !isLhs();
        }
    }

    public void printTree () {
        SideAwareNode next = innerPrintTree();
        ArrayList<Integer> printList = new ArrayList<Integer>();
        while (next != null) {
            if (next.isLhs()) {
                if (next.getValue() != null) {
                    System.out.println(next.getValue());
                }
            } else {
                if (next.getValue() != null) {
                    System.out.println(next.getValue());
                }
            }
            next = next.innerPrintTree();
            /*
            while (next.isLhs()) {
                if (next.getValue() != null) {
                    printList.add(next.getValue());
                }
                next = next.innerPrintTree();
                if (next == null) {
                    break;
                }
            }
            if (next == null) {
                break;
            }
            while (next.isRhs()) {
                if (next.getValue() != null) {
                    printList.add(next.getValue());
                }
                next = next.innerPrintTree();
                if (next == null) {
                    break;
                }
            }
            */
        }

        for (Integer val: printList) {
            System.out.println(val);
        }
    }

    public SideAwareNode innerPrintTree () {
        if (this.lhs != null) {
            return new SideAwareNode(lhs.getValue(), "lhs");
        }

        if (this.rhs != null) {
            return new SideAwareNode(rhs.getValue(), "rhs");
        }
        return null;
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
