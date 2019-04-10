import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class U4L02Notes extends JFrame {
	
	public static final String FILE_NAME = "/Spider-Man.jpg";
	
	public U4L02Notes(){
		initGUI();
		setTitle("Examples");
		setResizable(true);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void initGUI(){
		
		//image panel
		ImagePanel imgPanel = new ImagePanel(FILE_NAME);
		add(imgPanel, BorderLayout.WEST);
		
		//grayscale image panel
		ImagePanel grayscale = new ImagePanel(FILE_NAME);
		String type = "g";
		grayscale.convertToGrayscale(type);
		add(grayscale, BorderLayout.EAST);
		
		//avengers image panel
				//ImagePanel Avengers = new ImagePanel(FILE_NAME);
				//type = "a";
				//Avengers.convertToGrayscale(type);
				//add(Avengers, BorderLayout.CENTER);
		//negative image panel
				ImagePanel Negative = new ImagePanel(FILE_NAME);
				type = "n";
				Negative.convertToGrayscale(type);
				add(Negative, BorderLayout.CENTER);
}
	

	public static void main(String[] args) {
		try {
			String className = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(className);
		} catch (Exception e){}
		
		SwingUtilities.invokeLater(new Runnable (){
            @Override
            public void run() {
                new U4L02Notes();
            }   
        });

	}

}
