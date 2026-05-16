package healthcalc;

public class English extends BaseDecoratorLanguage {
    public English(HealthHospital healthHospital) {
        super(healthHospital);
    }


    @Override
    public Tuple<Float, String> indiceMasaCorporal(float altura, int peso) {
        return healthHospital.indiceMasaCorporal(altura, peso);
    }

    @Override
    public int pesoCorporalIdeal(char genero, float altura) {
        char gender;
        if (genero == 'M') {
            gender = 'H';
        } else if (genero == 'F') {
            gender = 'M';
        } else {
            throw new IllegalArgumentException("Invalid gender. Please use 'M' or 'F'.");
        }
        return healthHospital.pesoCorporalIdeal(gender, altura);
    }

}