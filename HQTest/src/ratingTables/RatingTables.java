package ratingTables;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JTabbedPane;
import javax.swing.JTable;

import coverages.CovSuper;

public class RatingTables {
	private JFrame frame = new JFrame("Rating Tables");

	private JTabbedPane jtp = new JTabbedPane();
	private JTable table;
	
	
	private static CovSuper[] reg	= coverages.CoverageRegistration.getCovs();
	public RatingTables()  throws NullPointerException{
		
		frame.setSize(300, 400);
		frame.setVisible(true);
		
		

		
		
		
		
		for(int i =0; i < reg.length; i++) {
			
			
				
		
		}
		
	
		for(int i =0; i < reg.length; i++) {
			if(reg[i].getTable() != null) {
				//System.out.println(reg[i].getName());
				table = reg[i].getTable();
				frame.add(table);
			}
		}
	
	
	
	
	}
	








}
	
	
	
	
	


