package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Localidad;
import com.exception.ServiciosException;

@Remote
public interface LocalidadBeanRemote {
	void AltaLocalidad(String nombre,String geo,long id_dep) throws ServiciosException;
	void ModificarLocalidad(long ID,String nombre,String geo) throws ServiciosException;
	void BorrarLocalidad (long ID) throws ServiciosException;
	List<Localidad> GetALL() throws ServiciosException;

}
