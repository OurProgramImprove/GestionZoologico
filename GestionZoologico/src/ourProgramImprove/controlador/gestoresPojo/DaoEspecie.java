package ourProgramImprove.controlador.gestoresPojo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ourProgramImprove.controlador.Utils;
import ourProgramImprove.modelo.Especie;
import ourProgramImprove.modelo.Familia;

public class DaoEspecie {

	public ArrayList<Especie> listar() throws ClassNotFoundException, IOException {
		ArrayList<Especie> especies = null;
		Especie especie;
		String sql = "SELECT * FROM especie;";

		try (Connection con = Utils.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();

		) {

			especies = new ArrayList<Especie>();

			while (rs.next()) {
				especie = new Especie();

				especie.setIdEspecie(rs.getInt("id_especie"));
				especie.setNombreVulgar(rs.getString("nombre_vulgar"));
				especie.setNombreCientifico(rs.getString("nombre_cientifico"));
				especie.setExtincion(rs.getInt("extincion"));
				especie.setAnimal(rs.getString("animal"));
				especie.setIdFamilia(rs.getInt("id_familia"));
				
				especies.add(especie);
			}

		} catch (SQLException sqle) {
			// TODO Auto-generated catch block
			sqle.printStackTrace();
			System.out.println("Erros con la BBDD --- " + sqle);
		} catch (NullPointerException npe) {
			System.out.println("Null ponter --- " + npe);
		} catch (Exception e) {
			System.out.println("Error general --- " + e);
		}
		return especies;
	}
	
	public void insertar(Especie especie) throws ClassNotFoundException, IOException {

		try (Connection con = Utils.getConnection();
				PreparedStatement pst = con.prepareStatement("INSERT INTO especie (nombre_vulgar, nombre_cientifico, extincion, animal, id_familia)"
						+ " VALUES ( ?, ?, ?, ?, ?)");

		) {

			pst.setString(1, especie.getNombreVulgar());
			pst.setString(2, especie.getNombreCientifico());
			pst.setInt(3, especie.getExtincion());
			pst.setString(4, especie.getAnimal());
			pst.setInt(5, especie.getIdFamilia());

			pst.executeUpdate();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			System.out.println("Erros con la BBDD --- " + sqle);
		} catch (NullPointerException npe) {
			System.out.println("Null ponter --- " + npe);
		} catch (Exception e) {
			System.out.println("Error general --- " + e);
		}
	}
	
}
