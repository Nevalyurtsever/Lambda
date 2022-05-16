package Lambdaday5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Lambda06 {
    public static void main(String[] args) throws IOException {
        //TASK 01 --> haluk.txt dosyasini okuyunuz.(Console'a yazdiriniz)
        System.out.println("\n*** haluk.txt dosyasini okuyunuz -->  ");
        Files.lines(Paths.get("src/Lambdaday5/nvl.txt")).//Files class'dan lines() method call edilerek data
                // çekilecek dosya yolu(path)
                // paremetre girilerek path'deki dosyanın dataları akısa alındı
                        forEach(System.out::println);//akısadaki datalar(her satırdaki string)yazıldı)


        //TASK 02 --> haluk.txt dosyasini buyuk harflerle okuyunuz.(Console'a buyuk harflerle yazdiriniz)
        System.out.println("\n*** haluk.txt dosyasini buyuk harflerle okuyunuz -->  ");

        Files.lines(Paths.get("src/Lambdaday5/nvl.txt")).
                map(String::toUpperCase).//akısdaki datalar buyuk harfe update edldi
                forEach(System.out::println);//akısadaki datalar(her satırdaki string)yazıldı)

        //TASK 03 --> haluk.txt dosyasindaki ilk satiri kucuk harflerle yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki ilk satiri kucuk harflerle okuyunuz 01 -->  ");
        Files.lines(Paths.get("src/Lambdaday5/nvl.txt")).map(t->t.toLowerCase()).forEach(System.out::println);
        //TASK 04 --> haluk.txt dosyasinda "basari" kelimesinin kac satirda gectiginiz yazdirinizSystem.out.println("\n*** haluk.txt dosyasinda basari kelimesinin kac satirda gectiginiz yazdiriniz -->  ");
        System.out.println( Files.lines(Paths.get("src/Lambdaday5/nvl.txt")).filter(t->t.contains("basari")).count());

        //TASK 05 --> haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz.System.out.println("\n*** haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz. -->  ");,
        //1. yol distinct
        Files.lines(Paths.get("src/Lambdaday5/nvl.txt")).map(t->t.split(" ")).//satırlardakı kelımeler array a atandı
                flatMap(Arrays::stream).//2D arraydakı elemanlar tek eleman olarak akısa alındı
                distinct()//akıstakı elemanlar tekrarsız yapıldı
                .collect(Collectors.toList())//akıstakı tekrarsız elemanlar lıste atandı
                .forEach(System.out::print);
        System.out.println(" ");
        //2.yol toset
        System.out.println(Files.lines(Paths.get("src/Lambdaday5/nvl.txt")).map(t -> t.split(" ")).flatMap(Arrays::stream).collect(Collectors.toSet()));


        //TASK 06 --> haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz.System.out.println("\n*** haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz. -->  ");

        Files.lines(Paths.get("src/Lambdaday5/nvl.txt")).map(t -> t.split(" ")).flatMap(Arrays::stream).sorted().forEach(System.out::println);

        //TASK 07 --> haluk.txt dosyasinda "basari" kelimesinin kac kere gectigini buyuk harf kucuk harf bagımsız yaziniz.System.out.println("\n*** haluk.txt dosyasinda basari kelimesinin kac kere gectigini  yazdiriniz. -->  ");
        System.out.println("\nTASK 07 --> haluk.txt dosyasinda \"basari\" kelimesinin kac kere gectigini buyuk harf kucuk harf bagımsız yaziniz.");
        System.out.println(Files.lines(Paths.get("src/Lambdaday5/nvl.txt")).map(t -> t.toLowerCase().split(" ")).flatMap(Arrays::stream).filter(t -> t.equals("basari")).count());
        //TASK 08 --> haluk.txt dosyasinda "a" harfi gecen kelimelerin sayisini ekrana yazdiran programi yazinizSystem.out.println("\n*** haluk.txt dosyasinda a harfi gecen kelimelerin sayisini ekrana yazdiran programi yazdiriniz. -->  ");
        System.out.println("TASK 08 --> haluk.txt dosyasinda \"a\" harfi gecen kelimelerin sayisini ekrana yazdiran programi yazinizSystem.out.println(\"\\n*** haluk.txt dosyasinda a harfi gecen kelimelerin sayisini ekrana yazdiran programi yazdiriniz");
        System.out.println(Files.lines(Paths.get("src/Lambdaday5/nvl.txt")).map(t -> t.split(" ")).flatMap(Arrays::stream).filter(t -> t.contains("a")).count());
        //TASK 09 --> haluk.txt dosyasinda icinde "a" harfi gecen kelimeleri yazdirinizSystem.out.println("\n*** haluk.txt dosyasinda a harfi gecen kelimeler yazdiriniz. -->  ");
        System.out.println("\n*** haluk.txt dosyasinda kac /farklı harf kullanildigini  yazdiriniz. -->  ");
        Files.lines(Paths.get("src/Lambdaday5/nvl.txt")).map(t -> t.split(" ")).flatMap(Arrays::stream).filter(t -> t.contains("a")).collect(Collectors.toList()).forEach(System.out::print);

        System.out.println(" ");
        //TASK 10 --> haluk.txt dosyasinda kac /farklı harf kullanildigini yazdiriniz
        System.out.println(Files.lines(Paths.get("src/Lambdaday5/nvl.txt")).map(t -> t.replaceAll("\\W","")
                .replaceAll("\\d","").split("")).flatMap(Arrays::stream).distinct().count());
        //TASK 11 --> haluk.txt dosyasinda kac farkli kelime kullanildigini yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");
        System.out.println(Files.lines(Paths.get("src/Lambdaday5/nvl.txt")).map(t -> t.replaceAll("\\W","")
                .replaceAll("\\d","").split(" ")).flatMap(Arrays::stream).distinct().count());


    }
    }

