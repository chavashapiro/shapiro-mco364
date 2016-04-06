package shapiro.mco364.paint;

import java.awt.Color;
import java.awt.Graphics2D;

import org.junit.Test;
import org.mockito.Mockito;

public class PencilToolTest {
	
	@Test
	public void testMousePressed() {
		
		PaintProperties properties = Mockito.mock(PaintProperties.class);
		PencilTool tool = new PencilTool(properties);
		
		Mockito.when(properties.getColor()).thenReturn(Color.RED);

		Graphics2D g = Mockito.mock(Graphics2D.class);
		tool.mousePressed(g, 5, 5);

		// check to make sure that g.drawLine(5,5,5,5) was called
		Mockito.verify(g).setColor(Color.RED);
		Mockito.verify(g).drawLine(5, 5, 5, 5);
	}
	
	@Test
	public void testMouseDragged() {
		PaintProperties properties = Mockito.mock(PaintProperties.class);
		PencilTool tool = new PencilTool(properties);
		
		Mockito.when(properties.getColor()).thenReturn(Color.RED);

		Graphics2D g = Mockito.mock(Graphics2D.class);
		tool.mouseDragged(g, 5, 10);
		tool.mouseDragged(g, 6, 9);
		
		Mockito.verify(g, Mockito.atLeastOnce()).setColor(Color.RED);
		Mockito.verify(g).drawLine(5, 10, 5, 10);
		Mockito.verify(g).drawLine(6, 9, 6, 9);
		Mockito.verify(g).drawLine(5, 10, 6, 9);
	}

}
