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
	
	
	private Double[][] Factor_Array;
	

	private Double[][] Premium_Array = {{964.0,475.0,475.0,404.0,475.0,494.0,564.0,347.0,564.0,564.0,564.0,355.0,564.0,517.0,627.0,678.0,625.0,678.0,376.0,402.0,540.0,428.0,468.0,
			468.0,421.0,452.0,540.0,678.0,574.0,420.0,678.0,584.0,613.0,703.0,540.0,517.0,486.0,634.0,413.0,402.0,758.0,433.0,427.0,456.0,765.0,564.0,
			564.0,700.0,564.0,452.0,537.0,564.0,564.0,494.0,480.0,613.0,480.0,564.0,539.0,564.0,704.0,625.0,678.0,494.0,678.0,765.0,678.0,678.0,678.0,
			402.0,678.0},
			{964.0,475.0,475.0,404.0,475.0,494.0,564.0,347.0,564.0,564.0,564.0,355.0,564.0,517.0,627.0,678.0,625.0,678.0,376.0,402.0,540.0,428.0,468.0,
				468.0,421.0,452.0,540.0,678.0,574.0,420.0,678.0,584.0,613.0,703.0,540.0,517.0,486.0,634.0,413.0,402.0,758.0,433.0,427.0,456.0,765.0,564.0,
				564.0,700.0,564.0,452.0,537.0,564.0,564.0,494.0,480.0,613.0,480.0,564.0,539.0,564.0,704.0,625.0,678.0,494.0,678.0,765.0,678.0,678.0,678.0,
				402.0,678.0}}; // Array of corresponding premiums.
	
	
	
	public Double[][] getCostValues(){
		if(Premium_Array != null) {
			return Premium_Array;
		}else {		
			return	Factor_Array;
		} 
	}
	
	
	
	
	

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
			premium = Premium_Array[0][Index_Position];											
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
