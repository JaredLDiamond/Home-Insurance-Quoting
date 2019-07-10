package hqtest;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Observable;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.KeyStroke;
import javax.swing.ToolTipManager;

import coverages.CovSuper;
import coverages.CoverageRegistration;


public class GUI_MenuBar extends Observable{
	
	
	
	private final CovSuper[] reg = CoverageRegistration.getCovs();// Contains all coverage values.
    private GUI_Display display = new GUI_Display();
   
    
    private static boolean checkActiveCoverages = false;
    private static boolean checkCoverageDescriptions = false;
	
    public GUI_MenuBar() {
		addObserver(display);		
	}

	
	
	private void changeData(Object data) {
		setChanged(); // the two methods of Observable class
		notifyObservers(data);		
	}
    
 
    
    
    public JMenuBar getMenuBar(){
        JMenuBar menuBar = new JMenuBar();        
        menuBar.add(menuFile());
        menuBar.add(menuView());     
        menuBar.add(menuHelp());
        //menuBar.add(menuFont());     
        return menuBar;
    }
    

    
    
	
	
    
    
 

    
    public JMenu menuView() {
    	JMenu menuView = new JMenu("Views");
    	menuView.add(LookAndFeel());
    	//menuView.add(menuFont());
    	//menuView.add(ratingTables());
    	menuView.add(activeCoverages());    	
    	return menuView;
    }
    
    public JMenu menuFile(){
        JMenu menuFile, submenu;
        menuFile = new JMenu("File");
        menuFile.setMnemonic(KeyEvent.VK_A);        
        JMenuItem menuItem;        
        menuFile.addSeparator();
        JCheckBoxMenuItem cbMenuItem = new JCheckBoxMenuItem("A check box menu item");
        cbMenuItem.setMnemonic(KeyEvent.VK_C);
        menuFile.add(cbMenuItem);
        cbMenuItem = new JCheckBoxMenuItem("Another one");
        cbMenuItem.setMnemonic(KeyEvent.VK_H);
        menuFile.add(cbMenuItem);
        //a submenu
        menuFile.addSeparator();
        submenu = new JMenu("A submenu");
        submenu.setMnemonic(KeyEvent.VK_S);

        menuItem = new JMenuItem("An item in the submenu");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_2, ActionEvent.ALT_MASK));
        submenu.add(menuItem);

        menuItem = new JMenuItem("Another item");
        submenu.add(menuItem);
        menuFile.add(submenu);
        return menuFile;
    }
    
    
    
    
    
    
    
    
    
    
    
    // ---------------------------- Change Look and Feel -------------------- 
    
    
    private void L_F_Listener(final JRadioButton jrb) {
        class myListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                {
                    if("Windows Look and Feel".equals(e.getActionCommand())){                           
                        GUI_Frame.setGlobalLookAndFeel(0);
                    }
                    if("Default Look and Feel".equals(e.getActionCommand())){                           
                        GUI_Frame.setGlobalLookAndFeel(1);
                        }
                    if("Motif Look and Feel".equals(e.getActionCommand())){                    
                        GUI_Frame.setGlobalLookAndFeel(2);
                    }
                    if("Nimbus Look and Feel".equals(e.getActionCommand())){                    	
                            GUI_Frame.setGlobalLookAndFeel(3);                            
                    }
                }
            }
        }
        jrb.addActionListener(new myListener());
    }	
    
    
    public JMenu LookAndFeel(){//View options
        JMenu menuView = new JMenu("Look And Feel");
        JRadioButton Windows_Look_And_Feel = new JRadioButton("Windows Look and Feel");
        JRadioButton Metal_Look_And_Feel = new JRadioButton("Default Look and Feel");
        JRadioButton Motif_Look_And_Feel = new JRadioButton("Motif Look and Feel");
        JRadioButton Nimbus_Look_And_Feel = new JRadioButton("Nimbus Look and Feel");
        
        ButtonGroup Look_And_Feel_Options = new ButtonGroup();
        Look_And_Feel_Options.add(Windows_Look_And_Feel);
        Look_And_Feel_Options.add(Metal_Look_And_Feel);
        Look_And_Feel_Options.add(Motif_Look_And_Feel);
        Look_And_Feel_Options.add(Nimbus_Look_And_Feel);
        
        JPanel Look_And_Feel_Radio_Group = new JPanel(new GridLayout(0, 1));
        Look_And_Feel_Radio_Group.add(Windows_Look_And_Feel);
        Look_And_Feel_Radio_Group.add(Metal_Look_And_Feel);
        Look_And_Feel_Radio_Group.add(Motif_Look_And_Feel);
        Look_And_Feel_Radio_Group.add(Nimbus_Look_And_Feel);

        menuView.add(Look_And_Feel_Radio_Group);
        L_F_Listener(Windows_Look_And_Feel);
        L_F_Listener(Metal_Look_And_Feel);
        L_F_Listener(Motif_Look_And_Feel);
        L_F_Listener(Nimbus_Look_And_Feel);
        
        return menuView;
    }
    
    
 // ---------------------------- End Change Look and Feel -------------------- 
    
    
    
    
    // ----------------------------- Show Active Coverage's Only ------------------
    
    JCheckBoxMenuItem ActiveCoverages = new JCheckBoxMenuItem("Show Active Options Only");
    
    public JMenu activeCoverages() {
    	JMenu menu = new JMenu("View Options");    	
    	menu.add(ActiveCoverages);     	
    	activeCoveragesOnlyListener(ActiveCoverages);
    	return menu;
    }
    
    public static boolean getActiveOnlyState() {    	
    	return checkActiveCoverages;
    }
    
    private void activeCoveragesOnlyListener(final JCheckBoxMenuItem jb) {
    	class myListener implements ActionListener{
    		@Override
			public void actionPerformed(ActionEvent e) {  
    			checkActiveCoverages = ActiveCoverages.getState();
    			changeData(reg); // Notify Observers.    			
    		}
    	}
    	jb.addActionListener(new myListener());    	
    }
    
 // ----------------------------- End Show Active Coverage's Only ------------------
    
    
    
    
    
    
    
    
    
    
    
    
    //-------------------------------------- Help Option ---------------------
    
    public JMenu menuHelp() {
    	JMenu menuHelp = new JMenu("Help");    	
    	menuHelp.add(CoverageDescriptions);
    	coverageDescriptionsListener(CoverageDescriptions);
    	return menuHelp;
    }
    
    public static boolean getCheckCoverageDescriptions()
    {
    	return checkCoverageDescriptions;
    }
    
    JCheckBoxMenuItem CoverageDescriptions = new JCheckBoxMenuItem("Show popup coverage descriptions");
    
	private void coverageDescriptionsListener(final JCheckBoxMenuItem jb) {
		class myListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				checkCoverageDescriptions = CoverageDescriptions.getState();
				display.coverageDescriptionPopup(checkCoverageDescriptions);
				changeData(reg);
			}
		}
		jb.addActionListener(new myListener());
	}
    
    
	//---------------------------------- End Help Option --------------------------------
    
	
	
	
	
	
	
//  public JMenu ratingTables() {
//	JMenu menu = new JMenu("Rating Tables");
//	JButton button = new JButton("Rating Tables");
//	menu.add(button);    	
//	ratingTablesListener(button);
//	return menu;
//}
//
//private void ratingTablesListener(final JButton jb) {
//	class myListener implements ActionListener{
//		@Override
//		public void actionPerformed(ActionEvent e) {   
//			StringBuilder str = new StringBuilder("Rating Table");
//					new GUI_Message().setMessage(str);
//		}
//	}
//	jb.addActionListener(new myListener());    	
//}
    
	
//	public JPanel menuFont() {
//        JComboBox<String> fonts = new JComboBox<String>(myFonts);  
//        JLabel FontLabel = new JLabel("Fonts");       
//        JPanel FontPanel = new JPanel(new GridLayout(0, 2));
//        FontPanel.setMaximumSize(new Dimension(500, 100));
//        FontPanel.add(FontLabel);
//        FontPanel.add(fonts);
//        fontListener(fonts);
//        return FontPanel;
//	}
	
	
	/*  Incomplete font options
	 * 
	 * 
	private void fontListener(final JComboBox<String> box) {
		//new GUI_Message().setMessage(new StringBuilder("pointer "));
		class myActionListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {	
				int pointer = box.getSelectedIndex();				
				//new GUI_Message().setMessage(new StringBuilder("pointer " + pointer));
				System.out.println("pointer " + pointer);
				new GUI_Frame().setFontType(myFonts[pointer]);;
				changeData(reg);
				
			}
		}
		myActionListener al = new myActionListener();
		box.addActionListener(al);

	}
	
	*/
    
//  public JMenu ratingTables() {
//	JMenu menu = new JMenu("Rating Tables");
//	JButton button = new JButton("Rating Tables");
//	menu.add(button);    	
//	ratingTablesListener(button);
//	return menu;
//}
//
//private void ratingTablesListener(final JButton jb) {
//	class myListener implements ActionListener{
//		@Override
//		public void actionPerformed(ActionEvent e) {   
//			StringBuilder str = new StringBuilder("Rating Table");
//					new GUI_Message().setMessage(str);
//		}
//	}
//	jb.addActionListener(new myListener());    	
//}
}
