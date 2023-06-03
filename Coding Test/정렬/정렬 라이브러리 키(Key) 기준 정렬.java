import java.util.*;

class Fruit implements Comparable<Fruit> {

    private String name;
    private int key;

    public Fruit(String name, int key) {
        this.name = name;
        this.key = key;
    }

    public String getName() {
        return this.name;
    }

    public int getKey() {
        return this.key;
    }

    // 정렬 기준은 '키가 낮은 순서'
    @Override
    public int compareTo(Fruit other) {
        if (this.key < other.key) {
            return -1;
        }
        return 1;
    }
}

public class Main {

    public static void main(String[] args) {
        List<Fruit> fruits = new ArrayList<>();

        fruits.add(new Fruit("바나나", 2));
        fruits.add(new Fruit("사과", 5));
        fruits.add(new Fruit("당근", 3));

        Collections.sort(fruits);

        for (int i = 0; i < fruits.size(); i++) {
            System.out.print("(" + fruits.get(i).getName() + "," + fruits.get(i).getKey() + ") ");
        }
    }
}