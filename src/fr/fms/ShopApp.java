package fr.fms;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import fr.fms.dao.ArticleDao;

import fr.fms.dao.UserDao;
import fr.fms.entities.Article;
import fr.fms.entities.User;


public class ShopApp {


	private static ArticleDao shop;	
	private static UserDao user;
	private static ArrayList<Article> articles;
	private static ArrayList<User> users;

	/**
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) {
		
		try {
		shopInit();
		welcome();

		Scanner scan = new Scanner(System.in); 

		String login = "";
		String password = "";
		User userOk=null;

		System.out.println("Tapez votre login et mot de passe pour accéder au menu.");

		// Verfie si le compte existe.
		userOk=	scanLogin(scan,login,password);

		if (userOk!=null) {
			System.out.println("Salut "+userOk.getLogin());	
			listArticles();
		} else {
			System.out.println("Client inexistant.");
		}
		


		scan.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	

		// insertion d'un article
		//Article art=new Article("Tapis de souris","Asus",45.99 );
		//shop.create(art);

		// mise à jour d'un article que je récupère
		//Article modifArticle=shop.read(4);
		//modif.setDescription("Tapis de douche");
		//modif.setBrand("Baleine bleue");
		//modif.setUnitaryPrice(499.99);
		//shop.update(modif);

		// suppression d'un article
		//shop.delete(4);

		// lecture d'un article en fonction de son identifiant
		/*
		 * Article readArticle=shop.read(16); if (readArticle!=null) {
		 * System.out.println("Affichage de l' "+readArticle.toString()); } else {
		 * System.out.println("Article inexistant"); }
		 */

		///////////////////////////////////////////// User

		// insertion d'un utilisateur
		//User util=new User("JCD","zozo31" );
		//user.create(util);

		//Liste users
		//listUsers();

		// mise à jour d'un utilisateur que je récupère
		//User modifUser=user.read(3);
		//modifUser.setPassword("Chewby82");
		//user.update(modifUser);

		// suppression d'un utilisateur
		//user.delete(5);

		// lecture d'un utilisateur en fonction de son identifiant

		//User readUser=user.read(4); if (readUser!=null) {
		//System.out.println("Affichage de l' "+readUser.toString()); } else {
		//System.out.println("Article inexistant"); }

		

	}
	// lecture de la table articles
	private static void listArticles() throws SQLException {

		System.out.println("Liste des articles : ");
		for(Article a : shop.readAll())
			System.out.println(a);

	}

	// lecture de la table users
	private static void listUsers() {

		System.out.println("Liste des utilisateurs : ");
		for(User u : users)
			System.out.println(u);

	}
	private static User scanLogin(Scanner scan, String login, String password) {
		User user = null;
		login=scan.next(); 
		password=scan.next();
		for (User u : users) {
			if (u.getLogin().equals(login) && u.getPassword().equals(password)) {
				user=new User(u.getIdUser(),u.getLogin(),u.getPassword());
			}
		}
		return user;
	}
	/**
	 * initialisation de la boutique
	 * @throws SQLException 
	 */
	private static void shopInit() throws SQLException {
		// TODO Auto-generated method stub
		shop = new ArticleDao();
		user=new UserDao();
		users=user.readAll();


	}

	/**
	 * affiche message bienvenue
	 */
	private static void welcome() {
		System.out.println();
		System.out.println("************************************");
		System.out.println("   BIENVENU CHEZ SHOPPING-SHOPPANG");
		System.out.println("************************************");		
		System.out.println();
	}
}

