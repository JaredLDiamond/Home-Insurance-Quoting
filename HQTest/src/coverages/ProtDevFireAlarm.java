package coverages;

public class ProtDevFireAlarm extends CovSuper {

	private static int Index_Position = 0;
	private static double premium = 0.0;
	private static double factor = 1.00;

	private final String[] Option_Array = { "None", "Smoke", "Local", "Department", "Central" }; // In other cases, the
																									// options are purly
																									// strings.
	private double[] Premium_Array = {}; // Array of corresponding premiums.
	
	@Override
    public String getCoverageDescription() {
    	return "Discounts given for prevention and mitigation of fire damage by the presence of an alarm system.";
    }

	@Override
	public String[] getOptionList() { // Returns a string array of the options.
		return Option_Array;
	}

	@Override
	public String getOption() { // Return only the currently selected option.
		return Option_Array[Index_Position];
	}

	@Override
	public double getFactor() { // Returns the single selected factor.
		factor = 1.00;
		return factor;
	}

	@Override
	public String getName() {// Return coverage name.
		return "Fire Alarm";
	}

	@Override
	public void setPremium(double value) { // The returned value would be calculated in the Premium Calculation, then
											// returned here..
		premium = value;
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
	public boolean isComboBox() {// Does this coverage use a ComboBox?
		return true;
	}

	@Override
	public void setIndexPosition(int position) {
		Index_Position = position; 
	}

	@Override
	public int getIndexPosition() {
		return Index_Position; // used for multidimensional arrays in other classes.
	}

	@Override
	public int covType() {// What type of coverage is this?
		return 1;
	}
}
