package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.dao.QuestionDao;
import jwp.dao.UserDao;
import jwp.model.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ListUserController implements Controller {
    private static final String USER_SESSION_KEY = "user";
    UserDao  userDao = new UserDao();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        System.out.println("list  ");
        HttpSession session = req.getSession();
        Object value = session.getAttribute(USER_SESSION_KEY);

        if (value == null) {
            return "redirect:/";
        }

        req.setAttribute("users", userDao.findAll());
        return "/user/list.jsp";
    }
}
