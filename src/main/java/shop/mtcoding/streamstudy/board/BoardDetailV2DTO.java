package shop.mtcoding.streamstudy.board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import shop.mtcoding.streamstudy.user.User;

@ToString // 객체를 sysout하면 toString이 자동 호출됨
@Getter
@Setter
public class BoardDetailV2DTO {
    private Integer id;
    private String title;
    private String content;
    // User은 Entity이기 때문에 UserDTO로 받는다. UserDTO는 여기서만 쓸 것이기 때문에 내부클래스로 구현한다.
    private UserDTO user; // password는 노출되면 안되기 때문에 DTO로 만듬
    private boolean isOwner; // 작성자 본인인지 아닌지 구별. DB에는 없는 필드

    public BoardDetailV2DTO(Board board, Integer sessionId) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.isOwner = board.getUser().getId() == sessionId;
        this.user = new UserDTO(board.getUser());
    }

    // 화면마다 필요한 DTO가 다 다를거기 때문에 내부에서만 쓰는 DTO를 만든 것
    @Getter
    @Setter
    public class UserDTO { // 내부클래스 (내부에서만 쓸거니까 static안붙여도됨)
        private Integer id;
        private String username;

        public UserDTO(User user) {
            this.id = user.getId();
            this.username = user.getUsername();
        }

    }

}
