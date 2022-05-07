package LambdaTutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02_Yeniden {
    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<>(Arrays.asList(4, 2, 6, 3, -3, 7, -5, 15));

        ciftElKare(sayi);
        System.out.println("\n   ***   ");
        tekElKupBirFazla(sayi);
        System.out.println("\n   ***   ");
        ciftElKarekok(sayi);
        System.out.println("\n   ***   ");
        enBuyuk(sayi);
        System.out.println("\n   ***   ");
        ciftElKareMax(sayi);
        System.out.println("\n   ***   ");
        elemanTopla(sayi);
        System.out.println("\n   ***   ");
        ciftElCarp(sayi);



    }



    // Task : Functional Programming ile listin cift elemanlarinin  karelerini ayni satirda aralarina bosluk bırakarak print ediniz
    private static void ciftElKare(List<Integer> sayi) {
        sayi.//list'teki elemanlari al
                stream().//akisa sun
                filter(Lambda01::ciftBul).//seed method 'tan class ismi ile birlikte method'u call et ve cift sayilari filtrele
                map(t -> (t * t)). //herbir t'yi al ve t'nin karesini bul
                forEach(Lambda01::yazdir);//herbir t'yi kareleriyle yazdir

        //map demek islem yapan bir fonksiyondur,icine hangi islemi koyarsaiz onu yapar,biz karelerini yaptirdik
    }


    // Task : Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print edi
    private static void tekElKupBirFazla(List<Integer> sayi) {
        sayi.stream().filter(t-> t%2!=0).map(t-> (t*t*t)+1).forEach(Lambda01::yazdir);
    }
// Task : Functional Programming ile listin cift elemanlarinin   karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz

    public static void ciftElKarekok(List<Integer> sayi){
        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map( Math::sqrt).//Math class'indaki hazir methodu kullandik
                forEach(t-> System.out.print(t + " "));// Lambda01.yazdir () method'u integer oldugu icin burda kullanamadik ve expression yaptik
    }
    // Task : list'in en buyuk elemanini yazdiriniz
    public static void enBuyuk(List<Integer> sayi){

       Optional<Integer> maxSayi= sayi.stream().reduce(Math::max);// reduce method'unu tek bir sonuc elde edecegimiz zaman kullaniiriz,max sayi sadece bir tanedir
        //yaptigimiz islemleri integer bir variable'a atamak istedik ama kirmizi cizince verince komuttan degistirdik
        System.out.println(maxSayi); //Optional[15]
        System.out.println("islemlerin sout icinde yazilmis halinin sonucu: "+sayi.stream().reduce(Math::max));//islemlerin sout icinde yazilmis halinin sonucu: Optional[15]

      //  reduce () methodu terminal yani son islem oldugu icin arkasidnan method kabul etmez o yuzden ciktiyi once  bir variable'a bagladik ve sout icinde sonucu yazdirdik
        //istersek bir variable'a baglamadan a sout icinde sonuclari yazdirabiliriz ki ikincisi bu islemdi

    }
    // Task : List'in cift elemanlarin karelerinin en buyugunu print ediniz
    public static void ciftElKareMax(List<Integer> sayi){
        System.out.println(sayi.stream().filter(Lambda01::ciftBul).map(t-> t*t).reduce(Math::max)); //Optional[36]    //Math class'i daha genistir
        System.out.println(sayi.stream().filter(Lambda01::ciftBul).map(t-> t*t).reduce(Integer::max)); //Optional[36]  //Integer class'i daha spesifik bir class ve daha hizli calisir

    }
    // Task : List'teki tum elemanlarin toplamini yazdiriniz.
    //Lambda Expression...

    public static void elemanTopla(List<Integer> sayi){
        System.out.println("Lambda method referance ile sonuc : "+ sayi.stream().reduce(Integer::sum));    //Lambda method referance ile sonuc : Optional[29]
      //biz bunu int bir variable 'a atamayiz optional ister,optional yaparsak atamayi kabul eder
        //cunku burda bir baslangic dederi vermedigimiz icin eger list bossa bize null degeri verir bu yuzden java tedbir alip optional'a casting yapar
        //asagidaki islemde baslangic 0 oldugu icin sonuc asla null olamz ve int bir variabl'aatamak da sorun olmaz

       int toplam= +sayi.stream().reduce(0, (a, b) -> a + b);
        System.out.println("Lambda expression ile souc: "+toplam);  //Lambda expression ile souc: 29
        //0 ile basladik sonra iki sayi aldik tyerine onlari topladik.
        //burdaki 0 ,for loop'taki konteynir gibidir
        // a,ilk degerini her zaman 0'dan (identity) alir
        //b ise ilk dgerini akistan yani gelen sayilardan alir
        //sonra artik a,deegrlerini islemden alir b ise akistan almaya  devam eder


    }

    // Task : List'teki cift elemanlarin carpimini  yazdiriniz.
    public static void ciftElCarp (List<Integer> sayi){
        System.out.println(sayi.stream().filter(Lambda01::ciftBul).reduce(Math::multiplyExact));  //Optional[48]
      int carpim=  sayi.stream().filter(Lambda01::ciftBul).reduce(1,(x,y)->x*y);
        System.out.println(carpim);  //48

    }

}
