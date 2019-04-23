public class good extends theHumanCondition
{
	String name;
	Mediator mediatingThing;
	public good(String name) {
		mediatingThing = Mediator.getInstance();
		mediatingThing.registerGood(this);
		this.name =name;
	}

	public String getEvilName() {
		return mediatingThing.getEvilName();
	}

	public String getName() {
		return name;
	}

}
