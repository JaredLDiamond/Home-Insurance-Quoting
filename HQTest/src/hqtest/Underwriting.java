package hqtest;

import coverages.CovSuper;
import coverages.CoverageRegistration;
import coverages.Plan;
import coverages.ProtectionClass;
import coverages.WoodStove;

public class Underwriting {	
	Plan plan = new Plan();
	WoodStove stove = new WoodStove();
	ProtectionClass PC = new ProtectionClass();
	
	StringBuilder restriction = new StringBuilder();
	
	
	
	private final CovSuper[] reg = CoverageRegistration.getCovs();// Contains all coverage values.
	
	public Underwriting() {
			if(stove.getIndexPosition() > 0) {
				restriction.append("Wood Stove not allowed\n");
			}
				
			if((plan.getIndexPosition() > 0)&&(PC.getIndexPosition() > 8)) {
				restriction.append("Summit plan not allowed in Protection Class 10\n");
			}
		
			if(PC.getIndexPosition() > 1) {
				restriction.append("Protection Class above PC2\n");
			}
			if(PC.getIndexPosition() > 2) {
				restriction.append("Protection Class above PC3\n");
			}
			
			for(int i = 0; i < reg.length; i ++) {
				if((reg[i].getName() == "Trampoline")&&(reg[i].getIndexPosition() > 0)) {
				restriction.append("Trampolines not allowed\n");
				}
			}
		}
		
	
	public StringBuilder setUnderwriting() {
		return restriction;
	}
	
		
	}
	
	

