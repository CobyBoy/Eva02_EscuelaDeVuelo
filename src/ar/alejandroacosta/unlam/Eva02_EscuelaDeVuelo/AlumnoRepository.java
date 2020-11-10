package ar.alejandroacosta.unlam.Eva02_EscuelaDeVuelo;

public interface AlumnoRepository {
	
	public Boolean agregarAlumnoAAcademia(Alumno alumno);
	
	public Alumno buscarAlumno(Integer idAlumno);
	
	public Boolean eliminarAlumno(Alumno alumno);
	
	public Boolean eliminarAlumnoPorId(Integer id);;

}
