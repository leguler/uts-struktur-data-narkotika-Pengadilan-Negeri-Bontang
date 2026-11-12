# ADR 1: Pemilihan Struktur Data Custom (SinglyLinkedList & ArrayStack)

## Status
Diterima

## Konteks
Tugas ini melarang penggunaan struktur data bawaan Java seperti `java.util.List` atau `java.util.Stack` untuk logika utama pengolahan data. Oleh karena itu, struktur data harus diimplementasikan secara manual.

## Keputusan
- Menggunakan **SinglyLinkedList** untuk menyimpan daftar putusan secara dinamis di memori agar efisien dalam penambahan elemen.
- Menggunakan **ArrayStack** dengan prinsip LIFO (Last In, First Out) untuk mencatat riwayat audit aktivitas (*audit log*).
