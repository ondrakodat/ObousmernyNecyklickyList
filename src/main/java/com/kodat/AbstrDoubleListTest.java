package com.kodat;


import org.junit.Assert;
import org.junit.Test;

public class AbstrDoubleListTest {
    @Test
    public void otestujDekleraciAPrazdnySeznam(){
        AbstrDoubleList<String> testyString = new AbstrDoubleList();
        Assert.assertTrue(testyString.jePrazdny());
        System.out.printf("Seznam ma : " + testyString.mohutnost() + " prvků. \n" );
        testyString.vlozPrvni("PrvniPrvek");
        testyString.vlozPrvni("DruhyPrvek");
        testyString.vlozPrvni("TretiPrvek");
        Assert.assertFalse(testyString.jePrazdny());
        System.out.printf("Seznam ma : " + testyString.mohutnost() + " prvků." );
    }
    @Test
    public void OtestujPoradiPrvku(){
        AbstrDoubleList<String> testyString = new AbstrDoubleList();
        testyString.vlozPrvni("PrvniPrvek");
        testyString.vlozPrvni("DruhyPrvek");
        testyString.vlozPrvni("TretiPrvek");

        String ocekavanyPosledniPrvek = "PrvniPrvek";
        String ocekavanyPrvniPrvek = "TretiPrvek";
        String aktualniPosledniPrvek = testyString.zpristupniPosledni();
        String aktualniPrvniPrvek = testyString.zpristupniPrvni();
        System.out.println("Posledni prvek je : " + ocekavanyPosledniPrvek);
        Assert.assertEquals(ocekavanyPrvniPrvek, aktualniPrvniPrvek);
        Assert.assertEquals(ocekavanyPosledniPrvek, aktualniPosledniPrvek);
    }
    @Test
    public void OtestujOdebiraniPoslednihoPrvku(){
        AbstrDoubleList<String> testyString = new AbstrDoubleList();
        testyString.vlozPrvni("PrvniPrvek");
        testyString.vlozPrvni("DruhyPrvek");
        testyString.vlozPrvni("TretiPrvek");
        int ocekavanyPocetPrvku = 3;
        //System.out.println("Pocet prvků v testyString odebiraniPoslednihoPrvku : " + testyString.mohutnost());
        Assert.assertEquals(ocekavanyPocetPrvku, testyString.mohutnost());
        //Testovani odebirani prvku
        String ocekavanyOdebranyPosledniPrvek = "PrvniPrvek";
        String ocekavanyOdebranyPosledniPrvek2 = "DruhyPrvek";
        String ocekavanyOdebranyPosledniPrvek3 = "TretiPrvek";

        String aktualniOdebranyPosledniPrvek = testyString.odeberPosledni();
        String aktualniOdebranyPosledniPrvek2 = testyString.odeberPosledni();
        String aktualniOdebranyPosledniPrvek3 = testyString.odeberPosledni();

        Assert.assertEquals(ocekavanyOdebranyPosledniPrvek, aktualniOdebranyPosledniPrvek);
        Assert.assertEquals(ocekavanyOdebranyPosledniPrvek2, aktualniOdebranyPosledniPrvek2);
        Assert.assertEquals(ocekavanyOdebranyPosledniPrvek3, aktualniOdebranyPosledniPrvek3);

        int ocevanyPocetPrvkuPoOdebrani = 0;
        int aktualniPocetPrvkuPoOdebrani = testyString.mohutnost();

        Assert.assertEquals(ocevanyPocetPrvkuPoOdebrani, aktualniPocetPrvkuPoOdebrani);

    }

    @Test
    public void OtestujOdebiraniPrvnihoPrvku(){
        AbstrDoubleList<String> testyString = new AbstrDoubleList();
        testyString.vlozPrvni("PrvniPrvek");
        testyString.vlozPrvni("DruhyPrvek");
        testyString.vlozPrvni("TretiPrvek");

        String ocekavanyOdebranyPrvniPrvek1 = "TretiPrvek";
        String ocekavanyOdebranyPrvniPrvek2 = "DruhyPrvek";
        String ocekavanyOdebranyPrvniPrvek3 = "PrvniPrvek";

        String aktualniOdebranyPrvniPrvek1 = testyString.odeberPrvni();
        String aktualniOdebranyPrvniPrvek2 = testyString.odeberPrvni();
        String aktualniOdebranyPrvniPrvek3 = testyString.odeberPrvni();

        Assert.assertEquals(ocekavanyOdebranyPrvniPrvek1, aktualniOdebranyPrvniPrvek1);
        Assert.assertEquals(ocekavanyOdebranyPrvniPrvek2, aktualniOdebranyPrvniPrvek2);
        Assert.assertEquals(ocekavanyOdebranyPrvniPrvek3, aktualniOdebranyPrvniPrvek3);
    }

    @Test
    public void OtestujOdebraniNaslednika(){
        AbstrDoubleList<String> testyString = new AbstrDoubleList();
        testyString.vlozPrvni("PrvniPrvek");
        testyString.vlozPrvni("DruhyPrvek");
        testyString.vlozPrvni("TretiPrvek");

        String ocekavanyOdebranyPrvniPrvek1 = "TretiPrvek";
        String ocekavanyOdebranyPrvniPrvek2 = "DruhyPrvek";
        String ocekavanyOdebranyPrvniPrvek3 = "PrvniPrvek";
        testyString.zpristupniPrvni();

        String aktualniOdebranyPrvniPrvek1 = testyString.odeberAktualni();
        String aktualniOdebranyPrvniPrvek2 = testyString.odeberAktualni();
        String aktualniOdebranyPrvniPrvek3 = testyString.odeberAktualni();


        Assert.assertEquals(ocekavanyOdebranyPrvniPrvek1, aktualniOdebranyPrvniPrvek1);
        Assert.assertEquals(ocekavanyOdebranyPrvniPrvek2, aktualniOdebranyPrvniPrvek2);
        Assert.assertEquals(ocekavanyOdebranyPrvniPrvek3, aktualniOdebranyPrvniPrvek3);

    }

    @Test
    public void OtestujOdebraniPredchudce(){
        AbstrDoubleList<String> testyString = new AbstrDoubleList();
        testyString.vlozPrvni("PrvniPrvek");
        testyString.vlozPrvni("DruhyPrvek");
        testyString.vlozPrvni("TretiPrvek");

        String ocekavanyOdebranyPrvniPrvek1 = "DruhyPrvek";
        String ocekavanyOdebranyPrvniPrvek2 = "TretiPrvek";
        testyString.zpristupniPosledni();
        String aktualniOdebranyPrvniPrvek1 = testyString.odeberPredchudce();
        String aktualniOdebranyPrvniPrvek2 = testyString.odeberPredchudce();

        Assert.assertEquals(ocekavanyOdebranyPrvniPrvek1, aktualniOdebranyPrvniPrvek1);
        Assert.assertEquals(ocekavanyOdebranyPrvniPrvek2, aktualniOdebranyPrvniPrvek2);
        Assert.assertThrows(RuntimeException.class,() -> testyString.odeberPredchudce());

    }


}
