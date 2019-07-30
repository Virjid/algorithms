package io.virjid.alg;

import java.util.Objects;

public class Graph<E> {
	private class Vertice<T> {
		private T data;
		private LinkedList<T> list;
	}

	private class Edge<T> {
		private Vertice<T> out;
		private Vertice<T> in;
	}

	private Vertice<E>[] adj;
	private int size;
	private int edgeSize;

	@SuppressWarnings("unchecked")
	public Graph(int capacity) {
		adj = new Vertice[capacity];
		size = 0;
		edgeSize = 0;
	}

	/**
	 * <p>
	 * 向图中添加一个顶点并返回该顶点对应的Vertice对象，该对象含有所保存的数据
	 * </p>
	 * 
	 * @param e
	 * @return
	 */
	private Vertice<E> addVertice(E e) {
		size++;
		adj[size - 1] = new Vertice<E>();
		adj[size - 1].data = e;
		adj[size - 1].list = new LinkedList<E>();
		return adj[size - 1];
	}

	private Vertice<E> getVertice(E v) {
		for (int i = 0; i < size; i++) {
			Vertice<E> n = adj[i];
			if (Objects.equals(v, n.data))
				return n;
		}
		return null;
	}

	private Edge<E> handleEdgeForAdd(E v, E w) {
		boolean vf = false, wf = false;
		Edge<E> edge = new Edge<>();

		for (int i = 0; i < size; i++) {
			Vertice<E> n = adj[i];
			if (Objects.equals(v, n.data)) {
				edge.out = n;
				vf = true;
			}
			if (Objects.equals(w, n.data)) {
				edge.in = n;
				wf = true;
			}
		}

		if (!vf)
			edge.out = addVertice(v);
		if (!wf)
			edge.in = addVertice(w);

		return edge;
	}

	/**
	 * <p>
	 * 向图中添加一条边, 其中结点v指向结点w,即v-&gt;w
	 * </p>
	 * 
	 * @param v
	 * @param w
	 */
	public void addEdge(E v, E w) {
		Edge<E> edge = handleEdgeForAdd(v, w);
		edge.out.list.add(edge.in.data);
		edgeSize++;
	}

	public int size() {
		return size;
	}

	public int edgeSize() {
		return edgeSize;
	}

	public boolean contains(E e) {
		for (int i = 0; i < size; i++) {
			Vertice<E> v = adj[i];
			if (Objects.equals(e, v.data))
				return true;
		}
		return false;
	}

	public void paint() {
		for (int i = 0; i < size; i++) {
			Graph<E>.Vertice<E> node = adj[i];
			System.out.print(node.data + "=>");
			for (E s : node.list) {
				System.out.print(s + "-->");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Graph<String> g = new Graph<>(15);
		g.addEdge("a", "b");
		g.addEdge("b", "c");
		g.addEdge("c", "d");
		g.addEdge("a", "d");
		g.addEdge("d", "e");
		g.addEdge("f", "f");
		g.addEdge("a", "u");
		g.addEdge("f", "f");
		LinkedStack<String> cycle = new LinkedStack<>();
		boolean flag = g.cycle("f", cycle);
		
		for (String s : cycle) {
			System.out.println(s);
		}
		
		System.out.println(flag);
	}

	public boolean cycle(E v, LinkedStack<E> cycle) {
		if (cycle.size() != 0 && Objects.equals(v, cycle.get(0)))
			return true;
		
		if (cycle.onStack(v) && !Objects.equals(v, cycle.get(0))) return false;
		
		cycle.push(v);

		Vertice<E> n = getVertice(v);
		if (n.list == null || n.list.size() == 0)
			return false;
		for (int i = 0; i < n.list.size(); i++) {
			boolean flag = cycle(n.list.get(i), cycle);
			
			if (flag) return true;
			else cycle.pop();
		}

		return false;
	}
}
