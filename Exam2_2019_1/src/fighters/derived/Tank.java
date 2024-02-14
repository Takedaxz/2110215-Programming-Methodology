package fighters.derived;

import fighters.base.Guardable;
import fighters.base.Unit;

public class Tank extends Unit implements Guardable {
    public Tank(int maxHealth,int speed,int defense,int location){
        super("Tank","t",maxHealth,speed,location,true);
    }
    @Override
    public void guard(){
        setOnGuard(true);
    }

    @Override
    public boolean move(int spaces){
        setOnGuard(false);
        return super.move(spaces);
    }
}
