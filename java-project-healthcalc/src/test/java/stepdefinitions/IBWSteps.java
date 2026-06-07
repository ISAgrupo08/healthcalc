package stepdefinitions;

import healthcalc.HealthCalcImpl;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IBWSteps {
    private HealthCalcImpl healthcalc;
    private String sexo;    
    private double altura;
    private double resultado;
    private boolean exceptionThrown;

    @Dado("que la calculadora de salud está operativa")
    public void que_la_calculadora_de_salud_está_operativa() {
        this.healthcalc = new HealthCalcImpl();
    }

    @Dado("que introduzco mi sexo {string}")
    public void que_introduzco_mi_sexo(String string) {
        this.sexo = string;
    }

    @Dado("introduzco mi altura {string}")
    public void introduzco_mi_altura(String altura) {
        this.altura = Double.parseDouble(altura);
    }

    @Cuando("solicito calcular el peso corporal ideal")
    public void solicito_calcular_el_peso_corporal_ideal() {
        try {
            this.resultado = healthcalc.ibwLorentz(altura, sexo.toLowerCase().charAt(0));
            exceptionThrown = false;   
        } catch (Exception e) {
            exceptionThrown = true;
        }
    }

    @Entonces("el sistema muestra el peso ideal para mi menor riesgo de mortalidad y mejor salud")
    public void el_sistema_muestra_el_peso_ideal_para_mi_menor_riesgo_de_mortalidad_y_mejor_salud() {
        // Aquí verificamos que el cálculo se haya hecho (sea mayor que 0)
        assert(resultado > 0);
    }


    @Entonces("el sistema calcula el {double} correctamente")
    public void el_sistema_calcula_el_resultado_correctamente(double expected) {
        // El 0.01 es el margen de error. Dice: "Si la diferencia es menor a 0.01, acéptalo como válido".
        assertEquals(expected, resultado, 0.01);
    }

    @Dado("que no he introducido todos los datos requeridos")
    public void que_no_he_introducido_todos_los_datos_requeridos() {
        // Simulamos datos incompletos dejando el sexo vacío o la altura en 0. Aquí optamos por dejar el sexo vacío.
        this.sexo = ""; 
    }

    @Entonces("el sistema muestra un mensaje de error indicando datos incompletos")
    public void el_sistema_muestra_mensaje_error_incompletos() {
        assertTrue(exceptionThrown, "Se esperaba una excepción por datos incompletos");
    }

    @Dado("que introduzco un sexo {string}")
    public void que_introduzco_un_sexo(String string) {
        this.sexo = string;
    }

    @Dado("introduzco una altura {string}")
    public void introduzco_una_altura_error(String altura) {
        this.altura = Double.parseDouble(altura);
    }

    @Entonces("el sistema informa que los datos no son válidos")
    public void el_sistema_informa_que_los_datos_no_son_validos_ibw() {
        assertEquals(true, exceptionThrown);
    }
}
