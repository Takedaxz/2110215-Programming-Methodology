package logic.components;

import exception.BadStatusException;

import java.util.ArrayList;

public class Player {
    private String name;
    private Status status;
    private int energy;
    private int money;
    public Player(String name, Status status){
        try{
            status.setHp(Math.max(status.getHp(),1));
        } catch (BadStatusException e){
            throw new RuntimeException(e);
        }

        setName(name);
        setStatus(status);
        setEnergy(10);
        setMoney(100);

        foods=new ArrayList<Food>();
        potions=new ArrayList<Potion>();
        ores=new ArrayList<Ore>();
    }
    public Player(String name, Status status, int energy, int money){
        try{
            status.setHp(Math.max(status.getHp(),1));
        } catch (BadStatusException e){
            throw new RuntimeException(e);
        }

        setName(name);
        setStatus(status);
        setEnergy(energy);
        setMoney(money);

        foods=new ArrayList<Food>();
        potions=new ArrayList<Potion>();
        ores=new ArrayList<Ore>();
    }
    public boolean buyOre(Ore ore){
        if(this.money>=ore.getCost()){
            setMoney(getMoney()-ore.getCost());
            ores.add(ore);
            return true;
        }
        return false;
    }
    public void drinkPotion(int index){
        if(index<potions.size() && index>=0){
            try{
                this.status.setHp(status.getHp()+potions.get(index).getIncreasingStatus().getHp());
            } catch(BadStatusException e){
                throw new RuntimeException(e);
            }
            try{
                this.status.setMagic(status.getMagic()+potions.get(index).getIncreasingStatus().getMagic());
            } catch(BadStatusException e){
                throw new RuntimeException(e);
            }
            try{
                this.status.setAttack(status.getAttack()+potions.get(index).getIncreasingStatus().getAttack());
            } catch(BadStatusException e){
                throw new RuntimeException(e);
            }
            try{
                this.status.setDurability(status.getDurability()+potions.get(index).getIncreasingStatus().getDurability());
            } catch(BadStatusException e){
                throw new RuntimeException(e);
            }

            potions.remove(index);
        }
    }
    public void eatFood(int index){
        if(index<foods.size() && index>=0){
            this.setEnergy(this.getEnergy()+foods.get(index).getEnergy());
            foods.remove(index);
        }
    }
    public void sellPotion(int index){
        if(index<potions.size() && index>=0){
            this.setMoney(this.getMoney()+potions.get(index).getPrice());
            potions.remove(index);
        }
    }
    public void sellFood(int index){
        if(index<foods.size() && index>=0){
            this.setMoney(this.getMoney()+foods.get(index).getPrice());
            foods.remove(index);
        }
    }
    public void attack(Monster monster){
        Status temp=monster.getStatus();
        if(monster.getStatus().getDurability()>=this.status.getAttack()){
            try{
                temp.setDurability(temp.getDurability()-this.status.getAttack());
            } catch(BadStatusException e){
                throw new RuntimeException(e);
            }
        }
        else{
            int trueDmg=this.status.getAttack()-monster.getStatus().getDurability();
            try{
                temp.setDurability(0);
            } catch(BadStatusException e){
                throw new RuntimeException(e);
            }
            try{
                temp.setHp(Math.max(0,temp.getHp()-trueDmg));
            } catch(BadStatusException e){
                throw new RuntimeException(e);
            }
        }
        monster.setStatus(temp);
    }
    public void magicAttack(Monster monster){
        Status temp=monster.getStatus();
        try{
            temp.setHp(Math.max(temp.getHp()-this.status.getMagic(),0));
        } catch(BadStatusException e){
            throw new RuntimeException(e);
        }
        monster.setStatus(temp);
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

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = Math.max(0,energy);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = Math.max(0,money);
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public ArrayList<Potion> getPotions() {
        return potions;
    }

    public void setPotions(ArrayList<Potion> potions) {
        this.potions = potions;
    }

    public ArrayList<Ore> getOres() {
        return ores;
    }

    public void setOres(ArrayList<Ore> ores) {
        this.ores = ores;
    }

    private ArrayList<Food> foods;
    private ArrayList<Potion> potions;
    private ArrayList<Ore> ores;



}
