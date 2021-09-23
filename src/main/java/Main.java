import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            //System.out.println(calculate(n));
            //System.out.println(isPalindrom(n));
            /*int[] arr = new int[]{10, 2, 7, 3, 1, 5};
            int[] res = getMinAndMax(arr);
            System.out.println(res[0]);
            System.out.println(res[1]);
            int[] arr1 = new int[]{1, 2, 3, 5};
            int[] arr2 = new int[]{4, 5, 6, 7, 67};
            int[] res = getNewArray(arr1, arr2);
            for (int num : res) System.out.println(num);
             */
            //System.out.println(calculate2(n));
            //System.out.println(calculate4(n));
            int[] arr1 = new int[]{5, 4, 3, 2, 1};
            sortOf(arr1);
            for (int num : arr1) System.out.println(num);

        }
    }

    static int calculate(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }
    /*
     * Исправление №1: String n => int n;
     * Исправление №2: Стоит объявить переменную result перед циклом
     * int result = 1;
     * Также, если есть такая необходимость, можно ввести обработку исключения: n < 0, бросать исключение
     * или возвращать result = -1;
     * Алгоритм считает факториал числа n;
     * Причём, при условии, что n = 0, функция вернёт единицу ( Факториал 0 = 1, всё верно)
     */

    static boolean isPalindrom (int n) {
        char[] nAsString = (""+n).toCharArray();
        int sz = nAsString.length;
        if (sz > 1 && sz % 2 != 0) return false;
        for (int i = 0; i < sz/2; i++) {
            if (nAsString[i] != nAsString[sz-1-i]) return false;
        }
        return true;
    }
    /*
     * Уточнение: Числа вида 1, 2, 4 (1 символ) считаются палиндромом в данной функции.
     * Возможны два исхода функции:
     * 1. Благоприятный исход: длина числа не чётная = > сложность решения 1 (const)
     * 2. Неблагоприятный исход: Длина числа чётная, проверка чисел => сложность решения n/2;
     */

    /**
     * @param arr - Массив чисел
     * @return массив из двух чисел, где:
     * int[0] - Макс. массива
     * int[1] - Мин. массива
     */
    static int[] getMinAndMax (int[] arr) {
        int[] res = new int[2];
        if (arr.length < 1) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        int min = arr[0];
        int max = arr[0];
        for (int i = 1, sz = arr.length; i < sz; i++) {
            if (arr[i] > max) max = arr[i];
            if (arr[i] < min) min = arr[i];
        }
        res[0] = min;
        res[1] = max;
        return res;
    }

    static int[] getNewArray (int[] m1, int[] m2) {
        int m1_sz = m1.length;
        int m2_sz = m2.length;
        int[] res = new int[m1_sz +m2_sz ];
        int i = 0;
        int j = 0;
        int k = 0;
        boolean flag1 = m1[0] > m2[m2_sz - 1];
        boolean flag2 = m2[0] > m1[m1_sz - 1];
        /* Здесь рассматриваем случай, когда все элементы одного массива больше элементов другого массива
         * В таком случае мы можем их не сравнивать, а просто добавить по очереди в новый массив
         * Есть возможность так сделать, т.к. по условию массивы отсортированы
         */
        if (flag1 || flag2) {
            int[] tmp1 = flag1 ? m2 : m1;
            int[] tmp2 = flag1 ? m1 : m2;
            for (int num : tmp1) {
                res[i] = num;
                i++;
            }
            for (int num : tmp2) {
                res[i] = num;
                i++;
            }
        } else {
            for (; i < res.length; i++) {
                if (j >= m1_sz) {
                    res[i] = m2[k];
                    k++;
                } else if (k >= m2_sz) {
                    res[i] = m1[j];
                    j++;
                } else if (m1[j] <m2[k]) {
                    res[i] = m1[j];
                    j++;
                } else {
                    res[i] = m2[k];
                    k++;
                }
            }
        }
        return res;
    }

    static long calculate2(int n) {
        long first = 0;
        long second = 1;
        long result = n;

        for (int i = 1; i < n; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }
    public static long calculate4(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return calculate4(n - 1) + calculate(n - 2);
        }
    }

    static void sortOf(int[] array) {
        boolean flag = false;
        int temp;
        while (!flag) {
            flag = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    flag = false;
                }
            }
        }
    }
}

