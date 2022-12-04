package src;


import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class Gui {
	private ImageIcon icon = new ImageIcon("C:\\Users\\aluno\\Documents\\BlocoDeNotas\\src\\Icon.png");
	private JEditorPane campoEscrita = new JEditorPane();
	private JMenuBar menu;
	private JFrame frame;
	private JMenu file, edit, help, palavraFormatacao;
	private JMenuItem salvar, novo, abrir, corPalavra, negrito, normal, italico;
	private HandlerFile filec = new HandlerFile();
	private JFileChooser fileChooser;
	private File fileAux;
	private JScrollPane scroll;

	public Gui() {
		frame = new JFrame("ToBex");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		chamada();
		frame.setIconImage(icon.getImage());
		frame.setJMenuBar(menu);
		frame.add(scroll);
		frame.setVisible(true);
	}

	private void chamada() {
		campoEscrita();
		menuBar();
	}

	private void campoEscrita() {
		campoEscrita.setEditable(true);
		scroll = new JScrollPane(campoEscrita);
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
		salvar = new JMenuItem("Salvar");
		abrir = new JMenuItem("Abrir");
		novo = new JMenuItem("Novo");
		file.add(novo);
		file.addSeparator();
		file.add(abrir);
		file.addSeparator();
		file.add(salvar);
		novo.addMouseListener(new New());
		abrir.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e) {
				try {
					campoEscrita.setText(filec.open(chooser(e)));
				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "Erro no codigo informe ao criador\n"+e1.getMessage());
				}
			}
		});
		salvar.addMouseListener(new MouseAdapter() {


			public void mouseReleased(MouseEvent e) {
				try {
					filec.save(chooser(e),getText());
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Erro ao criar o arquivo\n"+e1.getMessage());
				}
			}

		});
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
		negrito.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				campoEscrita.setFont(new Font("Arial",Font.BOLD,12));
			}
		});
		italico.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				campoEscrita.setFont(new Font("Arial",Font.ITALIC,12));
			}
		});
		normal.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				campoEscrita.setFont(new Font("Arial",Font.PLAIN,12));
			}
		});	
	}

	public String getText() {
		return campoEscrita.getText();
	}
	public String chooser(MouseEvent e) {
		fileChooser = new JFileChooser();
		int returnSave = fileChooser.showDialog((Component) e.getSource(), "Save");
		fileAux = fileChooser.getSelectedFile();
		if(JFileChooser.APPROVE_OPTION == returnSave ) {
			return fileAux.getPath();
		}else {
			return null;
		}
	}
}
