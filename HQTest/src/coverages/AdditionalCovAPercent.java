
package coverages;

public class AdditionalCovAPercent extends CovSuper{
    protected static int Index_Position     = 0;    
    protected static double premium         = 0.0;  
    protected static String[] Option_Array  = {"None", "Acap 25", "Acap 50"};  
    protected static double[] Premium_Array = {0, 50, 100};
   
    
    @Override
    public String getCoverageDescription() {
    	return "Coverage provided over the full dwelling cost, often by 25 to 50% the home value";
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
        return "Additional Cov A Percent";
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
