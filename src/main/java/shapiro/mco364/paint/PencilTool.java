package shapiro.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class PencilTool implements Tool {

	private Integer previousX;
	private Integer previousY;

	public void mousePressed(Graphics g, int x, int y, BufferedImage image) {
		previousX = null;
		previousY = null;

		g.setColor(Color.MAGENTA);
		g.drawLine(x, y, x, y);

	}

	public void mouseReleased(Graphics g, int x, int y) {
		// TODO Auto-generated method stub

	}

	public void mouseDragged(Graphics g, int x, int y) {
		g.setColor(Color.MAGENTA);
		g.drawLine(x, y, x, y);
		if (previousX != null && previousY != null) {
			g.drawLine(previousX, previousY, x, y);
		}

		previousX = x;
		previousY = y;

	}

	public void drawPreview(Graphics g) {
		// TODO Auto-generated method stub

	}

}
