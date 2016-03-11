package shapiro.mco364.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class PaintFrame extends JFrame {

	@Inject
	public PaintFrame(PaintProperties properties) {

		setTitle("PaintFrame");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		final Canvas canvas = new Canvas(properties);
		container.add(canvas, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		Dimension dim = new Dimension(800, 180);
		panel.setPreferredSize(dim);

		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				ToolButton button = (ToolButton) event.getSource();
				canvas.setTool(button.getTool());
			}
		};

		ToolButton[] buttons = new ToolButton[] { new ToolButton(new PencilTool(properties), "/pencil.png"),
				new ToolButton(new LineTool(properties), "/line.png"),
				new ToolButton(new BoxTool(properties), "/box.png"),
				new ToolButton(new OvalTool(properties), "/oval.png"),
				new ToolButton(new BucketTool(properties), "/bucket.png") };

		for (ToolButton button : buttons) {
			button.addActionListener(listener);
			panel.add(button);
		}

		JButton undoButton = new JButton(new ImageIcon(getClass().getResource("/undo.png")));
		undoButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				canvas.undo();
			}

		});
		panel.add(undoButton);

		JButton redoButton = new JButton(new ImageIcon(getClass().getResource("/redo.png")));
		redoButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				canvas.redo();
			}

		});
		panel.add(redoButton);

		final JColorChooser colorChooser = new JColorChooser(Color.BLACK);
		colorChooser.setPreviewPanel(new JPanel());
		AbstractColorChooserPanel[] panels = colorChooser.getChooserPanels();
		for (AbstractColorChooserPanel colorPanel : panels) {
			if (!colorPanel.getDisplayName().equals("Swatches")) {
				colorChooser.removeChooserPanel(colorPanel);
			}
		}
		colorChooser.getSelectionModel().addChangeListener(new ChangeListener() {

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
		Injector injector = Guice.createInjector(new PaintModule());
		PaintFrame frame = injector.getInstance(PaintFrame.class);
	}
}
