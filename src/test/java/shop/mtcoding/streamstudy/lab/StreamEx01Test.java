package shop.mtcoding.streamstudy.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class StreamEx01Test {

    @Test
    public void ex05() {
        // ex04 버블정렬해보기
    }

    @Test
    public void ex04() { // list에 있는 데이터를 newList에 넣는데, stream에 넣지말고 중복되지 않게끔 옮기기
        List<Integer> list = Arrays.asList(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);
        List<Integer> newList = new ArrayList<>();
        List<Integer> dList = new ArrayList<>();
        for (Integer i : list) {
            newList.add(i);
        }

        for (int i = 0; i < newList.size(); i++) {
            for (int j = i + 1; j < newList.size(); j++) {
                if (newList.get(i) == newList.get(j)) {
                    newList.remove(j);

                }
            }
        }

        for (Integer integer : newList) {
            System.out.println(newList);
        }
    }

    @Test
    public void ex03() {
        List<Integer> list = Arrays.asList(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);
        List<Integer> lowList = new ArrayList<>();
        List<Integer> highList = new ArrayList<>();

        // 얕은 복사 : 주소만 복사
        lowList = list;

        // 깊은 복사 : 주소만 복사하는게 아니라 값을 복사
        for (Integer i : list) {
            highList.add(i);
        }
    }

    @Test
    public void ex02() {
        List<Integer> list = Arrays.asList(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);
        Stream<Integer> stream = list.stream();
        stream.distinct().forEach(t -> {
            System.out.println(t);
        });
    }

    @Test
    public void ex01() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(4);
        list.add(2);
        list.add(3);
        list.add(1);

        Stream<Integer> stream = list.stream();
        // stream을 순회하면서 값을 sout으로 출력
        stream.forEach(t -> { // 처음에 들어오는 t(변수) : 4
            System.out.println(t);
        });

        // 위의 람다식을 익명클래스로 작성한 것
        stream.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer t) {
                System.out.println(t);

            }
        });

    }
}