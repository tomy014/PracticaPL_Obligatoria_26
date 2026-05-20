// Generated from C:/Users/alber/OneDrive - Universidad Rey Juan Carlos/Documentos/Universidad - Sexto Curso/Segundo semestre/Procesadores de Lenguajes/PObligatoria_2026/PL_Obligatoria_2026/src/TraductorC_v2.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TraductorC_v2Parser}.
 */
public interface TraductorC_v2Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#prg}.
	 * @param ctx the parse tree
	 */
	void enterPrg(TraductorC_v2Parser.PrgContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#prg}.
	 * @param ctx the parse tree
	 */
	void exitPrg(TraductorC_v2Parser.PrgContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#dcllist}.
	 * @param ctx the parse tree
	 */
	void enterDcllist(TraductorC_v2Parser.DcllistContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#dcllist}.
	 * @param ctx the parse tree
	 */
	void exitDcllist(TraductorC_v2Parser.DcllistContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#cabecera}.
	 * @param ctx the parse tree
	 */
	void enterCabecera(TraductorC_v2Parser.CabeceraContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#cabecera}.
	 * @param ctx the parse tree
	 */
	void exitCabecera(TraductorC_v2Parser.CabeceraContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#cablist}.
	 * @param ctx the parse tree
	 */
	void enterCablist(TraductorC_v2Parser.CablistContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#cablist}.
	 * @param ctx the parse tree
	 */
	void exitCablist(TraductorC_v2Parser.CablistContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#cablistP}.
	 * @param ctx the parse tree
	 */
	void enterCablistP(TraductorC_v2Parser.CablistPContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#cablistP}.
	 * @param ctx the parse tree
	 */
	void exitCablistP(TraductorC_v2Parser.CablistPContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#cab}.
	 * @param ctx the parse tree
	 */
	void enterCab(TraductorC_v2Parser.CabContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#cab}.
	 * @param ctx the parse tree
	 */
	void exitCab(TraductorC_v2Parser.CabContext ctx);
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
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#dcl}.
	 * @param ctx the parse tree
	 */
	void enterDcl(TraductorC_v2Parser.DclContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#dcl}.
	 * @param ctx the parse tree
	 */
	void exitDcl(TraductorC_v2Parser.DclContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#dclP}.
	 * @param ctx the parse tree
	 */
	void enterDclP(TraductorC_v2Parser.DclPContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#dclP}.
	 * @param ctx the parse tree
	 */
	void exitDclP(TraductorC_v2Parser.DclPContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#defcte}.
	 * @param ctx the parse tree
	 */
	void enterDefcte(TraductorC_v2Parser.DefcteContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#defcte}.
	 * @param ctx the parse tree
	 */
	void exitDefcte(TraductorC_v2Parser.DefcteContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#defvar}.
	 * @param ctx the parse tree
	 */
	void enterDefvar(TraductorC_v2Parser.DefvarContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#defvar}.
	 * @param ctx the parse tree
	 */
	void exitDefvar(TraductorC_v2Parser.DefvarContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#ctelist}.
	 * @param ctx the parse tree
	 */
	void enterCtelist(TraductorC_v2Parser.CtelistContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#ctelist}.
	 * @param ctx the parse tree
	 */
	void exitCtelist(TraductorC_v2Parser.CtelistContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#simpvalue}.
	 * @param ctx the parse tree
	 */
	void enterSimpvalue(TraductorC_v2Parser.SimpvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#simpvalue}.
	 * @param ctx the parse tree
	 */
	void exitSimpvalue(TraductorC_v2Parser.SimpvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(TraductorC_v2Parser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(TraductorC_v2Parser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#charlength}.
	 * @param ctx the parse tree
	 */
	void enterCharlength(TraductorC_v2Parser.CharlengthContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#charlength}.
	 * @param ctx the parse tree
	 */
	void exitCharlength(TraductorC_v2Parser.CharlengthContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#varlist}.
	 * @param ctx the parse tree
	 */
	void enterVarlist(TraductorC_v2Parser.VarlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#varlist}.
	 * @param ctx the parse tree
	 */
	void exitVarlist(TraductorC_v2Parser.VarlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#varlistP}.
	 * @param ctx the parse tree
	 */
	void enterVarlistP(TraductorC_v2Parser.VarlistPContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#varlistP}.
	 * @param ctx the parse tree
	 */
	void exitVarlistP(TraductorC_v2Parser.VarlistPContext ctx);
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
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#decproc}.
	 * @param ctx the parse tree
	 */
	void enterDecproc(TraductorC_v2Parser.DecprocContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#decproc}.
	 * @param ctx the parse tree
	 */
	void exitDecproc(TraductorC_v2Parser.DecprocContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#formal_paramlist}.
	 * @param ctx the parse tree
	 */
	void enterFormal_paramlist(TraductorC_v2Parser.Formal_paramlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#formal_paramlist}.
	 * @param ctx the parse tree
	 */
	void exitFormal_paramlist(TraductorC_v2Parser.Formal_paramlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#nomparamlist}.
	 * @param ctx the parse tree
	 */
	void enterNomparamlist(TraductorC_v2Parser.NomparamlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#nomparamlist}.
	 * @param ctx the parse tree
	 */
	void exitNomparamlist(TraductorC_v2Parser.NomparamlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#nomparamlistP}.
	 * @param ctx the parse tree
	 */
	void enterNomparamlistP(TraductorC_v2Parser.NomparamlistPContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#nomparamlistP}.
	 * @param ctx the parse tree
	 */
	void exitNomparamlistP(TraductorC_v2Parser.NomparamlistPContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#dec_s_paramlist}.
	 * @param ctx the parse tree
	 */
	void enterDec_s_paramlist(TraductorC_v2Parser.Dec_s_paramlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#dec_s_paramlist}.
	 * @param ctx the parse tree
	 */
	void exitDec_s_paramlist(TraductorC_v2Parser.Dec_s_paramlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#dec_s_paramlistP}.
	 * @param ctx the parse tree
	 */
	void enterDec_s_paramlistP(TraductorC_v2Parser.Dec_s_paramlistPContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#dec_s_paramlistP}.
	 * @param ctx the parse tree
	 */
	void exitDec_s_paramlistP(TraductorC_v2Parser.Dec_s_paramlistPContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#dec_s_param}.
	 * @param ctx the parse tree
	 */
	void enterDec_s_param(TraductorC_v2Parser.Dec_s_paramContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#dec_s_param}.
	 * @param ctx the parse tree
	 */
	void exitDec_s_param(TraductorC_v2Parser.Dec_s_paramContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#dec_d_paramlist}.
	 * @param ctx the parse tree
	 */
	void enterDec_d_paramlist(TraductorC_v2Parser.Dec_d_paramlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#dec_d_paramlist}.
	 * @param ctx the parse tree
	 */
	void exitDec_d_paramlist(TraductorC_v2Parser.Dec_d_paramlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#tipoparam}.
	 * @param ctx the parse tree
	 */
	void enterTipoparam(TraductorC_v2Parser.TipoparamContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#tipoparam}.
	 * @param ctx the parse tree
	 */
	void exitTipoparam(TraductorC_v2Parser.TipoparamContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#decfun}.
	 * @param ctx the parse tree
	 */
	void enterDecfun(TraductorC_v2Parser.DecfunContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#decfun}.
	 * @param ctx the parse tree
	 */
	void exitDecfun(TraductorC_v2Parser.DecfunContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#dec_f_paramlist}.
	 * @param ctx the parse tree
	 */
	void enterDec_f_paramlist(TraductorC_v2Parser.Dec_f_paramlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#dec_f_paramlist}.
	 * @param ctx the parse tree
	 */
	void exitDec_f_paramlist(TraductorC_v2Parser.Dec_f_paramlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#dec_f_paramlistP}.
	 * @param ctx the parse tree
	 */
	void enterDec_f_paramlistP(TraductorC_v2Parser.Dec_f_paramlistPContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#dec_f_paramlistP}.
	 * @param ctx the parse tree
	 */
	void exitDec_f_paramlistP(TraductorC_v2Parser.Dec_f_paramlistPContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#factorP}.
	 * @param ctx the parse tree
	 */
	void enterFactorP(TraductorC_v2Parser.FactorPContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#factorP}.
	 * @param ctx the parse tree
	 */
	void exitFactorP(TraductorC_v2Parser.FactorPContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#explist}.
	 * @param ctx the parse tree
	 */
	void enterExplist(TraductorC_v2Parser.ExplistContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#explist}.
	 * @param ctx the parse tree
	 */
	void exitExplist(TraductorC_v2Parser.ExplistContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#proc_call}.
	 * @param ctx the parse tree
	 */
	void enterProc_call(TraductorC_v2Parser.Proc_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#proc_call}.
	 * @param ctx the parse tree
	 */
	void exitProc_call(TraductorC_v2Parser.Proc_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#subpparamlist}.
	 * @param ctx the parse tree
	 */
	void enterSubpparamlist(TraductorC_v2Parser.SubpparamlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#subpparamlist}.
	 * @param ctx the parse tree
	 */
	void exitSubpparamlist(TraductorC_v2Parser.SubpparamlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#subproglist}.
	 * @param ctx the parse tree
	 */
	void enterSubproglist(TraductorC_v2Parser.SubproglistContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#subproglist}.
	 * @param ctx the parse tree
	 */
	void exitSubproglist(TraductorC_v2Parser.SubproglistContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#subprog}.
	 * @param ctx the parse tree
	 */
	void enterSubprog(TraductorC_v2Parser.SubprogContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#subprog}.
	 * @param ctx the parse tree
	 */
	void exitSubprog(TraductorC_v2Parser.SubprogContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#codproc}.
	 * @param ctx the parse tree
	 */
	void enterCodproc(TraductorC_v2Parser.CodprocContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#codproc}.
	 * @param ctx the parse tree
	 */
	void exitCodproc(TraductorC_v2Parser.CodprocContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorC_v2Parser#codfun}.
	 * @param ctx the parse tree
	 */
	void enterCodfun(TraductorC_v2Parser.CodfunContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorC_v2Parser#codfun}.
	 * @param ctx the parse tree
	 */
	void exitCodfun(TraductorC_v2Parser.CodfunContext ctx);
}