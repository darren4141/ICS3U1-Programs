import java.applet.Applet;
import java.awt.*;

public class RectanglePictures extends Applet{

	public void init(){
		resize(1000, 1000);
	}
	
	public void paint (Graphics g){
		drawPicture(175,175,325,325,g);
		
	}
	
	public void drawPicture(int x1, int y1, int x2, int y2, Graphics g){
		final double ratioHeight = Math.sqrt(3) / 2;
		drawRectangle(x1, y1, x2, y2, g);
		
		//[175, 175], [175, 325], [(x - height), (avg y)]
		drawTri(x1, y1, x1, y2, (x1 - ((int)Math.round(ratioHeight))*(y2-y1)), (y1+y2)/2, g); //LEFT TRIANGLE
		drawTri(x1, y1, x2, y1, (x1+x2)/2, (y1 - ((int)Math.round(ratioHeight)*(x2-x1))), g); //TOP TRIANGLE
		drawTri(x2, y1, x2, y2, (x2 + ((int)Math.round(ratioHeight))*(y2-y1)), (y1+y2)/2, g); //RIGHT TRIANGLE
		drawTri(x1, y2, x2, y2, (x1+x2)/2, (y2 + ((int)Math.round(ratioHeight)*(x2-x1))), g); //BOTTOM TRANGLE
		
	}
	
	public void drawRectangle(int x1, int y1, int x2, int y2, Graphics g){
		g.fillRect(x1, y1, x2-x1, y2-y1);
	}
	
	public void drawTri(int x1, int y1, int x2, int y2, int x3, int y3, Graphics g){
		int[] x = {x1, x2, x3};
		int[] y = {y1, y2, y3};
		g.drawPolygon(x, y, 3);
		
	}
	
}
