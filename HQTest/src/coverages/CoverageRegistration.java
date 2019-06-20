package coverages;

import java.util.ArrayList;

public class CoverageRegistration {
	public CoverageRegistration() {

	}

	public static CovSuper[] getCovs() {
		CovSuper[] reg;
		ArrayList<CovSuper> c = new ArrayList<CovSuper>();

		c.add(new BaseRate());
		c.add(new Tier());
		
		c.add(new Plan());
		
		
		c.add(new ProtectionClass());
		c.add(new ConstructionType());
		c.add(new CoverageA());	
		c.add(new CoverageB());
		c.add(new CoverageC());
		c.add(new CoverageD());
		c.add(new CoverageE());
		c.add(new CoverageF());
		c.add(new AdditionalCovAPercent());

		c.add(new ProtDevBurglarAlarm());
		c.add(new ProtDevFireAlarm());
		c.add(new ProtDevSprinklers());
		c.add(new APDeductible());
		c.add(new WoodStove());
		c.add(new Trampoline());
		c.add(new OrdinanceCoveragePercentage());

		int ctr = 0;

		for (int Coverage_Counter = 0; Coverage_Counter < c.size(); Coverage_Counter++) {
			if (c.get(Coverage_Counter) != null) {
				ctr++;
			}
		}

		reg = new CovSuper[ctr];
		ctr = 0;

		reg = new CovSuper[c.size()];
		reg = c.toArray(reg);

		return reg;
	}

}
