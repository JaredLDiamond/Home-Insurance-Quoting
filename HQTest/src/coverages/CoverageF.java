package coverages;


public class CoverageF extends CovSuper {
	private static int Index_Position = 0;
	private static double premium     = 0.0;
	private String[] Option_Array     = { "1000", "2000", "3000", "4000", "5000" }; 
	private Double[] Premium_Array    = { 0.0, 5.0, 10.0, 15.0, 20.0 }; 

	
	@Override
    public String getCoverageDescription() {
    	return "Coverage F - (Medical Insurance) helps pay for small injuries that happen to your guests on your property, regardless of who is at fault.";
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
		return "Medical (Cov F)";
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