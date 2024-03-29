package coverages;

public class CoverageD extends CovSuper implements SectionIICoverage  {
	private static double base;
	private static double minimum_value_allowed;
	private static double maximum_value_allowed;
	private static double step;
	private static double option;
	private static double premPer_1000 = 2;//Premium per $1000 dollars of difference between the base value of Coverage A, and the actually value of Coverage's B, C and D.
	private static double premium;	
	
	private static int ctr = 0;//Exists purely to check for the initial run.
	
	double Coverage_A_Current_Option = CoverageA.getCovAValue();	
	
	@Override
    public String getCoverageDescription() {
    	return "Provides reimbursement for the room and boarding of a client in the event of damage to a dwelling, which precludes habitation.";
    }
	
	public void setMinimumValue(double value) {
		minimum_value_allowed = value;
	}
	
	public CoverageD() {	
		base = (Coverage_A_Current_Option * 0.4);		
		minimum_value_allowed = ( Coverage_A_Current_Option * 0.3);  //Minimum required coverage is 10% of the home value.
		step = 1000;
		maximum_value_allowed = 500000;	
		
		if(ctr == 0) {
			option = base;//Run at initialization only.  Without the counter, base and option are always the same. 
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
	public double getStepValue() {
		return step;
	}
		
	
	@Override
	public double getBaseValue() {
		return base;
	}
	
	@Override
	public double getMaximumValue() {
		return maximum_value_allowed;
	}
	
	@Override
	public double getMinimumValue() {
		return minimum_value_allowed;
	}
	
	@Override
	public String getName(){
		return "Loss of Use (Cov D)";
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
