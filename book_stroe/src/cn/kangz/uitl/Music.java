package cn.kangz.uitl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;
 
 
public class Music extends Thread {
	Player player;
	File music;
 
	public Music() {
		this.music = new File("music\\��������.mp3");;
	}
 
	@Override
	public void run() {
		super.run();
		try {
			play();
		} catch (FileNotFoundException | JavaLayerException e) {
			e.printStackTrace();
		}
	}
 
	public void play() throws FileNotFoundException, JavaLayerException {
		BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(music));
		player = new Player(buffer);
		player.play();
	}
//public static void main(String[] args) {
//	Music m = new Music();
//	m.start();
//}
}

