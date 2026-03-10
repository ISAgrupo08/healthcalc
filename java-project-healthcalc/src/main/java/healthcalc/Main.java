package healthcalc;

import healthcalc.exceptions.InvalidHealthDataException;
import java.util.Scanner;
/**
 * Clase principal para ejecutar la calculadora de salud.
 * 
 * Aquí se puede implementar una interfaz de usuario simple en la consola
 * para interactuar con el usuario y mostrar los resultados de las métricas.
 * 
 * @author ISA
 */


public class main {
    public static void main(String[] args) {
        // 1. Creamos el objeto de nuestra calculadora
        HealthCalc healthCalc = new HealthCalcImpl();
        // 2. Preparamos el Scanner para leer del teclado (System.in)
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("=== CALCULADORA DE SALUD Y PESO ===");

            // --- ENTRADA DE DATOS ---
            System.out.print("Ingrese su altura en cm: ");
            double height = scanner.nextDouble();

            System.out.print("Ingrese su peso en kg: ");
            double weight = scanner.nextDouble();

            System.out.print("Ingrese tu porcentaje de grasa corporal (%): ");
            double bodyFatPercentage = scanner.nextDouble();

            // --- LÍNEA CLAVE PARA ARREGLAR EL ERROR ---
            scanner.nextLine(); // Esto limpia el "Enter" que quedó suelto
            // ------------------------------------------

            System.out.print("Ingrese su sexo (m para masculino, f para femenino): ");
            char sex = scanner.next().charAt(0);

            System.out.println("\n--- RESULTADOS ---");

            // --- CALCULAMOS LAS MÉTRICAS ---
            
            // --- 1. CÁLCULO DEL BMI (IMC) ---
            // Dividimos height por 100 para pasar de cm a metros
            double bmi = healthCalc.bmi(weight, height / 100.0); 
            System.out.printf("Índice de Masa Corporal (BMI): %.2f\n", bmi);

            // --- 2. CLASIFICACIÓN DEL BMI ---
            String bmiClassification = healthCalc.bmiClassification(bmi);
            System.out.println("Clasificación del BMI: " + bmiClassification);

            // --- 3. CÁLCULO DEL BMR (KATCH-MCARDLE) ---
            // Pasamos de entero a decimal para el porcentaje de grasa corporal
            double bmr = healthCalc.bmrKatchMcArdle(weight, bodyFatPercentage/100.0);
            System.out.printf("Tasa Metabólica Basal (BMR): %.2f kcal/día\n", bmr);

            // --- 4. CÁLCULO DEL IBW (LORENTZ) ---
            double ibw = healthCalc.ibwLorentz(height, sex);
            System.out.printf("Peso Ideal (IBW): %.2f kg\n", ibw);

        } catch(InvalidHealthDataException e) {
            //Aquellos errores relacionados con datos de salud inválidos, como peso o altura negativos, o porcentajes de grasa fuera de rango.
            System.out.println("Error en los datos ingresados: " + e.getMessage());
        } catch (Exception e) {
            //Cualquier otro error inesperado que pueda ocurrir durante la ejecución del programa.
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        }
    }
}
