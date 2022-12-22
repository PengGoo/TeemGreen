package kiy3035.abc.service;

import kiy3035.abc.domain.Board1;
import kiy3035.abc.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private BoardRepository boardRepository;

    // 이거 아니면 @Autowired로 하는 방법도 있음
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    // 글 작성 처리
    public void write(Board1 board1) {

        boardRepository.save(board1);
    }

    // 게시글 리스트 처리
    public List<Board1> board1List() {

        return boardRepository.findAll();
        // findAll 메소드 = board1 클래스가 담긴 List를 반환해줌
    }

    // 특정 게시글 불러오기
    public Board1 boardView(Long post_idx) {

        return boardRepository.findById(post_idx).get();
    }
}
