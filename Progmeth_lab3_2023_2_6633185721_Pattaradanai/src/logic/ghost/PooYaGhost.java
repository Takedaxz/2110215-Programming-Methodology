package logic.ghost;

import logic.game.GameController;
import utils.Config;

public class PooYaGhost extends HighGhost {
    private int power;

    public PooYaGhost(int power) {
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
        return Config.PooYaGhostLevel;
    }

    @Override
    public String toString() {
        return "PooYaGhost [HP: " + getHp() + " , Power: " + getPower() + "]";
    }

    @Override
    public void attack() {
        GameController player = GameController.getInstance();
        player.setHp(player.getHp()-getPower());
        player.setScore(player.getScore()-getPower());
    }

    @Override
    public void damage() {
        for (Ghost ghost : GameController.getInstance().getGhosts()) {
                ghost.decreaseHp(-getPower());
        }
    }
}
