package item.armor;

import item.base.BaseArmor;
import item.usage.Upgradable;

public class Suit extends BaseArmor implements Upgradable {
    private int level;
    private final int MAX_LEVEL;
    private final int[] DEF;

    public Suit() {
        super("Suit", 10);
        setLevel(0);
        this.MAX_LEVEL=3;
        this.DEF = new int[]{1, 2, 3, 5};
    }

    @Override
    public int getDef() {
        return DEF[getLevel()];
    }
    @Override
    public int getLevel() {
        return level;
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
    public int getMaxLevel() {
        return MAX_LEVEL;
    }

    @Override
    public String toString() {
        return getName() + " (Def: " + getDef() + ", Level: " + getLevel() +")";
    }
}
