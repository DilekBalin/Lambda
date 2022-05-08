package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Q01 {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(-5, -8, -2, -12, 0, 1, 12, 5, 6, 9, 15, 8));

        pozitif(list);
        System.out.println("\n   ***   ");
        kareleri(list);
        System.out.println("\n   ***   ");
        kareleriTekrarsiz(list);
        System.out.println("\n   ***   ");
        kucuktenBuyuge(list);
        System.out.println("\n   ***   ");
        buyuktenKucuge(list);
        System.out.println("\n   ***   ");
        kupBes(list);
        System.out.println("\n   ***   ");
        pozitifKareBes(list);
        System.out.println("\n   ***   ");
        elTopla(list);
        System.out.println("\n   ***   ");
        negatifKare(list);
        System.out.println("\n   ***   ");
        bestenBuyukVarMi(list);
        System.out.println("\n   ***   ");
        yuzeEsitmi(list);
        System.out.println("\n   ***   ");
        sifiraEsitmi(list);
        System.out.println("\n   ***   ");
        ilkBesElemanTopla(list);
        System.out.println("\n   ***   ");
        sonBesElemanTopla(list);
        System.out.println("\n   ***   ");


    }


    // S1:listi aralarinda bosluk birakarak yazdiriniz //


    //S2: sadece negatif olanlari yazdir


    //S3: pozitif olanlardan yeni bir liste olustur
    public static void yazdir(int b) {// verilen int degeri aynı satırda bosluk bırakarak yazdırma action yapan seed(tohum) method create edildi
        System.out.print(b + " ");
    }


    public static void pozitif(List<Integer> list) {
        list.stream().filter(t -> t > 0).collect(Collectors.toList()).forEach(Q01::yazdir);

    }

    // S4: list in elemanlarin karelerinden yeni bir list olusturalim
    public static void kareleri(List<Integer> list) {
        list.stream().map(t -> t * t).forEach(Q01::yazdir);
    }

    //S5 : list in elemanlarin karelerinden tekrarsiz yeni bir list olusturalim
    public static void kareleriTekrarsiz(List<Integer> list) {
        list.stream().map(t -> t * t).distinct().forEach(Q01::yazdir);
    }

    //S6: listin elemanlarini kucukten buyuge siralayalim
    public static void kucuktenBuyuge(List<Integer> list) {
        list.stream().sorted().forEach(Q01::yazdir);
    }


    //S7: listin elemanlarini buyukten kucuge siralayalim
    public static void buyuktenKucuge(List<Integer> list) {
        list.stream().sorted(Comparator.reverseOrder()).forEach(Q01::yazdir);
    }

    // S8: list pozitif elemanlari icn kuplerini bulup birler basamagi 5 olanlardan yeni bir list olusturalim

    public static void kupBes(List<Integer> list) {
        list.stream().map(t -> t * t * t).filter(t -> t % 10 == 5).forEach(Q01::yazdir);
    }

    //S9: list pozitif elemanlari icn karelerini bulup birler basamagi 5 olmayanlardan yeni bir list olusturalim
    public static void pozitifKareBes(List<Integer> list) {
        list.stream().filter(t -> t > 0).map(t -> t * t).filter(t -> t % 10 != 5).forEach(Q01::yazdir);
    }

    // S10 :list elemanlarini toplamini bulalim

    public static void elTopla(List<Integer> list) {
        System.out.print(list.stream().reduce(0, (t, u) -> t + u));
    }

    // S11 : peek ornegi cozelim - negatiflerin karelerinden list olusturalim
    public static void negatifKare(List<Integer> list) {
        list.stream().filter(t -> t < 0).peek(e -> System.out.println("Filtered value: " + e))
                .map(t -> t * t)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
    }


    // S12 : listeden 5 den buyuk  sayi var mi?
    public static void bestenBuyukVarMi(List<Integer> list) {
        System.out.println(list.stream().anyMatch(t -> t > 5));
    }

    // S13 : listenin tum elemanlari sifirdan kucuk mu?
    public static void tumElemanlarSifirdanKucukMu(List<Integer> list) {
        System.out.println(list.stream().allMatch(t -> t < 0));
    }

    // S14: listenin 100 e esit elemani yok mu ?

    public static void yuzeEsitmi(List<Integer> list) {
        System.out.println(list.stream().noneMatch(t -> t == 100));
    }

    // S15: listenin sifira esit elemani yok mu?
    public static void sifiraEsitmi(List<Integer> list) {
        System.out.println(list.stream().noneMatch(t -> t == 0));
    }

    // S16:  listenin ilk 5 elemanini topla?
    public static void ilkBesElemanTopla(List<Integer> list) {
        System.out.println(list.stream().limit(5).reduce(Integer::sum).orElseThrow());

    }


    //S17: listenin son bes elemaninin  listele
    public static void sonBesElemanTopla(List<Integer> list) {
        list.stream().skip(list.size() - 5).forEach(Q01::yazdir);

    }


}