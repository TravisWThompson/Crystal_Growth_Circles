package crystal_growth;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Frame extends JFrame{
	private static Panel panel;
	private static int Window_Size = 1000;
	
	
	public Frame(int Sample_Size, ArrayList<Grain> Grains) {
		setBounds(100, 100, Window_Size, Window_Size);
		panel = new Panel(Sample_Size, Window_Size, Grains);
		this.setContentPane(panel);	
	}

	public void updateDisplay(ArrayList<Grain> grains){
		panel.updateDisplay(grains);
	}
	
	
	
	public class Panel extends JPanel {
		private ArrayList<Grain> Grains;
		private int Window_Size;
		private int Sample_Size;
		
		public Panel(int samplesize, int windowsize, ArrayList<Grain> grains){
			Grains = grains;
			Window_Size = windowsize;
			Sample_Size = samplesize;
			this.setBackground(Color.WHITE);
			setVisible(true);
		}
		
		
		public void updateDisplay(ArrayList<Grain> grains){
			Grains = grains;
			repaint();
		}
		
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			
			for(int i = 0; i < Grains.size(); i++){
				int x = (int) Math.round(((double) Grains.get(i).getCenter().getComponent(0))
						* ((double)Window_Size) / ((double)Sample_Size)) - Grains.get(i).getRadius();
				int y = (int) Math.round(((double) Grains.get(i).getCenter().getComponent(1))
						* ((double)Window_Size) / ((double)Sample_Size)) - Grains.get(i).getRadius();
				int radius = Grains.get(i).getRadius();
				
				g.drawArc(x, y, radius *2, radius*2, 0, 360);
				
			}
		}
		
		
	}
	
	/**
	 * This thread will run the animation.
	 */
	/*
	@Override
	public void run() {
		
		while(true){
			repaint();
			try {
				Thread.sleep(16);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	*/
	
}
