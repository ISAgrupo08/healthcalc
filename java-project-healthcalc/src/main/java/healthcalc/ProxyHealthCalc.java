package healthcalc;

public class ProxyHealthCalc implements HealthHospital, HealthStats {

    private final HealthHospital realHospital;

    // Atributos para almacenar las estadísticas

    private HealthCalc calc;
    private float Suma_Altura = 0;
    private int Contador_Altura = 0;
    private float Suma_Peso = 0;
    private int Contador_Peso = 0;
    private float Suma_IMC = 0;
    private int Contador_IMC = 0;
    private int NumHombres = 0;
    private int NumMujeres = 0;
    private int Total_Pacientes = 0;

    // Constructor

    public ProxyHealthCalc(HealthCalc calc) {
        this.calc = calc;
        this.realHospital = new AdapterHospital(this.calc);
    }

    // Constructor alternativo

    public ProxyHealthCalc(HealthHospital realHospital) {
        this.realHospital = realHospital;
    }

    @Override
    public Tuple<Float, String> indiceMasaCorporal(float altura, int peso) {
        // Cálculo hecho a través del adapter
        Tuple<Float, String> resultado = realHospital.indiceMasaCorporal(altura, peso);
        // Registramos los datos
        this.Suma_Altura += altura;
        this.Contador_Altura++;
        this.Suma_Peso += (peso / 1000.0f);
        this.Contador_Peso++;

        if (resultado != null && resultado.getFirst() != null) {
            this.Suma_IMC += resultado.getFirst();
            this.Contador_IMC++;
        }

        this.Total_Pacientes++;

        return resultado;
    }

    @Override
    public int pesoCorporalIdeal(char genero, float altura) {
        // Cálculo hecho a través del adapter
        int resultado = realHospital.pesoCorporalIdeal(genero, altura);
        // Registro los datos
        this.Suma_Altura += altura;
        this.Contador_Altura++;

        // Control de género
        char g = Character.toUpperCase(genero);
        if (g == 'M') {
            this.NumHombres++;
        } else if (g == 'F') {
            this.NumMujeres++;
        }

        this.Total_Pacientes++;

        return resultado;

    }

    @Override
    public float alturaMedia() {
        if (this.Contador_Altura == 0) {
            return 0;
        }
        return this.Suma_Altura / this.Contador_Altura;

    }

    @Override
    public float pesoMedio() {
        if (this.Contador_Peso == 0) {
            return 0;
        }
        return this.Suma_Peso / this.Contador_Peso;
    }

    @Override
    public float imcMedio() {
        if (this.Contador_IMC == 0) {
            return 0;
        }
        return this.Suma_IMC / this.Contador_IMC;
    }

    @Override
    public int numSexoH() {
        return this.NumHombres;
    }

    @Override
    public int numSexoM() {
        return this.NumMujeres;
    }

    @Override
    public int numTotalPacientes() {
        return this.Total_Pacientes;
    }
}    
