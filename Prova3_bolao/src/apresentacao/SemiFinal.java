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

import negocio.Versus;



public class SemiFinal extends JFrame implements ActionListener{

	private String nome;
	private Versus time1;
	private Versus time01;
	private Versus time2;
	private Versus time02;
	private ArrayList<Versus> arrayCT;
	
	public SemiFinal(String time1, String time01, String time2, String time02, ArrayList<Versus> arrayCT, String nome){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 220);
		setLocationRelativeTo(this);
		
		this.arrayCT = arrayCT;
		this.nome = nome;
		
		add(BorderLayout.NORTH, titulo());
		add(BorderLayout.CENTER, bolao(time1, time01, time2, time02));
		add(BorderLayout.SOUTH, enviar());
		
		setVisible(true);
	}
	
	public JPanel titulo() {
		JPanel JP = new JPanel();
		JP.setBackground(Color.WHITE);
		
		JLabel JL = new JLabel("Semifinal");
		JL.setHorizontalAlignment(SwingConstants.CENTER);
		
		JP.add(JL);
		
		return JP;
	}
	
	public JPanel bolao(String tim1, String tim01, String tim2, String tim02) {
		JPanel JP = new JPanel();
		JP.setLayout(new GridLayout(3, 5));
		
		JLabel x1 = new JLabel();	
		JLabel x2 = new JLabel("=-VS-=");	
		x2.setHorizontalAlignment(JLabel.CENTER);
		JLabel x3 = new JLabel();	
		
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
		time1.pais = new JTextField();
		time1.pais.setText(tim1);
		time1.pais.setHorizontalAlignment(JTextField.CENTER);
		time1.placar = new JTextField();
		time1.placar.setHorizontalAlignment(JTextField.CENTER);

		time01 = new Versus();
		time01.pais.setText(tim01);
		time01.pais.setHorizontalAlignment(JTextField.CENTER);
		time01.placar.setHorizontalAlignment(JTextField.CENTER);

		time2 = new Versus();
		time2.pais.setText(tim2);
		time2.pais.setHorizontalAlignment(JTextField.CENTER);
		time2.placar.setHorizontalAlignment(JTextField.CENTER);

		time02 = new Versus();
		time02.pais.setText(tim02);
		time02.pais.setHorizontalAlignment(JTextField.CENTER);
		time02.placar.setHorizontalAlignment(JTextField.CENTER);
		
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
		
		return JP;
	}
	
	public JPanel enviar() {
		JPanel JP = new JPanel();
		JP.setBackground(Color.WHITE);
		
		JButton btn = new JButton("ENVIAR");
		btn.addActionListener(this);
		
		JP.add(btn);
		
		return JP;
	}
	
	public String vencedor(Versus CT, Versus CT2) {
		if (Integer.parseInt(CT.placar.getText()) > Integer.parseInt(CT2.placar.getText())) {
			return CT.pais.getText();
		} else {
			return CT2.pais.getText();
		}
	}
	
	public void addBolao() {
		arrayCT.add(time1);
		arrayCT.add(time01);
		arrayCT.add(time2);
		arrayCT.add(time02);
	}

	public void actionPerformed(ActionEvent e) {
		JButton botao = (JButton) e.getSource();

		Final pg = new Final(vencedor(time1, time01), vencedor(time2, time02), arrayCT, nome);
		addBolao();
		this.dispose();
	}
	
	public static void main(String[] args) {
		SemiFinal pg = new SemiFinal(null, null, null, null, null, null);
	}
	
}
