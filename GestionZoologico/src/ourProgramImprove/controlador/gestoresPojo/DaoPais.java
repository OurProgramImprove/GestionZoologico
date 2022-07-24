package ourProgramImprove.controlador.gestoresPojo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ourProgramImprove.controlador.Utils;
import ourProgramImprove.modelo.Continente;
import ourProgramImprove.modelo.Pais;

public class DaoPais {

	public ArrayList<Pais> leerPaises(int idContinente) {

		ArrayList<Pais> paises = null;
		Pais pais;
		String sql = "SELECT P.nombre FROM pais P join continente C on P.id_continente = C.id_continente "
				+ "	WHERE P.id_continente='" + idContinente + "'";

		try (Connection con = Utils.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();

		) {

			paises = new ArrayList<Pais>();

			while (rs.next()) {
				pais = new Pais();

				pais.setIdPais(rs.getInt("id_pais")); // NO ENCUENTRA ID_PAIS porque
				pais.setNombre(rs.getString("nombre"));

				paises.add(pais);
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

		return null;
	}

}
