package ba.unsa.etf.rpr.tut1;

public class Student {

    boolean obrisan;
    private String ime, prezime;
    private int brIndeksa;
    private static int brStudenata = 0;
    private static int [] brojeviIndeksa = new int[1000];

    public Student(String ime, String prezime, int brIndeksa) {
        if(brIndeksa <= 0)throw new IllegalArgumentException("Broj indeksa mora biti veci od nule");
        //if(brStudenata > 0)
        for(int i = 0; i < brStudenata; i++)
            if(brojeviIndeksa[i] == brIndeksa) throw new IllegalArgumentException("Broj indeksa je vec koristen");
        if(brojeviIndeksa.length == brStudenata) povecaj();
        this.ime = ime;
        this.prezime = prezime;
        this.brIndeksa = brIndeksa;
        obrisan = false;
        brojeviIndeksa[brStudenata] = brIndeksa;
        brStudenata++;
    }

    private void povecaj() {
        int [] pom = new int[brStudenata*2];
        for(int i = 0; i < brStudenata; i++)
            pom[i] = brojeviIndeksa[i];
        brojeviIndeksa = pom;
    }

    public void setIme(String ime) { this.ime = ime;
    if(obrisan) obrisan = false;
    }

    public void setPrezime(String prezime) { this.prezime = prezime;
    if(obrisan) obrisan = false;
    }

    public void setBrIndeksa(int brIndeksa) {
        this.brIndeksa = brIndeksa;
        if(obrisan) obrisan = false;
    }

    public String getIme() {
        if(obrisan)throw new IllegalArgumentException("Student je obrisan");
        return ime;
    }

    public String getPrezime() {
        if(obrisan)throw new IllegalArgumentException("Student je obrisan");
        return prezime;
    }

    public int getBrIndeksa() {
        if(obrisan)throw new IllegalArgumentException("Student je obrisan");
        return brIndeksa;
    }

    public void brisi() {
        if(obrisan)throw new IllegalArgumentException("Student vec obrisan");
        ime = "";
        prezime = "";
        brIndeksa = 0;
        obrisan = true;
        for(int i = 0; i < brStudenata; i++)
            if(brojeviIndeksa[i] == this.brIndeksa) {
                for(int j = i; j<brStudenata; j++)
                    brojeviIndeksa[j] = brojeviIndeksa[j+1];
                brStudenata--;
                return;
            }
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
