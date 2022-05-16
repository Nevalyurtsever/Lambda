package Lambdaday4;

import java.util.*;
import java.util.stream.Collectors;

public class C01 {
    /*
    TASK :
    fields --> Universite (String)
               bolum (String)
               ogrcSayisi (int)
               notOrt (int)
               olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
     */
    public static void main(String[] args) {

        Universite bogazici = new Universite("bogazici", "matematik", 571, 93);
        Universite itu = new Universite("istanbul teknik", "matematik", 622, 81);
        Universite istanbul = new Universite("istanbul", "hukuk", 1453, 71);
        Universite marmara = new Universite("marmara", "bilgisayar muh", 1071, 77);
        Universite ytu = new Universite("yıldız teknik", "gemi", 333, 74);
        List<Universite> unv = new ArrayList<>(Arrays.asList(bogazici, itu, istanbul, marmara, ytu));

        System.out.println(notOrt74BykUnv(unv));
        System.out.println("\n ***");
        System.out.println(ogrcSayisi110Azmi(unv));
        System.out.println("\n ***");
        System.out.println(matBolumVarMı(unv));
        System.out.println("\n ***");
        System.out.println(ogrSayiBkSiralaVoid(unv));
        System.out.println("\n ***");
        notOrtBkSiralaİlkUc(unv);
        System.out.println("\n ***");
        System.out.println(enAzOgrcSayisi2Unv(unv));
        System.out.println("\n ***");
        System.out.println(notOrt63Buyuk(unv));
        System.out.println("\n ***");
        System.out.println(notOrt130danbuyuk(unv));
        System.out.println("\n ***");
        System.out.println(mathbolumsayısı(unv));
        System.out.println("\n ***");
        System.out.println(ogrncısysı571denykmaxNotOrt(unv));
        System.out.println("\n ***");
        System.out.println(ogrncısysı1071azminnotort(unv));


    }

    //task 01--> notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.
    public static boolean notOrt74BykUnv(List<Universite> unv) {

        return unv.
                stream().
                allMatch(t -> t.getNotOrt() > 74);
    }

    //task 02-->ogrc sayilarinin   110 den az olmadigini  kontrol eden pr create ediniz.
    public static boolean ogrcSayisi110Azmi(List<Universite> unv) {
        return unv.stream().allMatch(t -> t.getOgrSayisi() > 110);
    }

    //task 03-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.
    public static boolean matBolumVarMı(List<Universite> unv) {
        return unv.stream().anyMatch(t -> t.getBolum().contains("matematik"));
    }

    //task 04-->universite'leri ogr sayilarina gore b->k siralayiniz.
    public static List<Universite> ogrSayiBkSiralaVoid(List<Universite> unv) {
        return unv.stream().sorted(Comparator.comparing(Universite::getOgrSayisi).reversed()).collect(Collectors.toList());
//collect()->akısdaki elamanları istenen sarta gore toplar.
//Collectors.toList()->collect'e toplanan elemanlarilist'e cevirir.

    }

    //task 05-->universite'leri notOrt gore  b->k siralayip ilk 3 'unu print ediniz.
    public static void notOrtBkSiralaİlkUc(List<Universite> unv) {
        Collection<Universite> notOrtBkSiralaİlkUc = (Collection<Universite>) unv.stream().sorted(Comparator.comparing(Universite::getNotOrt).reversed()).limit(3).collect(Collectors.toList());
        System.out.println(notOrtBkSiralaİlkUc);


    }

    //task 05-->universite'leri notOrt gore  b->k siralayip ilk 3 'unu print ediniz.
    public static List<Universite> notOrtBkSialiIlkUc(List<Universite> unv) {
        return unv.
                stream().//akısa alındı
                        sorted(Comparator.comparing(Universite::getNotOrt).reversed()).//notOrt a göre b->k sıralandı
                        limit(3).//akısın ilk 3 elemanı alındı
                        collect(Collectors.toList());//akısın ilk 3 elemanı list'e assign edildi
    }
    //toList());//akısın ilk 3 elemanı list'e assign edildi


    //task 06--> ogrc sayisi en az olan 2. universite'yi  print ediniz.
    public static List<Universite> enAzOgrcSayisi2Unv(List<Universite> unv) {
        return unv.stream().sorted(Comparator.comparing(Universite::getOgrSayisi)).limit(2).skip(1).collect(Collectors.toList());
        //collect toplamak demek

    }

    //task 07--> notOrt 63 'den buyuk olan universite'lerin ogrc sayilarini toplamini print ediniz
    public static Optional<Integer> notOrt63Buyuk(List<Universite> unv) {
        return Optional.of(unv.stream().filter(t -> t.getNotOrt() > 63).map(t -> t.getOgrSayisi()).reduce(0, (a, b) -> a + b));
        //map ile uptade edildi unversite not ortalaması akarken ogrencı saysı akmaya basladı
        //reduce(Integer::sum);
        //reduce(math::addexact ) da toplamayı verir
    }

    //task 08--> Ogrenci sayisi 130'dan buyuk olan universite'lerin notOrt'larinin ortalamasini bulunuz.
    public static OptionalDouble notOrt130danbuyuk(List<Universite> unv) {
        //unv.stream().filter(t->t.getOgrSayisi()>130) .map(t->t.getNotOrt()).reduce(0,(a,b)->(a+b));
        return unv.stream().filter(t -> t.getOgrSayisi() > 130).mapToDouble(t -> t.getNotOrt()).average();//akıs elemanlarının ortalamsı alındı
        //akıs elmanlarını istenilen data type olarak degistirir
        //reduce a gerek kalmadı
    }

    //task 09-->"matematik" bolumlerinin sayisini  print ediniz.
    public static int mathbolumsayısı(List<Universite> unv) {
        return (int) unv.stream().filter(t -> t.getBolum().equals("matematik")).count();//=>count();akıstakı eleman sayısını returneder
    }

    //task 10-->Ogrenci sayilari 571'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz
    public static OptionalInt ogrncısysı571denykmaxNotOrt(List<Universite> unv) {
        return unv.stream().//akıs
                filter(t -> t.getOgrSayisi() > 571)//universite obje akısı filtrelendi
                .mapToInt(t -> t.getNotOrt())//akıstakı unv objesı not ortalaması akısı olarak update edildi
                .max();
    }

    //task 11-->Ogrenci sayilari 1071'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.
public static OptionalInt ogrncısysı1071azminnotort(List<Universite> unv){
    return     unv.stream().filter(t->t.getOgrSayisi()<1071).mapToInt(t->t.getNotOrt()).min();

}

}



