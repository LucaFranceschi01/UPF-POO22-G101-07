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
		x = x / len;
		y = y / len;
	}

	//do the product of a vector by a scalar value
	Vec2D scalarProdVec2D(double scalar) {
		x = getX() * scalar;
		y = getY() * scalar;
		return Vec2D(x, y);
	}

	//print the vector with 3 decimal places
	void print() { printf("X: %.3f	Y: %.3f\n", getX(), getY()); }

};

#endif