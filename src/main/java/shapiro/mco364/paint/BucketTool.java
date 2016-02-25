package shapiro.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class BucketTool implements Tool {

	boolean[][] visited;

	public void mousePressed(Graphics g, int x, int y, BufferedImage image) {
		if (image.getRGB(x, y) != Color.MAGENTA.getRGB()) {
			visited = new boolean[image.getHeight()][image.getWidth()];
			fill(image, x, y);
		}
	}

	private void fill(BufferedImage image, int x, int y) {
		if (x < 0 || y < 0 || x >= image.getWidth() || y >= image.getHeight()) {
			return;
		}

		if (visited[y][x]) {
			return;
		}

		if (image.getRGB(x, y) != Color.MAGENTA.getRGB()) {
			return;
		}

		visited[y][x] = true;
		image.setRGB(x, y, Color.MAGENTA.getRGB());

		fill(image, x - 1, y);
		fill(image, x + 1, y);
		fill(image, x, y - 1);
		fill(image, x, y + 1);

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
