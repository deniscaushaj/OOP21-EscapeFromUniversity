package escapefromuniversity.model.basics;

public class HitBoxImpl implements HitBox{

	private final Point2D upperRightCorner;
	private final Point2D bottomLeftCorner;
	
	public HitBoxImpl(final Point2D bottomLeftCorner, final Point2D upperRightCorner){
		cornerTest(bottomLeftCorner, upperRightCorner);
		this.upperRightCorner = new Point2D(upperRightCorner);
		this.bottomLeftCorner = new Point2D(bottomLeftCorner);
	}
	
	public HitBoxImpl(final HitBox box){
		cornerTest(box.getBottomLeftCorner(), box.getUpperRightCorner());
		this.upperRightCorner = new Point2D(box.getUpperRightCorner());
		this.bottomLeftCorner = new Point2D(box.getBottomLeftCorner());
	}
	
	private void cornerTest(final Point2D bottomLeftCorner, final Point2D upperRightCorner) throws IllegalArgumentException{		
		switch(Double.compare(upperRightCorner.getX(), bottomLeftCorner.getX())) {
		  case 0:
			throw new IllegalArgumentException("The HitBox is inconsistent, its width is 0!");
		  case -1:
			throw new IllegalArgumentException("The HitBox is illegal, its right corner is on the left!");
		}
		
		switch(Double.compare(upperRightCorner.getY(), bottomLeftCorner.getY())) {
		  case 0:
			throw new IllegalArgumentException("The HitBox is inconsistent, its height is 0!");
		  case -1:
			throw new IllegalArgumentException("The HitBox is illegal, its upper corner is on the bottom!");
		}
	}
	
	@Override
	public Point2D getUpperRightCorner() {
		return new Point2D(upperRightCorner);
	}

	@Override
	public Point2D getBottomLeftCorner() {
		return new Point2D(bottomLeftCorner);
	}

	@Override
	public double getHeight() {
		return this.upperRightCorner.getY() - this.bottomLeftCorner.getY();
	}

	@Override
	public double getWidth() {
		return this.upperRightCorner.getX() - this.bottomLeftCorner.getX();
	}

	@Override
	public boolean isColliding(HitBox box) {
		return (box.getUpperRightCorner().getX() >= (this.getUpperRightCorner().getX()-this.getWidth())
				&& box.getUpperRightCorner().getX() <=  this.getUpperRightCorner().getX()) || 
				(box.getUpperRightCorner().getY() >= (this.getUpperRightCorner().getY()-this.getHeight())
				&& box.getUpperRightCorner().getY() <=  this.getUpperRightCorner().getY()) ||
				(box.getBottomLeftCorner().getX() >= this.getBottomLeftCorner().getX() 
				&& box.getBottomLeftCorner().getX() <= (this.getBottomLeftCorner().getX()+this.getWidth())) ||
				(box.getBottomLeftCorner().getY() >= this.getBottomLeftCorner().getY() 
				&& box.getBottomLeftCorner().getY() <= this.getBottomLeftCorner().getY()+this.getHeight());
				
	}
	
	

}
