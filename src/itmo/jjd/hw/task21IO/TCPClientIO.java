package itmo.jjd.hw.task21IO;

import itmo.jjd.hw.task21IO.common.Connection;
import itmo.jjd.hw.task21IO.common.Message;

import java.io.IOException;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Scanner;

public class TCPClientIO {
    private final String ip; // адрес серверной машины
    private final int port; // порт, на котором серверная программа ожидает клиента
    private LocalDateTime messageTime;
    public TCPClientIO(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void run(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя");
        String name = scanner.nextLine();
        String messageText;

        while (true){
            System.out.println("Введите сообщение");
            String text = scanner.nextLine();

            if ("/exit".equalsIgnoreCase(text)){
                System.out.println("Закрытие приложения");
                return;
            }

            Message message = new Message(name, text);

            try (Connection<Message> connection =
                         new Connection<>(new Socket(ip, port))){
                connection.sendMessage(message);
                Message fromServer = connection.readMessage();
                System.out.println("Сообщение от сервера: " + fromServer);
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Обработка IOException и ClassNotFoundException");
            } catch (Exception e) {
                System.out.println("Обработка Exception");
            }
            if ("/ping".equalsIgnoreCase(text)){
                System.out.println("время, за которое сообщение доходит до сервера и возвращается обратно " + getPingTime(message) + " ms");
            }
        }
    }
    private int getPingTime(Message message){
        return  (messageTime.getNano() - message.getDateTime().getNano());
    }
    public static void main(String[] args) {
        new TCPClientIO("127.0.0.1", 8090).run();
    }
}
