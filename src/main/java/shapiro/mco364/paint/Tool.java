package shapiro.mco364.paint;

import java.awt.Graphics2D;

public interface Tool {

	void mousePressed(Graphics2D g, int x, int y);

	void mouseReleased(Graphics2D g, int x, int y);

	void mouseDragged(Graphics2D g, int x, int y);

	void drawPreview(Graphics2D g);

}
