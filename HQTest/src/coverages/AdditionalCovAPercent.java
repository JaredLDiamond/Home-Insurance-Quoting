
package coverages;




public class AdditionalCovAPercent extends CovSuper{
    protected static int Index_Position = 0;    
    protected static double premium = 0.0;   
   
    
    
 
    protected static String[] Option_Array = {"None", "Acap 25", "Acap 50"};  
    
    
    
    protected static double[] Premium_Array = {0, 50, 100}; //Array of corresponding premiums.
   
    
    
    
    
 
    
    
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
    public double getPremium(){             //Returns the single selected premium.  Premiums are often computed through the 
                                            //Premium calculation method, and then are returned here, then sent to the display.
        if(Premium_Array.length > 0){         //If a premium already exists, such as if the coverage is a flat premium, then that
            premium = Premium_Array[Index_Position];//premium is used here without sending it to the Premium Calculation.
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
