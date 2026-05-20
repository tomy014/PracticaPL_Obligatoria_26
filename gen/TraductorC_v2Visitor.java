// Generated from C:/Users/alber/OneDrive - Universidad Rey Juan Carlos/Documentos/Universidad - Sexto Curso/Segundo semestre/Procesadores de Lenguajes/PObligatoria_2026/PL_Obligatoria_2026/src/TraductorC_v2.g4 by ANTLR 4.13.2
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
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#prg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrg(TraductorC_v2Parser.PrgContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#dcllist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDcllist(TraductorC_v2Parser.DcllistContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#cabecera}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCabecera(TraductorC_v2Parser.CabeceraContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#cablist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCablist(TraductorC_v2Parser.CablistContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#cablistP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCablistP(TraductorC_v2Parser.CablistPContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#cab}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCab(TraductorC_v2Parser.CabContext ctx);
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
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#dcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDcl(TraductorC_v2Parser.DclContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#dclP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDclP(TraductorC_v2Parser.DclPContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#defcte}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefcte(TraductorC_v2Parser.DefcteContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#defvar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefvar(TraductorC_v2Parser.DefvarContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#ctelist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtelist(TraductorC_v2Parser.CtelistContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#simpvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpvalue(TraductorC_v2Parser.SimpvalueContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(TraductorC_v2Parser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#charlength}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharlength(TraductorC_v2Parser.CharlengthContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#varlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarlist(TraductorC_v2Parser.VarlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#varlistP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarlistP(TraductorC_v2Parser.VarlistPContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit(TraductorC_v2Parser.InitContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#decproc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecproc(TraductorC_v2Parser.DecprocContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#formal_paramlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormal_paramlist(TraductorC_v2Parser.Formal_paramlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#nomparamlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNomparamlist(TraductorC_v2Parser.NomparamlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#nomparamlistP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNomparamlistP(TraductorC_v2Parser.NomparamlistPContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#dec_s_paramlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDec_s_paramlist(TraductorC_v2Parser.Dec_s_paramlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#dec_s_paramlistP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDec_s_paramlistP(TraductorC_v2Parser.Dec_s_paramlistPContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#dec_s_param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDec_s_param(TraductorC_v2Parser.Dec_s_paramContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#dec_d_paramlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDec_d_paramlist(TraductorC_v2Parser.Dec_d_paramlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#tipoparam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipoparam(TraductorC_v2Parser.TipoparamContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#decfun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecfun(TraductorC_v2Parser.DecfunContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#dec_f_paramlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDec_f_paramlist(TraductorC_v2Parser.Dec_f_paramlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#dec_f_paramlistP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDec_f_paramlistP(TraductorC_v2Parser.Dec_f_paramlistPContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#sent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSent(TraductorC_v2Parser.SentContext ctx);
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
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#factorP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorP(TraductorC_v2Parser.FactorPContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#explist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplist(TraductorC_v2Parser.ExplistContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#proc_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProc_call(TraductorC_v2Parser.Proc_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#subpparamlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubpparamlist(TraductorC_v2Parser.SubpparamlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#subproglist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubproglist(TraductorC_v2Parser.SubproglistContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#subprog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubprog(TraductorC_v2Parser.SubprogContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#codproc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodproc(TraductorC_v2Parser.CodprocContext ctx);
	/**
	 * Visit a parse tree produced by {@link TraductorC_v2Parser#codfun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodfun(TraductorC_v2Parser.CodfunContext ctx);
}