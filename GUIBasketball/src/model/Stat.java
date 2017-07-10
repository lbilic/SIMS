package model;

public class Stat {
	private int points;
	private int fgm;
	private int  fga;
	private double fg_percentage;
	private int ftm;
	private int fta;
	private double ft_percentage;
	private int assists;
	private int rebounds;
	private int defensive_rebounds;
	private int offensive_rebounds;
	private int steals;
	private int turnovers;
	private int fouls;
	
	public Stat() {
		this.points = 0;
		this.fgm = 0;
		this.fga = 0;
		this.fg_percentage = 0;
		this.ftm = 0;
		this.fta = 0;
		this.ft_percentage = 0;
		this.assists = 0;
		this.rebounds = 0;
		this.defensive_rebounds = 0;
		this.offensive_rebounds = 0;
		this.steals = 0;
		this.turnovers = 0;
		this.fouls = 0;
	}
	
	public Stat(int points, int fgm, int fga, double fg_percentage, int ftm, int fta, double ft_percentage, int assists,
			int rebounds, int defensive_rebounds, int offensive_rebounds, int steals, int turnovers, int fouls) {
		super();
		this.points = points;
		this.fgm = fgm;
		this.fga = fga;
		this.fg_percentage = fg_percentage;
		this.ftm = ftm;
		this.fta = fta;
		this.ft_percentage = ft_percentage;
		this.assists = assists;
		this.rebounds = rebounds;
		this.defensive_rebounds = defensive_rebounds;
		this.offensive_rebounds = offensive_rebounds;
		this.steals = steals;
		this.turnovers = turnovers;
		this.fouls = fouls;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getFgm() {
		return fgm;
	}

	public void setFgm(int fgm) {
		this.fgm = fgm;
	}

	public int getFga() {
		return fga;
	}

	public void setFga(int fga) {
		this.fga = fga;
	}

	public double getFg_percentage() {
		return fg_percentage;
	}

	public void setFg_percentage(double fg_percentage) {
		this.fg_percentage = fg_percentage;
	}

	public int getFtm() {
		return ftm;
	}

	public void setFtm(int ftm) {
		this.ftm = ftm;
	}

	public int getFta() {
		return fta;
	}

	public void setFta(int fta) {
		this.fta = fta;
	}

	public double getFt_percentage() {
		return ft_percentage;
	}

	public void setFt_percentage(double ft_percentage) {
		this.ft_percentage = ft_percentage;
	}

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public int getRebounds() {
		return rebounds;
	}

	public void setRebounds(int rebounds) {
		this.rebounds = rebounds;
	}

	public int getDefensive_rebounds() {
		return defensive_rebounds;
	}

	public void setDefensive_rebounds(int defensive_rebounds) {
		this.defensive_rebounds = defensive_rebounds;
	}

	public int getOffensive_rebounds() {
		return offensive_rebounds;
	}

	public void setOffensive_rebounds(int offensive_rebounds) {
		this.offensive_rebounds = offensive_rebounds;
	}

	public int getSteals() {
		return steals;
	}

	public void setSteals(int steals) {
		this.steals = steals;
	}

	public int getTurnovers() {
		return turnovers;
	}

	public void setTurnovers(int turnovers) {
		this.turnovers = turnovers;
	}

	public int getFouls() {
		return fouls;
	}

	public void setFouls(int fouls) {
		this.fouls = fouls;
	}
	
	
}
