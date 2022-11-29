#include <iostream>
#include "Agent.hpp"
#include "Vec2D.hpp"

int main() {
    //Creating 2 agents
    Vec2D v1(0, 0);
    Agent a1(&v1, "Paco", 10, 5);

    Vec2D v2(2, 2);
    Agent a2(&v2, "Paco", 24, 8);

    //Testing our methods on them
    a1.setTarget(&v2);
    a1.printPosition();
    a1.printDirection();
    a1.printTarget();

    a2.setTarget(&v1);
    a2.printPosition();
    a2.printDirection();
    a2.printTarget();
}