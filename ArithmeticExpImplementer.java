// A ArithmeticExpImplementer a
// 	new ArithmeticExpImplementer(Exp, String, Exp)
// Interpretation: 
//  e1 is the expression to the left of the operator
//  op is the operator inbetween the two arguments
//  e2 is the expression to the right of the operator


import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ArithmeticExpImplementer extends ExpImplementer 
				      implements ArithmeticExp {
	
	private Exp e1; // the first expression 
	private String op; // operator
	private Exp e2; // second expression
	
	// java constructor
	
	public ArithmeticExpImplementer(Exp e1, String op, Exp e2) {
		this.e1 = e1;
		this.op = op;
		this.e2 = e2;	
	}
	
	
	// RETURNS: the left hand side of the expression
	@Override
	public Exp leftOperand() {
		return this.e1;
	}
	
	// RETURNS: the right hand side of the expression
	@Override
	public Exp rightOperand() {
		return this.e2;
	}
	
	// RETURNS: the operator to be implemented
	@Override
	public String operation() {
		return this.op;
	}
	
	// RETURNS: this as an ArithmeticExp
	@Override
	public ArithmeticExp asArithmetic() {
		return this;
	}

	
	// RETURNS: true iff this class is a ArithmeticExp
	@Override
	public boolean isArithmetic() {
		return true;
	}
	
	// GIVEN: an environment 
	// RETURNS: new ExpVal with operation performed over the expressions
	// STRATEGY: switch cases over the operator
	@Override 
	public ExpVal value(Map<String, ExpVal> env) {
		switch(this.op) {
			case "LT":
				return new ExpValImplementer(
						this.e1.value(env).asInteger() 
						< 
						this.e2.value(env).asInteger() 
				);
			case "EQ":
				return new ExpValImplementer(
						this.e1.value(env).asInteger() 
						== 
						this.e2.value(env).asInteger() 
				);
			case "GT":
				return new ExpValImplementer(
						this.e1.value(env).asInteger()
						> 
						this.e2.value(env).asInteger() 
				);
			case "PLUS":
				return new ExpValImplementer(
						this.e1.value(env).asInteger() 
						+ 
						this.e2.value(env).asInteger() 
				);
			case "MINUS":
				return new ExpValImplementer(
						this.e1.value(env).asInteger() 
						- 
						this.e2.value(env).asInteger() 
				);
			case "TIMES":
				return new ExpValImplementer(
						this.e1.value(env).asInteger() 
						* 
						this.e2.value(env).asInteger() 
				);
			default:
				System.out.println("You have an invalid operator "
						+ "in an arithmetic expression.");
				return null;
		}
	}
	
	// RETURNS: the free variables present in the expression
	@Override 
	public HashSet<String> findFreeVariables(Map<String, ExpVal> env) {
		
		// finds the free variables in the individual expressions
		HashSet<String> e1Variables = ((ExpImplementer) (this.e1)).findFreeVariables(env);
		HashSet<String> e2Variables = ((ExpImplementer) (this.e2)).findFreeVariables(env);
		
		// combines the free variable for the two expression
		HashSet<String> allVariables = new HashSet<String>();
		allVariables.addAll(e1Variables);
		allVariables.addAll(e2Variables);
		
		return allVariables;
	}
	
}
