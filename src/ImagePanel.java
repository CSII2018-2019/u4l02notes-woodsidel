import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class ImagePanel extends JPanel {
	
	//what variables are needed?
	private static int width;
	private static int height;
	
	static BufferedImage image = null;
	
	public ImagePanel(String fn){
		image = readImageFile(this, fn);
		width = image.getWidth();
		height = image.getHeight();
	}
	
	public static BufferedImage readImageFile(Object requestor, String fileName){
		BufferedImage image = null;
		try {
			InputStream input = requestor.getClass().getResourceAsStream(fileName);
			image = ImageIO.read(input);
		} catch (IOException e){
			String message = "The image file " + fileName + " could not be opened.";
			JOptionPane.showMessageDialog(null, message);
		}
		return image;
	}
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, null);
		//title Panel
				Font titleFont = new  Font ("Times New Roman", Font.PLAIN, 40);
				g.setFont(titleFont);
				//g.drawString("When You Realize You Messed Up",25, 100);
				setForeground(Color.WHITE);

	}
	public Dimension getPreferredSize() {
		Dimension size = new Dimension(width, height);
		return size;
	}
	
	public void convertToGrayscale(String type) {
		if(type == "Grayscale") {
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				//get value for 1 pixel
				int p = image.getRGB(x, y);
				
				int a = (p >> 24) & 0xff;
				int r = (p >> 16) & 0xff;
				int g = (p >> 8) & 0xff;
				int b = (p >> 0) & 0xff;
				
				int avg = (r+g+b)/3;
				
				p = (a << 24) | (avg << 16) | (avg << 8) | (avg << 0);
					image.setRGB(x, y, p);
			}
		}
		}		
	}
	public void convertToSepia(String type) {
		if(type == "Sepia") {
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				//get value for 1 pixel
				int p = image.getRGB(x, y);
				
				int a = (p >> 24) & 0xff;
				int r = (p >> 16) & 0xff;
				int g = (p >> 8) & 0xff;
				int b = (p >> 0) & 0xff;
				
				int avg = (r+g+b)/3;
				
				int newRed = (int)(0.393*r + 0.769*g + 0.189*b);
				int newGreen = (int)(0.349*r + 0.686*g + 0.168*b);
				int newBlue = (int)(0.272*r + 0.534*g + 0.131*b);
				
				if(newRed > 255) {
					newRed = 255;	
				}
				if(newGreen > 255) {
					newGreen = 255;
				}
				if(newBlue > 255) {
					newBlue = 255;
				}
				
				p = (a << 24) | (newRed << 16) | (newGreen << 8) | (newBlue << 0);
				image.setRGB(x, y, p);
			}
		}
		}
	}

	public void convertToAvengers(String type) {
		if(type == "Avengers") {
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				//get value for 1 pixel
				int p = image.getRGB(x, y);
				
				int a = (p >> 24) & 0xff;
				int r = (p >> 16) & 0xff;
				int g = (p >> 8) & 0xff;
				int b = (p >> 0) & 0xff;
				
				
				//calculate average
				int redAverage = (g+b)/2;
				int avg = (r+g+b)/3;
				
				p = (a << 24) | (redAverage << 16) | (avg << 8) | (avg << 0);
				image.setRGB(x, y, p);
		
			}
		}
		}
	}
	public void convertToNegative(String type) {
		//negative image
		if(type == "Negative") {
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				//get value for 1 pixel
				int p = image.getRGB(x, y);
				
				int a = (p >> 24) & 0xff;
				int r = (p >> 16) & 0xff;
				int g = (p >> 8) & 0xff;
				int b = (p >> 0) & 0xff;
				
				
				//calculate average
				int avg = (r+g+b)/3;
				p = (a << 24) | (255-r << 16) | (255-g << 8) | (255-b << 0);
				
				image.setRGB(x,  y, p);

			}
		}
		}
		
	}
	
	
	}

