package ba.unsa.etf.rpr;

public class Program {

    public static void main(String[] args) {
        Predmet p = new Predmet("", 12345, 500);
        Student s = new Student();

        s.upisi(p);
        s.ispisi(p);
        s.Brisi();
        p.Brisi();
        Student.IspisiSpisak();

        //treba niz predmeta
    }
}
