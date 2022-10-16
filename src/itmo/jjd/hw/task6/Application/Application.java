package itmo.jjd.hw.task6.Application;

import itmo.jjd.hw.task6.Climber;
import itmo.jjd.hw.task6.Group;
import itmo.jjd.hw.task6.Mountain;

public class Application {
    public static void main(String[] args) {
        Climber[] climbers = {
                new Climber("Николай", "Россия"),
                new Climber("Генри", "Великобритания"),
                new Climber("Пьер", "Франция"),
                new Climber("Николай", "Россия"),
                new Climber("Николай", "Россия"),
                new Climber("Николай", "Россия"),
                new Climber("Николай", "Россия"),
                new Climber("Николай", "Россия"),
        };
        Mountain[] mountains = {
                new Mountain("Элбьбрус", "Россия", 5000),
                new Mountain("Мон Блан", "Франция", 5430),
                new Mountain("Лейк-Дистрикт", "Великобритания", 943),
        };
        Group[] groups = {
                new Group(true, mountains[0], 3),
                new Group(true, mountains[1], 2),
                new Group(true, mountains[2], 2),
            };
            for (int i = 0; i < 3; i++){
                groups[0].addClimber(climbers[i]);
        }
            for (int i = 0; i < 2; i++){
                groups[1].addClimber(climbers[i]);
            }
            for (int i = 1; i < 3; i++){
                groups[2].addClimber(climbers[i]);
            }
        for (Group group : groups) {
            System.out.println(group.toString());
        }
    }
    }