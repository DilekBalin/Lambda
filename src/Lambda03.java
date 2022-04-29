import java.util.*;
import java.util.stream.Stream;

public class Lambda03 {
    public static void main(String[] args) {

        List<String> menu = new ArrayList<>(Arrays.asList("kusleme", "adana", "trilece", "trilece", "trilece", "havucDilim", "buryan",
                "yaglama", "kokorec", "arabAsi", "guvec"));
        System.out.println("\n   ***   ");
        alfBykTekrrsz(menu);
        System.out.println("\n   ***   ");
        tersCharacterSirali(menu);
        System.out.println("\n   ***   ");
        characterSayiKb(menu);
        System.out.println("\n   ***   ");
        sonHarfTersSirali(menu);
        System.out.println("\n   ***   ");
        charKaresiCiftElSirala(menu);
        System.out.println("\n   ***   ");
        harfSayisi7denAzKontrol(menu);
        System.out.println("\n   ***   ");
        wIleBaslayanElmKnt(menu);
        System.out.println("\n   ***   ");
        xIleBitenElKontrol(menu);
        System.out.println("\n   ***   ");
        karakterSayisiEnBuyukElPrint(menu);
        System.out.println("\n   ***   ");
        ilkElHaricSonHarfeGoreSirali(menu);
        System.out.println("\n   ***   ");


        // Task : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.

    }

    public static void alfBykTekrrsz(List<String> menu) {
        menu.//akis kaynagi
                stream().//akisa girdi
                //  map(t-> t.toUpperCase()).//elemanlar buyuk harf update dildi
                        map(String::toUpperCase).
                sorted().//alfabetik(natural dogal) sira yapildi
                distinct().//benzersiz tekrarsiz hale getirildi
                forEach(t -> System.out.print(t + " "));//print edildi  //ADANA ARABASİ BURYAN GUVEC HAVUCDİLİM KOKOREC KUSLEME TRİLECE YAGLAMA

        //distinct() => Bu method tekrarlı elemanları sadece bir kere akısa sokar.
        // Bu akışın farklı elemanlarından (Object.equals (Object) 'e göre) oluşan bir akış döndürür.
        // Sıralı akışlar için, farklı elemanın seçimi sabittir
        // (yinelenen öğeler için, karşılaşma sırasında ilk görünen öğe korunur.)
        // Sırasız akışlar için, herhangi bir kararlılık garantisi verilmez. Stream return eder.
    }

    // Task : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz.
    public static void tersCharacterSirali(List<String> menu) {
        menu.
                stream().
                //map(t-> t.length()).
                        map(String::length).//elemanlar karakter sayisina update edildi
                sorted(Comparator.reverseOrder()).
                distinct().
                //forEach(t-> System.out.print(t+" ")); //10 7 6 5
                        forEach(Lambda01::yazdir);

    }

    // Task : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
    public static void characterSayiKb(List<String> menu) {
        menu.
                stream().
                sorted(Comparator.comparing(String::length)).//String class'indan getirilen karakter sayisina gore karsilastirma yap
                forEach(t -> System.out.print(t + " "));//adana guvec buryan kusleme trilece trilece trilece yaglama kokorec arabAsi havucDilim
    }

    // Task : list elemanlarinin son harfine gore ters sirali print ediniz.
    public static void sonHarfTersSirali(List<String> menu) {
        menu.
                stream().
                sorted(Comparator.comparing(t -> t.toString().//buraya gelen ifade string'ten farkli olsa bile String'e ceviriyoruz
                        charAt(t.toString().length() - 1)).reversed()).
                forEach(t -> System.out.print(t + " "));
    }

    //Task: List'in elemanlarini karakterlerinden cift sayili kareelrini hesaplayan ve kareelrine tekrarsiz buyukten kucuge sirali print ediniz
    public static void charKaresiCiftElSirala(List<String> menu) {
        menu.stream().
                map(t -> t.length() * t.length()).
                filter(Lambda01::ciftBul).//cift elemanlar firtrelendi
                distinct().//tekrarsiz yapildi
                sorted(Comparator.reverseOrder()).//ters buyukten kucuge siralam yapildi
                forEach(Lambda01::yazdir);//print edildi

        //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
        //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
        //noneMatch() --> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.
    }

    // Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.

    public static void harfSayisi7denAzKontrol(List<String> menu) {
//amele code
        System.out.println("amele code");
        boolean kontrol = menu.stream().allMatch(t -> t.length() <= 7);
        if (kontrol) {
            System.out.println("list elemanları 7 ve daha az harften olusuyor");
        } else System.out.println("list elemanları 7 harften  buyuk");
//cincix code
        System.out.println("cincix code");
        System.out.println(menu.
                stream().
                allMatch(t -> t.length() <= 7) ? "list elemanları 7 ve daha az harften olusuyor" : "list elemanları 7 harften  buyuk");
    }

    // Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
    public static void wIleBaslayanElmKnt(List<String> menu) {
        System.out.println(menu.
                stream().noneMatch(t -> t.startsWith("w")) ? "agam w ile başlayan yemahh olu mu ?" :
                "agam  wenemen ne menen bi şey  ?");

    }

    // Task : List elelmanlarinin "x" ile biten en az bir elemaı kontrol ediniz.

    public static void xIleBitenElKontrol(List<String> menu) {
        System.out.println(menu.
                stream().
                anyMatch(t -> t.endsWith("x")) ? "agam senden bir  cacix olmaz  ?" :
                "agam senin aradigin yemek bu torpaklarda yooogggg");




    }

    // Task : Karakter sayisi en buyuk elemani yazdiriniz.
 public static void karakterSayisiEnBuyukElPrint(List<String> menu){
   Stream<String> sonIsim=menu.

                     stream().
                     sorted(Comparator.comparing(t -> t.toString().length()).
                     reversed()).
             //findFirst());
             limit(1);// akistan cikan elemanlari a parametresine gore ilk a elemani alir
     System.out.println(Arrays.toString(sonIsim.toArray()));  //[havucDilim]
     /*
     sonIsim.toarray()--> Limit () methoreturn'dan dolayi stream typr olan sonIsim toArray() method ile array type convert edildi
          */

     //limit(1) => Sınırlandırma demek. Bu akışın elemanlarından oluşan, uzunluğu maxSize'dan uzun olmayacak
// şekilde kesilmiş bir akış return eder. Stream return eder


     Optional<String> enBylEl= menu.
             stream().
             sorted(Comparator.comparing(t -> t.toString().length()).
                     reversed()).findFirst();
     System.out.println(enBylEl);
 }

    // Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
public static void ilkElHaricSonHarfeGoreSirali(List<String> menu){
        menu.stream().sorted(Comparator.comparing(t-> t.charAt(t.length()-1))).skip(1).forEach(t-> System.out.print(t+ " "));//yaglama kokorec guvec kusleme trilece trilece trilece arabAsi havucDilim buryan

//skip(1) => atlama demek. Akışın ilk n elemanını attıktan sonra bu akışın kalan elemanlarından oluşan bir akış return eder.
// Bu akış n'den daha az öğe içeriyorsa, boş bir akış döndürülür. Bu, durum bilgisi olan bir ara işlemdir.
//skip(list.size()-1) => List'in uzunluğunun 1 eksiğini yazarsak son elemanı yazdırırız.
}
}
