package ourProgramImprove.controlador.gestoresPojo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ourProgramImprove.controlador.Utils;
import ourProgramImprove.modelo.PaisHasEspecie;

public class DaoPaisHasEspecie {

	public ArrayList<PaisHasEspecie> listar() throws ClassNotFoundException, IOException {
		ArrayList<PaisHasEspecie> paisesEspecies = null;
		PaisHasEspecie paisEspecie;
		String sql = "SELECT * FROM pais_has_especie;";

		try (Connection con = Utils.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();

		) {

			paisesEspecies = new ArrayList<PaisHasEspecie>();

			while (rs.next()) {
				paisEspecie = new PaisHasEspecie();

				paisEspecie.setIdPais(rs.getInt("id_pais"));
				paisEspecie.setIdEspecie(rs.getInt("id_especie"));

				paisesEspecies.add(paisEspecie);
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
		return paisesEspecies;
	}
	
	public void insertar(PaisHasEspecie paisEspecie) throws ClassNotFoundException, IOException {

		try (Connection con = Utils.getConnection();
				PreparedStatement pst = con.prepareStatement("INSERT INTO pais_has_especie (id_pais, id_especie) VALUES (?, ?)");

		) {

			pst.setInt(1, paisEspecie.getIdPais());
			pst.setInt(2, paisEspecie.getIdEspecie());

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
