import java.util.Arrays;

/**
 * Клас для заповнення квадратної матриці простими числами із заданого діапазону.
 */
public class Matrix {

    /**
     * @param matrix Квадратна матриця для заповнення простими числами.
     * @param start Початок діапазону для генерації простих чисел.
     * @param end Кінець діапазону для генерації простих чисел.
     */
    public static void fillMatrix(int[][] matrix, int start, int end) {
        int n = matrix.length;

        // Згенерувати прості числа в заданому діапазоні
        boolean[] isPrime = new boolean[end + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= end; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= end; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Заповнити матрицю простими числами
        int num = start;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                while (num <= end && !isPrime[num]) {
                    num++;
                }
                if (num <= end) {
                    matrix[i][j] = num;
                    num++;
                }
            }
        }
    }
}
