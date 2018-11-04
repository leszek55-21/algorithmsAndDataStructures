import myLinkedList.MyLinkedList;

public class Main {

    public static void main(String[] args) {

        MyLinkedList<Integer> ints = new MyLinkedList<>();
        ints.addToFront(5);
        ints.addToFront(4);
        ints.addToFront(3);
        ints.addToFront(2);
        System.out.println(ints.getSize());
        ints.printList();
        ints.removeFromFront();
        System.out.println(ints.getSize());
        ints.printList();
        ints.removeFromEnd();
        System.out.println(ints.getSize());
        ints.printList();
    }

    public static void printArray(int[] arr) {
        for(int element: arr) {
            System.out.println(element);
        }
    }
}
