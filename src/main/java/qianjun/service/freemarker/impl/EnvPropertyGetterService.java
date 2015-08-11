package qianjun.service.freemarker.impl;

import java.util.List;

import qianjun.common.TZUtil;
import qianjun.common.WebEnv;
import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
/**
 * 获取系统的环境变量
 * @author tangtianjiang
 * @date 2013-12-02
 */
public class EnvPropertyGetterService implements TemplateMethodModel{
	@SuppressWarnings("rawtypes")
	@Override
	public Object exec(List arguments) throws TemplateModelException {
		if (TZUtil.isEmpty(arguments)) {
			return null;
		}
		Object key = arguments.get(0);
		if (key == null) {
			return null;
		}
		return WebEnv.get(key.toString(), "");
	}
	
}

