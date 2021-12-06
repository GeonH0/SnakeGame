package snakegame;

public class Food {
	int x= 0;
	int y =0;
	int color;
	
	public Food(int x, int y) {
		this.x= x;
		this.y= y;
		color = (int)(Math.random()*0xFFFFFF);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

}
