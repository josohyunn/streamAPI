package shop.mtcoding.streamstudy.board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString // 객체를 sysout하면 toString이 자동 호출됨
@Getter
@Setter
public class BoardDetailDTO {
    private Integer id;
    private String title;
    private String content;
    private String author;

    // DTO에는 @Builder를 쓰지 않는다. 생성자로 깊은복사한다.
    // 매개변수에 필드를 적지않고 객체로 받는게 가장 깔끔한 방식(만들때 편하기 때문)
    public BoardDetailDTO(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.author = board.getAuthor();
    }

}
