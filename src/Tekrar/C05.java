package Tekrar;

import Lambdaday1.Lambda02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class C05 {
    public static void main(String[] args) {
        List<String> menü=new ArrayList<>(Arrays.asList("küşleme","adana","trileçe","havucDilim","buryan",
                "yaglama","kokareç","arabAşı","güveç","trileçe","trileçe","trileçe"));
        // Task : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
        menü.stream().map(t->t.toUpperCase()).sorted().distinct().forEach(t->System.out.print(t+" "));
        System.out.println(" ");
        // Task : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
menü.stream().map(String::length).sorted(Comparator.reverseOrder()).distinct().forEach(t->System.out.print(t+" "));
        System.out.println(" ");
        // Task : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
menü.stream().sorted(Comparator.comparing(String::length)).forEach(t->System.out.print(t+" "));
        System.out.println("");
        // Task : list elemanlarinin son harfine gore ters sirali print ediniz.
        menü.stream().sorted(Comparator.comparing(t->t.toString().charAt(t.toString().length()-1)).reversed()).forEach(t->System.out.print(t+" "));


    }
}
