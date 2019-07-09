package coverages;


public class CoverageE extends CovSuper {
	private static int Index_Position = 0;
	private static double premium = 0.0;
	

	private String[] Option_Array = { "100000", "200000", "300000", "400000", "500000" }; // In other cases, the
																							// options are purely
																							// strings.
	private double[] Premium_Array = { 0, 5, 10, 15, 20 }; // Array of corresponding premiums.

	@Override
    public String getCoverageDescription() {
    	return "Coverage E (Liability)  portion of the policy which covers the homeowner for accidental injuries caused to third parties and/or their property, such as a guest slipping and falling down improperly maintained stairs.";
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
		return "Liability (Cov E)";
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
		return Index_Position; // used for multidimensional arrays in other classes.
	}

	@Override
	public int covType() {
		return 0;
	}
}