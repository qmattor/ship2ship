package ship2ship;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ship implements drawable, updatable {
	public enum size {SLOOP, BRIG, GALLEON};
	BufferedImage bimg;
	private size shipSize;
	private double x, y;
	private double heading, velocity;

	private static BufferedImage rotate(BufferedImage bimg, Double angle) {
		double sin = Math.abs(Math.sin(Math.toRadians(angle))),
				cos = Math.abs(Math.cos(Math.toRadians(angle)));
		int w = bimg.getWidth();
		int h = bimg.getHeight();
		int neww = (int) Math.floor(w*cos + h*sin),
				newh = (int) Math.floor(h*cos + w*sin);
		BufferedImage rotated = new BufferedImage(neww, newh, bimg.getType());
		Graphics2D graphic = rotated.createGraphics();
		graphic.translate((neww-w)/2, (newh-h)/2);
		graphic.rotate(Math.toRadians(angle), w/2, h/2);
		graphic.drawRenderedImage(bimg, null);
		graphic.dispose();
		return rotated;
	}

	public ship(size sSize, double x, double y, double h, double v) {
		shipSize = sSize;
		this.x = x;
		this.y = y;
		heading = h;
		velocity = v;
		try {
			switch (sSize) {
				case SLOOP:
					bimg = ImageIO.read(new File("sloopimg.png"));
					break;
				case BRIG:
					bimg = ImageIO.read(new File("brigimg.png"));
					break;
				case GALLEON:
					bimg = ImageIO.read(new File("galleonimg.png"));
					break;
				default:
					throw new RuntimeException("N_sup size");
			}
		} catch (IOException e) {
			System.out.println("Could not load image for ship2ship.ship");
		}
	}

	@Override
	public void draw(Graphics g) {

	}

	@Override
	public void update() {

	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
}
