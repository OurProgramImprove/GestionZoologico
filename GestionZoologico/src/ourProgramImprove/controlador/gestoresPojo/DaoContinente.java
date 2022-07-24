package ourProgramImprove.controlador.gestoresPojo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ourProgramImprove.controlador.Utils;
import ourProgramImprove.modelo.Continente;

public class DaoContinente {

	public ArrayList<Continente> leerContinentes() throws ClassNotFoundException, IOException {
		ArrayList<Continente> continentes = null;
		Continente continente;
		String sql = "SELECT * FROM continente;";

		try (Connection con = Utils.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();

		) {

			continentes = new ArrayList<Continente>();

			while (rs.next()) {
				continente = new Continente();

				continente.setIdContinente(rs.getInt("id_continente"));
				continente.setNombre(rs.getString("nombre"));

				continentes.add(continente);
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
		return continentes;

	}

}
