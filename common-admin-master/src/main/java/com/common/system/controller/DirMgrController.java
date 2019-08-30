package com.common.system.controller;

import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.common.system.entity.RcDir;
import com.common.system.entity.RcRole;
import com.common.system.service.DirService;
import com.common.system.shiro.ShiroKit;
import com.common.system.shiro.ShiroUser;
import com.common.system.util.PageBean;
import com.common.system.util.Result;
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

	@RequestMapping(value = "isHasOpenDir")
	public @ResponseBody Result<Integer> isHasOpenDir() {
		Result<Integer> result = dirService.isHasOpenDir();
		return result;		
	}
	@RequestMapping(value = "save")
	public @ResponseBody Result<Integer> save(String dirUrl,int statusValue) {
		Result<Integer> result = dirService.isHasOpenDir();
		if(result.isStatus() || statusValue == 0) {
		Subject subject = ShiroKit.getSubject();
		ShiroUser user = (ShiroUser) subject.getPrincipal();
		RcDir rcDir = new RcDir();
		rcDir.setEditUser(user.getUsername());
		rcDir.setUrl(dirUrl);
		rcDir.setStatus(statusValue);
		result = dirService.save(rcDir);
		}
		return result;		
	}

	 @RequestMapping(value = "edit/{id}/{status}",method = RequestMethod.GET)
	 @ResponseBody
	    public String edit(@PathVariable Integer id,@PathVariable Integer status){
		 Result<Integer> result = dirService.isHasOpenDir();
		 RcDir rcDir = new RcDir();
			if(result.isStatus() || status == 1) {
				rcDir.setId(id);
				if(status == 0) {
					rcDir.setStatus(1);
				}else {
					rcDir.setStatus(0);
				}
	        dirService.updateById(rcDir);
			}
	        return REDIRECT+"/system/admin/dir/list";
	    }
	 
	@RequestMapping(value = "delete/{id}",method = RequestMethod.GET)
    public @ResponseBody String delete(@PathVariable Integer id){
		dirService.deleteById(id);        
        return REDIRECT+"/system/admin/dir/list";
    }
}
