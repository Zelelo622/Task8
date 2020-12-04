package ru.vsu.num11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);;
        int actionSelection = readInteger("1 to rotate the columns or 2 to rotate the rows: ");
        int n = readInteger("the number of shifts --> ");

        /*try {
            scanner = new Scanner(new File(args[0]));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }*/

        int[][] matrix = readMatrix(scanner);
        if (actionSelection == 1) {
            printMatrix(moveColumns(matrix, n));
        } else if (actionSelection == 2) {
            printMatrix(moveRows(matrix, n));
        } else {
            System.out.println("Incorrect option selected");
        }
    }

    private static int[][] moveRows(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int col = 0; col < matrix[0].length; col++) {
                int buffer = matrix[matrix.length - 1][col];
                for (int row = matrix.length - 1; row > 0; row--) {
                    matrix[row][col] = matrix[row - 1][col];
                }
                matrix[0][col] = buffer;
            }
        }
        return matrix;
    }

    private static int[][] moveColumns(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int row = 0; row < matrix.length; row++) {
                int buffer = matrix[row][matrix[0].length - 1];
                for (int col = matrix[0].length - 1; col > 0; col--) {
                    matrix[row][col] = matrix[row][col - 1];
                }
                matrix[row][0] = buffer;
            }
        }
        return matrix;
    }

    private static int[][] readMatrix(Scanner scanner) {
        int row = readInteger("the number of rows in the matrix --> ");
        int col = readInteger("the number of columns in the matrix --> ");
        int[][] matrix = new int[row][col];
        System.out.println("Enter the elements of the matrix:");
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                matrix[r][c] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static int readInteger(String phrase) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter %s", phrase);
        return scanner.nextInt();
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
