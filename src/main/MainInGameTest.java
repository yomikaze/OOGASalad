package main;


import GameView.GameSelectManager;
import authoring.WorldData;
import engine.gridobject.person.Player;
import engine.main.RPGEngine;
import engine.world.TitleWorld;

public class MainInGameTest extends RPGEngine {
	private WorldData myWorldData;

	public static void main(String[] args) {
		MainInGameTest engine = new MainInGameTest();
		engine.initializeGame();
		try {
			engine.doGameLoop();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void makeTitleScreen(){

		String[] anim = new String[]{"PlayerUp0.png", "PlayerUp1.png", "PlayerUp2.png", 
				"PlayerRight0.png", "PlayerRight1.png", "PlayerRight2.png",
				"PlayerDown0.png", "PlayerDown1.png", "PlayerDown2.png", "PlayerLeft0.png", 
				"PlayerLeft1.png", "PlayerLeft2.png"};

		Player player = new Player(anim, "Player", 2, new String[1], new String[1]);

		TitleWorld titleScreen = new TitleWorld(1000, 1000, null);
		titleScreen.setBackground("PokemonBackground.png");
		setWorld(titleScreen); // this is only called for the initial world
		GameSelectManager gsm = new GameSelectManager();
		System.out.println(gsm);
		player.setInteractionBox(gsm);
		
		//titleScreen.setMusic("/music/pokeTest.wav");
}

	@Override
	public void initializeGame() {
		setInit(true);
		//initMusicTest();
		initializeCanvas(500, 500);
		makeTitleScreen();
	}
}