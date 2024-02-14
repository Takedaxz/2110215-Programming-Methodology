package logic.rocks;

import logic.zombies.Zombie;

public class NormalRock {
    protected int damage;

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = Math.max(0,damage);
    }

    public NormalRock(int damage){
        setDamage(damage);
    }

    public int dealDamage(Zombie zombie){
        if(zombie.getDefense()>=getDamage()){
            return 0;
        }
        else{
            int reduceZombieHealth=getDamage()-zombie.getDefense();
            zombie.setHealth(zombie.getHealth()-reduceZombieHealth);
            return reduceZombieHealth;
        }
    }

    @Override
    public String toString() {
        return "NormalRock (" +  getDamage() + ')';
    }
}
