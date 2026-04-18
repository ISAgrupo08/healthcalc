package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.TitledBorder;

import healthcalc.HealthCalc;
import healthcalc.HealthCalcImpl;
import healthcalc.exceptions.InvalidHealthDataException;

import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculadoraGUI_Eer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel MetricaEER;
	private JTextField tfAltura_EER;
	private JTextField tfPeso_EER;
	private JTextField tfEdad_EER;
	private JTextField tfResultado_EER;
	private final ButtonGroup bgActividad = new ButtonGroup();
	private final ButtonGroup bgMetricas = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadoraGUI_Eer frame = new CalculadoraGUI_Eer();
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
	public CalculadoraGUI_Eer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 600);
		MetricaEER = new JPanel();
		MetricaEER.setBackground(new Color(205, 235, 222));
		MetricaEER.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(MetricaEER);
		MetricaEER.setLayout(null);
		
		JPanel DatosEER = new JPanel();
		DatosEER.setBackground(new Color(160, 218, 193));
		DatosEER.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		DatosEER.setBounds(100, 85, 400, 450);
		MetricaEER.add(DatosEER);
		DatosEER.setLayout(null);
		
		JPanel Datos = new JPanel();
		Datos.setBackground(new Color(108, 193, 162));
		Datos.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0)), "DATOS", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 128, 0)));
		Datos.setBounds(20, 30, 350, 250);
		DatosEER.add(Datos);
		Datos.setLayout(null);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSexo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSexo.setBounds(10, 60, 80, 20);
		Datos.add(lblSexo);
		
		JLabel lblAltura = new JLabel("Altura(cm)");
		lblAltura.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltura.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAltura.setBounds(10, 100, 80, 20);
		Datos.add(lblAltura);
		
		JComboBox comboSexo_EER = new JComboBox();
		comboSexo_EER.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboSexo_EER.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Femenino"}));
		comboSexo_EER.setBounds(100, 60, 100, 20);
		Datos.add(comboSexo_EER);
		
		tfAltura_EER = new JTextField();
		tfAltura_EER.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfAltura_EER.setHorizontalAlignment(SwingConstants.CENTER);
		tfAltura_EER.setBounds(100, 100, 100, 20);
		Datos.add(tfAltura_EER);
		tfAltura_EER.setColumns(10);
		
		JLabel lblPeso = new JLabel("Peso(Kg)");
		lblPeso.setHorizontalAlignment(SwingConstants.CENTER);
		lblPeso.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPeso.setBounds(10, 140, 80, 20);
		Datos.add(lblPeso);
		
		tfPeso_EER = new JTextField();
		tfPeso_EER.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfPeso_EER.setHorizontalAlignment(SwingConstants.CENTER);
		tfPeso_EER.setColumns(10);
		tfPeso_EER.setBounds(100, 140, 100, 20);
		Datos.add(tfPeso_EER);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEdad.setBounds(10, 180, 80, 20);
		Datos.add(lblEdad);
		
		tfEdad_EER = new JTextField();
		tfEdad_EER.setHorizontalAlignment(SwingConstants.CENTER);
		tfEdad_EER.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfEdad_EER.setColumns(10);
		tfEdad_EER.setBounds(100, 180, 100, 20);
		Datos.add(tfEdad_EER);
		
		JLabel lblActividad = new JLabel("Actividad");
		lblActividad.setHorizontalAlignment(SwingConstants.CENTER);
		lblActividad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblActividad.setBounds(225, 30, 100, 20);
		Datos.add(lblActividad);
		
		JRadioButton rdbtnSedentario = new JRadioButton("Sedentario/a");
		rdbtnSedentario.setBackground(new Color(108, 193, 162));
		bgActividad.add(rdbtnSedentario);
		rdbtnSedentario.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnSedentario.setBounds(225, 60, 110, 20);
		Datos.add(rdbtnSedentario);
		
		JRadioButton rdbtnLigero = new JRadioButton("Ligero/a");
		rdbtnLigero.setBackground(new Color(108, 193, 162));
		bgActividad.add(rdbtnLigero);
		rdbtnLigero.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnLigero.setBounds(225, 90, 110, 20);
		Datos.add(rdbtnLigero);
		
		JRadioButton rdbtnModerado = new JRadioButton("Moderado/a");
		rdbtnModerado.setBackground(new Color(108, 193, 162));
		bgActividad.add(rdbtnModerado);
		rdbtnModerado.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnModerado.setBounds(225, 120, 110, 20);
		Datos.add(rdbtnModerado);
		
		JRadioButton rdbtnActivo = new JRadioButton("Activo/a");
		rdbtnActivo.setBackground(new Color(108, 193, 162));
		bgActividad.add(rdbtnActivo);
		rdbtnActivo.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnActivo.setBounds(225, 150, 110, 20);
		Datos.add(rdbtnActivo);
		
		JRadioButton rdbtnMuyActivo = new JRadioButton("Muy activo/a");
		rdbtnMuyActivo.setBackground(new Color(108, 193, 162));
		bgActividad.add(rdbtnMuyActivo);
		rdbtnMuyActivo.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnMuyActivo.setBounds(225, 180, 110, 20);
		Datos.add(rdbtnMuyActivo);
		
		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setBounds(20, 300, 100, 25);
		DatosEER.add(lblResultado);
		
		tfResultado_EER = new JTextField();
		tfResultado_EER.setEditable(false);
		tfResultado_EER.setHorizontalAlignment(SwingConstants.CENTER);
		tfResultado_EER.setBounds(130, 300, 150, 25);
		DatosEER.add(tfResultado_EER);
		tfResultado_EER.setColumns(10);
		
		JLabel lblTipoError = new JLabel("");
		lblTipoError.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTipoError.setForeground(new Color(255, 0, 0));
		lblTipoError.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoError.setBounds(20, 350, 350, 70);
		DatosEER.add(lblTipoError);
		
		JLabel lblUnidad = new JLabel("kcal");
		lblUnidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUnidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblUnidad.setBounds(300, 300, 40, 25);
		DatosEER.add(lblUnidad);
		
		JLabel lblMetrica = new JLabel("MÉTRICA EER");
		lblMetrica.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMetrica.setHorizontalAlignment(SwingConstants.CENTER);
		lblMetrica.setBounds(100, 45, 400, 30);
		MetricaEER.add(lblMetrica);
		
		JLabel lblError = new JLabel("ERROR");
		lblError.setVisible(false);
		lblError.setBackground(new Color(240, 240, 240));
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setBounds(520, 350, 120, 100);
		MetricaEER.add(lblError);
		
		JLabel lblExito = new JLabel("ÉXITO");
		lblExito.setVisible(false);
		lblExito.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblExito.setHorizontalAlignment(SwingConstants.CENTER);
		lblExito.setForeground(new Color(0, 255, 0));
		lblExito.setBounds(520, 350, 120, 100);
		MetricaEER.add(lblExito);
		
		JToggleButton tglbtnBMI = new JToggleButton("BMI");
		tglbtnBMI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnBMI.isSelected()) {
		            CalculadoraGUI_BMI ventana_BMI = new CalculadoraGUI_BMI();
		            ventana_BMI.setVisible(true);
		            dispose();
				}
			}
		});
		tglbtnBMI.setBackground(new Color(108, 193, 162));
		bgMetricas.add(tglbtnBMI);
		tglbtnBMI.setFont(new Font("Tahoma", Font.BOLD, 12));
		tglbtnBMI.setBounds(20, 140, 82, 20);
		MetricaEER.add(tglbtnBMI);
		
		JToggleButton tglbtnIBW = new JToggleButton("IBW");
		tglbtnIBW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnIBW.isSelected()) {
		            CalculadoraGUI_IBW ventana_IBW = new CalculadoraGUI_IBW();
		            ventana_IBW.setVisible(true);
		            dispose();
		        }
		    }
			
		});
		tglbtnIBW.setBackground(new Color(108, 193, 162));
		bgMetricas.add(tglbtnIBW);
		tglbtnIBW.setFont(new Font("Tahoma", Font.BOLD, 12));
		tglbtnIBW.setBounds(20, 180, 82, 20);
		MetricaEER.add(tglbtnIBW);
		
		JToggleButton tglbtnEER = new JToggleButton("REE");
		tglbtnEER.setBackground(new Color(108, 193, 162));
		tglbtnEER.setSelected(true);
		bgMetricas.add(tglbtnEER);
		tglbtnEER.setFont(new Font("Tahoma", Font.BOLD, 12));
		tglbtnEER.setBounds(20, 220, 82, 20);
		MetricaEER.add(tglbtnEER);
		
		JButton btnCalcular = new JButton("CALCULAR");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					lblExito.setVisible(false);
					lblError.setVisible(false);
					lblTipoError.setText("");
					tfResultado_EER.setText("");
					
					double altura = Double.parseDouble(tfAltura_EER.getText());
					double peso = Double.parseDouble(tfPeso_EER.getText());
					int edad = Integer.parseInt(tfEdad_EER.getText());
					
					String sexo = comboSexo_EER.getSelectedItem().toString();
					
					String actividad = "";
		            if (rdbtnSedentario.isSelected()) actividad = "Sedentario";
		            else if (rdbtnLigero.isSelected()) actividad = "Ligero";
		            else if (rdbtnModerado.isSelected()) actividad = "Moderado";
		            else if (rdbtnActivo.isSelected()) actividad = "Activo";
		            else if (rdbtnMuyActivo.isSelected()) actividad = "Muy Activo";
					
					HealthCalc calc = new HealthCalcImpl();
					double resultado = calc.eer(sexo, edad, peso, altura, actividad);
					tfResultado_EER.setText(String.format("%.2f", resultado));
					lblExito.setVisible(true);
					
			} catch (InvalidHealthDataException ex) {
				lblError.setVisible(true);
				lblTipoError.setText(ex.getMessage());
				tfResultado_EER.setText("ERROR");
				 
			} catch (NumberFormatException ex) {
				lblError.setVisible(true);
				lblTipoError.setText("Datos incompletos/Uso de caracteres no numéricos");
				tfResultado_EER.setText("ERROR");
				
			} catch (Exception ex) {
				lblError.setVisible(true);
				lblTipoError.setText("Fallo inesperado");
				tfResultado_EER.setText("ERROR");
				
				}
			}
		});
		btnCalcular.setBackground(new Color(108, 193, 162));
		btnCalcular.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCalcular.setBounds(520, 150, 120, 100);
		MetricaEER.add(btnCalcular);
		
		JButton btnInicio = new JButton("VOLVER");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculadoraGUI_Inicio Menu = new CalculadoraGUI_Inicio();
				Menu.setVisible(true);
				dispose();
			}
		});
		btnInicio.setBackground(new Color(108, 193, 162));
		btnInicio.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnInicio.setBounds(520, 20, 120, 40);
		MetricaEER.add(btnInicio);
	}
}
