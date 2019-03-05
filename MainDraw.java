import javax.swing.JComponent;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.awt.Rectangle;

public class MainDraw extends JComponent{

	public boolean idleBruh = true;

	private BufferedImage image;
	private BufferedImage backgroundImage;
	public URL resource = getClass().getResource("Running/run0.png");
	public URL idleImages[];

	public int x = 75;
	public int y = 150;

	public int state = 0;

	public int HEALTH = 200;
	public int MANA = 200;

	MainMonster monster;

	public MainDraw(){
		//idleAnimation();
		try{
			image = ImageIO.read(resource);
			backgroundImage = ImageIO.read(getClass().getResource("background.jpg"));
		}
		catch(IOException e){
			e.printStackTrace();
		}
		monster = new MainMonster(200, 200);
		startGame();
	}

	public void reloadImageRun(){
		state++;

		if(state == 0){
			resource = getClass().getResource("Running/run0.png");
		}
		else if(state == 1){
			resource = getClass().getResource("Running/run1.png");
		}
		else if(state == 2){
			resource = getClass().getResource("Running/run2.png");
		}
		else if(state == 3){
			resource = getClass().getResource("Running/run3.png");
		}
		else if(state == 4){
			resource = getClass().getResource("Running/run4.png");
		}
		else if(state == 5){
			resource = getClass().getResource("Running/run5.png");
			state = 0;
		}
		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}

	}

	public void jumpingAnimation(){
		Thread thread = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 10; ctr++){
					try {
						if(ctr==9){
							resource = getClass().getResource("Running/run0.png");
						}
						else{
							resource = getClass().getResource("Jump/jump"+ctr+".png");
						}
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
				        repaint();
				        Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread.start();
	}

	public void bowAnimation(){
		Thread thread1 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 11; ctr++){
					try {
						if(ctr==10){
							resource = getClass().getResource("Running/run0.png");
						}
						else{
							resource = getClass().getResource("Archery/bow"+ctr+".png");
						}
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
				        repaint();
				        Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread1.start();
	}

	public void bowJumpAnimation(){
		Thread thread1 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 9; ctr++){
					try {
						if(ctr==8){
							resource = getClass().getResource("Running/run0.png");
						}
						else{
							resource = getClass().getResource("Archery2/advenBow"+ctr+".png");
						}
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
				        repaint();
				        Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread1.start();
	}

	/*public void idleAnimation(){
		idleImages = new URL [3];
		state = 0;
		Thread thread2 = new Thread(new Runnable(){
			public void run(){
				while(idleBruh){
					for(int ctr = 0;ctr < 3; ctr++){
							if(ctr == state){
								idleImages[ctr] = getClass().getResource("Idle/idle"+ctr+ ".png");
								resource = idleImages[ctr];
							}
							else if(state > 4){
								idleImages[ctr] = getClass().getResource("Idle/idle"+ctr+ ".png");
								state = 0;
								ctr = 0;
							}
							repaint();
							state++;
			        		
							
							try{
								image = ImageIO.read(resource);
								Thread.sleep(1000/20);
							}catch(IOException e){
								e.printStackTrace();
							}catch(InterruptedException e){
								e.printStackTrace();
							}
			        		
							
						}
					}
				}
			
		});
		thread2.start();
	}*/

	public void startGame(){
		Thread gameThread = new Thread(new Runnable(){
			public void run(){
				while(true){
					try{
							if(monster!=null){
								monster.moveTo(x,y);
								//bothCollision();
								repaint();
							}
						Thread.sleep(100);
					} catch (InterruptedException e) {
							e.printStackTrace();
					}
				}
			}
		});
		gameThread.start();
	}

	public void jump(){
		jumpingAnimation();
		idleBruh = false;
	}

	public void bowing(){
		bowAnimation();
		idleBruh = false;
	}

	public void bowingTwo(){
		bowJumpAnimation();
		idleBruh = false;
	}

	public void moveUp(){
		y = y - 5;
		idleBruh = false;
		reloadImageRun();
		repaint();
	}

	public void moveDown(){
		y = y + 5;
		idleBruh = false;
		reloadImageRun();
		repaint();
	}

	public void moveLeft(){
		x = x - 5;
		idleBruh = false;
		reloadImageRun();
		repaint();
	}

	public void moveRight(){
		x = x + 5;
		idleBruh = false;
		reloadImageRun();
		repaint();
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.YELLOW);
		g.drawImage(backgroundImage, 0, 0, this);
		g.drawImage(image, x, y, this);

		g.setColor(Color.gray);
		g.fillRect(5, 5, 200, 20);
		g.setColor(Color.red);
		g.fillRect(5, 5, HEALTH, 20);
		g.setColor(Color.blue);
		g.fillRect(5, 30, MANA, 20);
		
		g.drawImage(monster.image, monster.xPos, monster.yPos, this);
	}

}