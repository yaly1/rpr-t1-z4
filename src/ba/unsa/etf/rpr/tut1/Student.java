package ba.unsa.etf.rpr.tut1;

public class Student {

    boolean obrisan;
    private String ime, prezime;
    private int brIndeksa;

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setBrIndeksa(int brIndeksa) {
        this.brIndeksa = brIndeksa;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public int getBrIndeksa() {
        return brIndeksa;
    }

    public Student(String ime, String prezime, int brIndeksa) {
        this.ime = ime;
        this.prezime = prezime;
        this.brIndeksa = brIndeksa;
        obrisan = false;
    }

    public void brisi() {
        ime = "";
        prezime = "";
        brIndeksa = 0;
        obrisan = true;
    }

    @Override
    public String toString() {
        return prezime +
                " "  + ime +
                " (" + brIndeksa + ')';
    }

    public boolean isObrisan() {
        return obrisan;
    }
}
