package kiy3035.abc.controller;

import kiy3035.abc.domain.Board1;
import kiy3035.abc.repository.BoardRepository;
import kiy3035.abc.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write")     // localhost:8080/board/write
    public String boardWriteForm() {

        return "thymeleaf/board/boardwrite";
    }
    @PostMapping("/board/writeprocess")
    // @PostMapping("/board/writeprocess") 얘랑
    // boardwrite.html에 있는
    // form action="/board/writeprocess" 같아야함

    public String boardWriteProcess(Board1 board1) {

        System.out.println("제목 : " + board1.getPost_title());
        System.out.println("글 내용 : " + board1.getPost_cont());

        boardService.write(board1);
        return "thymeleaf/board/boardlist";
    }

    @GetMapping("/board/list")
    public String boardList(Model model) {

        model.addAttribute("list", boardService.board1List());

        return "thymeleaf/board/boardlist";
    }

    @GetMapping("/board/view")  // localhost:8080/board/view?post_idx=1
    public String boardView(Model model, Long post_idx) {

        model.addAttribute("board1", boardService.boardView(post_idx));
        return "thymeleaf/board/boardview";
    }
}
