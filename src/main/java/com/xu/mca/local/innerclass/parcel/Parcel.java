package com.xu.mca.local.innerclass.parcel;

/**
 * java_study
 */
public class Parcel {
    class Contents{
        private int i = 11;
        public int value() {
            return i;
        }
    }
    class Destination{
        private String label;
        Destination(String whereTo) {
            label = whereTo;
        }
        String readLabel() {
            return label;
        }
    }
    public Destination to(String s) {
        return new Destination(s);
    }

    public Contents cont() {
        return new Contents();
    }

    public void ship(String dest) {
        Contents c = new Contents();
        Destination d = new Destination(dest);
    }

    public static void main(String[] args) {
        Parcel parcel = new Parcel();
        parcel.ship("bj");

        Parcel parcel1 = new Parcel();
        Parcel.Contents c = parcel.cont();
        Parcel.Destination d = parcel1.to("sh");
    }
}
