package ourProgramImprove.controlador.gestoresPojo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ourProgramImprove.controlador.Utils;
import ourProgramImprove.modelo.ZooHasEspecie;

public class DaoZooHasEspecie {

	public ArrayList<ZooHasEspecie> listar() throws ClassNotFoundException, IOException {
		ArrayList<ZooHasEspecie> zoosEspecies = null;
		ZooHasEspecie zooEspecie;
		String sql = "SELECT * FROM zoo_has_especie;";

		try (Connection con = Utils.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();

		) {
			String toChar = null;
			zoosEspecies = new ArrayList<ZooHasEspecie>();

			while (rs.next()) {
				zooEspecie = new ZooHasEspecie();

				zooEspecie.setId(rs.getInt("id"));
				zooEspecie.setIdZoo(rs.getInt("id_zoo"));
				zooEspecie.setIdEspecie(rs.getInt("id_especie"));
				toChar = rs.getString("sexo");
				char sex=toChar.charAt(0);
				zooEspecie.setSexo(sex);
				zooEspecie.setCantidad(rs.getInt("cantidad"));

				zoosEspecies.add(zooEspecie);
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
		return zoosEspecies;
	}
}
