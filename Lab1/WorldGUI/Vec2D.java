public class Vec2D {
	private double x;
	private double y;

	// Constructors
	public Vec2D(double xInit, double yInit) { x = xInit; y = yInit; }
	
	public Vec2D(Vec2D v) { x = v.getX(); y = v.getY(); }

	// Getters
	public double getX() { return x; }
	public double getY() { return y; }

	// Add or subtract another vector
	public void add(Vec2D v) { x += v.getX(); y += v.getY(); }
	public void subtract(Vec2D v) { x -= v.getX(); y -= v.getY(); }

	// Compute the Euclidean length
	public double length() {
		return Math.sqrt(x * x + y * y);
	}
	
	// Normalize to unit length
	public void normalize() {
		double len = length();
		x = x / len;
		y = y / len;
	}

	// Scalar product
	public Vec2D scalarProdVec2D(double scalar) { return new Vec2D(scalar*x, scalar*y); }
}