package healthcalc;

public class AdapterHospital implements HealthHospital {

    private HealthCalc calc;

    public AdapterHospital(HealthCalc calc) {
        this.calc = calc;
    }
    
    @Override
    public Tuple<Float, String> indiceMasaCorporal(float altura, int peso) {
        try {
            // Adaptación: Gramos a Kilos
            double pesoKilos = peso / 1000.0;

            double alturaMetros = (double) altura;

            double bmi = calc.bmi(pesoKilos, alturaMetros);
            String classification = calc.bmiClassification(bmi);

            return new Tuple<>((float) bmi, classification);
        } catch (Exception e) {
            throw new RuntimeException("Error calculating BMI", e);
        }
    }

    @Override
    public int pesoCorporalIdeal(char genero, float altura) {
        try {
            // Adaptación: Centímetros a Metros
            double alturaMetros = altura * 100.0;
            double pesocorporalIdeal = calc.ibwLorentz(alturaMetros, genero);

            return (int) pesocorporalIdeal;

        } catch (Exception e) {
            throw new RuntimeException("Error calculating Ideal Body Weight", e);
        }
    }
}
