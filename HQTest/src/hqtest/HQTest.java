package hqtest;

import ratingTables.RatingTables;
import coverages.CovSuper;
import coverages.CoverageRegistration;

public class HQTest {
	private final static CovSuper[] reg = CoverageRegistration.getCovs();// Contains all coverage values.
	public static void main(String[] args) {
		//Just to get things started. 
        new GUI_Frame().GUI(); 
        
       	
       
        	//new RatingTables();
      
        
        
        
        
        
//        for (int i = 0; i < reg.length; i++) {
//        	if(reg[i].getName()== "Burglar Alarm") {
//        		new RatingTables(reg[i]);
//        	}
//        	
//        }
        
        
        
    }
}