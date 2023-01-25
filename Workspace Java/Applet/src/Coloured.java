import java.applet.Applet;
import java.awt.*;
public class Coloured extends Applet {
	public void init(){
		resize(1000, 600);
		Color green = new Color(204,255,204);
		setBackground(green);
	}
	public void paint(Graphics g){
		Color blue = new Color(158,217,255);
		Color pink = new Color(222,0,151);
		Color black = new Color(0,0,0);
		g.drawString("You can highlight a number 2 ways", 20, 20);
		g.drawString("You can highlight the number in a colour filled rectangle, or simply color the text", 20, 100);
		g.setColor(blue);
		g.fillRect(100,105,50,20);
		g.setColor(black);
		g.drawString("123456",100,120);
		g.setColor(pink);
		g.drawString("123456",100,150);
		
	}	
}