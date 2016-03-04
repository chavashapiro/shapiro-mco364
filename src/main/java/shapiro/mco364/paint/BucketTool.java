package shapiro.mco364.paint;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class BucketTool implements Tool {
	
	private PaintProperties properties;
	
	public BucketTool(PaintProperties properties) {
		this.properties = properties;
	}

	public void mousePressed(Graphics g, int x, int y) {
		int srcColor = properties.getImage().getRGB(x, y);
		int targetColor = properties.getColor().getRGB();
		if (srcColor != targetColor) {
			fill(properties.getImage(), x, y, srcColor, targetColor);
		}
	}

	private void fill(BufferedImage image, int x, int y, int srcColor,
			int targetColor) {
		Point point = new Point(x, y);
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(point);

		while (!queue.isEmpty()) {
			Point p = queue.remove();
			x = p.getX();
			y = p.getY();
			if (x > 0 && y > 0 && x < properties.getWidth() && y < properties.getHeight()
					&& image.getRGB(x, y) == srcColor) {

				image.setRGB(x, y, targetColor);

				queue.add(new Point(x - 1, y));
				queue.add(new Point(x + 1, y));
				queue.add(new Point(x, y - 1));
				queue.add(new Point(x, y + 1));
			}
		}

	}

	public void mouseReleased(Graphics g, int x, int y) {
		// TODO Auto-generated method stub

	}

	public void mouseDragged(Graphics g, int x, int y) {
		// TODO Auto-generated method stub

	}

	public void drawPreview(Graphics g) {
		// TODO Auto-generated method stub

	}

}
