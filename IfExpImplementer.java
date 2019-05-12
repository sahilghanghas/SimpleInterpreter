import java.util.HashSet;
import java.util.List;
import java.util.Map;

/*
 * Constructor template for IfExpImplementer is a
 *  new IfExpImplementer(Exp, Exp, Exp)
 * Interpretation:
 * 	testPart is the conditional part of the if statement
 * 	thenPart is what is returned if the conditional is true
 *  elsePart is what is returned if the conditional is false
 */

public class IfExpImplementer extends ExpImplementer implements IfExp {
	
	private Exp testPart;
	private Exp thenPart;
	private Exp elsePart;
	
	// java constructor
	
	public IfExpImplementer(Exp testPart, Exp thenPart, Exp elsePart) {
		this.testPart = testPart;
		this.thenPart = thenPart;
		this.elsePart = elsePart;
	}

	// RETURNS: this expression testPart
	@Override
	public Exp testPart() {
		return this.testPart;
	}

	// RETURNS: this expression thenPart
	@Override
	public Exp thenPart() {
		return this.thenPart;
	}

	// RETURNS: this expression elsePart
	@Override
	public Exp elsePart() {
		return this.elsePart;
	}
	
	// RETURNS: true iff this is a IfExp
	@Override 
	public boolean isIf() {
		return true;
	}
	
	// RETURNS: the expression as an if expression
	@Override 
	public IfExp asIf() {
		return this;
	}
	
	// GIVEN: an environment
	// RETURNS: this expression value
	@Override 
	public ExpVal value(Map<String, ExpVal> env) throws UnsupportedOperationException {
		if(this.testPart.value(env).isBoolean()) { // if valid condition
			if(this.testPart.value(env).asBoolean()) {
				return this.thenPart.value(env);
			} else {
				return this.elsePart.value(env);
			}
		} else { // the condition is not valid (e.g not boolean result)
			throw new UnsupportedOperationException();
		}
	}
	
	// RETURNS: the free variables present in the expression
	@Override 
	public HashSet<String> findFreeVariables(Map<String, ExpVal> env) {
		
		// find the free variables for each part of the if statement
		HashSet<String> condFreeVars = ((ExpImplementer) (this.testPart)).findFreeVariables(env);
		HashSet<String> thenFreeVars = ((ExpImplementer) (this.thenPart)).findFreeVariables(env);
		HashSet<String> elseFreeVars = ((ExpImplementer) (this.elsePart)).findFreeVariables(env);
		
		// combine the free variables
		HashSet<String> freeVars = new HashSet<String>();
		freeVars.addAll(condFreeVars);
		freeVars.addAll(thenFreeVars);
		freeVars.addAll(elseFreeVars);
		
		return freeVars;
	}
	
	
	
}
