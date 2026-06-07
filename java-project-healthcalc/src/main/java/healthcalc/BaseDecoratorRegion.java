package healthcalc;

public class BaseDecoratorRegion implements HealthHospital {
    protected HealthHospital calc;

    public BaseDecoratorRegion(HealthHospital calc) {
        this.calc = calc;
    }

    @Override
    public Tuple<Float, String> indiceMasaCorporal(float altura, int peso) {
        return calc.indiceMasaCorporal(altura, peso);
    }

    @Override
    public int pesoCorporalIdeal(char genero, float altura) {
        return calc.pesoCorporalIdeal(genero, altura);
    }
}