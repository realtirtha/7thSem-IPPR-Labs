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
	static int[][] A= new int[1000][1000];

	public static void main(String[] args) {
		//System.out.println("Hello, World!");
		
		
		BufferedImage image = new BufferedImage(A.length,A[0].length,BufferedImage.TYPE_BYTE_GRAY);
		
		
		//reading image
		try {
			image = ImageIO.read(new File("C:\\Tirtha Kshitz\\7th Sem\\IPPR\\7th Sem IPPR Labs\\hill.jpg"));
			System.out.println("Reading Complete.");
		}
		catch(IOException e) {
			System.out.println("Error: " + e);
		}
		
		/*
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
		convertToArray(image);
		
		//call to convert into array gray
		//arrConvertToBI(image);
		
		
		//question1: call to change intensity using thresholding
		//ques1(image);
		
		//call to write image image
		//writeImage(image);
		
		display(image);
		
	}
	
	
	
	//ques1 solving
	static void ques1(BufferedImage image) {
		for(int x=0;x<image.getWidth();x++)
			for(int y=0; y<image.getHeight();y++) {
				if(A[x][y]<128)
					A[x][y]=255;
				else
					A[x][y]=0;			}
	}
	
	
	//function to convert image to array
	static void convertToArray(BufferedImage image) {
		for(int x=0;x<image.getWidth();x++)
			for(int y=0; y<image.getHeight();y++) {
				Color newColor = new Color(A[x][y],A[x][y],A[x][y]);
				image.setRGB(x, y, newColor.getRGB());
			}
	}
	
	//function to change array image to gray array image
	static void arrConvertToBI(BufferedImage image) {
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
	
	//function to write image output
	static void writeImage(BufferedImage image) {
		try {
			File output_file = new File("C:\\Tirtha Kshitz\\7th Sem\\IPPR\\7th Sem IPPR Labs\\greyed-hill.jpg");
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
