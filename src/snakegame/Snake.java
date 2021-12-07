package snakegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Snake {
	JFrame frame;
	JPanel panel;
	JOptionPane option;
	int width = 190;
	int height =100;
	int speed=70;
	ArrayList<Madi> snake = new ArrayList<Madi>();
	ArrayList<Food> foods = new ArrayList<Food>();
	ArrayList<Madi> snake2 = new ArrayList<Madi>();
	
	int x=10,x2=width-10;
	int y =10,y2=10;
	
	int xDirection=1;
	int yDirection =0;
	
	int xDirection1=-1;
	int yDirection1 =0;
	
	
	int foodX =0;
	int foodY =0;
	
	int size=10;

	public Snake() {
		frame = new JFrame("뱀 게임");
		option = new JOptionPane();
		Gamepanel gamepanle = new Gamepanel();
		frame.getContentPane().add(gamepanle);
		gamepanle.setBackground(Color.black);
		
		
		frame.addKeyListener(new MyListener());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width*size,height*size);
		frame.setVisible(true);
		

		
		snake.add(new Madi(x,y));
		snake.add(new Madi(x-1,y));
		snake.add(new Madi(x-2,y));
		snake.add(new Madi(x-3,y));
		
		snake2.add(new Madi(x2,y2));
		snake2.add(new Madi(x2-1,y2));
		snake2.add(new Madi(x2-2,y2));
		snake2.add(new Madi(x2-3,y2));
		
		
		
		for(int i=0;i<20;i++) {
		
			foodX = (int)(Math.random()*(int)(width));
			foodY = (int)(Math.random()*(int)(height));
			foods.add(new Food(foodX,foodY));
		}
		
		
		
	}
	
	
	public void start() {
		while(true) {
			int lenght = snake.size();
			int lenght2 = snake2.size();
			
			if((snake.get(0).getX()<0)||(snake2.get(0).getX()<0)) {
				if((snake.get(0).getX()<0)) {
					option.showMessageDialog(null,"승자:snake2 \n점수는: "+lenght2,"승리자",option.INFORMATION_MESSAGE);
					System.exit(0);
				}
				else {
					option.showMessageDialog(null,"승자:snake1 \n점수는: "+lenght,"승리자",option.INFORMATION_MESSAGE);
					System.exit(0);
				}

			}
			else if((snake.get(0).getX()>width)||(snake2.get(0).getX()>width)) {
				if((snake.get(0).getX()>width)) {
					option.showMessageDialog(null,"승자:snake2 \n점수는: "+lenght2,"승리자",option.INFORMATION_MESSAGE);
					System.exit(0);
				}
				else {
					option.showMessageDialog(null,"승자:snake1 \n점수는: "+lenght,"승리자",option.INFORMATION_MESSAGE);
					System.exit(0);
				}
			}
			else if((snake.get(0).getY()<0)||(snake2.get(0).getY()<0)) {
				if((snake.get(0).getY()<0)) {
					option.showMessageDialog(null,"승자:snake2 \n점수는: "+lenght2,"승리자",option.INFORMATION_MESSAGE);
					System.exit(0);
				}
				else {
					option.showMessageDialog(null,"승자:snake1 \n점수는: "+lenght,"승리자",option.INFORMATION_MESSAGE);
					System.exit(0);
				}
			}
			else if((snake.get(0).getY()>height)||(snake2.get(0).getY()>height)) {
				if((snake.get(0).getY()>height)) {
					option.showMessageDialog(null,"승자:snake2 \n점수는: "+lenght2,"승리자",option.INFORMATION_MESSAGE);
					System.exit(0);
				}
				else {
					option.showMessageDialog(null,"승자:snake1 \n점수는: "+lenght,"승리자",option.INFORMATION_MESSAGE);
					System.exit(0);
				}
			}
			
			for(int i=0;i<lenght;i++) {
				for(int j=0;j<lenght2;j++) {
					if((snake.get(i).getX()==snake2.get(j).getX())&&(snake.get(i).getY()==snake2.get(j).getY())) {
						if((lenght<lenght2)) {
							option.showMessageDialog(null,"승자:snake2 \n점수는: "+lenght2,"승리자",option.INFORMATION_MESSAGE);
							System.exit(0);
						}
						else {
							option.showMessageDialog(null,"승자:snake1 \n점수는: "+lenght,"승리자",option.INFORMATION_MESSAGE);
							System.exit(0);
						}

					}
					
				}
			}

			
			
			x+= xDirection;
			y+= yDirection;
			
			x2+=xDirection1;
			y2+=yDirection1;
			
			
			int lastX = snake.get(lenght-1).getX();
			int lastY = snake.get(lenght-1).getY();
			
			int lastX2 = snake2.get(lenght2-1).getX();
			int lastY2 = snake2.get(lenght2-1).getY();
			
			for(int i = lenght-1;i>0;i--) {
				snake.get(i).setX(snake.get(i-1).getX());
				snake.get(i).setY(snake.get(i-1).getY());
			}
			
			for(int i=lenght2-1;i>0;i--) {
				snake2.get(i).setX(snake2.get(i-1).getX());
				snake2.get(i).setY(snake2.get(i-1).getY());
			}
			
			

			
			snake.get(0).setX(snake.get(0).getX()+xDirection);
			snake.get(0).setY(snake.get(0).getY()+yDirection);
			
			snake2.get(0).setX(snake2.get(0).getX()+xDirection1);
			snake2.get(0).setY(snake2.get(0).getY()+yDirection1);
			
			Iterator iter = foods.iterator();
			
			
			
			while(iter.hasNext()) {
			Food food = (Food) iter.next();
		if((snake.get(0).getX()==food.getX())&&(snake.get(0).getY()==food.getY())) {
					if((food.getColor()>0x00FFFF)&&(food.getColor()<0x191970)) {
						frame.addKeyListener(new ConverseListener());
					}
					else {
						frame.addKeyListener(new MyListener());
					}
					snake.add(new Madi(lastX,lastY));
					iter.remove();
					
							}
		if((snake2.get(0).getX()==food.getX())&&(snake2.get(0).getY()==food.getY())) {
			if((food.getColor()>0x00FFFF)&&(food.getColor()<0x191970)) {
				frame.addKeyListener(new ConverseListener());
			}
			else {
				frame.addKeyListener(new MyListener());
			}
			snake2.add(new Madi(lastX2,lastY2));
			iter.remove();
			
					}
		}
			
		
			if(foods.isEmpty()) {

					for(int i=0;i<10;i++) {
						
						foodX = (int)(Math.random()*(int)(width));
						foodY = (int)(Math.random()*(int)(height));
						foods.add(new Food(foodX,foodY));
					
				}
			}
			



			

			
			frame.repaint();
			if(snake.size()>10) {
				speed = 30;
			}
			
			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private class Gamepanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.setColor(Color.black);
			
			
			for(Madi madi:snake) {
				if(snake.get(0)==madi) {
					g.setColor(Color.green);
					g.drawRect(madi.getX()*size, madi.getY()*size, size , size);
					g.setColor(Color.red);
					g.fillRect(madi.getX()*size, madi.getY()*size, size , size );
				}
				else {
				g.setColor(Color.green);
				g.drawRect(madi.getX()*size, madi.getY()*size, size , size);
				g.setColor(Color.white);
				g.fillRect(madi.getX()*size, madi.getY()*size, size , size );
				
				}
			}
			
			for(Madi madi:snake2) {
				if(snake2.get(0)==madi) {
					g.setColor(Color.green);
					g.drawRect(madi.getX()*size, madi.getY()*size, size , size);
					g.setColor(Color.blue);
					g.fillRect(madi.getX()*size, madi.getY()*size, size , size );
				}
				else {
				g.setColor(Color.green);
				g.drawRect(madi.getX()*size, madi.getY()*size, size , size);
				g.setColor(Color.white);
				g.fillRect(madi.getX()*size, madi.getY()*size, size , size );
				}
			}
			

			for(Food food:foods) {
				g.setColor(new Color(food.color));
				g.fillOval(food.getX()* size, food.getY() * size, size, size);	
			}
			
		}
	}
	
	private class MyListener implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				xDirection=0;
				yDirection=-1;
				break;
			case KeyEvent.VK_DOWN:
				xDirection=0;
				yDirection=1;
				break;
			case KeyEvent.VK_LEFT:
				xDirection=-1;
				yDirection=0;
				break;
			case KeyEvent.VK_RIGHT:
				xDirection=1;
				yDirection=0;
				break;
			case KeyEvent.VK_W:
				xDirection1=0;
				yDirection1=-1;
				break;
			case KeyEvent.VK_S:
				xDirection1=0;
				yDirection1=1;
				break;
			case KeyEvent.VK_A:
				xDirection1=-1;
				yDirection1=0;
				break;
			case KeyEvent.VK_D:
				xDirection1=1;
				yDirection1=0;
				break;
			}
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	private class ConverseListener implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			switch (e.getKeyCode()) {
			case KeyEvent.VK_DOWN:
				xDirection=0;
				yDirection=-1;
				break;
			case KeyEvent.VK_UP:
				xDirection=0;
				yDirection=1;
				break;
			case KeyEvent.VK_RIGHT:
				xDirection=-1;
				yDirection=0;
				break;
			case KeyEvent.VK_LEFT:
				xDirection=1;
				yDirection=0;
				break;
			case KeyEvent.VK_S:
				xDirection1=0;
				yDirection1=-1;
				break;
			case KeyEvent.VK_W:
				xDirection1=0;
				yDirection1=1;
				break;
			case KeyEvent.VK_D:
				xDirection1=-1;
				yDirection1=0;
				break;
			case KeyEvent.VK_A:
				xDirection1=1;
				yDirection1=0;
				break;
			}
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
