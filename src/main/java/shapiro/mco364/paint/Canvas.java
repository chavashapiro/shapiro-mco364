package shapiro.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Stack;

import javax.swing.JPanel;

public class Canvas extends JPanel {

	private Stack<BufferedImage> undo;
	private Stack<BufferedImage> redo;
	private BufferedImage buffer;
	private Tool tool;
	private Color color;

	public Canvas() {

		undo = new Stack<BufferedImage>();
		redo = new Stack<BufferedImage>();
		buffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		tool = new PencilTool();
		color = Color.BLACK;

		this.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent event) {

			}

			public void mouseEntered(MouseEvent event) {

			}

			public void mouseExited(MouseEvent event) {

			}

			public void mousePressed(MouseEvent event) {
				undo.push(copyImage(buffer));

				tool.mousePressed(buffer.getGraphics(), event.getX(), event.getY(), buffer, color);
				repaint();

			}

			public void mouseReleased(MouseEvent event) {
				tool.mouseReleased(buffer.getGraphics(), event.getX(), event.getY(), color);
				repaint();
			}

		});

		addMouseMotionListener(new MouseMotionListener() {

			public void mouseDragged(MouseEvent event) {
				tool.mouseDragged(buffer.getGraphics(), event.getX(), event.getY(), color);
				repaint();
			}

			public void mouseMoved(MouseEvent event) {

			}

		});
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.drawImage(buffer, 0, 0, null);
		tool.drawPreview(g, color);
	}

	public void setTool(Tool newTool) {
		this.tool = newTool;
	}

	public void setColor(Color newColor) {
		this.color = newColor;
	}

	public void undo() {
		if (!undo.isEmpty()) {
			redo.push(copyImage(buffer));

			buffer = undo.pop();
			repaint();
		}
	}

	public void redo() {
		if (!redo.isEmpty()) {
			undo.push(copyImage(buffer));

			buffer = redo.pop();
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
