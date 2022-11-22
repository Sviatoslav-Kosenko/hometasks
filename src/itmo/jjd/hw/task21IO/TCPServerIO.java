package itmo.jjd.hw.task21IO;

import itmo.jjd.hw.task21IO.common.Connection;
import itmo.jjd.hw.task21IO.common.Message;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerIO {
        private int port;
        private String messageText;
        private int messageCounter;
        public TCPServerIO(int port) {
            this.port = port;
            this.messageCounter = 0;
        }

        //команда `/help` - отобразить пользователю список доступных команд
        //команда `/count` - отобразить пользователю количество сообщений,
        // которые получил сервер (от всех клиентов)
        //команда `/ping` - время, за которое сообщение доходит до сервера и возвращается обратно
        public void run() {
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                System.out.println("Сервер запущен...");
                while (true) {
                    // сервер ждет клиента
                    Socket socket = serverSocket.accept(); // дождался
                    // взаимодействие с клиентом (получение и передача информации)
                    Connection<Message> connection = new Connection<>(socket);

                    Message fromClient = connection.readMessage();
                    System.out.println("От клиента: " + fromClient);
                    if ("/help".equalsIgnoreCase(fromClient.getText())){
                        messageText = getHelpText();
                    } else if ("/count".equalsIgnoreCase(fromClient.getText())) {
                        messageText = getCountText();
                    }else {
                        messageText = "Сообщение от сервера";
                    }

                    Message message = new Message("Server", "Сообщение от сервера");
                    connection.sendMessage(message);
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Обработка IOException или ClassNotFoundException");
            }
        }
        private String getHelpText(){
            String text = "\n" +
                    "Команда    /help    - отобразить справку по командам" + "\n" +
                    "Команда    /count   - отобразить количество сообщений, обработанное сервером" + "\n" +
                    "Команда    /ping    - отобразить время, за которое сообщение доходит до сервера и возвращается обратно"
                    + "\n" +
                    "Команда    /exit    - закрыть клиентское приложение";
            return text;
        }
        private String getCountText() {
          return   "Количество сообщений " + this.messageCounter;
        }
        public static void main(String[] args) {
            // Integer.parseInt(); -> возвращает int
            // Integer.valueOf(); -> возвращает Integer

            // что делать, если аргумент не задан, его нельзя преобразовать в int
            // или число не может быть использовано в качестве значения port?

            new TCPServerIO(Integer.parseInt(args[8090])).run();
        }
    }