/* File: Guitar.java
 * Author: Olivia-Mei McDowell
 * Date: 11-16-2020
 * Description: The Guitar.java file outlines the Guitar class,
 * which contains standard guitar instrument properties, 
 * getter methods for all data fields, 
 * a playGuitar() method that returns a string representation of 
 * 16 randomly selected musical notes of random duration,
 * and a toString() method that displays the name of the guitar,
 * number of strings, length, manufacturer and color in String format.
 */

// Import required Java classes
import java.awt.Color;
import java.lang.reflect.Field; // Use reflection package to get string color name
import java.util.ArrayList;
import java.util.Random;

public class Guitar {
	
	// Initialize guitar class fields
	private String guitarName;
	private int numStrings;
	private double guitarLength;
	private String guitarManufacturer;
	private Color guitarColor;
	private String noteElement;
	private ArrayList<String> playGuitarList;
			
	// Constructor
	public Guitar (String name, int strings, double length, String manufacturer, Color color) {
		guitarName = name;
		numStrings = strings;
		guitarLength = length;
		guitarManufacturer = manufacturer;
		guitarColor = color;
	}
	
	// Default constructor
	public Guitar () {
		guitarName = "Default Guitar";
		numStrings = 6;
		guitarLength = 28.2;
		guitarManufacturer = "Gibson";
		guitarColor = Color.red;
	}
	
	// Getter methods
	public String getGuitarName() {
		return this.guitarName;
	}
	
	public int getNumStrings() {
		return this.numStrings;
	}
	
	public double getGuitarLength() {
		return this.guitarLength;
	}
	
	public String getGuitarManufacturer() {
		return this.guitarManufacturer;
	}
	
	public Color getGuitarColor() {
		return this.guitarColor;
	}

	// Getter method that returns noteElement, which is a string representation  
	// of one randomly selected musical note of random duration
	public String getRandomNote() {
		
		// Create ArrayList object that holds valid note options
		// Assume one octave in key of C where valid notes include A, B, C, D, E, F and G 
		ArrayList<String> noteOptions = new ArrayList<String>();
		noteOptions.add("A");
		noteOptions.add("B");
		noteOptions.add("C");
		noteOptions.add("D");
		noteOptions.add("E");
		noteOptions.add("F");
		noteOptions.add("G");
		
		// Create random class object
		Random randomNote = new Random();
		// Use random class method to select random value from noteOptions ArrayList
		int rNote = randomNote.nextInt(noteOptions.size());
		
		// Create ArrayList object that holds valid note duration options
		// Duration values are .25, .5, 1, 2, and 4 representing:
		// 16th, 8th, (1/4), (1/2) and whole notes, respectively
		ArrayList<String> durationOptions = new ArrayList<String>();
		durationOptions.add("0.25");
		durationOptions.add("0.5");
		durationOptions.add("1");
		durationOptions.add("2");
		durationOptions.add("4");

		// Create another random class object
		Random randomDuration = new Random();
		// Use random class method to select random value from durationOptions ArrayList
		int rDuration = randomDuration.nextInt(durationOptions.size());
		
		// Create string representation of note display format 
		// Call get method on noteOptions ArrayList, pass rNote as position peram, triggering random selection
		// Call get method on durationOptions ArrayList, pass rDuration as position peram, triggering random selection
		// Combine both random selections and assign to noteElement string field
		noteElement = noteOptions.get(rNote) + "(" + durationOptions.get(rDuration) + ")";

		return this.noteElement;
	} // End getRandomNote() method
	
	
	// Getter method for playGuitarList that uses For loop to
	// generate i# noteElements and append each to playGuitarList ArrayList
	public ArrayList<String> playGuitar(int iterations) {
		
		// Create ArrayList object
		ArrayList<String> playGuitarList = new ArrayList<String>();
	      
	      // For loop to iterate getRandomNote method i times, generating i noteElements
	      for (int i = 0; i < iterations; i++) { 		      
	    	  // Append result of getRandomNote method to playGuitarList
	    	  playGuitarList.add(getRandomNote());
	      } 
	      System.out.println(playGuitarList);
	      return this.playGuitarList;
	} // End playGuitar() method
	
	
	/* WARNING: Long comments explaining how the reflection package works
	 	Use reflection package to create getColorName method,
		which reads in RGB color value & returns string color name
		Source of info about reflection package - http://www.w3processing.com/index.php?subMenuId=194 */
	public String getColorName(Color guitarColorParam) {
        // Initiate try-catch statement
		try {
            /* Use the forName() and getDeclaredFields() methods on class object
				to fetch the properties of "java.awt.Color", and store in field array */
            Field[] colorFieldProperties = Class.forName("java.awt.Color").getDeclaredFields();
            
            // Use for loop to search the field array, iterating commands in body block
            for (Field colorField : colorFieldProperties) {
            	
            	// Perform getName on colorField and assign result to string variable "colorName"
                String colorName = colorField.getName();
                
                /* Use standard declaration of java.lang.reflect.Field.getType() method 
                   in order to perform getType() on colorField, and assign result to variable "type"
                   source - https://www.tutorialspoint.com/javareflect/javareflect_field_gettype.htm */
                Class<?> type = colorField.getType();
                
                /* If type is recognized as one of the known Java RGB colors in the default color class,
                	then fetch the default color class value, and then, 
                	if the default color definition matches the given guitar color parameter, 
                	then return the string name, in this case the variable colorName */
                if (type == java.awt.Color.class) {
                    Color defined = (Color) colorField.get(null);
                    if (defined.equals(guitarColorParam)) {
                        return colorName;
                    } // End nested if statement
                    
                } // End if statement
            
            } // End for loop
            
        } // End try code block
		
		// Initiate catch code to handle exceptions
		catch (Exception colorException) { // Pass generic exception type named colorException
            // Display what the colorException was
			System.out.println("Exception Occurred: " + colorException.toString());
        } // End catch statement
        return "No known color match exists.";
    } // End getColorName() method

	@Override // Override toString() method
    public String toString() {
    	return "[guitarName = " + this.guitarName + ", "
    			+ "numStrings = " + this.numStrings + ", "
    			+ "guitarLength = " + this.guitarLength + '"' + ", "
    			+ "guitarManufacturer = " + this.guitarManufacturer + ", "
    			/* Call getColorName() method, and pass the corresponding object's getGuitarColor() RGB value,
    				which returns the string color name, and then include result in toString() override method */
    			+ "guitarColor = " + getColorName(this.getGuitarColor()) +"]";
    } // End toString() method   

} // End Guitar class