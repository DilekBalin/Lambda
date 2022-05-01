import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class grupWork {
    public static void main(String[] args) {


        List<String> menu = new ArrayList<>(Arrays.asList("kusleme", "adana", "trilece", "trilece", "trilece", "havucDilim", "buryan",
                "yaglama", "kokorec", "arabAsi", "guvec"));
        alfabetikBuyukHarf(menu);
        System.out.println("\n   ***   ");
        karakterTersSirali(menu);
        System.out.println("\n   ***   ");
        karakterKckByk(menu);
        System.out.println("\n   ***   ");
        sonHarfeGoreTersSirala(menu);
        System.out.println("\n   ***   ");



    }
// Task : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    public static void alfabetikBuyukHarf( List<String> menu ){
        menu.stream().map(t-> t.toUpperCase()).sorted().distinct().forEach(t-> System.out.print(t+ " "));//ADANA ARABASİ BURYAN GUVEC HAVUCDİLİM KOKOREC KUSLEME TRİLECE YAGLAMA
        menu.stream().map(String::toUpperCase).sorted().distinct().forEach(t-> System.out.print(t+ " "));

    }


// Task : list elemanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void karakterTersSirali( List<String> menu ){
        menu.stream().map(String::length).sorted(Comparator.reverseOrder()).distinct().forEach(Lambda01::yazdir);//10 7 6 5
    }
// Task : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
    public static void karakterKckByk(List<String> menu ){
        menu.stream().sorted(Comparator.comparing(String::length)).forEach(t-> System.out.print(t+ " "));
    }

// Task : list elemanlarinin son harfine gore ters sirali print ediniz.
    public static void sonHarfeGoreTersSirala(List<String> menu ){
        menu.
                stream().
                sorted(Comparator.comparing(t-> t.toString().charAt(t.toString().length()-1)).reversed()).
                        forEach(t-> System.out.print(t+ " "));
    }
// Task : listin elemanlarin karakterlerinin cift sayili olanlarin karelerini hesaplayan,ve karelerini tekrarsiz buyukten kucuge sirali  print ediniz...
    public static void ciftolanKareTekrarsizBykKcg (List<String> menu){
        menu.stream().map(t-> t.length()*t.length()).filter(Lambda01::ciftBul);
    }


}
