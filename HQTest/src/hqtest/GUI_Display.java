package hqtest;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.ToolTipManager;

import coverages.CovSuper;

public class GUI_Display implements Observer {	
	private static JLabel[]		NameLabel;
	private static JLabel[]		OptionLabel;
	private static JLabel[]		FactorLabel;
	private static JLabel[]		PremiumLabel;
	private static JLabel		CoverageTotal;
	private static JLabel		DiscountAndSurchargeTotal;
	private static JLabel		Additional_Premium_Total;
	private static JLabel		Final_Total;

	private JPanel	NamePanel		= new JPanel(new GridLayout(0, 1));
	private JPanel	OptionPanel		= new JPanel(new GridLayout(0, 1));
	private JPanel	FactorPanel		= new JPanel(new GridLayout(0, 1));
	private JPanel	PremiumPanel	= new JPanel(new GridLayout(0, 1));
	private static CovSuper[] reg	= coverages.CoverageRegistration.getCovs();
	private final double[] Check_Premium_Highlighting;						// Gets the PremiumLabels to compare to highlight changes.
	private final double[] Check_Factor_Highlighting;
	
	
	
	public GUI_Display() {// Initializations			
		new Premium_Calculation(reg);// reg Contains all coverage values.  Here it initializes the premium calculation variables as well.
		NameLabel = new JLabel[reg.length];// Initialize NameLabel array.
		
		OptionLabel = new JLabel[reg.length];// Initialize OptionLabel array.
		
		FactorLabel = new JLabel[reg.length];// Initialize FactorLabel array.
		
		PremiumLabel = new JLabel[reg.length];// Initialize PremiumLabel array.

		CoverageTotal = new JLabel("" + Premium_Calculation.getCoveragesTotal());// Display the initial total PremiumLabel.
																					 
		DiscountAndSurchargeTotal = new JLabel("" + Premium_Calculation.getDiscountSurchargeTotal());

		Additional_Premium_Total = new JLabel("" + Premium_Calculation.getAdditionalPremiumTotal());
		Final_Total = new JLabel("" + Premium_Calculation.getFinalTotal());

		// Initialized for highlighting OptionLabel changes.
		Check_Premium_Highlighting = new double[reg.length];
		Check_Factor_Highlighting = new double[reg.length];
		for (int i = 0; i < reg.length; i++) {
			Check_Premium_Highlighting[i] = reg[i].getPremium();// Populating check array with the initial premiums.
			Check_Factor_Highlighting[i] = reg[i].getFactor();// Populating check array with the initial factors.
		}
	}
	
	//If the option is checked in the menu bar, popup descriptions of coverage's appear when the cursor pan's over the name.
	public void coverageDescriptionPopup(boolean bool) {
		for (int i = 0; i < reg.length; i++) {
			if (bool == true) {
				ToolTipManager.sharedInstance().setInitialDelay(1000);
				NameLabel[i].setToolTipText(reg[i].getCoverageDescription());
			}
			else {
				NameLabel[i].setToolTipText(null);
			}
		}
	}	
	
	

	private void showActiveCoverages(int i) {
		// If enabled, only the active coverage's will be visible.
		if (GUI_MenuBar.getActiveOnlyState() == false) {
			NameLabel[i].setVisible(true);
			OptionLabel[i].setVisible(true);
			
			FactorLabel[i].setVisible(true);
			
			PremiumLabel[i].setVisible(true);
		}		

		if (GUI_MenuBar.getActiveOnlyState() == true) {//If this option is active, only coverage's affecting the premium will be displayed.
			if (reg[i].getPremium() == 0) {
				NameLabel[i].setVisible(false);
				OptionLabel[i].setVisible(false);
				FactorLabel[i].setVisible(false);
				PremiumLabel[i].setVisible(false);
			}

			if (reg[i].getPremium() != 0) {
				NameLabel[i].setVisible(true);
				OptionLabel[i].setVisible(true);
				FactorLabel[i].setVisible(true);
				PremiumLabel[i].setVisible(true);
				if (reg[i].getPremium() < 0) {
					PremiumLabel[i].setBackground(Color.GREEN);//Coverage is green if the premium drops.
					FactorLabel[i].setBackground(Color.GREEN);
				} else {
					PremiumLabel[i].setBackground(Color.RED);//Coverage is red if the premium climbs.
					FactorLabel[i].setBackground(Color.RED);
				}
			}
		}

	}

	private void optionChangeHighlighting(int IndexPosition) {
		/*
		 * This code updates and highlights a Factor or Premium (as applicable), if it
		 * has changed since the previous input. If it is already highlighted and an
		 * unrelated change occurs, the Factor/Premium is returned to the default color.		 
		 */

		if (reg[IndexPosition].getPremium() != Check_Premium_Highlighting[IndexPosition]) { // Check_Premium_Highlighting was initialized above.  If it is different, the premium is highlighted.
			PremiumLabel[IndexPosition].setOpaque(true);
			PremiumLabel[IndexPosition].setBackground(Color.yellow);
		}
		if (reg[IndexPosition].getPremium() == Check_Premium_Highlighting[IndexPosition]) {
			PremiumLabel[IndexPosition].setBackground(null); // Reset the JLabel color to normal if the premium did not change with
													// the last input.
		}

		if (reg[IndexPosition].getFactor() != Check_Factor_Highlighting[IndexPosition]) {
			FactorLabel[IndexPosition].setOpaque(true);
			FactorLabel[IndexPosition].setBackground(Color.yellow);
		}
		if (reg[IndexPosition].getFactor() == Check_Factor_Highlighting[IndexPosition]) {
			FactorLabel[IndexPosition].setBackground(null); // Reset the JLabel color to normal if the FactorLabel did not
												// change with the last input.
		}

		Check_Premium_Highlighting[IndexPosition] = reg[IndexPosition].getPremium(); // Once completed, reset check for the current values
																// before testing again for PremiumLabel difference.

		Check_Factor_Highlighting[IndexPosition] = reg[IndexPosition].getFactor(); // Once completed, reset check for the current values
															// before testing again for FactorLabel difference.

	}

	

	private JPanel displayPanel(int covType) {
		// In a small program, it would be easier to just hard code these display
		// panels, but for extensibility, I've written them to be dynamically generated.

		int AddTotalsPanel = 0;// Used as a check. When this creates a PremiumLabel panel, then  the final PremiumLabel fields will be added.
									
		int AddFactorPanel = 0;// Used as a check. When the Discount/Surcharge section is created, a "FactorLabel" field will be added.
		

		JPanel TopLevelPanel = new JPanel(new GridLayout(2, 0));
		JPanel topPanel      = new JPanel();
		JPanel bottomPanel   = new JPanel(new GridLayout());
		
		JSplitPane TopLevelSplitPane;
		JSplitPane OptionAndFactorPremiumPane;
		JSplitPane FactorAndPremiumPanelPane;

		NamePanel    = new JPanel(new GridLayout(0, 1));
		OptionPanel  = new JPanel(new GridLayout(0, 1));
		FactorPanel  = new JPanel(new GridLayout(0, 1));
		PremiumPanel = new JPanel(new GridLayout(0, 1));

		NamePanel.setMinimumSize(new Dimension(30, 0));
		NamePanel.setPreferredSize(new Dimension(130, 0));

		OptionPanel.setMinimumSize(new Dimension(30, 0));
		OptionPanel.setPreferredSize(new Dimension(100, 0));

		FactorPanel.setMinimumSize(new Dimension(30, 0));
		FactorPanel.setPreferredSize(new Dimension(100, 0));

		PremiumPanel.setMinimumSize(new Dimension(60, 0));

		NamePanel.setBorder(BorderFactory.createTitledBorder("Coverage"));
		OptionPanel.setBorder(BorderFactory.createTitledBorder("Option"));
		FactorPanel.setBorder(BorderFactory.createTitledBorder("Factor"));
		PremiumPanel.setBorder(BorderFactory.createTitledBorder("Premium"));

		for (int i = 0; i < reg.length; i++) {
			if (reg[i].covType() == covType) {

				AddTotalsPanel = reg[i].covType();// Will only do this when Coverage Type is 0.

				AddFactorPanel = reg[i].covType();// Only occurs in Coverage Type 0 and 1.

				
				//Fill content
				NamePanel.add(NameLabel[i]       = new JLabel(reg[i].getName()));
				OptionPanel.add(OptionLabel[i]   = new JLabel(reg[i].getOption()));
				FactorPanel.add(FactorLabel[i]   = new JLabel("" + reg[i].getFactor()));
				PremiumPanel.add(PremiumLabel[i] = new JLabel("" + reg[i].getPremium()));
				
				
				//Place borders
				NameLabel[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				OptionLabel[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				FactorLabel[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				PremiumLabel[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			}
		}
		

		

		if (AddFactorPanel != 2) {// If this is the Additional Premiums panel, then a FactorLabel field is not added.									
			FactorAndPremiumPanelPane = createPane(FactorPanel, PremiumPanel);
			OptionAndFactorPremiumPane = createPane(OptionPanel, FactorAndPremiumPanelPane);
			TopLevelSplitPane = createPane(NamePanel, OptionAndFactorPremiumPane);

		} else {
			OptionAndFactorPremiumPane = createPane(OptionPanel, PremiumPanel);
			TopLevelSplitPane = createPane(NamePanel, OptionAndFactorPremiumPane);
		}

		topPanel.add(TopLevelSplitPane);
		TopLevelPanel.add(topPanel);

		if (AddTotalsPanel == 0) {// Only add totals on the PremiumLabel panel.

			bottomPanel.add(policyTotalsPanel());// For individual coverage PremiumLabels.
			TopLevelPanel.add(bottomPanel); // For total PremiumLabels.
		}
		return TopLevelPanel;
	}
	
	
	private JSplitPane createPane(JComponent Var1, JComponent Var2) {
		JSplitPane pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, Var1, Var2);
		pane.setOneTouchExpandable(true);
		pane.setVisible(true);
		return pane;
	}

	@Override
	public void update(Observable o, Object data) {		
		reg = (CovSuper[]) data;				
		
		new Premium_Calculation(reg);// Send updated information to the Premium Calculation.

		CoverageTotal.setText("" + Premium_Calculation.getCoveragesTotal());
		DiscountAndSurchargeTotal.setText("" + Premium_Calculation.getDiscountSurchargeTotal());
		Additional_Premium_Total.setText("" + Premium_Calculation.getAdditionalPremiumTotal());
		Final_Total.setText("" + Premium_Calculation.getFinalTotal());

		for (int i = 0; i < reg.length; i++) {
			OptionLabel[i].setText(reg[i].getOption() + "");// Update any changed Options.
			FactorLabel[i].setText(reg[i].getFactor() + "");// If Factor is applicable.
			PremiumLabel[i].setText(reg[i].getPremium() + "");// Updated any changed premiums.	
			
			optionChangeHighlighting(i);
			showActiveCoverages(i);// Show only active premium modifiers.
		}
	}
	

	public JPanel policyTotalsPanel() {
		//Create the Policy Total panel to be added to the bottom of the Premium Panel.
		
		JPanel TopLevelPanel = new JPanel(new GridLayout(3, 0));// Three rows, one column
		JPanel FirstColumn = new JPanel(new GridLayout(5, 0));// Five rows, one column
		JPanel SecondColumn = new JPanel(new GridLayout(5, 0));// Five rows, one column
		JPanel ThirdColumn = new JPanel(new GridLayout(5, 0));// Five rows, one column

		FirstColumn.add(new JLabel("Sub Totals"));
		FirstColumn.add(new JSeparator());
		FirstColumn.add(new JSeparator());
		FirstColumn.add(new JSeparator());
		FirstColumn.add(new JLabel("Company Totals"));

		SecondColumn.add(new JLabel("Premiums"));
		SecondColumn.add(new JLabel("Disc/Surch"));
		SecondColumn.add(new JLabel("Add Prems"));
		SecondColumn.add(new JSeparator());
		SecondColumn.add(new JSeparator());

		ThirdColumn.add(CoverageTotal);
		ThirdColumn.add(DiscountAndSurchargeTotal);
		ThirdColumn.add(Additional_Premium_Total);
		ThirdColumn.add(new JSeparator());
		ThirdColumn.add(Final_Total);

		JSplitPane First_And_SecondColumns = createPane(FirstColumn, SecondColumn);
		JSplitPane AllColumns = createPane(First_And_SecondColumns, ThirdColumn);
		TopLevelPanel.add(AllColumns);

		return TopLevelPanel;// Return the fully assembled totals section.
	}


	public JPanel getPremiumPanel() {
		JPanel panel = displayPanel(0);// 0 is type Coverage
		return panel;
	}

	public JPanel getDiscountSurchargePanel() {
		JPanel panel = displayPanel(1);// 1 is type Discount / Surcharge
		return panel;
	}

	public JPanel getAdditionalPremiumPanel() {
		JPanel panel = displayPanel(2);// 2 is type Additional Premiums
		return panel;
	}

}
