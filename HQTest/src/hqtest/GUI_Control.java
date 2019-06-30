package hqtest;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Observable;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JSplitPane;

import javax.swing.SpinnerNumberModel;
import javax.swing.ToolTipManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import coverages.CovSuper;
import coverages.CoverageA;
import coverages.CoverageB;
import coverages.CoverageRegistration;
import coverages.SectionIICoverage;

public class GUI_Control extends Observable {

	private static GUI_Message myMessage = new GUI_Message();
	

	private final CovSuper[] reg = CoverageRegistration.getCovs();// Contains all coverage values.
	Premium_Calculation pc = new Premium_Calculation(reg);
	private static GUI_Display display = new GUI_Display();// Create the object for MVC notification per individual coverage.
	
	
	JLabel[] name = new JLabel[reg.length];

	public GUI_Control() {
		addObserver(display);
		addObserver(myMessage);			
	}	
	
	
	
	private void changeData(Object data) {
		setChanged(); // the two methods of Observable class
		notifyObservers(data);
		
	}

	

	private JPanel controlPanel() {
		JPanel TopLevelPanel = new JPanel();
		JPanel Name_Panel = new JPanel(new GridLayout(0, 1));
		JPanel Option_Panel = new JPanel(new GridLayout(0, 1));
		
		
		//Rather than use one JPanel, and apply the labels and combo boxes directly to it, I've used three; top-level, name and option. 
		//The reason for this is so that a JSplitPane could be used to make better use of limited space and keep things orderly.  
		//Some names are long, and won't always fit in a predefined space.
		

		Name_Panel.setBorder(BorderFactory.createTitledBorder("Coverage"));
		
		
		JSplitPane TopLevelSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, Name_Panel, Option_Panel);
		TopLevelSplitPane.setMaximumSize(new Dimension(100, 100));
		TopLevelSplitPane.setDividerLocation(100);

		Option_Panel.setMinimumSize(new Dimension(90, 0));
		//Option_Panel.setPreferredSize(new Dimension(130, 0));
		Option_Panel.setBorder(BorderFactory.createTitledBorder("Option"));

		for (int i = 0; i < reg.length; i++) {// Retrieve and populate the coverage name panels.
			name[i] = new JLabel(reg[i].getName());
			name[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			
			
			// This is one of the few - if not only coverage-type items to
			// have more than one name.
			if ("Age of Dwelling".equals(reg[i].getName())) {// Age of Dwelling is the actual coverage, Current Year
																// subtract Year Built.
				name[i].setText("Year Built");// Year built is the input, also Current Year by default.
			}
			
			
			
			Name_Panel.add(name[i]);
			
			
			
			//If the length of the name of the coverage is greater than what can be displayed, then hovering over the label will cause a tool tip to pop-up showing the complete name of the coverage.
			if (name[i].getPreferredSize().getWidth() > TopLevelSplitPane.getDividerLocation()) {	
				ToolTipManager.sharedInstance().setInitialDelay(1000);
				name[i].setToolTipText(reg[i].getName());
			}else {
				name[i].setToolTipText(null);
			}
			

			


			// If initialization of box or list occur outside of this box, then each input
			// type
			// ends up having all the possible options, not just those of type box or list.
			// This
			// has been a problem for various reasons.
			if (reg[i].isComboBox()) {
				JComboBox<String> box = new JComboBox<String>(reg[i].getOptionList());// Populate the box with options from the
																		// corresponding Coverage class.
				
				Option_Panel.add(box);// Add the JComboBox to the menu.
				comboListener(reg[i], box);// Call the JComboBox listener.
			}

			if (reg[i].isSpinnerList()) {//Spinners that require an index fall into this list.  Coverage A, Plan and Base Rate generally. 
				SpinnerListModelIndexing list = new SpinnerListModelIndexing(reg[i]);// Populate the SpinnerIndex with all the options from the
																// corresponding Coverage class.
				
				
				
				
				list.setValue(reg[i].getOption());// Set the starting value to the coverage default.
				JSpinnerNumberField spin = new JSpinnerNumberField(list, reg[i]);// Wrap SpinnerIndex with JSpinner().				
				Option_Panel.add(spin);// Add the list to the menu.
				indexingSpinnerListener(reg[i], list);// Call the IndexSpinner listener.

			}
			
			

			if (reg[i].isSpinnerNumber()) {
				SpinnerNumberModel spinNumber = new SpinnerNumberModel(reg[i].getBaseValue(), reg[i].getMinimumValue(), reg[i].getMaximumValue(), reg[i].getStepValue());
				
			
				JSpinnerNumberField spin2 = new JSpinnerNumberField(spinNumber, reg[i]);	
				
				
				Option_Panel.add(spin2);
				spinnerNumberListener(reg[i], spinNumber);
				
			}
		}

		
		
		
		TopLevelSplitPane.addPropertyChangeListener(JSplitPane.DIVIDER_LOCATION_PROPERTY, 
			    new PropertyChangeListener() {
			        @Override
			        public void propertyChange(PropertyChangeEvent pce) {
			        	for(int i = 0; i < reg.length; i++) {			        	
			        		//If the length of the name of the coverage is greater than what can be displayed, then hovering over the label will cause a tool tip to pop-up showing the complete name of the coverage.
			    			if (name[i].getPreferredSize().getWidth() > TopLevelSplitPane.getDividerLocation()) {
			    				ToolTipManager.sharedInstance().setInitialDelay(1000);
			    				name[i].setToolTipText(reg[i].getName());
			    			}else {
			    				name[i].setToolTipText(null);
			    			}						
						}
			        }
			});
		
		TopLevelPanel.add(TopLevelSplitPane);
		return TopLevelPanel;
	}

	public JPanel getOption() {
		JPanel TopLevelPanel = controlPanel();
		return TopLevelPanel;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private void spinnerNumberListener(final CovSuper cs, final SpinnerNumberModel spinNumber) {
		class myListener implements ChangeListener {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				{
					cs.setOption(spinNumber.getValue());
					cs.getOption();				
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
						 pointer = list.getSelectedIndex();// Pulls this method from the SpinnerIndex.
						 cs.setIndexPosition(pointer);				// multidimensional arrays.
						 changeData(reg); // Notify Observers.	
					}
					
				}else {
					 
						pointer = list.getSelectedIndex();// Pulls this method from the SpinnerIndex.
						 // Pulls this method from the SpinnerIndex.
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
