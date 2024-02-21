package logic.actor;

import logic.game.GameController;
import logic.ghost.Ghost;
import logic.ghost.HighGhost;
import logic.ghost.LowGhost;
import logic.item.Amulet;
import logic.item.Item;
import utils.Config;

public class Villager extends Actor{

    public Villager(){

    }
    @Override
    public int getLevel() {
        return Config.VillagerLevel;
    }

    @Override
    public void attack() {
        GameController player = GameController.getInstance();
        Ghost firstGhost = GameController.getInstance().getGhosts().get(0);
        boolean hasAmulet=false;
        if(firstGhost instanceof LowGhost){
            for(Item item: player.getItems()){
                if(item instanceof Amulet){
                    hasAmulet=true;
                    break;
                }
            }
            if(hasAmulet){
                firstGhost.decreaseHp(getLevel()+1);
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
