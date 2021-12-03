package snakegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Snake {
	JFrame frame;
	JPanel panel;
	int width = 1024;
	int height =768;
	int speed=50;
	ArrayList<Madi> snake = new ArrayList<Madi>();
	
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
		frame.setSize(width,height);
		frame.setVisible(true);
		

		
		snake.add(new Madi(x,y));
		snake.add(new Madi(x-1,y));
		snake.add(new Madi(x-2,y));
		snake.add(new Madi(x-3,y));
		
		foodX = (int)(Math.random()*width);
		foodY = (int)(Math.random()*height);
		
	}
	
	
	public void start() {
		while(true) {
			
			x+= xDirection;
			y+= yDirection;
			

			
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
			
			
			
			g.setColor(Color.WHITE);
			for(Madi madi:snake) {
				g.fillRect(madi.getX()*size, madi.getY()*size, size , size );
			}
			
//			g.setColor(new Color((int)(Math.random()*100),(int)(Math.random()*100),(int)(Math.random()*100)));
			g.setColor(Color.BLUE);
			g.fillOval(foodX*size, foodY*size, size, size);
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
	
}
