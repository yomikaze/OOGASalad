package engine.gridobject.person;

import java.util.Map;
import java.util.Set;

import engine.dialogue.NPCResponseNode;
import engine.dialogue.UserQueryNode;
import engine.item.Item;

public class ShopKeeper extends NPC {
	Set<Item> myItemSet;

	/**
	 * Instantiates a new shop keeper.
	 *
	 * @param animImages the anim images
	 * @param name the name
	 * @param speed the speed
	 * @param numTilesWidth the num tiles width
	 * @param numTilesHeight the num tiles height
	 * @param movementType the movement type
	 * @param player the player
	 * @param itemSet the item set
	 */
	public ShopKeeper(String[] animImages, String name, double speed,
			int numTilesWidth, int numTilesHeight, int movementType,
			Player player, Set<Item> itemSet) {
		super(animImages, name, speed, numTilesWidth, numTilesHeight, movementType,
				player);
		myItemSet=itemSet;
		makeDialogue();

	}

	/**
	 * Make dialogue.
	 */
	private void makeDialogue(){
		NPCResponseNode n = new NPCResponseNode("What do you want to purchase?", null);
		
		for(Item item : myItemSet){
			NPCResponseNode n0 = new NPCResponseNode("You purchased a " + item.toString(), item);
			UserQueryNode q0 = new UserQueryNode(getPlayer(), null, item.toString(), n0);
			n.addResponseNode(q0);
			
		}
		this.setResponseNode(n);
	}


}
