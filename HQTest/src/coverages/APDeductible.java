package coverages;

public class APDeductible extends CovSuper {
	private static int Index_Position = 0;
	private static double premium = 0.0;
	private static double factor = 1.00;

	private String[] Option_Array = { "500", "1000", "1500", "2000", "2500" };
	private double[] Factor_Array = { 1.00, 0.75, 0.50, 0.25, 0.10 }; 

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
		return "AP Deductible";
	}

	@Override
	public void setPremium(double value) {
		premium = value;
	}

	@Override
	public double getPremium() {
		return premium;
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
		return 1;
	}
}