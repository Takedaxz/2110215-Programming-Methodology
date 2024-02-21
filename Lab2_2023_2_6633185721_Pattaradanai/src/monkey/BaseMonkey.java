package monkey;
import logic.game.GameSystem;
public class BaseMonkey {
    private int maxHp;
    private int hp;
    private int atk;
    private int def;

    public BaseMonkey(){
        this.maxHp = 30;
        this.hp = this.maxHp;
        this.atk = 20;
        this.def = 5;
    }

    public BaseMonkey(int maxHp, int atk, int def) {
        setMaxHp(maxHp);
        setHp(maxHp);
        setAtk(atk);
        setDef(def);
    }

    public void attack(BaseMonkey m){
        int damage = this.getAtk() - m.getDef();
        if (damage > 0){
            m.setHp(m.getHp() - damage);
        }
    }

    public String getType(){
        return this.getClass().getSimpleName();
    }

    public String toString(){
        return this.getClass().getSimpleName()+" hp="+this.getHp()+", atk="+this.getAtk()+", def= "+this.getDef();
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = Math.max(maxHp, 0);
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if (hp<0){
            this.hp=0;
        }else {
            this.hp = Math.min(hp, maxHp);
        }
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = Math.max(0,atk);
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = Math.max(0,def);
    }

}
