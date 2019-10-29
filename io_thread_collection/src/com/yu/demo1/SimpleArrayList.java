package src.com.yu.demo1;

import java.util.Arrays;

/**
 * 手动实现ArrayList
 * @author pengyu
 */
public class SimpleArrayList<E> {

    /**
     * 容量 默认大小10
      */
    private static int DEFAULT_CAPACITY = 10;
    /**
     * 数组最大容量
     */
    private final static int MAX_ARRAY_LENGTH = Integer.MAX_VALUE-8;
    /**
     * 存储元素的数组
     */
    private static Object[] elementData;

    /**
     * 数组大小
     */
    private static int size;

    public SimpleArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 构造器：生成数组
     * @param size
     */
    public SimpleArrayList(int size){
        if (size<0){
            throw new IllegalArgumentException();
        }else {// 生成指定大小的数组
            elementData = new Object[size];
        }
    }

    /**
     * 增加元素
     */
    public void add(E e){
        isCapacityEnough(size + 1);
        elementData[size++] = e;
    }

    /**
     * 判断是否需要扩容
     */
    private void isCapacityEnough(int size){
        if (size>DEFAULT_CAPACITY){
            explitcitCapacity(size+1);
        }
        if (size<0){
            throw new OutOfMemoryError();
        }
    }

    /**
     * 扩容
     */
    private void explitcitCapacity(int capacity){
        int newLength = elementData.length+ elementData.length>>2;
        // 在我们只增加一个元素的情况下，这个判断是永远不会生效的，
        // 但是如果有addAll方法，则增加的元素很多，就要导致一次申请2倍的长度是不够的。
        if(newLength-capacity<0){
            newLength = capacity;
        }
        // 超出数组最大长度的情况
        if (newLength > MAX_ARRAY_LENGTH){
            newLength = (capacity>MAX_ARRAY_LENGTH? Integer.MAX_VALUE : MAX_ARRAY_LENGTH);
        }
        elementData = Arrays.copyOf(elementData, newLength);
    }

    /**
     * 根据索引添加元素
     * @param index
     * @param e
     */
    public void add(int index,E e){
        checkRangeForAdd(index);
        isCapacityEnough(size+1);
        // 将index及之后的元素后移一位
        System.arraycopy(elementData, index, elementData, index+1, size-index);
        elementData[index] = e;
        size++;
    }

    /**
     * 判断索引是否越界
     */
    private void checkRangeForAdd(int index){
        // 支持头插、尾插、中间插
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("指定的index超出界限");
        }
    }

    // 检查index越界
    private void checkRange(int index){
        if (index >= size || index < 0){
            throw new IndexOutOfBoundsException("索引超出边界");
        }
    }

    /**
     * 获取指定元素
     * @param index
     * @return 查到的元素
     */
    public E get(int index){
        checkRange(index);
        // 对象造型并返回
        return (E)elementData[index];
    }

    /**
     * 获取元素位置
     */
    public int indexOf(Object o){
        if (o != null){
            for (int i = 0;i < size;i++){
                if (elementData[i].equals(o)){
                    return i;
                }
            }

        }else {
            for (int i = 0;i < size;i++){
                if (elementData[i]==null){
                    return i;
                }
            }
        }
        // 没有匹配到就返回-1
        return -1;
    }

    /**
     * 判断是否包含某元素
     */
    public boolean contains(Object o){
        return indexOf(o) >= 0;
    }

    /**
     * 获取大小
     */
    public int size(){
        return size;
    }

    // 判断是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 根据索引移除元素
     */
    public E remove(int index){
        checkRange(index);
        E value = (E)elementData[index];
        int moveSize = size - index - 1;
        if (moveSize > 0){
            System.arraycopy(elementData, index+1, elementData, index, moveSize);
        }
        // 因为这是对象，所以size--之后肯定找不到之前的元素，设置null但是并没有释放
        elementData[size--] = null;
        return value;
    }

    public boolean remove(Object o){
        if (contains(o)){
            remove(indexOf(o));
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String toString() {
       return Arrays.toString(elementData);

    }
}
