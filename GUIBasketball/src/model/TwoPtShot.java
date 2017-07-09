package model;

public class TwoPtShot extends Shot{

	public TwoPtShot(Player contributor, String scored, int _x, int _y) {
		setContributor(contributor);
		made = scored.equalsIgnoreCase("dao");
		x = _x;
		y = _y;
	}

}
