package persistenciaSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import entities.Arbre;
import entities.Decoracio;
import entities.Flor;
import entities.Material;

public class Persistencia {

	public static Connection connexio() {

		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/floristeriadb", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void saveFloristeria(Long id, String nom) {

		Connection connexio = connexio();
		String peticio = "INSERT INTO floristeria (id, nom) VALUES (?,?);";

		try {
			PreparedStatement ps = connexio.prepareStatement(peticio);
			ps.setLong(1, id);
			ps.setString(2, nom);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void saveArbre(Arbre arbre) {

		Connection connexio = connexio();
		String peticio = "INSERT INTO producte(id) VALUES(NULL);";
		String peticio2 = "SELECT LAST_INSERT_ID();";
		String peticio3 = "INSERT INTO arbre (id, preu, alcada, floristeriaId) VALUES(?,?,?,1);";

		try {
			PreparedStatement ps = connexio.prepareStatement(peticio);
			ps.executeUpdate();

			PreparedStatement ps2 = connexio.prepareStatement(peticio2);
			ResultSet rs = ps2.executeQuery();
			Long id = null;
			if (rs.next()) {
				id = rs.getLong(1);
			}

			PreparedStatement ps3 = connexio.prepareStatement(peticio3);
			ps3.setLong(1, id);
			ps3.setDouble(2, arbre.getPreu());
			ps3.setDouble(3, arbre.getAlcada());
			ps3.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void saveFlor(Flor flor) {

		Connection connexio = connexio();
		String peticio = "INSERT INTO producte (id) VALUES(NULL);";
		String peticio2 = "SELECT LAST_INSERT_ID();";
		String peticio3 = "INSERT INTO flor (id, preu, color, floristeriaId) VALUES(?, ?, ?, 1);";

		try {
			PreparedStatement ps = connexio.prepareStatement(peticio);
			ps.executeUpdate();

			PreparedStatement ps2 = connexio.prepareStatement(peticio2);
			ResultSet rs = ps2.executeQuery();
			Long id = null;
			if (rs.next()) {
				id = rs.getLong(1);
			}

			PreparedStatement ps3 = connexio.prepareStatement(peticio3);
			ps3.setLong(1, id);
			ps3.setDouble(2, flor.getPreu());
			ps3.setString(3, flor.getColor());
			ps3.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void saveDecoracio(Decoracio decoracio) {

		Connection connexio = connexio();
		String peticio = "INSERT INTO producte (id) VALUES(NULL);";
		String peticio2 = "SELECT LAST_INSERT_ID();";
		String peticio3 = "INSERT INTO decoracio (id, preu, material, floristeriaId) VALUES(?, ?, ?, 1);";

		try {
			PreparedStatement ps = connexio.prepareStatement(peticio);
			ps.executeUpdate();

			PreparedStatement ps2 = connexio.prepareStatement(peticio2);
			ResultSet rs = ps2.executeQuery();
			Long id = null;
			if (rs.next()) {
				id = rs.getLong(1);
			}

			PreparedStatement ps3 = connexio.prepareStatement(peticio3);
			ps3.setLong(1, id);
			ps3.setDouble(2, decoracio.getPreu());
			ps3.setString(3, decoracio.getMaterial().toString());
			ps3.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static List<Arbre> getArbres() {

		Connection connexio = connexio();
		String peticio = "SELECT * FROM arbre INNER JOIN producte ON arbre.id = producte.id WHERE producte.enStock = 1;";
		List<Arbre> llista = new ArrayList<Arbre>();
		try {

			PreparedStatement ps = connexio.prepareStatement(peticio);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Arbre arbre = new Arbre();
				arbre.setId(rs.getLong(1));
				arbre.setAlcada(rs.getDouble(2));
				arbre.setPreu(rs.getDouble(3));
				arbre.setFloristeriaId(rs.getLong(4));
				llista.add(arbre);

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return llista;
	}
	
	public static List<Flor> getFlors() {

		Connection connexio = connexio();
		String peticio = "SELECT * FROM flor INNER JOIN producte ON flor.id = producte.id WHERE producte.enStock = 1;";
		List<Flor> llista = new ArrayList<Flor>();
		try {

			PreparedStatement ps = connexio.prepareStatement(peticio);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Flor flor = new Flor();
				flor.setId(rs.getLong(1));
				flor.setColor(rs.getString(2));
				flor.setPreu(rs.getDouble(3));
				flor.setFloristeriaId(rs.getLong(4));
				llista.add(flor);

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return llista;
	}
	
	public static List<Decoracio> getDecoracions() {

		Connection connexio = connexio();
		String peticio = "SELECT * FROM decoracio INNER JOIN producte ON decoracio.id = producte.id WHERE producte.enStock = 1;";
		List<Decoracio> llista = new ArrayList<Decoracio>();
		try {

			PreparedStatement ps = connexio.prepareStatement(peticio);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Decoracio decoracio = new Decoracio();
				decoracio.setId(rs.getLong(1));
				Material material = (rs.getString(2).equals("fusta")) ?Material.FUSTA:Material.PLASTIC;
				decoracio.setMaterial(material);
				decoracio.setPreu(rs.getDouble(3));
				decoracio.setFloristeriaId(rs.getLong(4));
				llista.add(decoracio);

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return llista;
	}

}
