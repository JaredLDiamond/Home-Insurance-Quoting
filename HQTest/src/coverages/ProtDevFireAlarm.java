package coverages;

public class ProtDevFireAlarm extends CovSuper {

	private static int Index_Position = 0;
	

	private final String[] Option_Array = { "None", "Smoke", "Local", "Department", "Central" }; 
	

	//In this instance, Fire Alarm is factored into the Burglar Alarm arrays, so not premiums or factors are required here. 
	
	
	
	
	@Override
    public String getCoverageDescription() {
    	return "Discounts given for prevention and mitigation of fire damage by the presence of an alarm system.";
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
		return "Fire Alarm";
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
