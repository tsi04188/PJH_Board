package project.board.domain;


import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class BoardResponseDto {

    private Long id;
    private String title;
    private String content;
    private int readCnt;
    private String registerId;
    private LocalDateTime registerTime;

    public BoardResponseDto(Board board){
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.readCnt = board.getReadCnt();
        this.registerId = board.getRegisterId();
        this.registerTime = board.getRegisterTime();
    }

    @Override
    public String toString(){
        return "BoardListDto [id=" + id + ", title=" + title + ", content=" + content + ", readCnt=" + readCnt + ", " +
                "registerId " + registerId + ", registerTime=" + registerTime + "]";
    }
}
