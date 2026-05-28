package healthcalc;

public class PersonImpl implements Person {
    private final float weight;
    private final float height;
    private final Gender gender;
    private final int age;

    // El constructor para crear instancias de Person
    public PersonImpl(float weight, float height, Gender gender, int age) {
        this.weight = weight;
        this.height = height;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public float weight() {
        return this.weight;
    }

    @Override
    public float height() {
        return this.height;
    }

    @Override
    public Gender gender() {
        return this.gender;
    }

    @Override
    public int age() {
        return this.age;
    }
}
