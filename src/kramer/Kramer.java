/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package kramer;

import java.util.Scanner;

/**
 *
 * @author Jordy
 */
public class Kramer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Indique el sistema de ecuaciones por resolver (n x n): ");
        System.out.println("Cuantas variables tiene el sitema: ");
        int n = scanner.nextInt();
        float[][] matrix = new float[n][n + 1];
        
        System.out.print("""
                         Ingrese los elementos de la matriz en el formato: 
                         \u00b1x \u00b1y =..\u00b1n
                         \u00b1x \u00b1y =..\u00b1n
                          :  :     
                         \u00b1n \u00b1n =  \u00b1n
                         """);
        scanner.nextLine();
        float[] vector = new float[n];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] values = line.split("\\s+");

            for (int j = 0; j < n + 1; j++) {
                matrix[i][j] = Integer.parseInt(values[j]); 
            }
            vector[i] = matrix[i][n];
        }
        
        System.out.println("Matriz:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); 
        }
        
        System.out.println("Vector:");
        for(int i = 0; i < n; i++){
            System.out.print(vector[i] + " ");
        }
        System.out.println();
        scanner.close();
        float[] results = KramerOP.solveSystem(matrix, vector);
        for (float r : results) {
            System.out.print(r + " ");
        }
    }
 
}
