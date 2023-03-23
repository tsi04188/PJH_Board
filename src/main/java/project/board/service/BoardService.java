package project.board.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project.board.domain.Board;
import project.board.repository.BoardRepository;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public void write(Board board){
        boardRepository.save(board);
    }

    public Page<Board> list(Pageable pageable){
        return boardRepository.findAll(pageable);
    }

    public Board boardView(Long id){
        return boardRepository.findById(id).get();
    }

    public void delete(Long id){
        boardRepository.deleteById(id);
    }

}
