package com.touchhy.web.linweb.common.tool;

import java.util.ArrayList;
import java.util.List;

public class PageResourceConfigTool {
	private List<String> scripts  = new ArrayList<String>();
	private List<String> csses = new ArrayList<String>();
	public List<String> getScripts() {
		return scripts;
	}
	public void setScripts(List<String> scripts) {
		this.scripts = scripts;
	}
	
	public List<String> getCsses() {
		return csses;
	}
	public void setCsses(List<String> csses) {
		this.csses = csses;
	}
	public void addScript(String script){
		scripts.add(script);
	}
	public void addCss(String css){
		csses.add(css);
	}
}
