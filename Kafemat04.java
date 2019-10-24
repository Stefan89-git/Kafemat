package rs.itcentar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Kafemat04 {
    
    private static List<Napitak> napici = Arrays.asList(
        new Napitak("Turska kafa", 50), new Napitak("Kapucino", 120),
        new Napitak("Nes", 100), new Napitak("Makijato", 200)
    );
    
    private static List<Novcanica> validne_novcanice = Arrays.asList(
        new Novcanica("", 10), new Novcanica("", 20), new Novcanica("", 50),
        new Novcanica("sto dinara", 100), new Novcanica("", 200), new Novcanica("", 500),
        new Novcanica("", 1000), new Novcanica("", 2000), new Novcanica("", 5000)
    );
    
    public static void main(String[] args) {
        // unesemo novcanicu
        System.out.print("Unesite novcanicu: ");
        Scanner input = new Scanner(System.in);
        int novcanica = input.nextInt();
        
        try {
            if(proveriValidnostNovcanice(novcanica)) {
                // prikazujemo listu napitaka koje moze da kupi za taj novac
                stampajListNapitakaZaNovac(novcanica);
                // unosenjem rednog broja napitka vrsi se odabir
                int redniBroj = input.nextInt();
                racunajStampajKusur(redniBroj, novcanica);
            }
        } catch (MoneyBillNotValidException ex){// ako nije validna onda ispisemo na ekranu da novcanica nija validna
            System.err.println(ex.getMessage());
        } catch (NoDrinksForMoneyExcpetion ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public static boolean proveriValidnostNovcanice(int novcanica) throws MoneyBillNotValidException {
        // proverimo da li je validna
        // nije validna ako nije upalo nijednom u if
        // ako jeste onda
        for(Novcanica n : validne_novcanice) {
            if(novcanica == n.getApoeni()) {
                // validna
                System.out.println("Uneli ste " + n.getApoeni() + " din " + n.getNaziv());
                return true;
            }
        }
        throw new MoneyBillNotValidException(new Novcanica("unknown", novcanica),
                String.format("Novcanica vrednosti %d ne postoji", novcanica));
    }
    
    public static void stampajListNapitakaZaNovac(int novcanica) throws NoDrinksForMoneyExcpetion {
        int count = 0;
        for(int i=0;i<napici.size();i++) {
            Napitak n = napici.get(i);
            if(n != null) {
                String imeNapitka = n.getIme();
                int cenaNapitka = n.getCena();
                if(cenaNapitka <= novcanica) {
                    System.out.println(i + ".- " + imeNapitka + " - " + cenaNapitka + " din");
                    ++count;
                }
            }
        }
        if(count <= 0) {
            throw new NoDrinksForMoneyExcpetion(String.format("Nema napitaka za uneti novac od %d", novcanica));
        }
    }
    
    public static void racunajStampajKusur(int redniBroj, int novcanica){
        // a zatim se obavlja kupovina time sto se racuna kusur
        Napitak n = napici.get(redniBroj);
        if(n != null) {
            String imeKupljenNapitak = n.getIme();
            int cenaKupljenogNapitak = n.getCena();
            int kusur = novcanica - cenaKupljenogNapitak;
            System.out.println("Uspesno ste kupili: " + imeKupljenNapitak
                    + " po ceni od " + cenaKupljenogNapitak + " din");
            // i ako ga ima stampa na ekranu
            if(kusur > 0) {
                System.out.println("Vas kusur je: " + kusur + " din");
            }
        }
    }
}
