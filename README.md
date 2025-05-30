# RETO 1:

Deseamos escribir un informe realizando recortes de una revista publicada y uniendo estos recortes. Antes de hacer esto, le gustaría saber si es posible escribir su informe usando una determinada revista.
Escriba una función en Java que tenga como entrada dos cadenas de caracteres; la primera de ellas será la nota que deseamos escribir y la segunda cadena de caracteres será el texto completo de la revista que poseemos. La función debe determinar si la nota puede ser escrita con la revista dada.

Por favor, explica cómo tu función determinará la respuesta en términos de longitud del informe (n) y de la revista (m)


==============================================================================================================

# EXPLICACIÓN:
La longitud del informe es sacado gracias a la cantidad de, ya sea, letras o palabras que estén en cada texto.
Esto quiere decir, que si en el informe aparecen una cantidad de, por ejemplo, 18 palabras, de las cuales, 10 de ellas
tienen más de 5 apariciones, entonces, esto quiere decir que la cantidad de la revista, tiene que ser igual o mayor a estas
apariciones para que pueda ser escrito el informe.

En el caso de que se utilicen palabras, se deben de contar con la misma cantidad de palabras necesarias para poder
construir el respectivo informe.

Por lo tanto, si la cantidad de la revista, tanto en letras o en palabras, no satisface la cantidad de la nota, entonces no será
posible escribir el informe deseado.

==============================================================================================================
