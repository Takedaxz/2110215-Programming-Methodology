package monkey;

import logic.game.GameSystem;

public class Ape extends BaseMonkey{
    public Ape(int maxHp,int atk,int def){
        super(maxHp,atk,def);
    }

    public void attack(BaseMonkey m){
        int damage = this.getAtk() - m.getDef();
        if (damage > 0){
            m.setHp(m.getHp() - damage);
        }
    }

    public void attackAOE(){
        GameSystem gameSys = GameSystem.getInstance();
        for (int i = 0; i < gameSys.getMonkeyContainer().size(); i++) {
            super.attack(gameSys.getMonkeyContainer().get(i));
        }
    }



}
