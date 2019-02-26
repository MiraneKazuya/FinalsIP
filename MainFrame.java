import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainFrame extends JFrame implements KeyListener{

	MainDraw gameDraw;

	public MainFrame(){
		this.gameDraw = new MainDraw();
	}

	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			gameDraw.moveRight();
			System.out.println("Position: " + gameDraw.x + ", " + gameDraw.y);
		}

		else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			gameDraw.moveLeft();
			System.out.println("Position: " + gameDraw.x + ", " + gameDraw.y);
		}

		else if(e.getKeyCode() == KeyEvent.VK_UP){
			gameDraw.moveUp();
			System.out.println("Position: " + gameDraw.x + ", " + gameDraw.y);
		}

		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			gameDraw.moveDown();
			System.out.println("Position: " + gameDraw.x + ", " + gameDraw.y);
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE){
			gameDraw.jump();
		}	
		else if(e.getKeyCode() == KeyEvent.VK_A){
			gameDraw.bowing();
		}	
		else if(e.getKeyCode() == KeyEvent.VK_S){
			gameDraw.bowingTwo();
		}	
	}

	public void keyReleased(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			gameDraw.idleBruh = true;
			gameDraw.idleAnimation();
		}

		else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			gameDraw.idleBruh = true;
			gameDraw.idleAnimation();
		}

		else if(e.getKeyCode() == KeyEvent.VK_UP){
			gameDraw.idleBruh = true;
			gameDraw.idleAnimation();
		}

		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			gameDraw.idleBruh = true;
			gameDraw.idleAnimation();
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE){
			gameDraw.idleBruh = true;
			gameDraw.idleAnimation();
		}	
		else if(e.getKeyCode() == KeyEvent.VK_A){
			gameDraw.idleBruh = true;	
			
		}	
		else if(e.getKeyCode() == KeyEvent.VK_S){
			gameDraw.idleBruh = true;
		
		}	
	}

	public void keyTyped(KeyEvent e){

	}

	public static void main(String args[]){
		MainFrame gameFrame = new MainFrame();
		gameFrame.setSize(600,600);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setVisible(true);
		gameFrame.getContentPane().add(gameFrame.gameDraw);
		gameFrame.addKeyListener(gameFrame);
		System.out.println("BRUH");
	}

}