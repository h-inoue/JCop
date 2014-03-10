
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;



public abstract class EqualityExpr extends RelationalExpr implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
     @SuppressWarnings({"unchecked", "cast"})  public EqualityExpr clone() throws CloneNotSupportedException {
        EqualityExpr node = (EqualityExpr)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    // Declared in TypeCheck.jrag at line 220


  // 15.21
  public void typeCheck() {
    TypeDecl left = getLeftOperand().type();
    TypeDecl right = getRightOperand().type();
    if(left.isNumericType() && right.isNumericType())
      return;
    else if(left.isBoolean() && right.isBoolean())
      return;
    else if((left.isReferenceType() || left.isNull()) && (right.isReferenceType() || right.isNull())) {
      if(left.castingConversionTo(right) || right.castingConversionTo(left))
        return;
    }
    error(left.typeName() + " can not be compared to " + right.typeName());
  }

    // Declared in AutoBoxingCodegen.jrag at line 330


  public void emitEvalBranch(CodeGeneration gen) {
    if(isTrue())
      gen.emitGoto(true_label());
    else if(isFalse())
      gen.emitGoto(false_label());
    else {
      TypeDecl type = getLeftOperand().type();
      if(type.isNumericType() && !(type.isReferenceType() && getRightOperand().type().isReferenceType())) {
        type = binaryNumericPromotedType();
        getLeftOperand().createBCode(gen);
        getLeftOperand().type().emitCastTo(gen, type); // Binary numeric promotion
        getRightOperand().createBCode(gen);
        getRightOperand().type().emitCastTo(gen, type); // Binary numeric promotion
      }
      else if(type.isBoolean() && type != getRightOperand().type()) {
        type = binaryNumericPromotedType();
        getLeftOperand().createBCode(gen);
        getLeftOperand().type().emitCastTo(gen, type); // Binary numeric promotion
        getRightOperand().createBCode(gen);
        getRightOperand().type().emitCastTo(gen, type); // Binary numeric promotion
      }
      else {
        getLeftOperand().createBCode(gen);
        getRightOperand().createBCode(gen);
      }
      compareBranch(gen, true_label(), type);
      gen.emitGoto(false_label());
      // compareNotBranch does not work for float comparison with NaN
      //compareNotBranch(gen, false_label(), type);
      //gen.emitGoto(true_label());
    }
  }

    // Declared in java.ast at line 3
    // Declared in java.ast line 184

    public EqualityExpr() {
        super();


    }

    // Declared in java.ast at line 10


    // Declared in java.ast line 184
    public EqualityExpr(Expr p0, Expr p1) {
        setChild(p0, 0);
        setChild(p1, 1);
    }

    // Declared in java.ast at line 15


  protected int numChildren() {
    return 2;
  }

    // Declared in java.ast at line 18

  public boolean mayHaveRewrite() { return false; }

    // Declared in java.ast at line 2
    // Declared in java.ast line 153
    public void setLeftOperand(Expr node) {
        setChild(node, 0);
    }

    // Declared in java.ast at line 5

    public Expr getLeftOperand() {
        return (Expr)getChild(0);
    }

    // Declared in java.ast at line 9


    public Expr getLeftOperandNoTransform() {
        return (Expr)getChildNoTransform(0);
    }

    // Declared in java.ast at line 2
    // Declared in java.ast line 153
    public void setRightOperand(Expr node) {
        setChild(node, 1);
    }

    // Declared in java.ast at line 5

    public Expr getRightOperand() {
        return (Expr)getChild(1);
    }

    // Declared in java.ast at line 9


    public Expr getRightOperandNoTransform() {
        return (Expr)getChildNoTransform(1);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
