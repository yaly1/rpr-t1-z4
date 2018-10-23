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
    void upisi() {
        Student s1 = new Student("Yahya", "Aly", 17777);
        Student s2 = new Student("Muhamed", "Sosic", 16666);
        Student s3 = new Student("Baho", "Bahic", 15555);
        Predmet p = new Predmet("RPR", 11111, 120);
        assertEquals(0, p.getBr());
        p.upisi(s1);
        p.upisi(s2);
        p.upisi(s3);
        assertEquals(3, p.getBr());
    }

    @Test
    void ispisi() {
        Student s1 = new Student("Yahya", "Aly", 17777);
        Student s2 = new Student("Muhamed", "Sosic", 16666);
        Student s3 = new Student("Baho", "Bahic", 15555);
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
}