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

import healthcalc.HealthCalc;
import healthcalc.HealthCalcImpl;
import healthcalc.exceptions.InvalidHealthDataException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;

public class CalculadoraGUI_BMI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textResultadoBMI;
	private JTextField textResultadoClasificacion;
	private JTextField textFieldAltura;
	private JTextField textFieldPeso;
	private final ButtonGroup bgMetricas = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadoraGUI_BMI frame = new CalculadoraGUI_BMI();
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
	public CalculadoraGUI_BMI() {
		
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
		
		JPanel panelDatos = new JPanel();
		panelDatos.setBackground(new Color(108, 193, 162));
		panelDatos.setLayout(null);
		panelDatos.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0)), "DATOS", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 128, 0)));
		panelDatos.setBounds(30, 25, 350, 200);
		panelMetricaContainer.add(panelDatos);
		
		JLabel lblAltura_IBW_1 = new JLabel("Altura(cm)");
		lblAltura_IBW_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltura_IBW_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAltura_IBW_1.setBounds(0, 60, 120, 30);
		panelDatos.add(lblAltura_IBW_1);
		
		textFieldAltura = new JTextField();
		textFieldAltura.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldAltura.setColumns(10);
		textFieldAltura.setBounds(130, 60, 150, 30);
		panelDatos.add(textFieldAltura);
		
		JLabel lblsexo_IBW_1 = new JLabel("Peso(kg)");
		lblsexo_IBW_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblsexo_IBW_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblsexo_IBW_1.setBounds(0, 130, 120, 30);
		panelDatos.add(lblsexo_IBW_1);
		
		textFieldPeso = new JTextField();
		textFieldPeso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldPeso.setColumns(10);
		textFieldPeso.setBounds(130, 130, 150, 30);
		panelDatos.add(textFieldPeso);
		
		JPanel panelResultados = new JPanel();
		panelResultados.setBackground(new Color(108, 193, 162));
		panelResultados.setBounds(30, 225, 350, 150);
		panelMetricaContainer.add(panelResultados);
		panelResultados.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0)), "RESULTADOS", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 128, 0)));
		panelResultados.setLayout(null);
		
		JLabel lblBmi = new JLabel("bmi:");
		lblBmi.setBounds(0, 40, 120, 30);
		panelResultados.add(lblBmi);
		lblBmi.setHorizontalAlignment(SwingConstants.CENTER);
		lblBmi.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblClasificacin = new JLabel("Clasificación:");
		lblClasificacin.setBounds(10, 90, 110, 30);
		panelResultados.add(lblClasificacin);
		lblClasificacin.setHorizontalAlignment(SwingConstants.CENTER);
		lblClasificacin.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textResultadoBMI = new JTextField();
		textResultadoBMI.setEditable(false);
		textResultadoBMI.setBounds(130, 40, 150, 30);
		panelResultados.add(textResultadoBMI);
		textResultadoBMI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textResultadoBMI.setColumns(10);
		
		textResultadoClasificacion = new JTextField();
		textResultadoClasificacion.setEditable(false);
		textResultadoClasificacion.setBounds(130, 90, 150, 30);
		panelResultados.add(textResultadoClasificacion);
		textResultadoClasificacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textResultadoClasificacion.setColumns(10);
		
		JLabel lblTipoError = new JLabel("");
		lblTipoError.setForeground(new Color(255, 0, 0));
		lblTipoError.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoError.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTipoError.setBounds(10, 380, 380, 50);
		panelMetricaContainer.add(lblTipoError);
		
		JLabel lblExito = new JLabel("ÉXITO");
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
		
		JToggleButton tglbtnBMI = new JToggleButton("BMI");
		tglbtnBMI.addMouseListener(new MouseAdapter() {
			
		});
		tglbtnBMI.setSelected(true);
		bgMetricas.add(tglbtnBMI);
		tglbtnBMI.setFont(new Font("Tahoma", Font.BOLD, 12));
		tglbtnBMI.setBackground(new Color(108, 193, 162));
		tglbtnBMI.setBounds(20, 140, 82, 20);
		contentPane.add(tglbtnBMI);
		
		JToggleButton tglbtnIBW = new JToggleButton("IBW");
		tglbtnIBW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculadoraGUI_IBW ventana_IBW = new CalculadoraGUI_IBW();
				ventana_IBW.setVisible(true);
				dispose();
			}
		});
		bgMetricas.add(tglbtnIBW);
		tglbtnIBW.setFont(new Font("Tahoma", Font.BOLD, 12));
		tglbtnIBW.setBackground(new Color(108, 193, 162));
		tglbtnIBW.setBounds(20, 180, 82, 20);
		contentPane.add(tglbtnIBW);
		
		JToggleButton tglbtnEER = new JToggleButton("REE");
		tglbtnEER.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculadoraGUI_Eer ventana_EER= new CalculadoraGUI_Eer();
				ventana_EER.setVisible(true);
				dispose();
			}
		});
		bgMetricas.add(tglbtnEER);
		tglbtnEER.setFont(new Font("Tahoma", Font.BOLD, 12));
		tglbtnEER.setBackground(new Color(108, 193, 162));
		tglbtnEER.setBounds(20, 220, 82, 20);
		contentPane.add(tglbtnEER);
		
		JButton btnCalcular = new JButton("CALCULAR");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Reseteamos
					lblExito.setVisible(false);
	                lblError.setVisible(false);
	                lblTipoError.setText("");
	                textResultadoBMI.setText("");
	                textResultadoClasificacion.setText("");
	                //Obtener datos
	                String strAltura = textFieldAltura.getText();
	                String strPeso = textFieldPeso.getText();
	                
	                // 3. Validar que no estén vacíos antes de parsear
	                if (strAltura.isEmpty() || strPeso.isEmpty()) {
	                    throw new Exception("Campos vacíos");
	                }
	                double peso = Double.parseDouble(strPeso);
	             // Convertimos la altura de cm a metros para que HealthCalcImpl no lance excepción de rango
	                double alturaCm = Double.parseDouble(strAltura);
	                double alturaMetros = alturaCm / 100.0;
	                
                    HealthCalc calc = new HealthCalcImpl();
                    double bmi = calc.bmi(peso, alturaMetros);
                    String clasificacion = calc.bmiClassification(bmi);
                    
                    // Mostrar resultado
                    textResultadoBMI.setText(String.format("%.2f", bmi));
                    textResultadoClasificacion.setText(clasificacion);
                    lblExito.setVisible(true);
				
				} catch (NumberFormatException ex) {
		            // Error al convertir texto a número (letras, símbolos...)
		            lblError.setVisible(true);
		            lblTipoError.setText("Utilice solo caracteres numéricos. Use el punto en lugar de la coma.");
		        } catch (InvalidHealthDataException ex) {
		            // Errores de lógica (peso < 0, altura fuera de rango biológico, etc.)
		            lblError.setVisible(true);
		            textResultadoBMI.setText("");
		            textResultadoClasificacion.setText("");
		            lblTipoError.setText(ex.getMessage());
		        } catch (Exception ex) {
		            // Cualquier otro error
		            lblError.setVisible(true);
		            textResultadoBMI.setText("");
		            textResultadoClasificacion.setText("");
		            lblTipoError.setText("Fallo inesperado");
		        }
			}
		});
		btnCalcular.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCalcular.setBackground(new Color(108, 193, 162));
		btnCalcular.setBounds(520, 150, 120, 100);
		contentPane.add(btnCalcular);
		
		JLabel lblMtricaBmi = new JLabel("MÉTRICA BMI");
		lblMtricaBmi.setHorizontalAlignment(SwingConstants.CENTER);
		lblMtricaBmi.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMtricaBmi.setBounds(100, 45, 400, 30);
		contentPane.add(lblMtricaBmi);
		
		JButton btnInicio = new JButton("VOLVER");
		btnInicio.setBackground(new Color(108, 193, 162));
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculadoraGUI_Inicio Menu = new CalculadoraGUI_Inicio();
				Menu.setVisible(true);
				dispose();
			}
		});
		btnInicio.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnInicio.setBounds(520, 20, 120, 40);
		contentPane.add(btnInicio);

	}
}