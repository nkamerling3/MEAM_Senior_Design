import java.awt.image.BufferedImage;
	import java.io.File;
	import java.io.IOException;
	import javax.imageio.ImageIO;
	
public class ValidationPicture {

    public static int picCounter = 1;
	public BufferedImage origImage;
	public BufferedImage germImage;
	

	
public ValidationPicture(String destination) {
	try
    {
      origImage = ImageIO.read(new File(destination));//ex: "/Users/al/some-picture.jpg"));
      germImage = ImageIO.read(new File(destination));

      // work with the image here ...
    } 
    catch (IOException e)
    {
    	System.out.println("File not found!");
    	
    }
}



	
public int numGermPixels() {
	int germPixels = 0;

	int w = origImage.getWidth();
	int h = origImage.getHeight();
	
	for (int i = 0; i < h; i++) {
	      for (int j = 0; j < w; j++) {
	        int pixel = origImage.getRGB(j, i);
	        //int alpha = (pixel >> 24) & 0xFF;
	        int red =   (pixel >> 16) & 0xFF;
	        int green = (pixel >>  8) & 0xFF;
	        int blue =  (pixel      ) & 0xFF;
	        if(germRange(red, green, blue)) {
	        	germPixels++;
	        }
	      }
	    }
	
	return germPixels;

	    
}

public void createGermPic() {
	int w = origImage.getWidth();  
	int h = origImage.getHeight(); 
	int pixelCount = 0;
	for (int i = 0;  i < h; i++) { 
	      for (int j = 0; j < w; j++) { 
	        int pixel = germImage.getRGB(j, i);
	        int red =   (pixel >> 16) & 0xFF;
	        int green = (pixel >>  8) & 0xFF;
	        int blue =  (pixel      ) & 0xFF;

	        System.out.println("red value:" + red);
	        System.out.println("green value:" + green);
	        System.out.println("blue value:" + blue);
	        pixelCount++;
	        if(germRange(red, green, blue)) {
	           int redPixel = 0xFFFF0000;
	   
	           System.out.println("Pixel count =" + pixelCount);
	           
	        	germImage.setRGB(j, i, redPixel);
	        	
	        }
	        else {
	        	System.out.println("Pixel count =" + pixelCount);
	        	germImage.setRGB(j, i, pixel);
	        }
	      }
	    }
	
	
	
}

public void outputPicture() {
	try {
	    File outputfile = new File("germs" + picCounter + ".png");
	    picCounter++;
	    ImageIO.write(germImage, "png", outputfile);
	} catch (IOException e) {
	   System.out.println("Exception!");
	}
}

private boolean germRange(int r, int g, int b) {
	if(g > 70 && b > 180) {
	return true;
	}
	return false;
}


	
}
