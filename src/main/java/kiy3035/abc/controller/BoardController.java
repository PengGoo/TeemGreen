package kiy3035.abc.controller;

import kiy3035.abc.domain.Board1;
import kiy3035.abc.repository.BoardRepository;
import kiy3035.abc.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    public String boardWriteProcess(Board1 board1, Model model) {

        System.out.println("제목 : " + board1.getPost_title());
        System.out.println("글 내용 : " + board1.getPost_cont());

        model.addAttribute("message", "글 작성이 완료되었습니다");
        model.addAttribute("searchUrl", "/board/list");
        boardService.write(board1);

        return "thymeleaf/board/boardmessage";
    }

    // 게시글 목록
    @GetMapping("/board/list")
    public String boardList(Model model) {

        model.addAttribute("list", boardService.board1List());

        return "thymeleaf/board/boardlist";
    }

    // 게시글 상세 페이지
    @GetMapping("/board/view")  // localhost:8080/board/view?post_idx=1
    public String boardView(Model model, Long post_idx) {

        model.addAttribute("board1", boardService.boardView(post_idx));
        return "thymeleaf/board/boardview";
    }

    // 게시글 삭제
    @GetMapping("/board/delete")
    public String boardDelete(Long post_idx) {

        boardService.boardDelete(post_idx);
        return "redirect:/board/list";
    }

    // ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
    // 게시글 수정 , @PathVariable 사용 - 기존 쿼리string이랑은 약간 다름!
    @GetMapping("/board/modify/{post_idx}")
    public String boardModify(@PathVariable("post_idx") Long post_idx,
                              Model model) {

        model.addAttribute("board1", boardService.boardView(post_idx));
        return "thymeleaf/board/boardmodify";
    }

    @PostMapping("/board/update/{post_idx}")
    public String boardUpdate(@PathVariable("post_idx") Long post_idx, Board1 board1) {

        // 기존에 있던 글이 담겨서 넘어옴
        Board1 boardTemp = boardService.boardView(post_idx);

        // 새로 입력한 내용을 기존 내용위에 덮어쓰기
        boardTemp.setPost_title(board1.getPost_title());
        boardTemp.setPost_cont(board1.getPost_cont());

        boardService.write(boardTemp);

        return "redirect:/board/list";
    }
    // ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
}
