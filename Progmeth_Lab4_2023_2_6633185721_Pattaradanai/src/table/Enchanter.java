package table;

import item.base.BaseItem;
import item.usage.Upgradable;

public class Enchanter extends BaseTable {

    public Enchanter() {
        super("Enchanter");
    }

    @Override
    public String interact(BaseItem item) {
        if (item instanceof Upgradable upgradableItem) {
            if (upgradableItem.getLevel()<upgradableItem.getMaxLevel()) {
                upgradableItem.setLevel(upgradableItem.getLevel() + 1);
                return "Upgrade successfully";
            }
            else{
                return "Already max level";
            }
        }

        // If it’s not an upgradable item
        return "This item cannot be upgraded";
    }
}
