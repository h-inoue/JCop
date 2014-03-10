
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;


public class CharType extends IntegralType implements Cloneable {
    public void flushCache() {
        super.flushCache();
        narrowingConversionTo_TypeDecl_values = null;
        unaryNumericPromotion_computed = false;
        unaryNumericPromotion_value = null;
        typeDescriptor_computed = false;
        typeDescriptor_value = null;
        jvmName_computed = false;
        jvmName_value = null;
        boxed_computed = false;
        boxed_value = null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public CharType clone() throws CloneNotSupportedException {
        CharType node = (CharType)super.clone();
        node.narrowingConversionTo_TypeDecl_values = null;
        node.unaryNumericPromotion_computed = false;
        node.unaryNumericPromotion_value = null;
        node.typeDescriptor_computed = false;
        node.typeDescriptor_value = null;
        node.jvmName_computed = false;
        node.jvmName_value = null;
        node.boxed_computed = false;
        node.boxed_value = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public CharType copy() {
      try {
          CharType node = (CharType)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public CharType fullCopy() {
        CharType res = (CharType)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in CodeGeneration.jrag at line 954

  void emitCastTo(CodeGeneration gen, TypeDecl type)     { type.charToThis(gen); }

    // Declared in CodeGeneration.jrag at line 964

  void intToThis(CodeGeneration gen)   { gen.emit(Bytecode.I2C); }

    // Declared in CodeGeneration.jrag at line 971

  void floatToThis(CodeGeneration gen)   { gen.emit(Bytecode.F2I).emit(Bytecode.I2C); }

    // Declared in CodeGeneration.jrag at line 980

  void doubleToThis(CodeGeneration gen)   { gen.emit(Bytecode.D2I).emit(Bytecode.I2C); }

    // Declared in CodeGeneration.jrag at line 989

  void longToThis(CodeGeneration gen)   { gen.emit(Bytecode.L2I).emit(Bytecode.I2C); }

    // Declared in CodeGeneration.jrag at line 996

  void byteToThis(CodeGeneration gen)     { gen.emit(Bytecode.I2C); }

    // Declared in CodeGeneration.jrag at line 1012

  void shortToThis(CodeGeneration gen)     { gen.emit(Bytecode.I2C); }

    // Declared in java.ast at line 3
    // Declared in java.ast line 57

    public CharType() {
        super();

        setChild(new Opt(), 1);
        setChild(new List(), 2);

    }

    // Declared in java.ast at line 12


    // Declared in java.ast line 57
    public CharType(Modifiers p0, String p1, Opt<Access> p2, List<BodyDecl> p3) {
        setChild(p0, 0);
        setID(p1);
        setChild(p2, 1);
        setChild(p3, 2);
    }

    // Declared in java.ast at line 20


    // Declared in java.ast line 57
    public CharType(Modifiers p0, beaver.Symbol p1, Opt<Access> p2, List<BodyDecl> p3) {
        setChild(p0, 0);
        setID(p1);
        setChild(p2, 1);
        setChild(p3, 2);
    }

    // Declared in java.ast at line 27


  protected int numChildren() {
    return 3;
  }

    // Declared in java.ast at line 30

  public boolean mayHaveRewrite() { return false; }

    // Declared in java.ast at line 2
    // Declared in java.ast line 42
    public void setModifiers(Modifiers node) {
        setChild(node, 0);
    }

    // Declared in java.ast at line 5

    public Modifiers getModifiers() {
        return (Modifiers)getChild(0);
    }

    // Declared in java.ast at line 9


    public Modifiers getModifiersNoTransform() {
        return (Modifiers)getChildNoTransform(0);
    }

    // Declared in java.ast at line 2
    // Declared in java.ast line 42
    public void setSuperClassAccessOpt(Opt<Access> opt) {
        setChild(opt, 1);
    }

    // Declared in java.ast at line 6


    public boolean hasSuperClassAccess() {
        return getSuperClassAccessOpt().getNumChild() != 0;
    }

    // Declared in java.ast at line 10


     @SuppressWarnings({"unchecked", "cast"})  public Access getSuperClassAccess() {
        return (Access)getSuperClassAccessOpt().getChild(0);
    }

    // Declared in java.ast at line 14


    public void setSuperClassAccess(Access node) {
        getSuperClassAccessOpt().setChild(node, 0);
    }

    // Declared in java.ast at line 17

     @SuppressWarnings({"unchecked", "cast"})  public Opt<Access> getSuperClassAccessOpt() {
        return (Opt<Access>)getChild(1);
    }

    // Declared in java.ast at line 21


     @SuppressWarnings({"unchecked", "cast"})  public Opt<Access> getSuperClassAccessOptNoTransform() {
        return (Opt<Access>)getChildNoTransform(1);
    }

    // Declared in java.ast at line 2
    // Declared in java.ast line 42
    public void setBodyDeclList(List<BodyDecl> list) {
        setChild(list, 2);
    }

    // Declared in java.ast at line 6


    private int getNumBodyDecl = 0;

    // Declared in java.ast at line 7

    public int getNumBodyDecl() {
        return getBodyDeclList().getNumChild();
    }

    // Declared in java.ast at line 11


     @SuppressWarnings({"unchecked", "cast"})  public BodyDecl getBodyDecl(int i) {
        return (BodyDecl)getBodyDeclList().getChild(i);
    }

    // Declared in java.ast at line 15


    public void addBodyDecl(BodyDecl node) {
        List<BodyDecl> list = getBodyDeclList();
        list.addChild(node);
    }

    // Declared in java.ast at line 20


    public void setBodyDecl(BodyDecl node, int i) {
        List<BodyDecl> list = getBodyDeclList();
        list.setChild(node, i);
    }

    // Declared in java.ast at line 24

    public List<BodyDecl> getBodyDecls() {
        return getBodyDeclList();
    }

    // Declared in java.ast at line 27

    public List<BodyDecl> getBodyDeclsNoTransform() {
        return getBodyDeclListNoTransform();
    }

    // Declared in java.ast at line 31


     @SuppressWarnings({"unchecked", "cast"})  public List<BodyDecl> getBodyDeclList() {
        return (List<BodyDecl>)getChild(2);
    }

    // Declared in java.ast at line 35


     @SuppressWarnings({"unchecked", "cast"})  public List<BodyDecl> getBodyDeclListNoTransform() {
        return (List<BodyDecl>)getChildNoTransform(2);
    }

    // Declared in ConstantExpression.jrag at line 296
 @SuppressWarnings({"unchecked", "cast"})     public Constant cast(Constant c) {
        Constant cast_Constant_value = cast_compute(c);
        return cast_Constant_value;
    }

    private Constant cast_compute(Constant c) {  return Constant.create((char)c.intValue());  }

    // Declared in TypeAnalysis.jrag at line 30
 @SuppressWarnings({"unchecked", "cast"})     public boolean narrowingConversionTo(TypeDecl type) {
        Object _parameters = type;
if(narrowingConversionTo_TypeDecl_values == null) narrowingConversionTo_TypeDecl_values = new java.util.HashMap(4);
        if(narrowingConversionTo_TypeDecl_values.containsKey(_parameters))
            return ((Boolean)narrowingConversionTo_TypeDecl_values.get(_parameters)).booleanValue();
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        boolean narrowingConversionTo_TypeDecl_value = narrowingConversionTo_compute(type);
        if(isFinal && num == boundariesCrossed)
            narrowingConversionTo_TypeDecl_values.put(_parameters, Boolean.valueOf(narrowingConversionTo_TypeDecl_value));
        return narrowingConversionTo_TypeDecl_value;
    }

    private boolean narrowingConversionTo_compute(TypeDecl type) {  return type.isByte() || type.isShort();  }

    // Declared in TypeAnalysis.jrag at line 152
 @SuppressWarnings({"unchecked", "cast"})     public TypeDecl unaryNumericPromotion() {
        if(unaryNumericPromotion_computed)
            return unaryNumericPromotion_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        unaryNumericPromotion_value = unaryNumericPromotion_compute();
        if(isFinal && num == boundariesCrossed)
            unaryNumericPromotion_computed = true;
        return unaryNumericPromotion_value;
    }

    private TypeDecl unaryNumericPromotion_compute() {  return typeInt();  }

    // Declared in TypeAnalysis.jrag at line 189
 @SuppressWarnings({"unchecked", "cast"})     public boolean isChar() {
        boolean isChar_value = isChar_compute();
        return isChar_value;
    }

    private boolean isChar_compute() {  return true;  }

    // Declared in CodeGeneration.jrag at line 635
 @SuppressWarnings({"unchecked", "cast"})     public byte arrayLoad() {
        byte arrayLoad_value = arrayLoad_compute();
        return arrayLoad_value;
    }

    private byte arrayLoad_compute() {  return Bytecode.CALOAD;  }

    // Declared in CodeGeneration.jrag at line 737
 @SuppressWarnings({"unchecked", "cast"})     public byte arrayStore() {
        byte arrayStore_value = arrayStore_compute();
        return arrayStore_value;
    }

    private byte arrayStore_compute() {  return Bytecode.CASTORE;  }

    // Declared in ConstantPoolNames.jrag at line 22
 @SuppressWarnings({"unchecked", "cast"})     public String typeDescriptor() {
        if(typeDescriptor_computed)
            return typeDescriptor_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        typeDescriptor_value = typeDescriptor_compute();
        if(isFinal && num == boundariesCrossed)
            typeDescriptor_computed = true;
        return typeDescriptor_value;
    }

    private String typeDescriptor_compute() {  return "C";  }

    // Declared in CreateBCode.jrag at line 807
 @SuppressWarnings({"unchecked", "cast"})     public int arrayPrimitiveTypeDescriptor() {
        int arrayPrimitiveTypeDescriptor_value = arrayPrimitiveTypeDescriptor_compute();
        return arrayPrimitiveTypeDescriptor_value;
    }

    private int arrayPrimitiveTypeDescriptor_compute() {  return 5;  }

    // Declared in Java2Rewrites.jrag at line 36
 @SuppressWarnings({"unchecked", "cast"})     public String jvmName() {
        if(jvmName_computed)
            return jvmName_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        jvmName_value = jvmName_compute();
        if(isFinal && num == boundariesCrossed)
            jvmName_computed = true;
        return jvmName_value;
    }

    private String jvmName_compute() {  return "C";  }

    // Declared in Java2Rewrites.jrag at line 48
 @SuppressWarnings({"unchecked", "cast"})     public String primitiveClassName() {
        String primitiveClassName_value = primitiveClassName_compute();
        return primitiveClassName_value;
    }

    private String primitiveClassName_compute() {  return "Character";  }

    // Declared in AutoBoxing.jrag at line 38
 @SuppressWarnings({"unchecked", "cast"})     public TypeDecl boxed() {
        if(boxed_computed)
            return boxed_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        boxed_value = boxed_compute();
        if(isFinal && num == boundariesCrossed)
            boxed_computed = true;
        return boxed_value;
    }

    private TypeDecl boxed_compute() {  return lookupType("java.lang", "Character");  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
