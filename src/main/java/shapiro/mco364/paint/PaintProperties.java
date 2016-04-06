package shapiro.mco364.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;
import java.awt.image.BufferedImage;

import javax.inject.Singleton;

@Singleton
public class PaintProperties {

	private int width; // of canvas
	private int height; // of canvas
	private BufferedImage image;
	private Color color;
	private BasicStroke stroke;
	private boolean fill;

	public PaintProperties() {
		image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		width = image.getWidth();
		height = image.getHeight();
		color = Color.BLACK;
		stroke = new BasicStroke(6);
		fill = false;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Stroke getStroke() {
		return stroke;
	}

	public void setWeight(int weight) {
		this.stroke = new BasicStroke(weight);
	}

	public boolean isFill() {
		return fill;
	}

	public void setFill(boolean fill) {
		this.fill = fill;
	}
}
