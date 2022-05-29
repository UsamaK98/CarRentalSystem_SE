package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="car")
public class Car {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="model")
	private String model;
	
	@Column(name="make")
	private String make;
	
	@Column(name="type")
	private String type;
	
	@Column(name="rent")
	private int rent;
	
	public Car() {
		super();
	}
	
	public Car(String n,String m,String t,String r) {
		model=n;
		make=m;
		type=t;
		rent=Integer.parseInt(r);
	}
	
}
