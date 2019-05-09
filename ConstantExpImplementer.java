// Constructor template for ConstantExp is 
//   new ConstantExpImplementer(ExpVal)
// Interpretation: 
//     val is the value of the constant

import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class ConstantExpImplementer extends ExpImplementer 
				    implements ConstantExp {
	
	private ExpVal val; // val of type ExpVal
	
	
	// java constructor 
	
	public ConstantExpImplementer(ExpVal val) {
		this.val = val;
	}
	
	// RETURNS: the value of the current expression
	@Override
	public ExpVal value() {
		return this.val;
	}
	
	// GIVEN: an environment
	// RETURNS: this expression value
	@Override 
	public ExpVal value(Map<String, ExpVal> env) {
		return this.val;
	}
	
	// RETURNS:true iff this class is a constant
	@Override 
	public boolean isConstant() {
		return true;
	}
	
	@Override
	public ConstantExp asConstant() {
		return this;
	}
	
	// RETURNS: the free variables present in the expression
	@Override 
	public HashSet<String> findFreeVariables(Map<String, ExpVal> env) {	
		return new HashSet<String>();
	}

}
