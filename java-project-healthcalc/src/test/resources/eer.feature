# language: es

Característica: Cálculo del Requerimiento Energético Estimado (EER)

  Como usuario de la calculadora de salud
  Quiero conocer mi requerimiento energético estimado diario
  Para saber cuántas calorías debo consumir según mis características

  Antecedentes:
    Dado que la calculadora de salud se encuentra operativa

  @PrioridadAlta
  Escenario: Cálculo correcto del EER con datos válidos

    Dado que introduzco el sexo "masculino"
    Y introduzco la edad 25
    Y introduzco el peso 70,2
    Y introduzco la altura 175,5
    Y selecciono el nivel de actividad "moderada"
    Cuando solicito calcular el requerimiento energético estimado
    Entonces el resultado debe ser 2680

  @Error
  Escenario: Intento de cálculo con datos incompletos

    Dado que no he introducido todos los datos requeridos
    Cuando solicito calcular el requerimiento energético estimado
    Entonces el sistema muestra un mensaje de error indicando datos incompletos

  @Error
  Escenario: Edad negativa

    Dado que introduzco el sexo "masculino"
    Y introduzco la edad -5
    Y introduzco el peso 33
    Y introduzco la altura 69
    Y selecciono el nivel de actividad "muy activo"
    Cuando solicito calcular el requerimiento energético estimado
    Entonces el sistema informa que los datos no son válidos
  
  @Error
  Escenario: Edad demasiado alta

    Dado que introduzco el sexo "masculino"
    Y introduzco la edad 131
    Y introduzco el peso 69
    Y introduzco la altura 167
    Y selecciono el nivel de actividad "sedentaria"
    Cuando solicito calcular el requerimiento energético estimado
    Entonces el sistema informa que los datos no son válidos

  @Error
  Escenario: Peso negativo

    Dado que introduzco el sexo "femenino"
    Y introduzco la edad 12
    Y introduzco el peso -35
    Y introduzco la altura 137
    Y selecciono el nivel de actividad "ligera"
    Cuando solicito calcular el requerimiento energético estimado
    Entonces el sistema informa que los datos no son válidos

  @Error
  Escenario: Peso demasiado alto

    Dado que introduzco el sexo "femenino"
    Y introduzco la edad 48
    Y introduzco el peso 836
    Y introduzco la altura 172
    Y selecciono el nivel de actividad "sedentario"
    Cuando solicito calcular el requerimiento energético estimado
    Entonces el sistema informa que los datos no son válidos

  @Error
  Escenario: Altura demasiado baja

    Dado que introduzco el sexo "masculino"
    Y introduzco la edad 27
    Y introduzco el peso 85
    Y introduzco la altura 23
    Y selecciono el nivel de actividad "ligera"
    Cuando solicito calcular el requerimiento energético estimado
    Entonces el sistema informa que los datos no son válidos

  @Error
  Escenario: Altura demasiado alta

    Dado que introduzco el sexo "masculino"
    Y introduzco la edad 55
    Y introduzco el peso 77
    Y introduzco la altura 310
    Y selecciono el nivel de actividad "activa"
    Cuando solicito calcular el requerimiento energético estimado
    Entonces el sistema informa que los datos no son válidos

  @Calculo @Regresion
  Esquema del escenario: Cálculo del EER según características del usuario

    Dado que introduzco el sexo "<sexo>"
    Y introduzco la edad <edad>
    Y introduzco el peso <peso>
    Y introduzco la altura <altura>
    Y selecciono el nivel de actividad "<actividad>"
    Cuando solicito calcular el requerimiento energético estimado
    Entonces el resultado debe ser <resultado>

    Ejemplos:
      | sexo      | edad | peso   | altura     | actividad  | resultado   |
      | masculino | 25   | 70,2   | 175,5      | sedentario | 2074        |
      | masculino | 25   | 70     | 175        | moderada   | 2672        |
      | femenino  | 30   | 60     | 165        | activo     | 2386        |
      | femenino  | 45   | 65     | 160        | ligera     | 1855        |