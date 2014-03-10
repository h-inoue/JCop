
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;
public class Opt<T extends ASTNode> extends ASTNode<T> implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
     @SuppressWarnings({"unchecked", "cast"})  public Opt<T> clone() throws CloneNotSupportedException {
        Opt node = (Opt)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public Opt<T> copy() {
      try {
          Opt node = (Opt)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public Opt<T> fullCopy() {
        Opt res = (Opt)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in Opt.ast at line 3
    // Declared in Opt.ast line 0

    public Opt() {
        super();


    }

    // Declared in Opt.ast at line 9


     public Opt(T opt) {
         setChild(opt, 0);
     }

    // Declared in Opt.ast at line 13


  public boolean mayHaveRewrite() { return false; }

    // Declared in CreateBCode.jrag at line 927
 @SuppressWarnings({"unchecked", "cast"})     public boolean definesLabel() {
        boolean definesLabel_value = definesLabel_compute();
        return definesLabel_value;
    }

    private boolean definesLabel_compute() {  return getParent().definesLabel();  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
