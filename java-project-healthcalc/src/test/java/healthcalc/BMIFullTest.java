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
 * Tests for the HealthCalc interface.
 * 
 * Use the AAA pattern (Arrange, Act, Assert) for the tests.
 * 
 * @author ISA
 */
@DisplayName("Tests para la calculadora de salud.")
public class BMIFullTest {

	private HealthCalc healthCalc;

	@BeforeEach
	void setUp() {
		healthCalc = new HealthCalcImpl();
	}

    @Nested
    @DisplayName("Métrica del BMI")
    class BMIMetricTests {

        @Test
        @DisplayName("Cálculo de BMI con valores estándar válidos")
        void testBmiValido() throws InvalidHealthDataException {
            double weight = 70.0;
            double height = 1.75;
            double expectedBmi = 70.0 / Math.pow(1.75, 2);

            double result = healthCalc.bmi(weight, height);

            assertEquals(expectedBmi, result, 0.01);
        }

        @Test
        @DisplayName("Lanzar excepción cuando el peso es cero")
        void testBmiPesoCero() {
            assertThrows(InvalidHealthDataException.class, () -> healthCalc.bmi(0, 170));
        }

        @Test
        @DisplayName("Lanzar excepción cuando la altura es cero")
        void testBmiAlturaCero() {
            assertThrows(InvalidHealthDataException.class, () -> healthCalc.bmi(70, 0));
        }

        @Test
        @DisplayName("Lanzar excepción cuando los valores son negativos")
        void testBmiNegativos() {
            assertAll(
                () -> assertThrows(InvalidHealthDataException.class, () -> healthCalc.bmi(-70, 170)),
                () -> assertThrows(InvalidHealthDataException.class, () -> healthCalc.bmi(70, -170))
            );
        }

        @ParameterizedTest(name = "Peso mínimo inválido: {0} kg")
        @ValueSource(doubles = {-10.0, 0.0, 0.99})
        @DisplayName("Bloqueo de pesos inferiores al límite biológico mínimo (1 kg)")
        void testPesoMinimoImposible(double weight) {
            double height = 170.0;
            
            assertThrows(InvalidHealthDataException.class, () -> healthCalc.bmi(weight, height));
        }

        @ParameterizedTest(name = "Peso máximo inválido: {0} kg")
        @ValueSource(doubles = {700.1, 1000.0, 5000.0})
        @DisplayName("Bloqueo de pesos superiores al límite biológico máximo (700 kg)")
        void testPesoMaximoImposible(double weight) {
            double height = 170.0;
            
            assertThrows(InvalidHealthDataException.class, () -> healthCalc.bmi(weight, height));
        }

        @ParameterizedTest(name = "Altura mínima inválida: {0} m")
        @ValueSource(doubles = {-0.50, 0.0, 0.29})
        @DisplayName("Bloqueo de alturas inferiores al límite biológico mínimo (30 m)")
        void testAlturaMinimaImposible(double height) {
            double weight = 70.0;
            
            assertThrows(InvalidHealthDataException.class, () -> healthCalc.bmi(weight, height));
        }

        @ParameterizedTest(name = "Altura máxima inválida: {0} m")
        @ValueSource(doubles = {3.01, 3.50, 5.00})
        @DisplayName("Bloqueo de alturas superiores al límite biológico máximo (300 m)")
        void testAlturaMaximoImposible(double height) {
            double weight = 70.0;
            
            assertThrows(InvalidHealthDataException.class, () -> healthCalc.bmi(weight, height));
        }
    }

	@Nested
    @DisplayName("Clasificación básica a partir del BMI")
    class BMIFullClassificationTests {

        @ParameterizedTest(name = "BMI {0} debe ser clasificado como Severe Thinness")
        @ValueSource(doubles = {10.0, 15.9})
        @DisplayName("Validación de categoría Severe Thinness (Delgadez severa)")
        void testBmiSevereThinness(double bmi) throws InvalidHealthDataException {
            String expected = "Severe Thinness";

            String result = healthCalc.bmiClassificationFull(bmi);

            assertEquals(expected, result);
        }

        @ParameterizedTest(name = "BMI {0} debe ser clasificado como Moderate Thinness")
        @ValueSource(doubles = {16.0, 16.5, 16.99})
        @DisplayName("Validación de categoría Moderate Thinness (Delgadez moderada)")
        void testBmiModerateThinness(double bmi) throws InvalidHealthDataException {
            String expected = "Moderate Thinness";

            String result = healthCalc.bmiClassificationFull(bmi);

            assertEquals(expected, result);
        }

        @ParameterizedTest(name = "BMI {0} debe ser clasificado como Mild Thinness")
        @ValueSource(doubles = {17.0, 17.8, 18.4})
        @DisplayName("Validación de categoría Mild Thinness (Delgadez leve)")
        void testBmiMildThinness(double bmi) throws InvalidHealthDataException {
            String expected = "Mild Thinness";

            String result = healthCalc.bmiClassificationFull(bmi);

            assertEquals(expected, result);
        }

        @ParameterizedTest(name = "BMI {0} debe ser clasificado como Normal")
        @ValueSource(doubles = {18.5, 22.0, 24.9})
        @DisplayName("Validación de categoría Normal")
        void testBmiNormal(double bmi) throws InvalidHealthDataException {
            String expected = "Normal";

            String result = healthCalc.bmiClassificationFull(bmi);

            assertEquals(expected, result);
        }

        @ParameterizedTest(name = "BMI {0} debe ser clasificado como Overweight")
        @ValueSource(doubles = {25.0, 27.5, 29.99})
        @DisplayName("Validación de categoría Overweight (Sobrepeso)")
        void testBmiOverweight(double bmi) throws InvalidHealthDataException {
            String expected = "Overweight";

            String result = healthCalc.bmiClassificationFull(bmi);

            assertEquals(expected, result);
        }

        @ParameterizedTest(name = "BMI {0} debe ser clasificado como Obese Class I")
        @ValueSource(doubles = {30.0, 32.5, 34.99})
        @DisplayName("Validación de categoría Obese Class I")
        void testBmiObeseClassI(double bmi) throws InvalidHealthDataException {
            String expected = "Obese Class I";

            String result = healthCalc.bmiClassificationFull(bmi);

            assertEquals(expected, result);
        }

        @ParameterizedTest(name = "BMI {0} debe ser clasificado como Obesse Class II")
        @ValueSource(doubles = {35.0, 37.5, 39.99})
        @DisplayName("Validación de categoría Obese Class II")
        void testBmiObeseClassII(double bmi) throws InvalidHealthDataException {
            String expected = "Obese Class II";

            String result = healthCalc.bmiClassificationFull(bmi);

            assertEquals(expected, result);
        }

        @ParameterizedTest(name = "BMI {0} debe ser clasificado como Obesse Class III")
        @ValueSource(doubles = {40.0, 45.0, 60.0})
        @DisplayName("Validación de categoría Obese Class III")
        void testBmiObeseClassIII(double bmi) throws InvalidHealthDataException {
            String expected = "Obese Class III";

            String result = healthCalc.bmiClassificationFull(bmi);

            assertEquals(expected, result);
        }


        @ParameterizedTest(name = "BMI mínimo inválido: {0}")
        @ValueSource(doubles = {-50.0, -1.0, -0.01})
        @DisplayName("Bloqueo de valores de BMI negativos (Error de entrada)")
        void testBmiClassificationMinimoImposible(double bmi) {
            assertThrows(InvalidHealthDataException.class, () -> healthCalc.bmiClassificationFull(bmi));
        }

        @ParameterizedTest(name = "BMI máximo extremo: {0}")
        @ValueSource(doubles = {150.1, 200.0, 500.0})
        @DisplayName("Bloqueo de valores de BMI superiores al límite humano razonable (150)")
        void testBmiClassificationMaximoImposible(double bmi) {
            assertThrows(InvalidHealthDataException.class, () -> healthCalc.bmiClassificationFull(bmi));
        }

    }

}
