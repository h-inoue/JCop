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
import AST.LayerSwapping;
import AST.List;
import AST.Opt;
import AST.Program;
import AST.Stmt;
import AST.StringLiteral;
import AST.TryStmt;
import AST.VarAccess;
import AST.VariableDeclaration;
import AST.ParseName;
import AST.TypeAccess;
import AST.ClassAccess;
import java.util.*;

public class LayerSwappingGenerator extends Generator {

	private LayerSwapping swapping;
	private List<Expr> alayers;
	private Expr swlayer;
	private String swappingMethodName;

	public LayerSwappingGenerator(LayerSwapping swapping, List<Expr> alayers) {
		this.swapping = swapping;
		this.alayers = alayers;
		this.swlayer = swapping.getSwappableLayer().qualifiesAccess(new ClassAccess());
		// this.swlayer = new TypeAccess(swapping.getID()).qualifiesAccess(new ClassAccess());
		// this.swappingMethodName = swappingMethodName;
	}

	public Block generateSwappingBlock() {
		Block swappingBlock = generateLayerSwappingBlock();
		TryStmt tryStmt = 
			new TryStmt(
					swapping.getBlock().fullCopy(),
					new List<CatchClause>(), 
					getLayerRevertingMethodAccess(alayers));
		swappingBlock.addStmt(tryStmt);
		return swappingBlock;
	}
	
	private Block generateLayerSwappingBlock() {
		Block block = new Block();
		block.addStmt(generateSWLayerAssignment());
		for (Expr layerAccess : alayers)
			block.addStmt(generateLayerAssignment(layerAccess));
		return block;
	}

	private Stmt generateSWLayerAssignment() {					
		String varName = generateVarName();
		List<Expr> list = new List<Expr>();
		list.add((Expr)swlayer.fullCopy());
		Access abstractLayerAccess =
			getLayerMethodAccess(ID.removeAllSubLayer, list);
		VariableDeclaration layerAssignment = 
			new VariableDeclaration(
				JCopAccess.get(COMPOSITION), 
				varName, 
				abstractLayerAccess);
		return layerAssignment;
	}

	private Stmt generateLayerAssignment(Expr layerAccess) {					
		String varName = generateVarName();
		Access abstractLayerAccess =
			getLayerMethodAccess(ID.addLayer, createLayerSwappingArgs(layerAccess));
		VariableDeclaration layerAssignment = 
			new VariableDeclaration(
				JCopAccess.get(COMPOSITION), 
				varName, 
				abstractLayerAccess);
		return layerAssignment;
	}
	
	private List<Expr> createLayerSwappingArgs(Expr layer) {
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
			.qualifiesAccess(createMethodAccess(methodname, args));
	}
	
	private Opt<Block> getLayerRevertingMethodAccess(List<Expr> args) {
		Block block = new Block();
		for (int i = 0; i < args.getNumChild() + 1; i++) {
			String varName = generateVarName(i);
			VarAccess layerAssignment =	new VarAccess(varName);
			Access abstractLayerAccess = JCopAccess.get(JCOP).qualifiesAccess(createMethodAccess(ID.setComposition, layerAssignment));
			block.addStmt(new ExprStmt(abstractLayerAccess));
		}
		return new Opt<Block>(block);
	}

}
