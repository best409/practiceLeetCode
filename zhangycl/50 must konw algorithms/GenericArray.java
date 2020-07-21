package com.algorithm.a05_array;

import com.sun.xml.internal.bind.v2.TODO;

/**
 * 参考文献：
 * [1] wangzheng0822. 必知必会50个代码实现[M]. github, 2019.
 * @author: zhangycl  by  wangzheng0822
 * @date: 2020/7/21
 * @description:  GenericArray 的实现代码 --> 简化模拟了ArrayList的源码实现
 *
 */
public class GenericArray<T> {
    private T[] data;
    private int size;


    /*
    * 根据传入容量，构造Array
    * */
    public GenericArray(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }


    /*
     * 无参构造方法，默认数组容量为10
     * */
    public GenericArray() {
        this(10);
    }

    /*
     * 获取数组容量
     * */
    public int getCapacity() {
        return data.length;
    }

    //获取当前元素数
    /*
     * 获取数组容量
     * */
    public int count() {
        return size;
    }

    /*
     * 判断数组是否为空
     * */
    public boolean isEmpty() {
        return size == 0;
    }

    /*
     * 修改 index 位置的元素
     * */
    public void set(int index, T e) {
        checkIndex(index);
        data[index] = e;
    }

    /*
    * 获取 index 位置的元素
    * */
    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    /*
    * 查看数组是否包含元素e
    * */
    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /*
    * 获取对应元素的下标，未找到，返回 -1
    * */
    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /*
    * 在 index 位置，插入元素 e，时间复杂度 O()
    * */
    public void add(int index, T e) {
        checkIndexForAdd(index);

        if (size == data.length) {
            int oldCapacity = data.length;
            //如果当前元素个数等于数组容量，则将数组扩充为原来的1.5倍
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            resize(newCapacity);
        }

        for (int i = size-1; i >= index ; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /*
    * 向元素头插入元素
    * */
    public void addFirst(T e) {
        add(0, e);
    }

    /*
    * 向数组尾插入元素
    * */
    public void addLast(T e) {
        add(size, e);
    }

    /*
    * 删除 index 位置的元素，并返回
    * */
    public T remove(int index) {
        checkIndex(index);

        T ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i -1] = data[i]; //下标索引的最大值为 size -1
        }

        // clear to let GC do its work
        data[--size] = null; //下标索引的最大值为 size -1

        /*//缩容
        有待解决
        if (size == data.length / 4){

        }*/
        //TODO

        return ret;
    }


    /*
    * 删除第一个元素
    * */
    public T removeFirst() {
        return remove(0);
    }

    /*
    * 删除末尾元素
    * */
    public T removeLeast() {
        return remove(size - 1); //下标从0开始
    }

    /*
    * 从数组中删除指定元素
    * */
    public void removeElement(T e) {
        int index = find(e);
        if(index != -1) {
            remove(index);
        }
    }


    /*
    * 扩容方法，时间复杂度O(n)
    * */
    private void resize(int capacity) {
        T[] newData = (T[])new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array size = %d, capacity = %d \n", size, data.length));
        builder.append('[');
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(", ");
            }

        }
        builder.append(']');
        return builder.toString();
    }

    /*
     * 查找元素，判断index是否溢出(0 <= index < size)
     * */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed! Require index >=0 and index < size.");
        }
    }

    /*
     * 插入元素，判断index是否溢出(0 <= index <= size)
     * */
    public void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed! Require index >=0 and index <= size.");
        }
    }

}
