package Tekrar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C02 {
    public static void main(String[] args) {
        List<Integer> liste = new ArrayList<>(Arrays.asList(12, 34, 56, 67, 89, 31, 4, 5, 78));
        functıonal(liste);
        System.out.println();
        functional2(liste);
        System.out.println();
        filtrele(liste);
        System.out.println();
        buyukvecıft(liste);
    }
    //Task: functıonalProgramming ile list elemanlarinin 34 den kucuk cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz

    private static void buyukvecıft(List<Integer> liste) {
        liste.stream().filter(t->t>34).filter(C02::cıftBul).forEach(C02::yazdır);
    }

    private static void filtrele(List<Integer> liste) {
        //Task:FunctıonalProgramming ile list elemanlarinin  cift olanlarını ayni satirda aralarina bosluk birakarak print ediniz
liste.stream().filter(t-> t%2==0).forEach(t-> System.out.print(t+" "));
    }

    private static void functional2(List<Integer> liste) {
        liste.stream().forEach(C02::yazdır);
    }

    private static void functıonal(List<Integer> liste) {
        liste.stream().forEach(System.out::print);// ama bu hepsini yanyana yazdı


    }

    public static void yazdır(int a) {
        System.out.print(a + " ");
    }
    public static boolean cıftBul(int a){
     return   a%2==0;
    }
    //Task: functıonalProgramming ile list elemanlarinin 34 den kucuk cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz


}

