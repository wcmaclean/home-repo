public class evil extends theHumanCondition
{
	String name;
	Mediator mediatingThing;
	public evil(String name) {
		mediatingThing = Mediator.getInstance();
		mediatingThing.registerEvil(this);
		this.name =name;
	}

	public String getGoodName() {
		return mediatingThing.getGoodName();
	}

	public String getName() {
		return name;
	}

}
