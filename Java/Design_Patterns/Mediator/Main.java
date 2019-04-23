public class Main
{
	public Main(){
		good goodThing = new good("Batman");
		evil evilThing = new evil("Joker");
		System.out.println("Joker's Archnemesis is: " + goodThing.getEvilName());
		System.out.println("Batman's Archnemesis is: " + evilThing.getGoodName());
		System.out.println("\nBut as the story goes...");
		System.out.println("The Batmobile lost it's wheel, and the Joker got away.");
	}

	public static void main(String[] args) {
		new Main();
	}
}
