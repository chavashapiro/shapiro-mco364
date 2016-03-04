package shapiro.mco364.paint;

import java.awt.Graphics;

public class OvalTool implements Tool {

	private PaintProperties properties;
	private int x1;
	private int y1;
	private int width;
	private int height;
	private int cornerX;
	private int cornerY;	

	public OvalTool(PaintProperties properties) {
		this.properties = properties;
	}

	public void mousePressed(Graphics g, int x, int y) {
		x1 = x;
		y1 = y;
		width = 0;
		height = 0;
	}

	public void mouseReleased(Graphics g, int x, int y) {
		g.setColor(properties.getColor());
		width = Math.abs(x1 - x);
		height = Math.abs(y1 - y);
		if (x > x1 && y > y1) {
			g.drawOval(x1, y1, width, height);
		} else if (x < x1 && y < y1) {
			g.drawOval(x1 - width, y1 - height, width, height);
		} else if (x < x1 && y > y1) {
			g.drawOval(x1 - width, y1, width, height);
		} else if (x > x1 && y < y1) {
			g.drawOval(x1, y1 - height, width, height);
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
		g.setColor(properties.getColor());
		g.drawOval(cornerX, cornerY, width, height);
	}

}
