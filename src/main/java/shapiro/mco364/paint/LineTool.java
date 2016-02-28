package shapiro.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class LineTool implements Tool {

	private int x1;
	private int y1;
	private int x2;
	private int y2;

	public void mousePressed(Graphics g, int x, int y, BufferedImage image,
			Color color) {
		x1 = x;
		y1 = y;
		x2 = x;
		y2 = y;

	}

	public void mouseReleased(Graphics g, int x, int y, Color color) {

		g.setColor(color);
		g.drawLine(x1, y1, x, y);

	}

	public void mouseDragged(Graphics g, int x, int y, Color color) {
		x2 = x;
		y2 = y;

	}

	public void drawPreview(Graphics g, Color color) {
		g.setColor(color);
		g.drawLine(x1, y1, x2, y2);

	}

}
