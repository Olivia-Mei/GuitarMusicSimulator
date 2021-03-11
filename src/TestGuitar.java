/* File: TestGuitar.java
 * Author: Olivia-Mei McDowell
 * Date: 11-16-2020
 * Description: TestGuitar class demos the Guitar class properties
 * and methods via three different Guitar instances. 
 */

// Import required Java class
import java.awt.Color;

public class TestGuitar {

	public static void main(String[] args) {
		
		// Create default guitar object
		Guitar classic = new Guitar();
		
		// Call toString() method
		System.out.println("\ntoString(): " + classic);
		
		// Call getter methods
		System.out.println("\ngetGuitarName(): " + classic.getGuitarName()
						+ "\ngetNumStrings(): " + classic.getNumStrings()
						+ "\ngetGuitarLength(): " + classic.getGuitarLength() + '"'
						+ "\ngetGuitarManufacturer(): " + classic.getGuitarManufacturer()
						/* Call getColorName() method, and pass the corresponding object's getGuitarColor() RGB value,
							which returns the string color name, and then include result in toString() override method */
						+ "\ngetColorName(this.getGuitarColor()): " + classic.getColorName(classic.getGuitarColor()));
		
		// Call playGuitar() method, pass 16 as parameter to generate 16 random notes
		System.out.print("\nplayGuitar(16): ");
		classic.playGuitar(16);
		
		System.out.println("*************************************");
		
		// Create guitar #2, custom object
		Guitar ibanezUniverse = new Guitar("Ibanez Universe", 7, 25.5, "Ibanez", Color.black);
		
		// Call toString() method
		System.out.println("\ntoString(): " + ibanezUniverse);
				
		// Call getter methods
		System.out.println("\ngetGuitarName(): " + ibanezUniverse.getGuitarName()
						+ "\ngetNumStrings(): " + ibanezUniverse.getNumStrings()
						+ "\ngetGuitarLength(): " + ibanezUniverse.getGuitarLength() + '"'
						+ "\ngetGuitarManufacturer(): " + ibanezUniverse.getGuitarManufacturer()
						+ "\ngetColorName(this.getGuitarColor()): " + ibanezUniverse.getColorName(ibanezUniverse.getGuitarColor()));

		// Call playGuitar() method, pass 16 as parameter to generate 16 random notes
		System.out.print("\nplayGuitar(16): ");
		ibanezUniverse.playGuitar(16);
		
		System.out.println("*************************************");

		// Create guitar #3, custom object
		Guitar americanFenderBass = new Guitar("American Ultra Precision Bass", 4, 34, "Fender", Color.white);
		
		// Call toString() method
		System.out.println("\ntoString(): " + americanFenderBass);
		
		// Call getter methods
		System.out.println("\ngetGuitarName(): " + americanFenderBass.getGuitarName()
						+ "\ngetNumStrings(): " + americanFenderBass.getNumStrings()
						+ "\ngetGuitarLength(): " + americanFenderBass.getGuitarLength() + '"'
						+ "\ngetGuitarManufacturer(): " + americanFenderBass.getGuitarManufacturer()
						+ "\ngetColorName(this.getGuitarColor()): " + americanFenderBass.getColorName(americanFenderBass.getGuitarColor()));
		
		// Call playGuitar() method, pass 16 as parameter to generate 16 random notes
		System.out.print("\nplayGuitar(16): ");
		americanFenderBass.playGuitar(16);
		
	} // End main() method
	
} // End TestGuitar class