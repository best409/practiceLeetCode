/**
 * 二分查找法：前提条件：数组有序。
 */
public class BinarySearch{
    public static void main(String[] args) {
        int [] arr = {1,5,9,11,32,55};
        int [] arr1 = {1,5,9,9,12,21,32};

    }

    /**
     * 在有序数组中，查找指定的target值
     * @param tmp
     * @param target
     * @return
     */
    public int binarySearch(int [] tmp, int target){
        int left = 0;
        int right = tmp.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2 ;
            if(tmp[mid] == target){
                return mid;
            }else if(tmp[mid] < target){
                left = mid +1 ;
            }else if(tmp[mid] > target){
                right = mid - 1;
            }
        }
        return -1 ;
    }


    /**
     * 查找指定元素的左边界索引值
     */

    public int biNinarySearchLeftBount(int []tmp, int target){

        int left = 0;
        int right = tmp.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(tmp[mid] == target){
                left =  mid - 1;
            }else if(tmp[mid] < target){
                left = mid +1 ;
            }else if(tmp[mid] > target){
                right = mid - 1;
            }
        }
        //当target > 数组中所有值时，考虑left越界情况
        if(left >= tmp.length || tmp[left] != target) return -1;
        return left + 1;
    }


    /**
    * 查找指定元素的右边界索引值
     */

    public int binarySearchLeftBount(int []tmp, int target){

        int left = 0;
        int right = tmp.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(tmp[mid] == target){
                right =  mid + 1;
            }else if(tmp[mid] < target){
                left = mid +1 ;
            }else if(tmp[mid] > target){
                right = mid - 1;
            }
        }
        //当target < 数组中所有值时，考虑right越界情况
        if(right <= 0 || tmp[right] != target) return -1;
        return right;
    }

    /**
     * 二分查找法递归写法
     */
    public int binarySearchRur(int []tmp, int target, int left, int right){
        if(null == tmp || tmp.length <= 0 ) return -1;
        int mid = left + (right - left) / 2;
        if(tmp[mid] < target){
            binarySearchRur(tmp,target,left,mid-1);
        }else if(tmp[mid] > target){
            binarySearchRur(tmp,target,left+1,right);
        }else{
            return mid;
        }
        return -1;
    }
}