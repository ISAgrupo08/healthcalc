package healthcalc;

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
 * Tests para la métrica IBW usando la fórmula de Lorentz.
 * 
 * Fórmula:
 * Para hombres: IBW = altura (cm) - 100 - ((altura (cm) - 150) / 4)
 * Para mujeres: IBW = altura (cm) - 100 - ((altura (cm) - 150) / 2.5)
 */

@DisplayName("Tests para IBW - Lorentz")
public class IBWLorentzTest {
    private HealthCalc healthCalc;

    @BeforeEach
    void setUp() {
        healthCalc = new HealthCalcImpl();
    }

    @Nested
    @DisplayName("Cálculo del IBW con fórmula de Lorentz")
    class IbwMetricTests {
        @Test
        @DisplayName("Cálculo correcto para hombres con altura estándar")
            void testIbwHombreValido() throws InvalidHealthDataException {
                double height = 180.0;
                double expected = 180 - 100 - ((180 - 150) / 4);
        
                double result = healthCalc.ibwLorentz(height, 'm');
                assertEquals(expected, result, 0.01);
                
            }

        @Test
        @DisplayName("Cálculo correcto para mujeres con altura estándar")
            void testIbwMujerValido() throws InvalidHealthDataException {
                double height = 170.0;
                double expected = height - 100 - ((height - 150) / 2.5);

                double result = healthCalc.ibwLorentz(height, 'f');
                assertEquals(expected, result, 0.01);
            }
        
         @Test
        @DisplayName("Lanzar excepción cuando la altura es cero")
            void testIbwAlturaCero() {
                // Probamos que falla para hombre
                assertThrows(InvalidHealthDataException.class, () -> healthCalc.ibwLorentz(0,'m'));
                // Probamos que falla para mujer
                assertThrows(InvalidHealthDataException.class, () -> healthCalc.ibwLorentz(0,'f'));
            }
        
        @Test
        @DisplayName("Lanzar excepción cuando la altura es negativa")
            void testIbwAlturaNegativa() {
                // Probamos que falla para hombre
                assertThrows(InvalidHealthDataException.class, () -> healthCalc.ibwLorentz(-170,'m'));
                // Probamos que falla para mujer
                assertThrows(InvalidHealthDataException.class, () -> healthCalc.ibwLorentz(-170,'f'));
            }
        
        @Test
        @DisplayName("Lanzar excepción cuando el género no es válido")
            void testIbwGeneroInvalido() {
                // Al pasarle 'x', el código irá al 'else' y lanzará la excepción
                assertThrows(InvalidHealthDataException.class, () -> healthCalc.ibwLorentz(170, 'x'));
            }    
            
        @ParameterizedTest
        @DisplayName("Lanzar excepción para alturas no válidas")
        @ValueSource(doubles = {0.0, -100.0, -170.0})
        void testIbwAlturaInvalida(double height) {
            assertThrows(InvalidHealthDataException.class, () -> healthCalc.ibwLorentz(height,'m'));
            assertThrows(InvalidHealthDataException.class, () -> healthCalc.ibwLorentz(height,'f'));
        }

        @ParameterizedTest
        @DisplayName("Cálculo correcto para una variedad de alturas válidas(hombres)")
        @ValueSource(doubles = {150.0, 160.0, 170.0, 180.0, 190.0})
        void testIbwAlturaValida(double height) throws InvalidHealthDataException {
            double expected = height - 100 - ((height - 150) / 4.0);
            double result = healthCalc.ibwLorentz(height,'m');
            assertEquals(expected, result, 0.01);
        }

        @ParameterizedTest
        @DisplayName("Cálculo correcto para una variedad de alturas válidas (mujeres)")
        @ValueSource(doubles = {150.0, 160.0, 170.0, 180.0, 190.0})
        void testIbwAlturaValidaMujer(double height) throws InvalidHealthDataException {
            double expected = height - 100 - ((height - 150) / 2.0);
            double result = healthCalc.ibwLorentz(height,'f');
            assertEquals(expected, result, 0.01);
        }

        @ParameterizedTest(name = "Altura máxima inválida: {0} m")
        @DisplayName("Bloqueo de alturas superiores al límite biológico máximo (250 cm)")
        @ValueSource(doubles = {250.1, 300.0, 500.0})
        void testIbwAlturaMaximaImposible(double height) {
            assertThrows(InvalidHealthDataException.class, () -> healthCalc.ibwLorentz(height,'m'));
            assertThrows(InvalidHealthDataException.class, () -> healthCalc.ibwLorentz(height,'f'));
        }

        @ParameterizedTest(name = "Altura mínima inválida: {0} m")
        @DisplayName("Bloqueo de alturas inferiores al límite biológico mínimo (30 cm)")
        @ValueSource(doubles = {-0.50, 0.0, 29.9})
        void testIbwAlturaMinimaImposible(double height) {
            assertThrows(InvalidHealthDataException.class, () -> healthCalc.ibwLorentz(height,'m'));
            assertThrows(InvalidHealthDataException.class, () -> healthCalc.ibwLorentz(height,'f'));
        }

        @ParameterizedTest(name = "Altura límite válida para hombres: {0} cm")
        @DisplayName("Cálculo correcto para alturas en el límite biológico(hombres)")
        @ValueSource(doubles = {150.0, 250.0})
        void testIbwAlturaLimiteValida(double height) throws InvalidHealthDataException {
            double expected = height - 100 - ((height - 150) / 4.0);
            double result = healthCalc.ibwLorentz(height,'m');
            assertEquals(expected, result, 0.01);
        }

        @ParameterizedTest(name = "Altura límite válida para mujeres: {0} cm")
        @DisplayName("Cálculo correcto para alturas en el límite biológico (mujeres)")
        @ValueSource(doubles = {150.0, 250.0})
        void testIbwAlturaLimiteValidaMujer(double height) throws InvalidHealthDataException {
            double expected = height - 100 - ((height - 150) / 2.0);
            double result = healthCalc.ibwLorentz(height,'f');
            assertEquals(expected, result, 0.01);
        }

        @ParameterizedTest(name = "Altura con decimales para hombres: {0} cm")
        @DisplayName("Cálculo correcto para alturas con decimales")
        @ValueSource(doubles = {160.5, 175.3, 182.7})
        void testIbwAlturaConDecimales(double height) throws InvalidHealthDataException {
            double expected = height - 100 - ((height - 150) / 4.0);
            double result = healthCalc.ibwLorentz(height,'m');
            assertEquals(expected, result, 0.01);
        }

        @ParameterizedTest(name = "Altura con decimales para mujeres: {0} cm")
        @DisplayName("Cálculo correcto para alturas con decimales (mujeres)")
        @ValueSource(doubles = {160.5, 175.3, 182.7})
        void testIbwAlturaConDecimalesMujer(double height) throws InvalidHealthDataException {
            double expected = height - 100 - ((height - 150) / 2.0);
            double result = healthCalc.ibwLorentz(height,'f');
            assertEquals(expected, result, 0.01);
        }

    
    }   

}
    

       
            
  