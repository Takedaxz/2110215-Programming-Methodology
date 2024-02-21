package logic.components;

import exception.BadStatusException;

public class Monster {
    private String name;
    private Status status;
    private Food food;
    private Potion potion;

    public Monster(String name, Status status){
        try {
            status.setHp(Math.max(1,status.getHp()));
        } catch (BadStatusException e) {
            throw new RuntimeException(e);
        }
        setName(name);
        setStatus(status);
    }

    public void attack(Player player){
        Status temp=player.getStatus();
        if(player.getStatus().getDurability()>=this.status.getAttack()){
            try{
                temp.setDurability(temp.getDurability()-this.status.getAttack());
            } catch (BadStatusException e){
                throw new RuntimeException(e);
            }
        }
        else{
            int trueDmg=this.status.getAttack()-player.getStatus().getDurability();
            try{
                temp.setDurability(0);
            } catch (BadStatusException e){
                throw new RuntimeException(e);
            }
            try{
                temp.setHp(Math.max(0,temp.getHp()-trueDmg));
            } catch (BadStatusException e){
                throw new RuntimeException(e);
            }
        }

        player.setStatus(temp);
    }

    public void magicAttack(Player player){
        Status temp=player.getStatus();
        try{
            temp.setHp(Math.max(temp.getHp()-this.status.getMagic(),0));
        } catch (BadStatusException e){
            throw new RuntimeException(e);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Potion getPotion() {
        return potion;
    }

    public void setPotion(Potion potion) {
        this.potion = potion;
    }
}
