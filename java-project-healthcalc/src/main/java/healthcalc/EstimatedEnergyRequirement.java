package healthcalc;

import healthcalc.exceptions.InvalidHealthDataException;

public interface EstimatedEnergyRequirement {

    float estimatedEnergyRequirement(Person person) throws InvalidHealthDataException;
    
}
