import java.awt.*;

public class Agent {
    private Vec2D pos;
    private Vec2D dir;
    private Vec2D target;
    private double radius;
    private double speed;

    public Agent(double xInit, double yInit, double radiusInit){
        pos = new Vec2D(xInit, yInit);
        radius = radiusInit;
        //ask
    }

    public Agent(Vec2D posInit, double radiusInit){
        pos = new Vec2D(posInit);
        radius = radiusInit;
        //ask
    }

    public void setTarget(double xInit, double yInit){
        target = new Vec2D(xInit, yInit);
        dir = new Vec2D(target);
        dir.subtract(pos);
        dir.normalize();
    }

    public void setTarget(Vec2D t){
        target = t;
        dir = new Vec2D(target);
        dir.subtract(pos);
        dir.normalize();
    }

    public void setDirection(double xInit, double yInit){
        dir = new Vec2D(xInit, yInit);
        dir.subtract(pos);
        dir.normalize();
    }

    public void setDirection(Vec2D d){
        dir = new Vec2D(d);
        dir.subtract(pos);
        dir.normalize();
    }

    public void setSpeed(double speed){
        this.speed = speed;
    }

    public Vec2D getTarget(){
        return target;
    }

    public Vec2D getDirection(){
        return dir;
    }

    public Vec2D getPosition(){
        return pos;
    }

    public double getRadius(){
        return radius;
    }

    public void updatePosition(){
        pos.add(dir.scalarProdVec2D(speed)); //ask
    }

    public boolean targetReached(){
        Vec2D difference = new Vec2D(target);
        difference.subtract(pos);
        if(difference.length() <= radius){
            return true;
        } 
        return false;
    }

    public boolean isColliding(Agent A){
        Vec2D difference = new Vec2D(A.pos);
        difference.subtract(pos);
        if(difference.length() <= A.radius+this.radius){
            return true;
        }
        return false;
    }

    public Vec2D oppositeDirection(Agent A){
        Vec2D difference = new Vec2D(A.pos);
        difference.subtract(pos);
        return difference;
    }

    public void paintAgent(Graphics g) {
		int x = (int) (pos.getX() - radius);
        int y = (int) (pos.getY() - radius);
        int d = (int) (2 * radius);

        g.setColor(Color.RED);
        g.fillOval(x, y, d, d);
	}
}