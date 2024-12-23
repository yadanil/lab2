import java.util.Scanner;
import java.util.Arrays;


//Задание 1 1
class Point {
    private double x;
    private double y;

    //Конструктор для инициализации координат
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //Геттеры для координат
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    //Метод для получения текстового представления точки
    public String toString() {
        return String.format("{%f;%f}", x, y);
    }
}

//Задание 2 1
class Line {
    private Point start;
    private Point end;

    //Конструктор для инициализации линии
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    //Конструктор для создания линии с четырьмя числами (x1, y1, x2, y2)
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    public int getLength() {
        double dx = end.getX() - start.getX();
        double dy = end.getY() - start.getY();
        return (int) Math.round(Math.sqrt(dx * dx + dy * dy));
    }
    //Геттеры для начала и конца линии
    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    //Сеттеры для начала и конца линии
    public void setStart(Point start) {
        this.start = start;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    //Метод для получения текстового представления линии
    @Override
    public String toString() {
        return String.format("Линия от %s до %s", start, end);
    }
}

//Задание 3 1
class Student {
    private String name;
    private int[] grades;

    //Конструктор для инициализации имени и оценок
    public Student(String name, int[] grades) {
        this.name = name;
        this.grades = grades;
    }

    //Геттер для оценок
    public int[] getGrades() {
        return grades;
    }

    //Сеттер для оценок
    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    //Метод для получения текстового представления студента
    @Override
    public String toString() {
        return String.format("Имя: %s, Оценки: %s", name, Arrays.toString(grades));
    }
}

public class Main {
    public static void main(String[] args) {
        boolean temp_flag = false;
        //Задание 1 1
        Scanner scanner = new Scanner(System.in);

        double x = 0;
        double y = 0;
        //Создаем три точки с ручным вводом координат
        Point[] points = new Point[3];
        System.out.println("Задание 1 1");
        for (int i = 0; i < 3; i++) {
            System.out.println("Введите координаты для точки " + (i + 1) + ":");
            System.out.print("X: ");
            while (true) {
                if (scanner.hasNextDouble()) {
                    x = scanner.nextDouble();
                    break;
                } else {
                    System.out.println("Ошибка. Попробуйте еще раз.");
                    scanner.next();
                    System.out.print("X: ");
                }
            }
            System.out.print("Y: ");
            while (true) {
                if (scanner.hasNextDouble()) {
                    y = scanner.nextDouble();
                    break;
                } else {
                    System.out.println("Ошибка. Попробуйте еще раз.");
                    scanner.next();
                    System.out.print("X: ");
                }
            }

            points[i] = new Point(x, y);
        }

        // Выводим текстовое представление каждой точки
        System.out.println("Текстовое представление точек:");
        for (int i = 0; i < 3; i++) {
            System.out.println("Точка " + (i + 1) + ": " + points[i].toString());
        }



        //Задание 2 1
        System.out.println("\nЗадание 2 1");
        //Первая линия
        Point start1 = new Point(1, 3);
        Point end1 = new Point(23, 8);
        Line line1 = new Line(start1, end1);

        //Вторая линия
        Point start2 = new Point(5, 10);
        Point end2 = new Point(25, 10);
        Line line2 = new Line(start2, end2);

        //Третья линия
        Line line3 = new Line(line1.getStart(), line2.getEnd());

        System.out.println("Исходные линии:");
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);

        System.out.println("\nИзменение координат первой линии:");
        System.out.print("Введите новое значение X для начала первой линии: ");
        double newX1 = scanner.nextDouble();
        System.out.print("Введите новое значение Y для начала первой линии: ");
        double newY1 = scanner.nextDouble();
        line1.setStart(new Point(newX1, newY1));

        System.out.println("\nИзменение координат второй линии:");
        System.out.print("Введите новое значение X для конца второй линии: ");
        double newX2 = scanner.nextDouble();
        System.out.print("Введите новое значение Y для конца второй линии: ");
        double newY2 = scanner.nextDouble();
        line2.setEnd(new Point(newX2, newY2));

        //Обновление третьей линии
        line3.setStart(line1.getStart());
        line3.setEnd(line2.getEnd());

        System.out.println("\nЛинии после изменений:");
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);

        System.out.println("\nИзменение координат первой линии без изменения третьей линии:");
        System.out.print("Введите новое значение X для конца первой линии: ");
        double newEndX1 = scanner.nextDouble();
        System.out.print("Введите новое значение Y для конца первой линии: ");
        double newEndY1 = scanner.nextDouble();
        line1.setEnd(new Point(newEndX1, newEndY1));

        System.out.println("\nЛинии после изменений без изменения третьей линии:");
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);



        //Задание 3 1
        System.out.println("\nЗадание 3 1");

        //Вася
        int[] gradesVasya = {3, 4, 5};
        Student vasya = new Student("Вася", gradesVasya);

        //Петя
        Student petya = new Student("Петя", vasya.getGrades());

        //Замена первой оценки Пети
        petya.getGrades()[0] = 5;

        System.out.println(vasya);
        System.out.println(petya);

        System.out.println("\nОбъяснение результата:");
        System.out.println("При копировании оценок Васи в Петю использовалась ссылка на массив оценок Васи.");
        System.out.println("Поэтому изменение оценок Пети также изменило оценки Васи.");

        //Андрей
        int[] gradesAndrey = Arrays.copyOf(vasya.getGrades(), vasya.getGrades().length);
        Student andrey = new Student("Андрей", gradesAndrey);

        //Изменение оценки Васи
        vasya.getGrades()[1] = 2;

        System.out.println("\nПосле изменения оценок Васи:");
        System.out.println(vasya);
        System.out.println(petya);
        System.out.println(andrey);



        //Задание 4 1
        System.out.println("\nЗадание 4 1");

        //Создание точек
        Point point1 = new Point(3, 5);
        Point point2 = new Point(25, 6);
        Point point3 = new Point(7, 8);

        System.out.println("Точка 1: " + point1);
        System.out.println("Точка 2: " + point2);
        System.out.println("Точка 3: " + point3);


        //Задание 4 2
        System.out.println("\nЗадание 4 2");
        //Первая линия
        line1 = new Line(1, 3, 23, 8);

        //Вторая линия
        line2 = new Line(5, 10, 25, 10);

        //Третья линия
        line3 = new Line(line1.getStart(), line2.getEnd());

        System.out.println("Линия 1: " + line1);
        System.out.println("Линия 2: " + line2);
        System.out.println("Линия 3: " + line3);


        //Задание 5 3
        //Создание линии
        Line line = new Line(1, 1, 10, 15);

        System.out.println("Линия: " + line);
        System.out.println("Длина линии: " + line.getLength());
    }
}
