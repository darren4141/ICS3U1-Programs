import java.applet.Applet;
import java.awt.*;
public class BusinessCard extends Applet{
	public void init(){
		resize(400, 200);
		Color black = new Color(0,0,0);
		setBackground(black);
	}
	public void paint(Graphics g){
		Color white = new Color(255,255,255);
		Color green = new Color(105,255,71);
		g.setColor(white);
		g.drawString("DARREN LIU", 40, 40);
		g.drawString("Occupation: ear model", 230, 40);
		g.drawString("UHS student", 40, 60);
		g.fillRect(370,0,4,200);
		g.fillRect(0,75,400,3);
		g.setColor(green);
		g.drawString("Mobile Phone: 012-345-6789    Available: 24/7", 60, 95);
		g.drawString("Skills: ", 60, 115);
		g.drawString("  - Wearing headphones", 60, 135);
		g.drawString("  - Standing still", 60, 155);
		g.drawString("  - Not falling asleep", 60, 175);

	}
	
}
