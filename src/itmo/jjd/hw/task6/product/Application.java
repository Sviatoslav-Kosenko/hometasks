package itmo.jjd.hw.task6.product;

public class Application {
    public static void main(String[] args) {
        Product[] products = {
                new Product("Картошка",100,200,300,400),
                new Product("Банан",100,100,100,100),
                new Product("Рыба",300,400,500,300),
                new Product("Мясо",1000,1000,1000,1000),
        };
        MyProduct myProduct = new MyProduct(1000,700,300,700,2);
        for (Product product : products) {
            myProduct.addProduct(product);
        }
        System.out.println(myProduct);
    }
}