package shapiro.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class PencilTool implements Tool {

	private Integer previousX;
	private Integer previousY;

	public void mousePressed(Graphics g, int x, int y, BufferedImage image,
			Color color) {
		previousX = null;
		previousY = null;

		g.setColor(color);
		g.drawLine(x, y, x, y);

	}

	public void mouseReleased(Graphics g, int x, int y, Color color) {
		// TODO Auto-generated method stub

	}

	public void mouseDragged(Graphics g, int x, int y, Color color) {
		g.setColor(color);
		g.drawLine(x, y, x, y);
		if (previousX != null && previousY != null) {
			g.drawLine(previousX, previousY, x, y);
		}

		previousX = x;
		previousY = y;

	}

	public void drawPreview(Graphics g, Color color) {
		// TODO Auto-generated method stub

	}

}
