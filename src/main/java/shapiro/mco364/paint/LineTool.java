package shapiro.mco364.paint;

import java.awt.Graphics2D;

public class LineTool implements Tool {

	private PaintProperties properties;
	private int x1;
	private int y1;
	private int x2;
	private int y2;

	public LineTool(PaintProperties properties) {
		this.properties = properties;
	}

	public void mousePressed(Graphics2D g, int x, int y) {
		x1 = x;
		y1 = y;
		x2 = x;
		y2 = y;

	}

	public void mouseReleased(Graphics2D g, int x, int y) {

		g.setColor(properties.getColor());
		g.drawLine(x1, y1, x, y);

	}

	public void mouseDragged(Graphics2D g, int x, int y) {
		x2 = x;
		y2 = y;

	}

	public void drawPreview(Graphics2D g) {
		g.setColor(properties.getColor());
		g.drawLine(x1, y1, x2, y2);

	}

}
