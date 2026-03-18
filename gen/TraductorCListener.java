// Generated from C:/Users/alber/OneDrive - Universidad Rey Juan Carlos/Documentos/Universidad - Sexto Curso/Segundo semestre/Procesadores de Lenguajes/PObligatoria_2026/PL_Obligatoria_2026/src/TraductorC.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TraductorCParser}.
 */
public interface TraductorCListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TraductorCParser#prg}.
	 * @param ctx the parse tree
	 */
	void enterPrg(TraductorCParser.PrgContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorCParser#prg}.
	 * @param ctx the parse tree
	 */
	void exitPrg(TraductorCParser.PrgContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorCParser#dcllist}.
	 * @param ctx the parse tree
	 */
	void enterDcllist(TraductorCParser.DcllistContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorCParser#dcllist}.
	 * @param ctx the parse tree
	 */
	void exitDcllist(TraductorCParser.DcllistContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorCParser#cabecera}.
	 * @param ctx the parse tree
	 */
	void enterCabecera(TraductorCParser.CabeceraContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorCParser#cabecera}.
	 * @param ctx the parse tree
	 */
	void exitCabecera(TraductorCParser.CabeceraContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorCParser#cablist}.
	 * @param ctx the parse tree
	 */
	void enterCablist(TraductorCParser.CablistContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorCParser#cablist}.
	 * @param ctx the parse tree
	 */
	void exitCablist(TraductorCParser.CablistContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorCParser#cablistP}.
	 * @param ctx the parse tree
	 */
	void enterCablistP(TraductorCParser.CablistPContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorCParser#cablistP}.
	 * @param ctx the parse tree
	 */
	void exitCablistP(TraductorCParser.CablistPContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorCParser#cab}.
	 * @param ctx the parse tree
	 */
	void enterCab(TraductorCParser.CabContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorCParser#cab}.
	 * @param ctx the parse tree
	 */
	void exitCab(TraductorCParser.CabContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorCParser#sentlist}.
	 * @param ctx the parse tree
	 */
	void enterSentlist(TraductorCParser.SentlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorCParser#sentlist}.
	 * @param ctx the parse tree
	 */
	void exitSentlist(TraductorCParser.SentlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorCParser#sentlistP}.
	 * @param ctx the parse tree
	 */
	void enterSentlistP(TraductorCParser.SentlistPContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorCParser#sentlistP}.
	 * @param ctx the parse tree
	 */
	void exitSentlistP(TraductorCParser.SentlistPContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorCParser#dcl}.
	 * @param ctx the parse tree
	 */
	void enterDcl(TraductorCParser.DclContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorCParser#dcl}.
	 * @param ctx the parse tree
	 */
	void exitDcl(TraductorCParser.DclContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorCParser#defcte}.
	 * @param ctx the parse tree
	 */
	void enterDefcte(TraductorCParser.DefcteContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorCParser#defcte}.
	 * @param ctx the parse tree
	 */
	void exitDefcte(TraductorCParser.DefcteContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorCParser#ctelist}.
	 * @param ctx the parse tree
	 */
	void enterCtelist(TraductorCParser.CtelistContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorCParser#ctelist}.
	 * @param ctx the parse tree
	 */
	void exitCtelist(TraductorCParser.CtelistContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorCParser#simpvalue}.
	 * @param ctx the parse tree
	 */
	void enterSimpvalue(TraductorCParser.SimpvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorCParser#simpvalue}.
	 * @param ctx the parse tree
	 */
	void exitSimpvalue(TraductorCParser.SimpvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorCParser#defvar}.
	 * @param ctx the parse tree
	 */
	void enterDefvar(TraductorCParser.DefvarContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorCParser#defvar}.
	 * @param ctx the parse tree
	 */
	void exitDefvar(TraductorCParser.DefvarContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorCParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(TraductorCParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorCParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(TraductorCParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorCParser#charlength}.
	 * @param ctx the parse tree
	 */
	void enterCharlength(TraductorCParser.CharlengthContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorCParser#charlength}.
	 * @param ctx the parse tree
	 */
	void exitCharlength(TraductorCParser.CharlengthContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorCParser#varlist}.
	 * @param ctx the parse tree
	 */
	void enterVarlist(TraductorCParser.VarlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorCParser#varlist}.
	 * @param ctx the parse tree
	 */
	void exitVarlist(TraductorCParser.VarlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorCParser#varlistP}.
	 * @param ctx the parse tree
	 */
	void enterVarlistP(TraductorCParser.VarlistPContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorCParser#varlistP}.
	 * @param ctx the parse tree
	 */
	void exitVarlistP(TraductorCParser.VarlistPContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorCParser#init}.
	 * @param ctx the parse tree
	 */
	void enterInit(TraductorCParser.InitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorCParser#init}.
	 * @param ctx the parse tree
	 */
	void exitInit(TraductorCParser.InitContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorCParser#decproc}.
	 * @param ctx the parse tree
	 */
	void enterDecproc(TraductorCParser.DecprocContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorCParser#decproc}.
	 * @param ctx the parse tree
	 */
	void exitDecproc(TraductorCParser.DecprocContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorCParser#formal_paramlist}.
	 * @param ctx the parse tree
	 */
	void enterFormal_paramlist(TraductorCParser.Formal_paramlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorCParser#formal_paramlist}.
	 * @param ctx the parse tree
	 */
	void exitFormal_paramlist(TraductorCParser.Formal_paramlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorCParser#nomparamlist}.
	 * @param ctx the parse tree
	 */
	void enterNomparamlist(TraductorCParser.NomparamlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorCParser#nomparamlist}.
	 * @param ctx the parse tree
	 */
	void exitNomparamlist(TraductorCParser.NomparamlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorCParser#nomparamlistP}.
	 * @param ctx the parse tree
	 */
	void enterNomparamlistP(TraductorCParser.NomparamlistPContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorCParser#nomparamlistP}.
	 * @param ctx the parse tree
	 */
	void exitNomparamlistP(TraductorCParser.NomparamlistPContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorCParser#dec_s_paramlist}.
	 * @param ctx the parse tree
	 */
	void enterDec_s_paramlist(TraductorCParser.Dec_s_paramlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorCParser#dec_s_paramlist}.
	 * @param ctx the parse tree
	 */
	void exitDec_s_paramlist(TraductorCParser.Dec_s_paramlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorCParser#dec_d_paramlist}.
	 * @param ctx the parse tree
	 */
	void enterDec_d_paramlist(TraductorCParser.Dec_d_paramlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorCParser#dec_d_paramlist}.
	 * @param ctx the parse tree
	 */
	void exitDec_d_paramlist(TraductorCParser.Dec_d_paramlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorCParser#tipoparam}.
	 * @param ctx the parse tree
	 */
	void enterTipoparam(TraductorCParser.TipoparamContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorCParser#tipoparam}.
	 * @param ctx the parse tree
	 */
	void exitTipoparam(TraductorCParser.TipoparamContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorCParser#decfun}.
	 * @param ctx the parse tree
	 */
	void enterDecfun(TraductorCParser.DecfunContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorCParser#decfun}.
	 * @param ctx the parse tree
	 */
	void exitDecfun(TraductorCParser.DecfunContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorCParser#dec_f_paramlist}.
	 * @param ctx the parse tree
	 */
	void enterDec_f_paramlist(TraductorCParser.Dec_f_paramlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorCParser#dec_f_paramlist}.
	 * @param ctx the parse tree
	 */
	void exitDec_f_paramlist(TraductorCParser.Dec_f_paramlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorCParser#dec_f_paramlistP}.
	 * @param ctx the parse tree
	 */
	void enterDec_f_paramlistP(TraductorCParser.Dec_f_paramlistPContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorCParser#dec_f_paramlistP}.
	 * @param ctx the parse tree
	 */
	void exitDec_f_paramlistP(TraductorCParser.Dec_f_paramlistPContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorCParser#sent}.
	 * @param ctx the parse tree
	 */
	void enterSent(TraductorCParser.SentContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorCParser#sent}.
	 * @param ctx the parse tree
	 */
	void exitSent(TraductorCParser.SentContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorCParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(TraductorCParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorCParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(TraductorCParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorCParser#expP}.
	 * @param ctx the parse tree
	 */
	void enterExpP(TraductorCParser.ExpPContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorCParser#expP}.
	 * @param ctx the parse tree
	 */
	void exitExpP(TraductorCParser.ExpPContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorCParser#op}.
	 * @param ctx the parse tree
	 */
	void enterOp(TraductorCParser.OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorCParser#op}.
	 * @param ctx the parse tree
	 */
	void exitOp(TraductorCParser.OpContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorCParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(TraductorCParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorCParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(TraductorCParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorCParser#factorP}.
	 * @param ctx the parse tree
	 */
	void enterFactorP(TraductorCParser.FactorPContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorCParser#factorP}.
	 * @param ctx the parse tree
	 */
	void exitFactorP(TraductorCParser.FactorPContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorCParser#explist}.
	 * @param ctx the parse tree
	 */
	void enterExplist(TraductorCParser.ExplistContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorCParser#explist}.
	 * @param ctx the parse tree
	 */
	void exitExplist(TraductorCParser.ExplistContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorCParser#proc_call}.
	 * @param ctx the parse tree
	 */
	void enterProc_call(TraductorCParser.Proc_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorCParser#proc_call}.
	 * @param ctx the parse tree
	 */
	void exitProc_call(TraductorCParser.Proc_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorCParser#subpparamlist}.
	 * @param ctx the parse tree
	 */
	void enterSubpparamlist(TraductorCParser.SubpparamlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorCParser#subpparamlist}.
	 * @param ctx the parse tree
	 */
	void exitSubpparamlist(TraductorCParser.SubpparamlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorCParser#subproglist}.
	 * @param ctx the parse tree
	 */
	void enterSubproglist(TraductorCParser.SubproglistContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorCParser#subproglist}.
	 * @param ctx the parse tree
	 */
	void exitSubproglist(TraductorCParser.SubproglistContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorCParser#subprog}.
	 * @param ctx the parse tree
	 */
	void enterSubprog(TraductorCParser.SubprogContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorCParser#subprog}.
	 * @param ctx the parse tree
	 */
	void exitSubprog(TraductorCParser.SubprogContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorCParser#codproc}.
	 * @param ctx the parse tree
	 */
	void enterCodproc(TraductorCParser.CodprocContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorCParser#codproc}.
	 * @param ctx the parse tree
	 */
	void exitCodproc(TraductorCParser.CodprocContext ctx);
	/**
	 * Enter a parse tree produced by {@link TraductorCParser#codfun}.
	 * @param ctx the parse tree
	 */
	void enterCodfun(TraductorCParser.CodfunContext ctx);
	/**
	 * Exit a parse tree produced by {@link TraductorCParser#codfun}.
	 * @param ctx the parse tree
	 */
	void exitCodfun(TraductorCParser.CodfunContext ctx);
}