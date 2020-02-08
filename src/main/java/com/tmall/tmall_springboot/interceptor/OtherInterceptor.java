package com.tmall.tmall_springboot.interceptor;

import com.tmall.tmall_springboot.pojo.Category;
import com.tmall.tmall_springboot.pojo.OrderItem;
import com.tmall.tmall_springboot.pojo.User;
import com.tmall.tmall_springboot.service.CategoryService;
import com.tmall.tmall_springboot.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class OtherInterceptor implements HandlerInterceptor {
    @Autowired
    CategoryService categoryService;
    @Autowired
    OrderItemService orderItemService;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute("user");
        int  cartTotalItemNumber = 0;
        if (null!=user){
            List<OrderItem> orderItemList = orderItemService.listByUser(user);
            for (OrderItem orderItem : orderItemList){
                cartTotalItemNumber += orderItem.getNumber();
            }
        }

        List<Category> cs =categoryService.list();
        String contextPath=httpServletRequest.getServletContext().getContextPath();

        httpServletRequest.getServletContext().setAttribute("categories_below_search", cs);
        session.setAttribute("cartTotalItemNumber", cartTotalItemNumber);
        httpServletRequest.getServletContext().setAttribute("contextPath", contextPath);
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
