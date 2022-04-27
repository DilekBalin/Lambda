import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01_Yeniden {
    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<>(Arrays.asList(34, 22, 16, 11, 35, 20, 63, 21, 65, 44, 66, 64, 81, 38, 15));

        printElStructured(sayi);
        printElFunctional(sayi);
        printElFunctional1(sayi);
        printElFunctional2(sayi);
        printCiftElStructured(sayi);
        printCiftElFunctional(sayi);
        printCiftElFunctional1(sayi);
        ciftVeOtuzdorttenKucuk(sayi);
        ciftVeOtuzdorttenBuyuk(sayi);

    }
//task1 :Structered  ile list elemanlarini aralarinda bosluk birakacak sekilde print edin

    public static void printElStructured(List<Integer> sayi) {


        for (Integer w : sayi) { // datalar integer'dan gelecek,sayi'dan gelen herbir eleman integer olarak veriye esitlensin
            System.out.print(w + " "); //34 22 16 11 35 20 63 21 65 44 66 64 81 38 15
        }

        System.out.println("\n  *******************");
    }

//method disindayiz
//task2 :Functional ile list elemanlarini aralarinda bosluk birakacak sekilde print edin

    public static void printElFunctional(List<Integer> sayi) {
        //once aksiyon yapacagimiz elemani getiriyoruz
        sayi.stream().forEach(t -> System.out.print(t + " ")); //34 22 16 11 35 20 63 21 65 44 66 64 81 38 15


        System.out.println("\n  *******************");
    }


    ///task3:
    public static void printElFunctional1(List<Integer> sayi) {
        sayi.stream().forEach(System.out::print);//342216113520632165446664813815   bosluk vermedi bu istenmemis
        //method referance ->>System.out yapisindan print methodu refere et
        System.out.println("\n  *******************");
    }

    public static void yazdir(int a) { // verilen integer degeri ayni satirda bosluk birakarak

        // yazdirma aksiyonu yapan seed(tohum) method create edildi
        System.out.print(a + " ");
    }

    public static void printElFunctional2(List<Integer> sayi) {
        sayi.stream().forEach(Lambda01_Yeniden::yazdir);//34 22 16 11 35 20 63 21 65 44 66 64 81 38 15
        System.out.println("\n  *******************");

    }

 //Task : Sructed Programming ile list elemanlarinin  cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCiftElStructured(List<Integer> sayi){
        for (Integer w:sayi) {
            if(w%2==0)
                System.out.print(w+ " ");//34 22 16 20 44 66 64 38



        }
        System.out.println("\n  *******************");
    }

//Task : Sructed Programming ile list elemanlarinin  cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz.
public static void printCiftElFunctional(List<Integer> sayi) {
  sayi.stream().filter(t-> t%2==0).forEach(Lambda01_Yeniden::yazdir);//sayi 'yi al akisa sun
    //filtrele her bir elemni al t'ye bagla ve t'nin cift olmasini sorgula ve sonra da class ismi ile method call yap yazdir

    System.out.println("\n  *******************");
    }

public static boolean ciftBul(int b){  //seed method verilen int degerin cift olup olmadigini kontrol eder
        return b%2==0; //b yi al 2'yebolumunden kalan sifirsa dondur

}

    public static void printCiftElFunctional1(List<Integer> sayi) {
        sayi.
                stream().//list elemanlari islem akisina alindi
                filter(Lambda01_Yeniden::ciftBul).//ciftBul method refere edilerek akistaki elemanlar filtrelendi
                forEach(Lambda01_Yeniden::yazdir); //filtreden gelen elemanalr yazdir() methodu refer edilerek print edildi

        System.out.println("\n  *******************");
    }
    //Task : functional Programming ile list elemanlarinin 34 den kucuk cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void ciftVeOtuzdorttenKucuk(List<Integer> sayi){
        sayi.
                stream().
               // filter(t -> t % 2 == 0 && t < 34). // =>> istersek butun halinde yazariz
               filter(Lambda01_Yeniden::ciftBul).//method call ettik
                filter(t-> t<34).//expression yaptik
                forEach(Lambda01_Yeniden::yazdir);
                    //22 16 20
        System.out.println("\n  *******************");
}

    //Task : functional Programming ile list elemanlarinin 34 den buyuk veya cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void ciftVeOtuzdorttenBuyuk(List<Integer> sayi){
        sayi.
                stream().
                filter(t-> t%2==0 || t>34 ).  //ayni sarti ayni anda kontrol etmek icin bunu kullanmlaiyiz
                //yukridaki ornekte iki ayri filtre kullandik cunku iki ayri sarti kontrol ettik
                forEach(Lambda01_Yeniden::yazdir);  //34 22 16 35 20 63 65 44 66 64 81 38



    }
}