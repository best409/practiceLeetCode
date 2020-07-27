package com.test;

/**
 * 参考文献：
 * [1]  labuladong. 我作了首诗，保你闭着眼睛也能写对二分查找[M]. 微信公众号, 2020.
 *
 * @author: zhangycl
 * @date: 2020/7/27
 * @description: 1、总结二分查找框架，
 *                  1. 注意「搜索区间」和 while 的终止条件，如果存在漏掉的元素，记得在最后检查。
 *                  2. 如果将「搜索区间」全都统一成两端都闭，好记，只要稍改nums[mid] == target条件处的代码和返回的逻辑即可，推荐拿小本本记下，作为二分搜索模板。
 *                  3. 分析二分查找代码时，不要出现 else，全部展开成 else if 方便理解。
 */
public class BinarySearchFramework {

    /*
     * 1、二分查找框架
     *   1. 其中...标记的部分，就是可能出现细节问题的地方，需要关注。
     *   2. 代码中left + (right - left) / 2就和(left + right) / 2的结果相同，但是有效防止了left和right太大直接相加导致溢出。
     * */
/*    int binarySearch(int[] nums, int target) {
        int left = 0, right = ...;

        while(...) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                ...
            } else if (nums[mid] < target) {
                left = ...
            } else if (nums[mid] > target) {
                right ...
            }
        }
        return ...;
    }*/


    /*
     * 2、寻找一个数（基本的二分搜索）
     *      1. 搜索区间的概念：while(left <= right)的终止条件是left == right + 1 ，写成区间的形式就是[right + 1, right]
     *      2. 不足：不能查找 2 的 左边界和右边界，nums = [1,2,2,2,3]
     * */

    int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;//注意

        while (left <= right) {
            int mid = left + (right - left) / 2; //该写法可以防止溢出
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1; //注意
            else if (nums[mid] > target)
                right = mid - 1; //注意
        }

        return -1;
    }

    /*
     * 2、寻找左边界的二分搜索
     *      1. nums = [1,2,2,2,3]
     * */
    int left_bound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; //注意
        //搜索区间为[left, right]
        while (left <= right) { //注意
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                //搜索区间变为[mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1; //注意
            } else if (nums[mid] == target) {
                //收缩右侧边界
                right = mid - 1;
            }

        }

        //检查出界情况：因为while结束循环时，left = right + 1，下标最大为nums.length - 1
        //当while(left < right)终止的条件是left == right，此时搜索区间[left, left)为空，所以可以正确终止。
        //当while(left <= right)终止的条件是left =right + 1，由于 while 的退出条件是left == right + 1，所以当target比nums中所有元素都大时，会存在情况使得索引越界
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }


    /*
     * 3、寻找右侧边界的二分查找
     *      1. nums = [1,2,2,2,3]
     * */
    int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right -left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                //这里改成收缩左侧边界即可
                left = mid +1 ;
            }
        }

        //这里改为检查right 越界的情况
        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }




}
