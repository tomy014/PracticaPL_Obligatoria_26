// Generated from C:/Users/Alberto/OneDrive - Universidad Rey Juan Carlos/Documentos/Universidad - Sexto Curso/Segundo semestre/Procesadores de Lenguajes/PObligatoria_2026/PL_Obligatoria_2026/src/TraductorC_v2.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TraductorC_v2Parser}.
 */
public interface TraductorC_v2Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(TraductorC_v2Parser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(TraductorC_v2Parser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#defines}.
	 * @param ctx the parse tree
	 */
	void enterDefines(TraductorC_v2Parser.DefinesContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#defines}.
	 * @param ctx the parse tree
	 */
	void exitDefines(TraductorC_v2Parser.DefinesContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#ctes}.
	 * @param ctx the parse tree
	 */
	void enterCtes(TraductorC_v2Parser.CtesContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#ctes}.
	 * @param ctx the parse tree
	 */
	void exitCtes(TraductorC_v2Parser.CtesContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#decfuns}.
	 * @param ctx the parse tree
	 */
	void enterDecfuns(TraductorC_v2Parser.DecfunsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#decfuns}.
	 * @param ctx the parse tree
	 */
	void exitDecfuns(TraductorC_v2Parser.DecfunsContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(TraductorC_v2Parser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(TraductorC_v2Parser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#typevar}.
	 * @param ctx the parse tree
	 */
	void enterTypevar(TraductorC_v2Parser.TypevarContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#typevar}.
	 * @param ctx the parse tree
	 */
	void exitTypevar(TraductorC_v2Parser.TypevarContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#restdecfun}.
	 * @param ctx the parse tree
	 */
	void enterRestdecfun(TraductorC_v2Parser.RestdecfunContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#restdecfun}.
	 * @param ctx the parse tree
	 */
	void exitRestdecfun(TraductorC_v2Parser.RestdecfunContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#listparam}.
	 * @param ctx the parse tree
	 */
	void enterListparam(TraductorC_v2Parser.ListparamContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#listparam}.
	 * @param ctx the parse tree
	 */
	void exitListparam(TraductorC_v2Parser.ListparamContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#listparamP}.
	 * @param ctx the parse tree
	 */
	void enterListparamP(TraductorC_v2Parser.ListparamPContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#listparamP}.
	 * @param ctx the parse tree
	 */
	void exitListparamP(TraductorC_v2Parser.ListparamPContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#dim}.
	 * @param ctx the parse tree
	 */
	void enterDim(TraductorC_v2Parser.DimContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#dim}.
	 * @param ctx the parse tree
	 */
	void exitDim(TraductorC_v2Parser.DimContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#partes}.
	 * @param ctx the parse tree
	 */
	void enterPartes(TraductorC_v2Parser.PartesContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#partes}.
	 * @param ctx the parse tree
	 */
	void exitPartes(TraductorC_v2Parser.PartesContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#part}.
	 * @param ctx the parse tree
	 */
	void enterPart(TraductorC_v2Parser.PartContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#part}.
	 * @param ctx the parse tree
	 */
	void exitPart(TraductorC_v2Parser.PartContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#restpart}.
	 * @param ctx the parse tree
	 */
	void enterRestpart(TraductorC_v2Parser.RestpartContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#restpart}.
	 * @param ctx the parse tree
	 */
	void exitRestpart(TraductorC_v2Parser.RestpartContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#blq}.
	 * @param ctx the parse tree
	 */
	void enterBlq(TraductorC_v2Parser.BlqContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#blq}.
	 * @param ctx the parse tree
	 */
	void exitBlq(TraductorC_v2Parser.BlqContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#sentlist}.
	 * @param ctx the parse tree
	 */
	void enterSentlist(TraductorC_v2Parser.SentlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#sentlist}.
	 * @param ctx the parse tree
	 */
	void exitSentlist(TraductorC_v2Parser.SentlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#sentlistP}.
	 * @param ctx the parse tree
	 */
	void enterSentlistP(TraductorC_v2Parser.SentlistPContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#sentlistP}.
	 * @param ctx the parse tree
	 */
	void exitSentlistP(TraductorC_v2Parser.SentlistPContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#sent}.
	 * @param ctx the parse tree
	 */
	void enterSent(TraductorC_v2Parser.SentContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#sent}.
	 * @param ctx the parse tree
	 */
	void exitSent(TraductorC_v2Parser.SentContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#lid}.
	 * @param ctx the parse tree
	 */
	void enterLid(TraductorC_v2Parser.LidContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#lid}.
	 * @param ctx the parse tree
	 */
	void exitLid(TraductorC_v2Parser.LidContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#lidP}.
	 * @param ctx the parse tree
	 */
	void enterLidP(TraductorC_v2Parser.LidPContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#lidP}.
	 * @param ctx the parse tree
	 */
	void exitLidP(TraductorC_v2Parser.LidPContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#dims}.
	 * @param ctx the parse tree
	 */
	void enterDims(TraductorC_v2Parser.DimsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#dims}.
	 * @param ctx the parse tree
	 */
	void exitDims(TraductorC_v2Parser.DimsContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#init}.
	 * @param ctx the parse tree
	 */
	void enterInit(TraductorC_v2Parser.InitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#init}.
	 * @param ctx the parse tree
	 */
	void exitInit(TraductorC_v2Parser.InitContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#lexp}.
	 * @param ctx the parse tree
	 */
	void enterLexp(TraductorC_v2Parser.LexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#lexp}.
	 * @param ctx the parse tree
	 */
	void exitLexp(TraductorC_v2Parser.LexpContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#lexpP}.
	 * @param ctx the parse tree
	 */
	void enterLexpP(TraductorC_v2Parser.LexpPContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#lexpP}.
	 * @param ctx the parse tree
	 */
	void exitLexpP(TraductorC_v2Parser.LexpPContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(TraductorC_v2Parser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(TraductorC_v2Parser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#expP}.
	 * @param ctx the parse tree
	 */
	void enterExpP(TraductorC_v2Parser.ExpPContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#expP}.
	 * @param ctx the parse tree
	 */
	void exitExpP(TraductorC_v2Parser.ExpPContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#op}.
	 * @param ctx the parse tree
	 */
	void enterOp(TraductorC_v2Parser.OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#op}.
	 * @param ctx the parse tree
	 */
	void exitOp(TraductorC_v2Parser.OpContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(TraductorC_v2Parser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(TraductorC_v2Parser.FactorContext ctx);
}