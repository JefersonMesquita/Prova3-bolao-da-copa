package apresentacao;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import negocio.Bolao;
import persistencia.BolaoDAO;

public class ListaBoloes extends JFrame implements ActionListener{

	private String[] titulos = { "Participante:", "Placar Quarta:", "Placar Semifinal", "Placar Final:", "Vencedor" };
	private String[][] boloes;
	private ArrayList<Bolao> AAB;

	public ListaBoloes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 600);
		setLocationRelativeTo(this);

		listarBoloes();
		organizarLayout();

		setVisible(true);
	}

	public void organizarLayout() {
		DefaultTableModel DTM = new DefaultTableModel(boloes, titulos);
		JTable JT = new JTable(DTM);
		JScrollPane JS = new JScrollPane(JT);
		add(BorderLayout.CENTER, JS);
		
		JButton JB = new JButton("Menu");
		add(BorderLayout.SOUTH, JB);
		JB.addActionListener(this);
	}

	public void listarBoloes() {
		BolaoDAO dao = new BolaoDAO();
		AAB = new ArrayList<Bolao>();
		AAB = dao.listar();
		boloes = new String[AAB.size()][5];

		for (int i = 0; i < AAB.size(); i++) {
			boloes[i][0] = AAB.get(i).getNome();
			
			boloes[i][1] = AAB.get(i).getPaises().get(0) + AAB.get(i).getPlacares().get(0) + "-X-"
					+ AAB.get(i).getPaises().get(1) + AAB.get(i).getPlacares().get(1) + "_"
					+ AAB.get(i).getPaises().get(2) + AAB.get(i).getPlacares().get(2) + "-X-"
					+ AAB.get(i).getPaises().get(3) + AAB.get(i).getPlacares().get(3) + "_"
					+ AAB.get(i).getPaises().get(4) + AAB.get(i).getPlacares().get(4) + "-X-"
					+ AAB.get(i).getPaises().get(5) + AAB.get(i).getPlacares().get(5) + "_"
					+ AAB.get(i).getPaises().get(6) + AAB.get(i).getPlacares().get(6) + "-X-"
					+ AAB.get(i).getPaises().get(7) + AAB.get(i).getPlacares().get(7);
			
			boloes[i][2] = AAB.get(i).getPaises().get(8) + AAB.get(i).getPlacares().get(8) + "-X-"
					+ AAB.get(i).getPaises().get(9) + AAB.get(i).getPlacares().get(9) + "_"
					+ AAB.get(i).getPaises().get(10) + AAB.get(i).getPlacares().get(10) + "-X-"
					+ AAB.get(i).getPaises().get(11) + AAB.get(i).getPlacares().get(11);
			
			boloes[i][3] = AAB.get(i).getPaises().get(12) + AAB.get(i).getPlacares().get(12) + "-X-"
					+ AAB.get(i).getPaises().get(13) + AAB.get(i).getPlacares().get(13);
			
			boloes[i][4] = AAB.get(i).getPaises().get(14);
		}

	}
	
	public void actionPerformed(ActionEvent e) {
		JButton botao = (JButton) e.getSource();
		
		Menu menu = new Menu();
		this.dispose();
	}

	public static void main(String[] args) {
		ListaBoloes LB = new ListaBoloes();
	}

}
