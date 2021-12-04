package snakegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Snake {
	JFrame frame;
	JPanel panel;
	int width = 100;
	int height =70;
	int speed=50;
	ArrayList<Madi> snake = new ArrayList<Madi>();
	ArrayList<Food> foods = new ArrayList<Food>();
	
	int x=10;//픽 단위
	int y =10;//
	
	int xDirection=1;
	int yDirection =0;
	
	int foodX =0;
	int foodY =0;
	
	int size=10;

	public Snake() {
		frame = new JFrame("뱀 게임");
		Gamepanel gamepanle = new Gamepanel();
		frame.getContentPane().add(gamepanle);
		
		
		frame.addKeyListener(new MyListenr());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width*size,height*size);
		frame.setVisible(true);
		

		
		snake.add(new Madi(x,y));
		snake.add(new Madi(x-1,y));
		snake.add(new Madi(x-2,y));
		snake.add(new Madi(x-3,y));
		
		for(int i=0;i<10;i++) {
		
			foodX = (int)(Math.random()*(int)(width));
			foodY = (int)(Math.random()*(int)(height));
			foods.add(new Food(foodX,foodY));
		}
		
		
	}
	
	
	public void start() {
		while(true) {
			
			if((snake.get(0).getX()<0)) {
				xDirection=1;
				yDirection=0;
			}
			else if((snake.get(0).getX()>width)) {
				xDirection=-1;
				yDirection=0;
			}
			else if(snake.get(0).getY()<0) {
				xDirection=0;
				yDirection=1;
			}
			else if(snake.get(0).getY()>height) {
				xDirection=0;
				yDirection=-1;
			}
			x+= xDirection;
			y+= yDirection;
			int lenght = snake.size();
			
			int lastX = snake.get(lenght-1).getX();
			int lastY = snake.get(lenght-1).getY();
			
			for(int i = lenght-1;i>0;i--) {
				snake.get(i).setX(snake.get(i-1).getX());
				snake.get(i).setY(snake.get(i-1).getY());
			}
			

			
			snake.get(0).setX(snake.get(0).getX()+xDirection);
			snake.get(0).setY(snake.get(0).getY()+yDirection);
			
			Iterator iter = foods.iterator();
			
			
			
			while(iter.hasNext()) {
				
			Food food = (Food) iter.next();
		if((snake.get(0).getX()==food.getX())&&(snake.get(0).getY()==food.getY())) {
					snake.add(new Madi(lastX,lastY));
					iter.remove();
					

	
		}
			

	}
			


			

			
			frame.repaint();
			
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
			
			
			
			
			for(Madi madi:snake) {
				if(snake.get(0)==madi) {
					g.setColor(Color.red);
					g.fillRect(madi.getX()*size, madi.getY()*size, size , size );
				}
				else {
					
				
				g.setColor(Color.black);
				g.fillRect(madi.getX()*size, madi.getY()*size, size , size );
				}
			}
			

			for(Food food:foods) {
				g.setColor(new Color(food.color));
				g.fillOval(food.getX()* size, food.getY() * size, size, size);	
			}
			
		}
	}
	
	private class MyListenr implements KeyListener{

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
			}
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	private class ConverseListner implements KeyListener{

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
			}
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
