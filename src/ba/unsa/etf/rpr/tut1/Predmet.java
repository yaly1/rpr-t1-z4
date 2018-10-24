package ba.unsa.etf.rpr.tut1;

public class Predmet {

    private Student [] niz = null;
    private String naziv;
    private int sifra, maks, br;
    boolean obrisan;

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public int getSifra() {
        return sifra;
    }

    public int getMaks() {
        return maks;
    }

    public Predmet(String naziv, int sifra, int maks) {
        this.naziv = naziv;
        this.sifra = sifra;
        this.maks = maks;
        niz = new Student[maks];
        br = 0;
        obrisan = false;
    }

    public void brisi() {
        if(obrisan) throw new IllegalArgumentException("Predmet je obrisan");
        naziv = "";
        sifra = 0;
        maks = 0;
        niz = null;
        br = 0;
        obrisan = true;
    }

    public void upisi(Student s) {
        if(maks == br) throw new IndexOutOfBoundsException("Predmet je popunjen");
        if(s.obrisan) throw new IllegalArgumentException("Student je obrisan");
        for(int i = 0; i < br; i++) if(niz[i].getBrIndeksa() == s.getBrIndeksa()) throw new IllegalArgumentException("Student vec postoji");
        if(br < maks)
            niz[br++] = s;
    }

    public void ispisi(Student s) {
        if(br == 0) throw new IllegalArgumentException("Student nije ni upisan");
        for(int i = 0; i < br; i++)
            if(niz[i].getBrIndeksa() == s.getBrIndeksa()) {
                for(int j = i; j<br; j++)
                    niz[j] = niz[j+1];
                br--;
                return;
            }
        throw new IllegalArgumentException("Student nije ni upisan");
    }

    @Override
    public String toString() {
        String rez = "";
        for(int i = 0; i < br; i++)
            if(!niz[i].obrisan)
                rez += (i + 1) + ". " + niz[i].getPrezime() + " " + niz[i].getIme() + " (" + niz[i].getBrIndeksa() + ")\n";
            else this.ispisi(niz[i--]);
        return rez;
    }

    public Student[] getNiz() {
        return niz;
    }

    public int getBr() {
        return br;
    }
}
