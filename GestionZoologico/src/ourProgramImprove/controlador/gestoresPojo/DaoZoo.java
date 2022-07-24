package ourProgramImprove.controlador.gestoresPojo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ourProgramImprove.controlador.Utils;
import ourProgramImprove.modelo.Zoo;

public class DaoZoo {

	public ArrayList<Zoo> listar() throws ClassNotFoundException, IOException {
		ArrayList<Zoo> zoos = null;
		Zoo zoo;
		String sql = "SELECT * FROM zoo;";

		try (Connection con = Utils.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();

		) {

			zoos = new ArrayList<Zoo>();

			while (rs.next()) {
				zoo = new Zoo();

				zoo.setIdZoo(rs.getInt("id_zoo"));
				zoo.setNombre(rs.getString("nombre"));
				zoo.setTamaño(rs.getInt("tamaño"));
				zoo.setPresupuesto(rs.getFloat("presupuesto"));
				zoo.sethApertura(rs.getTime("h_apertura"));
				zoo.sethCierre(rs.getTime("h_cierre"));
				zoo.setPvpEntrada(rs.getFloat("pvp_entrada"));
				zoo.setCiudadZoo(rs.getInt("ciudad_zoo"));
				
				zoos.add(zoo);
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
		return zoos;
	}
	
	public void insertar(Zoo zoo) throws ClassNotFoundException, IOException {

		try (Connection con = Utils.getConnection();
				PreparedStatement pst = con.prepareStatement("INSERT INTO zoo (nombre, tamaño, presupuesto, h_apertura, h_cierre,"
						+ " pvp_entrada, ciudad_zoo) VALUES (?, ?, ?, ?, ?, ?, ?)");

		) {

			pst.setString(1, zoo.getNombre());
			pst.setInt(2, zoo.getTamaño());
			pst.setFloat(3,  zoo.getPresupuesto());
			pst.setTime(4, zoo.gethApertura());
			pst.setTime(5, zoo.gethCierre());
			pst.setFloat(6, zoo.getPvpEntrada());
			pst.setInt(7, zoo.getCiudadZoo());

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
