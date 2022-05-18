/**
 * Name: Sahil Gathe
 * ID: A16940774
 * Email: sgathe@ucsd.edu
 * Sources used: Tutors, Zybooks, and Lecture Slides
 * 
 * This file contains the tester for the Deque, Queue and Stack implmentation
 */

import org.junit.*;
import static org.junit.Assert.*;

/**
 * This class contains the tester for the Deque, Queue and Stack implmentation
 * 
 * IMPORTANT: Do not change the method names and points are awarded
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class CustomTester {
    // ----------------MyDeque class----------------
    /**
     * Test the constructor when the deque has a negtive intial capcity
     */
    @Test
    public void testMyDequeConstructor() {
        boolean error = false;
        try{
            MyDeque fail = new MyDeque<>(-1);
        }catch(IllegalArgumentException bad){
            error = true;
        }
        assertTrue(error);
    }

    /**
     * initalizes a daque without using deque methods 
     * @param deque
     * @param data
     * @param size
     * @param front
     * @param rear
     */
    static void initDeque(MyDeque<Integer> deque, Object[] data, int size, 
            int front, int rear) {
        deque.data = data;
        deque.size = size;
        deque.front = front;
        deque.rear = rear;
    }

    /**
     * Test the expandCapacity method when starting size is 0
     */
    @Test
    public void testMyDequeExpandCapacity() {
        MyDeque<Integer> deque = new MyDeque<>(0);
        deque.expandCapacity();
        assertEquals(10, deque.data.length);
    }

    /**
     * Test the addFirst method when the element is null
     */
    @Test
    public void testAddFirst() {
        boolean error = false;
        try{
            MyDeque fail = new MyDeque<>(10);
            fail.addFirst(null);
        }catch(NullPointerException bad){
            error = true;
        }
        assertTrue(error);
    }

    /**
     * Test the addLast method when element is null
     */
    @Test
    public void testAddLast() {
        boolean error = false;
        try{
            MyDeque fail = new MyDeque<>(10);
            fail.addLast(null);
        }catch(NullPointerException bad){
            error = true;
        }
        assertTrue(error);
    }

    /**
     * Test the removeFirst method when a deque with 0 elements
     */
    @Test
    public void testRemoveFirst() {
        MyDeque<Integer> deque = new MyDeque<>(10);
        Integer[] orig = { null, null, null, null, null, null, null };
        initDeque(deque, orig, 0, 0, 0);
        assertEquals(null, deque.removeFirst());
    }

    /**
     * Test the removeLast method when deque with 0 elements
     */
    @Test
    public void testRemoveLast() {
        MyDeque<Integer> deque = new MyDeque<>(10);
        Integer[] orig = { null, null, null, null, null, null, null };
        initDeque(deque, orig, 0, 0, 0);
        assertEquals(null, deque.removeLast());
    }

    /**
     * Test the peekFirst method when the deque has 0 elements
     */
    @Test
    public void testPeekFirst(){
        MyDeque<Integer> deque = new MyDeque<>(10);
        Integer[] orig = { null, null, null, null, null, null, null };
        initDeque(deque, orig, 0, 0, 0);
        assertEquals(null, deque.peekFirst());
    }

    /**
     * Test the peekLast method when the deque has 0 elements
     */
    @Test
    public void testPeekLast(){
        MyDeque<Integer> deque = new MyDeque<>(10);
        Integer[] orig = { null, null, null, null, null, null, null };
        initDeque(deque, orig, 0, 0, 0);
        assertEquals(null, deque.peekLast());
    }

    // ----------------MyStack class----------------
    /**
     * Test MyStack when pushing a null element
     */
    @Test
    public void testMyStack(){
        MyStack stack = new MyStack<>(10);
        boolean error = false;
        try{
            stack.push(null);
        }catch(NullPointerException bad){
            error = true;
        }
        assertTrue(error);
    }

    // ----------------MyQueue class----------------
    /**
     * Test MyQueue when quesing a null element
     */
    @Test
    public void testMyQueue(){
        MyQueue queue = new MyQueue(10);
        boolean error = false;
        try{
            queue.enqueue(null);
        }catch(NullPointerException bad){
            error = true;
        }
        assertTrue(error);
    }
}
