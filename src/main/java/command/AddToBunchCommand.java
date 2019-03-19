package command;

import dao.BunchDAO;
import dao.DAOFactory;
import dao.FlowerDAO;
import entitiy.Bunch;
import entitiy.Flower;
import entitiy.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Asus on 06.02.2018.
 */
public class AddToBunchCommand implements Command {

    public String execute(HttpServletRequest request) {
        long bunchId = Long.valueOf(request.getParameter("id"));
        DAOFactory factory = DAOFactory.getInstance();
        FlowerDAO flowerDAO = factory.getFlowerDAO();
        List<Flower> flowers = flowerDAO.getAll();
        request.setAttribute("id", bunchId);
        request.setAttribute("flowers", flowers);
        return "add_flowers.jsp";
    }

}
