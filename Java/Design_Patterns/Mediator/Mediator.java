public class Mediator
{
	private good good;
	private evil evil;
	private static final Mediator instance = new
Mediator();
	private Mediator(){
	}

	public static Mediator getInstance() {
		return instance;
	}

	public void registerGood(good goodThing) {
		good = goodThing;
	}

	public void registerEvil(evil evilThing) {
		evil = evilThing;
	}

	public String getGoodName() {
		return good.getName();
	}

	public String getEvilName(){
		return evil.getName();
	}
}
