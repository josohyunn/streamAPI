package shop.mtcoding.streamstudy.lab;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class StreamEx02Test {

    @Test
    public void ex05() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        List<Integer> newList = list.stream() // 순서에 상관 있음(limit은 줄이고 하는 것이기 때문에 예외)
                .skip(1) // skip : 물길에서 뺀다는건 아님
                .peek(t -> { // stream으로 return해주기 때문에 foreach대신 peek을 쓴다. peek은 collect전에 발동
                    System.out.println("peek : " + t);
                })
                .limit(2) //
                .map(t -> t * 2)
                .collect(Collectors.toList());
        // skip과 limit으로 페이징 가능(근데 페이징은 db에서 해줘서 굳이 stream에서 할 필요 없음)
        newList.stream().forEach(t -> System.out.println(t));

    }

    @Test
    public void ex04() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        List<Integer> newList = list.stream().limit(2).collect(Collectors.toList());
        newList.stream().forEach(t -> System.out.println(t));

    }

    @Test
    public void ex03() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        List<Integer> newList = list.stream()
                .filter(t -> t != 3) // 가공
                .map(t -> {
                    Integer r = t * 2;
                    return r;
                }) // 가공. 매번 각각의 값을 찾아가서 연산한 값으로 대체한다.
                .collect(Collectors.toList()); // 수집

        newList.stream().forEach(t -> System.out.println(t));

    }

    @Test
    public void ex02() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        // 람다 식은 ->뒤에 중괄호 없으면 바로 그 값을 return한다.
        List<Integer> newList = list.stream().filter(t -> t != 3).collect(Collectors.toList());

        newList.stream().forEach(t -> System.out.println(t));

    }

    @Test
    public void ex01() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        // 람다 식은 ->뒤에 중괄호 없으면 바로 그 값을 return한다.
        List<Integer> newList = list.stream().filter(t -> t % 2 != 0).collect(Collectors.toList());// return타입이 true일
                                                                                                   // 때에만 stream(물길)에
                                                                                                   // 남겨둠. false이면
                                                                                                   // stream에서 제외시킨다.
        // collect : 최종 연산

        newList.stream().forEach(t -> System.out.println(t));

    }

}
