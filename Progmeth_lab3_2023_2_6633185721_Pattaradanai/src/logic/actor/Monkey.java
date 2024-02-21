package logic.actor;

import logic.game.GameController;
import logic.ghost.Ghost;
import logic.ghost.LowGhost;
import logic.item.Amulet;
import logic.item.Banana;
import logic.item.Item;
import utils.Config;

public class Monkey extends Actor {

    public Monkey() {
    }

    @Override
    public int getLevel() {
        return Config.MonkeyLevel;
    }

    @Override
    public void attack() {
        GameController player = GameController.getInstance();
        Ghost firstGhost = GameController.getInstance().getGhosts().get(0);
        boolean hasBanana=false;
        if(firstGhost instanceof LowGhost){
            for(Item item: player.getItems()){
                if(item instanceof Banana){
                    hasBanana=true;
                    break;
                }
            }
            if(hasBanana){
                firstGhost.setHp(0);
            }
            else{
                firstGhost.decreaseHp(getLevel());
            }
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
