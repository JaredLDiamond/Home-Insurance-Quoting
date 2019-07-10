package coverages;

import hqtest.GUI_Message;

public class BaseRate extends CovSuper {
	
	//Base Rates has both it's own premiums, and also figures into the Protection Class factors.

	private static int Index_Position = 0;
	private static double premium     = 0.0;
	
	static GUI_Message message = new GUI_Message();

	protected static String[] Option_Array = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14",
			"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32",
			"33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50",
			"51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68",
			"69", "70", "71" };

	protected static double[] Premium_Array = { 964, 475, 475, 404, 475, 494, 564, 347, 564, 564, 564, 355, 564, 517, 627,
			678, 625, 678, 376, 402, 540, 428, 468, 468, 421, 452, 540, 678, 574, 420, 678, 584, 613, 703, 540, 517,
			486, 634, 413, 402, 758, 433, 427, 456, 765, 564, 564, 700, 564, 452, 537, 564, 564, 494, 480, 613, 480,
			564, 539, 564, 704, 625, 678, 494, 678, 765, 678, 678, 678, 402, 678 }; // Array of corresponding premiums.

	@Override
    public String getCoverageDescription() {
    	return "Base Rate - the minimum starting coverage.  Base rates are based on conditions in a given area, which may lead to increased liability.";
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
	public String getName() {
		return "Territories/Base Rate";
	}

	@Override
	public boolean isSpinnerList() {
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
