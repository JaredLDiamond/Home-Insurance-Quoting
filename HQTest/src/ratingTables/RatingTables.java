package ratingTables;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import coverages.CovSuper;
import hqtest.GUI_MenuBar;

public class RatingTables {
	private JFrame frame = new JFrame("Rating Tables");

	private JTabbedPane jtp = new JTabbedPane();
	
	
	
	private static CovSuper[] reg	= coverages.CoverageRegistration.getCovs();
	public RatingTables() {
		frame.setSize(300, 400);
		frame.setVisible(true);
	
		JTable values = new JTable();		
		for(int i =0; i < reg.length; i++) {	
			try {
			if(reg[i].getCostValues() != null) {	
				values.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);				
				values = new JTable(reg[i].getCostValues(), reg[i].getOptionList());				
				jtp.addTab(reg[i].getName(), new JScrollPane(values));
			}
			}catch(Exception e) {
				System.out.println(reg[i].getName() + " Null");
			}
			
			
			frame.add(jtp);
			
		}
		
		frame.addWindowListener(new WindowAdapter()
	    {
	        @Override
	        public void windowClosing(WindowEvent e)
	        {
	        	GUI_MenuBar.resetRatingTables();	           
	            e.getWindow().dispose();
	        }
	    });
	}
	
	
}
	
	
	
	
	


