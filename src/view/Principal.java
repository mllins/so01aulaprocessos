package view;

import controller.ProcController;

public class Principal {

	public static void main(String[] args) {
		ProcController proc = new ProcController();
//		proc.os();
		String command = "regedit.exe";
//		proc.callProcess(command);
//		command = "tasklist /fo table";
//		command = "tracert www.fateczl.edu.br";
//		command = "ping -t10 www.google.com.br";
//		proc.readProcess(command);
		command = "notepad.exe";
		proc.killProcess(command);
	}
}
