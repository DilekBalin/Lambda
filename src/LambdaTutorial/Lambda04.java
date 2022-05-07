package LambdaTutorial;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {


    public static void main(String[] args) {
  /*
    TASK :
    fields --> Universite (String)
               bolum (String)
               ogrcSayisi (int)
               notOrt (int)
               olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
     */


        Universite bogazici = new Universite("bogazici", "matematik", 571, 93);
        Universite itu = new Universite("istanbul teknik", "matematik", 622, 81);
        Universite istanbul = new Universite("istanbul", "hukuk", 1453, 71);
        Universite marmara = new Universite("marmara", "bilgisayar muh", 1071, 77);
        Universite ytu = new Universite("yıldız teknik", "gemi", 333, 74);
        List<Universite> unv = new ArrayList<>(Arrays.asList(bogazici, itu, istanbul, marmara, ytu));

        System.out.println(notOrt74BykUnv(unv));   //return oldugu icin sout icine yazdik
        System.out.println("\n   ***   ");
        System.out.println(ogrcSayisi110AzMi(unv));
        System.out.println("\n   ***   ");
        System.out.println(matVarMi(unv));
        System.out.println("\n   ***   ");
        System.out.print(ogrSayiBykKcGoreSirala(unv));
        System.out.println("\n   ***   ");
        ogrSayiBykKcGoreSiralaVoid(unv);
        System.out.println("\n   ***   ");
        System.out.println(notOrtBykKcSiralaIlk3Print(unv));
        System.out.println("\n   ***   ");
        System.out.println(ogrSayisiEnAz2Unv(unv));
        System.out.println("\n   ***   ");
        System.out.println(notOrt63tenBykUnv(unv));
        System.out.println("\n   ***   ");
        System.out.println("ToInt ile sonuc: " + notOrt63tenBykUnvToInt(unv));
        System.out.println("\n   ***   ");
        System.out.println(ogrSayisi333danBykUnvNotOrt(unv));
        System.out.println("\n   ***   ");
        System.out.println(matBolSayisi(unv));
        System.out.println("\n   ***   ");
        System.out.println(ogrSayisi571danFazlaUnvMaxNotOrt(unv));
        System.out.println("\n   ***   ");
        System.out.println(ogrSayisi1071danAzUnvMinNotOrt(unv));

    }

    //task 01--> notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.
    public static boolean notOrt74BykUnv(List<Universite> unv) {

        return unv.
                stream().
                //objenin icine girip get() method'u ile herbir method'u getirebilirisin
                        allMatch(t -> t.getNotOrt() > 74);//false cunku hepsi 74'ten buyuk olsaydi true olurdu
        //kontrol etmek match idi
        //git t'deki tum elemanlei 74'ten buyuk mu diye eslestir eslesenleri yazdiracaksin
        // burdaki t bir obje ve nokta deyince tum method'lar gelir biz ortamalyi kullancagiz
    }
//task 02-->ogrc sayilarinin   110 den az olmadigini  kontrol eden pr create ediniz.

    public static boolean ogrcSayisi110AzMi(List<Universite> unv) {
        return unv.stream().allMatch(t -> t.getOgrSayisi() > 110);//true


    }

    //task 03-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.
    public static boolean matVarMi(List<Universite> unv) {
        return unv.stream().anyMatch(t -> t.getBolum().contains("mat"));//true
    }

    //task 04-->universite'leri ogr sayilarina gore b->k siralayiniz.
    public static List<Universite> ogrSayiBykKcGoreSirala(List<Universite> unv) {
        return unv.stream().sorted(Comparator.comparing(Universite::getOgrSayisi).reversed()).collect(Collectors.toList());
        //niye collect yaptik? cunku stream bize sadece akisi getirir ama biz onu bir yerde toplamaliyiz ornegin List gibi
        //collect >> akisataki elemanlari istenen sarta gore toplar
        //Collectors.toList()>>>> collect'e toplanan elemanlari list'e cevirir
    }

    //task 04-->universite'leri ogr sayilarina gore b->k siralayiniz.(return etmeden)
    public static void ogrSayiBykKcGoreSiralaVoid(List<Universite> unv) {
        System.out.println(unv.stream().sorted(Comparator.comparing(Universite::getOgrSayisi).reversed()).collect(Collectors.toList()));
    }


    //task 05-->universite'leri notOrt gore  b->k siralayip ilk 3 'unu print ediniz.
    public static List notOrtBykKcSiralaIlk3Print(List<Universite> unv) {
        return unv.stream().sorted(Comparator.comparing(Universite::getNotOrt).reversed()).limit(3).collect(Collectors.toList());
    }


    //task 06--> ogrc sayisi en az olan 2. universite'yi  print ediniz.
    public static List<Universite> ogrSayisiEnAz2Unv(List<Universite> unv) {
        return unv.
                stream().
                sorted(Comparator.comparing(Universite::getOgrSayisi)).limit(2).skip(1).
                collect(Collectors.toList());//akis devam ederken elimizdekileri list'e atadik

    }

    //task 07--> notOrt 63 'den buyuk olan universite'lerin ogrc sayilarini toplamini print ediniz
    public static Optional<Integer> notOrt63tenBykUnv(List<Universite> unv) {
        return unv.stream().filter(t -> t.getNotOrt() > 63).
                map(t -> t.getOgrSayisi()).
                reduce(Integer::sum);    //Optional[4050]
        // reduce(Math::addExact);
        //reduce(0, (t,u)->t + u);
    }

    public static int notOrt63tenBykUnvToInt(List<Universite> unv) {
        return unv.
                stream().//objeler akiyor(tum bilgileri  ile)
                        filter(t -> t.getNotOrt() > 63).//akis filtreleniyor
                        mapToInt(t -> t.getOgrSayisi()).// elemanlari Wrapper class'ina atiyor artik data type'imiz Integer
                        sum(); // aldigi sayilari topluyor  //4050
    }

    //task 08--> Ogrenci sayisi 333'dan buyuk olan universite'lerin notOrt'larinin ortalamasini bulunuz.
    public static OptionalDouble ogrSayisi333danBykUnvNotOrt(List<Universite> unv) {
        return unv.stream().
                filter(t -> t.getOgrSayisi() > 333).//ogrenci sayisi 333'dan fazla olan unv obje olarak geldi
                        mapToDouble(t -> t.getNotOrt()).// o objelerden not ortaalamasi 333'den buyuk olanalri wrapper class'a attik onlar artik birer double sayi
                        average();   //OptionalDouble[80.5]
    }


    //task 09-->"matematik" bolumlerinin sayisini  print ediniz.
    public static long matBolSayisi(List<Universite> unv) {
        return unv.stream().
                filter(t -> t.getBolum().contains("mat")).count();

    }


    //task 10-->Ogrenci sayilari 571'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz
    public static OptionalDouble ogrSayisi571danFazlaUnvMaxNotOrt(List<Universite> unv) {
        return unv.stream().
                filter(t -> t.getOgrSayisi() > 571).// ogrenci sayisi 571'den buyuk olan unv obje olarak geldi(tum bnilgiler icinde)
                        mapToDouble(t -> t.getNotOrt()).
                max();//OptionalDouble[81.0]


    }


    //task 11-->Ogrenci sayilari 1071'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.

    public static OptionalInt ogrSayisi1071danAzUnvMinNotOrt(List<Universite> unv) {
      return  unv.stream().
                filter(t -> t.getOgrSayisi() < 1071).
                mapToInt(t -> t.getNotOrt()).
                min();//OptionalInt[74]

    }


}