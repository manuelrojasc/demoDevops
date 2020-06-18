package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexion.conexion;
import Modelo.Persona;



public class PersonaDao {
	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacion;
	
	// guardar producto
		public boolean guardar(Persona persona) throws SQLException, ClassNotFoundException {
			String sql = null;
			estadoOperacion = false;
			connection = obtenerConexion();

			try {
				connection.setAutoCommit(false);
				sql = "INSERT INTO persona (id, nombre, apellidos) VALUES(?,?,?)";
				statement = connection.prepareStatement(sql);

				statement.setString(1, null);
				statement.setString(2, persona.getNombre());
				statement.setString(3, persona.getApellidos());
	
				estadoOperacion = statement.executeUpdate() > 0;

				connection.commit();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				connection.rollback();
				e.printStackTrace();
			}

			return estadoOperacion;
		}
		
		// editar persona
		public boolean editar(Persona persona) throws SQLException, ClassNotFoundException {
			String sql = null;
			estadoOperacion = false;
			connection = obtenerConexion();
			try {
				connection.setAutoCommit(false);
				sql = "UPDATE persona SET nombre=?, apellidos=?, WHERE id=?";
				statement = connection.prepareStatement(sql);

				statement.setString(2, persona.getNombre());
				statement.setString(3, persona.getApellidos());

				estadoOperacion = statement.executeUpdate() > 0;
				connection.commit();
				statement.close();
				connection.close();

			} catch (SQLException e) {
				connection.rollback();
				e.printStackTrace();
			}

			return estadoOperacion;
		}
		// eliminar producto
		public boolean eliminar(int idPersona) throws SQLException, ClassNotFoundException {
			String sql = null;
			estadoOperacion = false;
			connection = obtenerConexion();
			try {
				connection.setAutoCommit(false);
				sql = "DELETE FROM persona WHERE id=?";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, idPersona);

				estadoOperacion = statement.executeUpdate() > 0;
				connection.commit();
				statement.close();
				connection.close();

			} catch (SQLException e) {
				connection.rollback();
				e.printStackTrace();
			}

			return estadoOperacion;
		}
		
		// obtener lista de personas
		public List<Persona> obtenerPersona() throws SQLException, ClassNotFoundException {
			ResultSet resultSet = null;
			List<Persona> listaPersona= new ArrayList<>();

			String sql = null;
			estadoOperacion = false;
			connection = obtenerConexion();

			try {
				sql = "SELECT * FROM persona";
				statement=connection.prepareStatement(sql);
				resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
					Persona p=new Persona();
					p.setDni(resultSet.getInt(1));
					p.setNombre(resultSet.getString(2));
					p.setApellidos(resultSet.getString(3));
					
					listaPersona.add(p);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return listaPersona;
		}
		// obtener un persona
		public Persona obtenerPersona(int idPersona) throws SQLException, ClassNotFoundException {
			ResultSet resultSet = null;
			Persona p=new Persona();

			String sql = null;
			estadoOperacion = false;
			connection = obtenerConexion();

			try {
				sql = "SELECT * FROM persona WHERE id =?";
				statement=connection.prepareStatement(sql);
				statement.setInt(1, idPersona);
				
				resultSet = statement.executeQuery();
				
				if(resultSet.next()) {
					p.setDni(resultSet.getInt(1));
					p.setNombre(resultSet.getString(2));
					p.setApellidos(resultSet.getString(3));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return p;
		}
		private Connection obtenerConexion() throws SQLException, ClassNotFoundException {
			return conexion.getConnection();
		}
}
