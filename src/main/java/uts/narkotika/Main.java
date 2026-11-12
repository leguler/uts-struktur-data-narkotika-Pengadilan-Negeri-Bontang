package uts.narkotika;

import uts.narkotika.io.CsvPutusanParser;
import uts.narkotika.model.Putusan;
import uts.narkotika.service.PutusanService;
import uts.narkotika.struktur.ArrayStack;
import uts.narkotika.struktur.SinglyLinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SinglyLinkedList<Putusan> data = new SinglyLinkedList<>();
        ArrayStack<String> auditLog = new ArrayStack<>();
        PutusanService service = new PutusanService();

        while (true) {
            System.out.println("\n=== SISTEM MANAJEMEN PUTUSAN NARKOTIKA ===");
            System.out.println("1. Import CSV");
            System.out.println("2. Tampilkan Semua Data (" + data.size() + " putusan)");
            System.out.println("3. Filter Berdasarkan Jenis Narkotika");
            System.out.println("4. Urutkan Pidana Terlama (Descending)");
            System.out.println("5. Statistik Rata-Rata Pidana");
            System.out.println("6. Cek Riwayat Audit Terakhir (Stack)");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            String pilihan = scanner.nextLine().trim();
            try {
                switch (pilihan) {
                    case "1":
                        System.out.print("Masukkan path file CSV: ");
                        String path = scanner.nextLine().trim();
                        data = CsvPutusanParser.parseFile(path);
                        auditLog.push("IMPORT: " + path + " (" + data.size() + " baris)");
                        System.out.println("Berhasil memuat " + data.size() + " putusan.");
                        break;
                    case "2":
                        for (int i = 0; i < data.size(); i++) {
                            System.out.println((i + 1) + ". " + data.get(i));
                        }
                        auditLog.push("VIEW_ALL");
                        break;
                    case "3":
                        System.out.print("Jenis narkotika (misal Sabu/Ganja): ");
                        String jenis = scanner.nextLine().trim();
                        SinglyLinkedList<Putusan> filtered = service.filterByJenis(data, jenis);
                        for (int i = 0; i < filtered.size(); i++) {
                            System.out.println((i + 1) + ". " + filtered.get(i));
                        }
                        auditLog.push("FILTER_JENIS: " + jenis);
                        break;
                    case "4":
                        SinglyLinkedList<Putusan> sorted = service.sortByPidanaDesc(data);
                        for (int i = 0; i < sorted.size(); i++) {
                            System.out.println((i + 1) + ". " + sorted.get(i));
                        }
                        auditLog.push("SORT_PIDANA_DESC");
                        break;
                    case "5":
                        System.out.printf("Rata-rata pidana: %.2f bulan%n", service.hitungRataRataPidana(data));
                        auditLog.push("STATISTIK_RATA_RATA");
                        break;
                    case "6":
                        if (auditLog.isEmpty()) {
                            System.out.println("Belum ada aktivitas.");
                        } else {
                            System.out.println("Aktivitas terakhir: " + auditLog.peek());
                        }
                        break;
                    case "0":
                        System.out.println("Keluar dari program.");
                        return;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
            }
        }
    }
}
