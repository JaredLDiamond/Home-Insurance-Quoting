package coverages;



public class Plan extends CovSuper {
    
    protected static int Index_Position = 0;    
    protected static Double premium     = 0.0;   
    protected static double factor      = 1.00;
    protected Double[][] Premium_Array;    
    protected Double[][] Factor_Array     = {{1.00, 1.20},{1.00, 1.20}};  
    
    
    
    
    public Double[][] getCostValues(){
		if(Premium_Array != null) {
			return Premium_Array;
		}else {		
			return	Factor_Array;
		} 
	}
    
    
    @Override
    public String getCoverageDescription() {
    	return "Plans are sets of predetermined options.  Some options may be modified.  A plan can provide a discount or a surcharge.";
    }
    
    protected String[] Option_Array = {"Plus", "Summit"};  
    
     
    @Override
    public String[] getOptionList()  {                      
        return Option_Array;
    }
    
    @Override
    public String getOption(){                  
        String option = Option_Array[Index_Position];
        return option;
    }
    
    @Override
    public double getFactor(){  
        factor = Factor_Array[0][Index_Position];
        return factor;
    }
    
    @Override
    public String getName(){
        return "Plan";
    }
 
  
    @Override
	public void setPremium(double value) {   
        premium = value;   
    }
    
    
    @Override
	public double getPremium(){   
        return premium;
    }
    
    @Override
    public boolean isSpinnerNumber(){ 
        return false;
    }    
   
    @Override
    public boolean isComboBox(){
        return true;
    }
    
    @Override
    public void setIndexPosition(int position){
         Index_Position = position;        
    }
    
    @Override
    public int getIndexPosition(){        
        return Index_Position;        
    }
    
    @Override
    public int covType(){
        return 0;
    }
}
