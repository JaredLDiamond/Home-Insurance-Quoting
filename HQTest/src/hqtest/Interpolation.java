package hqtest;

public interface Interpolation {
	public double Base();
	public void interpolatePoints(double lesser, double greater, double opts);
	
	public void setInterpolatedOption(double value);
	
	public void setInterpolatedFactor(double value);
	
	public double[] getNumericOptionList();
	
	
	
	/*Method of Interpolation
	 Example: A premium is desired for a policy amount of $164000 which falls between $160000 and $170000.  The desired amount is $4000 above $160000.
	 
	 
	 Policy Amount Shown             Premium Shown
	 _____________________________________________________________	
	 $170,000                        $561
	 $160,000                        $532
	 _____________________________________________________________
	 Difference
	 _____________________________________________________________
	 $10,000                         $29 
	 
	 
	 ($4,000(The additional amount)/$10,000(Difference amount)) * ($29 Difference Premium = $12) 
	 
	 $532 - Premium for $160,000
	 $12  - Premium for the additional $4,000
	 ------
	 $544 - Interpolated Premium;
	 
	 */
	
}
