package myLinkedList;

public class MyNode {

    private MyNode previous;
    private MyNode next;
    private Object object;

    public MyNode (Object object) {
        this.object = object;
    }

    public MyNode getPrevious () {
        return previous;
    }

    public void setPrevious (MyNode previous) {
        this.previous = previous;
    }

    public MyNode getNext () {
        return next;
    }

    public void setNext (MyNode next) {
        this.next = next;
    }

    public Object getObject () {
        return object;
    }

    public void setObject (Object object) {
        this.object = object;
    }

    @Override
    public String toString () {
        return object.toString();
    }
}
