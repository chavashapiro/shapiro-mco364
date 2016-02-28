package shapiro.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class BucketTool implements Tool {

	public void mousePressed(Graphics g, int x, int y, BufferedImage image,
			Color color) {
		int srcColor = image.getRGB(x, y);
		int targetColor = color.getRGB();
		if (srcColor != targetColor) {
			fill(image, x, y, srcColor, targetColor);
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
			if (x > 0 && y > 0 && x < image.getWidth() && y < image.getHeight()
					&& image.getRGB(x, y) == srcColor) {

				image.setRGB(x, y, targetColor);

				queue.add(new Point(x - 1, y));
				queue.add(new Point(x + 1, y));
				queue.add(new Point(x, y - 1));
				queue.add(new Point(x, y + 1));
			}
		}

	}

	public void mouseReleased(Graphics g, int x, int y, Color color) {
		// TODO Auto-generated method stub

	}

	public void mouseDragged(Graphics g, int x, int y, Color color) {
		// TODO Auto-generated method stub

	}

	public void drawPreview(Graphics g, Color color) {
		// TODO Auto-generated method stub

	}

}
