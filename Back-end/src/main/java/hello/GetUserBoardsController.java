package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin
@RestController
public class GetUserBoardsController {

    @Autowired
    private IBoardRepository boardRepository;

    private String userName = "";
    private String boardName = "";


    @RequestMapping(value = {"/users/{userName}/boards"}, method = RequestMethod.GET)
    public List<String> board(@PathVariable(value="userName") String userName) {

        List<Board> userBoards = boardRepository.findByUserName(userName);
        List<String> boards= new ArrayList<>();

        for(Board board : userBoards) {
            boards.add(board.getBoardName());
        }

        return boards;
    }
}
