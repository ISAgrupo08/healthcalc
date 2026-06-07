package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;

import healthcalc.HealthCalc;
import healthcalc.HealthCalcImpl;
import healthcalc.exceptions.InvalidHealthDataException;

public class CalculadoraGUI_IBW extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textIBW;
	private JTextField textresultado_IBW;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadoraGUI_IBW frame = new CalculadoraGUI_IBW();
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
	public CalculadoraGUI_IBW() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(205, 235, 222));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelMetricaContainer = new JPanel();
		panelMetricaContainer.setBackground(new Color(160, 218, 193));
		panelMetricaContainer.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelMetricaContainer.setBounds(100, 85, 400, 450);
		contentPane.add(panelMetricaContainer);
		panelMetricaContainer.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(108, 193, 162));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(160, 160, 160)), "DATOS", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 128, 0)));
		panel.setBounds(20, 30, 350, 200);
		panelMetricaContainer.add(panel);
		panel.setLayout(null);
		
		JLabel lblAltura_IBW = new JLabel("Altura(cm)");
		lblAltura_IBW.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAltura_IBW.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltura_IBW.setBounds(0, 60, 120, 30);
		panel.add(lblAltura_IBW);
		
		textIBW = new JTextField();
		textIBW.setBounds(130, 60, 150, 30);
		panel.add(textIBW);
		textIBW.setColumns(10);
		
		JLabel lblsexo_IBW = new JLabel("SEXO");
		lblsexo_IBW.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblsexo_IBW.setHorizontalAlignment(SwingConstants.CENTER);
		lblsexo_IBW.setBounds(0, 130, 120, 30);
		panel.add(lblsexo_IBW);
		
		JComboBox comboSexo_IBW = new JComboBox();
		comboSexo_IBW.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboSexo_IBW.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Femenino"}));
		comboSexo_IBW.setBounds(130, 130, 150, 30);
		panel.add(comboSexo_IBW);
		
		JLabel lblNewLabel = new JLabel("Resultado de la métrica:");
		lblNewLabel.setBounds(20, 250, 200, 30);
		panelMetricaContainer.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		textresultado_IBW = new JTextField();
		textresultado_IBW.setEditable(false);
		textresultado_IBW.setBounds(210, 250, 100, 30);
		panelMetricaContainer.add(textresultado_IBW);
		textresultado_IBW.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("kg");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(325, 250, 40, 30);
		panelMetricaContainer.add(lblNewLabel_1);
		
		JLabel lblMensajeError = new JLabel("¡No son válidos los datos introducidos!");
		lblMensajeError.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensajeError.setVisible(false);
		lblMensajeError.setForeground(new Color(196, 0, 0));
		lblMensajeError.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblMensajeError.setBounds(20, 300, 350, 30);
		panelMetricaContainer.add(lblMensajeError);
		
		JLabel lblExito = new JLabel(" ÉXITO");
		lblExito.setVisible(false);
		lblExito.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblExito.setHorizontalAlignment(SwingConstants.CENTER);
		lblExito.setForeground(new Color(0, 255, 0));
		lblExito.setBounds(520, 350, 120, 100);
		contentPane.add(lblExito);
		
		JLabel lblError = new JLabel("ERROR");
		lblError.setVisible(false);
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblError.setBackground(new Color(255, 255, 255));
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setBounds(520, 350, 120, 100);
		contentPane.add(lblError);
		
		JButton btnCalcular = new JButton("CALCULAR");
		btnCalcular.setBackground(new Color(108, 193, 162));
		btnCalcular.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					lblExito.setVisible(false);
					lblError.setVisible(false);
					lblMensajeError.setVisible(false);
					textresultado_IBW.setText("");
					
					// Obtener altura
					double altura = Double.parseDouble(textIBW.getText());
					// Obtener género del ComboBox y pasarlo a char
					String seleccion = comboSexo_IBW.getSelectedItem().toString();
					char genero = (seleccion.equalsIgnoreCase("Masculino")) ? 'm' : 'f';
					
					HealthCalc calc = new HealthCalcImpl();
					double resultado = calc.ibwLorentz(altura, genero);
					// Mostrar resultado
					textresultado_IBW.setText(String.format("%.2f", resultado));
					lblExito.setVisible(true);
					
				} catch (NumberFormatException ex) {
					// Error si el usuario mete letras o deja vacío
					lblError.setVisible(true);
					lblMensajeError.setVisible(true);
					System.out.println(ex.getMessage());
				} catch (InvalidHealthDataException ex) {
					// Errores controlados por vuestro ibwLorentz (ej. altura < 30)
					lblError.setVisible(true);
					lblMensajeError.setVisible(true);
					System.out.println(ex.getMessage());
				} catch (Exception ex) {
					// Cualquier otro error inesperado
					lblError.setVisible(true);
					lblMensajeError.setVisible(true);
				}
			}
		});
		btnCalcular.setBounds(520, 150, 120, 100);
		contentPane.add(btnCalcular);
		
		JLabel lblMetrica = new JLabel("MÉTRICA IBW");
		lblMetrica.setHorizontalAlignment(SwingConstants.CENTER);
		lblMetrica.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMetrica.setBounds(100, 10, 400, 30);
		contentPane.add(lblMetrica);
		
		
		JToggleButton tglbtnBMI = new JToggleButton("BMI");
		buttonGroup.add(tglbtnBMI);
		tglbtnBMI.setBackground(new Color(108, 193, 162));
		tglbtnBMI.setFont(new Font("Tahoma", Font.BOLD, 12));
		tglbtnBMI.setBounds(20, 140, 82, 20);
		contentPane.add(tglbtnBMI);
		tglbtnBMI.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Creamos la ventana de BMI
		        CalculadoraGUI_BMI ventanaBMI = new CalculadoraGUI_BMI();
		        ventanaBMI.setVisible(true);
		        // Cerramos la actual
		        dispose();
		    }
		});
		
		JToggleButton tglbtnIBW = new JToggleButton("IBW");
		tglbtnIBW.setBackground(new Color(108, 193, 162));
		tglbtnIBW.setSelected(true);
		buttonGroup.add(tglbtnIBW);
		tglbtnIBW.setFont(new Font("Tahoma", Font.BOLD, 12));
		tglbtnIBW.setBounds(20, 180, 82, 20);
		contentPane.add(tglbtnIBW);
		
		JToggleButton tglbtnEER = new JToggleButton("REE");
		tglbtnEER.setBackground(new Color(108, 193, 162));
		buttonGroup.add(tglbtnEER);
		tglbtnEER.setFont(new Font("Tahoma", Font.BOLD, 12));
		tglbtnEER.setBounds(20, 220, 82, 20);
		contentPane.add(tglbtnEER);
		tglbtnEER.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Creamos la ventana de REE
		        CalculadoraGUI_Eer ventanaREE = new CalculadoraGUI_Eer();
		        ventanaREE.setVisible(true);
		        // Cerramos la actual
		        dispose();
		    }
		});
		
		JButton btnInicio = new JButton("VOLVER");
		btnInicio.setBackground(new Color(108, 193, 162));
		btnInicio.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnInicio.setBounds(520, 20, 120, 40);
		contentPane.add(btnInicio);
		btnInicio.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Creamos la instancia de la pantalla de inicio
		        CalculadoraGUI_Inicio pantallaInicio = new CalculadoraGUI_Inicio();
		        
		        pantallaInicio.setVisible(true);
		        // Cerramos la ventana actual (IBW) para que no se queden mil ventanas abiertas
		        dispose(); 
		    }
		});

	}
}
