package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.Dao;
import entiy.Inf;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/AddInfServlet")
public class AddInfServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");

        String Terminal = req.getParameter("Terminal");
        String Text = req.getParameter("Text");
        String longitude = req.getParameter("Longitude");
        Double Longitude = Double.parseDouble(longitude);
        String latitude = req.getParameter("Latitude");
        Double Latitude = Double.parseDouble(latitude);


        Inf inf = new Inf();

        inf.setTerminal(Terminal);
        inf.setText(Text);
        inf.setLongitude(Longitude);
        inf.setLatitude(Latitude);


        int ret = new Dao().addInf(inf);

        Map<String,Object> returnMap = new HashMap<>();
        if(ret == 1) {
            returnMap.put("msg",true);
        }else {
            returnMap.put("msg",false);
        }
        //把登录成功的map返回给前端。json      : 便于前端进行处理。
        ObjectMapper objectMapper = new ObjectMapper();
        //就是将returnMap，转换为json字符串
        objectMapper.writeValue(resp.getWriter(),returnMap);
    }
}
