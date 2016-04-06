package shapiro.mco364.paint;

import java.awt.Graphics2D;

public class PencilTool implements Tool {

	private PaintProperties properties;
	private Integer previousX;
	private Integer previousY;

	public PencilTool(PaintProperties properties) {
		this.properties = properties;
	}

	public void mousePressed(Graphics2D g, int x, int y) {
		previousX = null;
		previousY = null;

		g.setColor(properties.getColor());
		// g.setStroke(properties.getStroke());
		g.drawLine(x, y, x, y);

	}

	public void mouseReleased(Graphics2D g, int x, int y) {
		// TODO Auto-generated method stub

	}

	public void mouseDragged(Graphics2D g, int x, int y) {
		g.setColor(properties.getColor());
		// g.setStroke(properties.getStroke());
		g.drawLine(x, y, x, y);
		if (previousX != null && previousY != null) {
			g.drawLine(previousX, previousY, x, y);
		}

		previousX = x;
		previousY = y;

	}

	public void drawPreview(Graphics2D g) {
		// TODO Auto-generated method stub

	}

}
