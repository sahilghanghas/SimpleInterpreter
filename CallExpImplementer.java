

//Constructor template for CallExpImplementer is a
//	new CallExpImplementer(Exp, List<Exp>)
//Interpretation: 
//	operator is the expression being called on the expression
//	operands is a list of expressions called on the operator

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;

public class CallExpImplementer extends ExpImplementer implements CallExp {

	private Exp operator; // either a lambda or identifier
	private List<Exp> operands; // list of expressions 

	// java constructor

	public CallExpImplementer(Exp operator, List<Exp> operands) {
		this.operator = operator;
		this.operands = operands;
	}


	// RETURNS: the current expression
	@Override
	public Exp operator() {
		return this.operator;
	}
	
	// RETURNS: the list of expressions
	@Override
	public List<Exp> arguments() {
		return this.operands;
	}
	
	// RETURNS: true iff isCall is called
	@Override 
	public boolean isCall() {
		return true;
	}
	
	@Override
	public CallExp asCall() {
		return this;
	}
	// GIVEN: an environment
	// RETURNS: value returned by the call as an expval
	@Override 
	public ExpVal value(Map<String, ExpVal> env)  {
		// get the value of the operator on the environment
		ExpVal opVal = this.operator.value(env);
		
		// Evaluate each operand 
		List<ExpVal> vals = new LinkedList<ExpVal>();
		
		for(Exp exp : this.operands) {
			vals.add(exp.value(env));
		}
		
		// extend the environment with the formals of the call
		if(opVal.isFunction()) {
			
			FunVal funVal = opVal.asFunction();
			Map<String, ExpVal> extendEnv = new Hashtable<String, ExpVal>();
			Map<String, ExpVal> originalEnv = funVal.environment();
			
			// make a copy of the original environment
			extendEnv.putAll(originalEnv);
			
			// map the formals to the environment
			List<String> formals = opVal.asFunction().code().formals(); 
						
			for(int i = 0; i < formals.size(); i++) {
				extendEnv.put(formals.get(i), vals.get(i));
			}
			
			return funVal.code().body().value(extendEnv);
		} else {
			return opVal;
		}		
	}

	
	// RETURNS: the free variables present in the expression
	@Override 
	public HashSet<String> findFreeVariables(Map<String, ExpVal> env) {
		
		HashSet<String> freeVars = new HashSet<String>();
		
		if(this.operator.isLambda()) {
			freeVars.addAll(((ExpImplementer) (this.operator)).findFreeVariables(env));
		}

		// gets the free variable from each operand
		for(Exp exp : this.operands) {
			freeVars.addAll(((ExpImplementer) (exp)).findFreeVariables(env));
		}
		
		return freeVars;
	}

	
}


