package Tekrar;

import Lambdaday1.Lambda02;

import java.util.*;

public class C04 {
    public static void main(String[] args) {
        List<Integer> liste = new ArrayList<>(Arrays.asList( 2, 3, 4, 89, 31, 4, 5, 77));
        // Task : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.
        Optional<Integer> task1 = liste.stream().filter(t -> t > 5 && t % 2 == 1).reduce(Math::min);
        System.out.println("task1 = " + task1);
        //t yi 2 kere yazmaya gere yoktur. aynı parentezin ıcınde ve yaprken
        // Task : Functional Programming ile listin cift elemanlarinin  karelerini ayni satirda aralarina bosluk bırakarak print ediniz
        liste.stream().filter(t -> t % 2 == 0).map(t -> t * t).forEach(t -> System.out.print(t + " "));
        // Task : Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print edi
        System.out.println(" ");
        liste.stream().filter(t -> t % 2 == 1).map(t -> (t * t * t) + 1).forEach(t -> System.out.print(t + " "));
        // Task : Functional Programming ile listin cift elemanlarinin   karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
        System.out.println(" ");
        liste.stream().filter(t -> t % 2 == 0).map(Math::sqrt).forEach(t -> System.out.print(t + " "));
        System.out.println(" ");
        // Task : list'in en buyuk elemanini yazdiriniz
        Optional<Integer> max = liste.stream().reduce(Integer::max);
        System.out.println("max = " + max);
        // Task : List'in cift elemanlarin karelerinin en buyugunu print ediniz
        Optional<Integer> karemax = liste.stream().filter(t -> t % 2 == 0).map(t -> (t * t)).reduce(Integer::max);
        System.out.println("karemax = " + karemax);
        // Task : List'teki tum elemanlarin toplamini yazdiriniz.
        int toplam = liste.stream().reduce(0, (a, b) -> a + b);// baslangıc degerini biz belirledigimiz ıcın optional a grek kalmadı.
        System.out.println("toplam = " + toplam);
        // Task : List'teki tum elemanlarin carpımını yazdiriniz.
        int carpım=liste.stream().reduce(1,(a,b)->a*b);
        System.out.println("carpım = " + carpım);
        // Task : List'teki tum elemanlarin maxı nı bulun
        int min=liste.stream().reduce(Integer.MIN_VALUE,(a,b)->a>b?a:b);
        System.out.println("min = " + min);
        // Task : List'teki tum elemanlarin minumun ununu bulun.
     int minn=   liste.stream().reduce(Integer.MAX_VALUE,(a,b)->(a<b ?a:b));
        System.out.println("minn = " + minn);
        //baslangıc degerlerini etkı etmemesı ıcın mınıumumda max alıyoruz
        //maxımumda mınumum alıyoruz

        // Task : List'teki cift elemanlarin carpimini  yazdiriniz.
Optional<Integer> carpımsonuc=liste.stream().filter(t->t%2==0).reduce(Math::multiplyExact);
        System.out.println("carpımsonuc = " + carpımsonuc);
        // Task : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.
liste.stream().filter(t->t%2==0).map(t->(t*t)).sorted().forEach(t->System.out.print(t+" "));
//listın sırayla yazdır kucukten buyuge
        System.out.println("");
        liste.stream().sorted().forEach(t->System.out.print(t+" "));
        // Task : list'in tek  elemanlarinin kareleri ni kucukten buyuge print ediniz.
        System.out.println(" ");
liste.stream().filter(t->t%2==1).map(t->(t*t)).sorted().forEach(t->System.out.print(t+" "));
//    // Task : list'in tek  elemanlarinin kareleri ni buykten kucuge  print ediniz.
        System.out.println(" ");
        liste.stream().filter(t->t%2==1).map(t->(t*t)).sorted(Comparator.reverseOrder()).forEach(Lambda02::yazdir);


    }
}
