package bouncingballs;

import javafx.scene.shape.*;
import javafx.scene.paint.*;
import java.util.Random;
import java.util.ArrayList;

public class Ball extends Circle {
    //the array of radial gradients
    RadialGradient[] radArr = new RadialGradient[5];
	
	//the references
	Integer radius, theStageHeight, theStageWidth;
	ArrayList<Ball> others;
	
	Integer speedX, speedY;
	
    public Ball(Integer radius, Integer theStageHeight, Integer theStageWidth, ArrayList<Ball> theOtherBalls) {
        super();
    
    //filling the radial gradient array
    radArr[0] = new RadialGradient(0, 0, 0.35, 0.35, 0.5, true, CycleMethod.NO_CYCLE, new Stop(0, Color.WHITE), new Stop(1, Color.GOLD));
    radArr[1] = new RadialGradient(0, 0, 0.35, 0.35, 0.5, true, CycleMethod.NO_CYCLE, new Stop(0, Color.WHITE), new Stop(1, Color.BLUE));
    radArr[2] = new RadialGradient(0, 0, 0.35, 0.35, 0.5, true, CycleMethod.NO_CYCLE, new Stop(0, Color.WHITE), new Stop(1, Color.RED));
    radArr[3] = new RadialGradient(0, 0, 0.35, 0.35, 0.5, true, CycleMethod.NO_CYCLE, new Stop(0, Color.WHITE), new Stop(1, Color.BLACK));
    radArr[4] = new RadialGradient(0, 0, 0.35, 0.35, 0.5, true, CycleMethod.NO_CYCLE, new Stop(0, Color.WHITE), new Stop(1, Color.GREEN));
    
    
    this.radius = radius;
    this.theStageHeight = theStageHeight;
    this.theStageWidth = theStageWidth;
    this.others = theOtherBalls;
    this.speedX = (new Random()).nextInt(5) * 5;
    this.speedY = (new Random()).nextInt(5) * 5;
    
	super.setRadius(radius);
	super.setCenterX((new Random()).nextInt(theStageWidth - radius));
	super.setCenterY((new Random()).nextInt(theStageHeight - radius));
	super.setFill(radArr[(new Random()).nextInt(radArr.length)]);
		
    }
    
    
    public void move() {
    super.setCenterX(super.getCenterX() + speedX);
    super.setCenterY(super.getCenterY() + speedY);
    
    //checking for collisions with the edges of the screen
    //top
    if(super.getCenterY() < radius/*not zero*/) {
		speedY = -speedY;
    }
    //bottom
    if(super.getCenterY() > (theStageHeight - radius)) {
		speedY = -speedY;
    }
    //left
    if(super.getCenterX() < radius) {
    speedX = -speedX;
    }
    //right
    if(super.getCenterX() > (theStageWidth - radius)) {
		speedX = -speedX;
    }
    
    
    //checking for collisions with other balls
    for(int i = 0; i < others.size(); i++) {
    if(others.get(i) != this && others.get(i).intersects(super.getLayoutBounds())) {
		//they collided
			Integer otherSpeedX = others.get(i).speedX, otherSpeedY = others.get(i).speedY;
			others.get(i).speedX = this.speedX;
			others.get(i).speedY = this.speedY;
			this.speedX = otherSpeedX;
			this.speedY = otherSpeedY;
			break;
    }
    }
    
    }
    }
