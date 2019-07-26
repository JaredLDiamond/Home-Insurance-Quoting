	package hqtest;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Observable;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.ToolTipManager;
import javax.swing.JSpinner.NumberEditor;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.DefaultFormatter;

import coverages.CovSuper;
import coverages.CoverageRegistration;
import coverages.SectionIICoverage;


public class GUI_Control extends Observable {
	private static GUI_Message myMessage = new GUI_Message();	

	private static final CovSuper[] reg = CoverageRegistration.getCovs();// Contains all coverage values.
	
	private static GUI_Display display = new GUI_Display();// Create the object for MVC notification per individual coverage.	
	
	

	public GUI_Control() {
		addObserver(display);
		addObserver(myMessage);			
	}	
	
	
	
	private void changeData(Object data) {
		setChanged(); // the two methods of Observable class
		notifyObservers(data);
		
	}

	
	static int ctr = 0;
	private JPanel controlPanel() {
		JPanel TopLevelPanel = new JPanel();
		JPanel NamePanel     = new JPanel(new GridLayout(0, 1));
		JPanel OptionPanel   = new JPanel(new GridLayout(0, 1));
		JLabel[] NameLabel   = new JLabel[reg.length];
		
		//Rather than use one JPanel, and apply the labels and combo boxes directly to it, I've used three; top-level, NameLabel and option. 
		//The reason for this is so that a JSplitPane could be used to make better use of limited space and keep things orderly.  
		//Some names are long, and won't always fit in a predefined space.
		
		JSplitPane TopLevelSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, NamePanel, OptionPanel);
		TopLevelSplitPane.setOneTouchExpandable(true);
		
		
		NamePanel.setBorder(BorderFactory.createTitledBorder("Coverage"));
		NamePanel.setMinimumSize(new Dimension(30, 0));
		NamePanel.setPreferredSize(new Dimension(170, 0));
		
		OptionPanel.setBorder(BorderFactory.createTitledBorder("Option"));
		OptionPanel.setMinimumSize(new Dimension(30, 0));		

		for (int i = 0; i < reg.length; i++) {// Retrieve and populate the coverage NameLabel panels.
			NameLabel[i] = new JLabel(reg[i].getName());
			NameLabel[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			
			
			// This is one of the few - if not only coverage-type items to
			// have more than one NameLabel.
//			if ("Age of Dwelling".equals(reg[i].getName())) {// Age of Dwelling is the actual coverage, Current Year
//																// subtract Year Built.
//				NameLabel[i].setText("Year Built");// Year built is the input, also Current Year by default.
//			}//The function that uses Age of Dwelling is not yet implemented.
			
			NamePanel.add(NameLabel[i]);	
			
			//If the length of the NameLabel of the coverage is greater than what can be displayed, then hovering over the label will cause a tool tip to pop-up showing the complete NameLabel of the coverage.
			if (NameLabel[i].getPreferredSize().getWidth() > TopLevelSplitPane.getDividerLocation()) {	
				ToolTipManager.sharedInstance().setInitialDelay(1000);
				NameLabel[i].setToolTipText(reg[i].getName());
			}else {
				NameLabel[i].setToolTipText(null);
			}


			// If initialization of box or list occur outside of this box, then each input
			// type
			// ends up having all the possible options, not just those of type box or list.
			// This
			// has been a problem for various reasons.
			if (reg[i].isComboBox()) {
				JComboBox<String> box = new JComboBox<String>(reg[i].getOptionList());// Populate the box with options from the corresponding Coverage class.																			
				OptionPanel.add(box);// Add the JComboBox to the menu.
				comboListener(reg[i], box);// Call the JComboBox listener.
			}

			if (reg[i].isSpinnerList()) {//Spinners that require an index fall into this list.  Coverage A, Plan and Base Rate generally. 
				SpinnerListModelIndexing list = new SpinnerListModelIndexing(reg[i]);// Populate the SpinnerListModelIndexing with all the options from the
																// corresponding Coverage class.
				
				list.setValue(reg[i].getOption());// Set the starting value to the coverage default.
				JSpinnerNumberField spin = new JSpinnerNumberField(list, reg[i]);// Wrap SpinnerListModelIndexing with JSpinner().				
				OptionPanel.add(spin);// Add the list to the menu.
				indexingSpinnerListener(reg[i], list);// Call the IndexSpinner listener.				
				
			}

			if (reg[i].isSpinnerNumber()) {
				SectionIICoverage sec2 = (SectionIICoverage) reg[i];
				SpinnerNumberModel spinNumber = new SpinnerNumberModel(sec2.getBaseValue(), sec2.getMinimumValue(), sec2.getMaximumValue(), sec2.getStepValue());		
				JSpinnerNumberField spin2 = new JSpinnerNumberField(spinNumber, reg[i]);	
				OptionPanel.add(spin2);
				
				
				spinnerNumberListener(sec2, spinNumber);			
				
				
				
				
				
				
				
				
				
				
				
				
				
				
//				if (this instanceof SectionIICoverage) {			
//					Double myValue = (Double) reg[i].getMinimumValue();
//					SectionIICoverage sec2 = (SectionIICoverage) this;
//					
//					if(myValue < sec2.getMinimumValue()) {
//						reg[i].setMinimumValue(sec2.getMinimumValue());	
//						
//						this.setValue(value);
//						
//						NumberEditor editor = new JSpinner.NumberEditor(this, "dF" + value);
//						JFormattedTextField jtf = editor.getTextField();
//						
//						DefaultFormatter formatter = (DefaultFormatter) jtf.getFormatter();
//				        formatter.setCommitsOnValidEdit(true);
//				        System.out.println("value changed: ");
//						JComponent comp = this.getEditor();
//						
//						
//						
//						JFormattedTextField field = (JFormattedTextField) comp.getComponent(0);
//					    DefaultFormatter formatter = (DefaultFormatter) field.getFormatter();
//					    formatter.setCommitsOnValidEdit(true);
//					    this.addChangeListener(new ChangeListener() {
		//
//					        
//					        public void stateChanged(ChangeEvent e) {
//					            System.out.println("value changed: ");
//					        }
		//
//							
//					    });
//						
						
						
						
						
						
						
						
//					}
//					else {			
//						getModel().setValue(value);
//					}
//				}
//
//				getModel().setValue(value);
//			}
//				
				
				
				
				
				
				
				
				
				
				
				
				
					
				
			}
		}
		
		TopLevelSplitPane.addPropertyChangeListener(JSplitPane.DIVIDER_LOCATION_PROPERTY, 
			    new PropertyChangeListener() {
			        @Override
			        public void propertyChange(PropertyChangeEvent pce) {
			        	for(int i = 0; i < reg.length; i++) {			        	
			        		//If the length of the NameLabel of the coverage is greater than what can be displayed, then hovering over the label will cause a tool tip to pop-up showing the complete NameLabel of the coverage.
			    			if (NameLabel[i].getPreferredSize().getWidth() > TopLevelSplitPane.getDividerLocation()) {
			    				ToolTipManager.sharedInstance().setInitialDelay(1000);
			    				NameLabel[i].setToolTipText(reg[i].getName());
			    			}else {
			    				NameLabel[i].setToolTipText(null);
			    			}						
						}
			        }
			});		
		TopLevelPanel.add(TopLevelSplitPane);
		return TopLevelPanel;
	}

	public JPanel getOptionPanel() {
		JPanel TopLevelPanel = controlPanel();
		return TopLevelPanel;
	}	
	
	private void spinnerNumberListener(final SectionIICoverage cs, final SpinnerNumberModel spinNumber) {
		class myListener implements ChangeListener {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				{
					cs.setOption(spinNumber.getValue());							
					changeData(reg); // Notify Observers.
				}
			}
		}
		spinNumber.addChangeListener(new myListener());
	}
	

	private void indexingSpinnerListener(final CovSuper cs, final SpinnerListModelIndexing list) {
		class myListener implements ChangeListener {
			@Override
			public void stateChanged(ChangeEvent e) {
				{						
					SpinnerListModelIndexing source = (SpinnerListModelIndexing)e.getSource();
					int pointer = list.getSelectedIndex();
					
					if(cs instanceof Interpolation==false) {//If this is not an instance of Interpolation, check the source for highlighting purposes.
															//CovA does not highlight without interpolation.  Need to fix this.
						
					
					if ((source.getValue() != cs.getOption())){		//Forces the system to take only the first spinner event for highlighting purposes.  			
						 pointer = list.getSelectedIndex();// Pulls this method from the SpinnerListModelIndexing.
						 cs.setIndexPosition(pointer);				// multidimensional arrays.
						 changeData(reg); // Notify Observers.	
					}
					
				}else {					 
						pointer = list.getSelectedIndex();// Pulls this method from the SpinnerListModelIndexing.
						 // Pulls this method from the SpinnerListModelIndexing.
						 cs.setIndexPosition(pointer);				// multidimensional arrays.
						 changeData(reg); // Notify Observers.							 
					 }					
				}
			}
		}  
		list.addChangeListener(new myListener());
	}

	private void comboListener(final CovSuper cs, final JComboBox<String> box) {
		class myActionListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {				
				
				int pointer = box.getSelectedIndex();
				cs.setIndexPosition(pointer);// This is here to set the values in the Coverage package, for use in
												// multi-dimensional arrays.
				changeData(reg);
				
			}
		}
		myActionListener al = new myActionListener();
		box.addActionListener(al);
	}
}
