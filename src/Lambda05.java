import java.util.stream.IntStream;

public class Lambda05 {


    public static void main(String[] args) {

        System.out.println("TASK 01 amele topla-->" + toplaAmele(10));      //55
        System.out.println("TASK 01 cincix topla-->" + cincixTopla(10));    //55
        System.out.println("   ***   ");
        System.out.println("TASK 02 -->" + xEKadarCiftTopla(10));  //30
        System.out.println("   ***   ");
        System.out.println("TASK 03 -->" + ilkXEKadarCiftTopla(10));  //110
        System.out.println("   ***   ");
        System.out.println("TASK 04 -->" + ilkXEKadarTekTopla(10));//100
        System.out.println("   ***   ");
        System.out.println("TASK 05 -->");
        ikininIlkXkuvveti(6);//2 4 8 16 32 64   //return olmadigi icin sout icine almadik
        System.out.println("   ***   ");
        System.out.println("TASK 06 -->");
        istenenSayininIlkXkuvveti(4, 4);//4 16 64 256
        System.out.println("   ***   ");
        istenenSayininIlkXkuvveti(2, 6);//2 4 8 16 32 64
        System.out.println("   ***   ");
        istenenSayininIlkXkuvveti(5, 3);//5 25 125
        System.out.println("   ***   ");
        System.out.println("TASK 07 -->"+istenenBirSayininFaktoriyeli(5)); //120= 1*2*3*4*5
        System.out.println("   ***   ");
        System.out.println("TASK 08 -->"+istenenBirSayininXinciKuvveti(2,4));//16
        System.out.println("   ***   ");
    }

    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar tamsayilari toplayan bir program create ediniz.
    //Structured(AMELE) Programming
    public static int toplaAmele(int x) {
        int toplam = 0;
        for (int i = 1; i <= x; i++) {
            toplam += i;
        }
        return toplam;
    }

    //Functional(cincix) Programming
    public static int cincixTopla(int x) {
        return IntStream.//Integer classindan bir akis olusturur
                range(1, x + 1).//aralik demek ilki dahil,ikincisi haric
                sum();//buldugun degerleri topla
        //return ettik
    }

    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
    public static int xEKadarCiftTopla(int x) {
        return IntStream.
                rangeClosed(1, x).//baslangic da bitis de dahil
                        filter(t -> t % 2 == 0).//ciftleri filtreledi
                        sum();

    }


    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.

    public static int ilkXEKadarCiftTopla(int x) {
        return IntStream.
                iterate(2, t -> t + 2). //2'den sonsuza kadar elemanlari 2 artirarak akisa alir
                        limit(x).//akistaki ilk x degerlerini alir
                        sum();
    }
    //iterate(seed, repeat action) --> seed'den(bir baslangic noktasi atanir) başlayarak repeat action'a göre (istenen isleme gore) sonsuza kadar elemanları akısa koy

    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.
    public static int ilkXEKadarTekTopla(int x) {
        return IntStream.
                iterate(1, t -> t + 2). //1'den sonsuza kadar elemanlari 2 artirarak akisa alir
                        limit(x).//akistaki ilk x degerlerini alir
                        sum();
    }

    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void ikininIlkXkuvveti(int x) {
        IntStream.
                iterate(2, t -> t * 2). //2 den sonsuza kadar elemanlari 2 ile carparak akisa alir
                limit(x).
                forEach(Lambda01::yazdir); //eger bir deger verseydi return olurdu ama biz yazdirmak istedik
    }
    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.

    public static void istenenSayininIlkXkuvveti(int istenenSayi, int x) {
        IntStream.
                iterate(istenenSayi, t -> t * istenenSayi).
                limit(x).
                forEach(Lambda01::yazdir);

        //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.
    }

    public static int istenenBirSayininFaktoriyeli(int x) {
      return IntStream.//int class'taki sayilari  akisa al
              rangeClosed(1, x).//1 den basla x'e kadar ikisi de dahil
              // reduce(Math::multiplyExact).
                      reduce(1, (t, u) -> t * u); //baslangic noktasi 1 olsun ve akistaki iki sayiyi caro,t ilk deegrden alir ,u akistan alir
        //return et

    }
    //TASK 08 --> Istenilen bir sayinin  x. kuvvetini ekrana yazdiran programi  create ediniz.
    public static int istenenBirSayininXinciKuvveti(int istenenSayi, int x) {
      //  return Math.pow(istenenSayi,x);
        return IntStream.
                iterate(istenenSayi,t-> t*istenenSayi).
                limit(x).
                reduce(0,(t,u)-> u);


}}