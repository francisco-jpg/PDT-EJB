package com.servicios;

import java.util.List;
import javax.ejb.Remote;
import com.entities.Departamento;
import com.exception.ServiciosException;

@Remote
public interface DepartamentoBeanRemote {
	void AltaDepartamento(String nombre,long id_zona) throws ServiciosException;
	void Modificardepartamento(long ID,String nombre) throws ServiciosException;
	void BorrarDepartamento (long ID) throws ServiciosException;
	List<Departamento> GetALL() throws ServiciosException;
}
