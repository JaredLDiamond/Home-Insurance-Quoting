package ratingTables;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import coverages.CovSuper;

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
			}catch(Exception e) {System.out.println(reg[i].getName() + " Null");}
			
			
			frame.add(jtp);
			
		}	
	}
}
	
	
	
	
	


