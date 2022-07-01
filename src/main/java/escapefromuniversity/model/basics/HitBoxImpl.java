package escapefromuniversity.model.basics;

import escapefromuniversity.model.map.Rectangle;

/**
 * A class which extends Rectangle and implements HitBox.
 */
public class HitBoxImpl extends Rectangle implements HitBox {

	private final Point2D topLeft;
	private final Point2D bottomRight;

	/**
	 * A constructor for HitBoxImpl.
	 * @param topLeft the top-left corner
	 * @param bottomRight the bottom-right corner
	 */
	public HitBoxImpl(final Point2D topLeft, final Point2D bottomRight) {
		super(topLeft, bottomRight);
		this.bottomRight = new Point2D(bottomRight);
		this.topLeft = new Point2D(topLeft);
	}
	

	@Override
	public Point2D getTopLeftCorner() {
		return new Point2D(bottomRight);
	}

	@Override
	public Point2D getBottomRightCorner() {
		return new Point2D(topLeft);
	}

	@Override
	public boolean isColliding(final HitBox box) {
		if (this.bottomRight.getY() < box.getBottomRightCorner().getY()
				|| this.topLeft.getY() > box.getTopLeftCorner().getY()) {
			return false;
		}
		return !(this.getTopLeftCorner().getX() < box.getBottomRightCorner().getX())
				&& !(this.topLeft.getX() > box.getTopLeftCorner().getX());
	}
}
