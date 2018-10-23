package ba.unsa.etf.rpr.tut1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void setIme() {
        Student s = new Student("Yahya", "Aly", 17777);
        assertEquals("Yahya", s.getIme());
        s.setIme("Yaly");
        assertEquals("Yaly", s.getIme());
    }

    @Test
    void setPrezime() {
        Student s = new Student("Yahya", "Aly", 17777);
        assertEquals("Aly", s.getPrezime());
        s.setPrezime("Yaly");
        assertEquals("Yaly", s.getPrezime());
    }

    @Test
    void setBrIndeksa() {
        Student s = new Student("Yahya", "Aly", 17777);
        assertEquals(17777, s.getBrIndeksa());
        s.setBrIndeksa(16666);
        assertEquals(16666, s.getBrIndeksa());
    }

    @Test
    void brisi() {
        Student s = new Student("Yahya", "Aly", 17777);
        s.brisi();
        assertAll("brisanje",
                () -> assertEquals("", s.getIme()),
                () -> assertEquals("", s.getPrezime()),
                () -> assertEquals(0, s.getBrIndeksa()),
                () -> assertTrue(s.isObrisan())
        );
    }
}