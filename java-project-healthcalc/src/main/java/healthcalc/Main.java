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


public class Main {
    public static void main(String[] args) {
        // 1. Creamos el objeto de nuestra calculadora
        // Usar el tipo concreto que devuelve getInstance()
        HealthCalcImpl healthCalc = HealthCalcImpl.getInstance();
        HealthHospital sistemaHospital =new AdapterHospital(healthCalc);
        ProxyHealthCalc Proxy = new ProxyHealthCalc(sistemaHospital);
        HealthHospital HospitalConProxy = Proxy;
        HealthStats Stats = Proxy;


        System.out.println("Patron Adapter");

        try{
            int peso = 80000;
            float altura = 1.80f;
            char sexo = 'm';

            System.out.println("Enviando datos traducidos -> Altura: " + altura + "m, Peso: " + peso + "g, Sexo: " + sexo);

            Tuple<Float, String> resultado = HospitalConProxy.indiceMasaCorporal(altura, peso);
            System.out.println("Resultado del índice de masa corporal: " + resultado.getFirst() + " - " + resultado.getSecond());

            int ibwHospital = HospitalConProxy.pesoCorporalIdeal(sexo, altura);
            System.out.println("Peso corporal ideal según el hospital: " + ibwHospital + " kg");

        } catch (Exception e) {
            System.out.println("Error en el sistema del hospital: " + e.getMessage());
        }

        System.out.println("\nESTADÍSTICAS DEL PROXY");
        System.out.println("Total pacientes: " + Stats.numTotalPacientes());
        System.out.println("Hombres: " + Stats.numSexoH());
        System.out.println("Mujeres: " + Stats.numSexoM());
        System.out.println("Peso medio: " + String.format("%.2f", Stats.pesoMedio()) + " kg");
        System.out.println("Altura media: " + String.format("%.2f", Stats.alturaMedia()) + " m");
        System.out.println("IMC medio: " + String.format("%.2f", Stats.imcMedio()));

    }

    // Aquí podríamos agregar métodos auxiliares para validar la entrada del usuario, formatear resultados, etc.
}
