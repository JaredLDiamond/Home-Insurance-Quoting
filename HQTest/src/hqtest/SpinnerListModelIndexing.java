package hqtest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.SpinnerListModel;

import coverages.CovSuper;

public class SpinnerListModelIndexing extends SpinnerListModel{
	private static final long serialVersionUID = 1L;
	private List<String> Coverage_Option_List;
	private int index = 0;
	private final CovSuper cs;	
	
	public SpinnerListModelIndexing(CovSuper cs) {
		this.Coverage_Option_List = new ArrayList<String>(Arrays.asList(cs.getOptionList()));
		this.setList(Coverage_Option_List);
		this.cs = cs;
	}	
	
	 @Override
	public Object getNextValue()
	  {
	    // Check for a next value.
	    if (index < (Coverage_Option_List.size() - 1))
	      // Return the element at the next index.
	      return Coverage_Option_List.get(index + 1);
	    else
	      // Return null as this is the end of the list.
	      return null;
	    }
	
	  
	  @Override
	public Object getPreviousValue()
	  {
	    // Check for a previous value.
	    if (index > 0)
	      // Return the element at the previous position.
	      return Coverage_Option_List.get(index - 1);
	        else
	      // Return null as this is the start of the list.
	      return null;
	    }
	
	
	@Override
    public Object getValue() {
      return Coverage_Option_List.get(index);
    }    

	
	
	
	@Override
    public void setValue(Object value) {
        int valueIndex;  
        
        // Search for the value in the Coverage_Option_List.
        valueIndex = Coverage_Option_List.indexOf(value);

        // Check for the value being found.
        String t = (String) value;   //Values have to be cast to a String from object....
        
        double Custom_Option_Point = Double.parseDouble(t);//Then cast to a double.  Need to fix this design...
        
        //double Custom_Option_Point = Double.parseDouble((String) value); This is more compact, but less readable.
        
        if (valueIndex == -1) {     
            int Maximum_List_Size = Coverage_Option_List.size() - 1;
            double Lesser_Option_Point = 0;
            double Greater_Option_Point = 0;
            
            try {
                for (int i = 0; i < Coverage_Option_List.size(); i++) {               //1.  Cycle through the Coverage_Option_List of options.  
                    if (cs instanceof Interpolation) {                //2.  Test if each coverage implements Interpolation.                    
                        Lesser_Option_Point = Double.parseDouble(Coverage_Option_List.get(i));     //3.  Assign index position "i" to Lesser_Option_Point.  
                        Greater_Option_Point = Double.parseDouble(Coverage_Option_List.get(i + 1));//4.  Assign "i" plus 1 to Greater_Option_Point.
                        
                        //System.out.println("Greater_Option_Point " + Greater_Option_Point+ " Lesser_Option_Point " + Lesser_Option_Point + " Custom_Option_Point " + Custom_Option_Point);

                        if ((Lesser_Option_Point < Custom_Option_Point) && (Greater_Option_Point > Custom_Option_Point)) {  //If the value is not on this Coverage_Option_List, then it finds the two values that the custom value sits between.
                            Interpolation I = (Interpolation) cs;  
                            I.interpolatePoints(Lesser_Option_Point, Greater_Option_Point, Custom_Option_Point);//Return the value of the previous/next element and the custom option.                            
                            
                            I.setInterpolatedOption(Custom_Option_Point);//Pass the interpolated option in for display.
                        }
                    }
                }
            } 
            
            catch(ClassCastException e){
                //Here in the event that CovSuper (cs) can't be cast to Interpolation (I).
                System.out.println("Interpolation cast failure " + e);
            }
            catch (IndexOutOfBoundsException e) {
                //During interpolation, this will always be thrown, as tabulating "Greater_Option_Point" always adds +1 to the index.                
                Greater_Option_Point = Maximum_List_Size;
                //System.out.println("IndexOutOfBoundsException " + e);
            }   catch(Exception e){
                
            }         
            throw new IllegalArgumentException("The supplied value does not "
                    + "exist in this Coverage_Option_List");
            
        }

        // Make the indices match.
        index = valueIndex;

        // Notify the listeners.
        fireStateChanged();
    }

    public int getSelectedIndex() {
        return index;
    }
}


