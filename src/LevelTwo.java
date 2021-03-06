import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LevelTwo {
	private int counter = 0;
	private Scene theScene2;
	private Group root2;
	private Stage primaryStage2;
	
	public LevelTwo(Stage stage, Group root, Scene scene) {
		theScene2 = scene;
		this.root2 = root;
		primaryStage2 = stage;
	}
	
	//initiates avatar, moving enemies, platforms, end wall, game over screen and Level label
	private ObstacleList obstacleList2 = new ObstacleList(2);
	private RunnerList runnerList2 = new RunnerList(2);
	private Avatar avatar2 = new Avatar(300,765,35,35);
	private MeteorList meteorList = new MeteorList(2);
	private EndList endList = new EndList(2);
	private LevelText text = new LevelText(2);
	private GameOver gmOver = new GameOver();
	
	
	public void start(Stage primaryStage) {

		
		//handles arrow key input
		AvatarMovement avatarHandler2 = new AvatarMovement(avatar2, obstacleList2, runnerList2, meteorList, endList);
			theScene2.setOnKeyPressed(avatarHandler2);
			//sets avatar as spaceship image
			avatar2.setFill(
				      new ImagePattern(
				    	        new Image("space35.png"), 0, 0, 1, 1, true
				    	      )
				    	    );
			//sets platforms as platform images
			for(Obstacle o: obstacleList2) {
				o.setFill(
					      new ImagePattern(
					    	        new Image("bump.jpg"), 0, 0, 1, 1, true
					    	      )
					    	    );
			}
			//sets end wall as end wall image
			for(End e: endList) {
				e.setFill(
					      new ImagePattern(
					    	        new Image("bump.jpg"), 0, 0, 1, 1, true
					    	      )
					    	    );
			}
			//sets enemeis as alien images
			for(Runner r: runnerList2) {
				r.setFill	(			
					      new ImagePattern(
					    	        new Image("alien.png"), 0, 0, 1, 1, true
					    	      )
					    	    );
			}
			//adds avatar, enemies, platforms, end wall and level text to scene
			root2.getChildren().add(avatar2);
			root2.getChildren().addAll(runnerList2);
			root2.getChildren().addAll(obstacleList2);
			root2.getChildren().addAll(endList);
			root2.getChildren().add(text);
			
			
			Timeline timeline2 = new Timeline(
	     			new KeyFrame(Duration.millis(10),
	     	               new EventHandler <ActionEvent>()
	     				   {
	     				   	@Override
	     				   	public void handle(ActionEvent event)
	     				   	{
	     				   		//if avatar reaches end wall go to level 2
	     				   			if(avatar2.intersects(endList.get(0))) {
	     				   				counter = counter+1;
	     				   				//remove all level 2 items
	     				   				root2.getChildren().remove(avatar2);
	     				   				root2.getChildren().removeAll(runnerList2);
	     				   				root2.getChildren().removeAll(obstacleList2);
	     				   				root2.getChildren().removeAll(endList);
	     				   				root2.getChildren().remove(text);
	     				   				//initiate level 3
	     				   				LevelThree three = new LevelThree(primaryStage2, root2, theScene2);
 								if(counter == 1) {
 									//start level 3
 								three.start(primaryStage2);
 								}
  								}
	     				   			//checks for collisions with platforms
	     				   	for(Obstacle p: obstacleList2) {
	     				   		avatar2.unCollisionCheck(p);
	     				   		avatar2.collisionCheck(p);
  						}
	     				   	//reverses gravity
  						if(avatar2.getReverse() == false) 
  						{
  							avatar2.revGrav();
  						}
  						else if(avatar2.getReverse() == true) 
  						{
     						avatar2.grav();
  						}
  						//if avatar touches enemy, game over screen
   						for(Runner r: runnerList2) {
  							if(avatar2.intersects(r)) {
  								gmOver.start(primaryStage);
  							}
  							}
   						//moves enemies
     				   	for(Runner r: runnerList2) {
     						r.updateLocation();
     						if(r.getLeftEnd() != r.getRightEnd()) {
     							 if(r.getX()<= r.getLeftEnd()) {
     								 r.reverseX();
     							 }
     							 else if(r.getX()>= r.getRightEnd()) {
     								r.reverseX();
     							 }
     						 }
     						 if(r.getUpEnd() != r.getDownEnd()) {
     							 if(r.getY()< r.getUpEnd()) {
     								 r.reverseY();
     							 }
     							 if(r.getY()>= r.getDownEnd()) {
     								 r.reverseY();
     							 }
     						 }
      						}
	     						}
	     				   }
	     			)
	     			);
	     	timeline2.setCycleCount(Timeline.INDEFINITE);
	    	timeline2.setAutoReverse(true);
	    	timeline2.play();


primaryStage.show();
}
	


}
