package apresentacao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import negocio.Bolao;
import negocio.Versus;

public class QuartasDeFinal extends JFrame implements ActionListener {

	private String nome;
	private Versus time1;
	private Versus time01;
	private Versus time2;
	private Versus time02;
	private Versus time3;
	private Versus time03;
	private Versus time4;
	private Versus time04;

	public QuartasDeFinal(String nome) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);
		setLocationRelativeTo(this);

		this.nome = nome;
		organizarLayout();

		setVisible(true);
	}

	public JPanel titulo() {
		JPanel JP = new JPanel();
		JP.setBackground(Color.WHITE);

		JLabel JL = new JLabel("Quartas de Final");
		JL.setHorizontalAlignment(SwingConstants.CENTER);

		JP.add(JL);

		return JP;
	}

	public JPanel bolao() {
		JPanel JP = new JPanel();
		JP.setLayout(new GridLayout(5, 5));

		JLabel x1 = new JLabel();
		JLabel x2 = new JLabel();
		JLabel x3 = new JLabel("=-VS-=");
		x3.setHorizontalAlignment(JLabel.CENTER);
		JLabel x4 = new JLabel();
		JLabel x5 = new JLabel();

		JTextField selecao1 = new JTextField(10);
		selecao1.setText("Selecao:");
		selecao1.setHorizontalAlignment(JTextField.CENTER);
		selecao1.setEditable(false);
		selecao1.setBackground(Color.GRAY);
		selecao1.setForeground(Color.WHITE);
		JTextField placar2 = new JTextField(10);
		placar2.setText("Placar:");
		placar2.setHorizontalAlignment(JTextField.CENTER);
		placar2.setEditable(false);
		placar2.setBackground(Color.GRAY);
		placar2.setForeground(Color.WHITE);
		JTextField selecao01 = new JTextField(10);
		selecao01.setText("Selecao:");
		selecao01.setHorizontalAlignment(JTextField.CENTER);
		selecao01.setEditable(false);
		selecao01.setBackground(Color.GRAY);
		selecao01.setForeground(Color.WHITE);
		JTextField placar02 = new JTextField(10);
		placar02.setText("Placar:");
		placar02.setHorizontalAlignment(JTextField.CENTER);
		placar02.setEditable(false);
		placar02.setBackground(Color.GRAY);
		placar02.setForeground(Color.WHITE);

		time1 = new Versus();
		time1.pais.setHorizontalAlignment(JTextField.CENTER);
		time1.placar.setHorizontalAlignment(JTextField.CENTER);

		time01 = new Versus();
		time01.pais.setHorizontalAlignment(JTextField.CENTER);
		time01.placar.setHorizontalAlignment(JTextField.CENTER);

		time2 = new Versus();
		time2.pais.setHorizontalAlignment(JTextField.CENTER);
		time2.placar.setHorizontalAlignment(JTextField.CENTER);

		time02 = new Versus();
		time02.pais.setHorizontalAlignment(JTextField.CENTER);
		time02.placar.setHorizontalAlignment(JTextField.CENTER);

		time3 = new Versus();
		time3.pais.setHorizontalAlignment(JTextField.CENTER);
		time3.placar.setHorizontalAlignment(JTextField.CENTER);

		time03 = new Versus();
		time03.pais.setHorizontalAlignment(JTextField.CENTER);
		time03.placar.setHorizontalAlignment(JTextField.CENTER);

		time4 = new Versus();
		time4.pais.setHorizontalAlignment(JTextField.CENTER);
		time4.placar.setHorizontalAlignment(JTextField.CENTER);

		time04 = new Versus();
		time04.pais.setHorizontalAlignment(JTextField.CENTER);
		time04.placar.setHorizontalAlignment(JTextField.CENTER);

		JP.add(selecao1);
		JP.add(placar2);
		JP.add(x1);
		JP.add(selecao01);
		JP.add(placar02);

		JP.add(time1.pais);
		JP.add(time1.placar);
		JP.add(x2);
		JP.add(time01.pais);
		JP.add(time01.placar);

		JP.add(time2.pais);
		JP.add(time2.placar);
		JP.add(x3);
		JP.add(time02.pais);
		JP.add(time02.placar);

		JP.add(time3.pais);
		JP.add(time3.placar);
		JP.add(x4);
		JP.add(time03.pais);
		JP.add(time03.placar);

		JP.add(time4.pais);
		JP.add(time4.placar);
		JP.add(x5);
		JP.add(time04.pais);
		JP.add(time04.placar);

		return JP;
	}

	public JPanel enviar() {
		JPanel JP = new JPanel();
		JP.setBackground(Color.WHITE);

		JButton btn = new JButton("ENVIAR");
		JP.add(btn);
		btn.addActionListener(this);

		return JP;
	}

	public void organizarLayout() {
		add(BorderLayout.NORTH, titulo());
		add(BorderLayout.CENTER, bolao());
		add(BorderLayout.SOUTH, enviar());
	}

	public String vencedor(Versus CT, Versus CT2) {
		if (Integer.parseInt(CT.placar.getText()) > Integer.parseInt(CT2.placar.getText())) {
			return CT.pais.getText();
		} else {
			return CT2.pais.getText();
		}
	}

	public ArrayList<Versus> addBolao() {
		ArrayList<Versus> arrayCT = new ArrayList<Versus>();

		arrayCT.add(time1);
		arrayCT.add(time01);
		arrayCT.add(time2);
		arrayCT.add(time02);
		arrayCT.add(time3);
		arrayCT.add(time03);
		arrayCT.add(time4);
		arrayCT.add(time04);

		return arrayCT;
	}

	public void actionPerformed(ActionEvent e) {
		JButton botao = (JButton) e.getSource();

		SemiFinal pg = new SemiFinal(vencedor(time1, time01), vencedor(time2, time02), vencedor(time3, time03), vencedor(time4, time04), addBolao(), nome);
		addBolao();
		this.dispose();
	}
	
	public static void main(String[] args) {
		QuartasDeFinal QDF = new QuartasDeFinal(null);
	}

}
