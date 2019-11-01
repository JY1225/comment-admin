package com.common.system.controller;

import java.util.List;

import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.common.system.entity.Cust_jccjs_list;
import com.common.system.entity.RcUser;
import com.common.system.service.CustJccjsService;
import com.common.system.service.UserService;
import com.common.system.shiro.ShiroKit;
import com.common.system.shiro.ShiroUser;
import com.common.system.util.PageBean;
import com.github.pagehelper.PageInfo;



@Controller
@RequestMapping("/file")
public class FileController extends BaseController {
	// @Autowired
	//private UserService userService;
	@Autowired
    private CustJccjsService custJccjsService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView findAll(ModelAndView modelAndView) {
		modelAndView.setViewName("/system/admin/file/list");
        return modelAndView;
	}

	@ResponseBody
	@RequestMapping(value = "page")
	public PageBean<Cust_jccjs_list> queryForPage(@RequestParam(value = "start", defaultValue = "1") int start,
			@RequestParam(value = "length", defaultValue = "10") int pageSize,
			@RequestParam(value = "date", required = false) String date,
			@RequestParam(value = "search", required = false) String search) {

		ShiroUser rcuser = (ShiroUser) getUser();
		//RcUser rcuser = userService.findByUserName(user.getUsername());

		List<Cust_jccjs_list> list = custJccjsService.listForPage((start / pageSize) + 1, pageSize, rcuser.getId());
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setUpload_filename(list.get(i).getUpload_filename().trim());
		}
		PageInfo<Cust_jccjs_list> pageInfo = new PageInfo<Cust_jccjs_list>(list);
		return new PageBean<Cust_jccjs_list>(pageInfo);
	}
}
