package hqtest;

import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import coverages.CovSuper;
import coverages.SectionIICoverage;

public class JSpinnerNumberField extends JSpinner{
	
	private static final long serialVersionUID = 1L;
	CovSuper cs;
	
	public JSpinnerNumberField(SpinnerModel model, CovSuper cs) {
		super(model);		
		this.cs = cs;			
    }
	
	
	
	public void setValue(Object value) {
		if (cs instanceof SectionIICoverage) {			
			Double myValue = (Double) value;
			SectionIICoverage sec2 = (SectionIICoverage) cs;
			
			if(myValue < sec2.getMinimumValue()) {
				value = sec2.getMinimumValue();						
			}
			else {			
				getModel().setValue(value);
			}
		}

		getModel().setValue(value);
	}

}
