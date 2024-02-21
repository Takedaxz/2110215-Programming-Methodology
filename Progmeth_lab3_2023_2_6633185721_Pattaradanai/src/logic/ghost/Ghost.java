package logic.ghost;

public abstract class Ghost {
    private int hp;

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = Math.max(0,hp);
    }

    public Ghost(int hp) {
        setHp(hp);
    }

    public boolean isDestroyed(){
        return getHp() <= 0;
    }

    public void decreaseHp(int amount){
        setHp(getHp()-amount);
    }

    public abstract int getLevel();

    public abstract void attack();


}

