// Generated from C:/Users/Alberto/OneDrive - Universidad Rey Juan Carlos/Documentos/Universidad - Sexto Curso/Segundo semestre/Procesadores de Lenguajes/PObligatoria_2026/PL_Obligatoria_2026/src/TraductorC_v2.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TraductorC_v2Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TraductorC_v2Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(TraductorC_v2Parser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#defines}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefines(TraductorC_v2Parser.DefinesContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#ctes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtes(TraductorC_v2Parser.CtesContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#decfuns}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecfuns(TraductorC_v2Parser.DecfunsContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(TraductorC_v2Parser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#typevar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypevar(TraductorC_v2Parser.TypevarContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#restdecfun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRestdecfun(TraductorC_v2Parser.RestdecfunContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#listparam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListparam(TraductorC_v2Parser.ListparamContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#listparamP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListparamP(TraductorC_v2Parser.ListparamPContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#dim}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDim(TraductorC_v2Parser.DimContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#partes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartes(TraductorC_v2Parser.PartesContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#part}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPart(TraductorC_v2Parser.PartContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#restpart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRestpart(TraductorC_v2Parser.RestpartContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#blq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlq(TraductorC_v2Parser.BlqContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#sentlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentlist(TraductorC_v2Parser.SentlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#sentlistP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentlistP(TraductorC_v2Parser.SentlistPContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#sent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSent(TraductorC_v2Parser.SentContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#lid}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLid(TraductorC_v2Parser.LidContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#lidP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLidP(TraductorC_v2Parser.LidPContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#dims}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDims(TraductorC_v2Parser.DimsContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit(TraductorC_v2Parser.InitContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#lexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLexp(TraductorC_v2Parser.LexpContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#lexpP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLexpP(TraductorC_v2Parser.LexpPContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(TraductorC_v2Parser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#expP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpP(TraductorC_v2Parser.ExpPContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp(TraductorC_v2Parser.OpContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(TraductorC_v2Parser.FactorContext ctx);
}