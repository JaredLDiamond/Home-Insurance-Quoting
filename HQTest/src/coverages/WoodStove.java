package coverages;

public class WoodStove extends CovSuper {

	private static int Index_Position = 0;
	private static double premium	  = 0.0;

	private String[] Option_Array	= { "No", "Yes" };
	private double[] Premium_Array	= { 0, 50 };

	@Override
	public String getCoverageDescription() {
		return "A wood fired stove on the property is a potential liability and will result in a surcharge.";
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
	public String getName() {
		return "Wood Stove";
	}

	@Override
	public void setPremium(double value) {
		premium = value;
	}

	@Override
	public double getPremium() { 
		if (Premium_Array.length > 0) { 
			premium = Premium_Array[Index_Position];
		}
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
		return 2;
	}

}