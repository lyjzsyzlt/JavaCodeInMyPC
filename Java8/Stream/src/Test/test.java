package Test;
import dishDefinition.Dish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test {
    private static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH) );




    public static void main(String[] args) {
        List<String> names=menu.stream().filter(dish -> dish.getCalories()>300).map(Dish::getName).limit(3).collect(Collectors.toList());
        Stream<String> s=names.stream();
        s.forEach(System.out::println);

        long count = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .distinct()
                .limit(3)
                .count();
        System.out.println(count);

        List<Integer> numbers=new ArrayList<>(Arrays.asList(1,2,3,4,5,4));
        numbers.stream().filter(i->i%2==0).forEach(System.out::println);

        List<Integer> num=new ArrayList<>(Arrays.asList(1,2,3,4,5));
        num.stream().map(i->i*i).forEach(System.out::println);

    }


}
