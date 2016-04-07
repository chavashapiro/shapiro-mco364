package shapiro.mco364.paint;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.JFrame;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class PaintFrame extends JFrame {

	@Inject
	public PaintFrame(Canvas canvas, PaintToolbar toolbar) {

		setTitle("PaintFrame");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		container.add(canvas, BorderLayout.CENTER);

		container.add(toolbar, BorderLayout.NORTH);

		setVisible(true);
	}

	public static void main(String[] args) throws SecurityException, IOException {
		Logger logger = Logger.getLogger("shapiro.mco364.paint");
		logger.setLevel(Level.FINE);
		Handler handler = new FileHandler("log");
		handler.setLevel(Level.FINE);
		handler.setFormatter(new SimpleFormatter());
		logger.addHandler(handler);

		Injector injector = Guice.createInjector(new PaintModule());
		PaintFrame frame = injector.getInstance(PaintFrame.class);
	}
}
