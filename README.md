  
  https://github.com/Javier1609/practica_final_parte_2.git


1. [Descripción del Proyecto](#descripcion-del-proyecto)
2. [Características del Proyecto](#caracteristicas-del-proyecto)
3. [Simulaciones de Montecarlo](#simulaciones-de-montecarlo)
4. [Funcionalidades de la Aplicación](#funcionalidades-de-la-aplicacion)
5. [Visualización de Resultados](#visualizacion-de-resultados)

<a name="descripcion-del-proyecto"></a>
## Descripción del Proyecto

El proyecto que hemos desarrollado es una aplicación de simulación para biólogos que trabajan con poblaciones de bacterias. La aplicación permite a los biólogos modelar y simular experimentos con diferentes poblaciones de bacterias, variando parámetros como la duración del experimento, la cantidad de comida disponible para las bacterias y el patrón de suministro de comida.

<a name="caracteristicas-del-proyecto"></a>
## Características del Proyecto

Los experimentos pueden durar diferentes cantidades de días, y la cantidad de comida disponible para las bacterias se mide en microgramos, con un máximo de 300,000 microgramos. Los biólogos pueden elegir entre varios patrones de suministro de comida, incluyendo un suministro constante, un incremento lineal seguido de un decremento lineal, y un patrón alterno donde se suministra comida un día y no se suministra al siguiente.

Además de modelar y simular estos experimentos, la aplicación también permite a los biólogos ordenar sus experimentos por fecha de inicio, nombre de la población de bacterias y número de bacterias en la población. Esto facilita la gestión de múltiples experimentos y permite a los biólogos encontrar rápidamente la información que necesitan.

<a name="simulaciones-de-montecarlo"></a>
## Simulaciones de Montecarlo

Una característica clave de la aplicación es su capacidad para realizar simulaciones de Montecarlo. Estas simulaciones utilizan números aleatorios y una serie de reglas para modelar la evolución de las poblaciones de bacterias a lo largo del tiempo. Las bacterias se colocan inicialmente en el centro de un plato de cultivo, y la simulación modela su comportamiento diario, incluyendo su movimiento, alimentación y reproducción.

Las simulaciones de Montecarlo son especialmente útiles para los biólogos porque les permiten prever cómo se desarrollará un experimento antes de realizarlo en el laboratorio. Esto puede ayudar a los biólogos a optimizar sus experimentos y a anticipar posibles problemas.

<a name="funcionalidades-de-la-aplicacion"></a>
## Funcionalidades de la Aplicación

La aplicación permite a los biólogos realizar las siguientes acciones:

1. Abrir un archivo que contenga un experimento
2. Crear un nuevo experimento
3. Crear una población de bacterias y añadirla al experimento actual
4. Visualizar los nombres de todas las poblaciones de bacterias del experimento actual
5. Borrar una población de bacterias del experimento actual
6. Ver información detallada de una población de bacterias del experimento actual
7. Realizar y visualizar la simulación correspondiente con una de las poblaciones de bacterias del experimento.
8. Guardar (se supone que para usar esta opción previamente hemos abierto un archivo)
9. Guardar como

<a name="visualizacion-de-resultados"></a>
## Visualización de Resultados

Finalmente, la aplicación permite a los biólogos visualizar los resultados de sus simulaciones. Los resultados se muestran en una matriz que representa el plato de cultivo, con diferentes colores que indican el número de bacterias en cada celda. Esto proporciona una representación visual intuitiva de la distribución y evolución de las poblaciones de bacterias.
