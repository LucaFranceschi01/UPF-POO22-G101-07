#ifndef _ENTITY_
#define _ENTITY_

#include "Vec2D.hpp"
#include <string>

using namespace std;
class Entity{
private:
    Vec2D * pos;
    string name;
    int energy;

public:
    //constructor
    Entity(Vec2D * pos, string n, int e) : pos(pos), name(n), energy(e) {}

    //getters
    Vec2D getPosition() { return pos; }
    string getName() { return name; }
    int getEnergy() { return energy; }

    //setters
    void setPosition(Vec2D * p) { pos = p; }
    void setName(string n) { name = n; }
    void setEnergy(int e) { energy = e; }


};

#endif