import java.util.Arrays;

public class CountingSortDesc {

    static int[] countingSort(int[] data) {
        int n = data.length;
        if (n == 0) return new int[0];

        int min = data[0];
        int max = data[0];
        for (int value : data) {
            if (value < min) min = value;
            if (value > max) max = value;
        }

        long range = (long) max - min + 1;
        if (range > 10_000_000L) {
            throw new IllegalArgumentException("Rentang nilai terlalu besar untuk counting sort: " + range);
        }

        int[] count = new int[(int) range];

        // catat berapa kali tiap nilai muncul; min dipetakan ke indeks 0
        for (int value : data) {
            count[value - min]++;
        }

        // dijumlah dari nilai terbesar ke kecil, jadi count[i] = jumlah elemen yang nilainya >= i + min
        for (int i = count.length - 2; i >= 0; i--) {
            count[i] += count[i + 1];
        }

        // dibaca dari belakang agar elemen kembar tidak tertukar urutannya
        int[] output = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int pos = --count[data[i] - min];
            output[pos] = data[i];
        }
        return output;
    }

    public static void main(String[] args) {
        int a1 = 4, a2 = 2, a3 = 9, a4 = 2;
        int a5 = 7, a6 = 3, a7 = 7, a8 = 1;

        int[] data = {a1, a2, a3, a4, a5, a6, a7, a8};

        System.out.println("Sebelum : " + Arrays.toString(data));
        int[] result = countingSort(data);
        System.out.println("Sesudah : " + Arrays.toString(result));
    }
}