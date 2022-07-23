package ourProgramImprove.controlador.gestoresPojo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ourProgramImprove.controlador.Utils;
import ourProgramImprove.modelo.Cliente;

public class DaoCliente {

	// TODO SON CLASES COPIADAS DE OTRO PROYECTO, ESTAN SIN TOCAR

	public ArrayList<Cliente> listarUsuarios() {
		ArrayList<Cliente> empleados = null;
		Cliente cliente;
		String sql = "SELECT * FROM cliente;";

		try (Connection con = Utils.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();

		) {

			empleados = new ArrayList<Cliente>();

			while (rs.next()) {
				cliente = new Cliente();

				cliente.setDni(rs.getString("dni"));
				cliente.setNombre(rs.getString("nombre"));
				cliente.setApellidoUno(rs.getString("apellido_uno"));
				cliente.setApellidoDos(rs.getString("apellido_dos"));
				cliente.setContraseña(rs.getString("contraseña"));

				empleados.add(cliente);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empleados;

	}

	public void insertar(Cliente cliente) throws ClassNotFoundException, IOException {
		// Cliente cliente = new Cliente();
		try (Connection con = Utils.getConnection();
				PreparedStatement pst = con.prepareStatement(
						"INSERT INTO cliente (dni, nombre, apellido_uno, apellido_dos, contraseña) VALUES (?, ?, ?, ?, ?)");

		) {

			pst.setString(1, cliente.getDni());
			pst.setString(2, cliente.getNombre());
			pst.setString(3, cliente.getApellidoUno());
			pst.setString(4, cliente.getApellidoDos());
			pst.setString(5, cliente.getContraseña());

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

	// /**
//	 * Pide por pantalla los datos de un alumno y lo inserta en la bbdd
//	 * 
//	 * @param sc2
//	 */
//	public void insertar(Scanner sc) {
//		boolean encontrado = false;
//
//		try (Connection con = Conexion.getConnection();
//				PreparedStatement pst = con.prepareStatement("INSERT INTO alumno (nombre, email) VALUES (?,?)");
//
//		) {
//
//			System.out.println("Introduce el nombre");
//			String nombre = sc.nextLine();
//
//			System.out.println("Introduce el gmail");
//			String email = sc.nextLine().trim();
//
//			encontrado = new Select().buscarEmail(email);
//			if (encontrado) {
//				System.out.println("El email del alumno ya se encuentra en la BBDD");
//			} else {
//				pst.setString(1, nombre);
//				pst.setString(2, email);
//
//				pst.executeUpdate();
//				System.out.println("Alumno insertado\n");
//			}
//
//		} catch (SQLException sqle) {
//			System.out.println("Este email ya esta registrado, Vamos al menu.\n");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}// insertar
//	
//-----------------------------------------------------------------------------------------------------------------
//	
//	public void borrarAlumno(Scanner sc) {
//
//		// creracion de las variables que necesitamos para recoger los datos
//		int id = 0;
//		boolean encontrado = false;
//
//		// declarar la sentencia que queremos
//		String sql = "DELETE FROM alumno WHERE id_alumno = ?;";
//
//		// conectar con la bbdd
//		try (Connection con = Conexion.getConnection(); PreparedStatement pst = con.prepareStatement(sql);
//
//		) {
//
//			boolean volverApedir = true;
//			while (volverApedir) {
//				System.out.println("Introduce la id del alumno que deseas eliminar");
//				try {
//					id = Integer.parseInt(sc.nextLine());
//					volverApedir = false;
//				} catch (Exception e) {
//					System.out.println("Debes introducir una id de un alumno existente, intentalo de nuevo");
//					System.out.println("Introduce la id del alumno que deseas eliminar");
//					volverApedir = true;
//				}
//			}
//
//			String sql2 = "SELECT id_alumno, nombre, email FROM clase.alumno WHERE id_alumno = ?;";
//			PreparedStatement pst2 = con.prepareStatement(sql2);
//
//			pst2.setInt(1, id);
//			ResultSet rs2 = pst2.executeQuery();
//
//			if (rs2.next()) {
//				pst.setInt(1, id);
//				pst.executeUpdate();
//				System.out.println("Alumno eliminado correctamente\n");
//			} else {
//				System.out.println("La id seleccionada no se encuentra en la BBDD\n");
//			}
//
//		} catch (SQLException sqle) {
//			System.out.println("Id de alumno no encontrado");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}// Borrar
//	
//-----------------------------------------------------------------------------------------------------------------
//	
//	/*EL METODO DE ABAJO ES UPDATE*/
//	public void modificar(Scanner sc) {
//
//		//declaracion de variables
//		int id = 0;
//		
//
//		//sentencia sql que necesitamos
//		String sql = "UPDATE alumno SET nombre = ?, email = ? WHERE id_alumno = ?;";
//
//		//conectar con la bbdd
//		try (Connection con = Conexion.getConnection();
//				PreparedStatement pst = con.prepareStatement(sql);
//
//		) {
//
//			
//			//gestion de error si mete letras en vez de numeros
//			boolean volverApedir = true;
//			while (volverApedir) {
//				System.out.println("Introduce la id del alumno que deseas modificar");
//				try {
//					id = Integer.parseInt(sc.nextLine());
//					volverApedir = false;
//				} catch (Exception e) {
//					System.out.println("No has introducido un valor correcto, intentalo de nuevo:");
//				}
//			
//				//sentencia para preguntar si la id introducida existe en la bbdd
//				String sql2 = "SELECT id_alumno, nombre, email FROM clase.alumno WHERE id_alumno = ?;";
//				PreparedStatement pst2 = con.prepareStatement(sql2);
//				// asignar datos introducidos a los interrogantes
//				pst2.setInt(1, id);
//				ResultSet rs2 = pst2.executeQuery();
//				
//				
//				if(rs2.next()){
//					//si la id existe pedimos los datos
//					String nombreNuevo = "";
//					String nombreViejo =  rs2.getString("nombre");
//					
//					String emailNuevo = "";
//					String emailViejo =  rs2.getString("email");
//				
//				
//					System.out.println("El nombre actual es : " + nombreViejo);
//		            System.out.println("Introduce un nuevo nombre");
//		            nombreNuevo = sc.nextLine();
//		            if ( "".equalsIgnoreCase(nombreNuevo)) {
//		            	nombreNuevo = nombreViejo;
//		            }
//	
//					System.out.println("El email actual es : " + emailViejo);
//					System.out.println("Introduce un email");
//					emailNuevo = sc.nextLine();
//					 if ( "".equalsIgnoreCase(emailNuevo)) {
//						 emailNuevo = emailViejo;
//			            }
//	
//					// asignar datos introducidos a los interrogantes
//					pst.setString(1, nombreNuevo);
//					pst.setString(2, emailNuevo);
//					pst.setInt(3, id);
//	
//					// ejecutar la select y controlar que el email no este repetido
//					boolean emailRepetido = true;
//					do {
//						
//						try{
//							pst.executeUpdate();
//							System.out.println("Alumno Actualizado");
//							emailRepetido = false;
//							
//						}catch (Exception e) {
//							System.out.println("*** Email repetido, por favor dime otro:");
//							emailNuevo = sc.nextLine();
//							pst.setString(2, emailNuevo);
//						}	
//		
//					}while(emailRepetido);
//					
//	
//		        }
//		        else{
//		           System.out.println("La id introducida no se encuentra en la base de datos, el alumno no existe");
//		           volverApedir=true;
//		        }
//			}
//			
//		} catch (Exception e) {
//			System.out.println("Error Inexperado, por favor contacta con el administrador.");
//			//e.printStackTrace();
//		} 
//		
//
//	}// Update

}
