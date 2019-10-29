package com.yu.testconnections.drylinkedlist;

/**
 * @author pengyu
 */
public class TestLinkedList<E> {

    private static class Node<E>{
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(E item, Node<E> next, Node<E> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    private int size;

    private Node<E> first;

    private Node<E> last;

    // add
    public boolean add(E element){
        // 插入到末尾
        addLast(element);
        return true; 
    }

    private void addLast(E element) {

        // 先找到最后一位
        Node<E> l = last;
        // 然后根据element创建新节点
        Node<E> node = new Node<>(element, null, l);
        // 新节点就是last
        last = node;
        // 如果之前last为空
        if (l == null){
            first = node;
        } else {
            // 让之前最后一位指向新节点
            l.next= node;
        }
        size++;
    }

    // 等于size表示添加到末尾
    private void checkRangeForAdd(int index) {
        if (index<0 || index > size){
            throw  new IndexOutOfBoundsException("指定索引超出范围："+index);
        }
    }

    public void add(int index , E element){
        // 有索引必须验证是否越界,添加和查找的越界范围不一样，一个不能等于size，一个可以等于size
        checkRangeForAdd(index);
        // 判断是否插入到末尾
        if (index == size){
            addLast(element);
        } else {
            // 根据索引通过遍历获取节点
            Node l = node(index);
            // 将节点l插入到index前面
            addBeforeNode(element ,l);
        }
    }

    /**
     *
     * @param element
     * @param specifiedNode 插入到该节点前面
     */
    private void addBeforeNode(E element, Node<E> specifiedNode) {

        // 需要前节点和新节点，后节点已经传过来了
        Node<E> preNode = specifiedNode.prev;
        // 定义新节点
        Node<E> newNode = new Node<>(element, specifiedNode, preNode);
        // 判断前节点是否为空，即是否为空链表
        if (preNode == null){
            first = newNode;
        } else {
            preNode.next = newNode;
        }

        specifiedNode.prev = newNode;
        size++;
    }

    // 根据索引获取节点
    private Node node(int index) {

        // 已知头尾，先判断从哪头遍历合适
        if (index < (size >> 1)){
            // 从头部开始 设置一个游标
            Node<E> cursor = first;
            // 起点0，结束到index
            for (int i = 0; i < index; i++) {
                cursor = cursor.next;
            }
            return cursor;
        } else {
            Node<E> cursor = last;
            for (int i=size;i>index;i--){
                cursor = cursor.prev;
            }
            return cursor;
        }
    }

    private void checkRange(int index){
        if (index<0 || index >=size){
            throw new IndexOutOfBoundsException("指定索引超出范围："+index);
        }
    }

    public E get(int index){
        checkRange(index);
        return (E)node(index);
    }

    public int indexOf(Object element){

        // 从首开始查找，分element是否为null，两种情况比较的对象不同
        Node<E> cursor = first;
        int count = 0;
        while (cursor != null) {
            if (element == null) {
                if (cursor.next == null){
                    return count;
                }
            } else {
                if (element.equals(cursor.item)){
                    return count;
                }
            }
            count++;
            cursor = cursor.next;
        }
        return -1;
    }

    public E remove(int index){
        checkRange(index);
        return deleLink(index);
    }

    private E deleLink(int index) {
        // 先获取要删除的节点
        Node<E> l = node(index);
        // 记录节点的值以便返回
        E item = l.item;
        Node<E> prevNode = l.prev;
        Node<E> nextNode = l.next;

        // 先看前节点的情况
        if (prevNode == null) {
            first = nextNode;
        } else {
            prevNode.next = nextNode;
            // 释放指针
            l.next = null;
        }

        if (nextNode == null) {
            last = prevNode;
        }else {
            nextNode.prev = prevNode;
            // 释放指针
            l.prev = null;
        }

        size--;
        // 释放值存储空间
        l.item = null;
        return item;
        }

    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index<0){
            return false;
        }
        deleLink(index);
        return true;
    }
}
