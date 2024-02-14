package logic.card;

import logic.player.Player;

public class MageCard extends BaseCard{
    private Element mageType;
    public MageCard(String name, int power, int health,Element mageType) {
        super(name, power, health);
        setMageType(mageType);
    }

    @Override
    public void play(Player player) {
        int count=0;
        for(BaseCard c : player.getField()) {
            if (c instanceof OrbCard oc)
                if(oc.getOrbType()==this.getMageType())
                    count++;
        }
        this.setPower(this.getPower()+count);
    }

    @Override
    public boolean canPlay(Player player) {
        for(BaseCard c : player.getField()) {
            if (c instanceof OrbCard oc)
                if(oc.getOrbType()==this.getMageType())
                    return true;
        }
        return false;
    }

    public Element getMageType() {
        return mageType;
    }

    public void setMageType(Element mageType) {
        this.mageType = mageType;
    }
}
