
import java.util.LinkedList;
import java.util.List;


/*
 * Constructor template of AstImplementer is a
 *  new AstImplementer(LambdaExp, Map)
 *  
 */

public abstract class AstImplementer implements Ast {

	// RETURNS: true iff this class is a pgm

	@Override
	public boolean isPgm() {
		return false;
	}


	// RETURNS: true iff this class is a definition

	@Override
	public boolean isDef() {
		return false;
	}


	// RETURNS: true iff this class is an expression
	
	@Override
	public boolean isExp() {
		return false;
	}

	
	// RETURNS: this class as a program
	
	@Override
	public List<Def> asPgm() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	// RETURNS: this class as a definition
	@Override
	public Def asDef() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	
	// RETURNS: this class as an expression

	@Override
	public Exp asExp() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

}
