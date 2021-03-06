// A ConstantExp is an object of any class that implements ConstantExp.
//
// Interpretation: A ConstantExp represents an long or boolean.

interface ConstantExp extends Exp {

    // Returns the value of this constant expression.

    ExpVal value();
}
