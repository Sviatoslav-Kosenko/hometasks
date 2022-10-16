package itmo.jjd.hw.task6;

public class Mountain {

    private String nameofmountain;
    private String country;
    private int height;

    public Mountain(String nameofmountain, String country, int height){
        setNameofmountain(nameofmountain);
        setCountry(country);
        setHeight(height);
    }
    public void setNameofmountain(String nameofmountain){
        if (nameofmountain == null || nameofmountain.length() < 4){
            throw new IllegalArgumentException("nameofmountain не м.б. меньше 4 символов");
        }
        this.nameofmountain = nameofmountain;
    }
    public String getNameofmountain(){

        return nameofmountain;
    }
    public void setCountry(String country){
        if (country == null || country.length() < 4){
            throw new IllegalArgumentException("country не м.б. меньше 4 символов");
        }
        this.country = country;
    }
    public String getCountry(){

        return country;
    }
    public void setHeight(int height){
        if (height < 100){
            throw new IllegalArgumentException("height не м.б. меньше 100");
        }
        this.height = height;
    }
    public int getHeight(){
        return height;
    }

    @Override
    public String toString() {
        return "Mountain{" +
                "nameofmountain='" + nameofmountain + '\'' +
                ", country='" + country + '\'' +
                ", height=" + height +
                '}';
    }
}
