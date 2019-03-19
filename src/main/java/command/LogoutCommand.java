package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Asus on 06.02.2018.
 */
public class LogoutCommand implements Command {

    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "controller?action=main";
    }

}
