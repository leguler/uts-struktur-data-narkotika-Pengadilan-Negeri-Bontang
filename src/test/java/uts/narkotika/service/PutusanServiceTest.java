package uts.narkotika.service;

import org.junit.jupiter.api.Test;
import uts.narkotika.model.Putusan;
import uts.narkotika.struktur.SinglyLinkedList;
import static org.junit.jupiter.api.Assertions.*;

public class PutusanServiceTest {

    @Test
    void testFilterDanStatistik() {
        SinglyLinkedList<Putusan> list = new SinglyLinkedList<>();
        list.addLast(new Putusan("01/Pid.Sus/2025", 2025, "PN Malang", "Sabu", 1.2, 60));
        list.addLast(new Putusan("02/Pid.Sus/2025", 2025, "PN Surabaya", "Ganja", 5.0, 48));
        list.addLast(new Putusan("03/Pid.Sus/2025", 2024, "PN Malang", "Sabu", 2.5, 84));

        PutusanService service = new PutusanService();
        assertEquals(2, service.filterByJenis(list, "Sabu").size());
        assertEquals(64.0, service.hitungRataRataPidana(list), 0.01);
        assertEquals("03/Pid.Sus/2025", service.sortByPidanaDesc(list).get(0).getNomorPutusan());
    }
}
