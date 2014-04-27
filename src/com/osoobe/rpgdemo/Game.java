/**
 * 
 */
package com.osoobe.rpgdemo;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import com.osoobe.rpgdemo.entities.Player;
import com.osoobe.rpgdemo.gfx.ImageLoader;
import com.osoobe.rpgdemo.gfx.SpriteSheet;

/**
 * @author Oshane Bailey
 *
 */
public class Game extends Canvas implements Runnable{
	public static final int WIDTH = 400, HEIGHT = 300, SCALE = 2;
	public static boolean running = false;
	public Thread thread_game;
	BufferedImage spriteImage;
	Player player;
	
	public static void main(String[] args){
		Game game = new Game();
		game.setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		game.setMaximumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		game.setMinimumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		
		JFrame jf_game = new JFrame("RPG Demo");
		jf_game.setSize(WIDTH*SCALE, HEIGHT*SCALE);
		jf_game.setResizable(false);
		jf_game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf_game.getContentPane().add(game);
		jf_game.setVisible(true);
		game.init();
		game.start();
	}
	
	public void init(){
		ImageLoader imLoader = new ImageLoader();
		spriteImage = imLoader.load("/sprites.png");
		
		SpriteSheet ss_image = new SpriteSheet(spriteImage);
		
		player = new Player(0,0,ss_image);
	}
	
	public void run() {
		// TODO Auto-generated method stub
		long lastTime = System.nanoTime();
		final double numTicks = 60D;
		double ns = 1000000000/numTicks;
		double delta = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime)/ns;
			lastTime = now;
			if(delta >= 1){
				tick();				
			}
			render();
		}
		stop();
	}
	
	/**
	 * Update the canvas elements and components data
	 */
	public void tick(){
		player.tick();
		
	}
	
	/**
	 * Render and repaint all elements and components
	 */
	public void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		Graphics gp = bs.getDrawGraphics();
		//start rendering
		gp.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);		
		player.render(gp);
		//stop rendering
		gp.dispose();		
		bs.show();
	}
	
	public synchronized void start(){
		if(running) return;
		running = true;
		thread_game = new Thread(this);
		thread_game.start();
	}
	
	
	/**
	 * Check if the thread is running and stop it
	 */
	public synchronized void stop(){
		if(!running) return;
		running = false;
		try {
			thread_game.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
