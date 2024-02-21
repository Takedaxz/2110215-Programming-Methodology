package logic.ghost;

import logic.game.GameController;
import utils.Config;

public class PryGhost extends LowGhost{
	private int power;
	private int ppt;

	public PryGhost(){
		setPower(Config.PryGhostPower);
		setPpt(0);
	}

	public PryGhost(int power) {
		setPower(power);
		setPpt(0);
	}

	public PryGhost(int power, int ppt) {
		setPower(power);
		setPpt(ppt);
	}

	@Override
	public String toString() {
		return "PryGhost [HP: " + getHp() + " , Power: " + getPower() + " , PPT: " + getPpt() + "]";
	}

	@Override
	public void attack() {
		GameController player=GameController.getInstance();
		int newHp = player.getHp()-(getPower()-getPpt());
		player.setHp(newHp);
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = Math.max(0,power);
	}

	public int getPpt() {
		return ppt;
	}

	public void setPpt(int ppt) {
		this.ppt = Math.max(0,ppt);
	}
}
