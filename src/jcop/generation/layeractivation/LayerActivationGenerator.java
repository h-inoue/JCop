package jcop.generation.layeractivation;

import jcop.Globals.CompilerOps;
import  jcop.Globals.ID;
import  static jcop.Globals.Types.*;
import jcop.Globals.LoggingProperties;
import jcop.compiler.CompilerConfiguration;
import jcop.compiler.JCopTypes.JCopAccess;
import jcop.generation.Generator;
import AST.Access;
import AST.Block;
import AST.CatchClause;
import AST.Expr;
import AST.ExprStmt;
import AST.LayerActivation;
import AST.List;
import AST.Opt;
import AST.Program;
import AST.Stmt;
import AST.StringLiteral;
import AST.TryStmt;
import AST.VarAccess;
import AST.VariableDeclaration;


public class LayerActivationGenerator extends Generator {

	private LayerActivation activation;
	private List<Expr> layers;
	private String activationMethodName;
	// private static int activeLayerCounter = 0;

	public LayerActivationGenerator(LayerActivation activation, String activationMethodName, List<Expr> layers) {
		this.activation = activation;
		this.layers = layers;
		this.activationMethodName = activationMethodName;
	}

		/*
from AST.Block
046      /**
047       * Create a deep copy of the AST subtree at this node.
048       * The copy is dangling, i.e. has no parent.
049       * @return dangling copy of the subtree at this node
050       * @apilevel low-level
051       
052      public Block fullCopy() {
053        Block tree = (Block) copy();
054        if (children != null) {
055          for (int i = 0; i < children.length; ++i) {
056            ASTNode child = (ASTNode) children[i];
057            if(child != null) {
058              child = child.fullCopy();
059              tree.setChild(child, i);
060            }
061          }
062        }
063        return tree;
064      }

		*/

	public Block generateActivationBlock() {
		Block activationBlock = generateLayerActivationBlock();
		TryStmt tryStmt = 
			new TryStmt(
					activation.getBlock().fullCopy(),
					new List<CatchClause>(), 
					getLayerDeActivationMethodAccess(layers));
		activationBlock.addStmt(tryStmt);
		return activationBlock;
	}
	
	private Block generateLayerActivationBlock() {
		Block block = new Block();
		for (Expr layerAccess : layers) 	
			block.addStmt(generateLayerAssignment(layerAccess));		
		return block;
	}

	private Stmt generateLayerAssignment(Expr layerAccess) {					
		String varName = generateVarName();
		Access abstractLayerAccess = 
			getLayerMethodAccess(activationMethodName,	createLayerActivationArgs(layerAccess));		
		VariableDeclaration layerAssignment = 
			new VariableDeclaration(
				JCopAccess.get(COMPOSITION), 
				varName, 
				abstractLayerAccess);
		return layerAssignment;
	}
	
	private List<Expr> createLayerActivationArgs(Expr layer) {
		List<Expr> args = new List<Expr>();
		if (CompilerConfiguration.getInstance().hasOption(CompilerOps.runtimeLogging)) 
			args.add(new StringLiteral(LoggingProperties.loggerName));		
		args.add(layer);
		return args;
	}


	private String generateVarName() {
		return ID.layerCompositionIdentifierPrefix + activeLayerCounter++;		
	}
	
	private String generateVarName(int pos) {
		return ID.layerCompositionIdentifierPrefix + (activeLayerCounter - 1 - pos);
	}
	
	private Access getLayerMethodAccess(String methodname, List<Expr> args) {
		return JCopAccess.get(JCOP).qualifiesAccess(createMethodAccess(ID.current))
			.qualifiesAccess(	createMethodAccess(methodname, args));
	}
	
	private Opt<Block> getLayerDeActivationMethodAccess(List<Expr> args) {
		Block block = new Block();
		for (int i = 0; i < args.getNumChild(); i++) {
			String varName = generateVarName(i);
			VarAccess layerAssignment =	new VarAccess(varName);
			Access abstractLayerAccess = JCopAccess.get(JCOP).qualifiesAccess(createMethodAccess(ID.setComposition, layerAssignment));
			block.addStmt(new ExprStmt(abstractLayerAccess));
		}
		return new Opt<Block>(block);
	}

}
