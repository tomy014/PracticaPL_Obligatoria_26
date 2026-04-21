import java.io.*;
import org.antlr.v4.runtime.*;

public class Main {
    public static void main(String[] args) {
        /*Transformar el archivo que recibe como parámetro (un fichero .for) por un fichero resultante .c
         *
         */
        try {
            // Fichero de entrada
            CharStream input = CharStreams.fromFileName(args[0]);
            // Analizador léxico
            TraductorC_v2Lexer analex = new TraductorC_v2Lexer(input);
            // Declaramos los tokens
            CommonTokenStream tokens = new CommonTokenStream(analex);
            // Analizador sintácticoW
            TraductorC_v2Parser anasint = new TraductorC_v2Parser(tokens, args[0]);

            // Llamar al programa del analizador sintáctico y obtener la traducción
            TraductorC_v2Parser.PrgContext tree = anasint.prg();
            String result = tree.s;

            // Nombre del fichero de salida (.for -> .c)
            String outputName = args[0].replaceAll("\\.for$", ".c");
            if (outputName.equals(args[0])) outputName = args[0] + ".c";

            // Escribir la traducción al fichero .c
            try (PrintWriter pw = new PrintWriter(new FileWriter(outputName))) {
                pw.print(result);
            }
        }
        catch (org.antlr.v4.runtime.RecognitionException e){//Error de reconocimiento en la entrada
            System.err.println("Error (ANTLr): " + e.getMessage());
        }
        catch (IOException e){//Error de entrada/salida
            System.err.println("Error (IO): " + e.getMessage());
        }
        catch (Exception e){ //Error genérico
            System.err.println("Error (Test): " + e);
        }
    }
}
