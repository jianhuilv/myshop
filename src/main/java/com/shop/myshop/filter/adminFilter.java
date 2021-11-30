package com.shop.myshop.filter;

import com.shop.myshop.mapper.UserMapper;
import com.shop.myshop.utils.SpringContextUtil;
import net.sf.json.JSONObject;
import com.shop.myshop.entity.User;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;

@CrossOrigin
@WebFilter(filterName = "adminFilter",urlPatterns = {"/admin/*"})
public class adminFilter extends HttpFilter {
    @Autowired
    UserMapper userMapper;
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest=(HttpServletRequest)request;
        HttpServletResponse httpServletResponse=(HttpServletResponse)response;
        ((HttpServletResponse) response).setHeader("Access-Control-Allow-Origin", "*");
        ((HttpServletResponse) response).setHeader("Access-Control-Allow-Credentials", "true");
        ((HttpServletResponse) response).setHeader("Access-Control-Allow-Methods", "*");
        ((HttpServletResponse) response).setHeader("Access-Control-Max-Age", "3600");
        ((HttpServletResponse) response).setHeader("Access-Control-Allow-Headers", "Authorization,Origin,X-Requested-With,Content-Type,Accept,"
                + "content-Type,origin,x-requested-with,content-type,accept,authorization,token,id,X-Custom-Header,X-Cookie,Connection,User-Agent,Cookie,*");
        ((HttpServletResponse) response).setHeader("Access-Control-Request-Headers", "Authorization,Origin, X-Requested-With,content-Type,Accept");
        ((HttpServletResponse) response).setHeader("Access-Control-Expose-Headers", "*");
        String servletPath=httpServletRequest.getServletPath();
        HttpSession session= httpServletRequest.getSession();
        User user=(User)session.getAttribute("user");
        System.out.println(servletPath);

        //设置输出
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/json; charset=utf-8");
        JSONObject jsonObject=new JSONObject();

        int questId=0;
        int userId=0;
            try{
                questId=Integer.parseInt(httpServletRequest.getParameter("uid"));
                userId=user.getUid();
            }
            catch (Exception e){
                writer =response.getWriter();
                System.out.println(e);
                jsonObject.put("msg","noLogin");
                writer.println(jsonObject);
                return;
            }
            if(userId==questId) {
                if(userMapper==null){
                    userMapper=(UserMapper) SpringContextUtil.getBean((UserMapper.class));
                }
                User user1=userMapper.getUserByUid(userId);
                if(user1.isAdmin()) {
                    chain.doFilter(request, response);
                }
                else {
                    writer =response.getWriter();
                    jsonObject.put("msg","NotAnAdminister");
                    writer.println(jsonObject);
                    return;
                }
            }
            else{
                writer =response.getWriter();
                jsonObject.put("msg","noRight");
                writer.println(jsonObject);
                return;
            }


    }
}
