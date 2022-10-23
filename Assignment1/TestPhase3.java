
public class TestPhase3 {

	public static void main(String[] args) {
		
		Player pike = new Player("Ashley Johnson");
		Player vex = new Player("Laura Bailey");
		Player vax = new Player("Liam O'Brien");
		Player keyleth = new Player("Liam O'Brien");
		Player scanlan = new Player("Sam Riegel");
		Player percy = new Player("Taliesin Jaffe");
		
		Team voxMachina = new Team();
		
		voxMachina.addMember(pike);
		voxMachina.addMember(vex);
		voxMachina.addMember(vax);
		voxMachina.addMember(keyleth);
		voxMachina.addMember(scanlan);
		voxMachina.addMember(percy);
		System.out.println(voxMachina);
		System.out.println("Is the team full? Should print true");
		System.out.println(voxMachina.teamFull());

		Team cTeam = new Team();
		Player kthriss = new Player("Chris Straub");
		Player walnut = new Player("Amy Falcone");
		Player rosie = new Player("Kate Welch");
		Player donaar = new Player("Ryan Hartman");
		Player omin = new Player("Jerry Holkins");
		cTeam.addMember(kthriss);
		cTeam.addMember(walnut);
		cTeam.addMember(rosie);
		cTeam.addMember(donaar);
		cTeam.addMember(omin);
				
		System.out.println(cTeam);
		System.out.println("Is the team full? Should print true");
		System.out.println(cTeam.teamFull());
		System.out.println();
		
		Game game = new Game(voxMachina, cTeam);
		System.out.println("Is Game Valid? Should print true");
		System.out.println(game.validGame());
		System.out.println();
		
		Team riffRaff = new Team();
		riffRaff.addMember(pike);
		riffRaff.addMember(vex);
		riffRaff.addMember(walnut);
		riffRaff.addMember(donaar);
		riffRaff.addMember(omin);
		
		Game badGame = new Game(voxMachina, riffRaff);
		System.out.println("Is Game Valid? Should print false");
		System.out.println(badGame.validGame());
		System.out.println();
		
		game.awardWinner(cTeam, 100);
		System.out.println("Should print: Player: Jerry Holkins " +
		"has played 1 game with an average of 20");
		System.out.println(omin);
		System.out.println();
		
		System.out.println("Print a header for Team Rosters and both teams, nicely spaced");
		System.out.println(game);
		
	}

}
