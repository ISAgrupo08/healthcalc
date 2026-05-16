package healthcalc;

public class BaseDecoratorLanguage implements HealthHospital {
    protected HealthHospital healthHospital;

    public BaseDecoratorLanguage(HealthHospital healthHospital) {
        this.healthHospital = healthHospital;
    }

    @Override
    public Tuple<Float, String> indiceMasaCorporal(float altura, int peso) {
        return healthHospital.indiceMasaCorporal(altura, peso);
    }

    @Override
    public int pesoCorporalIdeal(char genero, float altura) {
        return healthHospital.pesoCorporalIdeal(genero, altura);
    }

}