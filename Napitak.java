package rs.itcentar;

public class Napitak {
    private String ime;
    private int cena;

    public Napitak(String ime, int cena) {
        this.ime = ime;
        this.cena = cena;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "Napitak{" + "ime=" + ime + ", cena=" + cena + '}';
    }
}
