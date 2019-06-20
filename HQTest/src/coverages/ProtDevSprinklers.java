package coverages;

public class ProtDevSprinklers extends CovSuper {

	private static int Index_Position = 0;
    private static double premium = 0.0;   
    private static double factor = 1.00;
    
    protected String[] Option_Array = {"None", "Partial", "Extensive"}; 
    protected double[] Factor_Array = {1.00, 0.9, 0.8};

    @Override
	public String getName() {// Return coverage name.
		return "Sprinklers";
	}

	

	@Override
	public double getFactor() { // Returns the single selected factor.
		factor = Factor_Array[Index_Position];
		return factor;
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
	public void setPremium(double value) { // The returned value would be calculated in the Premium Calculation, then
											// returned here..
		premium = value;
	}

	@Override
	public double getPremium() { 		
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
		// Type 0 - Premiums
		// Type 1 - Discount/Surcharge's
		// Type 2 - Additional Premiums
		return 1;
	}

}
