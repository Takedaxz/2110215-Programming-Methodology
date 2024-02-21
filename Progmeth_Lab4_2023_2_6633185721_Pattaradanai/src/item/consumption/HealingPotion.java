package item.consumption;

import item.base.BaseConsumption;
import item.usage.Healable;
import item.usage.Upgradable;

public class HealingPotion extends BaseConsumption implements Healable, Upgradable {
    private int level;
    private final int MAX_LEVEL;
    private final int[] RECOVER_PT;

    public HealingPotion(){
        super("HealingPotion");
        setLevel(0);
        this.MAX_LEVEL=3;
        RECOVER_PT= new int[]{3, 5, 7, 10};

    }

    @Override
    public void setLevel(int level) {
        if (level >= 0 && level <= MAX_LEVEL) {
            this.level = level;
        } else {
            this.level = 0;
        }
    }

    @Override
    public String toString() {
        return getName()+" (+"+getRecoverPoint()+" HP, Level: "+getLevel()+")";
    }

    @Override
    public int getMaxLevel() {
        return MAX_LEVEL;
    }

    @Override
    public int getRecoverPoint() {
        return RECOVER_PT[getLevel()];
    }

    @Override
    public int getLevel(){
        return level;
    }
}
