package authoring;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Data.ImageManager;

public class TileImageEditor extends JFrame {

	private JList list;
	private JScrollPane scroll;
	DefaultListModel model;
	ImageManager m=new ImageManager();

	public TileImageEditor(String s) {
		super(s);
		this.setLayout(new BorderLayout());
		this.setSize(360, 360);
		model = new DefaultListModel();
		list = new JList(model);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.addListSelectionListener(new SelectionListener());
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		list.setVisibleRowCount(-1);
		scroll = new JScrollPane(list);
		this.getContentPane().add(scroll, BorderLayout.CENTER);
		
		for(String image: m.getSavedImageList()){
			addImage(m.loadImage(image));
		}
	}

	public void addImage(File fileName){
		BufferedImage temp;
		try {
			temp = ImageIO.read(fileName);
		} catch (IOException e) {
			temp = null;
		}
		Image scaledImage = temp.getScaledInstance(36, 36, Image.SCALE_FAST);
		Icon x = new ImageIcon(scaledImage);
		model.addElement(x);
	}
	
	public Icon selectImage(){
		if(list.getSelectedIndex()!=-1){
			return (Icon) model.get(list.getSelectedIndex());
		}	
		return null;
	}
	
	public class SelectionListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			//selectImage();
		}
		
	}
}