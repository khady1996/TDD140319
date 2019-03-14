package eu.ensup.junitdao.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import eu.ensup.junitdao.daotest.AccesBd;
import eu.ensup.junitdao.domaine.Etudiant;



public class EtudiantDao {


	public int createEtudiant(Etudiant etudiant) {
		// TODO Auto-generated method stub
		
		AccesBd bd = new AccesBd();
		int rs = 0;
		bd.seConnecter();
		try {

			String requete = "INSERT INTO `Etudiant` (`idEtu`,`nom`,`prenom`,`email`) VALUES ('"
					+ etudiant.getId() + "','" + etudiant.getNom() + "','" + etudiant.getPrenom() + "','"
					+ etudiant.getEmail() + "');";

			rs = bd.st.executeUpdate(requete);
			

		} catch (SQLException e) {

			e.printStackTrace();
		}

		bd.seDeconnecter();
		
		return rs;

	}
	
	public Etudiant readEtudiantbyId(int index) {
		
		AccesBd bd = new AccesBd();
		Etudiant etu = null;

		bd.seConnecter();
		try {

			String requete = "SELECT * FROM `Etudiant` WHERE `idEtu` = '" + index + "';";
			ResultSet rs = bd.st.executeQuery(requete);

			while (rs.next()) {
				etu = new Etudiant(rs.getInt("idEtu"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"));

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		bd.seDeconnecter();

		return etu;
	}
	
	public String updateEtudiant(Etudiant etu) {

		int rs = 0;
		AccesBd bd = new AccesBd();

		bd.seConnecter();

		try {
			String requete = "UPDATE `Etudiant` SET `prenom` = '"+etu.getPrenom()+"', `nom` = '"+etu.getNom()+"',`email` = '" + etu.getEmail() + "' WHERE `idEtu` = '" + etu.getId() + "';";

			rs = bd.st.executeUpdate(requete);

			if (rs != 0) {

				bd.seDeconnecter();

				return "OK";
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		bd.seDeconnecter();

		return "KO";
	}
	
	public int deleteEtudiantbyId(int index){
		int rs = 0;
		AccesBd bd = new AccesBd();
		bd.seConnecter();

		try {
			
			String requete = "DELETE FROM `Etudiant` WHERE `idEtu` = '" + index + "';";
			rs = bd.st.executeUpdate(requete);

			System.out.println("OK");

		} catch (SQLException e) {

			e.printStackTrace();
		}

		bd.seDeconnecter();
		return rs;

	}
	
	public List<Etudiant> getAll(){

		List<Etudiant> listetu = new ArrayList<Etudiant>();
		AccesBd bd = new AccesBd();

		bd.seConnecter();
		try {
			String requete = "SELECT * FROM `Etudiant`;";
			ResultSet rs = bd.st.executeQuery(requete);

			while (rs.next()) {

				listetu.add(new Etudiant(rs.getInt("idEtu"), rs.getString("nom"), rs.getString("prenom"),
						rs.getString("email")));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		bd.seDeconnecter();

		return listetu;
	}


}
