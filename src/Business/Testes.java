package Business;

import Gui.MainFrame;

public class Testes {
	
	public static void show(Cell[] gridcells) {
		for(int i=0;i<10;i++) {
			for(int j=0;j<20;j++) {
				if(gridcells[i*20+j].isAlive()) {
					System.out.print(1);
				}else {
					System.out.print(0);
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws InterruptedException{
		
		new MainFrame();
		/*
		Simulation sim = new Simulation(20, 60);
		Player p = new Player(Player.CURSOR_LIVE, 0);
		
		sim.setVelocity(4500);
		
		sim.mutation(p, 1, 2);
		sim.mutation(p, 2, 2);
		sim.mutation(p, 3, 2);
		
		sim.mutation(p, 10, 4);
		sim.mutation(p, 10, 5);
		sim.mutation(p, 10, 6);
		
		sim.play();
		*/
	}

}
