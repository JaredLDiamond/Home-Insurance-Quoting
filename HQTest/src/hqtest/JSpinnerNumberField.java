package hqtest;

import java.io.Serializable;
import java.text.ParseException;

import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.event.ChangeEvent;





import coverages.CoverageB;

public class JSpinnerNumberField extends JSpinner{
	
	
	
	CoverageB covb = new CoverageB();
	
	
	public JSpinnerNumberField(SpinnerModel model) {
		super(model);		
		CoverageB covb = new CoverageB();
		//System.out.println(covb.getMin());
    }
	
	
	
	public void setValue(Object value) {
		//System.out.println("Cov B minimum " + covb.getMin());
		//System.out.println("Object value " + value);
		
		Double myValue = (double) value;
		//System.out.println("myValue " + myValue);
		
		
		System.out.println("Cov B min " +  myValue);
		
		
		if(covb.getMinimumValue() < myValue) {
			myValue = covb.getMinimumValue();
		}
		
		
        getModel().setValue(myValue);
		
		
    }
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public JFormattedTextField getTextField() {
		
		JFormattedTextField text = new JFormattedTextField("test");
		
		
		
		return text;
        //return (JFormattedTextField)getComponent(0);
    }
	
	
	@Override
	public void commitEdit() throws ParseException {		
        JComponent editor = getEditor();
       
        if (editor instanceof DefaultEditor) {
            ((DefaultEditor)editor).commitEdit();
        }
    }
	

	public void setTextField(double newValue) {
		super.setValue(newValue);
	}
	
}
