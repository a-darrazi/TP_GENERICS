package ma.enset.tp1;

import java.math.BigDecimal;
import java.util.Scanner;

import ma.enset.tp1.entities.Produit;
import ma.enset.tp1.service.IMetier;
import ma.enset.tp1.service.MetierProduitImpl;

public class Application {

	public static void main(String[] args) {
		IMetier<Produit,Long> iMetier = new MetierProduitImpl();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			menu();
			System.out.print("taper votre choix: ");
			String choix = scanner.nextLine();
			switch (choix) {
			case "1":
				System.out.println("afficher la liste des produits ...");
				if (iMetier.getAll().size() == 0) {
					System.err.println("la list des produit est vide pour le moment !!");
					continue;
				}
				iMetier.getAll().forEach(System.out::println);
				break;
			case "2":
				System.out.println("rechercher un produit par son id");
				System.out.print("taper un id: ");
				Long id = Long.parseLong(scanner.nextLine());
				Produit p = iMetier.findById(id);
				if (p == null)
					continue;
				System.out.println(p);
				break;
			case "3":
				System.out.println("ajouter un nouveau produit");
				Produit produit = new Produit();
				System.out.print("taper le nom de ce produit: ");
				produit.setNom(scanner.nextLine());
				System.out.print("taper la marque de ce produit: ");
				produit.setMarque(scanner.nextLine());
				System.out.print("taper le prix de ce produit: ");
				produit.setPrice(BigDecimal.valueOf(Double.parseDouble(scanner.nextLine())));
				System.out.print("taper une description de ce produit: ");
				produit.setDescription(scanner.nextLine());
				System.out.print("taper le stock: ");
				produit.setStock(Integer.parseInt(scanner.nextLine()));
				iMetier.add(produit);
				break;
			case "4":
				System.out.println("supprimer un produit par id");
				System.out.print("taper un id: ");
				Long idp = Long.parseLong(scanner.nextLine());
				iMetier.delete(idp);
				break;
			case "5":
				iMetier.saveAll();
				System.out.println("saved!!");
				break;
			case "6":
				System.err.print("vous avez quitter le programme");
				System.exit(0);
				break;
			default:
				System.err.println("choix incorrect !!");
				break;
			}
		}
	}

	private static void menu() {
		System.out.println("-------------------------------- Menu --------------------------------------");
		System.out.println("tapper: ");
		System.out.println("1. pour afficher la liste des produits");
		System.out.println("2. pour rechercher un produit par son id");
		System.out.println("3. pour ajouter un nouveau produit dans la liste");
		System.out.println("4. pour supprimer un produit par id");
		System.out.println("5. pour sauvegarder la list des produit");
		System.out.println("6. pour quitter ce programme");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println();
	}

}
