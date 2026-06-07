package healthcalc;

import healthcalc.exceptions.InvalidHealthDataException;



public class HealthCalcImpl implements HealthCalc {
    
    @Override
    public String bmiSimpleClassification(double bmi) throws InvalidHealthDataException {
        if (bmi < 0) {
            throw new InvalidHealthDataException("BMI cannot be negative.");
        }
        if (bmi > 150) {
            throw new InvalidHealthDataException("BMI must be within a possible biological range [0-150].");
        }
        String result = "Obesity";
        // if (bmi < 18.5) {
        //     result = "Underweight";
        // } else if (bmi >= 18.5 && bmi < 25) {
        //     result = "Normal weight";
        // } else if (bmi >= 25 && bmi < 30) {
        //     result = "Overweight";
        // }
        if (bmi < 18.5) {
            result = "Underweight";
        } else if (bmi < 25) {
            result = "Normal weight";
        } else if (bmi < 30) {
            result = "Overweight";
        }
        return result;
    }

    @Override
    public String bmiClassification(double bmi) throws InvalidHealthDataException {
        if (bmi < 0) {
            throw new InvalidHealthDataException("BMI cannot be negative.");
        }
        if (bmi > 150) {
            throw new InvalidHealthDataException("BMI must be within a possible biological range [0-150].");
        }
        String result = "";
        if (bmi < 16) {
            result = "Severe Thinness";
        } else if (bmi >= 16 && bmi < 17) {
            result = "Moderate Thinness";
        } else if (bmi >= 17 && bmi < 18.5) {
            result = "Mild Thinness";
        } else if (bmi >= 18.5 && bmi < 25) {
            result = "Normal";
        } else if (bmi >= 25 && bmi < 30) {
            result = "Overweight";
        } else if (bmi >= 30 && bmi < 35) {
            result = "Obese Class I";
        } else if (bmi >= 35 && bmi < 40) {
            result = "Obese Class II";
        } else if (bmi >= 40) {
            result = "Obese Class III";
        }
        return result;
    }

    @Override
    public double bmi(double weight, double height) throws InvalidHealthDataException {
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
            throw new InvalidHealthDataException("Height must be within a possible biological range [30-300] cm.");
        }
        return weight / Math.pow(height, 2);
    }
    
    @Override
    public double bmrKatchMcArdle(double weight, double bodyFatPercentage)
        throws InvalidHealthDataException {

    if (weight <= 0)
        throw new InvalidHealthDataException("Peso inválido");

    if (bodyFatPercentage < 0 || bodyFatPercentage > 1)
        throw new InvalidHealthDataException("Porcentaje de grasa inválido");

    double leanMass = weight * (1 - bodyFatPercentage);
    return 370 + (21.6 * leanMass);
    }

    @Override
    public double ibwLorentz(double height,char gender) throws InvalidHealthDataException {

        if (height <= 0) {
            throw new InvalidHealthDataException("Height must be positive.");
        }

        if (height < 30 || height > 250) {
            throw new InvalidHealthDataException("Height must be within a possible biological range [30-250] cm.");
        }
        if (gender == 'm') {
            return (height - 100) - ((height - 150) / 4.0);
        } else if (gender == 'f') {
            return (height - 100) - ((height - 150) / 2.0);
        } else {
            throw new InvalidHealthDataException("Gender must be 'm' or 'f'.");
        }
    }

    @Override
    public double eer(String sexo, int edad, double peso, double altura, String actividad) throws InvalidHealthDataException {
        
        if (sexo == null || actividad == null) {
            throw new InvalidHealthDataException("Datos incompletos.");
        }
        if (edad < 0 || peso <= 0 || altura <= 30 || edad > 130 || peso > 700 || altura > 300) {
            throw new InvalidHealthDataException("Datos fuera de rango.");
        }

        double resultado;
        if (sexo.equalsIgnoreCase("masculino")) {
            resultado = 88.362 + (13.397 * peso) + (4.799 * altura) - (5.677 * edad);
        } else if (sexo.equalsIgnoreCase("femenino")) {
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
        return resultado * factorActividad;
    
    }
}
