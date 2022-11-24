import java.io.File;
import java.io.IOException;

public class HandlerFile {
	private File file;
	public void save() {
		file = new File("C:\\Users\\PYTER\\Documents\\Projete java\\Teste");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
