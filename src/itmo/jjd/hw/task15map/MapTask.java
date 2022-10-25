package itmo.jjd.hw.task15map;

import java.util.*;

public class MapTask {
    public static void main(String[] args) {
        // FIXME:: В решениях не использовать lambda выражения и stream API

        // TODO:: написать статический метод, который принимает на вход мапу (firstTaskMap) и город (city),
        //  формирует и возвращает список (List) логинов, которые соответствуют переданному городу

        HashMap<String, String> firstTaskMap = new HashMap<>();
        firstTaskMap.put("qwe", "Тверь");
        firstTaskMap.put("asd", "Тверь");
        firstTaskMap.put("zxc", "Москва");
        firstTaskMap.put("rty", "Тверь");
        firstTaskMap.put("fgh", "Магадан");

        String city = "Тверь";

        // TODO:: дан список слов (words).
        //  Написать статический метод, который будет возвращать количество одинаковых слов
        //  в мапе вида Map<String, Integer>, где String - слово и Integer - количество повторений

        List<String> words = new ArrayList<>();
        words.add("may");
        words.add("august");
        words.add("june");
        words.add("may");
        words.add("may");
        words.add("july");
        words.add("may");
        words.add("august");
        words.add("august");


        // TODO:: дана мапа (customerMap).
        //  Написать статический метод, который принимает на вход аргументы int from и int to и возвращает
        //  новую мапу, в которую войдут все покупатели, возраст которых находится в диапазоне [from, to)

        HashMap<String, Customer> customerMap = new HashMap<>();
        customerMap.put("1", new Customer("Павел", "1", 23));
        customerMap.put("2", new Customer("Олег", "2", 17));
        customerMap.put("3", new Customer("Максим", "3", 48));
        customerMap.put("4", new Customer("Евгения", "4", 67));


        // TODO:: Задания по тексту (text). На каждый пункт - минимум один метод (можно статический):
        //  1. написать метод, принимающий на вход слово и возвращающий частоту встречаемости данного слова в тексте
        //  (Map<String, Long>, где - ключи (String) - слово, значения (Long) - частота встречаемости)
        //  2. написать метод, который собирает все слова в группы по количеству букв:
        //  например, в одну группу попадут слова: 3 - [the, war, jar, get, met...], в другую 2 - [on, up, no, of...]
        //  (Map<Integer, ArrayList<String>>, где - ключи (Integer) - количество букв, значения (ArrayList<String>) - слова)
        //  3. написать метод, который выводит в консоль топ 10 самых часто встречаемых в тексте слов (артикли и предлоги тоже считаем за слова)

        // в тексте содержатся только буквы и пробельные символы
        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";

        System.out.println(getListLogins(firstTaskMap,city));
        System.out.println(getCountWords(words));
        System.out.println("word \"and\" occurs " + countWord("and", text) +" times" );
        System.out.println(sortWordsByLength(text));
        System.out.println(Arrays.toString(topTenWords(text)));
    }
    public static Map<Integer, HashSet<String>> sortWordsByLength(String text){
        String[] strings = text.split(" ");
        Map<Integer, HashSet<String>> listMap = new HashMap<>();
        for (String string : strings) {
            if(listMap.get(string.length()) == null){
                listMap.put(string.length(), new HashSet<>());
                listMap.get(string.length()).add(string);
            } else {
                listMap.get(string.length()).add(string);
            }
        }
        return listMap;
    }
    public static String[] topTenWords(String text){
        String[] strings = text.split(" ");
        NavigableMap<Integer, HashSet<String>> listMap = new TreeMap<>();
        for (String string : strings) {
            int key = countWord(string,text);
            if(listMap.get(key) == null){
                listMap.put(key, new HashSet<>());
                listMap.get(key).add(string);
            } else {
                listMap.get(key).add(string);
            }
        }
        listMap = listMap.descendingMap();
        String[] strings1 = new String[10];
        int count = 0;
        for (Map.Entry<Integer, HashSet<String>> integerHashSetEntry : listMap.entrySet()) {
            for (String s : integerHashSetEntry.getValue()) {
                if (count < 10){
                    strings1[count] = s;
                    count++;
                }
            }
        }
        return strings1;
    }

    public static int countWord(String word, String text){
        int count = 0;
        String[] strings = text.split(" ");
        List<String> stringList = new ArrayList<>(Arrays.asList(strings));
        for (String s : stringList) {
            if(s.equals(word)) count++;
        }
        return count;
    }

    public static List<String> getListLogins(HashMap<String, String> hashMap, String city){
        List<String> listLogins = new ArrayList<>();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            if(entry.getValue().equals(city)) listLogins.add(entry.getKey());
        }
        return listLogins;
    }

    public static Map<String, Integer> getCountWords(List<String> listWords){
        Map<String, Integer> mapWords = new HashMap<>();
        for (String listWord : listWords) {
            Integer temp = mapWords.put(listWord, 1);
            if(temp != null ){
                mapWords.put(listWord, ++temp);
            }
        }
        return  mapWords;
    }

    public static HashMap<String, Customer> sortingMap(HashMap<String, Customer> mapa, int from, int to){
        HashMap<String, Customer> tempMapa = new HashMap<>();
        for (Map.Entry<String, Customer> temp : tempMapa.entrySet()) {
            if(temp.getValue().getAge() >= from && temp.getValue().getAge() <= to ){
                tempMapa.put(temp.getKey(), temp.getValue());
            }
        }
        return tempMapa;
    }

    public static HashMap<String, Customer> getByAge(
            HashMap<String, Customer> map,
            int from, int to
    )
    {
        HashMap<String, Customer> newMap = new HashMap<>();
        for (Map.Entry<String, Customer> entry: map.entrySet()) {
            if (entry.getValue().getAge() >= from &&
                    entry.getValue().getAge() < to) {
                newMap.put(entry.getKey(), entry.getValue());
            }
        }
        return newMap;
    }
}