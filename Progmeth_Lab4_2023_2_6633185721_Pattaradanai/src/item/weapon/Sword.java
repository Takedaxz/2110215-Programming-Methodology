package item.weapon;

import item.base.BaseWeapon;
import item.usage.Upgradable;

public class Sword extends BaseWeapon implements Upgradable {

    private int level;
    private final int MAX_LEVEL;
    private final int[] ATT;

    public Sword() {
        super("Sword", 15, 1);
        setLevel(0);
        this.MAX_LEVEL=3;
        this.ATT=new int[]{3,5,8,12};
    }
    @Override
    public int getAtt() {

        return ATT[level];
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
        return getName() + " (Att: " + getAtt() + ", Range: " + getRange() + ", Level: " + getLevel() + ", " + getDurability() + " uses left)";
    }
    @Override
    public int getLevel() {
        return level;
    }
    @Override
    public int getMaxLevel() {
        return MAX_LEVEL;
    }

}
