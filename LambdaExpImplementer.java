import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * Constructor template for LambdaExpImplementer is a
 *  new LambdaExpImplementer(List, Exp)
 * Interpretation: 
 * 	formals is list of strings
 * 	body is an expression
 */

public class LambdaExpImplementer extends ExpImplementer implements LambdaExp {
	
	private List<String> formals;
	private Exp body;
	
	// java constructor
	
	public LambdaExpImplementer(List<String> formals, Exp body) {
		this.formals = formals;
		this.body = body;
	}

	// RETURNS: this formals list of string
	@Override
	public List<String> formals() {
		return this.formals;
	}

	// RETURNS:this expression body
	@Override
	public Exp body() {
		return this.body;
	}
	
	// GIVEN: an environment
	// RETURNS: this body expression value 
	@Override 
	public ExpVal value(Map<String, ExpVal> env) {
		FunVal temp = Asts.expVal(this, env);
		return temp;
	}
	
	// RETURNS: true iff this class is a lambda
	@Override 
	public boolean isLambda() {
		return true;
	}
	
	
	// RETURNS: this class as a lambda expression
	@Override 
	public LambdaExp asLambda() {
		return this;
	}
}
