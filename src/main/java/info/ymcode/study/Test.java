package info.ymcode.study;

public class Test {

    public int findTarget(int[] array, int target) {

        if (array == null) {
            return -1;
        }

        if (array.length == 1) {
            return (array[0] == target) ? 0 : -1;
        }

        int mid = array.length / 2;

        int start = 0;

        int length = array.length;

        while (mid >= start && mid < length) {

            if (array[mid] == target) {
                return mid;
            }

            if (array[mid] > target) {
                mid = mid / 2;
                length = mid;
            } else {
                mid = (length - mid) / 2;
                start = mid;
            }

        }
        return -1;
    }
}


