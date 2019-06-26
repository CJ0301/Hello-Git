package com.zte.action;

import javax.swing.JLabel;

public class MyJLable extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int getCurrentNo() {
		return currentNo;
	}

	public void setCurrentNo(int currentNo) {
		this.currentNo = currentNo;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	private int currentNo;
	private Object content;
	private String type;
	

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public MyJLable(String title, int currentNo){
		super(title);
		this.currentNo = currentNo;
	}
	
	
	
}
