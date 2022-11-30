package OK;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JOptionPane;


public class HandlerFile{
	private File file;
	public void save(String path,String cont) throws IOException {
		
		file = new File(path);
		file.createNewFile();
		FileWriter fileWrite = new FileWriter(path);
		fileWrite.write(cont);
		fileWrite.close();
	}
	public String open(String path) throws FileNotFoundException {
		Path pathaux = Paths.get(path);
		try {
			String data = new String(Files.readAllBytes(pathaux));
			return data;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo\n"+e.getMessage());
			return null;
		}
	}
}
