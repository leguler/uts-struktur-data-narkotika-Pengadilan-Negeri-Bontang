package uts.narkotika.service;

import uts.narkotika.model.Putusan;
import uts.narkotika.struktur.SinglyLinkedList;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PutusanService {

    public SinglyLinkedList<Putusan> filterByJenis(SinglyLinkedList<Putusan> source, String jenis) {
        SinglyLinkedList<Putusan> result = new SinglyLinkedList<>();
        for (int i = 0; i < source.size(); i++) {
            Putusan p = source.get(i);
            if (p.getJenisNarkotika().equalsIgnoreCase(jenis.trim())) {
                result.addLast(p);
            }
        }
        return result;
    }

    public SinglyLinkedList<Putusan> filterByTahun(SinglyLinkedList<Putusan> source, int tahun) {
        SinglyLinkedList<Putusan> result = new SinglyLinkedList<>();
        for (int i = 0; i < source.size(); i++) {
            Putusan p = source.get(i);
            if (p.getTahun() == tahun) {
                result.addLast(p);
            }
        }
        return result;
    }

    public SinglyLinkedList<Putusan> sortByPidanaDesc(SinglyLinkedList<Putusan> source) {
        List<Putusan> temp = new ArrayList<>();
        for (int i = 0; i < source.size(); i++) {
            temp.add(source.get(i));
        }
        temp.sort(Comparator.comparingInt(Putusan::getPidanaBulan).reversed());
        SinglyLinkedList<Putusan> sorted = new SinglyLinkedList<>();
        for (Putusan p : temp) {
            sorted.addLast(p);
        }
        return sorted;
    }

    public double hitungRataRataPidana(SinglyLinkedList<Putusan> source) {
        if (source.isEmpty()) return 0.0;
        long total = 0;
        for (int i = 0; i < source.size(); i++) {
            total += source.get(i).getPidanaBulan();
        }
        return (double) total / source.size();
    }
}
