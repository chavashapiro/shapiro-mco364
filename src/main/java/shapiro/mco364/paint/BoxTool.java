package shapiro.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class BoxTool implements Tool {

	private int x1;
	private int y1;
	private int width;
	private int height;
	private int cornerX;
	private int cornerY;

	public void mousePressed(Graphics g, int x, int y, BufferedImage image) {
		x1 = x;
		y1 = y;
		width = 0;
		height = 0;
	}

	public void mouseReleased(Graphics g, int x, int y) {
		g.setColor(Color.MAGENTA);
		width = Math.abs(x1 - x);
		height = Math.abs(y1 - y);
		if (x > x1 && y > y1) {
			g.drawRect(x1, y1, width, height);
		} else if (x < x1 && y < y1) {
			g.drawRect(x1 - width, y1 - height, width, height);
		} else if (x < x1 && y > y1) {
			g.drawRect(x1 - width, y1, width, height);
		} else if (x > x1 && y < y1) {
			g.drawRect(x1, y1 - height, width, height);
		}
	}

	public void mouseDragged(Graphics g, int x, int y) {
		width = Math.abs(x1 - x);
		height = Math.abs(y1 - y);
		if (x > x1 && y > y1) {
			cornerX = x1;
			cornerY = y1;
		} else if (x < x1 && y < y1) {
			cornerX = x1 - width;
			cornerY = y1 - height;
		} else if (x < x1 && y > y1) {
			cornerX = x1 - width;
			cornerY = y1;
		} else if (x > x1 && y < y1) {
			cornerX = x1;
			cornerY = y1 - height;
		}
	}

	public void drawPreview(Graphics g) {
		g.setColor(Color.MAGENTA);
		g.drawRect(cornerX, cornerY, width, height);
	}

}