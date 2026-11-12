# ADR 2: Strategi Pencarian dan Pengurutan

## Status
Diterima

## Konteks
Aplikasi memerlukan mekanisme untuk menyaring data berdasarkan jenis narkotika serta mengurutkan durasi hukuman pidana.

## Keputusan
- **Pencarian/Filter**: Dilakukan secara iteratif menelusuri `SinglyLinkedList` dengan mencocokkan string jenis narkotika secara *case-insensitive*.
- **Pengurutan (Sorting)**: Menggunakan algoritma perbandingan manual pada node linked list untuk mengurutkan durasi pidana dari yang terlama ke terbaru (Descending).
