# language: es

Característica: Cálculo del Peso Corporal Ideal (PCI/IBW)

  Como usuario de la calculadora de salud
  Quiero conocer mi peso ideal según mi altura y sexo
  Para tener una referencia de mi estado de salud

    Antecedentes:
        Dado que la calculadora de salud está operativa

    @PrioridadAlta
    Escenario: Cálculo correcto del IBW con datos válidos

        Dado que introduzco mi sexo "masculino"
        Y introduzco mi altura "175"
        Cuando solicito calcular el peso corporal ideal
        Entonces el sistema muestra el peso ideal para mi menor riesgo de mortalidad y mejor salud

    @Error
    Escenario: Intento de cálculo con datos incompletos
        
        Dado que no he introducido todos los datos requeridos
        Cuando solicito calcular el peso corporal ideal
        Entonces el sistema muestra un mensaje de error indicando datos incompletos
    
    @Error
    Escenario: Datos introducidos fuera de rango

        Dado que introduzco un sexo "desconocido"
        Y introduzco una altura "-5"
        Cuando solicito calcular el peso corporal ideal
        Entonces el sistema informa que los datos no son válidos
    
    @Calculo @Regresion
    Esquema del escenario: Cálculo del IBW según características del usuario

        Dado que introduzco mi sexo "<sexo>"
        Y introduzco mi altura "<altura>"
        Cuando solicito calcular el peso corporal ideal
        Entonces el sistema calcula el <resultado> correctamente

        Ejemplos:
          | sexo      | altura | resultado |
          | masculino | 175    | 68,75     |
          | femenino  | 165    | 57,5      |
          | masculino | 180    | 72,5      |
          | femenino  | 160    | 55,0      |