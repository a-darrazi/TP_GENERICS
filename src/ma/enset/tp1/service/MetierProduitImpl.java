package ma.enset.tp1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ma.enset.tp1.entities.Produit;

public class MetierProduitImpl implements IMetier<Produit>{
	private List<Produit> produits = new ArrayList<>();

	@Override
	public void add(Produit p) {
		Produit produit = null;
		
		//generate unique random id
		do {
			Long randomId = new Random().nextLong();
			p.setId(randomId<0? randomId*-1:randomId);
			produit = findById(p.getId());
		}while(produit != null);
		
		this.produits.add(p);
	}

	@Override
	public List<Produit> getAll() {
		return this.produits;
	}

	@Override
	public Produit findById(long id) {
		try {
			Produit produit = this.produits.stream().filter(p->p.getId() == id).findFirst().get();
			return produit;
		}catch(Exception e) {
			System.err.println("produit n'exist pas");
			return null;
		}
	}

	@Override
	public void delete(long id) {
		Produit produit = findById(id);
		if(produit == null) return;
		this.produits.remove(produit);
	}

}
