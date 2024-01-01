package com.practice.firstassignment;

/**
 * @author Shrikant_Bhadgaonkar
 * 3.Loop control and decision making
 */
import java.util.Scanner;

public class MatrixCheck {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Get the number of rows and columns for the matrix
        System.out.print("Enter the number of rows for the matrix: ");
        int rows = scanner.nextInt();

        System.out.print("Enter the number of columns for the matrix: ");
        int columns = scanner.nextInt();

        // Create a 2D array to store the matrix
        int[][] matrix = new int[rows][columns];

        // Get the elements of the matrix from the user
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter element at position (" + (i + 1) + ", " + (j + 1) + "): ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Close the scanner to avoid resource leak
        scanner.close();

        // Check and print the type of the matrix
        if (isIdentityMatrix(matrix)) {
            System.out.println("The entered matrix is an Identity Matrix.");
        } else if (isLowerTriangularMatrix(matrix)) {
            System.out.println("The entered matrix is a Lower Triangular Matrix.");
        } else if (isUpperTriangularMatrix(matrix)) {
            System.out.println("The entered matrix is an Upper Triangular Matrix.");
        } else {
            System.out.println("The entered matrix is a General Matrix.");
        }
    }

    // Method to check if the matrix is an Identity Matrix
    private static boolean isIdentityMatrix(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        if (rows != columns) {
            return false; // Identity matrix must be square
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if ((i == j && matrix[i][j] != 1) || (i != j && matrix[i][j] != 0)) {
                    return false;
                }
            }
        }

        return true;
    }

    // Method to check if the matrix is a Lower Triangular Matrix
    private static boolean isLowerTriangularMatrix(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < columns; j++) {
                if (matrix[i][j] != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    // Method to check if the matrix is an Upper Triangular Matrix
    private static boolean isUpperTriangularMatrix(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < i; j++) {
                if (matrix[i][j] != 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
