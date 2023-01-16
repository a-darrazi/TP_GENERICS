package ma.enset.tp1.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ma.enset.tp1.entities.Produit;

public class MetierProduitImpl implements IMetier<Produit,Long>{
	private List<Produit> produits;
	private static final String pathname = "produits.dat";

	public MetierProduitImpl(){
		this.loadProducts();
	}

	@Override
	public Produit add(Produit p) {
		Produit produit = null;

		//generate unique random id
		do {
			Long randomId = new Random().nextLong();
			p.setId(randomId<0? randomId*-1:randomId);
			produit = findById(p.getId());
		}while(produit != null);
		this.produits.add(p);
		this.saveAll();
		return p;
	}

	@Override
	public List<Produit> getAll() {
		return this.produits;
	}

	@Override
	public void saveAll() {
		try{
			File file = new File(pathname);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
			objectOutputStream.writeObject(this.produits);
			objectOutputStream.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public Produit findById(Long id) {
		try {
			Produit produit = this.produits.stream().filter(p->p.getId() == id).findFirst().get();
			return produit;
		}catch(Exception e) {
			System.err.println("produit n'exist pas");
			return null;
		}
	}

	@Override
	public void delete(Long id) {
		Produit produit = findById(id);
		if(produit == null) return;
		this.produits.remove(produit);
		this.saveAll();
	}

	private void loadProducts()  {
		try{
			File file = new File(pathname);
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
			this.produits = (List<Produit>) objectInputStream.readObject();
		}catch (Exception e){
			this.produits = new ArrayList<>();
		}
	}

}
