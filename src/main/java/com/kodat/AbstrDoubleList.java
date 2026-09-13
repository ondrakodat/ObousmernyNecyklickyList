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
        }
        if(data == null){
            throw new NullPointerException("Data jsou null!");
        }
        Uzel novyPrvek = new Uzel(data);

        //Mapovani odkazu nového prvk
        novyPrvek.naslednik = aktualni.naslednik;
        novyPrvek.predchudce = aktualni;

        //Mapovani odkazu stávajících prvků
        aktualni.naslednik.predchudce = novyPrvek;
        aktualni.naslednik = novyPrvek;

        if(aktualni == posledni){
            aktualni.naslednik = null;
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
        }

        Uzel novyPrvek = new Uzel(data);
        //Nastaveni noveho prvku
        novyPrvek.naslednik = aktualni;
        novyPrvek.predchudce = aktualni.predchudce;

        //Nastaveni stavajicich prvku
        aktualni.predchudce.naslednik = novyPrvek;
        aktualni.predchudce = novyPrvek;

        if(novyPrvek == hlava){
            novyPrvek.predchudce = null;
        }

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
        return null;
    }

    @Override
    public T odeberAktualni() {
        return null;
    }

    @Override
    public T odeberPosledni() {
        return null;
    }

    @Override
    public T odeberNaslednika() {
        return null;
    }

    @Override
    public T odeberPredchudce() {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
