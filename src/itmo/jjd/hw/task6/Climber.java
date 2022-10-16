package itmo.jjd.hw.task6;

public class Climber {

    private String name;
    private String address;
    public Climber(String name, String address){
        setName(name);
        setAddress(address);
    }
    public void setName(String name){
        if (name == null || name.length() < 3){
            throw new IllegalArgumentException("name не м.б. меньше 3 символов");
        }
        this.name = name;
    }
    public String getName(){

        return name;
    }

    public void setAddress(String address){
        if (address == null || address.length() < 5){
            throw new IllegalArgumentException("adress не м.б. меньше 5 символов");
        }
       this.address = address;
    }
    public String getAddress (){

        return address;
    }

    @Override
    public String toString() {
        return "Climber{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
