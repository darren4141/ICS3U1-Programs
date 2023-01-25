import java.applet.Applet;
import java.awt.*;
import java.time.*;
import java.time.format.DateTimeFormatter;


public class TimerTest extends Applet{
	
	public void paint (Graphics g){
		int heartX = 100;
		int heartY = 100;
		int heartSizeX = 100;
		int heartSizeY = (int)(heartSizeX*0.75);
		int [] x = {heartX, heartX-(heartSizeX/2), heartX+(heartSizeX/2)};
		int [] y = {heartY, heartY-heartSizeY, heartY-heartSizeY};
		
		g.fillPolygon(x, y, 3);
		g.fillOval(heartX-(heartSizeX/2)+1, heartY-heartSizeY-(heartSizeY/4), heartSizeX/2, heartSizeX/2);
		g.fillOval(heartX-1, heartY-heartSizeY-(heartSizeY/4), heartSizeX/2, heartSizeX/2);
		


	}

	
	
}
