package src.com.yu.demo1.drylinkedlist;

/**
 * 手动实现LinkedList
 *
 * @author pengyuchen
 */
public class SimpleLinkedList<E> {

    private static class Node<E> {
        // 数据域
        E item;
        // 后指针
        Node<E> next;
        // 前指针
        Node<E> prev;

        public Node(E item, Node<E> next, Node<E> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    public SimpleLinkedList() {
    }

    private int size;
    private Node<E> first;
    private Node<E> last;


    /**
     * 添加元素到尾部
     */
    private void addAtLast(E element){
        // 先找到尾节点
        Node<E> l = last;
        // 创建要插入的节点
        Node<E> node = new Node<>(element, null, l);
        // 新节点就是last
        last = node;
        // 修改插入之前的最后一个节点
        if (l == null){ // 之前是空链表,那么node也是第一个节点
            first = node;
        }else { // 不是空链表的话，让之前的尾元素指向node
            l.next = node;
        }
        size++;
    }

    /**
     * 添加元素
     */
    public boolean add(E element){
        addAtLast(element);
        return true;
    }

    /**
     * 检查索引范围 ,因为是添加，所以等于size的大小也是合法的
     */
    private void checkRangeForAdd(int index){
        if (index < 0|| index > size){
            throw new IndexOutOfBoundsException("指定的index超出界限");
        }
    }

    /**
     * 插入指定位置
     */
    public void add(int index,E element){
        checkRangeForAdd(index);
        if (index == size){
            addAtLast(element);
        }else {
            // 取得index所在节点
            Node<E> l = node(index);
            addBeforeNode(element, l);
        }

    }

    /**
     * 根据索引使用二分法查找到节点
     */
    private Node<E> node(int index){
        // 必须遍历才能找到，通过二分法看到底是在前半段还是后半段，然后再决定从哪头开始遍历
        if (index < (size >> 1)){
            Node<E> cursor = first;
            for (int i=0;i<index;i++){
                cursor = cursor.next;
            }
            return cursor;
        }else {
            Node<E> cursor = last;
            for (int i = size - 1;i > index; i++){
                cursor = cursor.prev;
            }
            return cursor;
        }
    }


    /**
     * 前插
     */
    private void addBeforeNode(E element,Node<E> specifiedNode){
        // 找到前节点
        Node<E> preNode = specifiedNode.prev;
        // 创建新节点
        Node<E> newNode = new Node<>(element, specifiedNode, preNode);
        // 处理前节点
        if (preNode == null){
            first = newNode;
        }else {
            preNode.next = newNode;
        }
        // 处理后节点
        specifiedNode.prev = newNode;
        size++;
    }

    /**
     * 查找元素
     */
    public E get(int index){
        checkRange(index);
        return node(index).item;
    }

    /**
     * 范围检查
     */
    private void checkRange(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("指定index超出界限");
        }
    }

    /**
     * 查找元素位置
     */
    public int indexOf(Object element){
        Node<E> cursor = first;
        int count = 0;
        while (cursor != null){
            if (element == null){
                if (cursor.item == null){
                    return count;
                }
            }else {
                if (element.equals(cursor.item)){
                    return count;
                }
            }
            count++;
            cursor = cursor.next;
        }
        return -1;
    }

    /**
     * 根据索引删除
     */
    public E remove(int index){
        checkRange(index);
        return deleteLink(index);
    }

    /**
     * 根据index删除节点
     */
    private E deleteLink(int index){
        Node<E> l = node(index);
        // 前节点
        Node<E> preNode = l.prev;
        // 后节点
        Node<E> nextNode = l.next;
        // 前节点处理
        if (preNode == null){
            last = nextNode;
        }else {
            // 前节点指向后节点
            preNode.next = nextNode;
            // 和后节点断开
            l.next=null;
        }
        // 后节点处理
        if (nextNode == null){
            last = preNode;
        }else {
            // 后节点指向前节点
            nextNode.next = preNode;
            // 和前节点断开
            l.prev = null;
        }
        size--;
        E item = l.item;
        l.item = null;
        return item;
    }

    /**
     * 根据元素删除
     */
    public boolean remove(Object o){
        int index = indexOf(o);
        if (index < 0) {
            return false;
        }
        deleteLink(index);
        return true;
    }

    @Override
    public String toString() {
        String items = "";
        Node<E> cursor = first;
        while (cursor!=null){
            if (cursor.item!=null){
                items+=cursor.item;
                items+=" ";
            }
            cursor = cursor.next;
        }
        return items;
    }

    /**
     * 测试
     */
    public static void main(String[] args) {
        SimpleLinkedList<String> list = new SimpleLinkedList();

    }


}
