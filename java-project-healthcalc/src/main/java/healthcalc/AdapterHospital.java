package healthcalc;

public class AdapterHospital implements HealthHospital {

    private HealthCalcImpl calc;

    public AdapterHospital(HealthCalcImpl calc) {
        this.calc = calc;
    }
    
    @Override
    public Tuple<Float, String> indiceMasaCorporal(float altura, int peso) {
        try {
            // Adaptación: Gramos a Kilos
            double pesoKilos = peso / 1000.0;
            double alturaMetros = (double) altura;

            Person persona = new PersonImpl((float) pesoKilos, (float) alturaMetros, null, 25, null);  

            double bmi = calc.basalMetabolicIndex(persona);
            BMICategory category = calc.category(persona);

            return new Tuple<>((float) bmi, category.toString());
        } catch (Exception e) {
            throw new RuntimeException("Error calculating BMI", e);
        }
    }

    @Override
    public int pesoCorporalIdeal(char genero, float altura) {
        try {
            Gender genderEnum;

            if (genero == 'm' || genero == 'M') {
                genderEnum = Gender.MALE;
            } else if (genero == 'f' || genero == 'F') {
                genderEnum = Gender.FEMALE;
            } else {
                throw new IllegalArgumentException("Sexo no válido. Use 'm' para masculino o 'f' para femenino.");
            }
            // Adaptación: Centímetros a Metros
            double alturaMetros = altura * 100.0;

            Person persona = new PersonImpl(70.0f, (float) alturaMetros, genderEnum, 25, null);
            double pesocorporalIdeal = calc.idealBodyWeight(persona);

            return (int) pesocorporalIdeal;

        } catch (Exception e) {
            throw new RuntimeException("Error calculating Ideal Body Weight", e);
        }
    }
}
