package multithreaded_chat;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Message implements Serializable {
    private String sender;
    private String text;
    private LocalDateTime dateTime;
    private int id;

    public Message(String sender, String text) {
        this.sender = sender;
        this.text = text;
    }
    public String getSender(){
        return sender;
    }
    public void setSender(String sender){
        this.sender = sender;
    }

    public String getText(){
        return text;
    }

    public  void setText(String text){
        this.text = text;
    }

    public void setDateTime(){
        dateTime = LocalDateTime.now();
    }

    public int getId() {
        return  id;
    }

    public void setId(int id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "Message{" +
                "sender='" + sender + '\'' +
                ", text='" + text + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }

    public static Message getMessage(String sender, String text){
        return new Message(sender,text);
    }
}
