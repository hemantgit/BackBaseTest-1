package com.backbase.test.mehdijavan.openbank;

import java.util.List;

public class OBTransactionMetadata {
	private String narrative; // text explaining the purpose of the transaction
	private List<OBComment> comments;
	private List<OBTag> tags;
	private List<OBImage> images;
	private OBLocation where;

	public String getNarrative() {
		return narrative;
	}

	public void setNarrative(String narrative) {
		this.narrative = narrative;
	}

	public List<OBComment> getComments() {
		return comments;
	}

	public void setComments(List<OBComment> comments) {
		this.comments = comments;
	}

	public List<OBTag> getTags() {
		return tags;
	}

	public void setTags(List<OBTag> tags) {
		this.tags = tags;
	}

	public List<OBImage> getImages() {
		return images;
	}

	public void setImages(List<OBImage> images) {
		this.images = images;
	}

	public OBLocation getWhere() {
		return where;
	}

	public void setWhere(OBLocation where) {
		this.where = where;
	}

}
