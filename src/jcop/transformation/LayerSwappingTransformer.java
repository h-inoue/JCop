package jcop.transformation;

import jcop.Globals;
import jcop.Globals.ID;
import jcop.compiler.CompilerConfiguration;
import jcop.generation.layeractivation.LayerSwappingGenerator;
import AST.Block;
import AST.Expr;
import AST.LayerSwapping;
import AST.List;
import AST.Access;
import AST.Program;


public class LayerSwappingTransformer extends Transformer {
	private LayerSwapping swapping;
	private List<Expr> alayers;
	private String swlayer;
	private LayerSwappingGenerator gen;
	

	public LayerSwappingTransformer(LayerSwapping swapping) {
		this.swapping = swapping;
		this.alayers = swapping.getArgsNoTransform().fullCopy();
		this.gen =	new LayerSwappingGenerator(swapping, alayers);
	}

	protected Block transform() {	
		Block swappingBlock = gen.generateSwappingBlock();		
		return swappingBlock;
	}
		
	// private String getMethodName() {
	// 	final String logging = 
	// 		CompilerConfiguration.getInstance().hasOption(Globals.CompilerOps.runtimeLogging) 
	// 		? "WithLogging" 
	// 		: "";
	// 	return swapping.getSwapping() 
	// 		? ID.addLayer + logging 
	// 		: ID.removeLayer + logging;
	// }
}
