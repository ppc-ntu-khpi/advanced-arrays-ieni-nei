/**
 * Клас для тестування заповнення матриці.
 */
public class Main {
    public static void main(String[] args) {
        int N = 4;
        int start = 3;
        int end = 63;

        // Створення матриці
        int[][] matrix = new int[N][N];

        Matrix.fillMatrix(matrix, start, end);

        // Ввивід
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }
}
