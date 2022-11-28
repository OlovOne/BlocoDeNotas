import java.io.File;
import java.io.IOException;


public class HandlerFile{
	private File file;
	public void save(String path) throws IOException {
		file = new File(path);
		file.createNewFile();
	}
}
