package hqtest;

import java.text.ParseException;

import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;

public class JSpinnerNumberField extends JSpinner{	
	
	public JSpinnerNumberField(SpinnerModel model) {
		super(model);
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
	

}
