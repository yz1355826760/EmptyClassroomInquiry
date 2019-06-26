package com.stdum.classServlet;

import javax.print.DocFlavor;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.sun.javafx.sg.prism.web.NGWebView;
import com.stdum.classDao.classDaoimpl.*;

@WebServlet(name = "cs")
public class classServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("utf-8");
        //获取数据
        String Week = req.getParameter("Week");
        //通过week来判断单双周
        String DS = "单";
        String SEweek = req.getParameter("SEweek");
        String Session = req.getParameter("Session");
        //处理请求
        classDaoimpl cd = new classDaoimpl();
        List<String> lu = cd.classSearchdao(Week, DS, SEweek, Session);
        req.getSession().setAttribute("lu",lu);
//        resp.sendRedirect("look.jsp");
//        req.getSession().setAttribute("lu",lu);





        ArrayList<String> yi = new ArrayList<>();
        ArrayList<String> er = new ArrayList<>();
        ArrayList<String> san = new ArrayList<>();
        ArrayList<String> si = new ArrayList<>();
        ArrayList<String> wu = new ArrayList<>();
        ArrayList<String> liu = new ArrayList<>();
        ArrayList<String> qi = new ArrayList<>();
        ArrayList<String> ba = new ArrayList<>();

        for (int i = 0;i < lu.size();i++){
            if(lu.get(i).startsWith("11")){
                yi.add(lu.get(i));
            }else if(lu.get(i).startsWith("12")){
                er.add(lu.get(i));
            }else if(lu.get(i).startsWith("13")){
                san.add(lu.get(i));
            }else if(lu.get(i).startsWith("14")){
                si.add(lu.get(i));
            }else if(lu.get(i).startsWith("21")){
                wu.add(lu.get(i));
            }else if(lu.get(i).startsWith("22")){
                liu.add(lu.get(i));
            }else if(lu.get(i).startsWith("23")){
                qi.add(lu.get(i));
            }else if(lu.get(i).startsWith("24")){
                ba.add(lu.get(i));
            }
        }
        req.getSession().setAttribute("yi",yi);
        req.getSession().setAttribute("er",er);
        req.getSession().setAttribute("san",san);
        req.getSession().setAttribute("si",si);
        req.getSession().setAttribute("wu",wu);
        req.getSession().setAttribute("liu",liu);
        req.getSession().setAttribute("qi",qi);
        req.getSession().setAttribute("ba",ba);
        req.getRequestDispatcher("look.jsp").forward(req,resp);

    }
}

