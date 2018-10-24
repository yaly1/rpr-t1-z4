package ba.unsa.etf.rpr.tut1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PredmetTest {

    @Test
    void setNaziv() {
        Predmet p = new Predmet("RPR", 11111, 120);
        assertEquals("RPR", p.getNaziv());
        p.setNaziv("RRP");
        assertEquals("RRP", p.getNaziv());
    }

    @Test
    void setSifra() {
        Predmet p = new Predmet("RPR", 11111, 120);
        assertEquals(11111, p.getSifra());
        p.setSifra(11222);
        assertEquals(11222, p.getSifra());
    }

    @Test
    void getSifra() {
        Predmet p = new Predmet("RPR", 11111, 120);
        p.setNaziv("RRP");
        p.setSifra(11222);
        assertAll("seteri",
                () -> assertEquals("RRP", p.getNaziv()),
                () -> assertEquals(11222, p.getSifra())
        );
    }

    @Test
    void getMaks() {
        Predmet p = new Predmet("RPR", 11111, 120);
        assertEquals(120, p.getMaks());
    }

    @Test
    void brisi() {
        Predmet p = new Predmet("RPR", 11111, 120);
        p.brisi();
        assertAll("brisanje",
                () -> assertEquals("", p.getNaziv()),
                () -> assertEquals(0, p.getSifra()),
                () -> assertEquals(0, p.getMaks()),
                () -> assertNull(p.getNiz()),
                () -> assertEquals(0, p.getBr())
        );
    }

    @Test
    void brisi2() {
        Predmet p = new Predmet("RPR", 11111, 120);
        p.brisi();
        assertThrows(IllegalArgumentException.class, () -> { p.brisi(); });
    }

    @Test
    void upisi() {
        Student s1 = new Student("Yahya", "Aly", 17768);
        Student s2 = new Student("Muhamed", "Sosic", 16664);
        Student s3 = new Student("Baho", "Bahic", 15555);
        Predmet p = new Predmet("RPR", 11111, 120);
        assertEquals(0, p.getBr());
        p.upisi(s1);
        p.upisi(s2);
        p.upisi(s3);
        assertEquals(3, p.getBr());
    }

    @Test
    void upisi2() {
        Student s1 = new Student("Yahya", "Aly", 17767);
        Predmet p = new Predmet("RPR", 11111, 120);
        p.upisi(s1);
        assertThrows(IllegalArgumentException.class, () -> { p.upisi(s1); });
    }

    @Test
    void upisi3() {
        Student s1 = new Student("Yahya", "Aly", 17766);
        Student s2 = new Student("Muhamed", "Sosic", 16663);
        Student s3 = new Student("Baho", "Bahic", 15554);
        Predmet p = new Predmet("RPR", 11111, 2);
        p.upisi(s1);
        p.upisi(s2);
        assertThrows(IndexOutOfBoundsException.class, () -> { p.upisi(s3); });
    }

    @Test
    void upisi4() {
        Student s1 = new Student("Yahya", "Aly", 17667);
        Predmet p = new Predmet("RPR", 11111, 120);
        s1.brisi();
        assertThrows(IllegalArgumentException.class, () -> { p.upisi(s1); });
    }

    @Test
    void ispisi() {
        Student s1 = new Student("Yahya", "Aly", 17765);
        Student s2 = new Student("Muhamed", "Sosic", 16662);
        Student s3 = new Student("Baho", "Bahic", 15553);
        Predmet p = new Predmet("RPR", 11111, 120);
        assertEquals(0, p.getBr());
        p.upisi(s1);
        p.upisi(s2);
        p.upisi(s3);
        assertEquals(3, p.getBr());
        p.ispisi(s2);
        assertEquals(2, p.getBr());
        p.ispisi(s1);
        assertEquals(1, p.getBr());
        p.ispisi(s3);
        assertEquals(0, p.getBr());
    }

    @Test
    void ispisi2() {
        Student s1 = new Student("Yahya", "Aly", 17764);
        Student s2 = new Student("Muhamed", "Sosic", 16661);
        Student s3 = new Student("Baho", "Bahic", 15552);
        Predmet p = new Predmet("RPR", 11111, 120);
        p.upisi(s1);
        p.upisi(s3);
        p.ispisi(s3);
        assertThrows(IllegalArgumentException.class, () -> { p.ispisi(s2); });
    }

    @Test
    void ispisi3() {
        Student s1 = new Student("Yahya", "Aly", 17264);
        Student s2 = new Student("Muhamed", "Sosic", 16261);
        Student s3 = new Student("Baho", "Bahic", 15252);
        Predmet p = new Predmet("RPR", 11111, 120);
        p.upisi(s1);
        p.upisi(s3);
        p.ispisi(s1);
        p.ispisi(s3);
        assertThrows(IllegalArgumentException.class, () -> { p.ispisi(s2); });
    }
}