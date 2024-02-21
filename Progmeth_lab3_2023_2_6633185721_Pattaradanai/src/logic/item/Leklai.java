package logic.item;

import logic.game.GameController;
import logic.ghost.Ghost;
import logic.ghost.HighGhost;
import logic.ghost.LowGhost;
import utils.Config;

public class Leklai extends Item{

    public Leklai(){

    }
    @Override
    public int getLevel() {
        return Config.LeklaiLevel;
    }

    @Override
    public void effect() {
        for(Ghost ghost:GameController.getInstance().getGhosts()){
            if(ghost.getLevel()<=getLevel()){
                if(ghost instanceof LowGhost){
                    ghost.decreaseHp(5);
                }
                else if(ghost instanceof HighGhost){
                    ghost.decreaseHp(4);
                }
            }
        }
    }

    @Override
    public String toString(){
        return this.getClass().getSimpleName();
    }


}
