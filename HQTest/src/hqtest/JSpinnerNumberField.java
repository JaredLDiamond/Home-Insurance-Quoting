package hqtest;

import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.JSpinner.NumberEditor;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.DefaultFormatter;

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
				
				this.setValue(value);
				
				NumberEditor editor = new JSpinner.NumberEditor(this, "dF" + value);
				JFormattedTextField jtf = editor.getTextField();
				
				DefaultFormatter formatter = (DefaultFormatter) jtf.getFormatter();
		        formatter.setCommitsOnValidEdit(true);
		        System.out.println("value changed: ");
//				JComponent comp = this.getEditor();
//				
//				
//				
//				JFormattedTextField field = (JFormattedTextField) comp.getComponent(0);
//			    DefaultFormatter formatter = (DefaultFormatter) field.getFormatter();
//			    formatter.setCommitsOnValidEdit(true);
//			    this.addChangeListener(new ChangeListener() {
//
//			        
//			        public void stateChanged(ChangeEvent e) {
//			            System.out.println("value changed: ");
//			        }
//
//					
//			    });
//				
				
				
				
				
				
				
				
			}
			else {			
				getModel().setValue(value);
			}
		}

		getModel().setValue(value);
	}

}
