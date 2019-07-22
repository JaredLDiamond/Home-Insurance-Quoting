
package coverages;

import javax.swing.JTable;

public class ProtDevBurglarAlarm extends CovSuper {
	private ProtDevFireAlarm Fire_Alarm = new ProtDevFireAlarm();
	
	private static int Index_Position = 0;
	private static double premium     = 0.0;
	private static double factor      = 1.00;

	

	private String[] Options_Array = { "None", "Local", "Extensive", "Department", "Central" };
	private Double[][] Premium_Array;
	
	               //Fire Alarm Options: None  Smoke Local Depart Cent       //Burglar Alarm Options:	        
	private Double[][] Factor_Array = {{ 1.00, 1.00, 0.98, 0.95, 0.90 },     //None      
			                           { 0.98, 0.98, 0.98, 0.95, 0.90 },     //Local     
			                           { 0.98, 0.98, 0.98, 0.95, 0.90 },     //Extensive 
			                           { 0.95, 0.95, 0.95, 0.90, 0.90 },     //Department
			                           { 0.90, 0.90, 0.90, 0.90, 0.85 } };   //Central  
	
	
	
	
	public Double[][] getCostValues(){
		if(Premium_Array != null) {
			return Premium_Array;
		}else {		
			return	Factor_Array;
		} 
	}
	
	
	
	
	
	
	
	
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
	public double getFactor() { 
		factor = Factor_Array[Index_Position][Fire_Alarm.getIndexPosition()];
		return factor;
	}

	@Override
	public String getName() {
		return "Burglar Alarm";
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
