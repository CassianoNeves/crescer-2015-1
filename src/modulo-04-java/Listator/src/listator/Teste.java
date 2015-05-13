package listator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Teste {

	public static void main(String[] args) throws IOException {
		String dir = "/home/cassiano/Documentos/";
		String[] files = new File(dir).list();
		StringBuilder arquivos = new StringBuilder();
		for( String file : files ){
			arquivos.append(file + "\n");
		}
		JOptionPane.showMessageDialog(null, arquivos.toString());
	}
}
