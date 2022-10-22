package itmo.jjd.hw.task14.message;

import java.util.*;

public class MessageTask {
    public static void countEachPriority(List<Message> messageList) {
        // TODO:  Подсчитать количество сообщений для каждого приоритета
        //  Ответ в консоль
        List<Message> tempList = new ArrayList<>();
        for (int i = 0; i < messageList.size(); i++){
            tempList.add(null);
        }
        Collections.copy(tempList,messageList);
        int count = 0;
        for (int i = 0; i < messageList.size(); i++) {
            Iterator<Message> iterator = tempList.listIterator();
            while (iterator.hasNext()){
                Message temp = iterator.next();
                if (messageList.get(i).getPriority().equals(temp.getPriority())){
                    count++;
                    iterator.remove();
                }
            }
            if (count !=0){
                System.out.println(count + " сообщения имеют приоритеты " + messageList.get(i).getPriority().name());
                count = 0;
            }
        }
    }

    public static void countEachCode(List<Message> messageList) {
        // TODO: Подсчитать количество сообщений для каждого кода сообщения
        //  Ответ в консоль
        List<Message> listTemp = new ArrayList<>();
        for (int i = 0; i < messageList.size(); i++) {
            listTemp.add(null);
        }
        Collections.copy(listTemp,messageList);
        int count = 0;
        for (Message message: messageList) {
            Iterator<Message> iterator = listTemp.listIterator();
            while (iterator.hasNext()){
                Message temp = iterator.next();
                if (message.getCode() == temp.getCode()){
                    count++;
                    iterator.remove();
                }
            }
            if (count != 0){
                System.out.println(count + "сообщение с кодом " + message.getCode());
                count = 0;
            }
        }
    }
    public static void uniqueMessageCount(List<Message> messageList) {
        // TODO: Подсчитать количество уникальных сообщений
        //  Ответ в консоль
        int count = 0;
        HashSet<Message> hashSet = new HashSet<>();
        for (Message message : messageList) {
            if (hashSet.add(message))
                count++;
        }
        System.out.println("уникальных сообщений: " + count);
    }

    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList) {
        // TODO: вернуть только неповторяющиеся сообщения и в том порядке,
        //  в котором они встретились в первоначальном списке
        //  Например, было: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        //  на выходе: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]
        LinkedHashSet<Message> tempOrOr = new LinkedHashSet<>();
        for (Message message: messageList) {
            tempOrOr.add(message);
        }
        messageList = new ArrayList<>(tempOrOr);
        return messageList;
    }

    public static void removeEach(List<Message> messageList, MessagePriority priority) {
        // TODO: удалить из коллекции каждое сообщение с заданным приоритетом
        //  вывод в консоль до удаления и после удаления
        Iterator<Message> iterator = messageList.listIterator();
        while (iterator.hasNext()){
            if (iterator.next().getPriority().equals(priority)) iterator.remove();
        }
        System.out.println(messageList);
    }
    public static void removeOther(List<Message> messageList, MessagePriority priority) {
        // TODO: удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет
        //  вывод в консоль до удаления и после удаления
        Iterator<Message> iterator = messageList.listIterator();
        while (iterator.hasNext()){
            if (!(iterator.next().getPriority().equals(priority))) iterator.remove();
        }
        System.out.println(messageList);
    }

    public static void main(String[] args) {
        List<Message> messages = Message.generate(34);
        System.out.println(messages);
        countEachPriority(messages);
        countEachCode(messages);
        uniqueMessageCount(messages);
        System.out.println(uniqueMessagesInOriginalOrder(messages));
        removeEach(messages,MessagePriority.MEDIUM);
        removeOther(messages,MessagePriority.LOW);
    }
}
