package projeto_pbd.com.br.modell;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backup {

	public static void backup(String diretorio) throws IOException {
		ProcessBuilder pb = null;
		Process p;
		BufferedReader br = null;
		
		//ta para salvar em linux e windows, mas se quiser pode deixar só para Windows
		//aqui vc só muda o nome do banco e esse caminho até o pg_dump
		if (System.getProperty("os.name").equalsIgnoreCase("Linux")) {
			pb = new ProcessBuilder("/usr/bin/pg_dump", "--file", diretorio+"/backup.backup", "--host", "localhost", "--port", "5432",
					"--username", "postgres", "--no-password", "--verbose", "--format=t", "--blobs", "testes_pbd");


		} else if (System.getProperty("os.name").equalsIgnoreCase("Windows"))
			pb = new ProcessBuilder("C:\\Program Files\\PostgreSQL\\10\\bin\\pg_dump.exe", "-i", "-h", "localhost",
					"-p", "5432", "-U", "postgres", "-F", "c", "-b", "-v", "-f", diretorio+"/backup.backup", "testes_pbd");

		pb.environment().put("PGPASSWORD", "postgres");
		pb.redirectErrorStream(true);
		p = pb.start();
		final InputStreamReader isr = new InputStreamReader(p.getInputStream());
		br = new BufferedReader(isr);

		String line;
		String temp = null;
		int i = 0;
		while ((line = br.readLine()) != null) {
			if (i == 0) {
				temp = line;
			}
			System.out.println(temp);
		}

	}

	public static void main(String[] args) {
		
		try {
			backup("/home/tainan/backup");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println("/  -> " + new File("/").getCanonicalPath());
			System.out.println(".. -> " + new File("..").getCanonicalPath());
			System.out.println(".  -> " + new File(".").getCanonicalPath());
			
			 System.out.println( System.getProperty("user.home"));
			 System.out.println( System.getProperty("user.desktop"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
