#include <iostream>
#include "Agent.hpp"
#include "Vec2D.hpp"

int main() {
    //Creating 2 agents
    Vec2D posA1 = Vec2D(0, 0);
    Vec2D tarA1 = Vec2D(5, 5);
    Agent a1(&posA1, "Paco", 10, 5);
    a1.print();
    //Testing our methods on them
    a1.setTarget(&tarA1);
    a1.print();

    // a2.setTarget(&v1);
    // a2.printPosition();
    // a2.printDirection();
    // a2.printTarget();

    // a1.update();
    // a1.update();
    // a1.printPosition();
    // a1.printDirection();
    // a1.printTarget();
}