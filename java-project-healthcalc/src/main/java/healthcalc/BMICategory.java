package healthcalc;

public enum BMICategory {
    SEVERE_THINNESS("Severe Thinness", 0.0, 15.99),
    MODERATE_THINNESS("Moderate Thinness", 16.0, 16.99),
    MILD_THINNESS("Mild Thinness", 17.0, 18.49),
    NORMAL("Normal", 18.5, 24.99),
    OVERWEIGHT("Overweight", 25.0, 29.99),
    OBESE_CLASS_I("Obese Class I", 30.0, 34.99),
    OBESE_CLASS_II("Obese Class II", 35.0, 39.99),
    OBESE_CLASS_III("Obese Class III", 40.0, 150.0);

    private final String etiqueta;
    private final double min;
    private final double max;

    BMICategory(String etiqueta, double min, double max) {
        this.etiqueta = etiqueta;
        this.min = min;
        this.max = max;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

}