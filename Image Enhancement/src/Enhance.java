import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Enhance {

	public static void main(String[] args) {
		BufferedImage image = null;
		
		//reading image
		try {
			File input = new File("C:\\Tirtha Kshitz\\7th Sem\\IPPR\\ImageProcessingLabs\\Image Enhancement\\images\\ox.jpg");
			image = ImageIO.read(input);
			System.out.println("Readin' complete");
		}
		catch(IOException e){
			System.out.println("Error : "+ e);
		}
		
		
		//function call to write image
		write(image);
	}
	
	//----------------------------------------------------
	
	public static void write(BufferedImage image) {
		File output= new File("C:\\Tirtha Kshitz\\7th Sem\\IPPR\\ImageProcessingLabs\\Image Enhancement\\images\\1ox.jpg");
		try {
			ImageIO.write(image,"jpg", output);
			System.out.println("writin' complete.");
		} catch (IOException e) {
			System.out.println("Error : "+e);
		}
	}

}
