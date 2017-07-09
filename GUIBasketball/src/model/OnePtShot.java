package model;

public class OnePtShot extends Shot{

	public OnePtShot(Player contributor, String scored, int _x, int _y) {
		setContributor(contributor);
		made = scored.equalsIgnoreCase("dao");
		x = _x;
		y = _y;
	}

}
