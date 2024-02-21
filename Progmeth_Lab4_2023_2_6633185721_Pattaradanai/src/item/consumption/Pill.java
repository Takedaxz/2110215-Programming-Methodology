package item.consumption;


import item.base.BaseConsumption;
import item.usage.Healable;

public class Pill extends BaseConsumption implements Healable {
    private final int RECOVER_PT;

    public Pill() {
        super("Pill");
        this.RECOVER_PT = 2;
    }

    @Override
    public String toString(){

        return getName()+" (+"+getRecoverPoint()+" HP)";
    }

    @Override
    public int getRecoverPoint() {
        return RECOVER_PT;
    }
}
