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
	private int width;
	private int height;
	
	BufferedImage image = null;
	
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
				//reset our pixel
				if(type.equals("g")) {
					p = gscale(avg, a, p);
					image.setRGB(x, y, p);
				}
				if(type.equals("a")) {
				p = avengers(a, p, avg, redAverage);
				image.setRGB(x, y, p); 
				}
				if(type.equals("n")) {
				p = negative(a, p, avg, r, g, b);
				image.setRGB(x, y, p);
				}
				
				
				
				}
			}
		}
	public static int gscale(int average, int a1, int p1) {
		
		p1 = (a1 << 24) | (average << 16) | (average << 8) | (average << 0);
		return p1;
		}
	public static int avengers(int a1, int p1, int average, int redAvg) {
		
		p1 = (a1 << 24) | (redAvg << 16) | (average << 8) | (average << 0);
		return p1;
	}
	public static int negative(int a1, int p1, int average, int r1, int g1, int b1) {
		//negative image
		p1 = (a1 << 24) | (255-r1 << 16) | (255-g1 << 8) | (255-b1 << 0);
		return p1;
	}
	
	
	}

