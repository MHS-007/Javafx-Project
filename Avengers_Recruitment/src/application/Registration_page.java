package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Registration_page extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage s) throws Exception {
		Group root = new Group();
		GridPane gp = new GridPane(); //A layout for stage.
		
		ImageView i = new ImageView("file:///C:/Users/das/eclipse-workspace/Avengers_Recruitment/MyImages/Avengers_Image.jpg");
		//Line "41" for Background image. (Don't forget to download the image and change the location)
		
		Image icon = new Image("file:///C:/Users/das/eclipse-workspace/Avengers_Recruitment/MyImages/Avg.png");
		// Line "43" for ICON image. (Don't forget to download the image and change the location)
		i.setFitHeight(500);
		i.setFitWidth(700);
		i.setOpacity(0.9); //how light or dark an image should be.
		
		Text heading = new Text();
		heading.setText("Registration");
		heading.setFont(Font.font("Monospaced",FontWeight.EXTRA_BOLD,FontPosture.REGULAR,35));
		heading.setUnderline(true);
		heading.setFill(Color.DARKGRAY);
		heading.setTranslateX(220);
		heading.setTranslateY(50);
		

		
		Label l1 = new Label(); //using label to associate with keyboard inputs.
		l1.setText("Name :");
		l1.setFont(Font.font("Bangers",FontWeight.EXTRA_BOLD,FontPosture.REGULAR,15));
		l1.setTextFill(Color.YELLOW);
		TextField t1 = new TextField(); //A field where user put his information.
		t1.setTranslateX(70);   //set position of TextField on x-axis. (for Aligning purpose).
		
		HBox h1 = new HBox(l1,t1); // To place your components horizontally.
		
		Label l2 = new Label();
		l2.setText("Last Name :");
		l2.setFont(Font.font("Bangers",FontWeight.EXTRA_BOLD,FontPosture.REGULAR,15));
		l2.setTextFill(Color.YELLOW);
		TextField t2 = new TextField();
		t2.setTranslateX(37);
		
		HBox h2 = new HBox(l2,t2);
		
		Label l3 = new Label();
		l3.setText("Heroic Name :");
		l3.setFont(Font.font("Bangers",FontWeight.EXTRA_BOLD,FontPosture.REGULAR,15));
		l3.setTextFill(Color.YELLOW);
		TextField t3 = new TextField();
		t3.setPromptText("ex: Iron lad, SupeKid");
		t3.setTranslateX(20);
		
		HBox h3 = new HBox(l3,t3);
		
		Label pass = new Label();
		pass.setText("New Password :");
		pass.setFont(Font.font("Bangers",FontWeight.EXTRA_BOLD,FontPosture.REGULAR,15));
		pass.setTextFill(Color.YELLOW);
		PasswordField newpass = new PasswordField(); //using this field your password will show as black dots.
		newpass.setTranslateX(10);
		
		HBox nph = new HBox(pass,newpass);
		
		Label l4 = new Label();
		l4.setText("Gender :");
		l4.setFont(Font.font("Bangers",FontWeight.EXTRA_BOLD,FontPosture.REGULAR,15));
		l4.setTextFill(Color.YELLOW);
		
		ToggleGroup tg = new ToggleGroup();
		RadioButton r1 = new RadioButton();
		r1.setText("Male");
		r1.setFont(Font.font("Bangers",FontWeight.EXTRA_BOLD,FontPosture.REGULAR,15));
		r1.setTextFill(Color.YELLOW);
		
		RadioButton r2 = new RadioButton();
		r2.setText("Female");
		r2.setFont(Font.font("Bangers",FontWeight.EXTRA_BOLD,FontPosture.REGULAR,15));
		r2.setTextFill(Color.YELLOW);
		
		
		r1.setToggleGroup(tg);
		r2.setToggleGroup(tg);
		
		r1.setTranslateX(12);	//moving "r1" button forward.
		r2.setTranslateX(-20);	//moving "r2" button backward.
		
		HBox h4 = new HBox(48,l4,r1,r2); //"48" is the horizontal gap between Label "Gender"
										 // and RadioButtons i.e "r1" and "r2".
		Label l5 = new Label();
		l5.setText("Date of Birth :");
		l5.setFont(Font.font("Bangers",FontWeight.EXTRA_BOLD,FontPosture.REGULAR,15));
		l5.setTextFill(Color.YELLOW);
		DatePicker dob = new DatePicker(); //you will have a calendar to pick your Date of Birth.
		dob.setTranslateX(20);
		dob.setEditable(false); //you cannot delete/remove your DOB after selecting it.
								//Although you can change it.
		
		HBox h5 = new HBox(l5,dob);
		
		Label l6 = new Label("Powers :");
		l6.setFont(Font.font("Bangers",FontWeight.EXTRA_BOLD,FontPosture.REGULAR,15));
		l6.setTextFill(Color.YELLOW);
		ComboBox<String> cmb = new ComboBox <String> (); //To add multiple items for giving variety of options to user.
		cmb.getItems().addAll("Archery","Astral Projection","Teleportation","Telekinesis"
		,"Telepathy","Shape-shifting","Sonic Scream","Invisiblity","Witchcraft",
		"Superhuman speed","Healing factor","Superhuman Strength"); //This line will place your /items/options one by one.
		
		//( Don't forget to use double quotes while adding your options and add commas (,) ).
		//example cmb.getItems().addAll("Apple","Banana","Orange");
		
		cmb.setPromptText("Select"); // A pre-written text this will give user an idea to "select" an option among many.
		cmb.setTranslateX(50);
		HBox hcmb = new HBox(10,l6,cmb);
		
		VBox v = new VBox(10,gp); //set all components vertically.
		
		v.setTranslateX(200);
		v.setTranslateY(90);
		
		gp.add(h1, 0, 0); // components of h1 will set position on 0th column and 0th row.
		gp.add(h2, 0, 1); // components of h2 will set position on 0th column and 1st row
		gp.add(h3, 0, 2); // and so on..
		gp.add(nph, 0, 3);
		gp.add(h4, 0, 4);
		gp.add(h5, 0, 5);
		gp.add(hcmb, 0, 6);
		gp.setVgap(30); // set he vertical gap between all components.
		
		Button register = new Button();
		register.setText("Register");
		register.setFont(Font.font("Bangers", FontWeight.EXTRA_BOLD, 15));
		register.setLayoutX(540);
		register.setLayoutY(420);
		
		
		register.setOnAction(e -> {
			String details = "";  //for storing user details. All info in TextField act as String.
			String name = t1.getText(); //take the info from t1's textfield and save it in a string variable.
			String Lname = t2.getText(); // and so on
			String Hname = t3.getText();
			String password = newpass.getText();
			String rb;
			
			String DOB = dob.getValue() + ""; //for saving date of birth.
			String cb = cmb.getSelectionModel().getSelectedItem() + ""; //for saving any particular option selected by user.
			
			
			//concatenating the details.
			details += name + ","; 
			details += Lname + ",";
			details += Hname + ",";
			details += password + ",";
			
			if(r1.isSelected()) //this is for saving the info of "Gender". if "Male" is selected.
			{
				rb = "Male";    // then save "Male" to a variable which we declare above.
				details += "Male" + ","; //concatenating "Male" with previous details.
			}
			else if(r2.isSelected()) //same for "Female" button. if "Female" is selected.
			{
				rb = "Female";
				details += "Female" + ",";
			}
			else
			{								
				rb = "";				 //otherwise save empty string.
				details += "none" + ","; //"none" represents that user did not select any option.
			}
			
			details += DOB + ","; //concatenating the details of date of birth and the particular-
			details += cb + ",";  //-option that user selected.
			
			if(name.length()==0 || Lname.length()==0 || Hname.length()==0 || password.length()==0 
				|| rb.length()==0 || DOB.length()==0 || cb.length()== 0) //checks if any field is empty or not.
			{
				
				Alert a = new Alert(Alert.AlertType.ERROR); //If an empty field is found throw an error message.
				a.setContentText("All fields are required to be filled"); //this is the message "All fields are required to be filled".
				a.setHeaderText(null);
				a.show();
			}
			else
				
			{
				Alert a = new Alert(Alert.AlertType.INFORMATION); //otherwise your info will be submitted.
				a.setContentText("Your Record is Submitted");
				a.setHeaderText(null);
				a.show();
				
				System.out.println(details); // Now you can see your info printed.
				
				Connection cnn = new Connection(); //for Filing purpose.
				try {
					cnn.writeintofile(details); //all details of yours will be written to a txt file.
					 Login_Page loginPage = new Login_Page(name, password); // then we jump to next page.
			            loginPage.start(s);
				} catch (IOException e1) {

					e1.printStackTrace();
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}
			
		});
		
		Button back = new Button(); //A button for if you want to go back to previous page.
		back.setText("Go Back");
		back.setFont(Font.font("Bangers", FontWeight.EXTRA_BOLD, 15));
		back.setLayoutX(40);
		back.setLayoutY(420);
		
		back.setOnAction(e -> { 	// if you click on "Go Back" button. (an action performed)
			Welcome_Page w = new Welcome_Page(); // you'll see previous page.
				try {
					w.start(s);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			
		});
		
		root.getChildren().addAll(i,v,back,register,heading);
		
		Scene newscene = new Scene(root,700,500);
		s.setTitle("Registration");
		s.setScene(newscene);
		s.getIcons().add(icon);
		s.setResizable(false);
		s.show();
		
	}

}
