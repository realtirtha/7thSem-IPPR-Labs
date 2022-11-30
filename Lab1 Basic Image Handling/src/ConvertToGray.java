import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ConvertToGray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("Hello, World!");
		
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("C:\\Tirtha Kshitz\\7th Sem\\IPPR\\7th Sem IPPR Labs\\TirthPic.jpg"));
			System.out.println("Reading Complete.");
		}
		catch(IOException e) {
			System.out.println("Error: " + e);
		}
		
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
		
		try {
			File output_file = new File("C:\\Tirtha Kshitz\\7th Sem\\IPPR\\7th Sem IPPR Labs\\TirthPic_Greyed.jpg");
			ImageIO.write(image, "jpg", output_file );
			
			ImageIcon icon = new ImageIcon(image);
			JFrame frame = new JFrame();
			frame.setLayout(new FlowLayout());
			frame.setSize(400,500);
			JLabel lbl = new JLabel();
			lbl.setIcon(icon);
			frame.add(lbl);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
			
			System.out.println("Writing Complete.");
			
		}
		catch(IOException e) {
			System.out.println("Error: " + e);
			return;
		}
		
	}

}
