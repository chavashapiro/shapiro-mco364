package shapiro.mco364.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PaintFrame extends JFrame {

	public PaintFrame() {

		setTitle("PaintFrame");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		final Canvas canvas = new Canvas();
		container.add(canvas, BorderLayout.CENTER);

		JPanel panel = new JPanel();

		JButton pencilButton = new JButton("Pencil");
		pencilButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				canvas.setTool(new PencilTool());
			}

		});
		panel.add(pencilButton);

		JButton lineButton = new JButton("Line");
		lineButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				canvas.setTool(new LineTool());
			}

		});
		panel.add(lineButton);

		JButton boxButton = new JButton("Box");
		boxButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				canvas.setTool(new BoxTool());
			}

		});
		panel.add(boxButton);

		JButton ovalButton = new JButton("Oval");
		ovalButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				canvas.setTool(new OvalTool());
			}

		});
		panel.add(ovalButton);

		JButton bucketButton = new JButton("Bucket");
		bucketButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				canvas.setTool(new BucketTool());
			}

		});
		panel.add(bucketButton);

		final JColorChooser colorChooser = new JColorChooser(Color.BLACK);
		colorChooser.setPreviewPanel(new JPanel());
		AbstractColorChooserPanel[] panels = colorChooser.getChooserPanels();
		for (AbstractColorChooserPanel colorPanel : panels) {
			if (!colorPanel.getDisplayName().equals("RGB")) {
				colorChooser.removeChooserPanel(colorPanel);
			}
		}
		colorChooser.getSelectionModel().addChangeListener(
				new ChangeListener() {

					public void stateChanged(ChangeEvent arg0) {
						Color newColor = colorChooser.getColor();
						canvas.setColor(newColor);
					}

				});
		panel.add(colorChooser);

		container.add(panel, BorderLayout.NORTH);

		setVisible(true);
	}

	public static void main(String[] args) {
		new PaintFrame();
	}
}
