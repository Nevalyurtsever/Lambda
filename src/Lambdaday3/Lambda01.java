package Lambdaday3;


import java.util.*;



public class Lambda01 {
    public static void main(String[] args) {
        List<Integer> sayi = new ArrayList<>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));
        System.out.println("\n   ***   ");
        minBul(sayi);
        System.out.println("\n   ***   ");
        bestenBykEnKck(sayi);
        System.out.println("\n   ***   ");
        tekKareBkPrint( sayi);
        System.out.println("\n   ***   ");
        ciftKareKbPrint(sayi);


    }


    // Task : List'teki elemanlardan en kucugunu 4 farklı yontem ile print ediniz.
    public static void minBul(List<Integer> sayi) {
        //1. yontem Method Reference --> Integer class
        Optional<Integer> minSayiInteger = sayi.stream().reduce(Integer::min);
        System.out.println(minSayiInteger);
        //2. yontem Method Reference --> Math class
        Optional<Integer> minSayiMath = sayi.stream().reduce(Math::min);
        System.out.println(minSayiMath);
        //3. yontem Lambda Expression
        int minSayiLJambda = (sayi.stream().reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y));
        System.out.println(minSayiLJambda);
        //4. yontem Method Reference --> Haluk class
        Optional<Integer> minSayiHaluk = sayi.stream().reduce(Lambda01::byHalukMin);
        System.out.println(minSayiHaluk);
    }


    public static int byHalukMin(int a, int b) {//bu method kendisine verilen iki int degerin en kücügunu return eder
        return a < b ? a : b;
    }

    // Task : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.
    public static void bestenBykEnKck(List<Integer> sayi) {

        System.out.println(sayi.stream().filter(t -> t > 5 && t % 2 == 1).reduce(Lambda01::byHalukMin));
    }

    // Task : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.
    public static void ciftKareKbPrint(List<Integer> sayi) {
        sayi.
                stream().//akısa alındı
                filter(Lambdaday1.Lambda02::ciftBul).//cift elemnlar fitrlenedi
                map(t->t*t).//fitrelenen cift sayı karesi alındı
                sorted().//karesi alınan elemanlar dogal(k->b) sıralandı
                forEach(Lambdaday1.Lambda02::yazdir);//print edildi

        //sorted() => Doğal düzene göre sıralanmış, bu akışın elemanlarında oluşan bir akış döndürür.
        //Sorted() methodu tekrarlı kullanılırsa en son kullanılan aktif olur.
    }

    // Task : list'in tek  elemanlarinin kareleri ni buykten kucuge  print ediniz.

    public static void tekKareBkPrint(List<Integer> sayi) {
        sayi.//akıs kaynagı
                stream().//akısa alındı
                filter(t->t%2!=0).//tek elemnlar fitrlenedi
                map(t->t*t).//fitrelenen cift sayı karesi alındı
                sorted(Comparator.reverseOrder()).//karesi alınan elemanlar ters(b->k) sıralandı
                forEach(Lambdaday1.Lambda02::yazdir);//print edildi


    }

}
