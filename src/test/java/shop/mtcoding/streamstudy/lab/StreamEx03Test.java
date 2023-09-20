package shop.mtcoding.streamstudy.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import shop.mtcoding.streamstudy.board.Board;
import shop.mtcoding.streamstudy.board.BoardDetailDTO;
import shop.mtcoding.streamstudy.board.BoardListDTO;

public class StreamEx03Test {

    @Test
    public void ex02() {
        Board b1 = Board.builder()
                .id(1)
                .title("제목1")
                .content("내용1")
                .author("ssar")
                .build();

        Board b2 = Board.builder()
                .id(2)
                .title("제목2")
                .content("내용2")
                .author("ssar")
                .build();

        Board b3 = Board.builder()
                .id(3)
                .title("제목3")
                .content("내용3")
                .author("cos")
                .build();
        List<Board> boardList = Arrays.asList(b1, b2, b3); // add보다 이게 편함
        List<BoardListDTO> responseDTOs = boardList.stream()
                .filter(board -> !board.getAuthor().equals("cos"))
                .map(board -> new BoardListDTO(board)) // Board를 BoardListDTO로 가공한다.
                .collect(Collectors.toList());
        System.out.println(responseDTOs);

    }

    @Test
    public void ex01() {
        Board board = Board.builder()
                .id(1)
                .title("제목1")
                .content("내용1")
                .author("ssar")
                .build();

        // 자바에서 깊은복사 하는 가장 좋은 방법
        BoardDetailDTO responseDTO = new BoardDetailDTO(board);
        System.out.println(responseDTO);

    }

}
