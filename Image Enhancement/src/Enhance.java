import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.awt.FlowLayout;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Enhance {

	public static void main(String[] args) {
		BufferedImage image = null;
		
		//reading image
		try {
			File input = new File("C:\\Tirtha Kshitz\\7th Sem\\IPPR\\ImageProcessingLabs\\Image Enhancement\\images\\tt.jpg");
			image = ImageIO.read(input);
			System.out.println("Readin' complete");
		}
		catch(IOException e){
			System.out.println("Error : "+ e);
		}
		
		
		//converting buffered image to array
		int[][] inArray = convertToArray(image);
		
		
		//question number 1
		//int [][] logTrans = logTransform(inArray, 1);
		//BufferedImage inBuffer = convertToBI(logTrans);
		//write(inBuffer);
		
		
		//according to question 2 
		//int[] occurance = oCount(inArray); //occ counting	
		//int imgSize=inArray.length*inArray[0].length;
		//double[] prob = probability(occurance, imgSize);	
		//double[] histogram = equalize(prob);
		//int[][] two = twoDimension(inArray, histogram); //1D array to 2D array	
		//BufferedImage inBuffer = convertToBI(two); //converting array into Buffered form	
		//write(inBuffer); //function call to write image
		
		
		//time for question no. 3
	}
	
	
	
	
	
	
	//----------------------------------------------------
	static int[][] twoDimension(int[][] arr,double[] his)
	{
		int z=0;
		for(int x=0;x<arr.length;x++)
		{
			for(int y=0;y<arr[0].length;y++)
			{
				
			    z=arr[x][y];
				arr[x][y]=(int) his[z];
			}
		}
		return arr;
	}
	
	static double[] equalize(double[] prob) {
		double[] s = new double[256];
		for(int i=0;i<256;i++)
		{
			s[i]=0;
			for(int j=0;j<=i;j++)
			{
				
				s[i]+=prob[j];
			}
			s[i]=s[i]*255;
		}
		return s;
	}
	
	static double[] probability(int[] count,int imgSize)
	{
		double[] prob = new double[256];
		
		for(int i=0;i<256;i++)
		{ 
			prob [i]=(double) count[i]/imgSize;
		}
		return prob;	
	}
	
	public static int[] oCount(int[][] arr) {
		int[] c = new int[256];
		

			for(int y=0; y<arr.length;y++) {
				for(int z=0; z<arr[0].length; z++) {
					c[arr[y][z]]++;
				}
			}
		
		
		return c;
	}
	
	
	
	
	
	public static int[][] logTransform(int [][] arr, double c){
		int ar[][] = new int[arr.length][arr[0].length];
	    int min = Integer.MAX_VALUE;
	    int max = Integer.MIN_VALUE;

	    for(int x=0;x<arr.length;x++)
	        for (int y=0;y<arr[0].length;y++) {
	            double logPixel = c * Math.log10(arr[x][y] + 1);
	            ar[x][y] = (int) logPixel;
	            min = Math.min(min, ar[x][y]);
	            max = Math.max(max, ar[x][y]);
	        }
	    for(int x=0;x<arr.length;x++)
	        for (int y=0;y<arr[0].length;y++) {
	            ar[x][y] = (ar[x][y] - min) * 255 / (max - min);
	        }
	    return ar;
	}
	
	public static BufferedImage convertToBI(int[][] arr) {
		BufferedImage img = new BufferedImage(arr.length,arr[0].length,BufferedImage.TYPE_BYTE_GRAY);
		for (int x=0;x<arr.length;x++)
			for (int y=0;y<arr[0].length;y++) {
				
				int pixelValue = arr[x][y];
				
				// Make sure that the pixel value is within the range 0-255
				pixelValue = Math.max(0, pixelValue);
				pixelValue = Math.min(255, pixelValue);
				
				//idk how it worked
				Color c = new Color(pixelValue, pixelValue, pixelValue);
				
				//Color c = new Color(arr[x][y],arr[x][y],arr[x][y]);
				
				img.setRGB(x, y, c.getRGB());
			}
		return img;
	}
	
	
	public static int[][] convertToArray(BufferedImage img){
		int arr[][] = new int[img.getWidth()][img.getHeight()];
		for (int x=0;x<img.getWidth();x++)
			for (int y=0;y<img.getHeight();y++) {
				Color c = new Color(img.getRGB(x,y));
				int red = c.getRed();
				int green = c.getGreen();
				int blue = c.getBlue();
				
				
				//for log
				arr[x][y] = (int) (0.21 * red + 0.72 * green + 0.07 * blue);
				//arr[x][y]= (red+green+blue)/3;
			}
		return arr;
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
	
	public static void write(BufferedImage image) {
		File output= new File("C:\\Tirtha Kshitz\\7th Sem\\IPPR\\ImageProcessingLabs\\Image Enhancement\\images\\2tt.jpg");
		try {
			ImageIO.write(image,"jpg", output);
			System.out.println("writin' complete.");
		} catch (IOException e) {
			System.out.println("Error : "+e);
		}
		display(image);
	}

}
