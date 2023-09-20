package shop.mtcoding.streamstudy.board;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import shop.mtcoding.streamstudy.user.User;

@RestController
public class BoardController {

    @Autowired
    private HttpSession session;

    @GetMapping("/boards")
    public BoardDetailV2DTO getBoardList() {
        // 강제 더미 로그인
        session.setAttribute("sessionUser", User.builder().id(1).username("ssar").build());

        // 게시글 id, 게시글 제목, 게시글 내용, 작성자 아이디, 작성자 유저네임
        // board(id, title, content), user(id, username), isOwner
        Board board = getDummy(); // DB에서 조회한 데이터

        User sessionUser = (User) session.getAttribute("sessionUser");
        BoardDetailV2DTO responseDTO = new BoardDetailV2DTO(board, sessionUser.getId());

        return responseDTO;
        // 메시지 컨버터 단점 : 전부다 getter때리기 때문에 lazy로딩이 일어난다.
        // 하지만 DTO를 쓰면 그럴 일이 없다.
    }

    private Board getDummy() {
        return Board.builder()
                .id(1)
                .title("제목1")
                .content("내용1")
                .author("cos")
                .user(User.builder().id(2).username("cos").password("1234").build())
                .build();
    }

}
