package com.liyan.servlet;

import com.liyan.pojo.Account;
import com.liyan.service.AccountService;
import com.liyan.service.Impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/transfer")
public class AccountServlet extends HttpServlet {
    private AccountService accountService = new AccountServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("teext/css");
            resp.setCharacterEncoding("utf8");
            req.setCharacterEncoding("utf8");
            Account accOut = new Account();
            accOut.setAccno(req.getParameter("accOutAccNo"));
            accOut.setPassword(req.getParameter("accOutPassword"));
            accOut.setBalance(Double.parseDouble(req.getParameter("accOutBalance")));
            Account accIn = new Account();
            accIn.setAccno(req.getParameter("accInNo"));
            accIn.setName(req.getParameter("accInName"));
            int index = accountService.transfer(accIn, accOut);
            if (index == AccountService.SUCCESS) {
                resp.sendRedirect("show");
            } else {
                HttpSession session=req.getSession();
                session.setAttribute("code",index);
                resp.sendRedirect("error.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
