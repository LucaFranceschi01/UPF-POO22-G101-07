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
        Vec2D dir(0, 0);
        Vec2D target(0, 0);
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
        dir->setX(p->getX());
        dir->setY(p->getY());
        dir->subtract(pos);
        dir->normalize();
    }

    void setTarget(Vec2D * p) { 
        target = p;
        setDirection(p);
    }
    
    void setRadius(double r) { radius = r; }
    void setSpeed(double s) { speed = s; }

    //update position of the agent
    void update() {
        Vec2D temp = dir->scalarProdVec2D(speed);
        pos->add(&temp);
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
        printDirection();
        printTarget();
    }

    void printPosition() {  printf("Position -->  X: %.3lf\tY: %.3lf\n", pos->getX(), pos->getY()); }
    void printDirection() { printf("Direction --> X: %.3lf\tY: %.3lf\n", dir->getX(), dir->getY()); }
    void printTarget() {    printf("Target -->    X: %.3lf\tY: %.3lf\n", target->getX(), target->getY()); }
};

#endif