/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kramer;

/**
 *
 * @author Jordy
 */
public class KramerOP {
    public static float[] solveSystem(float[][] A, float[] b) {
        int n = A.length;
        float[] x = new float[n];

        float detA = Determinate.calcularDeterminante(A);

        for (int i = 0; i < n; i++) {
            float[][] Ai = KramerOP.replaceColumnWithVector(A, b, i);
            float detAi = Determinate.calcularDeterminante(Ai);
            x[i] = detAi / detA;
        }
        
        return x;
    }
    public static float[][] replaceColumnWithVector(float[][] matrix, float[] vector, int columnIndex) {
    int numRows = matrix.length;

    if (numRows != vector.length || columnIndex < 0 || columnIndex >= matrix[0].length) {
        throw new IllegalArgumentException("La matriz y el vector deben tener dimensiones compatibles, y el índice de columna debe estar dentro de los límites de la matriz.");
    }

    float[][] result = new float[numRows][matrix[0].length];

    for (int i = 0; i < numRows; i++) {
        for (int j = 0; j < matrix[0].length; j++) {
            if (j == columnIndex) {
                result[i][j] = vector[i]; // Reemplazar la columna con el vector.
            } else {
                result[i][j] = matrix[i][j];
            }
        }
    }

    return result;
}
}
