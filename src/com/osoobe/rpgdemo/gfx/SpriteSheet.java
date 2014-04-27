package com.osoobe.rpgdemo.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	private BufferedImage sheet;
	public static int default_size = 16;
	
	public SpriteSheet(BufferedImage sheet){
		this.sheet = sheet;
	}
	
	public BufferedImage cropped(int row, int col, int w, int h, int size){
		return sheet.getSubimage(row, col, w, h);
	}
	
	public BufferedImage cropped(int row, int col, int w, int h){
		return cropped(row, col, w, h, default_size);
	}
}

