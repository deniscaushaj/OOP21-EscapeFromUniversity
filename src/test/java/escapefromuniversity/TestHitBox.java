package escapefromuniversity;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.basics.HitBoxImpl;

/**
 * JUnit test for the HitBox.
 *
 */
public class TestHitBox {
	
	@Test
	public void testCorrectBox() {
		assertDoesNotThrow(() -> new HitBoxImpl(new Point2D(1, 1), new Point2D(5, 10)));
	}
	
	@Test
	public void testMeasurement() {
		HitBoxImpl box = new HitBoxImpl(new Point2D(0.56, 0.5), new Point2D(6.74, 7.89));
		assertEquals(new Double(7.39), box.getHeight());
		assertEquals(new Double(6.18), box.getWidth());
	}
	
	@Test
	public void testCollisions() {
		HitBoxImpl box1 = new HitBoxImpl(new Point2D(1, 2), new Point2D(5, 5));
		HitBoxImpl box2 = new HitBoxImpl(new Point2D(3, 2), new Point2D(4, 7));
		assertTrue(box1.isColliding(box2));
	}
	

}
