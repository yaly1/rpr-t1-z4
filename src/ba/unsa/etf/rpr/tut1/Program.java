package ba.unsa.etf.rpr.tut1;

public class Program {

    public static void main(String[] args) {
        System.out.println();

        Student s1 = new Student("Yahya", "Aly", 17777);
        Student s2 = new Student("Muhamed", "Sosic", 16666);
        Student s3 = new Student("Baho", "Bahic", 15555);
        Student s4 = new Student("Faca", "Facic", 14444);
        Student s5 = new Student("Maca", "Macic", 13333);

        Predmet [] niz = new Predmet[3];
        Predmet p3 = new Predmet("US", 33333, 150);
        niz[0] = new Predmet("RPR", 11111, 100);
        niz[1] = new Predmet("ASP", 22222, 200);
        niz[2] = p3;

        niz[0].upisi(s1);
        niz[0].upisi(s2);
        niz[0].upisi(s3);

        niz[1].upisi(s5);
        niz[1].upisi(s4);
        niz[1].upisi(s3);

        niz[2].upisi(s1);
        niz[2].upisi(s3);
        niz[2].upisi(s5);

        System.out.println(niz[0]);
        s3.brisi();
        niz[1].brisi();
        System.out.println(niz[1]);
        System.out.println(niz[2]);
        niz[2].ispisi(s1);
        p3.brisi();
        System.out.println(niz[2]);

    }
}
