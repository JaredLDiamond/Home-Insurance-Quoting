package coverages;

import javax.swing.JTable;

public class ProtectionClass extends CovSuper{
	private static int Index_Position = 0;    
	private static double premium = 0.0;   
	private static double factor = 1.00;
    
    
    //Protection Class is a 3D array, factoring in Protection Class options, and also Base Rates and ConstructionType.
    
    private String[] Option_Array = {"PC1", "PC2", "PC3", "PC4", "PC5", "PC6", "PC7", "PC8", "PC9", "PC10"};  
    
    private Double[][][] Premium_Array;
                                           //"Frm", "Mas", "Sup"
    private Double[][][] Factor_Array =  {{{1.00, 1.00, 1.00},  //"PC1" //Territory 38
                                             {1.00, 1.00, 1.00},  //"PC2"
                                             {1.00, 1.00, 1.00},  //"PC3"
                                             {1.00, 1.00, 1.00},  //"PC4"
                                             {1.00, 1.00, 1.00},  //"PC5"
                                             {1.00, 1.00, 1.00},  //"PC6"
                                             {1.09, 1.09, 1.09},  //"PC7"
                                             {1.10, 1.10, 1.10},  //"PC8"
                                             {1.43, 1.46, 1.46},  //"PC9"
                                             {1.59, 1.59, 1.59}}, //"PC10"
                                            {{0.76, 0.80, 0.87},  //"PC1"//Territory 39
                                             {0.76, 0.80, 0.87},  //"PC2"
                                             {0.76, 0.80, 0.87},  //"PC3"
                                             {0.76, 0.80, 0.87},  //"PC4"
                                             {0.76, 0.80, 0.87},  //"PC5"
                                             {0.76, 0.80, 0.87},  //"PC6"
                                             {0.97, 0.97, 0.97},  //"PC7"
                                             {0.98, 0.98, 0.98},  //"PC8"
                                             {1.32, 1.32, 1.32},  //"PC9"
                                             {1.41, 1.41, 1.41}}, //"PC10"
                                            {{0.76, 0.80, 0.87},  //"PC1"//All other territories
                                             {0.76, 0.80, 0.87},  //"PC2"
                                             {0.76, 0.80, 0.87},  //"PC3"
                                             {0.76, 0.80, 0.87},  //"PC4"
                                             {0.76, 0.80, 0.87},  //"PC5"
                                             {0.76, 0.80, 0.87},  //"PC6"
                                             {0.97, 0.97, 0.97},  //"PC7"
                                             {0.98, 0.98, 0.98},  //"PC8"
                                             {1.32, 1.32, 1.32},  //"PC9"
                                             {1.41, 1.41, 1.41}}};//"PC10"
    
    
    public Double[][] getCostValues(){
//		if(Premium_Array != null) {
//			return Premium_Array;
//		}else {		
//			return	Factor_Array;
//		}
    	
    	return null;
    	
	}
    
    
    
    @Override
    public String getCoverageDescription() {
    	return "Defined by conditions of a given area, Protection Class can be determined by crime rates, distance to a fire station or geologic instability.";
    }
    
    @Override
	public String getName(){
    	return "Protection Class";
    }
    
    @Override
	public String[] getOptionList(){
    	return Option_Array;
    }
    
    @Override
	public double getFactor(){
    	final BaseRate terr = new BaseRate();
    	
    	int terrValue = 0; 
    	
    	for (int i = 0; i < terr.getOptionList().length; i++){
    		if(null!= terr.getOption())
    			switch(terr.getOption()){
    				case "38":{
    					terrValue = 0;
    				}
    				case "39":{
    					terrValue = 1;
    				}
    				default:{
    					terrValue = 2;
    				}	
    			}
    	}
    	factor = Factor_Array[new ConstructionType().getIndexPosition()][Index_Position][terrValue];
    	return factor;
    	}
    
    @Override
	public void setIndexPosition(int value){
    	Index_Position = value;
    }
    
    @Override
	public int getIndexPosition(){
    	return Index_Position;
    }
    
    @Override
	public boolean isComboBox(){
    	return true;
    }
    
    @Override
	public String getOption(){
    	return Option_Array[Index_Position];
    }
    
    @Override
	public void setPremium(double value){
    	premium = value;
    }
    
    @Override
	public double getPremium(){
    	return premium;
    }
    
    @Override
	public int covType(){
    	return 0;
    }
}
