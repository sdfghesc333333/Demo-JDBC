package com.laptrinhjavaweb.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.paging.PageRequest;
import com.laptrinhjavaweb.paging.Pageble;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.INewService;
import com.laptrinhjavaweb.sort.Sorter;
import com.laptrinhjavaweb.ulils.FormUtil;
import com.laptrinhjavaweb.ulils.MessageUtil;

@WebServlet(urlPatterns = {"/admin-new"})
public class NewController extends HttpServlet{

	private static final long serialVersionUID = 7665624487288931965L;

	@Inject
	private INewService newService;
	
	@Inject
	private ICategoryService categoryService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NewModel model = FormUtil.toModel(NewModel.class, req);
		/*String pageStr = req.getParameter("page");
		String maxPageItemStr = req.getParameter("maxPageItem");
		if(pageStr != null) {
			model.setPage(Integer.parseInt(pageStr));
		}else {
			model.setPage(1);
		}
		if(maxPageItemStr != null) {
			model.setMaxPageItem(Integer.parseInt(maxPageItemStr));
		}*/
		String view = "";
		if(model.getType().equals(SystemConstant.LIST)) {
			Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(), new Sorter(model.getSortName(), model.getSortBy()));
			model.setListResult(newService.findAll(pageble));
			model.setTotalItem(newService.getTotalItem());
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			req.setAttribute("message", "");
			req.setAttribute("alert", "");
			view = "/views/admin/new/listview.jsp";
		}else if(model.getType().equals(SystemConstant.EDIT)) {
			if(model.getId() != null) {
				model = newService.findOne(model.getId());
			}
			req.setAttribute("message", "");
			req.setAttribute("alert", "");
			req.setAttribute("categories", categoryService.findAll());
			view = "/views/admin/new/edit.jsp";
		}
		MessageUtil.showMessage(req);
		req.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
