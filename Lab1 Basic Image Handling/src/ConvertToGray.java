import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ConvertToGray {
	

	public static void main(String[] args) {
		//System.out.println("Hello, World!");
		
		
		BufferedImage image = null;
		
		
		//reading image
		try {
			image = ImageIO.read(new File("C:\\Tirtha Kshitz\\7th Sem\\IPPR\\7th Sem IPPR Labs\\hill.jpg"));
			System.out.println("Reading Complete.");
		}
		catch(IOException e) {
			System.out.println("Error: " + e);
		}
		
		/*
		//example number first
		 
		BufferedImage image = null;
		 
		//reading image
		try {
			image = ImageIO.read(new File("C:\\Tirtha Kshitz\\7th Sem\\IPPR\\7th Sem IPPR Labs\\hill.jpg"));
			System.out.println("Reading Complete.");
		}
		catch(IOException e) {
			System.out.println("Error: " + e);
		}
		
		//converting image to grey but using RBG value
		buffer(image);		
		
		//writing image
		try {
			File output_file = new File("C:\\Tirtha Kshitz\\7th Sem\\IPPR\\7th Sem IPPR Labs\\buffer-greyed-hill.jpg");
			ImageIO.write(image, "jpg", output_file );
			
			
			
			System.out.println("Writing Complete.");
			
		}
		catch(IOException e) {
			System.out.println("Error: " + e);
			return;
		}
		display(image);
		*/
		
		//call to convert image into array
		int[][] InArray= convertToArray(image);
		
		//modifying according to question 1
		int[][] q1= ques1(InArray);
		
		//call to convert into array gray
		BufferedImage InBuffered= arrConvertToBI(q1);
		
		
		
		
		//call to write image image
		writeImage(InBuffered);
		
		display(InBuffered);
		
	}
	
	
	
	//ques1 solving
	static int[][] ques1(int[][] g) {
		for(int x=0;x<g.length;x++)
			for(int y=0; y<g[0].length;y++) {
				if(g[x][y]<128)
					g[x][y]=255;
				else
					g[x][y]=0;
				}
		return g;
	}
	
	
	//function to convert image to array
	static int[][] convertToArray(BufferedImage image) {
		int[][] A = new int[image.getWidth()][image.getHeight()];
		for(int x=0;x<image.getWidth();x++)
			for(int y=0; y<image.getHeight();y++) {
				Color c= new Color(image.getRGB(x,y));
				int red = c.getRed();
				int green = c.getGreen();
				int blue = c.getBlue();
				
				A[x][y]= (red+green+blue)/3;
			}
		return A;
	}
	
	//function to change array image to gray array image
	static BufferedImage arrConvertToBI(int[][] q1) {
		BufferedImage img =new BufferedImage(q1.length,q1[0].length,BufferedImage.TYPE_BYTE_GRAY);
		for(int x=0;x<q1.length;x++)
			for(int y=0;y<q1[0].length;y++)
			{
				Color c = new Color(q1[x][y],q1[x][y],q1[x][y]);
				
				img.setRGB(x,y,c.getRGB());
			}
		return img;
	}
	
	
	 
	//function go process image according to example 1 but is commented on main
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
	
	//function to write image output
	static void writeImage(BufferedImage image) {
		try {
			File output_file = new File("C:\\Tirtha Kshitz\\7th Sem\\IPPR\\7th Sem IPPR Labs\\shree.jpg");
			ImageIO.write(image, "jpg", output_file );
			
			
			
			System.out.println("Writing Complete.");
			
		}
		catch(IOException e) {
			System.out.println("Error: " + e);
			return;
		}
		display(image);
	}
	
	
	

}
