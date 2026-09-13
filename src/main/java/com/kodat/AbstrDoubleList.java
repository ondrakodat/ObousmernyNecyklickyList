package com.kodat;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Iterator;


public class AbstrDoubleList<T> implements IAbstrDoubleList<T>{
    Uzel hlava;
    Uzel aktualni;
    Uzel posledni;
    int pocetPrvku;

    class Uzel {
        T data;
        Uzel naslednik;
        Uzel predchudce;

        public Uzel(T data) {
            this.data = data;
            this.naslednik = null;
            this.predchudce = null;
        }
    }


    @Override
    public void zrus() {
        pocetPrvku = 0;
        hlava = null;
        aktualni = null;
        posledni = null;
    }

    @Override
    public boolean jePrazdny() {
       return hlava == null ? true : false;
    }

    @Override
    public int mohutnost() {
        return pocetPrvku;
    }

    @Override
    public void vlozPrvni(T data) {
        if(jePrazdny()){
            hlava = new Uzel(data);
            aktualni = hlava;
            posledni = hlava;
            pocetPrvku++;
        }
    }

    @Override
    public void vlozNaslednika(T data) {
        if(jePrazdny()){
            vlozPrvni(data);
            return;
        }
        if(data == null){
            throw new NullPointerException("Data jsou null!");
        }
        Uzel novyPrvek = new Uzel(data);
        if(aktualni == posledni){
            aktualni.naslednik = novyPrvek;
            novyPrvek.predchudce = aktualni;
            posledni = novyPrvek;
        }else{
        //Mapovani odkazu nového prvk
        novyPrvek.naslednik = aktualni.naslednik;
        novyPrvek.predchudce = aktualni;

        //Mapovani odkazu stávajících prvků
        aktualni.naslednik.predchudce = novyPrvek;
        aktualni.naslednik = novyPrvek;
        }
        aktualni = novyPrvek;
        pocetPrvku++;
    }

    @Override
    public void vlozPredchudce(T data) {
        if(data == null){
            throw new NullPointerException("Data jsou null!");
        }
        if(jePrazdny()){
            vlozPrvni(data);
            return;
        }
        Uzel novyPrvek = new Uzel(data);
        if(aktualni == hlava){
            aktualni.predchudce = novyPrvek;
            novyPrvek.naslednik = aktualni;
            hlava = novyPrvek;
            aktualni = novyPrvek;
            pocetPrvku++;
            return;
        }
        //Nastaveni noveho prvku
        novyPrvek.naslednik = aktualni;
        novyPrvek.predchudce = aktualni.predchudce;

        //Nastaveni stavajicich prvku
        aktualni.predchudce.naslednik = novyPrvek;
        aktualni.predchudce = novyPrvek;



        aktualni = novyPrvek;
        pocetPrvku++;

    }

    @Override
    public T zpristupniAktualni() {
        if(aktualni == null){
            throw new NullPointerException("Aktualni je null");
        }
        return aktualni.data;
    }

    @Override
    public T zpristupniPrvni() {
        if(jePrazdny()){
            throw new RuntimeException("Seznam je prazdny");
        }
        if(hlava == null){
            throw new NullPointerException("Prvni je null");
        }
        return hlava.data;
    }

    @Override
    public T zpristupniPosledni() {
        if(jePrazdny()){
            throw new RuntimeException("Seznam je prazdny");
        }
        if(posledni == null){
            throw new NullPointerException("Posledni je null");
        }
        return posledni.data;
    }

    @Override
    public T zpristupniNaslednika() {
        if(jePrazdny()){
            throw new RuntimeException("Seznam je prazdny");
        }
        if(aktualni.naslednik == null){
            throw new NullPointerException("Posledni je null");
        }
        return aktualni.naslednik.data;
    }

    @Override
    public T zpristupniPredchudce() {
        if(jePrazdny()){
            throw new RuntimeException("Seznam je prazdny");
        }
        if(aktualni.predchudce == null){
            throw new NullPointerException("Posledni je null");
        }
        return aktualni.predchudce.data;
    }

    @Override
    public T odeberPrvni() {
        if(jePrazdny()){
            throw new RuntimeException("Seznam je prazdny");
        }
        Uzel prvekNavraceni = hlava;
        //pokud je prvni zaroven posledni tak mame seznam o jednom prvku a tedy muzeme rovnou zrusit celej
        if(hlava == posledni){
            zrus();
            return prvekNavraceni.data;
        }else {

            hlava.naslednik.predchudce = null;
            hlava = hlava.naslednik;
            pocetPrvku--;
            return prvekNavraceni.data;
        }
    }

    @Override
    public T odeberAktualni() {
        if(jePrazdny()){
            throw new RuntimeException("Seznam je prazdnej nejde nic odebrat");
        }
        Uzel prvekNaVraceni = aktualni;

        if(aktualni == hlava && aktualni == posledni){
            zrus();
            return prvekNaVraceni.data;
        }
        else if(aktualni == hlava){
            odeberPrvni();
            return prvekNaVraceni.data;
        }
        else if(aktualni == posledni){
            odeberPosledni();
            return prvekNaVraceni.data;
        }else{
            aktualni.naslednik.predchudce = aktualni.predchudce;
            aktualni.predchudce.naslednik = aktualni.naslednik;
            pocetPrvku--;

            //aktualni = null;
            //Muzeme ho hodit klido na null, ale Java by ho měla automaticky odstranit aby nevysel v paměti
            //V jazyku C nicméně by sme ho museli mazat ručne pomoci např. free
        }
        return prvekNaVraceni.data;
    }

    @Override
    public T odeberPosledni() {
        if(jePrazdny()){
            throw new RuntimeException("Seznam je prazdnej nejde nic odebrat");
        }
        Uzel prvekNaVraceni = posledni;
        if(posledni == hlava){
            zrus();
            return  prvekNaVraceni.data;
        }
        posledni = posledni.predchudce;
        posledni.predchudce.naslednik = null;
        posledni.naslednik = null;
        pocetPrvku--;
        return prvekNaVraceni.data;
    }

    @Override
    public T odeberNaslednika() {
        if(jePrazdny()){
            throw new RuntimeException("Seznam je prazdny");
        }
        if(aktualni.naslednik == null){
            throw new NullPointerException("Naslednik neexistuje");
        }
        Uzel prvekNaVraceni = aktualni.naslednik;
        if(aktualni == hlava && aktualni == posledni){
            zrus();
        } else if (aktualni == hlava && aktualni.naslednik == posledni) {
            aktualni.naslednik = null;
            posledni = aktualni;
        }else if (aktualni.naslednik == posledni){
            odeberPosledni();
        } else{
            aktualni.naslednik.naslednik.predchudce = aktualni;
            aktualni.naslednik = aktualni.naslednik.naslednik;
            pocetPrvku--;

        }
        return prvekNaVraceni.data;
    }

    @Override
    public T odeberPredchudce() {
        if(jePrazdny()){
            throw new RuntimeException("Seznam je prazdny");
        }
        if(aktualni.predchudce == null){
            throw new NullPointerException("Predchudce neexistuje");
        }
        Uzel prvekNaVraceni = aktualni.predchudce;
        if(aktualni == hlava && aktualni == posledni){
            zrus();
        }else{
            aktualni.predchudce.predchudce.naslednik = aktualni;
            aktualni.predchudce = aktualni.predchudce.predchudce;
        }
        pocetPrvku--;
        return prvekNaVraceni.data;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Uzel prvekProIterator = hlava;

            @Override
            public boolean hasNext() {
                return prvekProIterator != null;
            }

            @Override
            public T next() {
                if(hasNext()){
                    T data = prvekProIterator.data;
                    prvekProIterator = prvekProIterator.naslednik;
                    return data;
                }else{
                    throw new RuntimeException("Neni dalsi prvek");
                }

            }
        };
    }
}
