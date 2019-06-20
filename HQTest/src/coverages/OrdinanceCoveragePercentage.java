package coverages;



public class OrdinanceCoveragePercentage extends CovSuper {
    
    protected static int Index_Position = 0;    
    protected static double premium = 0.0;   
  
    
    
   
    protected String[] Option_Array = {"0", "50", "100"};  //In other cases, the options are purly strings.
    
    
    
    protected double[] Premium_Array = {0, 50, 100}; //Array of corresponding premiums.

    
 
    
    
    @Override
    public String[] getOptionList()  {                 //Returns a string array of the options.        
        return Option_Array;
    }
    
   
    
    @Override
    public String getOption(){                  //Return only the currently selected option.
        String option = Option_Array[Index_Position];
        return option;
    }
    
   
    
    @Override
    public String getName(){//Return coverage name.
        return "Ordinance Coverage Percentage";
    }
 
    
    @Override
	public void setPremium(double value) {   //The returned value would be calculated in the Premium Calculation, then returned here.. 
        premium = value;        
   
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
    public boolean isComboBox(){//Does this coverage use a ComboBox?
        return true;
    }
    
    @Override
    public void setIndexPosition(int position){//Return the index position of the selected coverage.
         Index_Position = position;        //the Index_Position is then used to retrieve the needed factor or premium. 
    }
    
    @Override
    public int getIndexPosition(){        //Return the current position of the option array.  Usually
        return Index_Position;        //used for multi-dimensional arrays in other classes.
    }
    
    @Override
    public int covType(){//What type of coverage is this?
        //Type 0 - Premiums
        //Type 1 - Discount/Surcharge's
        //Type 2 - Additional Premiums
        return 2;
    }
}
