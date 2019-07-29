package io.virjid.alg;

public interface List<E> extends Iterable<E> {
	/**
	 * <p>在指定的索引处向列表中添加一个元素</p>
	 * @param index 索引
	 * @param e 要被添加的元素
	 */
	void add(int index, E e);
	
	/**
	 * <p>向列表的末尾添加一个元素</p>
	 * @param index 索引
	 * @param e 要被添加的元素
	 */
	void add(E e);
	
	/**
	 * <p>根据索引尝试从列表中删除对应元素,被删除的元素会被返回</p>
	 * @param index 索引
	 * @return 被删除的元素
	 * @throws IndexOutOfBoundsException 给定的索引不合法
	 */
	E remove(int index) throws IndexOutOfBoundsException;
	
	/**
	 * <p>尝试获取给定索引对应的元素</p>
	 * @param index 索引
	 * @return 返回查询到的结果
	 * @throws IndexOutOfBoundsException 给定的索引不合法
	 */
	E get(int index) throws IndexOutOfBoundsException;
	
	/**
	 * <p>修改列表中给定索引对应的元素,对应的旧元素会被返回</p>
	 * @param index 索引
	 * @param e 新的元素
	 * @return 返回旧元素
	 * @throws IndexOutOfBoundsException 给定的索引不合法
	 */
	E set(int index, E e) throws IndexOutOfBoundsException;
	
	/**
	 * <p>判断该列表是否为空</p>
	 * @return 如果该列表为空就返回true,反之为false
	 */
	boolean isEmpty();
	
	/**
	 * <p>返回列表中元素的个数</p>
	 * @return 链表长度
	 */
	int size();
	
	/**
	 * <p>判断列表中是否存在指定的元素</p>
	 * @param e
	 * @return
	 */
	boolean contains(E e);
}
