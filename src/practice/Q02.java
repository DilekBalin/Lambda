package practice;

import java.util.stream.IntStream;

public class Q02 {
    public static void main(String[] args) {
        birdenOtuzaSayilar(30);
        System.out.println("\n   ***   ");
        birdenOtuzaSayilarotuzDahil(30);
        System.out.println("\n   ***   ");
        istenenIkiDegerArasi(3, 6);
        System.out.println("\n   ***   ");
        ort(30, 40);
        System.out.println("\n   ***   ");
        sekizeBolunen(325,468);
        System.out.println("\n   ***   ");
        sekizeBolunenYazdir(325,468);
        System.out.println("\n   ***   ");
        System.out.println(sekizeBolunenTopla(325, 468));
        System.out.println("\n   ***   ");
        System.out.println(tekSayiCarpim(7, 15));
        System.out.println("\n   ***   ");
        ilkOnElemaniYazdir(0,20);
        System.out.println("\n   ***   ");
        yedininKatlariniYazdir(21);
        System.out.println("\n   ***   ");
        System.out.println(yedininKatlariniYirmiYazdir(21));


    }

    public static void yazdir(int x) {
        System.out.print(x + " ");
    }

    // S1:1 den 30 kadar olan sayilari (30 dahil degil) 1 2 3 .... seklinde siralayalim (for loopsuz)
    //range(int startInclusive, int endExclusive)
    public static void birdenOtuzaSayilar(int x) {
        IntStream.
                range(1, 30).
                sorted().
                forEach(Q02::yazdir);
    }

    //S2 1 den 30 kadar olan sayilari (30 dahil ) 1 2 3 .... seklinde siralayalim (for loopsuz)
    //rangeClosed(int startInclusive, int endInclusive)
    public static void birdenOtuzaSayilarotuzDahil(int x) {
        IntStream.
                rangeClosed(1, 30).
                sorted().
                forEach(Q02::yazdir);
    }

    //S3 Istenen iki deger(dahi) arasindaki sayilari toplayalim
    public static void istenenIkiDegerArasi(int x, int istenenDeger) {
        System.out.println(IntStream.
                rangeClosed(x, istenenDeger).
                reduce(0, (a, b) -> a + b));

    }

    //S4: 30 ile 40 arasindaki sayilarin (dahi) ortalamasini bulalim
    public static void ort(int x, int istenenDeger) {
        System.out.println(IntStream.
                rangeClosed(x, istenenDeger).
                average().orElseThrow());
    }
        //S5: 325 ile 468 arasinda 8 e bolunen kac sayi vardir?
        public static void sekizeBolunen(int x, int istenenDeger) {
            System.out.print(IntStream.
                    rangeClosed(x, istenenDeger).
                    filter(t -> t % 8 == 0).count());
        }
        //S6: 325 ile 468 arasinda 8 bolunen sayilari yazdiralim
        public static void sekizeBolunenYazdir(int x, int istenenDeger) {
          IntStream.
                   rangeClosed(x, istenenDeger).
                   filter(t -> t % 8 == 0).forEach(Q02::yazdir);
        }

        // S7:325 ile 468 arasinda 8 bolunen sayilarin toplamini bulalim
        public static int sekizeBolunenTopla(int x, int istenenDeger) {
         return   IntStream.
                    rangeClosed(x, istenenDeger).
                    filter(t -> t % 8 == 0).sum();
        }

        // S8: 7ile 15 arasindaki tek sayilarin carpimini bulalim
        public static int tekSayiCarpim(int x, int istenenDeger) {

        return IntStream.range(x+1, istenenDeger).filter(t-> t%2!=0).reduce(Math::multiplyExact).orElseThrow();

        }

        //S9: pozitif tek sayilarin ilk 10 elemanin yazdiralim
        public static void ilkOnElemaniYazdir(int x, int istenenDeger) {
 IntStream.range(x,istenenDeger).filter(t-> t%2!=0).limit(20).forEach(Q02::yazdir);
        }

        //S10: 21 den baslayan 7 nin katlarinin tek olanlari ilk 10 teriminin yaziralim
        public static void yedininKatlariniYazdir(int x) {
            IntStream.iterate(21, a -> a+7).filter(t-> t%7==0 && t%2!=0).limit(10).forEach(Q02::yazdir);
        }

        //S11: 21 den baslayan 7 nin katlarinin ilk 20 teriminin toplayalim
        public static int yedininKatlariniYirmiYazdir(int x) {
           return IntStream.iterate(21, a -> a+7).filter(t-> t%7==0).limit(20).sum();
        }
    }
