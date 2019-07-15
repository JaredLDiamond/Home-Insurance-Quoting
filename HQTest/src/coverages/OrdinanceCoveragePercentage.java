package coverages;



public class OrdinanceCoveragePercentage extends CovSuper {    
    protected static int Index_Position = 0;    
    protected static double premium     = 0.0;   
    protected String[] Option_Array     = {"0", "50", "100"};      
    protected Double[] Premium_Array    = {0.0, 50.0, 100.0}; 

    
    @Override
    public String getCoverageDescription() {
    	return "Provides coverage in the event that a dwelling requires construction to meet municipal guidelines.";
    } 
    
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
    public String getName(){
        return "Ordinance Coverage Percentage";
    }
 
    
    @Override
	public void setPremium(double value) {   
        premium = value;  
    }
    
    @Override
    public double getPremium(){             
        if(Premium_Array.length > 0){         
            premium = Premium_Array[Index_Position];
        }        
        return premium;
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
        return 2;
    }
}
