package stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import healthcalc.HealthCalc;
import healthcalc.HealthCalcImpl;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

public class BMIFullSteps {
    private HealthCalc healthcalc;
    private double weight;
    private double height;
    private double bmi;
    private String resultado;
    private boolean exceptionThrown;
    @Dado("la calculadora de salud está iniciada")
    public void la_calculadora_de_salud_está_iniciada() {
        this.healthcalc = new HealthCalcImpl();
    }

    @Dado("el peso introducido es {double}")
    public void el_peso_introducido_es(double double1) {
        this.weight = double1;
    }
    @Dado("la altura introducida es {double}")
    public void la_altura_introducida_es(double double1) {
            this.height = double1;

    }
    @Cuando("ejecuto la operación de BMI")
    public void ejecuto_la_operación_de_BMI() {
        try {
              this.bmi = healthcalc.bmi(weight, (height/100.0));
            this.resultado = healthcalc.bmiClassification(this.bmi);
            exceptionThrown = false;
        } catch (Exception e) {
            exceptionThrown = true;
        }
    }
    @Entonces("el bmi debe ser {double}")
    public void el_bmi_debe_ser(double double1) {
         // El 0.01 es el margen de error. 
        // Dice: "Si la diferencia es menor a 0.01, acéptalo como válido".
        assertEquals(double1, bmi, 0.01);
    }
    @Entonces("el resultado debe ser {string}")
    public void el_resultado_debe_ser(String String1) {
         assertEquals(String1, this.resultado);
    }
    @Entonces("el sistema debe lanzar una excepción")
    public void el_sistema_debe_lanzar_una_excepción() {
        assertEquals(true, exceptionThrown);
    }

}