package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fruit_tbl")
public class Fruit {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	public Fruit() {

	}
	public Fruit(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String name() {
		return name;
	}
	public void name(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Fruit [id=" + id + ", name=" + name + "]";
	}
}
