package coverages;

import javax.swing.JTable;

public class ProtDevSprinklers extends CovSuper {

	private static int Index_Position = 0;
    private static double premium     = 0.0;   
    private static double factor      = 1.00;
    
    protected String[] Option_Array = {"None", "Partial", "Extensive"}; 
    protected Double[][] Factor_Array = {{1.00, 0.9, 0.8},
    							         {1.00, 0.9, 0.8}};
    
    protected Double[][] Premium_Array;
    
    public Double[][] getCostValues(){
		if(Premium_Array != null) {
			return Premium_Array;
		}else {		
			return	Factor_Array;
		} 
	}

    @Override
	public String getName() {
		return "Sprinklers";
	}

    @Override
    public String getCoverageDescription() {
    	return "Discounts given for the presence of a fire suppression system.  This often work in conjunction with a fire alarm system.";
    }

	@Override
	public double getFactor() { 
		factor = Factor_Array[0][Index_Position];
		return factor;
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
