import java.util.Arrays;

public class MergeSortDesc {

    static void mergeSort(int[] data) {
        int[] tmp = new int[data.length];
        sort(data, tmp, 0, data.length - 1);
    }

    private static void sort(int[] data, int[] tmp, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        sort(data, tmp, left, mid);
        sort(data, tmp, mid + 1, right);

        if (data[mid] >= data[mid + 1]) return;

        merge(data, tmp, left, mid, right);
    }

    private static void merge(int[] data, int[] tmp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            // >= supaya elemen kembar tetap di urutan aslinya (stabil)
            if (data[i] >= data[j]) {
                tmp[k++] = data[i++];
            } else {
                tmp[k++] = data[j++];
            }
        }
        while (i <= mid)   tmp[k++] = data[i++];
        while (j <= right) tmp[k++] = data[j++];

        System.arraycopy(tmp, left, data, left, right - left + 1);

        System.out.printf("merge [%d..%d] -> %s%n",
                left, right, Arrays.toString(Arrays.copyOfRange(data, left, right + 1)));
    }

    public static void main(String[] args) {
        int a1 = 38, a2 = 27, a3 = 43, a4 = 3;
        int a5 = 9, a6 = 82, a7 = 10, a8 = 55;

        int[] data = {a1, a2, a3, a4, a5, a6, a7, a8};

        System.out.println("Sebelum : " + Arrays.toString(data));
        mergeSort(data);
        System.out.println("Sesudah : " + Arrays.toString(data));
    }
}