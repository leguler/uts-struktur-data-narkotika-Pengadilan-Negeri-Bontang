package uts.narkotika.io;

import org.junit.jupiter.api.Test;
import uts.narkotika.model.Putusan;
import static org.junit.jupiter.api.Assertions.*;

public class CsvPutusanParserTest {

    @Test
    void testParseLineDenganTandaKutip() {
        String baris = "\"123/Pid.Sus/2025/PN Mlg\",2025,\"PN Malang, Jawa Timur\",Sabu,1.50,60";
        Putusan p = CsvPutusanParser.parseLine(baris);

        assertEquals("123/Pid.Sus/2025/PN Mlg", p.getNomorPutusan());
        assertEquals(2025, p.getTahun());
        assertEquals("PN Malang, Jawa Timur", p.getPengadilan());
        assertEquals("Sabu", p.getJenisNarkotika());
        assertEquals(1.50, p.getBeratGram(), 0.001);
        assertEquals(60, p.getPidanaBulan());
    }
}
