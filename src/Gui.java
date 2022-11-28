
import javax.swing.*;

public class Gui {

	private JEditorPane campoEscrita = new JEditorPane();
	private JMenuBar menu;
	private JFrame frame;
	private JMenu file, edit, help, palavraFormatacao;
	private JMenuItem salvar, novo, abrir, corPalavra, negrito, normal, italico;

	public Gui(String i) {
	}

	public Gui() {
		frame = new JFrame("ToBex");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		chamada();
		frame.setJMenuBar(menu);
		frame.add(campoEscrita);
		frame.setVisible(true);
	}

	private void chamada() {
		campoEscrita();
		menuBar();
	}

	private void campoEscrita() {
		campoEscrita.setEditable(true);
	}

	private void menuBar() {
		menu = new JMenuBar();
		file = new JMenu("File");
		edit = new JMenu("Formatação");
		help = new JMenu("Help");
		menuItemEdit();
		menuItemFile();
		menu.add(file);
		menu.add(edit);
		menu.add(help);
	}

	private void menuItemFile() {
		MenuHandlerSave menuHandlerSave = new MenuHandlerSave();
		salvar = new JMenuItem("Salvar");
		abrir = new JMenuItem("Abrir");
		novo = new JMenuItem("Novo");
		file.add(novo);
		file.addSeparator();
		file.add(abrir);
		file.addSeparator();
		file.add(salvar);
		salvar.addMouseListener(menuHandlerSave);
	}

	private void menuItemEdit() {
		palavraFormatacao = new JMenu("Formatações");
		corPalavra = new JMenuItem("Cor da palavra");
		subMenuDeFormatacao();
		edit.add(palavraFormatacao);
		edit.addSeparator();
		edit.add(corPalavra);

	}

	private void subMenuDeFormatacao() {
		negrito = new JMenuItem("Negrito");
		normal = new JMenuItem("Normal");
		italico = new JMenuItem("Italico");
		palavraFormatacao.add(normal);
		palavraFormatacao.add(negrito);
		palavraFormatacao.add(italico);
	}

	public void getText() {

	}
}
