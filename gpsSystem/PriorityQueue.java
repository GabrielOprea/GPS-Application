package gpsSystem;

import java.util.ArrayList;

/** 
 * A generic priority queue implemented by me.
 * It is based on a heap, and has two main methods:
 * enqueue and dequeue
 * @author oprea
 * @param <T> generic object type
 */
public class PriorityQueue<T extends Comparable<T>> {

	ArrayList<T> pq;
	public static final int NAN = -1;
	
	public PriorityQueue() {
		pq = new ArrayList<T>();
	}
	
	/**
	 * 
	 * @param n The heap is stored as an ArrayList with initial capacity n
	 */
	public PriorityQueue(int n) {
		pq = new ArrayList<T>(n);
	}
	
	public ArrayList<T> toArray() {
		return pq;
	}
	
	public boolean isEmpty() {
		return pq.isEmpty();
	}
	
	/**
	 * Prints all elements in the Priority Queue, unordered
	 */
	public void show() {
		for(T elem : pq) {
			System.out.println(elem);
		}
	}
	
	/**
	 * @param val object to be added in the queue
	 */
	public void enqueue(T val) {
		pq.add(val);
		heapifyUp(pq.size() - 1);
	}
	
	/**
	 * @return the object with the highest priority
	 */
	public T dequeue() {
		int n = pq.size();
		T info = pq.get(0);
		pq.set(0, pq.get(n - 1));		
		pq.remove(n - 1);
		heapifyDown(0);
		return info;
	}
	
	//priority relation for the heap
	private boolean priority(T parent, T son) {
		int x = parent.compareTo(son);
		if(x > 0) return true;
		return false;
	}
	
	//obtains the index of the parent based on the index of the son parameter
	private int parent(int son) {
		if(son == 0) return NAN;
	
		int res = (son - 1) / 2;
		if(res >= 0 && res < pq.size()) {
			return res;
		}
		//no parent found
		return NAN;
	}
	
	//obtains the index of the left son based on the index of the parent
	private int leftSon(int parent) {
		int res = (parent * 2) + 1;
		if(res > 0 && res < pq.size())
			return res;
		//no left son found
		return NAN;
	}
	
	//obtains the index of the right son based on the index of the parent
	private int rightSon(int parent) {
		int res = 2 * (parent + 1);
		if(res > 0 && res < pq.size())
			return res;
		//no right son found
		else return NAN;
	}
	
	private void swap(int ind1, int ind2) {
		T aux = pq.get(ind1);
		pq.set(ind1, pq.get(ind2));
		pq.set(ind2, aux);
	}
	
	/* receives an element index and adds it in the right position in the 
	heap by performing swaps with its initial parents */
	private void heapifyUp(int pos) {
		int parent = parent(pos);
		while(parent != NAN && !priority(pq.get(parent), pq.get(pos))) {
			swap(parent, pos);
			pos = parent;
			parent = parent(pos);
		}
	}
	
	// retrieves the son with the highest priority
	private int getSonRel(int pos) {
		int leftSon = leftSon(pos);
		int rightSon = rightSon(pos);
		
		int crtSon;
		if(leftSon == NAN) crtSon = rightSon;
		else if(rightSon == NAN) crtSon = leftSon;
		else crtSon = priority(pq.get(leftSon), pq.get(rightSon)) ? leftSon : rightSon;
		
		return crtSon;
	}
	
	/* receives an element index and adds it in the right position in the 
	heap by performing swaps with its sons */
	private void heapifyDown(int pos) {
		int crtSon = getSonRel(pos);
		while(crtSon != NAN && !priority(pq.get(pos), pq.get(crtSon))) {
			swap(pos, crtSon);
			pos = crtSon;
			crtSon = getSonRel(pos);
		}
	}
}
