package project.board.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.board.domain.Board;
import project.board.domain.BoardRequestDto;
import project.board.repository.BoardRepository;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public void write(Board board){
        boardRepository.save(board);
    }

    public List<Board> list(){
        return boardRepository.findAll();
    }
}
