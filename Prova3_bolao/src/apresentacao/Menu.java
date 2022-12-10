package apresentacao;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Menu extends JFrame implements ActionListener{
		
		public Menu() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(500, 300);
			setLocationRelativeTo(this);
			
			organizarLayout();
			
			setVisible(true);
		}
		
		public JPanel botoes() {
			JPanel J = new JPanel();
			J.setLayout(new GridLayout(4, 0, 1, 2));
			J.setBackground(Color.WHITE);

			JButton btn1 = new JButton("Cadastrar novo bolao");
			btn1.addActionListener(this);
			JButton btn2 = new JButton("Mostrar bolões cadastrados");
			btn2.addActionListener(this);
			JButton btn3 = new JButton("Importar bolões");
			btn3.addActionListener(this);
			JButton btn4 = new JButton("Exportar bolões");
			btn4.addActionListener(this);
			
			J.add(btn1);
			J.add(btn2);
			J.add(btn3);
			J.add(btn4);
			
			return J;
		}
		
		public JPanel text() {
			JPanel J = new JPanel();
			J.setBackground(Color.GRAY);
			
			JLabel JL = new JLabel("Funciolalidades do bolão:");
			JL.setHorizontalAlignment(SwingConstants.CENTER);
			JL.setForeground(Color.WHITE);
			
			J.add(JL);
			
			return J;
		}
	
		public void organizarLayout() {
			add(BorderLayout.NORTH, text());
			add(BorderLayout.CENTER, botoes());
		}
		
		public void actionPerformed(ActionEvent e) {
			JButton botao = (JButton) e.getSource();

			if(botao.getText().equals("Cadastrar novo bolao")) {
				InserirNome pg = new InserirNome();
			}
			if(botao.getText().equals("Mostrar bolões cadastrados")) {
				ListaBoloes LB = new ListaBoloes();
			}
			
			this.dispose();	
		}
		
		public static void main(String[] args) {
			Menu pg = new Menu();
		}
		
	}

