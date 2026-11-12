# uts-struktur-data-narkotika-Pengadilan-Negeri-Kota-Bontang



UTS Struktur Data \& Algoritma - Pengadilan Negeri Kota Bontang



Repositori ini dibuat untuk memenuhi tugas Ujian Tengah Semester (UTS) mata kuliah \*\*Struktur Data \& Algoritma\*\* Universitas Muhammadiyah Malang (UMM). Kami membangun aplikasi Console berbasis Java untuk mengelola dan menganalisis data putusan hukum kasus narkotika dari Pengadilan Negeri (PN) Bontang.



Anggota Kelompok

\- \*\*Anta-Rixa\*\* (Rafi Nasywa Pratama - 202510370110024) - Pengembangan core struktur data, parser CSV, dan layanan utama.

\- \*\*Leguler\*\* (Dewangga - 202510370110031) - Manajemen dataset PN Bontang, integrasi fitur CLI, dan dokumentasi.



Fitur Utama Aplikasi

1\. \*\*Import Dataset CSV\*\*: Memuat data putusan hukum dari file CSV (`data/putusan\_50.csv`) ke dalam memori secara dinamis.

2\. \*\*Tampilkan Semua Data\*\*: Menampilkan daftar seluruh putusan hukum yang tersimpan.

3\. \*\*Filter Berdasarkan Jenis Narkotika\*\*: Menyaring daftar putusan berdasarkan jenis zat narkotika tertentu (misalnya Sabu, Ganja, dll).

4\. \*\*Urutkan Pidana Terlama (Sorting Descending)\*\*: Mengurutkan daftar putusan berdasarkan lama pidana penjara dari yang paling lama ke yang singkat.

5\. \*\*Statistik Rata-Rata Pidana\*\*: Menghitung rata-rata lama hukuman pidana penjara dari dataset yang dimuat.

6\. \*\*Riwayat Aktivitas (Audit Log Stack)\*\*: Mencatat dan melacak aktivitas perintah terakhir yang dilakukan pengguna menggunakan struktur data `ArrayStack` (prinsip LIFO).



Struktur Data Buatan Sendiri (`src/main/java/uts/narkotika/struktur/`)

Program ini tidak pakai struktur data bawaan Java (`java.util.List` atau `Stack`) untuk logika utamanya, melainkan bikin sendiri dari nol:

1\. \*\*SinglyLinkedList\*\*: Buat nyimpen daftar putusan secara dinamis di memori.

2\. \*\*ArrayStack\*\*: Buat nyimpen riwayat aktivitas user (audit log) pakai prinsip LIFO (\*Last In, First Out\*).



Cara Menjalankan Program

Pastikan di komputermu sudah terinstal \*\*Java JDK\*\* dan \*\*Maven\*\*.



1\. \*\*Clone repository \& buka terminal di folder proyek:\*\*

&#x20;  ```bash

&#x20;  git clone \[https://github.com/leguler/uts-struktur-data-narkotika-kelompok-bontang.git](https://github.com/leguler/uts-struktur-data-narkotika-kelompok-bontang.git)

&#x20;  cd uts-struktur-data-narkotika-kelompok-bontang

