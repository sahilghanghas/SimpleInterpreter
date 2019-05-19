/*
 * Programs class defines the static function run
 */

import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;



public class Programs {
	
	// GIVEN: a program as list of definitions and list of inputs
	// RETURNS: the expression value for the given program
		
	public static ExpVal run (List<Def> pgm, List<ExpVal> inputs) {
				
		
		Map<String, ExpVal> env = new Hashtable<String, ExpVal>();
		
		
		// add all the definitions to the environment
		for(Def def : pgm) {
			env.put(def.lhs(), def.rhs().value(env));
		}
		
		// Evaluate the first definition
		Exp exp = pgm.get(0).rhs();
		
		//System.out.println("Made it here");
		
		if(exp.isLambda()) {			
			LambdaExp lambda = exp.asLambda();
			
			//System.out.println("IsLambda");
		
			// add the formals to the argument
			if(lambda.formals().size() == inputs.size()) {
				List<String> formals = lambda.formals();
				for(int i = 0; i < formals.size(); i++) {
					env.put(formals.get(i), inputs.get(i));
				}
			
				return lambda.body().value(env);
			} else {		
				throw new UnsupportedOperationException(); 
			}
			
		} else if(exp.isConstant()) {
			ConstantExp constExp = exp.asConstant();
			
			return constExp.value();
		} else {
			System.out.println("Something went wrong");
			return null;
		}
    }
	
	// Runs the ps11 program found in the file named on the command line
    // on the integer inputs that follow its name on the command line,
    // printing the result computed by the program.
    //
    // Example:
    //
    //     % java Programs sieve.ps11 2 100
    //     25
    
    public static void main (String[] args) { 
  	
    	List<Def> pgm = Scanner.parsePgm(Scanner.readPgm(args[0]));
    	List<ExpVal> inpts = new LinkedList<ExpVal>();
    	
    	// get the arguments
    	for(int i = 1; i < args.length; i++) {
    		if(args[i] == "true") {
    			inpts.add(Asts.expVal(true));  
    		} else if(args[i] == "false") {
    			inpts.add(Asts.expVal(false));
    		} else {
    			inpts.add(Asts.expVal(Integer.parseInt(args[i])));  
    		}	 		
    	}
    	
    	ExpVal val = Programs.run(pgm, inpts);
    	
    	System.out.println(val.asInteger());

    	
    }
    
    
    // Reads the ps11 program found in the file named by the given string
    // and returns the set of all variable names that occur free within
    // the program.
    //
    // Examples:
    //     Programs.undefined ("church.ps11")    // returns an empty set
    //     Programs.undefined ("bad.ps11")       // returns { "x", "z" }
    //
    //   where bad.ps11 is a file containing:
    // 
    //     f (x, y) g (x, y) (y, z);
    //     g (z, y) if 3 > 4 then x else f
    
    // a free variable is a variable that is not present in any environment
    
  
    public static Set<String> undefined (String filename) {
		List<Def> defs = Scanner.parsePgm(Scanner.readPgm(filename));
		
	
		Set<String> freeVariables = new HashSet<String>();
		
		
		// find all free variables
		
		
		
		
		
		
		
		
		
		
		
		return null;
    }
	
	
}