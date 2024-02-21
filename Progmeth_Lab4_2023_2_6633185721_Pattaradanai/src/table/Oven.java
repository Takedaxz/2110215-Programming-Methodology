package table;

import item.base.BaseItem;
import item.usage.CookState;
import item.usage.Cookable;

public class Oven extends BaseTable{

    public Oven() {
        super("Oven");
    }

    @Override
    public String interact(BaseItem item) {
        if (item instanceof Cookable cookable) {
            CookState currentState =cookable.getCookState();
            if(currentState==CookState.RAW){
                ((Cookable) item).setCookState(CookState.COOKED);
                return "Cooking succeed";
            }
            else if (currentState==CookState.COOKED) {
                ((Cookable) item).setCookState(CookState.BURNT);
                return "Your food has been burnt";
            } else if (currentState==CookState.BURNT) {
                return "Your food is already burnt, cannot be cooked anymore";

            }
        }

        // If it’s not a cookable item
        return "This item cannot be cooked";
    }
    }
