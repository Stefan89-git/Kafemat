package rs.itcentar;

public class Novcanica {
    private String naziv;
    private int apoeni;

    public Novcanica(String naziv, int apoeni) {
        this.naziv = naziv;
        this.apoeni = apoeni;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getApoeni() {
        return apoeni;
    }

    public void setApoeni(int apoeni) {
        this.apoeni = apoeni;
    }

    @Override
    public String toString() {
        return "Novcanica{" + "naziv=" + naziv + ", apoeni=" + apoeni + '}';
    }
}
