package healthcalc;

import java.util.Scanner;

import healthcalc.exceptions.InvalidHealthDataException;

public class main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HealthCalc healthCalc = new HealthCalcImpl();

        try {
            // ===== (Entrada de datos) =====
            System.out.println("=== Calculadora de BMI ===");

            System.out.print("Introduce el peso en kg (ej: 70,50): ");
            double weight = scanner.nextDouble();

            System.out.print("Introduce la altura en metros (ej: 1,75): ");
            double height = scanner.nextDouble();

            // ===== (Cálculo) =====
            double bmi = healthCalc.bmi(weight, height);
            String classification = healthCalc.bmiClassificationFull(bmi);

            // ===== (Salida) =====
            System.out.println("\n--- Resultado ---");
            System.out.printf("BMI calculado: %.2f%n", bmi);
            System.out.println("Clasificación: " + classification);

        } catch (InvalidHealthDataException e) {
            System.out.println("\nError en los datos introducidos: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\nEntrada inválida. Por favor introduce valores numéricos.");
        } finally {
            scanner.close();
        }
    }
}