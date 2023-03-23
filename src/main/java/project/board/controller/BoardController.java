package project.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.board.domain.Board;
import project.board.service.BoardService;

import java.nio.file.Path;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/list")
    public String boardList(Model model, @PageableDefault(page = 0, size = 10, direction = Sort.Direction.DESC) Pageable pageable){
        Page<Board> list = boardService.list(pageable);

        int nowPage = list.getPageable().getPageNumber() + 1;
        int startPage = Math.max(nowPage - 4, 1);
        int endPage = Math.min(nowPage + 5, list.getTotalPages());

        model.addAttribute("list", list);
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        return"boardList";
    }

    @GetMapping("/writeForm")
    public String boardWriteForm(){
        return "writeForm";
    }

    @PostMapping("/writeAction")
    public String boardWriteAction(Board board){
        boardService.write(board);
        return "redirect:/board/list";
    }

    @GetMapping("/view/{id}")
    public String boardView(@PathVariable("id") Long id, Model model){
        model.addAttribute("board", boardService.boardView(id));
        return "boardView";
    }

    @GetMapping("updateForm/{id}")
    public String boardUpdateForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("board", boardService.boardView(id));
        return "updateForm";
    }

    @PostMapping("updateAction/{id}")
    public String boardUpdateAction(@PathVariable("id") Long id, Board board){
        Board boardTemp = boardService.boardView(id);
        boardTemp.setTitle(board.getTitle());
        boardTemp.setContent(board.getContent());

        boardService.write(boardTemp);

        return "redirect:/board/list";
    }

    @GetMapping("delete/{id}")
    public String boardDelete(@PathVariable("id") Long id){
        boardService.delete(id);
        return "redirect:/board/list";
    }


}
