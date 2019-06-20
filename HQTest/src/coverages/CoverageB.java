package coverages;

public class CoverageB extends CovSuper  {
	private static double base;
	private double minimum_value_allowed;
	private double maximum_value_allowed;
	private double step;
	private static double option;
	private static double premPer_1000 = 2;//Premium per $1000 dollars of difference between the base value of Coverage A, and the actually value of Coverages B, C and D.
	private static double premium;	
	
	private static int ctr = 0;
	
	double Coverage_A_Current_Option = CoverageA.getCovAValue();	
	
	
	public CoverageB() {	
		base = (Coverage_A_Current_Option * 0.2);		
		minimum_value_allowed = ( Coverage_A_Current_Option * 0.1);  //Minimum required coverage is 10% of the home value.
		step = 1000;
		maximum_value_allowed = 500000;		
		
		
		if(ctr == 0) {
			option = base;//Run at initialization only.
			ctr++;
		}
		
		
		
		double prem = (option - base)/1000;		
		premium = (prem * premPer_1000);	
		
		if(option == base) {
			premium = 0;
		}
		
		if(option < minimum_value_allowed) {
			option = minimum_value_allowed;			
		}
		
		
	
		
	}
	
	
	
	
	
	@Override
	public String getName(){
		return "Other Structures (Cov B)";
	}
	
	
	@Override
	public double getBase(){
		return base;
	}
	
	@Override
	public double getMin(){
		return minimum_value_allowed;		
	}
	
	@Override
	public double getMax(){
		return maximum_value_allowed;
	}
	
	@Override
	public double getStep(){
		return step;
	}
	
	@Override
	public boolean isSpinnerNumber(){
		return true;
	}	
	
	@Override
	public void setOption(Object o){
		option = (double)o;
	}
	
	
	@Override
	public String getOption(){			
		return "" + option;
	}
	
	@Override
	public double getPremium(){	
		double prem = (option - base)/1000;		
		premium = (prem * premPer_1000);	
		return premium;
	}
}
