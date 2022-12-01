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
		//System.out.println("Hello, World!");
		
		
		//declaration part
		//BufferedImage image = null;
		int A[][]= new int[10000][1000];
		BufferedImage image = new BufferedImage(A.length,A[0].length,BufferedImage.TYPE_BYTE_GRAY);
		
		
		//reading image code
		try {
			image = ImageIO.read(new File("C:\\Tirtha Kshitz\\7th Sem\\IPPR\\7th Sem IPPR Labs\\TirthPic.jpg"));
			System.out.println("Reading Complete.");
		}
		catch(IOException e) {
			System.out.println("Error: " + e);
		}
		
		
		//code to convert image to array
		convertToArray(image);
		
		
		
		
		//buffer(image);
		
		
		//writing image
		try {
			File output_file = new File("C:\\Tirtha Kshitz\\7th Sem\\IPPR\\7th Sem IPPR Labs\\TirthPic_Greyed.jpg");
			ImageIO.write(image, "jpg", output_file );
			
			display(image);
			
			System.out.println("Writing Complete.");
			
		}
		catch(IOException e) {
			System.out.println("Error: " + e);
			return;
		}
		
	}
	
	
	//function to convert image to array
	static void convertToArray(BufferedImage image) {
		ConvertToGray cog = new ConvertToGray();
		for(int x=0;x<image.getWidth();x++)
			for(int y=0; y<image.getHeight();y++) {
				Color newColor = new Color(cog.A[x][y],cog.A[x][y],cog.A[x][y]);
				image.setRGB(x, y, newColor.getRGB());
			}
	}
	
	
	 
	//function go process image
	static void buffer(BufferedImage image) {
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
	}
	
	//function to display on console
	static void display(BufferedImage image) {
		ImageIcon icon = new ImageIcon(image); 
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout());
		frame.setSize(400,500);
		JLabel lbl = new JLabel();
		lbl.setIcon(icon);
		frame.add(lbl);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	

}
