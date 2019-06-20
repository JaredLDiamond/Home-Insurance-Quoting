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
import coverages.CoverageRegistration;

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

	
	
	
	
	
	
	
	
	
	
	static String FontType = " Times New Roman";
    static String[] myFontsType = {" Algerian",	" Arial",	" Arial Black",	" Arial Bold",	" Arial Bold Italic",	" Arial Italic",	" Arial Narrow",	" Arial Narrow Bold",	" Arial Narrow Bold Italic",	" Arial Narrow Italic",	" Arial Unicode MS",	" Bahnschrift",	" Dialog.plain",	" Dialog.plain",	" Dialog.plain",	" Dialog.plain",	" Dialog.plain",	" Dialog.plain",	" Dialog.plain",	" Dialog.plain",	" Dialog.plain",	" Dialog.plain",	" Dialog.plain",	" Dialog.plain",	" Dialog.plain",	" Dialog.plain",	" Dialog.plain",	" Baskerville Old Face",	" Bauhaus 93",	" Bell MT",	" Bell MT Bold",	" Bell MT Italic",	" Berlin Sans FB",	" Berlin Sans FB Bold",	" Berlin Sans FB Demi Bold",	" Bernard MT Condensed",	" Bodoni MT Poster Compressed",	" Book Antiqua",	" Book Antiqua Bold",	" Book Antiqua Bold Italic",	" Book Antiqua Italic",	" Bookman Old Style",	" Bookman Old Style Bold",	" Bookman Old Style Bold Italic",	" Bookman Old Style Italic",	" Bookshelf Symbol 7",	" Bradley Hand ITC",	" Britannic Bold",	" Broadway",	" Brush Script MT Italic",	" Calibri",	" Calibri Bold",	" Calibri Bold Italic",	" Calibri Italic",	" Calibri Light",	" Calibri Light Italic",	" Californian FB",	" Californian FB Bold",	" Californian FB Italic",	" Cambria",	" Cambria Bold",	" Cambria Bold Italic",	" Cambria Italic",	" Cambria Math",	" Candara",	" Candara Bold",	" Candara Bold Italic",	" Candara Italic",	" Centaur",	" Century",	" Century Gothic",	" Century Gothic Bold",	" Century Gothic Bold Italic",	" Century Gothic Italic",	" Chiller",	" Colonna MT",	" Comic Sans MS",	" Comic Sans MS Bold",	" Comic Sans MS Bold Italic",	" Comic Sans MS Italic",	" Consolas",	" Consolas Bold",	" Consolas Bold Italic",	" Consolas Italic",	" Constantia",	" Constantia Bold",	" Constantia Bold Italic",	" Constantia Italic",	" Cooper Black",	" Corbel",	" Corbel Bold",	" Corbel Bold Italic",	" Corbel Italic",	" Courier New",	" Courier New Bold",	" Courier New Bold Italic",	" Courier New Italic",	" Dialog.bold",	" Dialog.bolditalic",	" Dialog.italic",	" Dialog.plain",	" DialogInput.bold",	" DialogInput.bolditalic",	" DialogInput.italic",	" DialogInput.plain",	" Ebrima",	" Ebrima Bold",	" Footlight MT Light",	" Franklin Gothic Medium",	" Franklin Gothic Medium Italic",	" Freestyle Script",	" French Script MT",	" Gabriola",	" Gadugi",	" Gadugi Bold",	" Garamond",	" Garamond Bold",	" Garamond Italic",	" Georgia",	" Georgia Bold",	" Georgia Bold Italic",	" Georgia Italic",	" HP Simplified",	" HP Simplified Bold",	" HP Simplified Bold Italic",	" HP Simplified Italic",	" HP Simplified Light",	" HP Simplified Light Italic",	" Harlow Solid Italic",	" Harrington",	" High Tower Text",	" High Tower Text Italic",	" HoloLens MDL2 Assets",	" Impact",	" Informal Roman",	" Ink Free",	" Javanese Text",	" Jokerman",	" Juice ITC",	" Kristen ITC",	" Kunstler Script",	" Leelawadee UI",	" Leelawadee UI Bold",	" Leelawadee UI Semilight",	" Lucida Bright Regular",	" Lucida Bright Demibold",	" Lucida Bright Demibold Italic",	" Lucida Bright Italic",	" Lucida Bright Regular",	" Lucida Calligraphy Italic",	" Lucida Console",	" Lucida Fax Demibold",	" Lucida Fax Demibold Italic",	" Lucida Fax Italic",	" Lucida Fax Regular",	" Lucida Handwriting Italic",	" Lucida Sans Demibold",	" Lucida Sans Regular",	" Lucida Sans Typewriter Bold",	" Lucida Sans Typewriter Regular",	" Lucida Sans Unicode",	" MS Gothic",	" MS PGothic",	" MS Reference Sans Serif",	" MS Reference Specialty",	" MS UI Gothic",	" MT Extra",	" MV Boli",	" Magneto Bold",	" Malgun Gothic",	" Malgun Gothic Bold",	" Malgun Gothic Semilight",	" Marlett",	" Matura MT Script Capitals",	" Microsoft Himalaya",	" Microsoft JhengHei",	" Microsoft JhengHei Bold",	" Microsoft JhengHei Light",	" Microsoft JhengHei UI",	" Microsoft JhengHei UI Bold",	" Microsoft JhengHei UI Light",	" Microsoft New Tai Lue",	" Microsoft New Tai Lue Bold",	" Microsoft PhagsPa",	" Microsoft PhagsPa Bold",	" Microsoft Sans Serif",	" Microsoft Tai Le",	" Microsoft Tai Le Bold",	" Microsoft YaHei",	" Microsoft YaHei Bold",	" Microsoft YaHei Light",	" Microsoft YaHei UI",	" Microsoft YaHei UI Bold",	" Microsoft YaHei UI Light",	" Microsoft Yi Baiti",	" MingLiU-ExtB",	" MingLiU_HKSCS-ExtB",	" Mistral",	" Modern No. 20",	" Mongolian Baiti",	" Monospaced.bold",	" Monospaced.bolditalic",	" Monospaced.italic",	" Monospaced.plain",	" Monotype Corsiva",	" Myanmar Text",	" Myanmar Text Bold",	" NSimSun",	" Niagara Engraved",	" Niagara Solid",	" Nirmala UI",	" Nirmala UI Bold",	" Nirmala UI Semilight",	" Old English Text MT",	" Onyx",	" PMingLiU-ExtB",	" Palatino Linotype",	" Palatino Linotype Bold",	" Palatino Linotype Bold Italic",	" Palatino Linotype Italic",	" Papyrus",	" Parchment",	" Playbill",	" Poor Richard",	" Pristina",	" Ravie",	" SansSerif.bold",	" SansSerif.bolditalic",	" SansSerif.italic",	" SansSerif.plain",	" Segoe MDL2 Assets",	" Segoe Print",	" Segoe Print Bold",	" Segoe Script",	" Segoe Script Bold",	" Segoe UI",	" Segoe UI Black",	" Segoe UI Black Italic",	" Segoe UI Bold",	" Segoe UI Bold Italic",	" Segoe UI Emoji",	" Segoe UI Historic",	" Segoe UI Italic",	" Segoe UI Light",	" Segoe UI Light Italic",	" Segoe UI Semibold",	" Segoe UI Semibold Italic",	" Segoe UI Semilight",	" Segoe UI Semilight Italic",	" Segoe UI Symbol",	" Serif.bold",	" Serif.bolditalic",	" Serif.italic",	" Serif.plain",	" Showcard Gothic",	" SimSun",	" SimSun-ExtB",	" Sitka Banner",	" Sitka Banner Bold",	" Sitka Banner Bold Italic",	" Sitka Banner Italic",	" Sitka Display",	" Sitka Display Bold",	" Sitka Display Bold Italic",	" Sitka Display Italic",	" Sitka Heading",	" Sitka Heading Bold",	" Sitka Heading Bold Italic",	" Sitka Heading Italic",	" Sitka Small",	" Sitka Small Bold",	" Sitka Small Bold Italic",	" Sitka Small Italic",	" Sitka Subheading",	" Sitka Subheading Bold",	" Sitka Subheading Bold Italic",	" Sitka Subheading Italic",	" Sitka Text",	" Sitka Text Bold",	" Sitka Text Bold Italic",	" Sitka Text Italic",	" Snap ITC",	" Stencil",	" Sylfaen",	" Symbol",	" Tahoma",	" Tahoma Bold",	" Tempus Sans ITC",	" Times New Roman",	" Times New Roman Bold",	" Times New Roman Bold Italic",	" Times New Roman Italic",	" Trebuchet MS",	" Trebuchet MS Bold",	" Trebuchet MS Bold Italic",	" Trebuchet MS Italic",	" Verdana",	" Verdana Bold",	" Verdana Bold Italic",	" Verdana Italic",	" Viner Hand ITC",	" Vivaldi Italic",	" Vladimir Script",	" Webdings",	" Wide Latin",	" Wingdings",	" Wingdings 2",	" Wingdings 3",	" Yu Gothic Bold",	" Yu Gothic Light",	" Yu Gothic Medium",	" Yu Gothic Regular",	" Yu Gothic UI Bold",	" Yu Gothic UI Light",	" Yu Gothic UI Regular",	" Yu Gothic UI Semibold",	" Yu Gothic UI Semilight"};
    static int myFontSize = 14;
    
    public static void setFontType(String setFont) {  
    	System.out.println("setFont TYpe");
    	FontType = setFont;       	
    }
    
    public static String getFontType() {  
    	return FontType;    	
    }
    
    public static int setFontSize(int FontSize) {    	
    	return FontSize;
    }
    
    public static int getFontSize() {
    	return myFontSize;
    }
    
    
    public static void setMyStyle(JComponent arg) {//Create the size and style of the text.
        arg.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        arg.setFont(new Font(GUI_Frame.getFontType(), Font.PLAIN, GUI_Frame.getFontSize()));        
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
		
		

		Name_Panel.setMinimumSize(new Dimension(90, 0));
		Name_Panel.setPreferredSize(new Dimension(130, 0));
		Name_Panel.setBorder(BorderFactory.createTitledBorder("Coverage"));
		
		
		JSplitPane TopLevelSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, Name_Panel, Option_Panel);
		TopLevelSplitPane.setMaximumSize(new Dimension(100, 100));
		TopLevelSplitPane.setDividerLocation(100);

		Option_Panel.setMinimumSize(new Dimension(90, 0));
		//Option_Panel.setPreferredSize(new Dimension(130, 0));
		Option_Panel.setBorder(BorderFactory.createTitledBorder("Option"));

		for (int i = 0; i < reg.length; i++) {// Retrieve and populate the coverage name panels.
			name[i] = new JLabel(reg[i].getName());
			
			
			// This is one of the few - if not only coverage-type items to
			// have more than one name.
			if ("Age of Dwelling".equals(reg[i].getName())) {// Age of Dwelling is the actual coverage, Current Year
																// subtract Year Built.
				name[i].setText("Year Built");// Year built is the input, also Current Year by default.
			}
			
			
			setMyStyle(name[i]);
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
				GUI_Frame.setMyStyle(box);
				Option_Panel.add(box);// Add the JComboBox to the menu.
				comboListener(reg[i], box);// Call the JComboBox listener.
			}

			if (reg[i].isSpinnerList()) {//Spinners that require an index fall into this list.  Coverage A, Plan and Base Rate generally. 
				SpinnerListModelIndexing list = new SpinnerListModelIndexing(reg[i]);// Populate the SpinnerIndex with all the options from the
																// corresponding Coverage class.
				
				
				
				
				list.setValue(reg[i].getOption());// Set the starting value to the coverage default.
				JSpinnerNumberField spin = new JSpinnerNumberField(list);// Wrap SpinnerIndex with JSpinner().
				GUI_Frame.setMyStyle(spin); // Format output.
				Option_Panel.add(spin);// Add the list to the menu.
				indexingSpinnerListener(reg[i], list);// Call the IndexSpinner listener.

			}
			
			

			if (reg[i].isSpinnerNumber()) {
				SpinnerNumberModel spinNumber = new SpinnerNumberModel(reg[i].getBase(), reg[i].getMin(), reg[i].getMax(), reg[i].getStep());
				
				
				
				JSpinnerNumberField spin2 = new JSpinnerNumberField(spinNumber);
				GUI_Frame.setMyStyle(spin2);
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
