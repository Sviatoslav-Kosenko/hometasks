package game_fox_adventure;

import java.util.InputMismatchException;
import java.util.Scanner;

public class QuestApplication {
    public static void main(String[] args) {
        menuMethod(true);
    }

    public static void menuMethod(boolean isNewGame){
        //Объект меню
        Menu menu = new Menu();
        //Объекты для всех умений объекта Меню.
        Command startGame = new ChooseFirstCommand(menu);
        Command downloadGame = new ChooseSecondCommand(menu);
        Command saveGame = new ChooseThirdCommand(menu);
        Command exit = new ChooseFourthCommand(menu);

        //
        Invoker invoker = new Invoker(startGame,downloadGame,saveGame,exit);
        //Меню игры
        if (isNewGame){
            System.out.println("Меню игры: " + "\n" +
                    "__________ " + "\n" +
                    "1. Начать игру. " + "\n" +
                    "2. Загрузить игру. " + "\n" +
                    "3. Выйти. " + "\n" +
                    "__________");
            Scanner scanner = new Scanner(System.in);
            int chooseMenuPoint;
            boolean b = true;
            while (b){
                try {
                    chooseMenuPoint = scanner.nextInt();
                    switch (chooseMenuPoint){
                        case 1: invoker.flipStart();
                        b = false;
                        scanner.close();
                        return;

                        case 2: invoker.flipDownload();
                        b = false;
                        scanner.close();
                        return;

                        case 3: invoker.flipExit();
                        b = false;
                        scanner.close();
                        return;

                        default:
                            System.out.println("Данного пункта нет в меню.");
                    }
                }catch (InputMismatchException e){
                    System.out.println("Введите корректное значение.");
                    scanner.next();
                }
            }
            scanner.close();
        }else {
            System.out.println("Меню игры: " + "\n" +
                    "__________ " + "\n" +
                    "1. Начать игру. " + "\n" +
                    "2. Загрузить игру. " + "\n" +
                    "3. Выйти. " + "\n" +
                    "4. Сохранить игру. " + "\n" +
                    "__________");

            Scanner scanner = new Scanner(System.in);
            int chooseMenuPoint;
            boolean b = true;
            while (b) {
                try {
                    chooseMenuPoint = scanner.nextInt();
                    switch (chooseMenuPoint) {
                        case 1: invoker.flipStart();
                            b = false;
                            scanner.close();
                            return;
                        case 2: invoker.flipDownload();
                            b = false;
                            scanner.close();
                            return;
                        case 3: invoker.flipExit();
                            b = false;
                            scanner.close();
                            return;
                        case 4: invoker.flipSaveGame();
                            b = false;
                            scanner.close();
                            return;
                        default:
                            System.out.println("Данного пункта нет в меню.");
                            //scanner.next();
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Введите корректное значение.");
                    scanner.next();
                }
            }
            scanner.close();
        }
    }
}