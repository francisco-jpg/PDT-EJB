package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Observacion;
import com.entities.Revisa;
import com.entities.Usuario;
import com.exception.ServiciosException;

@Remote
public interface RevisaBeanRemote {
	void AltaRev(long ID_rev,String com,String fiab,Observacion obs,Usuario usr) throws ServiciosException;
	void ModRev(long ID_rev,String com,String fiab) throws ServiciosException;
	void DelRev (long ID) throws ServiciosException;
	List<Revisa> GetAll() throws ServiciosException;
	List<Revisa> GetAllMy(String ID) throws ServiciosException;
}
