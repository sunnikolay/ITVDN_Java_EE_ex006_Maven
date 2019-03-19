package command;

import dao.BunchDAO;
import dao.DAOFactory;
import entitiy.Bunch;
import entitiy.Flower;
import entitiy.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Asus on 06.02.2018.
 */
public class BunchFlowersCommand implements Command {

    public String execute(HttpServletRequest request) {
        int bunchId = Integer.valueOf(request.getParameter("id"));
        System.out.println(bunchId);
        User currentUser = (User) request.getSession().getAttribute("user");
        DAOFactory factory = DAOFactory.getInstance();
        BunchDAO bunchDAO = factory.getBunchDAO();
        Bunch currentBunch = bunchDAO.bunchById(bunchId, currentUser);
        System.out.println(currentBunch.getId());
        List<Flower> flowers = bunchDAO.getFlowersToBunch(currentBunch);
        request.setAttribute("flowers", flowers);
        request.setAttribute("id", bunchId);
        return "bunch_flowers.jsp";
    }

}
