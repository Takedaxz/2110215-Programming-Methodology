package logic.ghost;

import logic.game.GameController;
import utils.Config;

public class GaGhost extends LowGhost{
	//TODO implements here
    private int energy;

    public GaGhost(){
        setEnergy(Config.GaGhostEnergy);
    }

    public GaGhost(int energy){
        setEnergy(energy);
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = Math.max(0,energy);
    }

    @Override
    public String toString() {
        return "GaGhost [HP: " + getHp() + " , Energy: " + getEnergy() + "]";
    }

    @Override
    public void attack() {
        GameController player=GameController.getInstance();
        int newHp = player.getHp()-getEnergy();
        player.setHp(newHp);
    }
	
}
