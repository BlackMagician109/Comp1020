
public class TestPhase2 {

	public static void main(String[] args) {
		
		Player pike = new Player("Ashley Johnson");
		Player vex = new Player("Laura Bailey");
		Player vax = new Player("Liam O'Brien");
		Player keyleth = new Player("Marisha Ray");
		Player scanlan = new Player("Sam Riegel");
		Player percy = new Player("Taliesin Jaffe");
		Player grog = new Player("Travis Willingham");

		
		System.out.println("The following tests should print the player names " +
		" for a given team in the format of: \n" +
		"Team Members: \n" +
		"1: Ashley Johnson \n" +
		"etc. Each player on their own line");
		System.out.println();
		
		Team voxMachina = new Team();
		
		voxMachina.addMember(pike);
		System.out.println(voxMachina);
		System.out.println();
		
		voxMachina.addMember(vex);
		System.out.println(voxMachina);
		System.out.println();
		
		voxMachina.addMember(vex);
		System.out.println(voxMachina);
		System.out.println();
		voxMachina.addMember(vax);
		voxMachina.addMember(keyleth);
				
		System.out.println(voxMachina);
		System.out.println();
		
		System.out.println("Is the team full? Should print false");
		System.out.println(voxMachina.teamFull());
		System.out.println();
		
		voxMachina.addMember(scanlan);
		System.out.println(voxMachina);
		System.out.println("Is the team full? Should print true");
		System.out.println(voxMachina.teamFull());
		System.out.println();
		
		voxMachina.addMember(percy);
		voxMachina.addMember(grog);
		voxMachina.removePlayer(percy);
		System.out.println("Team list should be unchanged:");
		System.out.println(voxMachina);
		System.out.println();
		
		System.out.println("Is the team full? Should print true");
		System.out.println(voxMachina.teamFull());
		System.out.println();
		
		voxMachina.addMember(grog);
		System.out.println(voxMachina);
		System.out.println("Is the team full? Should print true");
		System.out.println(voxMachina.teamFull());
		System.out.println();


		Team badGuys = new Team();
		badGuys.addMember(percy);
		System.out.println("Are there common members? Should print false");
		System.out.println(voxMachina.hasCommonPlayers(badGuys));
		badGuys.addMember(pike);
		System.out.println("Are there common members now? Should print true");
		System.out.println(voxMachina.hasCommonPlayers(badGuys));
		System.out.println("Is the team full? Should print false");
		System.out.println(badGuys.teamFull());
		
		
		
	}

}
