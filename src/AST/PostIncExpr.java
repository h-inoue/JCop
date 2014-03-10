
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;


public class PostIncExpr extends PostfixExpr implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
     @SuppressWarnings({"unchecked", "cast"})  public PostIncExpr clone() throws CloneNotSupportedException {
        PostIncExpr node = (PostIncExpr)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public PostIncExpr copy() {
      try {
          PostIncExpr node = (PostIncExpr)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public PostIncExpr fullCopy() {
        PostIncExpr res = (PostIncExpr)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in CreateBCode.jrag at line 841

  public void createBCode(CodeGeneration gen) { emitPostfix(gen, 1); }

    // Declared in java.ast at line 3
    // Declared in java.ast line 150

    public PostIncExpr() {
        super();


    }

    // Declared in java.ast at line 10


    // Declared in java.ast line 150
    public PostIncExpr(Expr p0) {
        setChild(p0, 0);
    }

    // Declared in java.ast at line 14


  protected int numChildren() {
    return 1;
  }

    // Declared in java.ast at line 17

  public boolean mayHaveRewrite() { return false; }

    // Declared in java.ast at line 2
    // Declared in java.ast line 139
    public void setOperand(Expr node) {
        setChild(node, 0);
    }

    // Declared in java.ast at line 5

    public Expr getOperand() {
        return (Expr)getChild(0);
    }

    // Declared in java.ast at line 9


    public Expr getOperandNoTransform() {
        return (Expr)getChildNoTransform(0);
    }

    // Declared in PrettyPrint.jadd at line 389
 @SuppressWarnings({"unchecked", "cast"})     public String printPostOp() {
        String printPostOp_value = printPostOp_compute();
        return printPostOp_value;
    }

    private String printPostOp_compute() {  return "++";  }

    // Declared in CreateBCode.jrag at line 215
 @SuppressWarnings({"unchecked", "cast"})     public boolean needsPop() {
        boolean needsPop_value = needsPop_compute();
        return needsPop_value;
    }

    private boolean needsPop_compute() {  return false;  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
