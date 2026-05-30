package healthcalc;

import healthcalc.exceptions.InvalidHealthDataException;



public class HealthCalcImpl implements BasalMetabolicIndex {

    // Implementación del patrón Singleton
    private static HealthCalcImpl instance;

    private HealthCalcImpl() {
        // Constructor privado. Vacío porque no se necesita inicialización adicional.
    }
    
    public static HealthCalcImpl getInstance() {
        if (instance == null) {
            instance = new HealthCalcImpl();
        }
        return instance;
    }

    public float basalMetabolicIndex(Person person) throws InvalidHealthDataException {
        double weight = person.weight();
        double height = person.height();
        if (weight <= 0) {
            throw new InvalidHealthDataException("Weight must be positive.");
        }
        if (height <= 0) {
            throw new InvalidHealthDataException("Height must be positive.");
        }
        if (weight < 1 || weight > 700) {
            throw new InvalidHealthDataException("Weight must be within a possible biological range [1-700] kg.");
        }
        if (height < 0.30 || height > 3.00) {
            throw new InvalidHealthDataException("Height must be within a possible biological range [0.30-3.00] m.");
        }
        return (float) (weight / Math.pow(height, 2)); 
    }

    public BMICategory category(Person person) throws InvalidHealthDataException {
        double bmi = basalMetabolicIndex(person);
        // Tratamos los posibles errores
        if (bmi < 0) {
            throw new InvalidHealthDataException("BMI must be a positive value.");
        }
        if (bmi > 150) {
            throw new InvalidHealthDataException("BMI must be within a possible biological range [0-150].");
        }
        for (BMICategory category : BMICategory.values()) {
            if (bmi >= category.getMin() && bmi < category.getMax()) {
                return category;
            }
        }
        throw new InvalidHealthDataException("BMI value is out of any defined category range.");
    }
}