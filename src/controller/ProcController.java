package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcController {

	public ProcController() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public void os() {
		String osName = System.getProperty("os.name");
		String osVersion = System.getProperty("os.version");
		String osArch = System.getProperty("os.arch");
		System.out.println("SO: " + osName + " - versão: " + osVersion + " - arquitetura: " + osArch);
	}
	
	public void callProcess(String command) {
		try {
			Runtime.getRuntime().exec(command);
//			ProcessBuilder pb = new ProcessBuilder(command);
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			if(e.getMessage().contains("740")) {
				StringBuffer buffer=new StringBuffer();
				buffer.append("cmd /c");
				buffer.append(" ");
				buffer.append(command);
				try {
					Runtime.getRuntime().exec(buffer.toString());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
//					e1.printStackTrace();
					System.err.println();
				}
			} else {
				System.err.println("Comando não encontrado.");
			}
		}
	}
	
	public void readProcess(String command) {
		try {
			Process p = Runtime.getRuntime().exec(command); // Executa o processo e o coloca em uma variável Process
			InputStream stream = p.getInputStream(); // Recebe a sequência de bits do processo.
			InputStreamReader reader = new InputStreamReader(stream); // Faz a leitura dos bits recebidos.
			BufferedReader buffer = new BufferedReader(reader); // Faz uma converção e armazena em um buffer.
			String line = buffer.readLine();
			while (line != null) {
				System.out.println(line);
				line=buffer.readLine();
			}
			buffer.close();
			reader.close();
			stream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.err.println(e.getMessage());
		}
	}
	
	public void killProcess(String param) {
		String cmdPid = "taskkill /pid";
		String cmdNome = "taskkill /im";
		@SuppressWarnings("unused")
		int pid = 0;
		StringBuffer buffer = new StringBuffer();
		try {
			pid = Integer.parseInt(param);
			buffer.append(cmdPid);
			buffer.append(" ");
			buffer.append(param);
		} catch (NumberFormatException e) {
			buffer.append(cmdNome);
			buffer.append(" ");
			buffer.append(param);
		}
		callProcess(buffer.toString());
	}
}
