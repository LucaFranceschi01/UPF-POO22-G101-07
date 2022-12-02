#ifndef _VEC2D_
#define _VEC2D_

#include <cmath>
class Vec2D {
	
private:
	double x;
	double y;

public:
	// constructors
	Vec2D(double xInit, double yInit) : x(xInit), y(yInit) {}
	
	Vec2D(Vec2D * v) : x(v->getX()), y(v->getY()) {}

	// getters
	double getX() { return x; }
	double getY() { return y; }

	// setters
	void setX(double d) { x = d; }
	void setY(double d) { y = d;}

	// add or subtract another vector
	void add     (Vec2D * v) { x += v->getX(); y += v->getY(); }
	void subtract(Vec2D * v) { x -= v->getX(); y -= v->getY(); }

	// compute the Euclidean length
	double length() {
		return sqrt(x * x + y * y);
	}
	
	// normalize to unit length
	void normalize() {
		double len = length();
		if (len != 0) {
			x = x / len;
			y = y / len;
		} else { x = 0; y = 0; }
	}

	Vec2D scalarProdVec2D(double scalar) {
		return Vec2D(x*scalar, y*scalar);
	}

	void print() {
		printf("X: %.3lf Y: %.3lf\n", x, y);
	}
};

#endif