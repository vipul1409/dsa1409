/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.concurrent.ConcurrentHashMap;
class UrlData implements Comparable<UrlData>
{
	public String url;
	public int count;
	
	public int compareTo(UrlData other) {
		return this.count - other.count;
	}
}

class BinaryHeap<T extends Comparable<T>> implements PriorityQueue<T> {
    private static final int DEFAULT_CAPACITY = 10;
    protected T[] array;
    protected int size;
    
    /**
     * Constructs a new BinaryHeap.
     */
    @SuppressWarnings("unchecked")
	public BinaryHeap (int capacity) {
        // Java doesn't allow construction of arrays of placeholder data types 
        array = (T[])new Comparable[capacity];  
        size = 0;
    }
    
    
    /**
     * Adds a value to the min-heap.
     */
    public void add(T value) {
        // grow array if needed
        if (size >= array.length - 1) {
            array = this.resize();
        }        
        
        // place element into heap at bottom
        size++;
        int index = size;
        array[index] = value;
        
        bubbleUp();
    }
    
    
    /**
     * Returns true if the heap has no elements; false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    
    /**
     * Returns (but does not remove) the minimum element in the heap.
     */
    public T peek() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }
        
        return array[1];
    }

    
    /**
     * Removes and returns the minimum element in the heap.
     */
    public T remove() {
    	// what do want return?
    	T result = peek();
    	
    	// get rid of the last leaf/decrement
    	array[1] = array[size];
    	array[size] = null;
    	size--;
    	
    	bubbleDown();
    	
    	return result;
    }
    
    
    /**
     * Returns a String representation of BinaryHeap with values stored with 
     * heap structure and order properties.
     */
    public String toString() {
        return Arrays.toString(array);
    }
    
    public List<UrlData> toList() {
        return Arrays.toList(array);
    }

    
    /**
     * Performs the "bubble down" operation to place the element that is at the 
     * root of the heap in its correct place so that the heap maintains the 
     * min-heap order property.
     */
    protected void bubbleDown() {
        int index = 1;
        
        // bubble down
        while (hasLeftChild(index)) {
            // which of my children is smaller?
            int smallerChild = leftIndex(index);
            
            // bubble with the smaller child, if I have a smaller child
            if (hasRightChild(index)
                && array[leftIndex(index)].compareTo(array[rightIndex(index)]) > 0) {
                smallerChild = rightIndex(index);
            } 
            
            if (array[index].compareTo(array[smallerChild]) > 0) {
                swap(index, smallerChild);
            } else {
                // otherwise, get outta here!
                break;
            }
            
            // make sure to update loop counter/index of where last el is put
            index = smallerChild;
        }        
    }
    
    
    /**
     * Performs the "bubble up" operation to place a newly inserted element 
     * (i.e. the element that is at the size index) in its correct place so 
     * that the heap maintains the min-heap order property.
     */
    protected void bubbleUp() {
        int index = this.size;
        
        while (hasParent(index)
                && (parent(index).compareTo(array[index]) > 0)) {
            // parent/child are out of order; swap them
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }        
    }
    
    
    protected boolean hasParent(int i) {
        return i > 1;
    }
    
    
    protected int leftIndex(int i) {
        return i * 2;
    }
    
    
    protected int rightIndex(int i) {
        return i * 2 + 1;
    }
    
    
    protected boolean hasLeftChild(int i) {
        return leftIndex(i) <= size;
    }
    
    
    protected boolean hasRightChild(int i) {
        return rightIndex(i) <= size;
    }
    
    
    protected T parent(int i) {
        return array[parentIndex(i)];
    }
    
    
    protected int parentIndex(int i) {
        return i / 2;
    }
    
    
    protected T[] resize() {
        return Arrays.copyOf(array, array.length * 2);
    }
    
    
    protected void swap(int index1, int index2) {
        T tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;        
    }
}

class WebsiteAnalyzer {
 // you may declare and use other variables or
 // other helper methods you may need
 private static BinaryHeap<UrlData> heap = new BinaryHeap<UrlData>(10);
 private static ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<String, Long>();
 
 //Can power till top 10
 public void reportPageAccess(String pageUrl) {
 	if(map.containsKey(pageUrl)) {
 		map[pageurl]++;
 	}
 	else {
 		hm.put(pageurl,1);
 	}
 	heap.add(new UrlData(pageUrl, map[pageUrl]));
 }
 
 // the size of the list returned must be n
 public List<UrlData> getTopNPages(int n) {
 	return 
 }
 
}
/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		System.out.println("Hello");
	}
}
