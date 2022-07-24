package ourProgramImprove.controlador.gestoresPojo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ourProgramImprove.controlador.Utils;
import ourProgramImprove.modelo.Familia;

public class DaoFamilia {

	public ArrayList<Familia> listar() throws ClassNotFoundException, IOException {
		ArrayList<Familia> familias = null;
		Familia familia;
		String sql = "SELECT * FROM familia;";

		try (Connection con = Utils.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();

		) {

			familias = new ArrayList<Familia>();

			while (rs.next()) {
				familia = new Familia();

				familia.setIdFamilia(rs.getInt("id_familia"));
				familia.setNombre(rs.getString("nombre"));

				familias.add(familia);
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
		return familias;
	}

	public void insertar(Familia familia) throws ClassNotFoundException, IOException {

		try (Connection con = Utils.getConnection();
				PreparedStatement pst = con.prepareStatement("INSERT INTO familia (nombre) VALUES (?)");

		) {

			pst.setString(1, familia.getNombre());

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
