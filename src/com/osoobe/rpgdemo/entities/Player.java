package com.osoobe.rpgdemo.entities;

import java.awt.Graphics;

import com.osoobe.rpgdemo.Game;
import com.osoobe.rpgdemo.gfx.SpriteSheet;

public class Player {
	int x, y;
	SpriteSheet ss_image;
	
	public Player(int x, int y, SpriteSheet image){
		this.x = x;
		this.y = y;
		ss_image = image;
	}
	
	public void tick(){
		
	}
	
	/**
	 * Change the player position on the screen
	 * @param graphics
	 */
	public void render(Graphics graphics){
		graphics.drawImage(ss_image.cropped(0, 0, 16, 16), x, y, 16*Game.SCALE, 16*Game.SCALE, null);
	}
	
}
