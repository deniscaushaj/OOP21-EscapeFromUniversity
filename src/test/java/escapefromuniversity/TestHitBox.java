package escapefromuniversity;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import escapefromuniversity.model.Point2D;
import escapefromuniversity.model.HitBoxImpl;

public class TestHitBox {

	@Test
	public void testFlatBox() {
	    Throwable exception1 = assertThrows(IllegalArgumentException.class, () -> new HitBoxImpl(new Point2D(1,5), new Point2D(10,5)));
	    assertEquals("The HitBox is inconsistent, its height is 0!", exception1.getMessage());
	    
	    Throwable exception2 = assertThrows(IllegalArgumentException.class, () -> new HitBoxImpl(new Point2D(2,1), new Point2D(2,8)));
		assertEquals("The HitBox is inconsistent, its width is 0!", exception2.getMessage());
	}
	
	@Test
	public void testIllegalBox() {
	   Throwable exception1 = assertThrows(IllegalArgumentException.class, () -> new HitBoxImpl(new Point2D(5,1), new Point2D(3,10)));
	   assertEquals("The HitBox is illegal, its right corner is on the left!", exception1.getMessage());
	   
	   Throwable exception2 = assertThrows(IllegalArgumentException.class, () -> new HitBoxImpl(new Point2D(1,8), new Point2D(5,2)));
	   assertEquals("The HitBox is illegal, its upper corner is on the bottom!", exception2.getMessage());
	}
	
	@Test
	public void testCorrectBox() {
		assertDoesNotThrow(() -> new HitBoxImpl(new Point2D(1,1), new Point2D(5,10)));
	}
	
	@Test
	public void testMeasurement() {
		HitBoxImpl box = new HitBoxImpl(new Point2D(0.568,0.5), new Point2D(6.74, 7.89));
		assertEquals(new Double(7.39), box.getHeight());
		assertEquals(new Double(6.172), box.getWidth());
	}
	
	@Test
	public void testCollisions() {
		HitBoxImpl box1 = new HitBoxImpl(new Point2D(2,1), new Point2D(5, 5));
		HitBoxImpl box2 = new HitBoxImpl(new Point2D(6,3), new Point2D(7, 4));
		assertTrue(box1.isColliding(box2));
		
	}
	

}
