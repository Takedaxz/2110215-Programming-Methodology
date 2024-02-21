package grader.student;

import java.util.ArrayList;
import java.util.List;

import logic.ghost.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.actor.Actor;
import logic.actor.GhostDoctor;
import logic.actor.Villager;
import logic.game.GameController;
import logic.game.GameIO;
import logic.item.Item;
import logic.item.Leklai;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {
    @Test
    void testPlayNotDestroyedGhost() {
        Actor actor = new Villager();
        
        Ghost g1 = new PooYaGhost(8);
        Ghost g2 = new GaGhost();
        Ghost g3 = new PryGhost();
        
        GameController.getInstance().getGhosts().clear();
        GameController.getInstance().getItems().clear();
        GameController.getInstance().addNewGhost(g1);
        GameController.getInstance().addNewGhost(g2);
        GameController.getInstance().addNewGhost(g3);
        
        GameController.getInstance().play(actor);
        
        assertEquals(g1, GameController.getInstance().getGhosts().get(0));
        assertEquals(3, GameController.getInstance().getGhosts().size());
    }
    
    @Test
    void testPlayDestroyedGhost() {
    	Actor actor = new GhostDoctor();

        Ghost g1=new PryGhost();
        Ghost g2=new MaBongGhost();
        Ghost g3=new PongGhost();

        GameController.getInstance().getGhosts().clear();
        GameController.getInstance().getItems().clear();
        GameController.getInstance().addNewGhost(g1);
        GameController.getInstance().addNewGhost(g2);
        GameController.getInstance().addNewGhost(g3);
        GameController.getInstance().play(actor);
        assertEquals(3,GameController.getInstance().getGhosts().size());
        assertEquals("MaBongGhost",GameController.getInstance().getGhosts().get(0).getClass().getSimpleName());

    }
    
    @Test
    void testPlayWithItem() {
    	Actor actor = new Villager();
        Item item = new Leklai();
        GameController.getInstance().addNewItem(item);
        GameController.getInstance().getGhosts().clear();
        GameController.getInstance().addNewGhost(new GaGhost());
        GameController.getInstance().addNewGhost(new PryGhost());
        GameController.getInstance().addNewGhost(new PooYaGhost(5));
        GameController.getInstance().play(actor);
        assertEquals(10,GameController.getInstance().getGhosts().get(0).getHp());
//        System.out.println(GameController.getInstance().getGhosts().get(0).getHp());
//        System.out.println(GameController.getInstance().getGhosts().get(1).getHp());
//        System.out.println(GameController.getInstance().getGhosts().get(2).getHp());

    }
    @Test
    void testIsGameOver() {
    	GameController.getInstance().setHp(15);
        GameController.getInstance().addNewActor(new GhostDoctor());
        assertFalse(GameController.getInstance().isGameOver());

        GameController.getInstance().getActors().clear();
        GameController.getInstance().setHp(15);
        assertTrue(GameController.getInstance().isGameOver());

        GameController.getInstance().getActors().clear();
        GameController.getInstance().setHp(-9);
        GameController.getInstance().addNewActor(new GhostDoctor());
        assertTrue(GameController.getInstance().isGameOver());

        GameController.getInstance().getActors().clear();
        GameController.getInstance().setHp(-43);
        assertTrue(GameController.getInstance().isGameOver());
    }

}