import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class ExpImplementer extends AstImplementer implements Exp {
	
	// RETURNS: true iff this class is a constant
	@Override
	public boolean isConstant() {
		return false;
	}
	
	// RETURNS: true iff this class is a identifier
	@Override
	public boolean isIdentifier() {
		return false;
	}

	// RETURNS: true iff this class is a lambda
	@Override
	public boolean isLambda() {
		return false;
	}
	
	// RETURNS: true iff this class is a arithmetic
	@Override
	public boolean isArithmetic() {
		return false;
	}
	
	// RETURNS: true iff this class is a call
	@Override
	public boolean isCall() {
		return false;
	}

	// RETURNS: true iff this class is a if
	@Override
	public boolean isIf() {
		return false;
	}
	
	// RETURNS: true iff this class is a Exp
	@Override 
	public boolean isExp() {
		return true;
	}
	
	// RETURNS: this constant expression
	@Override
	public ConstantExp asConstant() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	
	// RETURNS: this identifier expression
	@Override
	public IdentifierExp asIdentifier() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	// RETURNS: this lambda function
	@Override
	public LambdaExp asLambda() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	
	// RETURNS: this arithmetic expression
	@Override
	public ArithmeticExp asArithmetic() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	
	// RETURNS: this call expression
	@Override
	public CallExp asCall() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	// RETURNS: this if expression
	@Override
	public IfExp asIf() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	
	// RETURNS: this as a definition
	@Override 
	public Def asDef() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	
	// RETURNS: this as a program
	@Override 
	public List<Def> asPgm() {
		LinkedList<Def> defs = new LinkedList<Def>();
		defs.add(this.asDef());
		return defs;
	}
	
	// GIVEN: an environment
	// RETURNS: this expression value
	@Override
	public ExpVal value(Map<String, ExpVal> env) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	
	// RETURNS: this expression
	@Override 
	public Exp asExp() {
		return this;
	}
	
	// RETURNS: the free variables present in the expression
	public HashSet<String> findFreeVariables(Map<String, ExpVal> env) {
		return new HashSet<String>();
	}
}