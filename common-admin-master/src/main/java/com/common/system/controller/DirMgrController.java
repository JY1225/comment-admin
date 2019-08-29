package com.common.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.common.system.entity.RcDir;
import com.common.system.service.DirService;
import com.common.system.util.PageBean;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/dir")
public class DirMgrController extends BaseController {

	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(DirMgrController.class);

	@Autowired
	private DirService dirService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView findAllDir(ModelAndView modelAndView) {
		modelAndView.setViewName("/system/admin/dir/list");
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping(value = "page")
	public PageBean<RcDir> queryForPage(@RequestParam(value = "start", defaultValue = "1") int start,
			@RequestParam(value = "length", defaultValue = "10") int pageSize,
			@RequestParam(value = "date", required = false) String date,
			@RequestParam(value = "search", required = false) String search) {
		PageInfo<RcDir> pageInfo = dirService.listForPage((start / pageSize) + 1, pageSize);
		return new PageBean<RcDir>(pageInfo);
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView add(ModelAndView modelAndView) {
		modelAndView.setViewName("/system/admin/dir/add");
		return modelAndView;
	}

}
