/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kramer;

/**
 *
 * @author Jordy
 */
public class Determinate {
    
    public static float calcularDeterminante(float[][] A) {
        float n = A.length;
        
        if (n == 1) {
            return A[0][0];
        }

        if (n == 2) {
            return (A[0][0] * A[1][1]) - (A[0][1] * A[1][0]);
        }
        
        float determinante = 0;
        
        for (int i = 0; i < n; i++) {

            float cofactor = A[0][i] * calcularDeterminante(obtenerSubmatriz(A, 0, i));
            
            if (i % 2 == 0) {
                determinante += cofactor;
            } else {
                determinante -= cofactor;
            }
        }
        
        return determinante;
    }
    
    private static float[][] obtenerSubmatriz(float[][] matriz, float fila, float columna) {
        int n = matriz.length;
        float[][] submatriz = new float[n - 1][n - 1];
        int r = 0, c = 0;
        
        for (int i = 0; i < n; i++) {
            if (i == fila) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (j == columna) {
                    continue;
                }
                submatriz[r][c] = matriz[i][j];
                c++;
            }
            r++;
            c = 0;
        }
        
        return submatriz;
    }
}
