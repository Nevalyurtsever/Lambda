package Tekrar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class C03 {
    public static void main(String[] args) {
        List<Integer> liste = new ArrayList<>(Arrays.asList(12, 34, 56, 67, 89, 31, 4, 5, 78));
        // Task : List'teki elemanlardan en kucugunu 4 farklı yontem ile print ediniz.
        IntClass(liste);
       MathClass(liste);
       expression(liste);
      byNeval(liste);
    }

    private static void byNeval(List<Integer> liste) {
        Optional<Integer> nevalce=liste.stream().reduce(C03::nevalce);
        System.out.println("nevalce = " + nevalce);
    }
    public static int nevalce(int a,int b){
        return b<a ?b:a;
    }

    private static void expression(List<Integer> liste) {
       int expression= liste.stream().reduce(Integer.MAX_VALUE,(a,b)->a>b?b:a);
        System.out.println("expression = " + expression);
        //optional yapmadı cunku ilk degeri biz belirledik


    }

    private static void MathClass(List<Integer> sayilar) {
        Optional<Integer> mathMin= sayilar.stream().reduce(Math::min);
        System.out.println("mathMin = " + mathMin);
    }

    private static void IntClass(List<Integer> liste) {
        Optional<Integer> IntegerMin=liste.stream().reduce(Integer::min);
        System.out.println("IntegerMin = " + IntegerMin);
    }
}
