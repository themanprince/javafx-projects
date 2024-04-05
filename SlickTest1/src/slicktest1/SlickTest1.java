package slicktest1;

import org.newdawn.slick.*;

public class SlickTest1 extends BasicGame{
public SlickTest1() {
    
    super("Slick Example");
    
}

public void render(GameContainer gmc, Graphics gr) throws SlickException{
    
}

public void init(GameContainer gc) throws SlickException {
    
}

public void update(GameContainer gc, int delta) throws SlickException {
    
}


public static void main(String[] args) {
    System.setProperty("org.lwjgl.librarypath", "C:\\Users\\PST JUDE\\Documents\\NetBeansProjects\\libgdx-1.6.1\\GameProjects\\SlickTest1\\natives");
    AppGameContainer screen = null;
    
    try{
        screen = new AppGameContainer(new SlickTest1());
    }catch(SlickException e1) {
        e1.printStackTrace();
    }
    
    
    try{
        screen.setDisplayMode(600, 400, false);
    }catch(SlickException e) {
        e.printStackTrace();
    }
    
    try{
        screen.start();
    }catch(SlickException e) {
        e.printStackTrace();
    }
        
}
}