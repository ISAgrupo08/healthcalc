package healthcalc;

public interface HealthHospital {

    // Muestra el índice de masa corporal (BMI) y su clasificación
    Tuple<Float, String> indiceMasaCorporal(float altura, int peso);
    // Calcula el peso corporal ideal 
    int pesoCorporalIdeal(char genero, float altura);
}