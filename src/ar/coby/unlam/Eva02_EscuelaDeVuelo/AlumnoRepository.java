package ar.coby.unlam.Eva02_EscuelaDeVuelo;

public interface AlumnoRepository {
	
	public Boolean agregarAlumno(Alumno alumno);
	
	public Alumno buscarAlumno(Integer idAlumno);
	
	public Boolean eliminarAlumno(Alumno alumno);
	
	public Boolean eliminarAlumnoPorId(Integer id);;

}
