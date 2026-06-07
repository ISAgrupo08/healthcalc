package healthcalc;

public class PersonImpl implements Person {
    private final double weight;
    private final double height;
    private final Gender gender;
    private final int age;
    private final String activity;

    // El constructor para crear instancias de Person
    public PersonImpl(double weight, double height, Gender gender, int age, String activity) {
        this.weight = weight;
        this.height = height;
        this.gender = gender;
        this.age = age;
        this.activity = activity;
    }

    @Override
    public double weight() {
        return this.weight;
    }

    @Override
    public double height() {
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

    @Override
    public String activity() {
        return this.activity;
    }
}
