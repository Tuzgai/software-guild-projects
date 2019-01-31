
import com.sg.wordgame.controller.WordGameController;
import com.sg.wordgame.dao.WordGameDao;
import com.sg.wordgame.dao.WordGameDaoFileImpl;
import com.sg.wordgame.view.UserIO;
import com.sg.wordgame.view.UserIOConsoleImpl;
import com.sg.wordgame.view.WordGameView;

/**
 *
 * @author Stuart
 */
public class app {

    public static void main(String[] args) {
        UserIO io = new UserIOConsoleImpl();
        WordGameDao dao = new WordGameDaoFileImpl();
        WordGameView view = new WordGameView(io);
        WordGameController controller = new WordGameController(view, dao);

        controller.run();
    }
}
