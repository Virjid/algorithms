package io.virjid.alg;

import java.util.Iterator;
import java.util.Objects;

public class LinkedList<E> implements List<E> {
	private class Node<T> {
		private T data;
		private Node<T> next;
	}
	private int size;
	private Node<E> head;
	
	public LinkedList() {
		head = new Node<E>();
		size = 0;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			private Node<E> current = head;
			@Override
			public boolean hasNext() {
				return current.next!=null;
			}

			@Override
			public E next() {
				current = current.next;
				return current.data;
			}
			
		};
	}

	@Override
	public void add(int index, E e) {
		rangeCheckForAdd(index);
		int i = -1;
		Node<E> p = head;
		Node<E> q = null;
		while(i != index) {
			q = p;
			p = p.next;
			i++;
		}
		size++;
		Node<E> newNode = new Node<>();
		newNode.data = e;
		
		q.next = newNode;
		newNode.next = p;
	}
	
	@Override
	public void add(E e) {
		add(size, e);
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		rangeCheck(index);
		Node<E> p = head;
		Node<E> q = null;
		int i = -1;
		while(i != index) {
			q = p;
			p = p.next;
			i++;
		}
		
		q.next = p.next;
		p.next = null;
		size--;
		return p.data;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		rangeCheck(index);
		Node<E> p = head;
		int i = -1;
		while(i != index) {
			p = p.next;
			i++;
		}
		return p.data;
	}

	@Override
	public E set(int index, E e) throws IndexOutOfBoundsException {
		Node<E> p = head;
		int i = -1;
		while(i != index) {
			p = p.next;
			i++;
		}
		E oldEle = p.data;
		p.data = e;
		return oldEle;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public int size() {
		return size;
	}
	
	@Override
	public boolean contains(E e) {
		Node<E> p = head;
		while(p.next!=null) {
			p = p.next;
			if (Objects.equals(p.data, e)) return true;
		}
		return false;
	}
	
	private void rangeCheck(int index) {
		if (index<0 || index>=size)
			throw new IndexOutOfBoundsException(""+index);
	}
	
	private void rangeCheckForAdd(int index) {
		if (index<0 || index>size)
			throw new IndexOutOfBoundsException(""+index);
	}
}
