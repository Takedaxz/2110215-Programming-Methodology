public class Dice {
    private int faceValue;
    public static final int MAX_VALUE=6;

    public Dice(){ //เมื่อไม่ได้ใส่ค่าเข้ามาก็จะเข้ามาอยู่ในเคสนี้
        this.faceValue=5;
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

    @Override
    public String toString() {
        return "Dice{" +
                "faceValue=" + faceValue +
                '}';
    }

    public int getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(int faceValue) {
        if(faceValue<1)
            this.faceValue=1;
        else if(faceValue>MAX_VALUE)
            this.faceValue=MAX_VALUE;
        else
            this.faceValue = faceValue;
    }

    public Dice(int faceValue) {
        this.faceValue = faceValue;
    }


}
