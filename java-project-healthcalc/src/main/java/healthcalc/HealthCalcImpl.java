package healthcalc;

import healthcalc.exceptions.InvalidHealthDataException;



public class HealthCalcImpl implements HealthCalc {

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
    public String bmiClassificationFull(double bmi) throws InvalidHealthDataException {
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
            throw new InvalidHealthDataException("Height must be within a possible biological range [0.30-3.00] m.");
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
}
