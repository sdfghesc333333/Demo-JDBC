package com.laptrinhjavaweb.controller.web;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.INewService;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.ulils.FormUtil;
import com.laptrinhjavaweb.ulils.SessionUtil;

@WebServlet(urlPatterns = { "/trang-chu", "/dang-nhap", "/thoat"})
public class HomeController extends HttpServlet {

	@Inject
	private ICategoryService categoryService;

	@Inject
	private INewService newService;
	
	
	@Inject
	private IUserService userService; 

	private static final long serialVersionUID = 7665624487288931965L;

	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * Long categoryid = 1L;
		 * 
		 * req.setAttribute("news", newService.findByCategoryId(categoryid));
		 */
		 /*NewModel newModel = new NewModel();
		String title = "Bai viet 110";
		String content = "Bai viet 110";
		Long categoryid = 1L;
		
		newModel.setTitle(title);
		newModel.setContent(content);
		newModel.setCategoryid(categoryid);
		newService.save(newModel);*/
		
		/*Long[] ids = {21L ,23L};
		
		newModel.setIds(ids);
		newService.delete(ids);*/
		

		String action = req.getParameter("action");
		if(action != null && action.equals("login")) {
			String message = req.getParameter("message");
			String alert = req.getParameter("alert");
			if(message != null && alert != null) {
				req.setAttribute("message", resourceBundle.getString(message));
				req.setAttribute("alert", "danger");
			}
			RequestDispatcher rd = req.getRequestDispatcher("/views/login.jsp");
			rd.forward(req, resp);
		}else if(action != null && action.equals("logout")) {
			SessionUtil.getInstance().removeValue(req, "USERMODEL");
			resp.sendRedirect(req.getContextPath()+"/trang-chu");
		}else {
			req.setAttribute("categories", categoryService.findAll());

			RequestDispatcher rd = req.getRequestDispatcher("/views/web/home1.jsp");
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action != null && action.equals("login")) {
			UserModel model = FormUtil.toModel(UserModel.class, req);
			model = userService.findByUserNameAndPasswordAndStatus(model.getUsername(), model.getPassword(), 1);
			if(model != null) {
				SessionUtil.getInstance().putValue(req, "USERMODEL", model);
				if(model.getRole().getCode().equals("USER")) {
					resp.sendRedirect(req.getContextPath()+"/trang-chu");
				} else if(model.getRole().getCode().equals("ADMIN")) {
					resp.sendRedirect(req.getContextPath()+"/admin-home");
				}
			}else {
				resp.sendRedirect(req.getContextPath()+"/dang-nhap?action=login&message=username_password_invalid&alert=danger");
			}
		}
	}
}
	