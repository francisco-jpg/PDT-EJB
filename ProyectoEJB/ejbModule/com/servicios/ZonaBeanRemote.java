package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Zona;
import com.exception.ServiciosException;

@Remote
public interface ZonaBeanRemote {
	void AltaZona(String nombre) throws ServiciosException;
	void ModificarZona(long ID,String nombre) throws ServiciosException;
	void BorrarZona (long ID) throws ServiciosException;
	List<Zona> GetALL() throws ServiciosException;

}
