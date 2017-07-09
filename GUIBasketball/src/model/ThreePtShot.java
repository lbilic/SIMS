package model;

public class ThreePtShot extends Shot{

	public ThreePtShot(Player contributor, String scored, int _x, int _y) {
		setContributor(contributor);
		made = scored.equalsIgnoreCase("dao");
		x = _x;
		y = _y;
	}

}
