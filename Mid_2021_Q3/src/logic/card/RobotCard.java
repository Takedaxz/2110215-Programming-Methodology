package logic.card;

import logic.player.Player;

public class RobotCard extends BaseCard{
    private int energyCost;

    public RobotCard(String name, int power, int health,int energyCost){
        super(name,power,health);
        setEnergyCost(energyCost);
    }


    @Override
    public void play(Player player) {
        int playerEnergy=player.getEnergy()-this.getEnergyCost();
        player.setEnergy(playerEnergy);
    }

    @Override
    public boolean canPlay(Player player) {
        return player.getEnergy()>=this.getEnergyCost();
    }

    public int getEnergyCost() {
        return energyCost;
    }

    public void setEnergyCost(int energyCost) {
        this.energyCost = Math.max(0,energyCost);
    }
}
