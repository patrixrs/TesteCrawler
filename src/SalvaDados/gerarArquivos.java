package SalvaDados;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Boolean.TRUE;

public class gerarArquivos {

    public static void escreverCSV( String delimit,String texto, String caminhoArquivo)
	throws IOException {
            String nomeArquivo = "CapturaDados.txt";
            File file = new File(caminhoArquivo+nomeArquivo);
            
            if (!file.exists()) {
		file.createNewFile();
            }
            
            FileWriter fw = new FileWriter(file, TRUE);
            PrintWriter bw = new PrintWriter(fw);            
            
            bw.println(texto + delimit);
            bw.flush();
            // se não existir o arquivo ele será criado
            bw.close();            
	}      
}
