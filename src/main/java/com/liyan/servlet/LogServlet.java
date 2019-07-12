package com.liyan.servlet;


import com.liyan.file.PageInfo;
import com.liyan.service.Impl.LogServiceImpl;
import com.liyan.service.LogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/show")
public class LogServlet extends HttpServlet {
    private LogService logService = new LogServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("teext/css");
            resp.setCharacterEncoding("utf8");
            String pageSizestr = req.getParameter("pageSize");
            String pageNumberstr = req.getParameter("pageNumber");
            int pageSize = 2;
            int pageNumber = 1;
            if (pageSizestr != null && !pageSizestr.equals("")) {
                pageSize = Integer.parseInt(pageSizestr);
            }
            if (pageNumberstr != null && !pageNumberstr.equals("")) {
                pageNumber = Integer.parseInt(pageNumberstr);
            }
            PageInfo pageInfo=logService.findpaeg(pageSize,pageNumber);
            req.setAttribute("pageInfo",pageInfo);
            req.getRequestDispatcher("log.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
