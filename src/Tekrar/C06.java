package Tekrar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class C06 {
    public static void main(String[] args) {
 List<String> menü = new ArrayList<>(Arrays.asList("küşleme", "adana", "trileçe", "havucDilim", "buryan",
         "yaglama", "kokareç", "arabaşı", "güveç", "trileçe", "trileçe", "trileçe"));

 // Task : list elemanlarinin son harfine gore ters sirali print ediniz.
 menü.stream().sorted(Comparator.comparing(t -> t.toString().charAt(t.toString().length() - 1)).reversed()).forEach(t -> System.out.print(t + " "));
 System.out.println("*** \n");
 // Task : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
 menü.stream().sorted(Comparator.comparing(t -> t.length())).forEach(t -> System.out.print(t + " "));

 // Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,ve karelerini tekrarsiz buyukten kucuge sirali  print ediniz..
 System.out.println("*** \n");

 menü.stream().map(t -> t.length() * t.length()).filter(t -> t % 2 == 0).distinct().sorted(Comparator.reverseOrder()).forEach(t -> System.out.print(t + " "));
        System.out.println("*** \n");
 // Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
 boolean kontrol=menü.stream().allMatch(t->t.length()<=7);
       if (kontrol){
           System.out.println("elemanların 7 ve daha az harften olusuyor");
       }else {
           System.out.println("lıst elemanlarının ıcınde  7 harften buyuk kelimeler var");
       }
        System.out.println(menü.stream().allMatch(t -> t.length() <= 7) ? "list elemanları 7 ve daha az harften olusuyor" : "list elemanları 7 harften buyuktur");

        // Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
        System.out.println(menü.stream().noneMatch(t -> t.startsWith("w")) ? "listenizde wile baslayan yemek yoktur" : "listenizde w baslayanile yemek verdır");

// Task : List elelmanlarinin "x" ile biten en az bir elemanı kontrol ediniz.
        System.out.println(menü.stream().anyMatch(t -> t.endsWith("x")) ? "x ıle bitiyor" : "x ıle bıtmıyor");
        // Task : Karakter sayisi en buyuk elemani yazdiriniz.
        System.out.println(menü.stream().sorted(Comparator.comparing(t -> t.toString().length()).reversed()).findFirst());
        // Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
menü.stream().sorted(Comparator.comparing(t->t.toString().length()).reversed()).skip(1).forEach(t->System.out.print(t+" "));
        System.out.println(" ");
     Stream<String> isim= (menü.stream().sorted(Comparator.comparing(t->t.toString().length()).reversed()).limit(1));
        System.out.println(Arrays.toString(isim.toArray()));
    }
}
