package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Connection {
	
	String filename="Registration.txt"; //to generate a txt file using ".txt" extension.
	String filename1="Login.txt";
	Scanner x; //for taking input from file whatever data is there.
	
	/* Remember the txt files (2 in this project) will create inside your javaFX Project as well 
	 * make sure to create method like "writeintofile" because that's how you write your details/info
	 * in a txt file. otherwise your details/info will not be visible and it is just a blank txt
	 * file. If txt file is not showing after running this program make sure to refresh the whole project */
	
	public void writeintofile(String details) throws IOException //how to pass your "details" into a txt file
	{
		FileWriter file=new FileWriter(filename,true); // "true" is for appending the data so if you run the application again the previous data will not override by the new one
		BufferedWriter b=new BufferedWriter(file);
		
		b.write(details);
		b.write("\n");	
		b.close();
	}
	
	public void writeintoLoginfile(String data) throws IOException //same as "writeintofile". just a couple of changes.
	{
		FileWriter file=new FileWriter(filename1,true);
		BufferedWriter b=new BufferedWriter(file);
		
		b.write(data);
		b.write("\n");	
		b.close();
	}

	public boolean readData(String n, String p) {   //reading the data from txt file
	    boolean status = false;
	    String tempn = n;
	    String tempp = p;

	    while (x.hasNextLine()) {
	        String line = x.nextLine();
	        String[] parts = line.split(","); //splitting the "name" and "password" so we can verify easily.
	        String name = parts[0]; //save name to first location.
	        String pass = parts[1]; //save password to second location.

	        if (tempn.equals(name) && tempp.equals(pass)) {   //verifying the name and password.
	            status = true;
	            break;
	        }
	    }

	    return status;
	}

	
	public void openfile() {	//opening the file so we can check the "name" and "password" is there or not.
	    try {
	        if (x != null) {
	            x.close();
	        }
	        x = new Scanner(new File(filename1));
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	}


}
