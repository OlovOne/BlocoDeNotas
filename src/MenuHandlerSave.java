import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class MenuHandlerSave implements MouseListener{
	private HandlerFile file = new HandlerFile();
	private JFileChooser fileChooser;
	private File fileAux;
	private Gui gui;
	public void mouseClicked(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
		gui = new Gui(null);
		gui.getText();
		fileChooser = new JFileChooser();
		int returnSave = fileChooser.showDialog((Component) e.getSource(), "Save");
		fileAux = fileChooser.getSelectedFile();
		if(JFileChooser.APPROVE_OPTION == returnSave ) {
			String path = fileAux.getPath()+".txt";
			try {
				file.save(path);
			} catch (IOException e1) {
				JOptionPane.showConfirmDialog(null, "Erro ao criar o arquivo\n"+e1.getMessage());
			}
		}
	}
	public void mouseEntered(MouseEvent e) {	
	}
	public void mouseExited(MouseEvent e) {	
	}

	

}
