package com.lab.model;

import java.io.Serializable;

public class Tutorial  implements Serializable{
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -7473757553955627600L;

	private Long id;

    private String title;

    private String description;

    private Boolean published;

    public Tutorial(String title, String description, Boolean published) {
		this.title = title;
		this.description = description;
		this.published = published;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }
}