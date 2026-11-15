import java.util.Stack;

public class DFS {
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

    public static void cariDFS(int startIndex, int target) {
        boolean[] visited = new boolean[namaNode.length];
        Stack<Integer> stack = new Stack<>();

        stack.push(startIndex);
        System.out.println("=== PROSES PENCARIAN DFS (Target n = " + target + ") ===");
        int langkah = 1;

        while (!stack.isEmpty()) {
            int current = stack.pop();

            if (!visited[current]) {
                visited[current] = true;
                System.out.println("Langkah " + langkah++ + ": Mengunjungi " + namaNode[current] 
                                + " (Nilai = " + nilaiNode[current] + ")");

                // Cek apakah nilai node saat ini adalah target n
                if (nilaiNode[current] == target) {
                    System.out.println("-> HASIL: Angka " + target + " DITEMUKAN pada node " + namaNode[current] + "!");
                    return;
                }

                // Masukkan tetangga ke stack dari indeks terbesar ke terkecil
                // agar node dengan indeks lebih kecil diproses lebih dulu (LIFO)
                for (int i = adjMatrix.length - 1; i >= 0; i--) {
                    if (adjMatrix[current][i] == 1 && !visited[i]) {
                        stack.push(i);
                    }
                }
            }
        }
        System.out.println("-> HASIL: Angka " + target + " tidak ditemukan.");
    }

    public static void main(String[] args) {
        int angkaDicari = 65; // Nilai n yang dicari
        cariDFS(0, angkaDicari); // Mulai dari indeks 0 (node a1)
    }
}