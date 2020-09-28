package info.ymcode.study.search;

/**
 * 有序数组2分查找某个数
 */
public class BinSearch {

    /**
     * 有序数组，2分查找，某个数出现的最后的位置
     *
     * @param arr
     * @param target
     * @return
     */
    public static int binSearchLast(int[] arr, int target) {
        if (arr == null) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int mid = (left + right) / 2;
            // arr[mid] >= target，从mid开始往后找
            if (target >= arr[mid]) {
                left = mid;
            } else {
                // 此时，arr[mid] != target。所以跳过边界mid。right = mid -1
                right = mid - 1;
            }

        }

        // 返回right
        return arr[right] == target ? right : -1;
    }

    /**
     * 有序数组，2分查找，某个数出现的第一次的位置
     *
     * @param arr
     * @param target
     * @return
     */
    public static int binSearchFirst(int[] arr, int target) {
        if (arr == null) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int mid = (left + right) / 2;
            // target > arr[mid]时，往前找
            if (target > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }

        // 返回left
        return arr[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 2, 3, 4, 5};
        System.out.println(binSearchLast(arr, 2));
        System.out.println(binSearchFirst(arr, 2));
    }
}
