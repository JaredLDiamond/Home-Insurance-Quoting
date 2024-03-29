package coverages;

import javax.swing.JTable;

public class CovSuper {

	private static int Index_Position = 0;
	private static double premium = 0.0;
	private static double factor = 1.00;
	private static double maximum_value_allowed = 0;
	private static double minimum_value_allowed = 0;

	public String[] Option_Array = { "" }; // In many cases, the options are purely strings.  Because of that, all options must be in string form, although in cases of interpolation, a numeric options list is required.  It is still converted to a string for the display. 
	private Double[] Premium_Array = {}; // Array of corresponding premiums.
	private Double[] Factor_Array = { 1.00 }; // Array of corresponding factors.
												// Usually, only factors or premiums used. Rarely both.
	
	public String underwriting = null;
	
	static protected int base;
	static protected int min;
	static protected int max;
	static protected int step;

	
	public Double[][] getCostValues(){
		return null;
	}
	
	
	
	public String getCoverageDescription() {
    	return "";
    }
	

	public String[] getOptionList() { // Returns a string array of the options.
		return Option_Array;
	}

	public String getOption() { // Return only the currently selected option.		
		return Option_Array[Index_Position];
	}
	
	

	public double getFactor() { // Returns the single selected factor.
		factor = Factor_Array[Index_Position];
		return factor;
	}

	public String getName() {// Return coverage name.
		return "default";
	}

	public void setPremium(double value) { // The returned value would be calculated in the Premium Calculation, then
											// returned here..
		premium = value;
	}

	public double getPremium() { // Returns the single selected premium. Premiums are often computed through the
		// Premium calculation method, and then are returned here, then sent to the
		// display.
		if (Premium_Array.length > 0) { // If a premium already exists, such as if the coverage is a flat premium, then
											// that
			premium = Premium_Array[Index_Position];// premium is used here without sending it to the Premium
														// Calculation.
		}
		return premium;
	}

	public boolean isSpinnerList() { // Does this coverage use a Spinner?
		return false;
	}
	
	public boolean isSpinnerNumber(){//Does the coverage use a SpinnerNumberModel?
		return false;
	}

	public boolean isComboBox() {// Does this coverage use a ComboBox?
		return false;
	}

	public void setIndexPosition(int position) {// Return the index position of the selected coverage.
		Index_Position = position; // the Index_Position is then used to retrieve the needed factor or premium.
	}

	public int getIndexPosition() { // Return the current position of the option array. Usually
		return Index_Position; // used for multidimensional arrays in other classes.
	}

	public int covType() {// What type of coverage is this?
		// Type 0 - Premiums
		// Type 1 - Discount/Surcharge's
		// Type 2 - Additional Premiums
		return 0;
	}
	
}
