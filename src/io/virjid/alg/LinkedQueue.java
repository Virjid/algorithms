package io.virjid.alg;

public class LinkedQueue<E> extends LinkedList<E> {
	public LinkedQueue() {
		super();
	}
	
	public void add(E e) {
		super.add(e);
	}
	
	public E remove() {
		return super.remove(0);
	}
}
