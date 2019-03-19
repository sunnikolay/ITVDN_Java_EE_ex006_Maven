package command;

import dao.BunchDAO;
import dao.DAOFactory;
import entitiy.Bunch;
import entitiy.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Asus on 06.02.2018.
 */
public class CreateBunchCommand implements Command {

    public String execute(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        Bunch bunch = new Bunch();
        DAOFactory daoFactory = DAOFactory.getInstance();
        BunchDAO bunchDAO = daoFactory.getBunchDAO();
        bunchDAO.addBunch(bunch, user);
        List<Bunch> bunches = bunchDAO.getAllBunches(user);
        request.setAttribute("bunches", bunches);
        return "controller?action=main";
    }

}
