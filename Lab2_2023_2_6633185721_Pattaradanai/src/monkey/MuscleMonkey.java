package monkey;

public class MuscleMonkey extends BaseMonkey {
    private final int POWER_UP=4;

    public MuscleMonkey(int maxHp,int atk,int def){
        super(maxHp,atk,def);
    }

    public void attack(BaseMonkey m){
        m.setHp(m.getHp()-this.getAtk()+m.getDef());
        m.setHp(m.getHp()-this.getAtk()+m.getDef());
    }

    public void buff(){
        setAtk(this.getAtk()+POWER_UP);
        setDef(this.getDef()+POWER_UP);
    }
}
