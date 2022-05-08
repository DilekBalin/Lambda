package LambdaTutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class C02 {
    public static void main(String[] args) {
        List<String> menu = new ArrayList<>(Arrays.asList("kusleme", "adana", "trilece", "trilece", "trilece", "havucDilim", "buryan",
                "yaglama", "kokorec", "arabAsi", "guvec"));
        alfBuyukTekrarsiz(menu);
        System.out.println("\n   ***   ");
        karaktersayiTersSirala(menu);
        System.out.println("\n   ***   ");
        karakterSayisiKucuktenBuyuk(menu);
        System.out.println("\n   ***   ");
        sonHarfSirala(menu);
        System.out.println("\n   ***   ");
        karakterCiftOlanlarinkare(menu);
        System.out.println("\n   ***   ");
        yediVeYediednAz(menu);
        System.out.println("\n   ***   ");
        wIleBaslayan(menu);
        System.out.println("\n   ***   ");
        karaktreEnBuyuk(menu);
        System.out.println("\n   ***   ");

        kEnBuyuk(menu);



    }



    // Task : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    public static void alfBuyukTekrarsiz(List<String> menu){
        menu.stream().
                map(t-> t.toUpperCase()).sorted().distinct().forEach(t-> System.out.print(t + " "));
    }
    public static void sYazdir (String a) {
        System.out.print(a+" ");

    }

// Task : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz.
    public static void karaktersayiTersSirala (List<String> menu){
        menu.
                stream().map(String::length).
                sorted(Comparator.reverseOrder()).distinct().forEach(C01::yazdir);
    }
    // Task : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
    private static void karakterSayisiKucuktenBuyuk(List<String> menu) {
        menu.stream().sorted(Comparator.comparing(String::length)).forEach(C02::sYazdir);

    }

    // Task : list elemanlarinin son harfine gore ters sirali print ediniz.
    public static void sonHarfSirala(List<String> menu){
        menu.stream().sorted(Comparator.comparing(t-> t.toString().charAt(t.toString().length()-1)).reversed()).
                forEach(C02::sYazdir);

    }
    //Task: List'in elemanlarinin karakterlerinin cift sayili olanlarin karelerini hesaplayan ve bunlari tekrarsiz buyukten kucuge sirali print ediniz
    public static void karakterCiftOlanlarinkare (List<String> menu){
        menu.stream().map(t->  t.length()*t.length()).filter(C01::ciftYazdir).distinct().sorted(Comparator.reverseOrder()).forEach(C01::yazdir);

    }
    // Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
    public static void yediVeYediednAz(List<String> menu){
        System.out.println(menu.stream().anyMatch(t -> t.length() <= 7) ? "true" : "false");
    }
    // Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
    public static void wIleBaslayan(List<String> menu){
        System.out.println(menu.stream().anyMatch(t -> t.startsWith("w")) ? "true" : "false");
    }
    // Task : List elelmanlarinin "x" ile biten en az bir elemanini kontrol ediniz.
    public static void xIleBten(List<String> menu){
        System.out.println(menu.stream().anyMatch(t -> t.endsWith("x")) ? "true" : "false");
    }

    // Task : Karakter sayisi en buyuk elemani yazdiriniz.

    public static void karaktreEnBuyuk(List<String> menu){
        System.out.println(menu.stream().sorted(Comparator.comparing(t -> t.toString().length()).reversed()).findFirst());
    }
    //Task: List elemanlarini son harfine gore siralayip ilk eleman haric kalan elemanlari print ediniz
    public static void kEnBuyuk(List<String> menu){
        menu.stream().sorted(Comparator.comparing(t -> t.toString().charAt(t.toString().length()-1))).skip(1).forEach(C02::sYazdir);

    }


}