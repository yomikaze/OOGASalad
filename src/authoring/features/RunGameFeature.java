package authoring.features;
import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;


import GameView.Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ Pritam M.
 */
public class RunGameFeature extends Feature implements ActionListener {

    private Main mainGame;

    public RunGameFeature(){
        mainGame = new Main();
        BasicArrowButton playButton = new BasicArrowButton(SwingConstants.EAST);
        playButton.setActionCommand("play");
        playButton.addActionListener(this);
        myComponents.put(playButton, BorderLayout.NORTH);
    }

    public void runGame(){
        mainGame.startEngine();
     
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        runGame();
    }
}
