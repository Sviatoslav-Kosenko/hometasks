package itmo.jjd.hw.task16;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AdditionalTask {
    public static void main(String[] args) {
        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout the point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";
        // TODO: Используя Stream API: создать Map<String, Long>, где
        //      String - слово
        //      Long - частота встречаемости
        //  В мапу должны войти только первые 10 по частоте встречаемости слов.

        Map<String, Long> map01 = text.lines().
                map((string-> string.split("[^a-zA-Z]")))
                .flatMap((arr)-> Arrays.stream(arr))
                .filter((string) -> string.length() > 1)
                        .map((string)->string.toLowerCase()).collect(Collectors
                        .toMap(Function.identity(),(string) -> (long)1, (val1, val2)->val1 +val2))
                        .entrySet().stream().sorted((entry1, entry2)-> entry2.getValue()
                        .compareTo(entry1.getValue()))
                        .limit(10)
                .collect(Collectors.toMap((entry)->entry.getKey(),(value)-> value.getValue()));
        System.out.println(map01);
    }
}