package myLinkedList;

public class MyLinkedList<T> {

    private MyNode head;
    private MyNode tail;
    private int size;

    public void addToFront(Object object) {
        MyNode node = new MyNode(object);
        if(head == null) {
            tail = node;
        } else {
            head.setPrevious(node);
            node.setNext(head);
        }
        head = node;
        size++;
    }

    public void addToEnd(Object object) {
        MyNode node = new MyNode(object);
        if(tail == null) {
            head = node;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
        }
        tail = node;
        size++;
    }

    public Object removeFromFront() {
       if(isEmpty()) {
           return null;
       }
       MyNode removedNode = head;

       if(head.getNext() == null) {
           tail = null;
       } else {
           head.getNext().setPrevious(null);
       }
       head = head.getNext();
       size--;
       removedNode.setNext(null);
       return removedNode;
    }

    public Object removeFromEnd() {
        if(isEmpty()) {
            return null;
        }
        MyNode removedNode = tail;

        if(tail.getPrevious() == null) {
            head = null;
        } else {
            tail.getPrevious().setNext(null);
        }
        tail = tail.getPrevious();
        size--;
        removedNode.setPrevious(null);
        return removedNode;
    }

    public int getSize () {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        MyNode current = head;
        System.out.print("HEAD=>");
        while(current != null) {
            System.out.print(current);
            System.out.print("<=>");
            current = current.getNext();
        }
        System.out.println("null");
    }
}
