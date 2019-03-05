import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.awt.Rectangle;

public class MainMonster{
	
	public int xPos = 150;
	public int yPos = 300;

	public BufferedImage image;
	public URL resource = getClass().getResource("Slime/idle0.png");

	public MainMonster(){
		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public MainMonster(int xPass, int yPass){
		xPos = xPass;
		yPos = yPass;

		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}

	public void moveTo(int toX, int toY){
		if(xPos<toX){
			xPos++;
		}
		else if(xPos>toX){
			xPos--;
		}

		if(yPos<toY){
			yPos++;
		}
		else if(yPos>toY){
			yPos--;
		}
	}
	
}