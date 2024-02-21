package logic.ghost;

import logic.game.GameController;
import utils.Config;

public class MaBongGhost extends LowGhost{
    private int power;
    private int speed;

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = Math.max(0,power);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = Math.max(0,speed);
    }

    public MaBongGhost(){
        setPower(Config.MaBongGhostPower);
        setSpeed(Config.MaBongGhostSpeed);

    }

    public MaBongGhost(int power){
        setPower(power);
        setSpeed(Config.MaBongGhostSpeed);
    }

    public MaBongGhost(int power,int speed){
        setPower(power);
        setSpeed(speed);
    }

    @Override
    public String toString() {
        return "MaBongGhost [HP: " + getHp() + " , Power: " + getPower() + " , Speed: " + getSpeed() + "]";
    }

    @Override
    public void attack() {
        GameController player=GameController.getInstance();
        int newHp = player.getHp()-(getPower()*getSpeed());
        player.setHp(newHp);
    }

}
