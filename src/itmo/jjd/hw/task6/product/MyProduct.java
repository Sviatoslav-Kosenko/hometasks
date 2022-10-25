package itmo.jjd.hw.task6.product;

import java.util.Arrays;

public class MyProduct {
    private int proteins;
    private int fats;
    private int carbohydrates;
    private int calories;
    public Product[] products;
    private int size;

    public MyProduct(int proteins, int fats, int carbohydrates, int calories, int size) {
        setProteins(proteins);
        setFats(fats);
        setCarbohydrates(carbohydrates);
        setCalories(calories);
        setSize(size);
        setProducts(size);
    }

    public void setProteins(int proteins) {
        if (proteins < 0) {
            throw new IllegalArgumentException("Значение белка не м.б. меньше 0");
        }
        this.proteins = proteins;
    }

    public void setFats(int fats) {
        if (fats < 0) {
            throw new IllegalArgumentException("Значение жиров не м.б. меньше 0");
        }
        this.fats = fats;
    }

    public void setCarbohydrates(int carbohydrates) {
        if (carbohydrates < 0) {
            throw new IllegalArgumentException("Значение углеводов не м.б. меньше 0");
        }
        this.carbohydrates = carbohydrates;
    }

    public void setCalories(int calories) {
        if (calories < 0) {
            throw new IllegalArgumentException("Значение калорий не м.б. меньше 0");
        }
        this.calories = calories;
    }

    public void setSize(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Значение не м.б. меньше 0");
        }
        this.size = size;
    }

    public void setProducts(int sizeBasket) {
        this.products = new Product[sizeBasket];
    }

    public int getProteins() {
        return proteins;
    }

    public int getFats() {
        return fats;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public int getCalories() {
        return calories;
    }

    public Product[] getProducts() {
        return products;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "MyProduct{" +
                "proteins=" + proteins +
                ", fats=" + fats +
                ", carbohydrates=" + carbohydrates +
                ", calories=" + calories +
                ", products=" + Arrays.toString(products) +
                ", size=" + size +
                '}';
    }

    public void addProduct(Product product) {
        if (product.getProteins() > this.getProteins()) {
            System.out.println("Product " + product.getName() +
                    " Н.б. добавлен. Продукт имеет много белка.");
            return;
        }
        if (product.getFats() > this.getFats()) {
            System.out.println("Product " + product.getName() +
                    " Н.б. добавлен. Продукт имеет много жира.");
            return;
        }
        if (product.getCarbohydrates() > this.getCarbohydrates()) {
            System.out.println("Product " + product.getName() +
                    " Н.б. добавлен. Продукт имеет много углеводов.");
            return;
        }
        if (product.getCalories() > this.getCalories()) {
            System.out.println("Product " + product.getName() +
                    " Н.б. добавлен. Продукт имеет много калорий.");
            return;
        }
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                return;
            }
            if (i == products.length - 1) {
                System.out.println("Продукты добавлены!");
            }
        }

    }
}