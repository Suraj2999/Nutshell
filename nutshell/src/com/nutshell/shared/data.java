package com.nutshell.shared;

import java.io.Serializable;

public class data implements Serializable
{
	String image="";
	String headline="";
	String tag="";
	String summary="";
	String category="";
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImage() 
	{
		return image;
	}
	public void setImage(String image) 
	{
		this.image = image;
	}
	public String getHeadline() 
	{
		return headline;
	}
	public void setHeadline(String headline) 
	{
		this.headline = headline;
	}
	public String getTag() 
	{
		return tag;
	}
	public void setTag(String tag) 
	{
		this.tag = tag;
	}
	public String getSummary() 
	{
		return summary;
	}
	public void setSummary(String summary) 
	{
		this.summary = summary;
	}


}
