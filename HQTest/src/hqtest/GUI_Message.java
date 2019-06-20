package hqtest;



import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextArea;

public class GUI_Message implements Observer {
	static JTextArea text      = new JTextArea();
	static StringBuilder myStr = new StringBuilder();
	static StringBuilder AltMessage = new StringBuilder();
	//Using StringBuilder instead of String, to that the message can be appended and overwritten as needed.
	
	public GUI_Message() {}

	@Override
	public void update(Observable o, Object data) {		
		//reg = ((CovSuper[]) data);		//In the end, actually using data or object is not necessary to update the class.  
		myStr = new Underwriting().setUnderwriting();
		text.setText(myStr.toString());
	}  
	
	public void setMessage(StringBuilder message) {//This method is for any remaining non-underwriting messages from other sources.		
		if(message.length() > 0) {//If there's no message, ignore this step.
			text.append(message.toString());
		}
	}
	
	public JTextArea getMessages(){	
		text.setEditable(false);		
		//The text area is applied directly to a scroll pane in GUI_Frame - messagePanel();
        return text;        
    }
	
	
}
