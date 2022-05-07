package LambdaTutorial;

import java.util.*;

public class C01 {
    public static void main(String[] args) {

        //Task : "Structured Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.
        List<Integer> sayi = new ArrayList<>(Arrays.asList(2, 3, 13, -5, 4, 7, -6, 1, 10, 5));
        listElemanlariniYazdir(sayi);
        System.out.println("**********");
        ciftElemanlariYazdir(sayi);
        System.out.println("**********");
        tekelemanyazdir(sayi);
        System.out.println("**********");
        otuzDortKucukCift(sayi);
        System.out.println("**********");
        otuzDortKucukVeyaCift(sayi);
        System.out.println("**********");
        tekKupBirFazla(sayi);
        System.out.println("**********");
        ciftKare(sayi);
        System.out.println("**********");
        ciftElKarekok(sayi);
        System.out.println("**********");
        enBuyuk(sayi);
        System.out.println("**********");
        ciftKareEnBuyuk(sayi);
        System.out.println("**********");
        enKucuk(sayi);
        tumElemanToplam(sayi);
        enKucukFarkliYontem(sayi);
        bestenBuyukEnKucuk(sayi);
        tekElKareKB(sayi);


    }

    public static void ciftKare(List<Integer> sayi) {
        sayi.stream().filter(C01::ciftYazdir).map(t -> t * t).forEach(C01::yazdir);
    }

    public static void listElemanlariniYazdir(List<Integer> sayi) {
        sayi.
                stream().
                //forEach(t -> System.out.print(t + " "));
                        forEach(C01::yazdir);
    }

    public static void yazdir(int sayi) {
        System.out.print(sayi + " ");
    }

    // Task : structured Programming ile list elemanlarinin  cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void ciftElemanlariYazdir(List<Integer> sayi) {
        sayi.
                stream().
                // filter(t -> t % 2 == 0).
                        filter(C01::ciftYazdir).
                forEach(C01::yazdir);
    }

    public static boolean ciftYazdir(int a) {
        return a % 2 == 0;
    }

    public static boolean tekYazdir(int b) {
        return b % 2 != 0;
    }

    public static void tekelemanyazdir(List<Integer> sayi) {
        sayi.stream().
                // filter(t -> t % 2 != 0).
                        filter(C01::tekYazdir).
                forEach(C01::yazdir);
    }

    //Task : functional Programming ile list elemanlarinin 34 den kucuk cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void otuzDortKucukCift(List<Integer> sayi) {
        sayi.stream().filter(t -> t < 34).filter(C01::ciftYazdir).forEach(C01::yazdir);
        sayi.stream().filter(t -> t < 34 && t % 2 == 0).forEach(t -> System.out.print(t + " "));
    }
    //Task : functional Programming ile list elemanlarinin 34 den buyk veya cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void otuzDortKucukVeyaCift(List<Integer> sayi) {
        sayi.stream().filter(t -> t < 34).filter(C01::ciftYazdir).forEach(C01::yazdir);
        sayi.stream().filter(t -> t < 34 || t % 2 == 0).forEach(t -> System.out.print(t + " "));
    }

    // Task : Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print edi
    public static void tekKupBirFazla(List<Integer> sayi) {
        sayi.stream().filter(C01::tekYazdir).map(t -> (t * t * t) + 1).forEach(C01::yazdir);
    }

    // Task : Functional Programming ile listin cift elemanlarinin   karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz

    public static void ciftElKarekok(List<Integer> sayi) {
        sayi.stream().filter(C01::ciftYazdir).map(Math::sqrt).forEach(t -> System.out.print(t + " "));
    }
    // Task : list'in en buyuk elemanini yazdiriniz

    public static void enBuyuk(List<Integer> sayi) {
        System.out.println(sayi.stream().reduce(Math::max));
    }

    // Task : list'in en kucuk elemanini yazdiriniz
    public static void enKucuk(List<Integer> sayi) {
        System.out.println(sayi.stream().reduce(Math::min));
    }

    // Task : List'in cift elemanlarin karelerinin en buyugunu print ediniz
    public static void ciftKareEnBuyuk(List<Integer> sayi) {
        System.out.println(sayi.stream().filter(C01::ciftYazdir).map(Math::sqrt).reduce(Math::max));
    }


    // Task : List'teki tum elemanlarin toplamini yazdiriniz.
    public static void tumElemanToplam(List<Integer> sayi) {
        System.out.println(sayi.stream().reduce(0, (t, u) -> t + u));
    }

    // Task : List'teki cift elemanlarin carpimini  yazdiriniz.
    public static void ciftElemanCarpim(List<Integer> sayi) {
        System.out.println(sayi.stream().filter(C01::ciftYazdir).reduce(0, (t, u) -> t * u));
    }

    // Task : List'teki elemanlardan en kucugunu 4 farklı yontem ile print ediniz.
    public static void enKucukFarkliYontem(List<Integer> sayi) {
        System.out.println(sayi.stream().reduce(Math::min));
        System.out.println(sayi.stream().reduce(Integer::min));
        Integer min = sayi.stream().reduce(Math::min).orElseThrow();
        System.out.println(min);
        Optional<Integer> min2 = sayi.stream().reduce(Math::min);
        System.out.println(min2);
        Integer min3 = sayi.stream().reduce(Integer.MAX_VALUE, (t, u) -> t < u ? t : u);
        System.out.println(min3);


    }

    // Task : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.
    public static void bestenBuyukEnKucuk(List<Integer> sayi) {
        System.out.println(sayi.stream().filter(C01::tekYazdir).filter(t -> t > 5).reduce(Math::min));
        System.out.println(sayi.stream().filter(C01::tekYazdir).filter(t -> t > 5).reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y));

    }

    // Task : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.
    public static void ciftElKareKB(List<Integer> sayi) {
        sayi.stream().filter(C01::ciftYazdir).map(t -> t * t).sorted().forEach(C01::yazdir);
    }

    // Task : list'in tek  elemanlarinin kareleri ni buykten kucuge  print ediniz.
    public static void tekElKareKB(List<Integer> sayi) {
        sayi.stream().filter(C01::tekYazdir).map(t -> t * t).sorted(Comparator.reverseOrder()).forEach(C01::yazdir);
    }
}