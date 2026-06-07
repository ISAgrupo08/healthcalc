package healthcalc;

public class USA extends BaseDecoratorRegion {
    public USA(HealthHospital calc) {
        super(calc);
    }

    @Override
    public Tuple<Float, String> indiceMasaCorporal(float alturaPulgadas, int pesoLibras) {
        
        // 1 libra = 0.453592 kg
        float alturaM = (float) (alturaPulgadas * 0.0254);
        // 1 pulgada = 0.0254 metros
        int pesoKg = (int) (pesoLibras / 2.2046);

        Tuple<Float, String> result = super.indiceMasaCorporal(alturaM, pesoKg);
        float bmi = result.getFirst();
        String classification = result.getSecond();

        return new Tuple<>(bmi, classification);
    }

    @Override
    public int pesoCorporalIdeal(char genero, float altura) {
        float idealWeight = super.pesoCorporalIdeal(genero, altura);
        return (int) (idealWeight * 2.2046); // Convertir de kg a libras
    }
}