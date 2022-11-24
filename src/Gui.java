import java.awt.event.KeyEvent;

import javax.swing.*;

public class Gui{
	
	private JTextArea campoEscrita;
	private JMenuBar menu;
	private JFrame frame;
	private JMenu file,edit,help,palavraFormatacao;
	private JMenuItem salvar,novo,abrir,corPalavra,negrito,normal,italico;
	
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
		campoEscrita = new JTextArea();
		campoEscrita.setLineWrap(true);
		TextHandler handlerText = new TextHandler();
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
		MenuHandler menuHandler = new MenuHandler();
		salvar = new JMenuItem("Salvar");
		abrir = new JMenuItem("Abrir");
		novo = new JMenuItem("Novo");
		file.add(novo);
		file.addSeparator();
		file.add(abrir);
		file.addSeparator();
		file.add(salvar);
		salvar.addActionListener(menuHandler);
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
	
	public JMenuItem getSalvar() {
		return salvar;
	}
	public void setSalvar(JMenuItem salvar) {
		this.salvar = salvar;
	}
	public JMenuItem getNovo() {
		return novo;
	}
	public void setNovo(JMenuItem novo) {
		this.novo = novo;
	}
	public JMenuItem getAbrir() {
		return abrir;
	}
	public void setAbrir(JMenuItem abrir) {
		this.abrir = abrir;
	}
	public JMenuItem getCorPalavra() {
		return corPalavra;
	}
	public void setCorPalavra(JMenuItem corPalavra) {
		this.corPalavra = corPalavra;
	}
	public JMenuItem getNegrito() {
		return negrito;
	}
	public void setNegrito(JMenuItem negrito) {
		this.negrito = negrito;
	}
	public JMenuItem getNormal() {
		return normal;
	}
	public void setNormal(JMenuItem normal) {
		this.normal = normal;
	}
	public JMenuItem getItalico() {
		return italico;
	}
	public void setItalico(JMenuItem italico) {
		this.italico = italico;
	}
	
}
