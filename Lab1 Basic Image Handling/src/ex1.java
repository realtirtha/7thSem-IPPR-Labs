import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ex1 {
	
	ConvertToGray cg = new ConvertToGray();
	
	public void buffer(BufferedImage image) {
		for(int y=0;y<image.getHeight();y++)
			for(int x=0;x<image.getWidth();x++)
			{
				Color c = new Color(image.getRGB(x, y));
				int red = (c.getRed());
				int green = (c.getGreen());
				int blue = c.getBlue();
				
				int gray = (int)(red+green+blue)/3;
				Color newColor = new Color(gray,gray,gray);
				image.setRGB(x,y,newColor.getRGB());
			}
		
		//writing image
		try {
			File output_file = new File("C:\\Tirtha Kshitz\\7th Sem\\IPPR\\7th Sem IPPR Labs\\shree.jpg");
			ImageIO.write(image, "jpg", output_file );
			
			
			
			System.out.println("Writing Complete.");
			
		}
		catch(IOException e) {
			System.out.println("Error: " + e);
			return;
		}
		cg.display(image);
	}
}
