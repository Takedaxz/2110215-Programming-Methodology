package item.consumption;

import item.base.BaseConsumption;
import item.usage.CookState;
import item.usage.Cookable;
import item.usage.Healable;

import java.util.HashMap;

public class Pork extends BaseConsumption implements Cookable, Healable {
    private CookState cookState;
    private final HashMap<CookState, Integer> RECOVER_PT;

    public Pork() {
        super("Pork");
        setCookState(CookState.RAW);
        RECOVER_PT = new HashMap<CookState,Integer>();
        RECOVER_PT.put(CookState.RAW, 1);
        RECOVER_PT.put(CookState.COOKED, 2);
        RECOVER_PT.put(CookState.BURNT, 0);
    }
    @Override
    public int getRecoverPoint() {
        return RECOVER_PT.get(cookState);
    }
    @Override
    public CookState getCookState() {
        return cookState;
    }
    @Override
    public void setCookState(CookState cookState) {
        this.cookState = cookState;
    }

    @Override
    public String toString() {
        String state="";
        if(getCookState()==CookState.RAW)
            state="Raw";
        else if(getCookState()==CookState.COOKED)
            state="Cooked";
        else if(getCookState()==CookState.BURNT)
            state="Burnt";
        return state+ " " + getName() + " (+" + getRecoverPoint() + " HP)";
    }
}
