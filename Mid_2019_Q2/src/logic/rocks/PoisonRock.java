package logic.rocks;

import logic.zombies.Zombie;

public class PoisonRock extends NormalRock{
    private int damageOverTime;

    public int getDamageOverTime() {
        return damageOverTime;
    }

    public void setDamageOverTime(int damageOverTime) {
        this.damageOverTime = Math.max(0,damageOverTime);
    }

    public PoisonRock(int damage, int damageOverTime){
        super(damage);
        setDamageOverTime(damageOverTime);
    }

    public int dealDamage(Zombie zombie){
        zombie.setDecay(zombie.getDecay()+damageOverTime);
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
        return "PoisonRock (" + super.getDamage() + ", DoT = "+ getDamageOverTime() + ')';
    }
}
