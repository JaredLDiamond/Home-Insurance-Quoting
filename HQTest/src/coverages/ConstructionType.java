package coverages;

import javax.swing.JTable;

public class ConstructionType extends CovSuper {

	private static int Index_Position = 0;
	private static double premium     = 0.0;
	private static double factor      = 1.00;

	private String[] Option_Array = {"Frame", "Masonry", "Superior"}; 	
	private Double[][] Factor_Array = {{ 1.00, 1.25, 1.50 },
									 { 1.00, 1.25, 1.50 }};
	
	private Double[][] Premium_Array;
	
	//In this situation, ConstructionType has both it's own independent factors, and also figures into
	//the Protection Class fields.
	
	
	
	public Double[][] getCostValues(){
		if(Premium_Array != null) {
			return Premium_Array;
		}else {		
			return	Factor_Array;
		} 
	}
	
	
	@Override
    public String getCoverageDescription() {
    	return "Provides a discount or surcharge based on the construction materials and conditions.  Wood frame homes often cause a surcharge, while steel frame homes provide a discount.";
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
	public double getFactor() {
		factor = Factor_Array[0][Index_Position];
		return factor;
	}

	@Override
	public String getName() {
		return "Construction Type";
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
		return 0;
	}
}
