package hw1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Collections;

public class Task5 {
    public static void main(String[] args) {
        /**Задача 1
         Заполните массив на N элементов случайным целыми числами и выведете максимальное,
         минимальное и среднее арифметическое значение элементов массива.*/
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Введите любое положительное целое число");
        int vvod = scanner1.nextInt();
        System.out.println("Вы ввели " + vvod);
        int[] massiv = new int[vvod];
        //Заполняю массив случайными числами.
        int max = massiv[0];
        int min = massiv[0];
        int sum = 0;
        for (int i = 0; i < massiv.length; i++) {
            massiv[i] = (int) (Math.random() * vvod);
            sum += massiv[i];
            if (massiv[i] > max) max = massiv[i];
            else if (massiv[i] < min) min = massiv[i];
            {            }
        }
        System.out.println(Arrays.toString(massiv));
        System.out.println("Максимум: " + max);
        System.out.println("Минимум: " + min);
        System.out.println("Среднее арифметическое значение " + sum / vvod);

        /**Задача 2
         Создайте массив из чётных чисел [2;20] и выведите элементы массива в консоль
         в обратном порядке (20 18 16 ... 4 2).*/
        int[] chetnoe = {20, 18, 16, 14, 12, 10, 8, 6, 4, 2};
        for (int i = chetnoe.length - 1; i >= 0; i--) {
            System.out.print("Результат " + chetnoe[i] + ", ");
        }
        System.out.println("Результат.");
        /**Задача 5
         Задать массив. Отрицательные элементы массива перенести в новый массив.
         Размер массива должен быть равен количеству отрицательных элементов.*/
        //Задал массив.
        int[] nechot = {5, 9, -44, 0, -2, 100, 6, -6, -1,-1};
        System.out.println("Вывод заданного массива " + Arrays.toString(nechot));
        //Отсортировал массив.
        Arrays.sort(nechot);
        System.out.println("Вывод после сортировки " + Arrays.toString(nechot));
        int negative = 0;
        //Цикл для проверки массива на отрицательное число
        for (int i = 0; i < nechot.length; i++){
            if (nechot[i] < 0){
                negative = negative + 1;
            }
        }

        //Задал массив куда буду копировать.
        int[] newnechot1 = new int[negative];
        //Скопировал.
        System.arraycopy(nechot, 0, newnechot1, 0, negative);
        System.out.println("Вывод после копирования нечетных значений " + Arrays.toString(newnechot1));
        /**Задача 4
         Найдите самое длинное слово в предложении, при условии, что в предложении все слова разной длины.
         Предложение для поска длинного слова: "в предложении все слова разной длины"
         (самостоятельно найти метод преобразования строки в массив строк).*/
        //Задал строку
        String stroka = "в предложении все слова разной длины";
        //Привожу строку в массив с разделением элементов по "ПРОБЕЛУ".
        String[] strokaMas = stroka.split(" ");
        //Вывожу результат
        System.out.println(Arrays.toString(strokaMas));
        //Отсортировал - это не обезательно.
        Arrays.sort(strokaMas);
        //Вывожу результат.
        System.out.println(Arrays.toString(strokaMas));
        int razmer = strokaMas.length;
        String otvet = strokaMas[0];
        for (int i = 0; i <= razmer - 1; i++) {
            if (strokaMas[i].length() > razmer) {
                otvet = strokaMas[i];
            }
        }
        System.out.println("Правильный ответ: " + otvet);
        /** Это решения я списал)). Не хотелось через for делать*/
        String s = Arrays.stream(strokaMas).max(Comparator.comparing(String::length)).get();
        System.out.println("Правильный ответ: " + s);
        /**Задача 3
         Задать массив на N слов.
         В цикле считывать с консоли слова (scanner.nextLine()), и добавлять их в массив (добавлять новое слово в массив можно только, если в нем его еще нет).
         В итоге в массиве будут только уникальные слова.
         Выход из программы по слову exit (слово 'exit' в массив не добавлять) или если массив заполнен.
         Перед завершением программы, вывести получившийся массив в консоль*/

    }
}