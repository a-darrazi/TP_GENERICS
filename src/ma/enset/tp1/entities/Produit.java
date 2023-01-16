package ma.enset.tp1.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class Produit implements Serializable {
	private Long id;
	private String nom;
	private String marque;
	private BigDecimal price;
	private String description;
	private int stock;
	
	
	
	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", marque=" + marque + ", price=" + price + ", description="
				+ description + ", stock=" + stock + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

	
}
