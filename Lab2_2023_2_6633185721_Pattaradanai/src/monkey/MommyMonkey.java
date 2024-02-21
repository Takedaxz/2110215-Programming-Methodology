package monkey;

import logic.game.GameSystem;

public class MommyMonkey extends BaseMonkey{
    public MommyMonkey(int maxHp,int atk,int def){
        super(maxHp,atk,def);
    }

    public void attack(BaseMonkey m){

    }

    public void birth() {
        BaseMonkey newMonkey = new BaseMonkey();
        GameSystem gameSys = GameSystem.getInstance();
        gameSys.getMonkeyContainer().add(newMonkey);
    }
}
