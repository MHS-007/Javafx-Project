package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Login_Page extends Application {
	private String name;
	private String password;

	public Login_Page(String name, String password) {
		this.name = name;		//we store the data of "name" from "Registration_Page".
		this.password = password; //we store the data of "password" from "Registration_Page".
	}
	
	//so you will use the same "name" and "password" which you provided in Registration.
	//otherwise an error will be shown.

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stg) throws Exception {
		Group root = new Group();
		ImageView i = new ImageView("file:///C:/Users/das/eclipse-workspace/Avengers_Recruitment/MyImages/login.jpg");
		//Line "42" for Background image. (Don't forget to download the image and change the location).
		
		Image icon = new Image("file:///C:/Users/das/eclipse-workspace/Avengers_Recruitment/MyImages/Avg.png");
		// Line "45" for ICON image. (Don't forget to download the image and change the location).
		
		i.setFitHeight(500);
		i.setFitWidth(900);
		i.setOpacity(0.9);
		
		Label l1 = new Label();
		l1.setText("Username: ");
		l1.setFont(Font.font("Bangers",FontWeight.EXTRA_BOLD,FontPosture.REGULAR,20));
		l1.setTextFill(Color.YELLOW);
		TextField t1 = new TextField();
	
		HBox h1 = new HBox(9,l1,t1);
		h1.setLayoutX(300); //set position on x-axis.
		h1.setLayoutY(220); //set position on y-axis.
		
		
		Label l2 = new Label();
		l2.setText("Password: ");
		l2.setFont(Font.font("Bangers",FontWeight.EXTRA_BOLD,FontPosture.REGULAR,20));
		l2.setTextFill(Color.YELLOW);
		PasswordField t2 = new PasswordField();
		
		
		HBox h2 = new HBox(14,l2,t2);
		h2.setLayoutX(300);
		h2.setLayoutY(260);
		
		
		Button Login = new Button();
		Login.setText("Log in");
		Login.setFont(Font.font("Bangers", FontWeight.BOLD, 15));
		Login.setLayoutX(415);
		Login.setLayoutY(300);
		
		/*Notice we didn't use Layout "GridPane" here just because we have only two
		 * components here so that's why I change the position of "HBoxes" instead of using "GridPane" 
		 * but if you want to use "GridPane" you can use freely there is no such restrictions. I
		 * just wanted to tell you that you have both ways for changing the Layouts of X and Y */
		
		Login.setOnAction(e ->{
			String u = t1.getText();
			String p = t2.getText();
			String details = "";
			
			details += u + ",";
			details += p + ",";
			
			System.out.println(details);
			
			Connection cnn=new Connection();
			try {
				cnn.writeintoLoginfile(details);
				cnn.openfile();  //opening the login file for data verification.
				boolean ans=cnn.readData(name, password);  //verifying the data.
				if(u.length() == 0 || p.length() == 0)
				{
					Alert a = new Alert(AlertType.ERROR);
					a.setHeaderText(null);
					a.setContentText("Empty field");
					a.show();
				}
				else if(ans==true)
				{
					if(u.contains(name) && p.contains(password))
					{
						
						Alert a=new Alert(AlertType.INFORMATION);
						a.setHeaderText(null);
						a.setContentText("Welcome to Avengers Club!");
						a.show();
					}
					
					else
					{
						Alert a=new Alert(AlertType.ERROR);
						a.setHeaderText(null);
						a.setContentText("Login Failed");
						a.show();
					}
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			
		});
		
		
		Button back = new Button();
		back.setText("Go Back");
		back.setFont(Font.font("Bangers", FontWeight.BOLD, 15));
		back.setLayoutX(40);
		back.setLayoutY(400);
		
		back.setOnAction(e -> {
			Welcome_Page w = new Welcome_Page();
				try {
					w.start(stg);
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			
		});
		
		root.getChildren().addAll(i,h1,h2,Login,back);
		
		Scene sc = new Scene(root,900,450);
		stg.setTitle("Log in");
		stg.setScene(sc);
		stg.getIcons().add(icon);
		stg.setResizable(false);
		stg.show();
		
	}

}
