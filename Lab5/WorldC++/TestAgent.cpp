#include <iostream>
#include "Agent.hpp"
#include "Vec2D.hpp"

int main() {
    // Creating 2 agents and setting targets
    Vec2D posAlex = Vec2D(0, 0);
    Vec2D tarAlex = Vec2D(3, 3);
    Agent alex(&posAlex, "Alex", 10, 1);
    alex.setTarget(&tarAlex);

    Vec2D posLuca = Vec2D(5, 0);
    Vec2D tarLuca = Vec2D(0, 5);
    Agent luca(&posLuca, "Luca", 10, 1);
    luca.setTarget(&tarLuca);

    // Looping until both have reached their targets to test out methods

    while (!alex.targetReached() || !luca.targetReached()) {
        if (alex.isColliding(&luca)) { // same as luca.isColliding(&alex)
            std::cout << "\nAlex and Luca ARE colliding\n\n";
        } else {
            std::cout << "\nAlex and Luca are NOT colliding\n\n";
        }

        alex.print();
        luca.print();

        alex.update();
        luca.update();

        if (alex.targetReached()) { std::cout << "---------- Alex has reached its target! ----------\n"; }
        if (luca.targetReached()) { std::cout << "---------- Luca has reached its target! ----------\n"; }
        std::cout << "--------------------------------------------------\n";
    }
}