/* -> INSTRUCTIONS <-
 * 1- READ the comments properly.
 * 2- Do not try to open "Login_Page" class directly.
 * 3- when you run the program try to "signup" first if you directly click into "login" button and 
 *    you put your "username" and "password" it will not identify you thats why you need to "signup" 
 *    first.
 * 4- Feel free to give feedback.
 */
package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Welcome_Page extends Application {

	public static void main(String[] args) {
		launch(args); //This line is for launching your javafx Application.
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		Group root = new Group(); //JavaFX Group is a container, it is a component not applying the
		//Layout for its subcomponents. All subcomponents are in position of 0,0. The Group is used to 
		//group some controls to do a certain task.
		
		ImageView i = new ImageView("file:///C:/Users/das/eclipse-workspace/Avengers_Recruitment/MyImages/MS_AVG.jpeg"); 
		//Line "32" for Background image. (Don't forget to download the image and change the location)
		
		Image icon = new Image("file:///C:/Users/das/eclipse-workspace/Avengers_Recruitment/MyImages/Avg.png"); 
		// Line "33" for ICON image. (Don't forget to download the image and change the location)
		
		i.setFitHeight(250); // changing the height of background image.
		i.setFitWidth(400); // changing the width of background image.
		
		
		Text t = new Text(); //for writing any texts.
		t.setText("  Do you want to be an Avenger?"); //setText method will actually set your text.
		t.setFont(Font.font("Bangers",FontWeight.EXTRA_BOLD,FontPosture.REGULAR,13)); //setting font name, font weight, posture and size
		t.setFill(Color.GREY); //To change the color of text.
		t.setLayoutX(130); // set Position of text on x-axis.
		t.setLayoutY(180); // set Position of text on y-axis.
		
		
		ToggleGroup tg = new ToggleGroup(); //for choosing only one option "Yes" or "No" not both.
		RadioButton r1 = new RadioButton(); //rounded button for selection of only one option.
		RadioButton r2 = new RadioButton();
		r1.setText("Yes"); //for naming the button of r1.
		r2.setText("No"); //for naming the button of r2.
		
		r1.setFont(Font.font("Bangers",FontWeight.EXTRA_BOLD,FontPosture.REGULAR,13));
		r1.setTextFill(Color.GREEN); //setTextFill is same as setFill. setFill method is used to style the text of class "Text" only. 
									//while setTextFill is used to style the text for other components like buttons, RadioButtons etc.
		r2.setTextFill(Color.RED);
		r2.setFont(Font.font("Bangers",FontWeight.EXTRA_BOLD,FontPosture.REGULAR,13));
		
		r1.setToggleGroup(tg); //This is the line where you can select either "Yes" button or "No" button.
		r2.setToggleGroup(tg); //If you select "yes" button then that button will be half filled with rounded black color.
							   // But if you select "No" Button same will be happen to that button but this time "Yes" button will be empty.
		
		r1.setLayoutX(150); // set Position of r1 at x-axis.
		r1.setLayoutY(190); // set Position of r1 at y-axis.
		r2.setLayoutX(250); // set Position of r2 at x-axis.
		r2.setLayoutY(190); // set Position of r2 at y-axis.
		
		Button signup = new Button(); // creating a normal button.
		signup.setText("Sign Up"); // for naming button.
		signup.setFont(Font.font("Bangers",FontWeight.EXTRA_BOLD,FontPosture.REGULAR,12)); //styling the button.
		
		Button Exit = new Button();
		Exit.setText("Exit");
		Exit.setFont(Font.font("Bangers",FontWeight.EXTRA_BOLD,FontPosture.REGULAR,12));
		
		Button login = new Button();
		login.setText("Log in");
		login.setFont(Font.font("Bangers",FontWeight.EXTRA_BOLD,FontPosture.REGULAR,12));
		
		signup.setVisible(false); // This button will be invisible at first until you select the RadioButton "Yes".
		login.setVisible(false); // This button will be invisible at first until you select the RadioButton "Yes".
		Exit.setVisible(false); // This button will be invisible at first until you select the RadioButton "No".
		
		Text t2 = new Text();
		t2.setText("or");
		t2.setFont(Font.font("Bangers",FontWeight.EXTRA_BOLD,FontPosture.REGULAR,12));
		t2.setFill(Color.GREY);
		t2.setVisible(false);
		
		r1.selectedProperty().addListener((observable, oldvalue, newvalue) ->{ //this line is for 
		//when you pressing the button "r1" and "r2" one after another. Basically it means when "r1" is
		//pressed do certain tasks like visible the buttons and a text, signup(b), login(b) and text "or"
		//but when you press "r2" none of this should work. so basically it will handle "oldvalue" and "newvalue"
		// "oldvalue" means you keep pressing the "r1" button and "newvalue" means you are pressing
		// the "r2" button.
												
			 if (newvalue) 
			 {
			   signup.setVisible(true);
			   t2.setVisible(true);
			   login.setVisible(true);
			   
			   signup.setLayoutX(150);		//performing some tasks
			   t2.setLayoutX(214);
			   login.setLayoutX(230);
			   
			   signup.setLayoutY(220);
			   t2.setLayoutY(235);
			   login.setLayoutY(220);
			 } 
			 else 
			 {
			    signup.setVisible(false);
			    t2.setVisible(false);
			    login.setVisible(false);
			 }
		});
		
		
		r2.selectedProperty().addListener((observable, oldvalue, newvalue) ->{ //same for "r2"
			 if (newvalue) 
			 {
				 
				 Exit.setVisible(true);
				 Exit.setLayoutX(200);		//performing some tasks.
				 Exit.setLayoutY(220);
			 } 
			 else 
			 {
			    Exit.setVisible(false);
			 }
		});
		
		
		Exit.setOnAction(e -> Platform.exit()); //closes the javaFX Application...
		
		signup.setOnAction(new EventHandler<ActionEvent>(){  // set an action on button "signup"--
															//--it means something should happen when we click this button.
			@Override
			public void handle(ActionEvent arg0) {
				Registration_page r = new Registration_page(); //so after clicking this button it--
															  //--should take you to another page											  
				try {
					r.start(stage);		// this line actually will take you to--
										//--"Registration_page".
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		
		login.setOnAction(new EventHandler<ActionEvent>(){   // same for "Login_Page".

			@Override
			public void handle(ActionEvent arg0) {
				Login_Page lp = new Login_Page(null, null); //jump to "Login_Page".
				try {
					lp.start(stage);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		
			
		root.getChildren().addAll(i,t,r1,r2,signup,login,Exit,t2); //adding children's (components).
		
		Scene s = new Scene(root,400,250);  //creating scene "s" so we can place all our components.
		stage.setTitle("Welcome Avenger");
		stage.setScene(s); //adding scene onto stage.
		stage.getIcons().add(icon); //adding icon for application.
		stage.setResizable(false); // one cannot resize the Application.
		stage.show(); //display all our components.
		
	}

}
