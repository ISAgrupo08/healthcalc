package healthcalc;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import healthcalc.exceptions.InvalidHealthDataException;

/**
 * Tests para la métrica BMR usando la fórmula de Katch-McArdle.
 * 
 * Fórmula:
 * BMR = 370 + (21.6 × masaMagra)
 * masaMagra = peso × (1 - %grasa)
 */

@DisplayName("Tests para BMR - Katch McArdle")
public class BMRKatchMcArdleTest {

    private HealthCalc healthCalc;

    @BeforeEach
    void setUp() {
        healthCalc = new HealthCalcImpl();
    }

    @Nested
    @DisplayName("Cálculo del BMR con fórmula Katch-McArdle")
    class BmrMetricTests {

        @Test
        @DisplayName("Cálculo correcto con valores estándar válidos")
        void testBmrValido() throws InvalidHealthDataException {
            // Arrange
            double weight = 70.0;
            double bodyFat = 0.15;
            double leanMass = 70.0 * (1 - 0.15);
            double expected = 370 + (21.6 * leanMass);

            // Act
            double result = healthCalc.bmrKatchMcArdle(weight, bodyFat);

            // Assert
            assertEquals(expected, result, 0.01);
        }

        @Test
        @DisplayName("Cálculo correcto cuando el porcentaje de grasa es 0%")
        void testBmrGrasaCero() throws InvalidHealthDataException {
            double weight = 70.0;
            double bodyFat = 0.0;

            double expected = 370 + (21.6 * 70.0);

            double result = healthCalc.bmrKatchMcArdle(weight, bodyFat);

            assertEquals(expected, result, 0.01);
        }

        @ParameterizedTest(name = "Peso inválido: {0} kg")
        @ValueSource(doubles = {-10.0, 0.0})
        @DisplayName("Bloqueo de pesos negativos o cero")
        void testPesoInvalido(double weight) {
            double bodyFat = 0.15;

            assertThrows(InvalidHealthDataException.class,
                    () -> healthCalc.bmrKatchMcArdle(weight, bodyFat));
        }

        @ParameterizedTest(name = "Porcentaje de grasa inválido: {0}")
        @ValueSource(doubles = {-0.1, -0.01})
        @DisplayName("Bloqueo de porcentaje de grasa negativo")
        void testPorcentajeGrasaNegativo(double bodyFat) {
            double weight = 70.0;

            assertThrows(InvalidHealthDataException.class,
                    () -> healthCalc.bmrKatchMcArdle(weight, bodyFat));
        }

        @ParameterizedTest(name = "Porcentaje de grasa mayor que 100%: {0}")
        @ValueSource(doubles = {1.01, 1.5, 2.0})
        @DisplayName("Bloqueo de porcentaje de grasa superior a 1 (100%)")
        void testPorcentajeGrasaMayorQueUno(double bodyFat) {
            double weight = 70.0;

            assertThrows(InvalidHealthDataException.class,
                    () -> healthCalc.bmrKatchMcArdle(weight, bodyFat));
        }

        @Test
        @DisplayName("Bloqueo simultáneo de múltiples valores inválidos")
        void testMultiplesValoresInvalidos() {
            assertAll(
                () -> assertThrows(InvalidHealthDataException.class,
                        () -> healthCalc.bmrKatchMcArdle(-70, 0.15)),
                () -> assertThrows(InvalidHealthDataException.class,
                        () -> healthCalc.bmrKatchMcArdle(70, -0.2)),
                () -> assertThrows(InvalidHealthDataException.class,
                        () -> healthCalc.bmrKatchMcArdle(0, 1.5))
            );
        }
    }
}


