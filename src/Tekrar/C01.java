package Tekrar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C01 {
    public static void main(String[] args) {
        //Task: Structured Programmıng kullanarak list elemanlarını aralarında bosluk olacak sekılde print ediniz
functional();

    }

    public void structured() {

        List<Integer> liste = new ArrayList<>(Arrays.asList(12, 34, 56, 67, 89, 31, 4, 5, 78));
        for (int i = 0; i < liste.size(); i++) {
            System.out.print(liste.get(i) + " ");
        }
        System.out.println("");
        //veya for each ile
        for (Integer each : liste) {
            System.out.print(each + " ");
        }
    }
    public  static void  functional(){
        List<Integer> liste = new ArrayList<>(Arrays.asList(12, 34, 56, 67, 89, 31, 4, 5, 78));
      liste.stream().forEach(t-> System.out.print(t+" "));

    }
}
