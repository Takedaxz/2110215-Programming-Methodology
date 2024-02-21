package logic.ghost;

import logic.game.GameController;
import utils.Config;

public class PongGhost extends HighGhost{
	//TODO implements here
    private int power;
    public PongGhost(){
        setPower(Config.PongGhostPower);
    }

    public PongGhost(int power){
        setPower(power);
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = Math.max(0,power);
    }
    @Override
    public int getLevel() {
        return Config.PongGhostLevel;
    }

    @Override
    public String toString() {
        return "PongGhost [HP: " + getHp() + " , Power: " + getPower() + "]";
    }

    @Override
    public void attack() {
        GameController player=GameController.getInstance();
        int newHp = player.getHp()-getPower();
        player.setHp(newHp);
    }
    @Override
    public void damage() {
        for (Ghost ghost : GameController.getInstance().getGhosts()) {
            if (ghost instanceof LowGhost) {
                ghost.decreaseHp(-getPower());
            }
        }
    }
}
