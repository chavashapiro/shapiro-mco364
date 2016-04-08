package shapiro.mco364.paint;

import java.awt.Graphics2D;
import java.util.logging.Logger;

public class LineTool implements Tool {

	private static final Logger LOG = Logger.getLogger(LineTool.class.getName());

	private CanvasRepaintManager manager;
	private PaintProperties properties;
	private int x1;
	private int y1;
	private int x2;
	private int y2;

	public LineTool(CanvasRepaintManager manager, PaintProperties properties) {
		this.manager = manager;
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

		String logMessage = String.format("x1=%d y1=%d x2=%d y2=%d", x1, y1, x2, y2);
		LOG.fine(logMessage);
	}

}
