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
	private static JFrame frame = new JFrame("Rating Tables");

	private static JTabbedPane jtp = new JTabbedPane();

	private static boolean firstRun = true;

	private static CovSuper[] reg = coverages.CoverageRegistration.getCovs();

	public RatingTables() {
		if (firstRun == true) {
			frame.setSize(300, 400);
		}

		frame.setVisible(true);

		JTable values = new JTable();
		for (int i = 0; i < reg.length; i++) {
			try {
				if ((reg[i].getCostValues() != null) && (firstRun == true)) {
					values.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					values = new JTable(reg[i].getCostValues(), reg[i].getOptionList());
					jtp.addTab(reg[i].getName(), new JScrollPane(values));
				}
			} catch (Exception e) {
				System.out.println(reg[i].getName() + " Null");
			}

			frame.add(jtp);

		}
		firstRun = false;
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				GUI_MenuBar.resetRatingTables();
				e.getWindow().dispose();
				// Clear the checkbox when the rating table is closed.
			}
		});
	}

	public static void boxSetClose() {
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
				e.getWindow().dispose();
				System.out.println("close window");
				// Clear the checkbox when the rating table is closed.
			}
		});
		// Close the window when the checkbox is unchecked.
	}

}
