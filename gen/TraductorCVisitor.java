// Generated from C:/Users/Alberto/OneDrive - Universidad Rey Juan Carlos/Documentos/Universidad - Sexto Curso/Segundo semestre/Procesadores de Lenguajes/PObligatoria_2026/PL_Obligatoria_2026/src/TraductorC.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TraductorCParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TraductorCVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TraductorCParser#prg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrg(TraductorCParser.PrgContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorCParser#dcllist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDcllist(TraductorCParser.DcllistContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorCParser#cabecera}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCabecera(TraductorCParser.CabeceraContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorCParser#cablist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCablist(TraductorCParser.CablistContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorCParser#cablistP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCablistP(TraductorCParser.CablistPContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorCParser#cab}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCab(TraductorCParser.CabContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorCParser#sentlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentlist(TraductorCParser.SentlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorCParser#sentlistP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentlistP(TraductorCParser.SentlistPContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorCParser#dcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDcl(TraductorCParser.DclContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorCParser#defcte}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefcte(TraductorCParser.DefcteContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorCParser#ctelist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtelist(TraductorCParser.CtelistContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorCParser#simpvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpvalue(TraductorCParser.SimpvalueContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorCParser#defvar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefvar(TraductorCParser.DefvarContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorCParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(TraductorCParser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorCParser#charlength}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharlength(TraductorCParser.CharlengthContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorCParser#varlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarlist(TraductorCParser.VarlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorCParser#varlistP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarlistP(TraductorCParser.VarlistPContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorCParser#init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit(TraductorCParser.InitContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorCParser#decproc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecproc(TraductorCParser.DecprocContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorCParser#formal_paramlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormal_paramlist(TraductorCParser.Formal_paramlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorCParser#nomparamlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNomparamlist(TraductorCParser.NomparamlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorCParser#nomparamlistP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNomparamlistP(TraductorCParser.NomparamlistPContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorCParser#dec_s_paramlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDec_s_paramlist(TraductorCParser.Dec_s_paramlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorCParser#dec_d_paramlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDec_d_paramlist(TraductorCParser.Dec_d_paramlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorCParser#tipoparam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipoparam(TraductorCParser.TipoparamContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorCParser#decfun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecfun(TraductorCParser.DecfunContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorCParser#dec_f_paramlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDec_f_paramlist(TraductorCParser.Dec_f_paramlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorCParser#dec_f_paramlistP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDec_f_paramlistP(TraductorCParser.Dec_f_paramlistPContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorCParser#sent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSent(TraductorCParser.SentContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorCParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(TraductorCParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorCParser#expP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpP(TraductorCParser.ExpPContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorCParser#op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp(TraductorCParser.OpContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorCParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(TraductorCParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorCParser#factorP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorP(TraductorCParser.FactorPContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorCParser#explist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplist(TraductorCParser.ExplistContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorCParser#proc_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProc_call(TraductorCParser.Proc_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorCParser#subpparamlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubpparamlist(TraductorCParser.SubpparamlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorCParser#subproglist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubproglist(TraductorCParser.SubproglistContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorCParser#subprog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubprog(TraductorCParser.SubprogContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorCParser#codproc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodproc(TraductorCParser.CodprocContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorCParser#codfun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodfun(TraductorCParser.CodfunContext ctx);
}