package qianjun.common;

import org.springframework.web.servlet.ModelAndView;

import qianjun.common.AjaxResponse.AjaxResponseStatus;
import qianjun.common.CommonConstants.ViewNames;

/**
 * 
 * TODO controller的一些工具
 * @author TangTianJiang
 * @date 2013年12月9日 下午8:09:08
 */
public class ControllerUtils {
	/**
	 * 根据参数返回ModelAndView
	 * @param mv
	 * @param viewName
	 * @return
	 */
	public static ModelAndView returnMV(ModelAndView mv, String viewName){
		mv.setViewName(viewName);
		return mv;
	}
	
	/**
	 * 
	 * TODO 返回错误提示内容的ModelAndView， 返回的的提示信息最好是国际化文件里的key，若不是，请先自行判断当前的语言，做好国际化
	 * @author TangTianJiang
	 * @date 2013年12月15日 上午10:14:15
	 * @param failMsg  页面内的现实内容
	 * @param alertFlag 是否弹出提示框
	 * @param alertMsg 弹出提示框时，对应的提示内容
	 * @return
	 */
	public static ModelAndView returnFailBlankMV(String failMsg,  boolean alertFlag, String alertMsg){
		ModelAndView mv = new ModelAndView();
		mv.addObject("message",failMsg);
		mv.addObject("alertMessage",alertMsg);
		mv.addObject("alertFlag", alertFlag);
		mv.setViewName(ViewNames.ABOUT_BLANK.viewName());
		return mv;
	}
	/**
	 * 返回信息输出的页面
	 * TODO
	 * @author TangTianJiang
	 * @date 2013年12月20日 下午1:41:03
	 * @param infoMsg    现实的信息内容(可以是国际化的key，也可以直接的输出信息)
	 * @param currentMenu   信息现实在哪个菜单下
	 * @return
	 */
	public static ModelAndView returnInfoMV(String infoMsg,String currentMenu){
		ModelAndView mv = new ModelAndView();
		mv.addObject("info",infoMsg);
		mv.addObject("currentMenu", currentMenu);
		mv.setViewName(ViewNames.MESSAGE_INFO.viewName());
		return mv;
	}
	
	
	public static ModelAndView returnErrorMsgMV(String errorMsg, String errorMsgDetail){
		ModelAndView mv = new ModelAndView();
		mv.setViewName(ViewNames.MESSAGE_ERROR.viewName());
		mv.addObject("errorMsg", errorMsg);
		mv.addObject("errorMsgDetail", errorMsgDetail);
		return mv;
	}

	/**
	 * 返回信息输出的页面
	 * @author Jindaqi
	 * @param infoMsg    现实的信息内容(可以是国际化的key，也可以直接的输出信息)
	 * @param currentMenu   信息现实在哪个菜单下
	 * @param returnPage 返回页面
	 * @return
	 */
	public static ModelAndView returnInfoMV(String infoMsg,String currentMenu, String returnPage){
		ModelAndView mv = new ModelAndView();
		mv.addObject("info",infoMsg);
		mv.addObject("currentMenu", currentMenu);
		if (null!=returnPage) {
			mv.addObject("returnPage", returnPage);
		}
		mv.setViewName(ViewNames.MESSAGE_INFO.viewName());
		return mv;
	}
	public static ModelAndView backToLoginMV(){
		return new ModelAndView("redirect:/login");
	}
	/**
	 * 
	 * TODO 返回到主搜索页面
	 * @author TangTianJiang
	 * @date 2014年1月6日 下午1:02:55
	 * @return
	 */
	public static ModelAndView backToMainSearch(){
		return new ModelAndView("redirect:/travel_book_page");
	}
	/**
	 * 返回ajax错误信息
	 * TODO
	 * @author TangTianJiang
	 * @date 2014年1月8日 下午9:45:50
	 * @param errorMsg
	 * @return
	 */
	public static AjaxResponse returnAjaxErrorResponse(String errorMsg){
		AjaxResponse response = new AjaxResponse();
		response.setStatus(AjaxResponseStatus.FAILED);
		response.setMessage(errorMsg);
		return response;
	}
	
	public static AjaxResponse returnAjaxErrorResponseWithDataAndMsg(String errorMsg,Object data){
		AjaxResponse response = new AjaxResponse();
		response.setStatus(AjaxResponseStatus.FAILED);
		response.setData(data);
		response.setMessage(errorMsg);
		return response;
	}
	
	/**
	 * 返回ajax成功
	 * TODO
	 * @author TangTianJiang
	 * @date 2014年1月8日 下午9:45:50
	 * @param errorMsg
	 * @return
	 */
	public static AjaxResponse returnAjaxSuccessResponse(){
		AjaxResponse response = new AjaxResponse();
		response.setStatus(AjaxResponseStatus.SUCCESS);
		return response;
	}
	
	/**
	 * 返回ajax成功
	 * TODO
	 * @author TangTianJiang
	 * @date 2014年1月8日 下午9:45:50
	 * @param errorMsg
	 * @return
	 */
	public static AjaxResponse returnAjaxSuccessResponseWithData(Object data){
		AjaxResponse response = new AjaxResponse();
		response.setData(data);
		response.setStatus(AjaxResponseStatus.SUCCESS);
		return response;
	}
	
	/**
	 * 返回CheckEnableMsgEntity内的错误消息
	 * TODO
	 * @author TangTianJiang
	 * @date 2014年1月8日 下午9:45:50
	 * @param errorMsg
	 * @return
	 */
	public static AjaxResponse returnAjaxErrorResponseWithCheckEnableEntity(CheckEnableMsgEntity<String> checkResult ,String defaultMsg){
		if (null != checkResult.getCheckBackObj()) {
			return returnAjaxErrorResponse(checkResult.getCheckBackObj());
		}else{
			return returnAjaxErrorResponse(defaultMsg);
		}
	}
	
}
