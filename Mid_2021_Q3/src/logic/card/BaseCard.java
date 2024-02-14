package logic.card;

import logic.player.Player;

public abstract class BaseCard {
    private String name;
    private int power;
    private int health;

    public BaseCard(String name,int power,int health){
        setName(name);
        setPower(power);
        setHealth(health);
    }

    public abstract void play(Player player);

    public abstract boolean canPlay(Player player);

    public int attack(BaseCard target){
        int newHp=target.getHealth()-this.getPower();
        if(newHp>=0) {
            target.setHealth(newHp);
            return 0;
        }
        else {
            target.setHealth(0);
            return -newHp;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = Math.max(0,power);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = Math.max(0,health);
    }
}
