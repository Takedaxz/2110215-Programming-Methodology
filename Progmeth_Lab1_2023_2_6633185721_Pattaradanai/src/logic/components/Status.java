package logic.components;

import exception.BadStatusException;

public class Status {
    private int hp;
    private int durability;
    private int attack;
    private int magic;

    public Status(int hp, int durability, int attack, int magic) throws BadStatusException{
        setHp(hp);
        setDurability(durability);
        setAttack(attack);
        setMagic(magic);
    }

    public void setHp(int hp)throws BadStatusException{
        if(hp>=0) this.hp=hp;
        else throw new BadStatusException();
    }

    public void setDurability(int durability)throws BadStatusException{
        if(durability>=0) this.durability=durability;
        else throw new BadStatusException();
    }

    public void setAttack(int attack)throws BadStatusException{
        if(attack>=0) this.attack=attack;
        else throw new BadStatusException();
    }

    public void setMagic(int magic)throws BadStatusException{
        if(magic>=0) this.magic= magic;
        else throw new BadStatusException();
    }

    public int getHp(){
        return this.hp;
    }
    public int getAttack(){
        return this.attack;
    }
    public int getDurability(){
        return this.durability;
    }
    public int getMagic(){
        return this.magic;
    }

    public void addStatus(Status another) throws BadStatusException{
        this.hp+=another.hp;
        this.durability+=another.durability;
        this.attack+=another.attack ;
        this.magic+=another.magic ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Status status = (Status) o;

        if (hp != status.hp) return false;
        if (durability != status.durability) return false;
        if (attack != status.attack) return false;
        return magic == status.magic;
    }

}
