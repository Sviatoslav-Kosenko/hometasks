package hw1;
// Даны длина, ширина и высота прямоугольного параллелепипеда.
// Найти и вывести в консоль его площадь.
public class Task1 {
    public static void main(String[] args) {

        int a = 3, b = 4, c = 5;

        int d = 2*((a*b)+(b*c)+(a*c)); // Площадь поверхности параллелепипеда через его ребра:
                                       // S=2(a*b+b*c+a*c)

        System.out.println("Площадь равна: "+d + "m2");
//Дано целое число.
// Найти и вывести в консоль данное число в кубе.
        int e = 3;

        System.out.println("Ответ: "+ e * e * e);

//Даны две переменные типа double: время (в часах) и расстояние (в километрах).
// Найти и вывести в консоль скорость, выраженную в метрах в секунду.
        double t = 2;

        double s = 100;
        //Формула расчёта скорости V = S : t
        //Переводим растояние из киллометров в метры, часы в секунды;
        double v = (s*1000)/(t*(60*60));

        System.out.println("Ответ: "+ v +"м/с");

        int f = 45%9;
        int j = 11%2;
        int i = 17%3;
        System.out.println("Число от деления равно 5 и 0 в остатке, ответ: "+ f);
        System.out.println("Число от деления равно 5 и 1 в остатке, ответ: "+j);
        System.out.println("Число от деления равно 5 и 2 в остатке, ответ: "+i);
    }
}
