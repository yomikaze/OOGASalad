package engine.gridobject.person;

import java.awt.event.KeyEvent;
import java.util.List;

import engine.*;
import engine.gridobject.Building;
import engine.gridobject.GridObject;
import engine.world.SurroundingChecker;
import engine.world.Tile;

public class Player extends RuleFollower {
	

	public boolean aClick = false;
	//private KeyHandler myKeyHandler;
	private SurroundingChecker mySurroundingChecker;
	
	private boolean isAnimated = false;
	private String[] myAnimImages;
	private AbstractGameState myState;
	private boolean enterDoor;
	private double originalSpeed;
 
	
	public Player(String image, double speed, int numTilesWidth, int numTilesHeight) {
		super(image, speed, numTilesWidth, numTilesHeight);
		setMyItems(null);
		enterDoor=false;
		originalSpeed = this.getSpeed();
	}
	
//	public Player(String[] animImages, double speed, int numTilesWidth, int numTilesHeight) {
//		super(animImages, speed, numTilesWidth, numTilesHeight);
//		isAnimated = true;
//		myAnimImages = animImages;
//		myItems = null;
//	}
	
	public void setSurroundingsChecker(SurroundingChecker surroundingChecker){
		mySurroundingChecker = surroundingChecker;
	}
	public void getAnimImages(String[] animImages) {
		myAnimImages = animImages;
		isAnimated = true;
	}
	
	public void keyPressed(KeyEvent e) {
//		System.out.println("playerx: " + this.getX() + "playery: " + this.getY());
		if (e.getKeyCode() == AbstractGameState.UP){
			setDY(-super.getSpeed());
			GridObject surrounding = mySurroundingChecker.checkSurroundings(this);
			if(surrounding instanceof Building && ((Building) surrounding).playerAtDoor(this)){
				System.out.println("GO IN DOOR");
				((Building) surrounding).enterBuilding();
			}
		}
		if (e.getKeyCode() == AbstractGameState.DOWN)
			setDY(super.getSpeed());
		if (e.getKeyCode() == AbstractGameState.RIGHT)
			setDX(super.getSpeed());
		if (e.getKeyCode() == AbstractGameState.LEFT)
			setDX(-super.getSpeed());
		if (e.getKeyCode() == AbstractGameState.A) {
			GridObject surrounding = mySurroundingChecker.checkSurroundings(this);
			if(surrounding!=null)surrounding.doDialogue();
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == AbstractGameState.UP
				|| e.getKeyCode() == AbstractGameState.DOWN)
			setDY(0);

		if (e.getKeyCode() == AbstractGameState.RIGHT
				|| e.getKeyCode() == AbstractGameState.LEFT)
			setDX(0);
		if (e.getKeyCode() == AbstractGameState.A)
			aClick=false;
	}
	
	public boolean getAClick(){
		return aClick;
	}
	
	public double getOriginalSpeed(){
		return originalSpeed;
	}
	
	
}
