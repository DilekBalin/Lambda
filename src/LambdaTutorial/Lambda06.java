
package LambdaTutorial;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

    public class Lambda06 {

        public static void main(String[] args) throws IOException {
            //TASK 01 --> haluk.txt dosyasini okuyunuz.(Console'a print ediniz.)
            System.out.println("\nTASK 01 --> haluk.txt dosyasini okuyunuz -->  ");

            Path haluk = Path.of("src/lambdaTutorial/haluk.txt");//path haluk obj atandi
            Stream<String> akıs = Files.lines(haluk);//haluk.txt dataları akıs stream'e atandı

            //1. yol...
            Files.lines(haluk).//Files class'ina git lines methodu'nda haluk objesine calis >>>haluk dosyasindaki datalar akisa alindi
                    //Files.lines(Paths.get("src/lambdaTutorial/haluk.txt")).//path'deki dosyanın dataları akısa alındı
                            forEach(System.out::println);//akısdaki datalar(her satırdaki string) print edildi.
            //2.yol..
            akıs.forEach(System.out::println);//hazir hael getirdigimiz aakisi call ettik
            //TASK 02 --> haluk.txt dosyasini buyuk harflerle okuyunuz.(Console'a buyuk harflerle print ediniz.)
            System.out.println("\nTASK 02 --> haluk.txt dosyasini buyuk harflerle okuyunuz -->  ");

            Files.lines(Paths.get("src/lambdaTutorial/haluk.txt")).
                    map(String::toUpperCase).//akısdaki datalar buyuk harfe update edldi
                    forEach(System.out::println);//akısadaki datalar(her satırdaki string)yazıldı)

            //TASK 03 --> haluk.txt dosyasindaki ilk satiri kucuk harflerle print ediniz..
            System.out.println("\nTASK 03 --> haluk.txt dosyasindaki ilk satiri kucuk harflerle okuyunuz  -->  ");
            //1. yol limit();
            Files.lines(haluk). //akisa aldik
                    map(String::toLowerCase).//kucuk harfe cevirdik
                    limit(1).//ilk satiri getirdik >>>akis verir
                    forEach(System.out::println);//yazdirdik

            //2. yol findFirst();
            System.out.println(Files.lines(haluk).
                    map(String::toLowerCase).
                    findFirst()); // direkt elemani getirir

            //TASK 04 --> haluk.txt dosyasinda "basari" kelimesinin kac satirda gectiginiz print ediniz.
            System.out.println("\nTASK 04 --> haluk.txt dosyasinda basari kelimesinin kac satirda gectiginiz yazdiriniz -->  ");
            System.out.println(Files.lines(haluk).  //akisa alindi
                    map(String::toLowerCase).//kucuk harfe cevrildi
                    filter(t -> t.contains("basari")).  //icinde "basari" yazanlari filtrele
                    count());  //saydir

            //TASK 05 --> haluk.txt dosyasindaki farkli kelimeleri  print ediniz..
            System.out.println("\nTASK 05 --> haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz. -->  ");
/*
   Stream.flatMap, adıyla tahmin edilebileceği gibi, bir map ve flat işleminin birleşimidir. Bu, ilk önce elemanlarınıza bir
   fonksiyon uyguladığınız ve daha sonra düzleştirdiğiniz anlamına gelir.
   Stream.map yalnızca akışı düzleştirmeden bir işlevi uygular.

   Bir akışın düzleştirme'in neyi içerdiğini anlamak için, "iki seviye" olan [ [1,2,3],[4,5,6],[7,8,9] ] gibi bir yapı düşünün.
   Bunun düzleştirilmesi, "bir seviye" yapısında dönüştürülmesi anlamına gelir: [ 1,2,3,4,5,6,7,8,9 ].
   flatMap yöntemi, bir akışın her bir değerini başka bir akışla değiştirmenizi sağlar
   ve ardından oluşturulan tüm akışları tek bir akışa birleştirir.

 */

            //1. yol.. distinct()
            System.out.println(Files.lines(haluk).
                    map(t -> t.split(" ")).//satırlardaki kelimeler arraya atandı
                            flatMap(Arrays::stream).//2D arraydaki elelmanlar tek eleman olarak akısa alındı,cunku akista ic ic e yapilar vardi
                            distinct().//akısdaki elemanlar tekrarsız yapıldı
                            collect(Collectors.toList()));//akısdaki tekrarsız elemanlar liste atandı cunku birden cok eleman sout icine yazilmaz,array,list ya da set'e almak lazim

            //2. yol.. toset()
            System.out.println(Files.lines(haluk).
                    map(t -> t.split(" ")).//satırlardaki kelimeler arraya atandı
                            flatMap(Arrays::stream).
                    collect(Collectors.toSet()));//set benzersiz yapti



            //TASK 06 --> haluk.txt dosyasindaki tum kelimeleri natural order  print ediniz..
            System.out.println("\nTASK 06 --> haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz. -->  ");
            Files.lines(haluk).
                    map(t -> t.split(" ")).//satırlardaki kelimeler arraya atandı
                    flatMap(Arrays::stream).//2D arraydaki elelmanlar tek eleman olarak akısa alındı
                    sorted().//harf sırası yapıldı
                    forEach(System.out::println);//print edildi

            //TASK 07 --> haluk.txt dosyasinda "basari" kelimesinin kac kere gectigini buyuk harf kucuk harf bagımsız print ediniz.
            System.out.println("\nTASK 07 --> haluk.txt dosyasinda basari kelimesinin kac kere gectigini  yazdiriniz. -->  ");

            System.out.println(Files.lines(haluk).
                    map(t -> t.toLowerCase().split(" ")).
                    flatMap(Arrays::stream).
                    filter(t -> t.equals("basari")).//equals deyince o kelimyei saydiracak,contains deseydik o kelimenin gectigi her ifadeyi alirdi
                    count());
            //TASK 08 --> haluk.txt dosyasinda "a" harfi gecen kelimelerin sayisini print eden  programi create ediniz.
            System.out.println("\nTASK 08 --> haluk.txt dosyasinda a harfi gecen kelimelerin sayisini ekrana yazdiran programi yazdiriniz. -->  ");
            System.out.println(Files.lines(haluk).//txt dosyasıne erişldi
                    map(t -> t.split(" ")).//satırlar akısa alındı
                    flatMap(Arrays::stream).//her satırdaki her kelime akısa alındı
                    filter(t -> t.contains("a")).//a bulunduran kelimeler fitrelenedi
                    count());//a bulunduran kelimeler sayıldı

            //TASK 09 --> haluk.txt dosyasinda icinde "a" harfi gecen kelimeleri print ediniz.
            System.out.println("\nTASK 09 --> haluk.txt dosyasinda a harfi gecen kelimeler yazdiriniz. -->  ");
            System.out.println(Files.lines(haluk).
                    map(t -> t.split(" ")).//satırlar akısa alındı
                            flatMap(Arrays::stream).//her satırdaki her kelime akısa alındı
                            filter(t -> t.contains("a")).//a bulunduran kelimeler fitrelenedi
                            collect(Collectors.toList()));//a harfi gecen kelimeler list'e toplandi
                   // forEach(t-> System.out.print(t + " ");  //collect yapmadan da olur


            //TASK 10 --> haluk.txt dosyasinda kac /farklı harf kullanildigini print ediniz.
            System.out.println("\nTASK 10 --> haluk.txt dosyasinda kac /farklı harf kullanildigini  yazdiriniz. -->  ");
            System.out.println(Files.lines(haluk).
                    map(t -> t.replaceAll("\\W", "").//satırlar \\W ifadesi a-z A-Z 0-9 _ disindakileri kapsar
                            replaceAll("\\d", "").//digit haric her seyi hiclik yap
                            split("")).//harf akısı saglanır
                            flatMap(Arrays::stream).//her harf ayri ayri akisa alindi
                    distinct().
                    count());

            //TASK 11 --> haluk.txt dosyasinda kac farkli kelime kullanildigini print ediniz.
            System.out.println("\nTASK 11 --> haluk.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");
            System.out.println(Files.lines(haluk).
                    map(t -> t.replaceAll("[.!,:)\\-]", "").//istemedigimiz sembolleri hiclige cevirdik

                            split(" ")).//kelime akısı saglanır
                            flatMap(Arrays::stream).//her bir kelime akisa alindi
                    distinct().
                    count());
            //TASK 12 --> haluk.txt dosyasinda  farkli kelimeleri print ediniz
            System.out.println("\nTASK 12 --> haluk.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");
            System.out.print(Files.lines(haluk).
                    map(t -> t.replaceAll("[.!,:)\\-]", "").
                            split(" ")).//kelime akısı saglanır
                            flatMap(Arrays::stream).
                    collect(Collectors.toList()));
        }

    }

