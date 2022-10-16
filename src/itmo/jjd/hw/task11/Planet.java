package itmo.jjd.hw.task11;

public enum Planet {
    EARTH (10000,6000),VENERA(7000,3000),MARS(20000,9000);
    private double weight;
    private double radius;

    Planet(double weight, double radius){
        setWeight(weight);
        setRadius(radius);
    }
    public void setWeight(double weight){
        this.weight = weight;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public double getWeight(){
        return weight;
    }
    public double getRadius(){
        return radius;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name=" + this.name() +
                ", weight=" + weight + " kg. " +
                ", radius=" + radius + " km. " +
                '}';
    }
}
