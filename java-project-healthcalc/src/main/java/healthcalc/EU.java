package healthcalc;

public class EU extends BaseDecoratorRegion {
    public EU(HealthHospital calc) {
        super(calc);
    }

    @Override
    public Tuple<Float, String> indiceMasaCorporal(float altura, int peso) {

        float alturaM = altura / 100; // Paso de centímetros a metros
        int pesoKg = peso / 1000; // Paso de gramos a kg

        Tuple<Float, String> result = super.indiceMasaCorporal(alturaM, pesoKg);
        float bmi = result.getFirst();
        String classification = result.getSecond();

        return new Tuple<>(bmi, classification);
    }
    
    @Override
    public int pesoCorporalIdeal(char genero, float altura) {
        float alturaM = altura / 100; // Paso de centímetros a metros

        int idealWeight = super.pesoCorporalIdeal(genero, alturaM);
        return idealWeight;
    }
}