package com.xu.mca.local.interfaces;

/**
 * java_study
 */
public class Music {
    static void tune(Instrument instrument) {
        instrument.play();
    }

    static void tuneAll(Instrument[] instruments) {
        for (Instrument instrument : instruments) {
            instrument.play();
        }
    }

    public static void main(String[] args) {
        Instrument[] instruments = new Instrument[2];
        int i = 0;
        instruments[i++] = new Brass();
        instruments[i++] = new Wind();
        tuneAll(instruments);

        long a = 100000;
        System.out.println(a * a * a * a);
//        hurt=(long)(strongHurtRate*crossRbData.getProp(Prop.ATT) * crossRbData.getProp(Prop.RB_ATT_PLAYER)*crossRbData.getProp(Prop.RB_ATT_PLAYER) /(crossRbData.getProp(Prop.RB_ATT_PLAYER)+target.getProp(Prop.RB_ATT_DEF)))/PlayerCons.Prop_MULTI +crossRbData.getProp(Prop.RB_HURT_PLAYER);

        long att = 16449622;
        long pAtt= 6000;
        long attDef = 0;
        long hurtPlayer = 60000;
        double rate = 1.0d;
        long result = (long)((rate * att * pAtt * pAtt)/(pAtt + attDef))/10000 + hurtPlayer;
        System.out.println(result);
    }
}
