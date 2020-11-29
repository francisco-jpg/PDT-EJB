package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Fenomeno;
import com.exception.ServiciosException;

@Remote
public interface FenomenoBeanRemote {
	
	void AltaFenomeno(String nombre,String descripcion,int tel) throws ServiciosException;
	void ModificarFenomeno(long ID,String nombre,String descripcion,int tel) throws ServiciosException;
	void BorrarFenomeno(long ID) throws ServiciosException;
	List<Fenomeno> GetALL() throws ServiciosException;

}
