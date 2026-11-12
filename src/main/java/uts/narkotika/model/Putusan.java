package uts.narkotika.model;

public class Putusan {
    private final String nomorPutusan;
    private final int tahun;
    private final String pengadilan;
    private final String jenisNarkotika;
    private final double beratGram;
    private final int pidanaBulan;

    public Putusan(String nomorPutusan, int tahun, String pengadilan, String jenisNarkotika, double beratGram, int pidanaBulan) {
        this.nomorPutusan = nomorPutusan;
        this.tahun = tahun;
        this.pengadilan = pengadilan;
        this.jenisNarkotika = jenisNarkotika;
        this.beratGram = beratGram;
        this.pidanaBulan = pidanaBulan;
    }

    public String getNomorPutusan() { return nomorPutusan; }
    public int getTahun() { return tahun; }
    public String getPengadilan() { return pengadilan; }
    public String getJenisNarkotika() { return jenisNarkotika; }
    public double getBeratGram() { return beratGram; }
    public int getPidanaBulan() { return pidanaBulan; }

    @Override
    public String toString() {
        return String.format("%s (%d) - %s | %s (%.2fg) -> %d bulan",
                nomorPutusan, tahun, pengadilan, jenisNarkotika, beratGram, pidanaBulan);
    }
}
