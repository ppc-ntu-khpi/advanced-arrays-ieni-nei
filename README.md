# Практична робота "Поглиблене використання масивів"
## Завдання:
1. Заповніть квадратну матрицю заданого порядку N простими числами з вказаного діапазону і виведіть її 
Цей репозиторій містить iнструкції та стартовий код для виконання практичної роботи з теми.

Результат:

![image](https://github.com/ppc-ntu-khpi/advanced-arrays-ieni-nei/assets/113203792/4a8ebf69-5c9a-4ca4-981e-dd3f355b99be)

Код:

```Main.java```:
```java
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

```

```Matrix.java```:
```java
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

```
