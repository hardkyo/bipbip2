package com.kitri.gallery.model;

import com.kitri.freeboard.model.BoardDto;

public class GalleryDto extends BoardDto {
	private int aseq;
	private String orignPicture;
	private String savePicture;
	private String saveFolder;
	private int type;

	public int getAseq() {
		return aseq;
	}

	public void setAseq(int aseq) {
		this.aseq = aseq;
	}

	public String getOrignPicture() {
		return orignPicture;
	}

	public void setOrignPicture(String orignPicture) {
		this.orignPicture = orignPicture;
	}

	public String getSavePicture() {
		return savePicture;
	}

	public void setSavePicture(String savePicture) {
		this.savePicture = savePicture;
	}

	public String getSaveFolder() {
		return saveFolder;
	}

	public void setSaveFolder(String saveFolder) {
		this.saveFolder = saveFolder;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
