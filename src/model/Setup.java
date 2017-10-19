package model;

public class Setup
{
	private Repeatstate repstate = Repeatstate.REPEATLOOPOFF;
	
	public enum Repeatstate
	{
		LISTLOOPON,
		REPEATTRACK,
		REPEATLOOPOFF
	}
	
	
// ---------------------------------------------------
	public void setRepstate(Repeatstate repstate)
	{
		this.repstate = repstate;
	}
	public Repeatstate getRepstate()
	{
		return repstate;
	}
	
// ---------------------------------------------------
}
