# HealthCalc
Bienvenido al proyecto de la asignatura de **Ingeniería del Software Avanzada**.

El [Hospital Universitario Virgen de la Victoria (El Clínico)](https://www.sspa.juntadeandalucia.es/servicioandaluzdesalud/hospital/virgen-victoria/) de Málaga nos ha encargado el desarrollo de una **Calculadora de Salud** (**_HealthCalc_**) que permita calcular diferentes métricas de los pacientes.

## Requisitos

### Requisitos Funcionales

### Requisitos No Funcionales
- Todo el código de la aplicación (incluido los comentarios) deben estar en inglés.

## Métricas de HealthCalc

### Métricas Antropométricas

* **M1: Índice de Masa Corporal (IMC) o _Body Mass Index (BMI)_:** El IMC es es un indicador estándar, adoptado por la [Organización Mundial de la Salud (OMS)](https://www.who.int/es), que evalúa la adecuación del peso de una persona en relación con su altura para estimar la grasa corporal.

    * **Fórmula:** $IMC = \frac{\text{peso (kg)}}{\text{altura (m)}^2}$

    El IMC nos permite clasificar el estado nutricional de una persona en categorías. La OMS ha definido la siguiente clasificación estándar del estado nutricional en adultos:

      - Bajo peso ($<18.5$)
      - Normal ($18.5-24.9$)
      - Sobrepeso ($25-29.9$)
      - Obesidad ($\ge 30$)

![Clasificación del estado nutricional de una persona.](resources/images/bmi.jpeg =300x)

---

* **M2: Peso Corporal Ideal (PCI) o _Ideal Body Weight (IBW)_:** El PCI estima el peso teórico que se asocia con el menor riesgo de mortalidad y una mejor salud para un persona.

    Existen diferentes fórmulas para calcular el PCI:

    1. **Fórmula de Devine (1974)**
    Es la más extendida en entornos clínicos para ajustar dosis de medicamentos.

        - **Hombres:** 50 kg + [2.3 × (estatura en pulgadas - 60)]
        - **Mujeres:** 45.5 kg + [2.3 × (estatura en pulgadas - 60)]

    2. **Fórmula de Robinson (1983)**
    Es una variante de Devine más precisa, dando valores más bajos en mujeres y más altos en hombres. 

        - **Hombres:** 52 kg + [1.9 × (estatura en pulgadas - 60)]
        - **Mujeres:** 49 kg + [1.7 × (estatura en pulgadas - 60)]

    3. **Fórmula de Hamwi (1964)**
    Fórmula clásica utilizada por dietistas y nutricionistas debido a su sencillez.

        - **Hombres:** 48.1 kg + [2.7 × (estatura en pulgadas - 60)]
        - **Mujeres:** 45.4 kg + [2.2 × (estatura en pulgadas - 60)]

    4. **Fórmula de Lorentz (1929)**
    Es la fórmula más sencilla de aplicar manualmente ya que utiliza directamente la estatura en centímetros y no requiere conversiones a pulgadas.

        - **Hombres:** $PCI = (Estatura en cm - 100) - \frac{Estatura - 150}{4}$
        - **Mujeres:** $PCI = (Estatura en cm - 100) - \frac{Estatura - 150}{2}$

    **Nota:** Para convertir la estatura de **cm a pulgadas**, hay que dividir los centímetros entre **2.54**.

---

* **M3: Área de Superficie Corporal (ASC) o _Body Surface Area (BSA)_:** El ASC es una medida clínica utilizada para calcular dosis precisas de medicamentos, especialmente en quimioterapia y fluidos intravenosos, y para evaluar la severidad de quemaduras.

    La fórmula más común es la de **Mosteller**:

    * **Fórmula (Mosteller):** $BSA = \sqrt{\frac{\text{altura (cm)} \times \text{peso (kg)}}{3600}}$    

---

### Métricas Metabólicas y Nutricionales

* **M4: Tasa Metabólica Basal (TMB) o _Basal Metabolic Rate (BMR)_:** El TMB calcula la cantidad mínima de energía (calorías) que el cuerpo necesita en reposo absoluto. 

    Existen diferentes fórmulas para calcular el PCI:

    1. **Ecuación de Mifflin-St Jeor**
    Es actualmente la más precisa para la población general y la que utilizan la mayoría de calculadoras modernas. 

        - **Hombres:**  `TMB = (10 × peso en kg) + (6.25 × altura en cm) - (5 × edad en años) + 5`
        - **Mujeres:**  `TMB = (10 × peso en kg) + (6.25 × altura en cm) - (5 × edad en años) - 161`

    2. **Ecuación de Harris-Benedict (revisada)**
    Es el método clásico. La versión original de 1919 fue revisada en 1984 por Roza y Shizgal para mejorar su exactitud.

        - **Hombres:**  `TMB = 88.362 + (13.397 × peso en kg) + (4.799 × altura en cm) - (5.677 × edad en años)`
        - **Mujeres:**  `TMB = 447.593 + (9.247 × peso en kg) + (3.098 × altura en cm) - (4.330 × edad en años)`

    3. **Ecuación de Katch-McArdle**
    A diferencia de las anteriores, esta fórmula no distingue entre sexos, sino que utiliza la Masa Corporal Magra (peso sin grasa). Es ideal si conoces tu porcentaje de grasa corporal.
        - `TMB = 370 + (21.6 × Masa Corporal Magra en kg)`
            > **Nota:** Masa Magra = Peso total × (1 - % de grasa decimal)

    4. **Ecuación de la OMS (FAO/WHO/UNU)**
    Utilizada a menudo en estudios de salud pública, divide el cálculo por rangos de edad específicos: 

        | Edad (Años) | Hombres | Mujeres |
        | :--- | :--- | :--- |
        | **18 – 30** | `(15.057 × peso) + 692.2` | `(14.818 × peso) + 486.6` |
        | **30 – 60** | `(11.472 × peso) + 873.1` | `(8.126 × peso) + 845.6` |
        | **> 60** | `(11.711 × peso) + 587.7` | `(9.082 × peso) + 658.5` |

---

* **M5: Gasto Energético Diario Total (GEDT) o _Total Daily Energy Expenditure (TDEE)_:** El TDEE es la cantidad total de calorías que el cuerpo quema en 24 horas. Suma el metabolismo basal (funciones vitales en reposo), la actividad física, la digestión y el movimiento cotidiano. Es esencial para ajustar la nutrición (perder, ganar o mantener peso).

    Para obtener las calorías totales que quemas al día, multiplica tu **TMB** por tu nivel de actividad:

    - **Sedentario** (poco/nada de ejercicio): `TMB × 1.2`
    - **Ligero** (ejercicio 1-3 días/semanas): `TMB × 1.375`
    - **Moderado** (ejercicio 3-5 días/semana): `TMB × 1.55`
    - **Fuerte** (ejercicio 6-7 días/semana): `TMB × 1.725`
    - **Muy fuerte** (atleta o trabajo físico pesado): `TMB × 1.9`

---

### Métricas Clínicas y Cardiovasculares
Requieren datos de signos vitales o resultados de laboratorio.

* **Presión Arterial Media (PAM):** Indica la eficacia de la perfusión de los órganos vitales.
    * **Fórmula:** $PAM = \frac{PAS + 2(PAD)}{3}$
* **Tasa de Filtración Glomerular Estimada (eGFR):** Evalúa la función renal (Fórmulas CKD-EPI o Cockcroft-Gault).
* **Escala NEWS2 (National Early Warning Score):** Sistema de puntuación para detectar deterioro clínico agudo basado en 7 parámetros fisiológicos.

---

## 4. Consideraciones Técnicas de Ingeniería de Software

Para que el proyecto cumpla con estándares de software médico, se deben incluir:

1.  **Validación de Rangos (Data Scrubbing):**
    * *Hard Limits:* Bloquear entradas imposibles (ej. altura de 3 metros).
    * *Soft Limits:* Avisos ante valores inusuales pero posibles.
2.  **Soporte Multi-unidad:** Conversión automática entre sistema métrico (kg, cm) e imperial (lb, ft/in).
3.  **Gestión de Errores:** Manejo de excepciones en divisiones por cero (ej. altura 0 en IMC).
4.  **Privacidad (Compliance):** Si el software almacena datos, debe considerar la anonimización de la Información Personal Identificable (PII) bajo normativas como GDPR o HIPAA.

---