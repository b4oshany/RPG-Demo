package com.osoobe.rpgdemo.entities;

import java.awt.Graphics;

import com.osoobe.rpgdemo.Game;
import com.osoobe.rpgdemo.gfx.SpriteSheet;

public class Player {
	int x, y, h, w;
	SpriteSheet ss_image;
	
	public Player(SpriteSheet image, int x, int y, int w, int h){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		ss_image = image;
	}
	
	public Player(SpriteSheet image, int x, int y){
		this.x = x;
		this.y = y;
		this.w = 20;
		this.h = 20;
		ss_image = image;
	}
	
	public void tick(){
		
	}
	
	/**
	 * Change the player position on the screen
	 * @param graphics
	 */
	public void render(Graphics graphics){
		graphics.drawImage(ss_image.cropped(0, 4, w, h), x, y, w*Game.SCALE, h*Game.SCALE, null);
	}
	
}
