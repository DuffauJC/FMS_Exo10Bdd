/**
 * 
 */
package fr.fms.business;

import java.util.ArrayList;

import fr.fms.entities.Article;



/**
 * @author Stagiaires08P
 *
 */
public interface IShopBusiness {

	public void addCard(Article article);													//ajoute un compte associé à un client à notre banque
	public Account consultAccount(long accountId);												//renvoi le compte correspondant à l'id 
	public void pay(long accountId, double amount) ;											//faire un versement sur un compte 
	public boolean withdraw(long accountId, double amount);										//faire un retrait sur un compte
	public void transfert(long accountId, long accIdDest, double amount)throws Exception;	    //faire un virement d'un compte source vers destination
	public ArrayList<Transaction> listTransactions(long accountId); 
}
