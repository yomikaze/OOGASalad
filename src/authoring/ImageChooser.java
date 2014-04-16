package authoring;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

 class ImageChooser extends Feature implements ActionListener{

	private String fileName;

    private String identifier;
    private JFrame frame;
    private int result;

	private ImageResizer myImResizer;

	
	private ImageChooser(){
		JButton myChooseImageButton = new JButton("New Image");
		myChooseImageButton.addActionListener(this);
		myChooseImageButton.setActionCommand("choose");
		myComponents.put(myChooseImageButton, BorderLayout.SOUTH);
		myImResizer = new ImageResizer();


	}

	public void actionPerformed(ActionEvent e) {
		if("choose".equals(e.getActionCommand())){

            imageFilePanel();

			//fileName = JOptionPane.showInputDialog("Name your image:");

            //String determineImage = (String)JOptionPane.showInputDialog(frame,"What type of image is this?","Image determination.",JOptionPane.PLAIN_MESSAGE,null,choices,"Grid Object");
            //identifier = determineImage.replaceAll("\\s","").toLowerCase();

			//if(fileName.equals("")){
			//	JOptionPane.showMessageDialog(frame, "Must name image.", "Error Message", JOptionPane.ERROR_MESSAGE);
				//fileName = JOptionPane.showInputDialog("Please name the image:");
				//try {

				//} catch (IOException e1) {}
			//} else{
				//try {
				//	chooseImage(e);
				//} catch (IOException e1) {}
			//}
            if(result==JOptionPane.OK_OPTION){
                try {
                    chooseImage();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
		     }
        }


    }
	
	private void chooseImage() throws IOException {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"JPG, PNG, GIF", "jpg","gif","png");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION){
			System.out.println("You chose to open this file: " +
					chooser.getSelectedFile().getAbsolutePath());
		}
		File imageFile = chooser.getSelectedFile();
		myImResizer.storeImage(fileName, imageFile, identifier);
	}

    private void imageFilePanel(){
        JRadioButton go = new JRadioButton("Grid Object");
        JRadioButton ti = new JRadioButton("Tile Image");
        JTextField fn = new JTextField(15);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(fn);
        panel.add(go);
        panel.add(ti);
        result = JOptionPane.showOptionDialog(null, panel, "Name Image", JOptionPane.CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

        if(result == JOptionPane.OK_OPTION){
            if(fn.getText().equals("") || !(go.isSelected()) && !(ti.isSelected())){
                JOptionPane.showMessageDialog(frame, "Complete required fields.", "Error Message", JOptionPane.ERROR_MESSAGE);
                imageFilePanel();
            }
        } else{}

        fileName = fn.getText();
        if(go.isSelected()){
            identifier = "gridobject";
        } else {
            identifier = "tileimage";
        }
    }


}
