package com.majomi.zeninstants.messagesentities;

import java.io.Serializable;

import com.majomi.zeninstants.AppLog;


public class MessageTextEntity implements Cloneable, Serializable {
	private static final long serialVersionUID = 8111201739719136190L;
	
	protected long id = 1;
	private String text;
	private String summary; // Text shown in historical
	private String urlMoreInfo;
	private boolean favorite = false;


	public MessageTextEntity() {
		this.text = new String();
		this.summary = new String();
	}

	public MessageTextEntity(String text) {
		super();
		this.text = text;
		if(text.length()> 40)
			this.summary = text.substring(0, 40) + "...";
		else
			this.summary = text;
	}

	public MessageTextEntity(String text, String summary) {
		super();
		this.text = text;
		this.summary = summary;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getLayout(){return -1;}

	public String getUrlMoreInfo() {
		return urlMoreInfo;
	}

	public void setUrlMoreInfo(String urlMoreInfo) {
		this.urlMoreInfo = urlMoreInfo;
	}

	public boolean isFavorite() {
		return favorite;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}

	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch(CloneNotSupportedException cnse) {
			AppLog.logWarningString(cnse.getMessage());
		}

		return o;
	}


	/*	
	public void setHistorialContent(Activity act, View vi)
	{
		TextView summarytext = (TextView) vi.findViewById(R.id.hmtext);
		summarytext.setText(getSummary());
	}
	 */	
}