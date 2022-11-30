#ifndef _AGENT_
#define _AGENT_

#include "Vec2D.hpp"
#include "Entity.hpp"

class Agent: public Entity{
    
private:

    Vec2D * dir;
    Vec2D * target;
    double radius;
    double speed;

public:
    //constructor
    Agent(Vec2D * p, string n, int e, double r) : Entity(p, n, e) {
        radius = r;
        speed = 1;
        dir = nullptr;
        target = nullptr;
    }

    //getters
    Vec2D *getPosition() { return pos; }
    Vec2D *getDirection() { return dir; }
    Vec2D *getTarget() { return target; }
    double getRadius() { return radius; }
    double getSpeed() { return speed; }

    //setters
    void setPosition(Vec2D * p) { pos = p; }

    void setDirection(Vec2D * p) {
        dir = p;
        dir->subtract(pos);
        dir->normalize();
    }

    void setTarget(Vec2D * p) { 
        Vec2D temp = Vec2D(*p);
        target = &temp;

        Vec2D temp2 = Vec2D(*p);
        temp2.subtract(pos);
        temp2.normalize();
        dir = &temp2;
    }
    
    void setRadius(double r) { radius = r; }
    void setSpeed(double s) { speed = s; }

    //update position of the agent
    void update() {
        std::cout << "----------" << '\n';
        pos->print();
        dir->print();
        Vec2D newdir = dir->scalarProdVec2D(speed);
        std::cout << "----------" << '\n';
        pos->print();
        dir->print();

        newdir.print();
        std::cout << "-------------------" << '\n';
        pos->add(&newdir);
    }

    //check if the agent has reached the target
    bool targetReached() {
        Vec2D * difference = target;
        difference->subtract(pos);
        if(difference->length() <= radius){
            return true;
        } 
        return false;
    }

    //checks if the agents is colliding with another agent      --> need to check if it works
    /*bool isColliding(Agent * a) {
        Vec2D * difference = &a->getPosition();
        difference->subtract(pos);
        if(difference->length() <= a->getRadius()+getRadius()){
            return true;
        }
        return false;
    }*/

    //printers
    void print() {
        std::cout << getName() << ' ' << getEnergy() << '\n';
        printPosition();
        if (getDirection() != nullptr) {
            printDirection();
        }
        if (getTarget() != nullptr) {
            printTarget();
        }
    }


    void printPosition() { std::cout << "Position --> "; Vec2D *v = getPosition(); v->print(); }
    void printDirection() { std::cout << "Direction --> "; Vec2D *v = getDirection(); v->print(); }
    void printTarget() { std::cout << "Target --> "; Vec2D *v = getTarget(); v->print(); }
};

#endif