package coverages;

import java.util.Arrays;

import hqtest.Interpolation;

public class CoverageA extends CovSuper implements Interpolation {
	protected static int Index_Position = 0;
    protected static double premium = 0.0;
    protected static double factor = 1.0;
    protected static double option = 0;
    protected static double Interpolated_Option = 0;
    protected static double Interpolated_Factor = 0;
    
    @Override
    public String getCoverageDescription() {
    	return "Coverage A - Dwelling Form covers damage to the main dwelling.";
    }    
    
    public static double getCovAValue(){    	
    	return option;
    }

    protected static double[] Option_Array = {50000, 52000, 54000, 56000, 58000, 60000, 62000, 64000, 66000, 68000, 70000, 72000, 74000, 76000, 78000, 80000,
        82000, 84000, 86000, 88000, 90000, 92000, 94000, 96000, 98000, 100000, 110000, 120000, 130000, 140000, 150000, 160000,
        170000, 180000, 190000, 200000, 210000, 220000, 230000, 240000, 250000, 260000, 270000, 280000, 290000, 300000, 310000, 320000,
        330000, 340000, 350000, 360000, 370000, 380000, 390000, 400000, 410000, 420000, 430000, 440000, 450000, 460000, 470000, 480000,
        490000, 500000};  //Array of available options.

    protected static double[] Premium_Array = {}; //Array of corresponding premiums.
    protected static double[] Factor_Array = {0.72, 0.735, 0.75, 0.765, 0.78, 0.794, 0.808, 0.821, 0.834, 0.847, 0.86, 0.872, 0.885, 0.897, 0.908, 0.92, 0.931, 0.942, 0.952, 0.962, 0.972, 0.981, 0.99, 0.996, 0.998, 1,
        1.046, 1.106, 1.137, 1.17, 1.216, 1.282, 1.347, 1.412, 1.474, 1.535, 1.59, 1.645, 1.7, 1.755, 1.81, 1.862, 1.914, 1.966, 2.018, 2.07, 2.121, 2.172, 2.223, 2.274, 2.325, 2.376,
        2.427, 2.478, 2.529, 2.58, 2.63, 2.68, 2.73, 2.78, 2.83, 2.88, 2.93, 2.98, 3.03, 3.08};  //Array of corresponding factors.
    //Usually, only factors or premiums used.  Rarely both. 

    
    
    
    //Coverage A arrays are static in order to properly set the defaults (100,000 is standard).
    //If not static, the array's will be unable to change out of the standard.
    static {
		for(int i = 0; i < Option_Array.length; i++){
			if(Option_Array[i] == 100000){
				Index_Position = i;
				
			}
		}
    }
   
    
    

	@Override
	public double Base() {
		return 0.0;
	}

	public CoverageA() {
		option = Option_Array[Index_Position];
		factor = Factor_Array[Index_Position];
	}

//	@Override
//	public void interpolatePoints(double Lesser_Policy_Amount, double Greater_Policy_Amount, double Desired_Option_Amount) {
//
//		/*
//		 * Method of Interpolation Example: A premium is desired for a policy amount of
//		 * $164000 which falls between $160000 and $170000. The desired amount is $4000
//		 * above $160000.
//		 * 
//		 * 
//		 * Policy Amount Shown Premium Shown
//		 * _____________________________________________________________ $170,000 $561
//		 * $160,000 $532 _____________________________________________________________
//		 * Difference _____________________________________________________________
//		 * $10,000 $29
//		 * 
//		 * 
//		 * ($4,000(The additional amount)/$10,000(Difference amount)) * ($29 Difference
//		 * Premium = $12)
//		 * 
//		 * $532 - Premium for $160,000 $12 - Premium for the additional $4,000 ------
//		 * $544 - Interpolated Premium;
//		 * 
//		 */
//
//		int Point_A = Arrays.binarySearch(Option_Array, Lesser_Policy_Amount);
//		int Point_B = Arrays.binarySearch(Option_Array, Greater_Policy_Amount);
//
//		double Lower_Factor = Factor_Array[Point_A];
//		double Greater_Factor = Factor_Array[Point_B];
//
//		double Lower_Option = Option_Array[Point_A];
//		double Greater_Option = Option_Array[Point_B];
//
//		double Option_Difference = Greater_Option - Lower_Option;
//		double Factor_Difference = Greater_Factor - Lower_Factor;
//
//		double Amount_Above_Lowest_Point = Desired_Option_Amount - Lower_Option;
//
//		Interpolated_Factor = ((Amount_Above_Lowest_Point / Option_Difference) * Factor_Difference) + Lower_Factor;
//		factor = Interpolated_Factor;
//		option = Desired_Option_Amount;
//	}

	
	
	
	
	
	
	@Override
	public void interpolatePoints(double Lesser_Option_Amount, double Greater_Option_Amount, double Custom_Option_Amount) {
        int Point_A = Arrays.binarySearch(Option_Array, Lesser_Option_Amount); //Low point
        int Point_B = Arrays.binarySearch(Option_Array, Greater_Option_Amount);//High point       

        double Lower_Factor = Factor_Array[Point_A];
        double Greater_Factor = Factor_Array[Point_B];

        double Lower_Option = Option_Array[Point_A];
        double Greater_Option = Option_Array[Point_B];

        double Option_Difference = Greater_Option - Lower_Option;

        double Amount_Above_Lowest_Point = Custom_Option_Amount - Lower_Option;

        double Factor_Difference = Greater_Factor - Lower_Factor;
        Interpolated_Factor = ((Amount_Above_Lowest_Point / Option_Difference) * Factor_Difference) + Lower_Factor;
        factor = Interpolated_Factor;
        option = Custom_Option_Amount;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
    public String[] getOptionList()  {                 //Returns a string array of the options.
		String[] strOptions = new String[Option_Array.length]; //These get loaded into the corresponding Spinner/ComboBoxes.
        for(int i = 0; i < Option_Array.length; i++){
            strOptions[i] = "" + Option_Array[i]; 
        }
        return strOptions;
    }
    
    
    @Override
    public void setInterpolatedOption(double value) {
        Interpolated_Option = value;
    }

    @Override
    public void setInterpolatedFactor(double value) {
        factor = value;
    }



    @Override
    public double[] getNumericOptionList() {
        return Option_Array;
    }

	@Override
	public String getOption() {
		if (Interpolated_Option != 0) { // If an interpolated option is entered...
			option = Interpolated_Option; // Set option to the interpolated value...
			Interpolated_Option = 0; // Reset Interpolated_Option to zero for the next cycle...
			return option + ""; // Send to display
		} else {
			return option + ""; // Otherwise, just send the list option.
		}
	}

	@Override
	public double getFactor() { // Returns the single selected factor.
		if (Interpolated_Factor != 0) { // If the factor is interpolated....
			factor = Interpolated_Factor; // Set Factor to Interpolated_Factor
			Interpolated_Factor = 0; // Reset Interpolated_Factor to zero for the next cycle.
			return factor; // Return Interpolated factor.
		} else {
			return factor; // If not interpolated, send selected list factor...
		}
	}

	@Override
	public String getName() {
		return "Dwelling (Cov A)";
	}

	@Override
	public void setPremium(double value) {
		premium = value;
	}

	@Override
	public double getPremium() {
		if (Premium_Array.length > 0) {
			premium = Premium_Array[Index_Position];
		}
		return premium;
	}

	@Override
	public boolean isSpinnerList() {
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
