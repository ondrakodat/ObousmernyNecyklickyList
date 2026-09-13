package com.kodat;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        IAbstrDoubleList<String> listStringu = new AbstrDoubleList<>();
        System.out.printf("Je seznam po vytvoreni prazdny? : " + listStringu.jePrazdny() + "\n");
        for (int i = 1; i <= 50; i++) {
            listStringu.vlozNaslednika("Data s číslem : " + i);
        }
        System.out.printf("Pocet prvku v listu : " + listStringu.mohutnost() + "\n");
        System.out.println("Posledni prvek v listu : " + listStringu.zpristupniPosledni() + "\n");
        listStringu.odeberPosledni();
        System.out.printf("Posledni prvek v listu po odebrani : " + listStringu.zpristupniPosledni() + "\n");
        System.out.println("Pocet prvku v list : " + listStringu.mohutnost() + "\n");

        System.out.printf("Prvni prvek pred odebranim : " + listStringu.zpristupniPrvni() + "\n");
        listStringu.odeberPrvni();
        System.out.printf("Prvni prvek po odebrani : " + listStringu.zpristupniPrvni());
    }
}
