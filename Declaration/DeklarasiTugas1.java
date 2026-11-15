// 1. Buatlah sebuah deklarasi variabel dengan tipe data integer yang bernama ‘StrukturBaris’. (15 Poin)

// 2. Buatlah sebuah deklarasi variabel dengan tipe data string yang bernama ‘KataBaru’ yang berisi kata 
// ‘Nama Awal Anda' (silahkan ubah dengan nama awal anda masing-masing). (15 Poin)

// 3. Buatlah pendeklarasian array satu dimensi dengan nama ‘empatAngka’, tipe data integer, 
// yang berisi angka (2 Digit Nim Awal Anda, 10, 20, 2 Digit Nim AkhirAnda). (15 Poin)

// 4. Buatlah pendeklarasian array dua dimensi dengan nama ‘Angka’, tipe data String, 
// yang terdiri dari tiga baris dan tiga kolom, isi baris dan kolom berisi 
// angka berikut (2 Digit Nim Awal Anda, 3, 5, 14, 19, 20, 22, 27, 2 Digit Nim AkhirAnda). (20 Poin)

// 5. Buatlah deklarasi linked list dengan nama 'listAngka' yang memiliki 
// list (2 Digit Nim Awal Anda, 19, 44, 60, 2 Digit Nim AkhirAnda). (20 Poin)

// 6. Buatlah video penjelasan dengan durasi maksimal 15 menit tentang 
// cara kerja kode program yang kalian buat (Usahakan terlihat wajah saat menjelaskan) 
// dan gunakan format laporan yang sudah disedikan. (30 Poin)

import java.util.LinkedList;

public class DeklarasiTugas1 {
    public static void main(String[] args) {

        int StrukturBaris;
        StrukturBaris = 3;

        String KataBaru = "FLEXSY BILBIS TRIWIBOWO";

        int[] empatAngka = {5, 10, 20, 37};

        String[][] Angka = {
            {"05", "3",  "5"},
            {"14", "19", "20"},
            {"22", "27", "37"}
        };

        LinkedList<Integer> listAngka = new LinkedList<>();
        listAngka.add(5);
        listAngka.add(19);
        listAngka.add(44);
        listAngka.add(60);
        listAngka.add(37);

        System.out.println("StrukturBaris : " + StrukturBaris);
        System.out.println("KataBaru   : " + KataBaru);

        System.out.print("empatAngka : ");
        for (int n : empatAngka) System.out.print(n + " ");
        System.out.println();

        System.out.println("Angka      :");
        for (int i = 0; i < StrukturBaris; i++) {
            for (int j = 0; j < Angka[i].length; j++) {
                System.out.print(Angka[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("listAngka  : " + listAngka);
    }
}