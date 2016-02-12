package shapiro.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Canvas extends JPanel {
	
	private BufferedImage buffer;
	private Integer previousX;
	private Integer previousY;

	public Canvas() {
		
		buffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);

		this.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent event) {

			}

			public void mouseEntered(MouseEvent event) {

			}

			public void mouseExited(MouseEvent event) {

			}

			public void mousePressed(MouseEvent event) {
				
				previousX = null;
				previousY = null;
				
				Graphics g = buffer.getGraphics();
				g.setColor(Color.MAGENTA);
				g.drawLine(event.getX(), event.getY(), event.getX(), event.getY());
				
				repaint();

			}

			public void mouseReleased(MouseEvent event) {

			}

		});

		addMouseMotionListener(new MouseMotionListener() {

			public void mouseDragged(MouseEvent event) {
				Graphics g = buffer.getGraphics();
				g.setColor(Color.MAGENTA);
				g.drawLine(event.getX(), event.getY(), event.getX(), event.getY());
				if (previousX != null && previousY != null) {
					g.drawLine(previousX, previousY, event.getX(), event.getY());
				}
				
				previousX = event.getX();
				previousY = event.getY();
				
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
	}

}
