package shapiro.mco364.paint;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@Singleton
public class PaintToolbar extends Container {

	@Inject
	public PaintToolbar(final Canvas canvas, PaintProperties properties) {

		setLayout(new FlowLayout());
		Dimension dim = new Dimension(800, 180);
		setPreferredSize(dim);

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
			add(button);
		}

		JButton undoButton = new JButton(new ImageIcon(getClass().getResource("/undo.png")));
		undoButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				canvas.undo();
			}

		});
		add(undoButton);

		JButton redoButton = new JButton(new ImageIcon(getClass().getResource("/redo.png")));
		redoButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				canvas.redo();
			}

		});
		add(redoButton);

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
		add(colorChooser);
	}

}
