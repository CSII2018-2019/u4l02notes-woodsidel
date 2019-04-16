import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		String type = JOptionPane.showInputDialog("What Filter Do You Want? \nFilters: Grayscale, Avengers, Negative, Sepia");
		if(type == "Grayscale") {
		//grayscale image panel
		ImagePanel grayscale = new ImagePanel(FILE_NAME);
		grayscale.convertToGrayscale(type);
		add(grayscale, BorderLayout.CENTER);
		}
		else if(type == "Avengers") {
		//avengers image panel
				ImagePanel Avengers = new ImagePanel(FILE_NAME);
				Avengers.convertToAvengers(type);
				add(Avengers, BorderLayout.CENTER);
		}
		else if(type == "Negative") {
		//negative image panel
				ImagePanel Negative = new ImagePanel(FILE_NAME);
				Negative.convertToNegative(type);
				add(Negative, BorderLayout.CENTER);
		}
		else if(type == "Sepia") {
		//sepia image panel
				ImagePanel Sepia = new ImagePanel(FILE_NAME);
				Sepia.convertToSepia(type);
				add(Sepia, BorderLayout.CENTER);		
		}
		else {
		//normal image panel
		ImagePanel imgPanel = new ImagePanel(FILE_NAME);
		add(imgPanel, BorderLayout.CENTER);
		}
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
