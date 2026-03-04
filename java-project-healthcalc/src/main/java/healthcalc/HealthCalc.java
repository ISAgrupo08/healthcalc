package healthcalc;

import healthcalc.exceptions.InvalidHealthDataException;

/**
 * Calculator of some health parameters of persons.
 * 
 * @author ISA
 *
 */	
public interface HealthCalc {
	
	/**
	 * Calculate the BMI classification of a person.
	 * The BMI classification is based on the following table:
	 * Underweight: BMI < 18.5
	 * Normal weight: 18.5 <= BMI < 25
	 * Overweight: 25 <= BMI < 30
	 * Obesity: BMI >= 30
	 *
	 * @param bmi	Body Mass Index of the person (kg/m2).
	 * @return	  	The BMI classification of the person.
	 * @throws Exception
	 */
	public String bmiClassification(double bmi) throws InvalidHealthDataException;

	/**
	 * Calculate the BMI classification of a person.
	 * The BMI classification is based on the following table:
	 * Severe Thinness BMI < 16
	 * Moderate Thinness 16 <= BMI < 17
	 * Mild Thinness  17 <= BMI < 18.5
	 * Normal 18.5 <= BMI < 25
	 * Overweight 25 <= BMI < 30
	 * Obese Class I 30 <= BMI < 35
	 * Obese Class II 35 <= BMI < 40
	 * Obese Class III BMI >= 40
	 *
	 * @param bmi	Body Mass Index of the person (kg/m2).
	 * @return	  	The BMI classification of the person.
	 * @throws Exception
	 */
	public String bmiClassificationFull(double bmi) throws InvalidHealthDataException;
	
	/**
	 * Calculate the Body Mass Index (BMI) of a person with the Harris-Benedict formula:
	 *
	 * @param weight	Weight of the person (kg).
	 * @param height 	Height of the person (cm).
	 * @return	  		The Body Mass Index of the person (kg/m2).
	 * @throws Exception
	 */
	public double bmi(double weight, double height) throws InvalidHealthDataException;


	/**
	 * Calculate the Basal Metabolic Rate (BMR) of a person with the Katch-McArdle formula:
	 * 
	 * @param weight			Weight of the person (kg).
	 * @param bodyFatPercentage	Body fat percentage of the person (0.0 to 1.0).
	 * @return					The Basal Metabolic Rate of the person (kcal/day).
	 * @throws InvalidHealthDataException
	 */
	public double bmrKatchMcArdle(double weight, double bodyFatPercentage) throws InvalidHealthDataException;

	/**
	 * Calculate the Ideal Body Weight (IBW) of a person with the Lorentz formula:
	 * @param height 	Height of the person (cm).
	 * @return	  		The Ideal Body Weight of the person (kg).	
	 * @throws InvalidHealthDataException
	 * Fórmula:
	 * IBW = (altura - 100) - ((altura - 150) / 4) para hombres
	 * IBW = (altura - 100) - ((altura - 150) / 2) para mujeres
	 */

    public double ibwLorentz(double height,char gender) throws InvalidHealthDataException;

}
