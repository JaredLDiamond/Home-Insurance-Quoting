package coverages;

public class Tier extends CovSuper {

	private static int Index_Position = 0;	
	private static double factor      = 1.00;	

	private String[] Option_Array = { "Standard", "Preferred" }; 	
	private Double[] Factor_Array = { 1.00, 1.15 }; 

	
	@Override
    public String getCoverageDescription() {
    	return "";
    }
	
	@Override
	public String[] getOptionList() { 
		return Option_Array;
	}

	@Override
	public String getOption() { 
		return Option_Array[Index_Position];
	}

	@Override
	public double getFactor() { 
		factor = Factor_Array[Index_Position];
		return factor;
	}

	@Override
	public String getName() {
		return "Tier";
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
