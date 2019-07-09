
package coverages;

public class ProtDevBurglarAlarm extends CovSuper {
	private static int Index_Position = 0;
	private static double premium = 0.0;
	private static double factor = 1.00;

	private ProtDevFireAlarm Fire_Alarm = new ProtDevFireAlarm();

	private String[] Options_Array = { "None", "Local", "Extensive", "Department", "Central" };
	private double[] Premium_Array = {};
	private double[][] Factor_Array = { { 1.00, 1.00, 0.98, 0.95, 0.90 }, { 0.98, 0.98, 0.98, 0.95, 0.90 },
			{ 0.98, 0.98, 0.98, 0.95, 0.90 }, { 0.95, 0.95, 0.95, 0.90, 0.90 }, { 0.90, 0.90, 0.90, 0.90, 0.85 } };

	@Override
    public String getCoverageDescription() {
    	return "Discounts given for prevention and mitigation of acts of robbery and home invasion by the presence of an alarm system.";
    }
	
	@Override
	public String[] getOptionList() {
		return Options_Array;
	}

	@Override
	public String getOption() {
		String option = Options_Array[Index_Position];
		return option;
	}

	@Override
	public double getFactor() { // Returns the single selected factor.
		factor = Factor_Array[Index_Position][Fire_Alarm.getIndexPosition()];
		return factor;
	}

	@Override
	public String getName() {// Return coverage name.
		return "Burglar Alarm";
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
	public void setIndexPosition(int position) {// Return the index position of the selected coverage.
		Index_Position = position; // the Index_Position is then used to retrieve the needed factor or premium.
	}

	@Override
	public int getIndexPosition() { // Return the current position of the option array. Usually
		return Index_Position; // used for multi-dimensional arrays in other classes.
	}

	@Override
	public int covType() {// What type of coverage is this?
		return 1;
	}
}
