/**
 * @param <E>
 * @author 严书航
 * @date 2019/06/19
 */
public class LinearList<E> {
    /**
     * 存储数据的数组
     */
    private Object[] data;

    /**
     * 数组中存储的元素数量
     */
    private int size;

    /**
     * 默认数组容量：10
     */
    public LinearList() {
        this.data = new Object[10];
    }

    /**
     * 自定义数组的容量
     * @param initalSize 数组容量
     */
    public LinearList(int initalSize) {
        if (initalSize < 0) {
            throw new IllegalArgumentException("初始化大小不能小于0：initalSize " + initalSize);
        }
        this.data = new Object[initalSize];
    }

    /**
     *
     * @return 数组中的元素个数
     */
    public int size() {
        return this.size;
    }

    /**
     * 返回数组是否为空
     * @return 空时返回true
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     *
     * @param element 添加的元素
     * @return 成功返回true
     */
    public boolean add(E element) {
        this.data[size] = element;
        size++;
        return true;
    }

    /**
     *
     * @param index 元素的索引
     * @return 返回该索引存储的元素
     */
    public E get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("outofbound LinearList size " + size + " index " + index);
        }
        return (E) this.data[index];
    }

    /**
     *
     * @param index 索引
     * @param element 设置的新元素
     * @return 返回旧元素
     */
    public E set(int index, E element) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("outofbound LinearList size " + size + " index " + index);
        }
        E oldVal = get(index);
        data[index] = element;
        return oldVal;
    }

    /**
     * 在index前插入元素
     * @param index 索引
     * @param element 插入的元素
     * @return 成功返回true
     */
    public boolean insert(int index, E element) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("outofbound LinearList size " + size + " index " + index);
        }
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = element;
        size++;
        return true;
    }

    /**
     * 根据索引删除元素
     * @param index 索引
     * @return 返回删除的元素
     */
    public E remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("outofbound LinearList size " + size + " index " + index);
        }
        E oldVal = (E) data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
        return oldVal;
    }

    /**
     * 删除第一个匹配的元素
     * @param element 要删除的元素
     * @return 成功返回true
     */
    public boolean remove(E element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(data[i])) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i < size - 1) {
                builder.append(",");
            }
        }
        builder.append("]");
        return builder.toString();
    }
}
