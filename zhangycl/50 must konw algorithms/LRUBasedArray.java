package com.algorithm.a06_linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * 参考文献：
 * [1] wangzheng0822. 必知必会50个代码实现[M]. github, 2019.
 * @author: zhangycl  by  wangzheng0822
 * @date: 2020/7/21
 * @description:  数组实现LRU缓存：T(n) = O(n) , S(n) = O(n), 不支持 null 缓存
 *                 1. 用数组T[] 移动位置，用hashmp判断是否存在某个值和该值在数组中的下标位置
 */
public class LRUBasedArray<T> {

    private static final int DEFAULT_CAPACITY = (1 << 3); //8

    private int capacity;
    private int count;
    private T[] value;
    private Map<T,Integer> holder;

    public LRUBasedArray() {

        this(DEFAULT_CAPACITY);
    }

    public LRUBasedArray(int capacity) {
        this.capacity = capacity;
        value = (T[]) new Object[capacity];
        count = 0;
        holder = new HashMap<T, Integer>(capacity);
    }

    /*
    *模拟访问某个值
    * */
    public void offer(T object) {
        if (object == null) {
            throw new IllegalArgumentException("该缓存容器不支持null");
        }
        Integer index = holder.get(object);
        if(index == null) {
            if (isFull()) {
                removeAndCache(object);
            } else {
                cache(object, count );
            }
        } else {
            update(index);
        }
    }

    /*
    * 若缓存中有指定的值，则更新位置
    * */
    public void update(int end) {
        T target = value[end];
        rightShift(end);//end之前的元素统一向后移动一位
        value[0] = target;
        holder.put(target, 0);
    }

    /*
    * 缓存数据到头部，但 end 位置前的元素要先统一右移
    * */
    public void cache(T object, int end) {
        rightShift(end);
        value[0] = object;
        holder.put(object, 0);
        count++;
    }

    /*
    * 缓存满的情况，踢出最后一个元素后，在缓存到数组头部
    * */
    public void removeAndCache(T object) {
        T key = value[--count];
        holder.remove(key);//删除数组最后一个元素
        cache(object, count);
    }


    /*
    * 缓存是否满了
    * */
    public boolean isFull() {
        return count == capacity;
    }

    /*
    * 是否包含key
    * */
    public boolean isContain(T object) {
        return holder.containsKey(object);
    }

    /*
    * 是否为空
    * */
    public boolean isEmpty() {
        return count == 0;
    }

    /*
    * end左边的数据统一右移一位
    * */
    public void rightShift(int end) {
        for (int i = end -1; i >= 0; i--) {
            value[i + 1] = value[i];
            holder.put(value[i], i + 1);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(value[i]);
            sb.append(" ");

        }
        return sb.toString();
    }


    static class TestLRUBaseArray {
        public static void main(String[] args) {
//            testWithException();
            testDefaultConstructor();
            testSpecifiedConstructor(5);
        }

        private static void testWithException() {
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>();
            lru.offer(null);

        }

        public static void testDefaultConstructor() {
            System.out.println("===无参测试===");
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>();
            lru.offer(1);
            lru.offer(2);
            lru.offer(3);
            lru.offer(4);
            lru.offer(5);
            System.out.println(lru);
            lru.offer(6);
            lru.offer(7);
            lru.offer(8);
            lru.offer(9);
            System.out.println(lru);
        }

        public static void testSpecifiedConstructor(int capacity) {
            System.out.println("======有参测试========");
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>(capacity);
            lru.offer(1);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
            lru.offer(3);
            System.out.println(lru);
            lru.offer(4);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
            lru.offer(4);
            System.out.println(lru);
            lru.offer(7);
            System.out.println(lru);
            lru.offer(1);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
        }

    }

}
