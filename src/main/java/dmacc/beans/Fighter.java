package dmacc.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Ethan Dorenkamp - edorenkamp
 * CIS175 - Spring 2021
 * Apr 2, 2021
 */
@Entity
public class Fighter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int height; // Height in inches
	private double weight; // Weight in pounds
	private double wins;
	private double losses;
	private double ties;
	@Column(nullable = true)
	private double average; // Calculated as wins / (wins + losses + ties)
	
	public Fighter() {
		super();
	}

	public Fighter(String name) {
		super();
		this.name = name;
	}

	public Fighter(String name, int height, double weight, double wins, double losses, double ties) {
		super();
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.wins = wins;
		this.losses = losses;
		this.ties = ties;
		calculateAverage();
	}

	public Fighter(Long id, String name, int height, double weight, double wins, double losses, double ties) {
		super();
		this.id = id;
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.wins = wins;
		this.losses = losses;
		this.ties = ties;
		calculateAverage();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getWins() {
		return wins;
	}

	public void setWins(double wins) {
		this.wins = wins;
		calculateAverage();
	}

	public double getLosses() {
		return losses;
	}

	public void setLosses(double losses) {
		this.losses = losses;
		calculateAverage();
	}

	public double getTies() {
		return ties;
	}

	public void setTies(double ties) {
		this.ties = ties;
		calculateAverage();
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	} 

	@Override
	public String toString() {
		return "Fighter [id=" + id + ", name=" + name + ", height=" + height + ", weight=" + weight + ", wins=" + wins
				+ ", losses=" + losses + ", ties=" + ties + ", average=" + average + "]";
	}

	// Called upon object creation when given wins, losses, and ties. Also called when wins, losses, or ties are updated
	private void calculateAverage() {
		this.average = this.wins / (this.wins + this.losses + this.ties);
	}

	
}
