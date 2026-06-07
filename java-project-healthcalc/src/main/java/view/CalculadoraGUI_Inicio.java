package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculadoraGUI_Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel Inicio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadoraGUI_Inicio frame = new CalculadoraGUI_Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CalculadoraGUI_Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 500);
		Inicio = new JPanel();
		Inicio.setBackground(new Color(191, 255, 255));
		Inicio.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(Inicio);
		Inicio.setLayout(null);
		
		JLabel lblTitulo = new JLabel("CALCULADORA DE SALUD");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTitulo.setBounds(50, 125, 560, 50);
		Inicio.add(lblTitulo);
		
		JLabel lblNewLabel = new JLabel("Por favor, seleccione una métrica inicial para calcular.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(50, 230, 560, 50);
		Inicio.add(lblNewLabel);
		
		JButton btnBMI = new JButton("BMI");
		btnBMI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculadoraGUI_BMI ventana_BMI= new CalculadoraGUI_BMI();
				ventana_BMI.setVisible(true);
				dispose();
			}
		});
		btnBMI.setBackground(new Color(128, 255, 255));
		btnBMI.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBMI.setBounds(100, 350, 100, 50);
		Inicio.add(btnBMI);
		
		JButton btnIBW = new JButton("IBW");
		btnIBW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculadoraGUI_IBW ventana_IBW= new CalculadoraGUI_IBW();
				ventana_IBW.setVisible(true);
				dispose();
			}
		});
		btnIBW.setBackground(new Color(128, 255, 255));
		btnIBW.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnIBW.setBounds(300, 350, 100, 50);
		Inicio.add(btnIBW);
		
		JButton btnEER = new JButton("REE");
		btnEER.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculadoraGUI_Eer ventana_EER = new CalculadoraGUI_Eer();
				ventana_EER.setVisible(true);
				dispose();
			}
		});
		btnEER.setBackground(new Color(128, 255, 255));
		btnEER.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnEER.setBounds(500, 350, 100, 50);
		Inicio.add(btnEER);
		
		JButton btnNewButton = new JButton("SALIR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(480, 20, 150, 50);
		Inicio.add(btnNewButton);
	}

}
