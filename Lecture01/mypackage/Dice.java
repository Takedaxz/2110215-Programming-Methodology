package mypackage;

public class Dice {
    public final static int MAX=6;
    private int faceValue;


    public Dice(int faceValue) {
        this.faceValue = faceValue;
    }

    public int getFaceValue() {
        return faceValue;
    }

    @Override
    public String toString() {
        return "Dice{" +
                "faceValue=" + faceValue +
                '}';
    }

    public void setFaceValue(int faceValue) {
        this.faceValue = faceValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dice dice = (Dice) o;

        return faceValue == dice.faceValue;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public Dice() {
        this.faceValue = 1;
    }
}
