package coverages;


public class CoverageE extends CovSuper {
	private static int Index_Position = 0;
	private static double premium     = 0.0;
	private String[] Option_Array     = { "100000", "200000", "300000", "400000", "500000" }; 
	private Double[] Premium_Array    = { 0.0, 5.0, 10.0, 15.0, 20.0 }; 

	@Override
    public String getCoverageDescription() {
    	return "Coverage E (Liability)  portion of the policy which covers the homeowner for accidental injuries caused to third parties and/or their property, such as a guest slipping and falling down improperly maintained stairs.";
    }
	
	@Override
	public String[] getOptionList() { 
		return Option_Array;
	}

	@Override
	public String getOption() { 
		String option = Option_Array[Index_Position];
		return option;
	}

	@Override
	public double getPremium() { 
		if (Premium_Array.length > 0) { 
			premium = Premium_Array[Index_Position];
		}
		return premium;
	}

	@Override
	public String getName() {
		return "Liability (Cov E)";
	}

	@Override
	public void setPremium(double value) { 
		premium = value;
	}

	@Override
	public boolean isComboBox() {
		return true;
	}

	@Override
	public void setIndexPosition(int position) {
		Index_Position = position;
	}

	@Override
	public int getIndexPosition() { 
		return Index_Position; 
	}

	@Override
	public int covType() {
		return 0;
	}
}