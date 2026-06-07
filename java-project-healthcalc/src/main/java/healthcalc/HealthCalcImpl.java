package healthcalc;

import healthcalc.exceptions.InvalidHealthDataException;



public class HealthCalcImpl implements BasalMetabolicIndex, IdealBodyWeight, EstimatedEnergyRequirement {

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
        float bmi = this.basalMetabolicIndex(person); 
        
        if (bmi < 0) {
            throw new InvalidHealthDataException("El BMI no puede ser negativo.");
        }
        if (bmi > 150) {
            throw new InvalidHealthDataException("El BMI debe estar dentro de un rango posible [0-150].");
        }
        
        if (bmi < 16.0f) {
            return BMICategory.SEVERE_THINNESS;
        } else if (bmi < 17.0f) {
            return BMICategory.MODERATE_THINNESS;
        } else if (bmi < 18.5f) {
            return BMICategory.MILD_THINNESS;
        } else if (bmi < 25.0f) {
            return BMICategory.NORMAL;
        } else if (bmi < 30.0f) {
            return BMICategory.OVERWEIGHT;
        } else if (bmi < 35.0f) {
            return BMICategory.OBESE_CLASS_I;
        } else if (bmi < 40.0f) {
            return BMICategory.OBESE_CLASS_II;
        } else {
            return BMICategory.OBESE_CLASS_III;
        }
    }

    public float idealBodyWeight(Person person) throws InvalidHealthDataException {
        double height = person.height();
        Gender gender = person.gender();
        if (height <= 0) {
            throw new InvalidHealthDataException("Height must be positive.");
        }
        if (height < 30 || height > 250) {
            throw new InvalidHealthDataException("Height must be within a possible biological range [30-250] cm.");
        }
        if (gender == Gender.MALE) {
            return (float) ((height - 100) - ((height - 150) / 4.0));
        } else if (gender == Gender.FEMALE) {
            return (float) ((height - 100) - ((height - 150) / 2.0));
        } else {
            throw new InvalidHealthDataException("Gender must be either MALE or FEMALE.");
        }
    }

    public float estimatedEnergyRequirement(Person person) throws InvalidHealthDataException {

        if (person == null || person.gender() == null || person.activity() == null) {
            throw new InvalidHealthDataException("Datos incompletos.");
        }

        double peso = person.weight();
        double altura = person.height();
        int edad = person.age();
        String actividad = person.activity();
        
        if (edad < 0 || peso <= 0 || altura <= 30 || edad > 130 || peso > 700 || altura > 300) {
            throw new InvalidHealthDataException("Datos fuera de rango.");
        }

        double resultado;
        if (person.gender() == Gender.MALE) {
            resultado = 88.362 + (13.397 * peso) + (4.799 * altura) - (5.677 * edad);
        } else if (person.gender() == Gender.FEMALE) {
            resultado = 447.593 + (9.247 * peso) + (3.098 * altura) - (4.330 * edad);
        } else {
            throw new InvalidHealthDataException("Sexo debe ser 'masculino' o 'femenino'.");
        }
        double factorActividad;
        switch (actividad.toLowerCase()) {
            case "sedentario":
            case "sedentaria":
                factorActividad = 1.2;
                break;
            case "ligero":
            case "ligera":
                factorActividad = 1.375;
                break;
            case "moderado":
            case "moderada":
                factorActividad = 1.55;
                break;
            case "activo":
            case "activa":
                factorActividad = 1.725;
                break;
            case "muy activo":
            case "muy activa":
                factorActividad = 1.9;
                break;
            default:
                throw new InvalidHealthDataException("Nivel de actividad no reconocido.");
        }
        return (float) (resultado * factorActividad);    
    }
}