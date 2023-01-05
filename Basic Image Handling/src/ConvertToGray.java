import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ConvertToGray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("Hello, World!");
				//ex1 ex = new ex1();
				
				
				BufferedImage image = null;
				
				
				//reading image
				try {
					image = ImageIO.read(new File("C:\\Tirtha Kshitz\\7th Sem\\IPPR\\ImageProcessingLabs\\Basic Image Handling\\images\\hill.jpg"));
					System.out.println("Reading Complete.");
				}
				catch(IOException e) {
					System.out.println("Error: " + e);
				}
				
				//example solution
				//ex.buffer(image);
				
				//call to convert image into array
				int[][] InArray= convertToArray(image);
				BufferedImage original = arrConvertToBI(InArray);
				display(original);
				
				//modifying according to question 1
				//int[][] q1= ques1(InArray);
				
				//modifying according to question 2
				//int[][] q2= ques2(InArray,mean(InArray));
				
				//modifying according to question 3, but calling ques2 caz' it does same work
				int[][] q3= ques2(InArray,median(InArray));
				
				//call to convert into array gray
				//BufferedImage InBuffered= arrConvertToBI(q1);
				//BufferedImage InBuffered= arrConvertToBI(q2);
				BufferedImage InBuffered= arrConvertToBI(q3);
					
				//call to write image image
				writeImage(InBuffered);
			
	}
	

	
	//---------------------------------------------------------------------------------
	//---------------------------------------------------------------------------------
	
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
	
	//finding mean
	static int mean(int[][] f){
		int sum=0;
		int count=0;
		for(int x=0;x<f.length;x++)
		{
			for(int y=0;y<f[0].length;y++)
			{
				
				sum+=f[x][y];
				count++;
			
			}
		}
		int mean=sum/count;
		return mean;
	}
	
	//ques2 solving
	static int[][] ques2(int[][] h, int m){
		for(int x=0;x<h.length;x++)
			for(int y=0;y<h[0].length;y++) {
				if(h[x][y]>m)
					h[x][y]=255;
				else
					h[x][y]=0;
			}
		return h;
	}
	
	//finding median
	static int median(int[][] me) {
		int count= me.length*me[0].length;
		int[] ar= new int[count];
		int i=0;
		for(int x=0;x<me.length;x++)
			for(int y=0;y<me[0].length;y++) {
				if(i<count) {
					ar[i]=me[x][y];
					i++;
				}
			}
		Arrays.sort(ar);
		int pos= (count+1)/2;
		int median = ar[pos-1];
		
		return median;
		
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
			File output_file = new File("C:\\\\Tirtha Kshitz\\\\7th Sem\\\\IPPR\\\\ImageProcessingLabs\\\\Basic Image Handling\\\\images\\\\q3hill.jpg");
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
