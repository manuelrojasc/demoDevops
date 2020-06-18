package Modelo;

public class Persona {
	  private int dni ;
	  private String nombre;
	  private String apellidos;
	  
		public Persona(int dni, String nombre, String apellidos) {
			super();
			this.dni = dni;
			this.nombre = nombre;
			this.apellidos = apellidos;
		}
		public Persona() {
			// TODO Auto-generated constructor stub
		}
		public int getDni() {
			return dni;
		}

		public void setDni(int dni) {
			this.dni = dni;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellidos() {
			return apellidos;
		}

		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}

		@Override
		public String toString() {
			return "modeloPersona [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
		}
	  
	}
