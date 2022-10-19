import java.awt.*;

public class World {
    private int width;
    private int height;
    private Agent[] agents;
    private int margin;
    private int numAgents;

    public World(int wInit, int hInit, int cap){
        width = wInit;
        height = hInit;
        numAgents = cap;
        agents = new Agent[numAgents];
        margin = 30;
        

        for(int i=0; i<numAgents; i++){
            agents[i] = new Agent(randomVec2D(), randomRadius());
            agents[i].setTarget(randomVec2D());
            agents[i].setSpeed(1);
        }
    }

    public World(int wInit, int hInit, int cap, int marginInit){
        width = wInit;
        height = hInit;
        numAgents = cap;
        agents = new Agent[numAgents];
        margin = marginInit;

        for(int i=0; i<numAgents; i++){
            agents[i] = new Agent(randomVec2D(), randomRadius());
            agents[i].setTarget(randomVec2D());
            agents[i].setSpeed(1);
        }
    }

    public void simulationStep(){
        for(int i=0; i<numAgents; i++){
            if(agents[i].targetReached()){
                agents[i].setTarget(randomVec2D());
            } else{
                agents[i].updatePosition();
            }
        }
        manageCollisions(); // In each simulation step we need to manage the collisions
    }

    public void paintWorld(Graphics g) {
        for(int i=0; i<numAgents; i++){
            agents[i].paintAgent(g);
        }
	}

    // Manage the collisions between agents
    public void manageCollisions(){
        for (int i=0; i<numAgents; ++i){
            for (int j = i+1; j<numAgents; ++j){
                if(agents[i].isColliding(agents[j])){
                    // Get vector between centers of colliding agents
                    Vec2D diffVec = new Vec2D(agents[i].getPosition());
                    diffVec.subtract(agents[j].getPosition()); // This vector goes "from j to i"
                    diffVec.normalize();
                    // Set new target in the new direction (diffVec) "randomly" so that it does not fall off the window 
                    agents[i].setTarget(randomPosInLine(agents[i].getPosition(), diffVec)); // No need to flip the vector since the direction is OK
                    agents[j].setTarget(randomPosInLine(agents[j].getPosition(), diffVec.scalarProdVec2D(-1))); // We need to flip the vector "from i to j"
                }
            }
        }
    }

    private Vec2D randomVec2D(){
        double x = margin + Math.random()*(width-2*margin);
        double y = margin + Math.random()*(height-2*margin);
        return new Vec2D (x, y);
    }

    // From a position and direction of a vector, returns a position in the straight line of the point-slope equation inside the margins
    private Vec2D randomPosInLine(Vec2D pos, Vec2D dir){
        // We store all the four possible equations in an array
        double[] k = new double[4];
        k[0] = (margin-pos.getY())/dir.getY();
        k[1] = (margin-pos.getX())/dir.getX();
        k[2] = (height-margin-pos.getY())/dir.getY();
        k[3] = (width-margin-pos.getX())/dir.getX();
        // Take the index of the minimum positive value for k (the correct one depending on each case)
        int kMinIndex = min(k);

        // Shrink it so that not always bounces until the margin (commented because it looks "less chaotic" when it bounces to the margin)
        // double kRand = randomWithMax(k[kMinIndex]);
        // return new Vec2D(pos.getX()+kRand*dir.getX(), pos.getY()+kRand*dir.getY());
        
        // Return the position vector of the new target using the point-slope equation
        return new Vec2D(pos.getX()+k[kMinIndex]*dir.getX(), pos.getY()+k[kMinIndex]*dir.getY());
    }

    // Takes the minimum positive double value from an array and returns the index
    private int min(double[] kn){
        int min = 0;
        for(int i=0; i<kn.length; i++){
            if((kn[i] > 0 && kn[min] < 0) || (kn[i] > 0 && kn[i] < kn[min])) { min = i; }
        }
        return min;
    }

    private double randomRadius(){
        return 5 + Math.random()*(margin - 5);
    }
    
    /*private double randomWithMax(double max){
        return max*Math.random();
    }*/    
}