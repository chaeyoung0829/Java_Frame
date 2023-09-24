package Lesson01;

import java.awt.Dimension;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

class ImagePanel extends JPanel {
	private Image img;
	
	public ImagePanel(Image img) {
		this.img = img;
		setSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setLayout(null);
	}
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0,null);
	}
	
	public int getWidth(){
		return img.getWidth(null);
	}
	
	public int getHeight() {
		return img.getHeight(null);
	}

}
public class Lesson_01 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Lesson_01");
		frame.setSize(640,480);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		ImagePanel panel = new ImagePanel(new ImageIcon("./image_01/Welcome.jpg").getImage());
		File f = new File("./image_01/Welcome.jpg");
		System.out.println(f.exists()?"Exists": "doesnt exists");
		frame.add(panel);
		frame.pack();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
}
