import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuHandler implements ActionListener{
	private Gui gui;
	private HandlerFile file = new HandlerFile();
	public void actionPerformed(ActionEvent e) {
		gui=new Gui();
		if(e.getSource() == gui.getSalvar()) {
			file.save();
			System.out.print("1");
		}
		
	}

	

}
