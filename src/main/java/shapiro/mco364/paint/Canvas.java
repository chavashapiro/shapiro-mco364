package shapiro.mco364.paint;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Canvas extends JPanel {

	private BufferedImage buffer;
	private Tool tool;

	public Canvas() {

		buffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		tool = new LineTool();

		this.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent event) {

			}

			public void mouseEntered(MouseEvent event) {

			}

			public void mouseExited(MouseEvent event) {

			}

			public void mousePressed(MouseEvent event) {

				tool.mousePressed(buffer.getGraphics(), event.getX(), event.getY());
				repaint();

			}

			public void mouseReleased(MouseEvent event) {
				tool.mouseReleased(buffer.getGraphics(), event.getX(), event.getY());
				
				repaint();

			}

		});

		addMouseMotionListener(new MouseMotionListener() {

			public void mouseDragged(MouseEvent event) {
				tool.mouseDragged(buffer.getGraphics(), event.getX(), event.getY());
				
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
		tool.drawPreview(g);
	}

}
