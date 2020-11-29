package com.servicios;

import java.util.Date;
import java.util.List;
import javax.ejb.Remote;

import com.entities.Imagenes;
import com.entities.Observacion;
import com.exception.ServiciosException;

@Remote
public interface ObservacionBeanRemote {
//	void AltaObservacion(String desc,String geo,long id_fen,long id_loc,long id_user,byte[] imagene) throws ServiciosException;
	void AltaObservacion(int estado,String desc, Date fecha,String geo,long id_fen, long id_loc,long id_user) throws ServiciosException;
	void ModificarObservacion(long id,long estado,String desc, Date fecha,String geo,long id_fen, long id_loc,long id_user) throws ServiciosException;
	void BorrarObservacion (long ID) throws ServiciosException;
	List<Observacion> GetALL() throws ServiciosException;
	List<Observacion> GetALL(int id_usuario) throws ServiciosException;
	List<Observacion> ObsFilt(int id_fen) throws ServiciosException;
}
