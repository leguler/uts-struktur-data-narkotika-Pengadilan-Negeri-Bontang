package uts.narkotika.io;

import uts.narkotika.model.Putusan;
import uts.narkotika.struktur.SinglyLinkedList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvPutusanParser {

    public static SinglyLinkedList<Putusan> parseFile(String filePath) throws IOException {
        SinglyLinkedList<Putusan> list = new SinglyLinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                Putusan p = parseLine(line);
                if (p != null) {
                    list.addLast(p);
                }
            }
        }
        return list;
    }

    public static Putusan parseLine(String line) {
        String[] cols = splitCsvLine(line);
        if (cols.length < 6) {
            throw new IllegalArgumentException("Format baris CSV tidak valid: " + line);
        }
        String nomor = cols[0].trim();
        int tahun = Integer.parseInt(cols[1].trim());
        String pengadilan = cols[2].trim();
        String jenis = cols[3].trim();
        double berat = Double.parseDouble(cols[4].trim());
        int pidana = Integer.parseInt(cols[5].trim());
        return new Putusan(nomor, tahun, pengadilan, jenis, berat, pidana);
    }

    private static String[] splitCsvLine(String line) {
        List<String> tokens = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean inQuotes = false;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (c == ',' && !inQuotes) {
                tokens.add(sb.toString());
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }
        tokens.add(sb.toString());
        return tokens.toArray(new String[0]);
    }
}
