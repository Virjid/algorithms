package io.virjid.alg;

public class LinkedStack<E> extends LinkedList<E> {
	public LinkedStack() {
		super();
	}
	
	public void push(E e) {
		super.add(e);
	}
	
	public E pop() {
		return super.remove(this.size()-1);
	}
	
	public boolean onStack(E e) {
		return super.contains(e);
	}
	
	public static void main(String[] args) {
		LinkedStack<String> stack = new LinkedStack<>();
		stack.push("a");
		stack.push("b");
		stack.pop();
		for (String s : stack) {
			System.out.println(s);
		}
	}
}
