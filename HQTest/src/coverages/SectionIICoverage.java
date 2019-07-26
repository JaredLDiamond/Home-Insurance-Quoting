package coverages;

public interface SectionIICoverage {
	public double getMaximumValue();
	public double getMinimumValue();
	public double getBaseValue();
	public double getStepValue();	
	
	public void setOption(Object o);
	public void setMinimumValue(double value);

}
