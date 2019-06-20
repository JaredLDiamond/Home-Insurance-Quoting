package hqtest;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class GUI_Frame {  
	
    private static JFrame topLevelApplicationFrame;    
    private static final GUI_Control control = new GUI_Control();    
    private static final GUI_Display display = new GUI_Display();  
    private static final GUI_Message myMessage = new GUI_Message();
    private static final GUI_MenuBar menuBar = new GUI_MenuBar();
    
    public GUI_Frame() {
    	//setFont(100);
    }
    
            
    public static void setGlobalLookAndFeel(int LookAndFeelIndex){
    	try {
        	switch (LookAndFeelIndex) {
            case 0:
            	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                SwingUtilities.updateComponentTreeUI(topLevelApplicationFrame);      
                break;
            case 1:            	
            	UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                SwingUtilities.updateComponentTreeUI(topLevelApplicationFrame);  
                break;
            case 2:
            	UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            	SwingUtilities.updateComponentTreeUI(topLevelApplicationFrame);            	
            	break;
            default:
            	try {
            	    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            	    	if ("Nimbus".equals(info.getName())) {
            	            UIManager.setLookAndFeel(info.getClassName());
            	            SwingUtilities.updateComponentTreeUI(topLevelApplicationFrame);    
            	            break;
            	        }
            	    }
            	} catch (Exception e) {
            	    // If Nimbus is not available, you can set the GUI to another look and feel.
            	}           
        }
            
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        }
    }
    
    
    private void gridFramework() {   //Creates the main topLevelApplicationFrame of 1 thin vertical panel, and 1 large rectangle panel for the remainder. 
    	
        topLevelApplicationFrame = new JFrame();
        
        topLevelApplicationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        topLevelApplicationFrame.setTitle("HQTest SEL IL");
        
        topLevelApplicationFrame.setJMenuBar(menuBar.getMenuBar()); //Add the menu bar to the topLevelApplicationFrame.
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//Get the size of the monitor
        
        topLevelApplicationFrame.setSize(screenSize);//set the topLevelApplicationFrame to the full monitors size.        
        JSplitPane Top_Level_Split_Pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, optionControlPanel(), optionDisplaylPanel());//Set a split pane between the two separate sections.        
                                                                    //output Pane contains three different output panels returned form GUI_Control.   
        
        topLevelApplicationFrame.add(Top_Level_Split_Pane);          
        topLevelApplicationFrame.setVisible(true); 
           
        
    }
    
    
    
    
    
    
    
   
    static String FontType = " Times New Roman";
    static String[] myFontsType = {" Algerian",	" Arial",	" Arial Black",	" Arial Bold",	" Arial Bold Italic",	" Arial Italic",	" Arial Narrow",	" Arial Narrow Bold",	" Arial Narrow Bold Italic",	" Arial Narrow Italic",	" Arial Unicode MS",	" Bahnschrift",	" Dialog.plain",	" Dialog.plain",	" Dialog.plain",	" Dialog.plain",	" Dialog.plain",	" Dialog.plain",	" Dialog.plain",	" Dialog.plain",	" Dialog.plain",	" Dialog.plain",	" Dialog.plain",	" Dialog.plain",	" Dialog.plain",	" Dialog.plain",	" Dialog.plain",	" Baskerville Old Face",	" Bauhaus 93",	" Bell MT",	" Bell MT Bold",	" Bell MT Italic",	" Berlin Sans FB",	" Berlin Sans FB Bold",	" Berlin Sans FB Demi Bold",	" Bernard MT Condensed",	" Bodoni MT Poster Compressed",	" Book Antiqua",	" Book Antiqua Bold",	" Book Antiqua Bold Italic",	" Book Antiqua Italic",	" Bookman Old Style",	" Bookman Old Style Bold",	" Bookman Old Style Bold Italic",	" Bookman Old Style Italic",	" Bookshelf Symbol 7",	" Bradley Hand ITC",	" Britannic Bold",	" Broadway",	" Brush Script MT Italic",	" Calibri",	" Calibri Bold",	" Calibri Bold Italic",	" Calibri Italic",	" Calibri Light",	" Calibri Light Italic",	" Californian FB",	" Californian FB Bold",	" Californian FB Italic",	" Cambria",	" Cambria Bold",	" Cambria Bold Italic",	" Cambria Italic",	" Cambria Math",	" Candara",	" Candara Bold",	" Candara Bold Italic",	" Candara Italic",	" Centaur",	" Century",	" Century Gothic",	" Century Gothic Bold",	" Century Gothic Bold Italic",	" Century Gothic Italic",	" Chiller",	" Colonna MT",	" Comic Sans MS",	" Comic Sans MS Bold",	" Comic Sans MS Bold Italic",	" Comic Sans MS Italic",	" Consolas",	" Consolas Bold",	" Consolas Bold Italic",	" Consolas Italic",	" Constantia",	" Constantia Bold",	" Constantia Bold Italic",	" Constantia Italic",	" Cooper Black",	" Corbel",	" Corbel Bold",	" Corbel Bold Italic",	" Corbel Italic",	" Courier New",	" Courier New Bold",	" Courier New Bold Italic",	" Courier New Italic",	" Dialog.bold",	" Dialog.bolditalic",	" Dialog.italic",	" Dialog.plain",	" DialogInput.bold",	" DialogInput.bolditalic",	" DialogInput.italic",	" DialogInput.plain",	" Ebrima",	" Ebrima Bold",	" Footlight MT Light",	" Franklin Gothic Medium",	" Franklin Gothic Medium Italic",	" Freestyle Script",	" French Script MT",	" Gabriola",	" Gadugi",	" Gadugi Bold",	" Garamond",	" Garamond Bold",	" Garamond Italic",	" Georgia",	" Georgia Bold",	" Georgia Bold Italic",	" Georgia Italic",	" HP Simplified",	" HP Simplified Bold",	" HP Simplified Bold Italic",	" HP Simplified Italic",	" HP Simplified Light",	" HP Simplified Light Italic",	" Harlow Solid Italic",	" Harrington",	" High Tower Text",	" High Tower Text Italic",	" HoloLens MDL2 Assets",	" Impact",	" Informal Roman",	" Ink Free",	" Javanese Text",	" Jokerman",	" Juice ITC",	" Kristen ITC",	" Kunstler Script",	" Leelawadee UI",	" Leelawadee UI Bold",	" Leelawadee UI Semilight",	" Lucida Bright Regular",	" Lucida Bright Demibold",	" Lucida Bright Demibold Italic",	" Lucida Bright Italic",	" Lucida Bright Regular",	" Lucida Calligraphy Italic",	" Lucida Console",	" Lucida Fax Demibold",	" Lucida Fax Demibold Italic",	" Lucida Fax Italic",	" Lucida Fax Regular",	" Lucida Handwriting Italic",	" Lucida Sans Demibold",	" Lucida Sans Regular",	" Lucida Sans Typewriter Bold",	" Lucida Sans Typewriter Regular",	" Lucida Sans Unicode",	" MS Gothic",	" MS PGothic",	" MS Reference Sans Serif",	" MS Reference Specialty",	" MS UI Gothic",	" MT Extra",	" MV Boli",	" Magneto Bold",	" Malgun Gothic",	" Malgun Gothic Bold",	" Malgun Gothic Semilight",	" Marlett",	" Matura MT Script Capitals",	" Microsoft Himalaya",	" Microsoft JhengHei",	" Microsoft JhengHei Bold",	" Microsoft JhengHei Light",	" Microsoft JhengHei UI",	" Microsoft JhengHei UI Bold",	" Microsoft JhengHei UI Light",	" Microsoft New Tai Lue",	" Microsoft New Tai Lue Bold",	" Microsoft PhagsPa",	" Microsoft PhagsPa Bold",	" Microsoft Sans Serif",	" Microsoft Tai Le",	" Microsoft Tai Le Bold",	" Microsoft YaHei",	" Microsoft YaHei Bold",	" Microsoft YaHei Light",	" Microsoft YaHei UI",	" Microsoft YaHei UI Bold",	" Microsoft YaHei UI Light",	" Microsoft Yi Baiti",	" MingLiU-ExtB",	" MingLiU_HKSCS-ExtB",	" Mistral",	" Modern No. 20",	" Mongolian Baiti",	" Monospaced.bold",	" Monospaced.bolditalic",	" Monospaced.italic",	" Monospaced.plain",	" Monotype Corsiva",	" Myanmar Text",	" Myanmar Text Bold",	" NSimSun",	" Niagara Engraved",	" Niagara Solid",	" Nirmala UI",	" Nirmala UI Bold",	" Nirmala UI Semilight",	" Old English Text MT",	" Onyx",	" PMingLiU-ExtB",	" Palatino Linotype",	" Palatino Linotype Bold",	" Palatino Linotype Bold Italic",	" Palatino Linotype Italic",	" Papyrus",	" Parchment",	" Playbill",	" Poor Richard",	" Pristina",	" Ravie",	" SansSerif.bold",	" SansSerif.bolditalic",	" SansSerif.italic",	" SansSerif.plain",	" Segoe MDL2 Assets",	" Segoe Print",	" Segoe Print Bold",	" Segoe Script",	" Segoe Script Bold",	" Segoe UI",	" Segoe UI Black",	" Segoe UI Black Italic",	" Segoe UI Bold",	" Segoe UI Bold Italic",	" Segoe UI Emoji",	" Segoe UI Historic",	" Segoe UI Italic",	" Segoe UI Light",	" Segoe UI Light Italic",	" Segoe UI Semibold",	" Segoe UI Semibold Italic",	" Segoe UI Semilight",	" Segoe UI Semilight Italic",	" Segoe UI Symbol",	" Serif.bold",	" Serif.bolditalic",	" Serif.italic",	" Serif.plain",	" Showcard Gothic",	" SimSun",	" SimSun-ExtB",	" Sitka Banner",	" Sitka Banner Bold",	" Sitka Banner Bold Italic",	" Sitka Banner Italic",	" Sitka Display",	" Sitka Display Bold",	" Sitka Display Bold Italic",	" Sitka Display Italic",	" Sitka Heading",	" Sitka Heading Bold",	" Sitka Heading Bold Italic",	" Sitka Heading Italic",	" Sitka Small",	" Sitka Small Bold",	" Sitka Small Bold Italic",	" Sitka Small Italic",	" Sitka Subheading",	" Sitka Subheading Bold",	" Sitka Subheading Bold Italic",	" Sitka Subheading Italic",	" Sitka Text",	" Sitka Text Bold",	" Sitka Text Bold Italic",	" Sitka Text Italic",	" Snap ITC",	" Stencil",	" Sylfaen",	" Symbol",	" Tahoma",	" Tahoma Bold",	" Tempus Sans ITC",	" Times New Roman",	" Times New Roman Bold",	" Times New Roman Bold Italic",	" Times New Roman Italic",	" Trebuchet MS",	" Trebuchet MS Bold",	" Trebuchet MS Bold Italic",	" Trebuchet MS Italic",	" Verdana",	" Verdana Bold",	" Verdana Bold Italic",	" Verdana Italic",	" Viner Hand ITC",	" Vivaldi Italic",	" Vladimir Script",	" Webdings",	" Wide Latin",	" Wingdings",	" Wingdings 2",	" Wingdings 3",	" Yu Gothic Bold",	" Yu Gothic Light",	" Yu Gothic Medium",	" Yu Gothic Regular",	" Yu Gothic UI Bold",	" Yu Gothic UI Light",	" Yu Gothic UI Regular",	" Yu Gothic UI Semibold",	" Yu Gothic UI Semilight"};
    static int myFontSize = 14;
    
    public static void setFontType(String setFont) {  
    	System.out.println("setFont TYpe");
    	FontType = setFont;       	
    }
    
    public static String getFontType() {    
    	System.out.println("getFont TYpe");
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public JScrollPane optionControlPanel(){
        JPanel panel = new JPanel();               
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));     
        panel.add(control.getOption());        
        JScrollPane pane = new JScrollPane(panel, 
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
        JViewport jv1 = new JViewport();     
        JLabel panelName = new JLabel("Options");        
        setMyStyle(panelName);        
        jv1.setView(panelName);        
        pane.setColumnHeader(jv1);
        return pane;
    }
    
    
    public JPanel optionDisplaylPanel(){
        JPanel Local_Combined_Option_Display_Panel = new JPanel(new BorderLayout());   
        JSplitPane Local_Option_And_Fact_Prem_Pane;
        JSplitPane Top_Level_Split_Pane;
        JSplitPane Local_Combined_Display_And_Message_Pane;
        
        Local_Option_And_Fact_Prem_Pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, discountAndSurchargePanel(), additionalPremiumsPanel());                 
        Top_Level_Split_Pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, mainCoverageDisplayPanel(), Local_Option_And_Fact_Prem_Pane); 
       
       
        Local_Combined_Display_And_Message_Pane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, Top_Level_Split_Pane,messagePanel());        
        Local_Combined_Option_Display_Panel.add(Local_Combined_Display_And_Message_Pane); 

        return Local_Combined_Option_Display_Panel;
    }
    
    public JScrollPane mainCoverageDisplayPanel(){
        JPanel panel = new JPanel();        
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));          
        panel.add(display.getPremiumPanel());//Sets the actual content       
        JScrollPane pane = new JScrollPane(panel, 
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);  
        
        JViewport jv1 = new JViewport();        
        JLabel panelName = new JLabel("Premiums");//panel name
        setMyStyle(panelName);
        
        jv1.setView(panelName); 
        pane.setColumnHeader(jv1);
        return pane;        
    }
    
    private JScrollPane discountAndSurchargePanel(){
        JPanel panel = new JPanel();  
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        panel.add(display.getDiscountSurchargePanel());//Sets the actual content        
        JScrollPane pane = new JScrollPane(panel, 
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);   
        
        JViewport jv1 = new JViewport();        
        JLabel panelName = new JLabel("Discount/Surcharges");
        setMyStyle(panelName);
        jv1.setView(panelName);
        pane.setColumnHeader(jv1);
        return pane; 
    }
    
    private JScrollPane additionalPremiumsPanel(){
        JPanel panel = new JPanel();              
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));  
        
        
        panel.add(display.getAdditionalPremiumPanel());//Sets the actual content        
        JScrollPane pane = new JScrollPane(panel, 
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
        
        JViewport jv1 = new JViewport();        
        JLabel panelName = new JLabel("Additional Premiums");
        setMyStyle(panelName);
        jv1.setView(panelName);
        pane.setColumnHeader(jv1);
        return pane; 
    }
    
    public JScrollPane messagePanel(){   
        JScrollPane pane = new JScrollPane(myMessage.getMessages(), 
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
        
        JViewport jv1 = new JViewport();        
        JLabel panelName = new JLabel("Messages");
        setMyStyle(panelName);
        jv1.setView(panelName);
        pane.setColumnHeader(jv1);
        return pane; 
    }   
    
    public void GUI()
    {
        gridFramework();
    }


}
