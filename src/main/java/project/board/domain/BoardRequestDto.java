package project.board.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Builder

public class BoardRequestDto {

    private Long id;
    private String title;
    private String content;
    private String registerId;

    public BoardRequestDto(Long id, String title, String content, String registerId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.registerId = registerId;
    }

}
