import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    static String[] namaNode = {"a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8"};
    static int[] nilaiNode = {10, 25, 30, 37, 50, 65, 70, 85};

    // Adjacency Matrix sesuai konsep pada modul[cite: 1]
    static int[][] adjMatrix = {
        //a1 a2 a3 a4 a5 a6 a7 a8
        { 0, 1, 1, 0, 0, 0, 0, 0 }, // a1
        { 0, 0, 0, 1, 1, 0, 0, 0 }, // a2
        { 0, 0, 0, 0, 0, 1, 1, 0 }, // a3
        { 0, 0, 0, 0, 0, 0, 0, 1 }, // a4
        { 0, 0, 0, 0, 0, 1, 0, 0 }, // a5
        { 0, 0, 0, 0, 0, 0, 0, 0 }, // a6
        { 0, 0, 0, 0, 0, 0, 0, 0 }, // a7
        { 0, 0, 0, 0, 0, 0, 0, 0 }  // a8
    };

    public static void cariBFS(int startIndex, int target) {
        boolean[] visited = new boolean[namaNode.length];
        Queue<Integer> queue = new LinkedList<>();

        visited[startIndex] = true;
        queue.add(startIndex);

        System.out.println("=== PROSES PENCARIAN BFS (Target n = " + target + ") ===");
        int langkah = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.println("Langkah " + langkah++ + ": Mengunjungi " + namaNode[current] 
                            + " (Nilai = " + nilaiNode[current] + ")");

            // Cek apakah nilai node saat ini adalah target n
            if (nilaiNode[current] == target) {
                System.out.println("-> HASIL: Angka " + target + " DITEMUKAN pada node " + namaNode[current] + "!");
                return;
            }

            // Masukkan semua tetangga yang belum dikunjungi ke dalam Queue (FIFO)
            for (int i = 0; i < adjMatrix.length; i++) {
                if (adjMatrix[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        System.out.println("-> HASIL: Angka " + target + " tidak ditemukan.");
    }

    public static void main(String[] args) {
        int angkaDicari = 65; // Nilai n yang dicari
        cariBFS(0, angkaDicari); // Mulai dari indeks 0 (node a1)
    }
}