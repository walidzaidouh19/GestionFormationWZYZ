package com.sqli.Web;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sqli.model.Compte;
import com.sqli.service.CompteServImpl;
import com.sqli.service.CompteServInt;
import com.sqli.dao.*;


@ManagedBean(name = "authentificatonBean")
@SessionScoped


public class authentificatonBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String login;
	private String password;
	//Spring User Service is injected...
		@ManagedProperty(value="#{CompteService}")
	    CompteServInt service;
		
	
	private Compte c;

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@SuppressWarnings("unused")
	public void isConnect(ComponentSystemEvent event){

		FacesContext fc = FacesContext.getCurrentInstance();

		if (fc.getExternalContext().getSessionMap().get("teste")==null){

			ConfigurableNavigationHandler nav 
			= (ConfigurableNavigationHandler) 
			fc.getApplication().getNavigationHandler();

			nav.performNavigation("login");
		}			
	}


	public void logout() throws IOException{
		System.err.println("logout");
		c = new Compte();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("test",null);
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		ConfigurableNavigationHandler nav 
		= (ConfigurableNavigationHandler) 
		FacesContext.getCurrentInstance().getApplication().getNavigationHandler();

		nav.performNavigation("login");
		FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");


	}
	public void logout2(){
		c = new Compte();
		System.err.println("logout");
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("test",null);

	}
	public void isAdmin(ComponentSystemEvent event){

		FacesContext fc = FacesContext.getCurrentInstance();

		if (!"Administrateur".equals(fc.getExternalContext().getSessionMap().get("role"))){

			ConfigurableNavigationHandler nav 
			= (ConfigurableNavigationHandler) 
			fc.getApplication().getNavigationHandler();

			nav.performNavigation("Acceille");
		}

	}	
	public void isDirecteur(ComponentSystemEvent event){

		FacesContext fc = FacesContext.getCurrentInstance();

		if (!"Personnel".equals(fc.getExternalContext().getSessionMap().get("role"))){

			ConfigurableNavigationHandler nav 
			= (ConfigurableNavigationHandler) 
			fc.getApplication().getNavigationHandler();

			nav.performNavigation("Accueil_Cadre");
		}
	}
	public void isDirecteurs(ComponentSystemEvent event){

		FacesContext fc = FacesContext.getCurrentInstance();

		if (!"Directeur".equals(fc.getExternalContext().getSessionMap().get("role"))){

			ConfigurableNavigationHandler nav 
			= (ConfigurableNavigationHandler) 
			fc.getApplication().getNavigationHandler();

			nav.performNavigation("AccueilDirecteur");
		}
	}
	public String testsession(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		//try{
		//String l=facesContext.getExternalContext().getSessionMap().get("teste").toString();
		if(facesContext.getExternalContext().getSessionMap().get("teste")==null){
			System.out.print("/////////////////////////////////////////////////:");
			return "true";}
		//}catch(Exception e){
		else{

			System.err.print("/////////////////////////////////////////////////:");
			return "false";}

		//}
	}

	public String iscon(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		if(facesContext.getExternalContext().getSessionMap().get("teste")!=null){
			System.out.print("/////////////////////////////////////////////////:");
			return "true";}
		else{
			System.err.print("/////////////////////////////////////////////////:");
			return "false";}
	}

	public String redirectLogin(){
		System.err.println("login redirect");
		return "login?faces-redirect=true";
	}
	public String rediAdmin(){
		System.err.println("role :"+c.getProfil().getIntituleProfil());
		if(c!=null){
			if(c.getProfil().getIntituleProfil().equals("Administratif"))
				return "true";
			else
				return "false";
		}else
			return "false";
	}

	public String redirectpageAcceuil(){
		String page="login?faces-redirect=true";
		if(c!=null){
			if(c.getProfil().getIntituleProfil().equals("Personnel"))
				page="Acceuil_Cadre?faces-redirect=true";
			if(c.getProfil().getIntituleProfil().equals("directeur"))
				page="AccueuilDirecteur?faces-redirect=true";
			if(c.getProfil().getIntituleProfil().equals("Administratif"))
				page="Accueil?faces-redirect=true";
		}
		return page; 
	}

	public String rediPersonnel(){
		if(c.getProfil().getIntituleProfil().equals("Personnel"))
			return "true";
		else
			return "false";
	}

	public String rediDirecteur(){

		if(c.getProfil().getIntituleProfil().equals("directeur"))
			return "true";
		else
			return "false";
	}

	public String redirect() { 
		return "Accueil";
	}

	public String redirect404(){
		System.err.println("404");
		return "404?faces-redirect=true";
	}
	public String save(){
		System.out.println(login);
		System.out.println(password);

		if(login==null || password==null){
			System.out.print("Le login ou password session est invalide");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Le login ou password session est invalide !!! ", ""));   
			return "login" ; 

		}
		else{
			System.out.println("########################################");
			c=service.getCompteS(login);
			if(c==null){
				System.out.println("Le Login et le password sont incorrects!");
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Le Login et le password sont incorrects!", ""));   
				return "login" ; 
			}
			else{
				String pass=c.getPassword();
				if (pass==null|| !password.equals(pass))  {
					System.out.println("Le password de session est incorrect!");
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Le Login et le password sont incorrects! ", ""));   
					return "login" ; 
				}
				else {
					FacesContext facesContext = FacesContext.getCurrentInstance();
					facesContext.getExternalContext().getSessionMap().put("teste",c.getIdCompte());
					facesContext.getExternalContext().getSessionMap().put("role",c.getProfil().getIntituleProfil());
					facesContext.getExternalContext().getSessionMap().put("matricule",c.getPersonnel().getMatricule());
					System.out.println("user est:"+c.getLogin()+"mot de passe"+c.getPassword());
					if(c.getProfil().getIntituleProfil().equals("PROFIL_COLLAB")){
						return "Accueil?faces-redirect=true";
					}else if(c.getProfil().getIntituleProfil().equals("PROFIL_ADMIN")){
						return "AccueuilAdmin?faces-redirect=true";
					}
					else if(c.getProfil().getIntituleProfil().equals("PROFIL_FORMATEUR")){
						return "Acceuil_Formateur?faces-redirect=true";
					}else{
						return "Acceuil_Resp?faces-redirect=true";
					}


				}
			}
		}       
	} 
	
	public CompteServInt getService() {
		return service;
	}
	public void setService(CompteServInt service) {
		this.service = service;
	}


}
