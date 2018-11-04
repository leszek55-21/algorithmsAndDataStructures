package myLinkedList;

import org.junit.Before;

import static org.junit.Assert.*;

public class MyLinkedListTest {

    private MyLinkedList<String> list;

    @Before
    public void beforeTest() {
        list = new MyLinkedList<>();
        list.addToEnd(new String("first"));
        list.addToEnd(new String("second"));
        list.addToEnd(new String("third"));
        list.addToEnd(new String("fourth"));

    }

    @org.junit.Test
    public void addToFront () {

    }

    @org.junit.Test
    public void addToEnd () {
    }

    @org.junit.Test
    public void removeFromFront () {
    }

    @org.junit.Test
    public void removeFromEnd () {
    }

    @org.junit.Test
    public void getSize () {
        int size = list.getSize();
        assertEquals(4, size);
    }

    @org.junit.Test
    public void isEmpty () {
    }

    @org.junit.Test
    public void printList () {
    }

    @org.junit.Test
    public void dummyTest() {
        String s  = "c";
        String d = s;
        assertSame(s, d);
    }
}