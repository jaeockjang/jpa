package com.bezkoder.spring.jpa.postgresql;

import org.apache.logging.log4j.util.PropertySource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//@SpringBootTest
@DisplayName("Test01 Test Class")
public class Test01 {
    @Test
    @DisplayName("Test01....")
    public void t001() {
        System.out.printf("System out Test");

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5,4,4,5);
        list.stream().forEach(System.out::println);
        System.out.println("--------");
        list.stream().distinct().sorted(Comparator.reverseOrder()).limit(6).forEach(System.out::println);
        System.out.println("--------");
        Stream.of(1,2).forEach(System.out::println);
        String[] strArr={"A","B","Z","K"};
        Stream<String> stringStream=Arrays.stream(strArr);
        stringStream.sorted().forEach(System.out::println);

    }

    @Test
    void t002() {
        System.out.println("-------");
        String a=null;
        Objects.requireNonNull(a);
    }

    @Test
    void t003() {
        Stream<String> builderStream= Stream.<String>builder()
                .add("Jang ").add("Jae").add("Ock")
                .build();

//        builderStream.forEach(System.out::println);

//        List<String> list= builderStream.collect(Collectors.toList());
//        System.out.printf("count:" +list.size());

//        builderStream.filter(x-> x.contains("Jan")).forEach(System.out::println); ;

//        builderStream.map(String::toLowerCase).forEach(System.out::println);

//          int sum= builderStream.mapToInt(x-> { return x.length(); }).sum();
//        System.out.printf("sum:"+sum);

//          int sum= builderStream.map(x-> { return x.length(); }).reduce(0,Integer::sum);
//        System.out.printf("sum:"+sum);

//        builderStream.sorted().forEach(System.out::println);

//        builderStream.sorted(Comparator.comparingInt(String::length) )
//                .forEach(System.out::println);

        builderStream.sorted(Comparator.comparingInt(String::length).reversed() )
                .forEach(System.out::println);


    }


}
