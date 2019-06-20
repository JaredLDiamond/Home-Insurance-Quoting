package coverages;
public class Plan extends CovSuper {
    
    protected static int Index_Position = 0;    
    protected static double premium = 0.0;   
    protected static double factor = 1.00;
    
    
    
    protected String[] Option_Array = {"Plus", "Summit"};  //In other cases, the options are purly strings.
    
    
    
    protected double[] Premium_Array = {};    //Array of corresponding premiums.
    protected double[] Factor_Array = {1.00, 1.20};  //Array of corresponding factors.
                                             //Usually, only factors or premiums used.  Rarely both. 
    
     
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
    public double getFactor(){  //Returns the single selected factor.
        factor = Factor_Array[Index_Position];
        return factor;
    }
    
    @Override
    public String getName(){//Return coverage name.
        return "Plan";
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
    public boolean isSpinnerNumber(){  //Does this coverage use a Spinner?
        return false;
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
    public int getIndexPosition(){        
        return Index_Position;        
    }
    
    @Override
    public int covType(){
        return 0;
    }
}
