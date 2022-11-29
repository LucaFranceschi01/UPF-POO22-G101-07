#ifndef _AGENT_
#define _AGENT_

#include "Vec2D.hpp"
#include "Entity.hpp"

class Agent: public Entity{
    
private:
    Vec2D * pos;
    Vec2D * dir;
    Vec2D * target;
    double radius;
    double speed;

public:
    //constructor
    Agent(Vec2D * p, string n, int e, double r) : Entity(p, n, e), radius(r){}

    //getters
    Vec2D getPosition() { return pos; }
    Vec2D getDirection() { return dir; }
    Vec2D getTarget() { return target; }
    double getRadius() { return radius; }
    double getSpeed() { return speed; }

    //setters
    void setPosition(Vec2D * p) { pos = p; }
    void setDirection(Vec2D * p) { dir = p; }
    void setTarget(Vec2D * p) { target = p; }
    void setRadius(double r) { radius = r; }
    void setSpeed(double s) { speed = s; }

    //update position of the agent
    void update() { pos->add(&dir->scalarProdVec2D(speed)); }

    //check if the agent has reached the target
    bool targetReached() {
        Vec2D * difference = target;
        difference->subtract(pos);
        if(difference->length() <= radius){
            return true;
        } 
        return false;
    }

    //checks if the agents is colliding with another agent      --> not working yet
    /*bool isColliding(Agent a) {
        Vec2D difference = a->getPosition();
        difference->subtract(pos);
        if(difference.length() <= a->getRadius()+getRadius()){
            return true;
        }
        return false;
    }*/
};

#endif