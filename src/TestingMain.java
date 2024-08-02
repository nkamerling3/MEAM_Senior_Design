import java.awt.image.BufferedImage;
	import java.io.File;
	import java.io.IOException;
	import javax.imageio.ImageIO;
public class TestingMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidationPicture beforePicture = new ValidationPicture("/Users/noahkamerling/Desktop/SeniorDesignValidationPictures/BackTests/GloGermRightBackTestBefore.png");
		ValidationPicture afterPicture = new ValidationPicture("/Users/noahkamerling/Desktop/SeniorDesignValidationPictures/BackTests/GloGermRightBackTestAfter.png");
		int germsBefore = beforePicture.numGermPixels();
		int germsAfter = afterPicture.numGermPixels();
		
		beforePicture.createGermPic();
		afterPicture.createGermPic();
		beforePicture.outputPicture();
		afterPicture.outputPicture();
		
	    double ratioRemoved = (Double.valueOf(germsBefore) - Double.valueOf(germsAfter))/ (Double.valueOf(germsBefore));
	    System.out.println("Glo Germ Pixels Before:" + germsBefore);
		System.out.println("Glo Germ Pixels After:" + germsAfter);
	    System.out.println("Ratio Of Germs Removed:" + ratioRemoved);
		 
		 

	}

}
