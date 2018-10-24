package ba.unsa.etf.rpr.tut1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void ctorExceptionTest() { // dva studenta ne mogu imati isti broj indeksa
        assertThrows(IllegalArgumentException.class, () -> {
            Student s1 = new Student("Yahya", "Aly", 17777);
            Student s2 = new Student("Muhamed", "Sosic", 17777);
        });
    }

    @Test
    void ctorExceptionTest2() {
        assertThrows(IllegalArgumentException.class, () -> { new Student("Yahya", "Aly", 0); });
    }

    @Test
    void setIme() {
        Student s = new Student("Yahya", "Aly", 17776);
        assertEquals("Yahya", s.getIme());
        s.setIme("Yaly");
        assertEquals("Yaly", s.getIme());
    }

    @Test
    void setPrezime() {
        Student s = new Student("Yahya", "Aly", 17775);
        assertEquals("Aly", s.getPrezime());
        s.setPrezime("Yaly");
        assertEquals("Yaly", s.getPrezime());
    }

    @Test
    void setBrIndeksa() {
        Student s = new Student("Yahya", "Aly", 17774);
        assertEquals(17774, s.getBrIndeksa());
        s.setBrIndeksa(16666);
        assertEquals(16666, s.getBrIndeksa());
    }

    @Test
    void brisi() {
        Student s = new Student("Yahya", "Aly", 17773);
        s.brisi();
        assertTrue(s.isObrisan());
    }

    @Test
    void brisi2() {
        Student s = new Student("Yahya", "Aly", 17772);
        //s.brisi();
        //assertThrows(IllegalArgumentException.class, () -> { s.brisi(); });
    }

    @Test
    void getIme() {
        Student s = new Student("Yahya", "Aly", 17771);
        s.brisi();
        s.setIme("Yaly");
        assertEquals("Yaly", s.getIme());
        s.brisi();
        assertThrows(IllegalArgumentException.class, () -> { s.getIme(); });
    }

    @Test
    void getPrezime() {
        Student s = new Student("Yahya", "Aly", 17770);
        s.brisi();
        s.setPrezime("Yaly");
        assertEquals("Yaly", s.getPrezime());
        s.brisi();
        assertThrows(IllegalArgumentException.class, () -> { s.getPrezime(); });
    }

    @Test
    void getBrIndeksa() {
        Student s = new Student("Yahya", "Aly", 17769);
        s.brisi();
        s.setBrIndeksa(16665);
        assertEquals(16665, s.getBrIndeksa());
        s.brisi();
        assertThrows(IllegalArgumentException.class, () -> { s.getBrIndeksa(); });
    }
}