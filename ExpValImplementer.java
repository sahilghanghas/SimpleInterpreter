/*
 * Constructor template for ExpValImplementer is a
 *  new ExpValImplementer(boolean)
 *  or
 *  new ExpValImplementer(long)
 * Interpretation: 
 * 	type is a number indicating whether the value of the expression
 *   is a boolean or a number.
 * 	bValue is the value if the ExpVal is a Boolean
 * 	lValue is the value if the ExpVal is a Number
 */
public class ExpValImplementer implements ExpVal {

	

	/*
	 * type = 0 is a Boolean
	 * type = 1 is a Number
	 */

	private int type = 0;
	private boolean bValue = false;
	private long lValue = 0;
	
	
	// java constructor 
	public ExpValImplementer(boolean n) {
		this.bValue = n;
		this.type = 0;
	}
	
	// java constructor 
	public ExpValImplementer(long val) {
		this.lValue = val;
		this.type = 1;
	}


	// RETURNS: true iff this class is a boolean
	@Override
	public boolean isBoolean() {
		return type == 0;
	}


	// RETURNS: true iff this class is an integer
	@Override
	public boolean isInteger() {
		return type == 1;
	}


	// RETURNS: true iff this class is a function
	@Override
	public boolean isFunction() {
		return false;
	}

	
	// RETURNS: true iff this class is boolean
	@Override
	public boolean asBoolean() {
		return this.bValue;
	}


	// RETURNS: this lValue
	@Override
	public long asInteger() {
		return this.lValue;
	}


	// RETURNS: the FunVal representation of this
	@Override
	public FunVal asFunction() {
		throw new UnsupportedOperationException();
	}

}

