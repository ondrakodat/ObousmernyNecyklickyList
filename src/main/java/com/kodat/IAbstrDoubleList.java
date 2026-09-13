package com.kodat;

import java.util.Iterator;

public interface IAbstrDoubleList<T> extends Iterable{
    void zrus();
    boolean jePrazdny();
    int mohutnost();

    void vlozPrvni(T data);
    void vlozNaslednika(T data);
    void vlozPredchudce(T data);

    T zpristupniAktualni();
    T zpristupniPrvni();
    T zpristupniPosledni();
    T zpristupniNaslednika();
    T zpristupniPredchudce();

    T odeberPrvni();
    T odeberAktualni();
    T odeberPosledni();
    T odeberNaslednika();
    T odeberPredchudce();

    Iterator<T> iterator();


}
