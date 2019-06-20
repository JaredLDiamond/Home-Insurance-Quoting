

package hqtest;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Observable;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.KeyStroke;

import coverages.CovSuper;
import coverages.CoverageRegistration;


public class GUI_MenuBar extends Observable{
	
	
	
	private final CovSuper[] reg = CoverageRegistration.getCovs();// Contains all coverage values.
    private GUI_Display display = new GUI_Display();
   
    
    private static boolean checkActiveCoverages = false;
	
    public GUI_MenuBar() {
		addObserver(display);		
	}

	
	
	private void changeData(Object data) {
		setChanged(); // the two methods of Observable class
		notifyObservers(data);		
	}
    
 
    
    
    public JMenuBar getMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        GUI_Frame.setMyStyle(menuBar);  
        menuBar.add(menuFile());
        menuBar.add(menuView());     
        menuBar.add(menuFont());     
        return menuBar;
    }
    
    public JMenu ratingTables() {
    	JMenu menu = new JMenu("Rating Tables");
    	JButton button = new JButton("Rating Tables");
    	menu.add(button);    	
    	ratingTablesListener(button);
    	return menu;
    }
    
    private void ratingTablesListener(final JButton jb) {
    	class myListener implements ActionListener{
    		@Override
			public void actionPerformed(ActionEvent e) {   
    			StringBuilder str = new StringBuilder("Rating Table");
    					new GUI_Message().setMessage(str);
    		}
    	}
    	jb.addActionListener(new myListener());    	
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
	
	
    
    
 
    
    
	
	public JPanel menuFont() {
        JComboBox fonts = new JComboBox(myFonts);        
        
        
        JLabel FontLabel = new JLabel("Fonts");
       
        JPanel FontPanel = new JPanel(new GridLayout(0, 2));
        FontPanel.setMaximumSize(new Dimension(500, 100));
       
        
        JMenuItem item = new JMenuItem();
        
        
        
        
        FontPanel.add(FontLabel);
        FontPanel.add(fonts);
        
        
        
        
        comboListener(fonts);
        
        
        return FontPanel;
	}
    
	
	
	
	
	
	String[] myFonts = {" Algerian",	" Arial",	" Arial Black",	" Arial Bold",	" Arial Bold Italic",	" Arial Italic",	" Arial Narrow",	" Arial Narrow Bold",	" Arial Narrow Bold Italic",	" Arial Narrow Italic",	" Arial Unicode MS",	" Bahnschrift",	" Dialog.plain",	" Dialog.plain",	" Dialog.plain",	" Dialog.plain",	" Dialog.plain",	" Dialog.plain",	" Dialog.plain",	" Dialog.plain",	" Dialog.plain",	" Dialog.plain",	" Dialog.plain",	" Dialog.plain",	" Dialog.plain",	" Dialog.plain",	" Dialog.plain",	" Baskerville Old Face",	" Bauhaus 93",	" Bell MT",	" Bell MT Bold",	" Bell MT Italic",	" Berlin Sans FB",	" Berlin Sans FB Bold",	" Berlin Sans FB Demi Bold",	" Bernard MT Condensed",	" Bodoni MT Poster Compressed",	" Book Antiqua",	" Book Antiqua Bold",	" Book Antiqua Bold Italic",	" Book Antiqua Italic",	" Bookman Old Style",	" Bookman Old Style Bold",	" Bookman Old Style Bold Italic",	" Bookman Old Style Italic",	" Bookshelf Symbol 7",	" Bradley Hand ITC",	" Britannic Bold",	" Broadway",	" Brush Script MT Italic",	" Calibri",	" Calibri Bold",	" Calibri Bold Italic",	" Calibri Italic",	" Calibri Light",	" Calibri Light Italic",	" Californian FB",	" Californian FB Bold",	" Californian FB Italic",	" Cambria",	" Cambria Bold",	" Cambria Bold Italic",	" Cambria Italic",	" Cambria Math",	" Candara",	" Candara Bold",	" Candara Bold Italic",	" Candara Italic",	" Centaur",	" Century",	" Century Gothic",	" Century Gothic Bold",	" Century Gothic Bold Italic",	" Century Gothic Italic",	" Chiller",	" Colonna MT",	" Comic Sans MS",	" Comic Sans MS Bold",	" Comic Sans MS Bold Italic",	" Comic Sans MS Italic",	" Consolas",	" Consolas Bold",	" Consolas Bold Italic",	" Consolas Italic",	" Constantia",	" Constantia Bold",	" Constantia Bold Italic",	" Constantia Italic",	" Cooper Black",	" Corbel",	" Corbel Bold",	" Corbel Bold Italic",	" Corbel Italic",	" Courier New",	" Courier New Bold",	" Courier New Bold Italic",	" Courier New Italic",	" Dialog.bold",	" Dialog.bolditalic",	" Dialog.italic",	" Dialog.plain",	" DialogInput.bold",	" DialogInput.bolditalic",	" DialogInput.italic",	" DialogInput.plain",	" Ebrima",	" Ebrima Bold",	" Footlight MT Light",	" Franklin Gothic Medium",	" Franklin Gothic Medium Italic",	" Freestyle Script",	" French Script MT",	" Gabriola",	" Gadugi",	" Gadugi Bold",	" Garamond",	" Garamond Bold",	" Garamond Italic",	" Georgia",	" Georgia Bold",	" Georgia Bold Italic",	" Georgia Italic",	" HP Simplified",	" HP Simplified Bold",	" HP Simplified Bold Italic",	" HP Simplified Italic",	" HP Simplified Light",	" HP Simplified Light Italic",	" Harlow Solid Italic",	" Harrington",	" High Tower Text",	" High Tower Text Italic",	" HoloLens MDL2 Assets",	" Impact",	" Informal Roman",	" Ink Free",	" Javanese Text",	" Jokerman",	" Juice ITC",	" Kristen ITC",	" Kunstler Script",	" Leelawadee UI",	" Leelawadee UI Bold",	" Leelawadee UI Semilight",	" Lucida Bright Regular",	" Lucida Bright Demibold",	" Lucida Bright Demibold Italic",	" Lucida Bright Italic",	" Lucida Bright Regular",	" Lucida Calligraphy Italic",	" Lucida Console",	" Lucida Fax Demibold",	" Lucida Fax Demibold Italic",	" Lucida Fax Italic",	" Lucida Fax Regular",	" Lucida Handwriting Italic",	" Lucida Sans Demibold",	" Lucida Sans Regular",	" Lucida Sans Typewriter Bold",	" Lucida Sans Typewriter Regular",	" Lucida Sans Unicode",	" MS Gothic",	" MS PGothic",	" MS Reference Sans Serif",	" MS Reference Specialty",	" MS UI Gothic",	" MT Extra",	" MV Boli",	" Magneto Bold",	" Malgun Gothic",	" Malgun Gothic Bold",	" Malgun Gothic Semilight",	" Marlett",	" Matura MT Script Capitals",	" Microsoft Himalaya",	" Microsoft JhengHei",	" Microsoft JhengHei Bold",	" Microsoft JhengHei Light",	" Microsoft JhengHei UI",	" Microsoft JhengHei UI Bold",	" Microsoft JhengHei UI Light",	" Microsoft New Tai Lue",	" Microsoft New Tai Lue Bold",	" Microsoft PhagsPa",	" Microsoft PhagsPa Bold",	" Microsoft Sans Serif",	" Microsoft Tai Le",	" Microsoft Tai Le Bold",	" Microsoft YaHei",	" Microsoft YaHei Bold",	" Microsoft YaHei Light",	" Microsoft YaHei UI",	" Microsoft YaHei UI Bold",	" Microsoft YaHei UI Light",	" Microsoft Yi Baiti",	" MingLiU-ExtB",	" MingLiU_HKSCS-ExtB",	" Mistral",	" Modern No. 20",	" Mongolian Baiti",	" Monospaced.bold",	" Monospaced.bolditalic",	" Monospaced.italic",	" Monospaced.plain",	" Monotype Corsiva",	" Myanmar Text",	" Myanmar Text Bold",	" NSimSun",	" Niagara Engraved",	" Niagara Solid",	" Nirmala UI",	" Nirmala UI Bold",	" Nirmala UI Semilight",	" Old English Text MT",	" Onyx",	" PMingLiU-ExtB",	" Palatino Linotype",	" Palatino Linotype Bold",	" Palatino Linotype Bold Italic",	" Palatino Linotype Italic",	" Papyrus",	" Parchment",	" Playbill",	" Poor Richard",	" Pristina",	" Ravie",	" SansSerif.bold",	" SansSerif.bolditalic",	" SansSerif.italic",	" SansSerif.plain",	" Segoe MDL2 Assets",	" Segoe Print",	" Segoe Print Bold",	" Segoe Script",	" Segoe Script Bold",	" Segoe UI",	" Segoe UI Black",	" Segoe UI Black Italic",	" Segoe UI Bold",	" Segoe UI Bold Italic",	" Segoe UI Emoji",	" Segoe UI Historic",	" Segoe UI Italic",	" Segoe UI Light",	" Segoe UI Light Italic",	" Segoe UI Semibold",	" Segoe UI Semibold Italic",	" Segoe UI Semilight",	" Segoe UI Semilight Italic",	" Segoe UI Symbol",	" Serif.bold",	" Serif.bolditalic",	" Serif.italic",	" Serif.plain",	" Showcard Gothic",	" SimSun",	" SimSun-ExtB",	" Sitka Banner",	" Sitka Banner Bold",	" Sitka Banner Bold Italic",	" Sitka Banner Italic",	" Sitka Display",	" Sitka Display Bold",	" Sitka Display Bold Italic",	" Sitka Display Italic",	" Sitka Heading",	" Sitka Heading Bold",	" Sitka Heading Bold Italic",	" Sitka Heading Italic",	" Sitka Small",	" Sitka Small Bold",	" Sitka Small Bold Italic",	" Sitka Small Italic",	" Sitka Subheading",	" Sitka Subheading Bold",	" Sitka Subheading Bold Italic",	" Sitka Subheading Italic",	" Sitka Text",	" Sitka Text Bold",	" Sitka Text Bold Italic",	" Sitka Text Italic",	" Snap ITC",	" Stencil",	" Sylfaen",	" Symbol",	" Tahoma",	" Tahoma Bold",	" Tempus Sans ITC",	" Times New Roman",	" Times New Roman Bold",	" Times New Roman Bold Italic",	" Times New Roman Italic",	" Trebuchet MS",	" Trebuchet MS Bold",	" Trebuchet MS Bold Italic",	" Trebuchet MS Italic",	" Verdana",	" Verdana Bold",	" Verdana Bold Italic",	" Verdana Italic",	" Viner Hand ITC",	" Vivaldi Italic",	" Vladimir Script",	" Webdings",	" Wide Latin",	" Wingdings",	" Wingdings 2",	" Wingdings 3",	" Yu Gothic Bold",	" Yu Gothic Light",	" Yu Gothic Medium",	" Yu Gothic Regular",	" Yu Gothic UI Bold",	" Yu Gothic UI Light",	" Yu Gothic UI Regular",	" Yu Gothic UI Semibold",	" Yu Gothic UI Semilight"};
	Integer[] fontSize = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
	
    
	
	
	
	
	
	private void comboListener(final JComboBox<String> box) {
		//new GUI_Message().setMessage(new StringBuilder("pointer "));
		class myActionListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {	
				int pointer = box.getSelectedIndex();				
				//new GUI_Message().setMessage(new StringBuilder("pointer " + pointer));
				new GUI_Frame().setFontType(myFonts[pointer]);;
				changeData(reg);
				
			}
		}
		myActionListener al = new myActionListener();
		box.addActionListener(al);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    
	private void L_F_Listener1(final JRadioButton jrb) {
        class myListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                {
                    if("first".equals(e.getActionCommand())){                           
                        GUI_Frame.setFontType(" Arial");
                        System.out.println("Arial");
                    }
                    if("second".equals(e.getActionCommand())){                           
                        GUI_Frame.setFontType(" Times New Roman");
                        System.out.println("second");
                        }
                    
                }
            }
        }
        jrb.addActionListener(new myListener());
        
    }

    
    
    
  
    
    
    
    
    
    
    
    
    
    
    public JMenu menuView() {
    	JMenu menuView = new JMenu("Views");
    	menuView.add(LookAndFeel());
    	menuView.add(menuFont());
    	menuView.add(ratingTables());
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
    
    
    
    
    JCheckBoxMenuItem ActiveCoverages = new JCheckBoxMenuItem("Show Active Options Only");
    
    public JMenu activeCoverages() {
    	JMenu menu = new JMenu("View Options");    	
    	menu.add(ActiveCoverages);     	
    	ActiveCoveragesOnly(ActiveCoverages);
    	return menu;
    }
    
    
    
    
    
    private void ActiveCoveragesOnly(final JCheckBoxMenuItem jb) {
    	class myListener implements ActionListener{
    		@Override
			public void actionPerformed(ActionEvent e) {  
    			checkActiveCoverages = ActiveCoverages.getState();
    			changeData(reg); // Notify Observers.    			
    		}
    	}
    	jb.addActionListener(new myListener());    	
    }
    
    
    
    
    public static boolean getActiveOnlyState() {    	
    	return checkActiveCoverages;
    }
    
    
    
    
    
    
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



	
}
