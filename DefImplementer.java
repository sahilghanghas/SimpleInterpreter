

// A DefImplementer is a
// 	new DefImplementer(String, Exp)
// Interpretation: 
//  lhs - the left hand side of the definition
//  rhs - the right hand side of the definition


import java.util.List;
import java.util.LinkedList;

public class DefImplementer extends ExpImplementer implements Def {
	
	private String id;
	private Exp rhs;
	
	
	// java constructor
	
	public DefImplementer(String id, Exp rhs) {
		this.id = id;
		this.rhs = rhs;
	}

	// RETURNS: left hand side of this expression
	@Override
	public String lhs() {
		return this.id;
	}
	

	// RETURNS: right hand side of this expression
	@Override
	public Exp rhs() {
		return this.rhs;
	}

	// RETURNS: true iff this class is a definition
	@Override
	public boolean isDef() {
		return true;
	}

	// RETURNS: true iff this class is a expression
	@Override
	public boolean isExp() {
		return false;
	}

	// RETURNS: a program representation of this class
	@Override
	public List<Def> asPgm() {
		LinkedList<Def> defs = new LinkedList<Def>();
		defs.add(this);
		return defs;
	}

	// RETURNS: returns this as a definition
	@Override
	public Def asDef() {
		return this;
	}

}
