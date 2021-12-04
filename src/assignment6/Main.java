package assignment6;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {
	
    @Override
    public void start(Stage primaryStage) {
    	
    	//draw three random cards
    	int[] cardNums = getThreeRandomCards();
    	
    	//create an arraylist to hold the images of the cards
    	ArrayList<Image> cardImages = new ArrayList<>();

    	//get the images of the cards
    	for(int card: cardNums) {
    		cardImages.add(new Image("image/card/" + card + ".png"));
    	}
    	
    	//create an arraylist to hold the card image view elements
    	ArrayList<ImageView> cardImageViews = new ArrayList<>();
    	
    	//load the images to the view elements
    	for(Image card:cardImages) {
    		cardImageViews.add(new ImageView(card));
    	}
    	
    	//create a pane
    	FlowPane pane = new FlowPane();
    	
    	//add the image view elements to the pane
    	for(ImageView i : cardImageViews) {
    		pane.getChildren().addAll(i);
    	}
    	
    	//create a scene. the images are 72x96 pixels so make the view 3*72 x 96
    	Scene scene = new Scene(pane, 216, 96);
    	
    	primaryStage.setScene(scene);
    	primaryStage.setTitle("Displaying Three Cards");
    	primaryStage.show();
    }
    
    public static int[] getThreeRandomCards() {
		//create an empty deck
		ArrayList<Integer> deck = new ArrayList<>();
		
		//load 52 cards, in order, into the deck
		for(int i = 0; i < 54; i++) {
			deck.add(i+1);
		}
		
		//shuffle the deck
		java.util.Collections.shuffle(deck);
		
		//create an array that will hold the three cards
		int[] threeCards = new int[3];
		
		//draw the first three cards from the deck
		for(int i = 0; i < 3; i++) {
			threeCards[i] = deck.get(i);
		}
		
		//return the deck
		return threeCards;
	}

    public static void main(String[] args) {
        launch(args);
    }
}