import java.awt.image.BufferedImage;
import java.awt.Color;
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
		
		
		//converting buffered image to array
		int[][] inArray = convertToArray(image);
		
		
		//question number 1
		//int [][] logTrans = logTransform(inArray);
		
		//according to question 2 
		int[] occurance = oCount(inArray); //occ counting
		
		int imgSize=inArray.length*inArray[0].length;
		double[] prob = probability(occurance, imgSize);
		
		double[] histogram = equalize(prob);
		
		//1D array to 2D array
		int[][] two = twoDimension(inArray, histogram);
		
		
		//converting array into Buffered form
		//BufferedImage inBuffer = convertToBI(logTrans);
		BufferedImage inBuffer = convertToBI(two);
		
		//function call to write image
		write(inBuffer);
	}
	
	
	
	
	
	
	//----------------------------------------------------
	static int[][] twoDimension(int[][] f,double[] m)
	{
		int z=0;
		for(int x=0;x<f.length;x++)
		{
			for(int y=0;y<f[0].length;y++)
			{
				
			    z=f[x][y];
				f[x][y]=(int) m[z];
			}
		}
		return f;
	}
	
	static double[] equalize(double[] prob) {
		double[] s = new double[256];
		for(int i=0;i<256;i++)
		{
			for(int j=0;j<=i;j++)
			{
				s[i]=0;
				s[i]+=prob[j];
			}
			s[i]=s[i]*255;
		}
		return s;
	}
	
	static double[] probability(int[] arr,int imgSize)
	{
		double[] prob = new double[256];
		
		for(int i=0;i<256;i++)
		{
			prob [i]=(double) arr[i]/imgSize;
		}
		return prob;	
	}
	
	public static int[] oCount(int[][] arr) {
		int[] c = new int[256];
		
		for(int x=0;x<256;x++) {
			for(int y=0; y<arr.length;y++) {
				for(int z=0; z<arr[0].length; z++) {
					if(x==arr[y][z]) {
						c[x]++;
					}
				}
			}
		}
		
		return c;
	}
	
	public static int[][] logTransform(int [][] arr){
		int ar[][] = new int[arr.length][arr[0].length];
		
		for(int x=0;x<arr.length;x++)
			for (int y=0;y<arr[0].length;y++) {
				ar[x][y]= (int) Math.log(arr[x][y]);
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
				
				arr[x][y]= (red+green+blue)/3;
			}
		return arr;
	}
	
	public static void write(BufferedImage image) {
		File output= new File("C:\\Tirtha Kshitz\\7th Sem\\IPPR\\ImageProcessingLabs\\Image Enhancement\\images\\2ox.jpg");
		try {
			ImageIO.write(image,"jpg", output);
			System.out.println("writin' complete.");
		} catch (IOException e) {
			System.out.println("Error : "+e);
		}
	}

}
