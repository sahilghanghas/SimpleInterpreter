
// An Ast is an object of any class that implements the Ast interface.
//
// Interpretation: An Ast represents the abstract syntax tree
// for some part of a source program.
//
// This abstract data type simplies the parser,
// but should not be used by the type checker or interpreter.


import java.util.List;
import java.util.Map;
import java.util.LinkedList;


// Asts class defines all the static methods  


public class Asts {
	 // Static factory methods for Def
    
    // Returns a Def with the given left and right hand sides.
    
    public static Def def (String id1, Exp rhs) { 
    	return new DefImplementer(id1, rhs);
    }
    
    // Static factory methods for Exp
    
    // Returns an ArithmeticExp representing e1 op e2.
    
    public static ArithmeticExp arithmeticExp (Exp e1, String op, Exp e2) {
    	return new ArithmeticExpImplementer(e1, op, e2);
    }
    
    // Returns a CallExp with the given operator and operand expressions.
    
    public static CallExp callExp (Exp operator, List<Exp> operands) { 
    	return new CallExpImplementer(operator, operands);
    }
    
    // Returns a ConstantExp with the given value.
    
    public static ConstantExp constantExp (ExpVal value) { 
    	return new ConstantExpImplementer(value);
    }
    
    // Returns an IdentifierExp with the given identifier name.
    
    public static IdentifierExp identifierExp (String id) {
    	return new IdentifierExpImplementer(id);
    }
    
    // Returns an IfExp with the given components.
    
    public static IfExp ifExp (Exp testPart, Exp thenPart, Exp elsePart) {
    	return new IfExpImplementer(testPart, thenPart, elsePart);
    }
    
    // Returns a LambdaExp with the given formals and body.
    
    public static LambdaExp lambdaExp (List<String> formals, Exp body) {
    	return new LambdaExpImplementer(formals, body);
    }
    
    // Static factory methods for ExpVal
    
    // Returns a value encapsulating the given boolean.
    
    public static ExpVal expVal (boolean b) {
    	return new ExpValImplementer(b);
    }
    
    // Returns a value encapsulating the given (long) integer.
    
    public static ExpVal expVal (long n) {
    	return new ExpValImplementer(n);
    }
    
    // Returns a value encapsulating the given lambda expression
    // and environment.
    // This looks like a local function declaration
    
    public static FunVal expVal (LambdaExp exp, Map<String,ExpVal> env) {
    	return new FunValImplementer(exp, env);
    }
    
    // Static methods for creating short lists
    
    public static <X> List<X> list (X x1) {
    	List<X> lst = new LinkedList<X>();
    	lst.add(x1);
    	return lst;
    }
    
    // RETURNS: a list of the variables x1, and x2 of type X
    
    public static <X> List<X> list (X x1, X x2) {
    	List<X> lst = new LinkedList<X>();
    	lst.add(x1);
    	lst.add(x2);
    	return lst;
    }
    
    // RETURNS: a list of the variables x1, x2 and x3 of type X
    
    public static <X> List<X> list (X x1, X x2, X x3) {
    	List<X> lst = new LinkedList<X>();
    	lst.add(x1);
    	lst.add(x2);
    	lst.add(x3);
    	return lst;
    }
    
    // RETURNS: a list of the variables x1, x2, x3 and x4 of type X
    
    public static <X> List<X> list (X x1, X x2, X x3, X x4) {
    	List<X> lst = new LinkedList<X>();
    	lst.add(x1);
    	lst.add(x2);
    	lst.add(x3);
    	lst.add(x4);
    	return lst;
    }
}
