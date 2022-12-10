package apresentacao;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import negocio.Bolao;
import negocio.Versus;
import persistencia.BolaoDAO;


public class TelaFinal extends JFrame implements ActionListener{

	private String nome;
	private Bolao AB = new Bolao();
	
	public TelaFinal(String venc, ArrayList<Versus> arrayCT, String nome) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);
		setLocationRelativeTo(this);

		this.nome = nome;
		
		organizarLayout(venc);
		
		add(arrayCT);
		inserirBolao();

		setVisible(true);
	}

	public void organizarLayout(String venc) {
		add(BorderLayout.CENTER,vencedor(venc));
		add(BorderLayout.SOUTH, botaoMenu());
	}
	
	public JPanel vencedor (String venc) {
		JPanel JP = new JPanel();
		
		JP.setLayout(new GridBagLayout());
		JLabel vencedor = new JLabel(venc);
		
		JP.add(vencedor);
		return JP;
	}
	
	public JPanel botaoMenu() {
		JPanel JP = new JPanel();
		
		JButton JB = new JButton("Menu");
		JP.add(BorderLayout.SOUTH, JB);
		JB.addActionListener(this);
		
		return JP;
	}
	
	public void add(ArrayList<Versus> arrayCT) {
		AB.setNome(this.nome);
		
		for (Versus a : arrayCT) {
			AB.addPaises(a.pais.getText());
			if (a.placar.getText() != "00000")
				AB.addPlacares(Integer.parseInt(a.placar.getText()));
		}
	}
	
	public void inserirBolao() {
		BolaoDAO dao = new BolaoDAO();
		
		dao.inserir(AB);
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton botao = (JButton) e.getSource();
		
		Menu menu = new Menu();
		this.dispose();
	}
}
