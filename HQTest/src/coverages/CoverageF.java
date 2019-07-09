package coverages;

/**
 *
 * @author Bowser
 */
public class CoverageF extends CovSuper {
	private static int Index_Position = 0;
	private static double premium = 0.0;
	

	private String[] Option_Array = { "1000", "2000", "3000", "4000", "5000" }; 
	private double[] Premium_Array = { 0, 5, 10, 15, 20 }; // Array of corresponding premiums.

	
	@Override
    public String getCoverageDescription() {
    	return "Coverage F - (Medical Insurance) helps pay for small injuries that happen to your guests on your property, regardless of who is at fault.";
    }
	
	
	@Override
	public String[] getOptionList() { // Returns a string array of the options.
		return Option_Array;
	}

	@Override
	public String getOption() { // Return only the currently selected option.
		String option = Option_Array[Index_Position];
		return option;
	}

	@Override
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

	@Override
	public String getName() {
		return "Medical (Cov F)";
	}

	@Override
	public void setPremium(double value) { // The returned value would be calculated in the Premium Calculation, then
											// returned here..
		premium = value;
	}

	@Override
	public boolean isComboBox() {// Does this coverage use a ComboBox?
		return true;
	}

	@Override
	public void setIndexPosition(int position) {// Return the index position of the selected coverage.
		Index_Position = position; // the Index_Position is then used to retrieve the needed factor or premium.
	}

	@Override
	public int getIndexPosition() { // Return the current position of the option array. Usually
		return Index_Position; // used for multi-dimensional arrays in other classes.
	}

	@Override
	public int covType() {
		return 0;
	}
	
	
}