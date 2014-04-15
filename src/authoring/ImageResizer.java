package authoring;


import java.io.File;
import java.io.IOException;
import Data.ImageManager;

public class ImageResizer {
	
	private File storedImage;
	private String fileName;
    private String fileId;
	private File imageFile;
    private ImageManager myImageManager;
	
	public ImageResizer(){
        myImageManager = new ImageManager();
    }

	protected void storeImage(String name, File file, String id) throws IOException {
		fileName = name;
		imageFile = file;
        fileId = id;
		storedImage = myImageManager.storeImage(fileName,imageFile,fileId);
		addToWorldData();
	}

	private void addToWorldData() {
        FeatureManager.getWorldData().saveImage(fileName, storedImage);
        FeatureManager.imageEditor.addImage(storedImage, fileName);
	}

}
