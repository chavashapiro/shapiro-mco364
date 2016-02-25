package shapiro.mco364.paint;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintFrame extends JFrame{
	
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
				canvas.setPencilTool();
			}
			
		});
		panel.add(pencilButton);
		
		JButton lineButton = new JButton("Line");
		lineButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				canvas.setLineTool();
			}
			
		});
		panel.add(lineButton);
		
		JButton boxButton = new JButton("Box");
		boxButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				canvas.setBoxTool();
			}
			
		});
		panel.add(boxButton);
		
		JButton ovalButton = new JButton("Oval");
		ovalButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				canvas.setOvalTool();
			}
			
		});
		panel.add(ovalButton);
		
		JButton bucketButton = new JButton("Bucket");
		bucketButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				canvas.setBucketTool();
			}
			
		});
		panel.add(bucketButton);
		
		container.add(panel, BorderLayout.NORTH);
				
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new PaintFrame();
	}
}
