package info.ymcode.study.sort;

/**
 * 归并排序
 */
public class MergeSort {

    public static void mergeSort(int[] arra) {
        if (arra == null || arra.length == 1) {
            return;
        }
        process(arra, 0, arra.length - 1);
    }

    /**
     * 划分
     *
     * @param arra
     * @param left
     * @param right
     */
    public static void process(int[] arra, int left, int right) {
        if (left == right) {
            return;
        }

        int mid = (left + right) / 2;
        process(arra, left, mid);
        process(arra, mid + 1, right);

        merge(arra, left, mid, right);
    }

    /**
     * 归并
     *
     * @param arra
     * @param left
     * @param mid
     * @param right
     */
    public static void merge(int[] arra, int left, int mid, int right) {
        int[] help = new int[right - left + 1];

        int l = left;
        int r = mid + 1;

        int index = 0;

        while (l <= mid && r <= right) {
            if (arra[l] < arra[r]) {
                help[index++] = arra[l++];
            } else {
                help[index++] = arra[r++];
            }
        }

        while (l <= mid) {
            help[index++] = arra[l++];
        }

        while (r <= right) {
            help[index++] = arra[r++];
        }

        for (int i = 0; i < help.length; i++) {
            arra[left + i] = help[i];
        }
    }

    public static void main(String[] args) {

        int[] arra = new int[]{0, 3, 1, 5, 6, 3, 8};

        mergeSort(arra);

        for (int i = 0; i < arra.length; i++) {
            System.out.println(arra[i]);
        }

    }
}
