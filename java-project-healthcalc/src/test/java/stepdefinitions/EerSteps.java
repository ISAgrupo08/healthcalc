package stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import healthcalc.HealthCalc;
import healthcalc.HealthCalcImpl;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

public class EerSteps {
    private HealthCalc healthcalc;
    private String sexo;
    private int edad;
    private double peso;
    private double altura;
    private String actividad;
    private double eer;
    private boolean exceptionThrown;

    @Dado("que la calculadora de salud se encuentra operativa")
    public void operativa() {
        this.healthcalc = new HealthCalcImpl();
    }

    @Dado("que introduzco el sexo {string}")
    public void introduzco_el_sexo(String Sexo) { 
        this.sexo = Sexo;
    }

    @Dado("introduzco la edad {int}")
    public void la_edad_introducida_es(Integer Edad) {
        this.edad = Edad;
    }

    @Dado("introduzco el peso {double}")
    public void introduzco_el_peso(Double Peso) {
        this.peso = Peso;
    }

    @Dado("introduzco la altura {double}")
    public void introduzco_la_altura(Double Altura) {
        this.altura = Altura;
    }

    @Dado("selecciono el nivel de actividad {string}")
    public void selecciono_un_nivel_de_actividad(String Actividad) {
        this.actividad = Actividad;
    }

    @Dado("que no he introducido todos los datos requeridos")
    public void datos_incompletos() {
        this.sexo = null;
    }

    @Cuando("solicito calcular el requerimiento energético estimado")
    public void calcular() {
        try {
            this.eer = healthcalc.eer(sexo, edad, peso, altura, actividad);
            exceptionThrown = false;
        } catch (Exception e) {
            exceptionThrown = true;
        }
    }

    @Entonces("el resultado debe ser {double}")
    public void el_resultado_debe_ser(Double esperado) {
        assertEquals(esperado, this.eer, 1.0);
    }

    @Entonces("el sistema informa que los datos no son válidos")
    public void el_sistema_informa_que_los_datos_no_son_validos() {
        assertEquals(true, exceptionThrown, "Se esperaba una excepción por datos fuera de rango");
}
    
    @Entonces("el sistema muestra las calorías diarias recomendadas")
    public void el_sistema_muestra_las_calorías_diarias_recomendadas() {
        assertEquals(false, exceptionThrown);
    }

    @Entonces("el sistema muestra un mensaje de error indicando datos incompletos")
    public void el_sistema_muestra_un_mensaje_de_error_indicando_datos_incompletos() {
        assertEquals(true, exceptionThrown);
    }

    
}
