
public class TestPhase4 {

	public static void main(String[] args) {
		
		Location place = new Location("Darkzone", "Confusion corner");
		
		Player pike = new Player("Ashley Johnson");
		Player vex = new Player("Laura Bailey");
		Player vax = new Player("Liam O'Brien");
		Player keyleth = new Player("Liam O'Brien");
		Player scanlan = new Player("Sam Riegel");
		Player percy = new Player("Taliesin Jaffe");

		place.addMember(pike);
		place.addMember(vex);
		place.addMember(vax);
		place.addMember(keyleth);
		place.addMember(scanlan);
		place.addMember(percy);
		
		Team voxMachina = new Team();
		
		voxMachina.addMember(pike);
		voxMachina.addMember(vex);
		voxMachina.addMember(vax);
		voxMachina.addMember(keyleth);
		voxMachina.addMember(scanlan);
		voxMachina.addMember(percy);
		
		System.out.println("Membership list for location should print FIVE players");
		System.out.println(place);
		System.out.println();
		
		Player grog = new Player("Travis Willingham", place);
		System.out.println("Membership list for location should print SIX players");
		System.out.println(place);
		System.out.println();
		
		Location laserTopia = new Location("LaserTopia", "Waverley Ave");
		Team cTeam = new Team();
		Player kthriss = new Player("Chris Straub", laserTopia);
		Player walnut = new Player("Amy Falcone", laserTopia);
		Player rosie = new Player("Kate Welch", laserTopia);
		Player donaar = new Player("Ryan Hartman", laserTopia);
		Player omin = new Player("Jerry Holkins", laserTopia);
		cTeam.addMember(kthriss);
		cTeam.addMember(walnut);
		cTeam.addMember(rosie);
		cTeam.addMember(donaar);
		cTeam.addMember(omin);

		Game game = new Game(voxMachina, cTeam);
		game.awardWinner(cTeam, 100);
		
		System.out.println("Membership list for location should print FIVE players each " +
		"with average of 20");
		System.out.println(laserTopia);
		System.out.println();

		System.out.println("Membership list for location should print FIVE players each " +
		"with average of 0 and ONE with no average as no games played");
		System.out.println(place);
		System.out.println();
		
		System.out.println("Should print header with 2 locations");
		System.out.println(Location.allLocationNames());
		System.out.println();
		
		System.out.println("Should print: Travis Willingham is a member at: Darkzone");
		System.out.println(Location.whichLocations(grog));
		laserTopia.addMember(grog);
		System.out.println();
		
		Player tiberius = new Player("Orion Acaba");
		System.out.println("Should print: Orion Acaba is a member at:"); // NO LOCATIONS
		System.out.println(Location.whichLocations(tiberius));
		System.out.println("Should print: Orion Acaba is a member at: LaserTopics");
		laserTopia.addMember(tiberius);
		System.out.println(Location.whichLocations(tiberius));
		System.out.println("Should print: Orion Acaba is a member at:\nDarkzone \nLasertopia");
		place.addMember(tiberius);
		System.out.println(Location.whichLocations(tiberius));
		System.out.println();

	}

}
