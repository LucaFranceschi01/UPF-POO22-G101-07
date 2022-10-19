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

    private Vec2D randomVec2D(){
        double x = margin + Math.random()*(width-2*margin);
        double y = margin + Math.random()*(height-2*margin);
        return new Vec2D (x, y);
    }

    private Vec2D randomPosInLine(Vec2D pos, Vec2D dir){ // from a vector return Vec2D in line of v
        double[] kn = new double[4];
        kn[0] = (30-pos.getY())/dir.getY();
        kn[1] = (30-pos.getX())/dir.getX();
        kn[2] = (570-pos.getY())/dir.getY();
        kn[3] = (770-pos.getX())/dir.getX();
        int kMin = min(kn);
        double kRand = randomWithMax(kn[kMin]);
        
        //System.out.printf("%f, %f = %f%n", pos.getX(), kRand*dir.getX(), pos.getX()+kRand*dir.getX());
        //System.out.printf("%f, %f = %f%n", pos.getY(), kRand*dir.getY(), pos.getY()+kRand*dir.getY());


        return new Vec2D(pos.getX()+kRand*dir.getX(), pos.getY()+kRand*dir.getY());
    }

    private int min(double[] kn){
        int min = 0;
        for(int i=0; i<kn.length; i++){
            if(abs(kn[i]) < abs(kn[min])) { min = i; }
        }
        return min;
    }

    private double abs(double d) {
        if(d > 0) { return d; }
        return -d;
    }

    private double randomWithMax(double max){
        return max*Math.random();
    }

    private double randomRadius(){
        return 5 + Math.random()*(margin - 5);
    }

    public void simulationStep(){
        for(int i=0; i<numAgents; i++){
            if(agents[i].targetReached()){
                agents[i].setTarget(randomVec2D());
            } else{
                agents[i].updatePosition(); // ask
                manageCollisions();
            }
        }
    }

    public void paintWorld(Graphics g) {
        for(int i=0; i<numAgents; i++){
            agents[i].paintAgent(g);
        }
	}

    public void manageCollisions(){// sin exito
        for (int i=0; i<numAgents; ++i){
            for (int j = i+1; j<numAgents; ++j){
                if(agents[i].isColliding(agents[j])){
                    //vector entre centros 
                    Vec2D diffVec = new Vec2D(agents[i].getPosition());
                    diffVec.subtract(agents[j].getPosition()); // de Bj a Ai
                    diffVec.normalize();
                    //set nuevo target en el vector
                    //System.out.printf("%f, %f%n", diffVec.getX(), diffVec.getY());

                    agents[i].setTarget(randomPosInLine(agents[i].getPosition(), diffVec));
                    //System.out.printf("%f, %f%n", diffVec.scalarProdVec2D(-1).getX(), diffVec.scalarProdVec2D(-1).getY());

                    agents[j].setTarget(randomPosInLine(agents[j].getPosition(), diffVec.scalarProdVec2D(-1)));                
                }
            }
        }
    }
}
