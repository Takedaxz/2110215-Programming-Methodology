package logic.game;

import java.util.ArrayList;

import logic.actor.Actor;
import logic.actor.Villager;
import logic.ghost.Ghost;
import logic.item.Item;
import utils.GameUtils;

public class GameController {

	private int hp;
	private int score;
	private static GameController instance;
	private ArrayList <Actor> actors;
	private ArrayList <Ghost> ghosts;
	private ArrayList <Item> items;

	private void initGame(){
		setHp(10);
		setScore(0);
		addNewActor(new Villager());
		for (int i = 0; i < 10; i++) {
			addNewGhost(GameUtils.getRandomGhost(false));
		}
	}

	public void play(Actor selectedActor){
		for (Item item : items) {
			item.effect();
		}
		Ghost currentGhost = getGhosts().get(0);
		currentGhost.attack();
		selectedActor.attack();
		int ghostDie=0;
		for(int i=0;i<getGhosts().size();i++){
			if(getGhosts().get(i).isDestroyed()){
				setScore(getScore()+ghosts.get(i).getLevel());
				getGhosts().remove(i);
				ghostDie++;
				i--;
			}
		}
//		for (Ghost ghost : getGhosts()) {
//			if(ghost.isDestroyed()){
//				Ghost ghostTemp = ghost;
//				int index = ghosts.indexOf(ghost);
//				setScore(getScore()+ghostTemp.getLevel());
//				getGhosts().remove(index);
//				ghostDie++;
//			}
//		}
		for (int i = 0; i < ghostDie; i++) {
			addNewGhost(GameUtils.getRandomGhost(true));
		}
	}

	public boolean isGameOver(){
		return actors.isEmpty() || hp <= 0;
	}
	
	
	public GameController() {
		
		this.actors = new ArrayList <Actor> ();
		this.ghosts = new ArrayList <Ghost> ();
		this.items = new ArrayList <Item> ();
		initGame();
		
	}
	
	public static GameController getInstance() {
		if(instance == null)
			instance = new GameController();
		return instance;
	}
	public void updateGameController() {
		
		GameIO.showGameState();
		GameIO.showCurrentGhost(ghosts);
		Actor selectedActor = GameIO.selectActor(this.actors);
		GameIO.showItemList(this.items);

	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getScore() {
		return score;
	}
	public ArrayList<Ghost> getGhosts() {
		return ghosts;
	}
	public ArrayList<Actor> getActors() {
		return actors;
	}
	public ArrayList<Item> getItems() {
		return items;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public void addNewActor(Actor actor) {
		this.actors.add(actor);
	}
	public void addNewItem(Item item) {
		this.items.add(item);
	}
	public void addNewGhost(Ghost ghost) {
		this.ghosts.add(ghost);
	}

	/*
	This lab is quite challenging cuz i have to implement many classes HAHAHAH. (and pretty hard kub HAHAHA)
	My favorite TA is TA Tonsak cuz I saw him playing Valorant that was shown Discord Status.(HAHAHAH)
	Btw I don't talk to TA that much ,so I randomly chose TA.
	 */

	
}
