package authoring;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.*;
/*
public class GridObjectCreation extends Feature{
	
	private JButton myGridObjectButton;
	private List<Feature> myGridFeatures;
	private AuthoringView gridObjectView;
	private GridObjectImageEditor imageEditor=new GridObjectImageEditor();
	
	public GridObjectCreation(){
		myGridFeatures = new ArrayList<Feature>();
		myGridFeatures.add(new GridObjectCoordinateFeature(this));
		myGridFeatures.add(new GridObjectImageFeature(this));
		myGridFeatures.add(new DialogueFeature(this));
		
		myGridObjectButton = new JButton("New GridObject");
		myGridObjectButton.addActionListener(new GridObjectWindowAction());
		imageEditor.setSuperFeature(this);
		myComponents.put(myGridObjectButton, BorderLayout.SOUTH);
		//gridObjectView = new AuthoringView(myGridFeatures, false);
	}
	public AuthoringView getView(){
		return gridObjectView;
	}
	private class GridObjectWindowAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			gridObjectView = new AuthoringView(myGridFeatures, false);
			imageEditor.imageRefresh();
			imageEditor.setVisible(true);
		}	
	}
	public Feature getFeature(String s){
		Feature myFeature=null;
		for(Feature f: myGridFeatures){
			if(f.getClass().getSimpleName().equals(s))
				myFeature = f;
		}
		return myFeature;
	}
	*/
	/*
	private JButton myGridObjectButton;
	private List<Feature> myGridFeatures;
	private GridObjectData myData;
	private AuthoringView gridObjectView;
	private GridObjectImageEditor imageEditor=new GridObjectImageEditor();
	
	public GridObjectCreation(){
		myData = new GridObjectData();
		
		myGridFeatures = new ArrayList<Feature>();
		//myGridFeatures.add(new EncounterableFeature(this));
		myGridFeatures.add(new SaveGridObjectFeature(this));
		myGridFeatures.add(new SteppableFeature(this));
		myGridFeatures.add(new GridObjectCoordinateFeature(this));
		myGridFeatures.add(new GridObjectImageFeature(this));
		myGridFeatures.add(new TalkableFeature(this));
		myGridFeatures.add(new WidthHeightFeature(this));
		myGridFeatures.add(new DialogueFeature(this));
		
		myGridObjectButton = new JButton("New GridObject");
		myGridObjectButton.addActionListener(new GridObjectWindowAction());
		imageEditor.setSuperFeature(this);
		myComponents.put(myGridObjectButton, BorderLayout.SOUTH);
		//gridObjectView = new AuthoringView(myGridFeatures, false);
	}
	public GridObjectData getData(){
		return myData;
	}
	public AuthoringView getView(){
		return gridObjectView;
	}
	public void setCoordinates(int x, int y){
		
	}
	private class GridObjectWindowAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			gridObjectView = new AuthoringView(myGridFeatures, false);
			imageEditor.imageRefresh();
			imageEditor.setVisible(true);
		}	
	}
	public Feature getFeature(String s){
		Feature myFeature=null;
		for(Feature f: myGridFeatures){
			if(f.getClass().getSimpleName().equals(s))
				myFeature = f;
		}
		return myFeature;
	}
	
}
*/