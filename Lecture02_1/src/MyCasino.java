import java.sql.SQLOutput;

public class MyCasino {
    public static void main(String[] args) {
        Dice d1 = new Dice(3); //สั่งจองเนื้อที่
        Dice d2 = new Dice();
        Dice d3 = new Dice(3);
        System.out.println(d1.getFaceValue());
        System.out.println(d1);
        System.out.println(d2.getFaceValue());
        System.out.println(d1);

        System.out.println(d1.equals(d2));
        System.out.println(d1.equals(d3));
    }
}
