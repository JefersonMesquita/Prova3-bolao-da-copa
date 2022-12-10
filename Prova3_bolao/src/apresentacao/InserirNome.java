package apresentacao;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InserirNome extends JFrame implements ActionListener{

	private JTextField nome;

	public InserirNome() {
		setLayout(new FlowLayout());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 80);
		setLocationRelativeTo(this);

		receberNome();
		iniciar();

		setVisible(true);
	}

	public void receberNome() {
		JLabel digiteNome = new JLabel("Digite seu nome:");
		add(digiteNome);

		nome = new JTextField(25);
		add(nome);
	}

	public void iniciar() {
		JButton iniciar = new JButton("INICIAR");
		iniciar.addActionListener(this);
		add(iniciar);
	}

	public void actionPerformed(ActionEvent e) {
		JButton botao = (JButton) e.getSource();

		QuartasDeFinal pg = new QuartasDeFinal(nome.getText());
		this.dispose();
	}
	
	public static void main(String[] args) {
		InserirNome pg = new InserirNome();
	}
}
