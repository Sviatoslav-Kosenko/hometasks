package hw1;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
//1. Программа загадывает число в диапазоне [1;9]
//2. Пользователь вводит число с клавиатуры
//3. Программа в зависимости от введенного числа выводит в консоль следующее:
//    1) "загаданное число больше"
//    2) "загаданное число меньше"
//    3) "Вы угадали" (программа завершает работу)
//4. Если введен 0, выввести "выход из программы" (программа завершает работу)
        Scanner in = new Scanner(System.in);
        System.out.println("Введите целое число");
        int minimal = 1;
        int maximum = 9;
        int rand = (int) ((Math.random() * minimal + Math.random() * maximum) / 2);
        while (true) {
            System.out.println("Угадайте число от " + minimal + " до " + maximum);
            int userNumber = in.nextInt();
            if (rand == 0) {
                System.out.println("Выход из программы");
                break;
            }
           else if (rand > userNumber) {
                System.out.println("Загаданное число больше");
            }
            else if (rand < userNumber) {
                System.out.println("Загаданное число меньше");
            } else if (rand == userNumber){
                System.out.println("Вы угадали");
                break;
            }
            }
//1. Пользователь загадывает число в диапазоне от [2 до 100]
//2. Программа пытается его угадать (используйте метод бинарного поиска, т.е деление отрезка на 2).
//3. Программа может задавать пользователю вопросы: Число равно ...?, Число больше ...?
//   и в зависимоти от ответа пользователя принимать решения.
//4. Вместо текстовых ответов ДА/НЕТ, используйте числа 0 - НЕТ и 1 - ДА
        int mmini = 2;
        int mmaxi = 100;
        int mrand = (int) ((Math.random()*mmini + Math.random()*mmaxi) / 2 );
        int userVvod;
        Scanner vvod = new Scanner(System.in);
        System.out.println("Загадайте число от 2 до 100");
        userVvod = vvod.nextInt();
        while(true){
            System.out.println("Число равно, больше " + mrand + " ? " + " Введите '1' если ДА, '0' если НЕТ");
            userVvod = vvod.nextInt();
            if (userVvod == mrand){
                System.out.println("Отлично! Ваше число " + mrand);
                break;
            } else if (userVvod == 1){
                mmini = mrand;
                mrand = (int) ((Math.random()*mmini + Math.random()*mmaxi) / 2);
                if (mmini == mrand && mrand != 100){
                    mrand += 1;
                }
            } else if (userVvod == 0) {
                mmaxi = mrand;
                mrand = (int) ((Math.random() * mmini + Math.random() * mmaxi ) / 2);
            }
        }
        }
    }




