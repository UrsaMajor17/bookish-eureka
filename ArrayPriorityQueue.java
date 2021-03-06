//Team Bookish Eureka: Arpita Abrol, Jason Mohabir, William Xiang                                                                                                                 
//APCS2 pd10                                                                                                                                                                     
//HW35 -- Privileged Status Gets You to the Front of the Line                                                                                                                      
//2016-05-04                                                                                                                                                                       

import java.util.ArrayList;

public class ArrayPriorityQueue<Object> implements PriorityQueue<Object> {

    // instance vars
    ArrayList<Object> items;
    int size;

    // constructor for class ArrayPriorityQueue
    public ArrayPriorityQueue() {
        items = new ArrayList<Object>();
        size = 0;
    }

    // postcondition: returns true if the number of elements in 
    //                the priority queue is 0; otherwise, returns false 
    public boolean isEmpty(){
        return size == 0;
    }

    // postcondition: x has been added to the priority queue; 
    //                number of elements in the priority queue is increased by 1 
    public void add( Object x ) {
        items.add( (Object) x );
        size++;
    }

    // postcondition: The smallest item in the priority queue is removed 
    //                and returned; the number of elements in the priority queue 
    //                is decreased by 1
    //                throws an IndexOutOfBoundsException if the priority queue is empty 
    public Object removeMin() {
        int minIndex = findMin();
        Object min = items.get( minIndex );
        items.remove( minIndex );
        size--;
        return min;
    }

    // postcondition: The smallest item in the priority queue is returned; the 
    //                priority queue is unchanged 
    //                throws an IndexOutOfBoundsException if the priority queue is empty 
    public Object peekMin() {
        int minIndex = findMin();
        Object min = items.get( minIndex );
        return min;
    }
    
    
    // postcondition: The index of the smallest item in the priority queue  
    //                is returned; the priority queue is unchanged 
    //                throws an IndexOutOfBoundsException if the priority queue is empty 
    public int findMin() {
        if (size > 0) { //queue is empty
            int minIndex = 0;
            for (int i = 1; i < size; i++) { //reigning champ algo
                Comparable min = (Comparable) items.get(minIndex);
                Comparable itemAtIndex = (Comparable) items.get(i);
                if (  itemAtIndex.compareTo(min) < 0 )
                    minIndex = i;
            }
            return minIndex;
        } else {
            throw new IndexOutOfBoundsException("Error: Queue is empty!");
        }
    }
    
    public String toString() {
        String retStr = "[ ";
        for (int i = 0; i < size; i++) {
            retStr += items.get(i) + ", ";
        }
        
        if (size > 0) retStr = retStr.substring( 0, retStr.length() - 2 ) + " ]";
        else retStr += "]";
        
        return retStr;
    }

    public static void main(String[] args) {
        
        ArrayPriorityQueue<Integer> tomo = new ArrayPriorityQueue<Integer>();
        
        System.out.println("\n\nAdding elements to tomo...");
        System.out.println("tomo before adding: " + tomo);
        tomo.add(1);
        tomo.add(5);
        tomo.add(7);
        tomo.add(2);
        tomo.add(5);
        System.out.println("tomo after adding: " + tomo);
        
        
        System.out.println("\n\nRemoving elements from tomo...");
        while (true) { 
            //should eventually result in IndexOutOfBoundsException being thrown
            System.out.println("\nMin value: " + tomo.peekMin());
            System.out.println(tomo.removeMin());
            System.out.println("tomo after removing: " + tomo);
        }
    }

} //end class