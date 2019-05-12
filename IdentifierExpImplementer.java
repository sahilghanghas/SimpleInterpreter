import java.util.HashSet;
import java.util.Map;

/*
 * Constructor template of IdentifierExpImplementer is a
 *  new IdentifierExpImplementer(String)
 * Interpretation:
 * 	id is the identifiers id used to find it in the environment
 */

public class IdentifierExpImplementer extends ExpImplementer 
				      implements IdentifierExp {
	
	private String id;
	
	// java constructor
	
	public IdentifierExpImplementer(String id) {
		this.id = id;
	}

	// RETURNS: this string id
	@Override
	public String name() {
		return this.id;
	}
	
	// GIVEN: an environment
	// RETURNS: this expression value
	@Override 
	public ExpVal value(Map<String, ExpVal> env) throws UnsupportedOperationException {
		if(env.containsKey(this.id)) {
			return env.get(this.id);
		} else {
			throw new UnsupportedOperationException();
		}
	}
	
	// RETURNS: true iff this class is an identifier
	@Override 
	public boolean isIdentifier() {
		return true;
	}
	
	// RETURNS: this as an operator 
	@Override
	public IdentifierExp asIdentifier() {
		return this;
	}
	
	// RETURNS: the free variables present in the expression
	@Override 
	public HashSet<String> findFreeVariables(Map<String, ExpVal> env) {

		HashSet<String> freeVars = new HashSet<String>();
		
		// only adds id's that are not in the environment as free
		// variables
		if(!env.containsKey(this.id)) {
			freeVars.add(this.id);
		} 
		
		return freeVars;
	}
}
