import java.awt.*;

public class World {
    private int width;
    private int height;
    private Agent[] agents;
    private int margin;

    public World(int wInit, int hInit){
        width = wInit;
        height = hInit;
        agents = new Agent[10];
        margin = 30;

        for(int i=0; i<10; i++){
            agents[i] = new Agent(randomVec2D(), randomRadius());
            agents[i].setTarget(randomVec2D());
            agents[i].setSpeed(1);
        }
    }

    public World(int wInit, int hInit, int marginInit){
        width = wInit;
        height = hInit;
        agents = new Agent[10];
        margin = marginInit;

        for(int i=0; i<10; i++){
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

    private double randomRadius(){
        return 5 + Math.random()*(margin - 5);
    }

    public void simulationStep(){
        for(int i=0; i<10; i++){
            if(agents[i].targetReached()){
                agents[i].setTarget(randomVec2D());
            } else{
                agents[i].updatePosition(); // ask
            }
        }
    }

    public void paintWorld(Graphics g) {
        for(int i=0; i<10; i++){
            agents[i].paintAgent(g);
        }
	}
}
