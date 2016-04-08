package shapiro.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Stack;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.JPanel;

@Singleton
public class Canvas extends JPanel {

	private Stack<BufferedImage> undo;
	private Stack<BufferedImage> redo;
	private Tool tool;
	private PaintProperties properties;

	@Inject
	public Canvas(final PaintProperties properties) {

		this.properties = properties;
		undo = new Stack<BufferedImage>();
		redo = new Stack<BufferedImage>();
		tool = new PencilTool(properties);

		this.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent event) {

			}

			public void mouseEntered(MouseEvent event) {

			}

			public void mouseExited(MouseEvent event) {

			}

			public void mousePressed(MouseEvent event) {
				undo.push(copyImage(properties.getImage()));

				tool.mousePressed((Graphics2D) properties.getImage().getGraphics(), event.getX(), event.getY());
				repaint();

			}

			public void mouseReleased(MouseEvent event) {
				tool.mouseReleased((Graphics2D) properties.getImage().getGraphics(), event.getX(), event.getY());
				repaint();
			}

		});

		addMouseMotionListener(new MouseMotionListener() {

			public void mouseDragged(MouseEvent event) {
				tool.mouseDragged((Graphics2D) properties.getImage().getGraphics(), event.getX(), event.getY());
				repaint();
			}

			public void mouseMoved(MouseEvent event) {

			}

		});
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.drawImage(properties.getImage(), 0, 0, null);
		tool.drawPreview((Graphics2D) g);
	}

	public void setTool(Tool newTool) {
		this.tool = newTool;
	}

	public void setColor(Color newColor) {
		properties.setColor(newColor);
	}

	public void undo() {
		if (!undo.isEmpty()) {
			redo.push(copyImage(properties.getImage()));

			properties.setImage(undo.pop());
			repaint();
		}
	}

	public void redo() {
		if (!redo.isEmpty()) {
			undo.push(copyImage(properties.getImage()));

			properties.setImage(redo.pop());
			repaint();
		}
	}

	private BufferedImage copyImage(BufferedImage image) {
		BufferedImage newBuffer = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
		Graphics2D g2d = newBuffer.createGraphics();
		g2d.drawImage(image, 0, 0, null);

		return newBuffer;
	}
}
