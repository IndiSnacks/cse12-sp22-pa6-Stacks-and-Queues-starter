import java.lang.module.ResolutionException;
import java.security.SignatureException;

/**
 * Name: Sahil Gathe
 * Email: sgathe@ucsd.edu
 * Sources used: Tutors, zybook, and class slides 
 * 
 * This file contains a MyDeque class, which is an implementation of a deque.
 * 
 */

/**
 * This class implements the deque.
 */

class MyDeque<E> implements DequeInterface<E>{
    
    Object[] data;
    int size;
    int rear;
    int front;

    /**
     * Constroctor of the deque
     * 
     * @param initialCapacity the inital capsity for the data array
     * the daque is built on
     */
    public MyDeque(int initialCapacity){
        if(initialCapacity < 0){
            throw new IllegalArgumentException("Deque inital capasity is negtive");
        }
        else{
            this.data = new Object[initialCapacity];
            this.size = 0;
            this.front = 0;
            this.rear = 0;

        }
    }

    /**
     * @return return the deque's size
     */
    public int size(){
        return size;
    }

    /**
     * expends the capacity of the array the deque is built on
     */
    public void expandCapacity(){
        if(data.length == 0){
            data = new Object[10];
        }
        else{
            Object[] temp = new Object[data.length * 2];
            for(int i = 0; i < data.length; i++){
                temp[i] = data[i];
            }

            data = temp;
            front = 0;
            if(size == 0){
                rear = 0;
            }
            else{
                rear = size - 1;
            }
        }
    }

    /**
     * @param element will be added to frount of the deque
     */
    public void addFirst(E element){
        if(element == null){
            throw new NullPointerException("addFirst Elemtent null");
        }
        
        if(size >= data.length){
            expandCapacity();
        }
        
        if(size == 0){
            data[0] = element;
        }
        else if(front == 0){
            data[data.length - 1] = element;
            front = data.length;
        }
        else{
            data[front - 1] = element;
            front--;
        }
        size++;

        if(front > rear){
            for(int i = 0; i < data.length; i++){
                if(data[i] != null){
                    rear = i;
                }
                else{
                    break;
                }
            }
        }
        else{
            for(int i = front; i < data.length; i++){
                if(data[i] != null){
                    rear = i;
                }
                else{
                    break;
                }
            }
        }
    }

    /**
     * @param element is added to end of deque
     */
    public void addLast(E element){
        if(element == null){
            throw new NullPointerException("Element in addLast is null");
        }

        if(size >= data.length){
            expandCapacity();
        }

        if(rear == data.length - 1){
            data[0] = element;
            rear = 0;
        }
        else{
            data[rear + 1] = element;
            rear++;
        }
        size++;

        if(front > rear){
            for(int i = data.length - 1; i > 0; i++){
                if(data[i] != null){
                    front = i;
                }
                else{
                    break;
                }
            }
        }
        else{
            for(int i = rear; i > 0; i--){
                if(data[i] != null){
                    front = i;
                }
                else{
                    break;
                }
            }
        }
    }

    /**
     * removes the first element in the deque
     * 
     * @return the value of the removed elemnt form the deque
     */
    public E removeFirst(){
        if(size == 0){
            return null;
        }

        E rtnValue = (E) data[front];
        data[front] = null;
        size--;

        if(front > data.length || size == 0){
            front = 0;
        }
        else{
            front++;
        }

        return rtnValue;
    }

    /**
     * Removes the last element in the deque
     * 
     * @return the removed element
     */
    public E removeLast(){
        if(size == 0){
            return null;
        }

        E rtnValue = (E) data[rear];
        data[rear] = null;
        size--;

        if(rear == 0){
            rear = data.length;
        }
        else{
            rear--;
        }

        return rtnValue;
    }

    /**
     * @return the first element in the daque
     */
    public E peekFirst(){
        if(size == 0){
            return null;
        }
        else{
            return (E) data[front];
        }
    }

    /**
     * @return the last element in the deque
     */
    public E peekLast(){
        if(size == 0){
            return null;
        }
        else{
            return (E) data[rear];
        }
    }
}