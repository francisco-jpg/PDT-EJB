package com.servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.entities.Departamento;
import com.entities.Zona;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class DepartamentoBean
 */
@Stateless
@LocalBean
public class DepartamentoBean implements DepartamentoBeanRemote {

	@PersistenceContext 
	private EntityManager em;
    public DepartamentoBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void AltaDepartamento( String nombre, long id_zona)  {
		try {
			System.out.println("Departamento Entra ->"+nombre);
			Departamento dep = new Departamento();
			//dep.setIdDepartamento(ID);
			dep.setNombre(nombre);
			Zona zona=em.find(Zona.class, id_zona);
			System.out.println("Departamento->"+nombre);
			System.out.println("zona->"+zona.getNombre());
			dep.setZona(em.find(Zona.class, id_zona));
			em.persist(dep);
			em.flush();
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			
		}
		
		
		
	}

	@Override
	public void Modificardepartamento(long ID, String nombre) throws ServiciosException {
		Departamento dep = em.find(Departamento.class, ID);
		em.detach(dep);
		dep.setNombre(nombre);
		em.merge(dep);
		em.flush();
	}

	@Override
	public void BorrarDepartamento(long ID) throws ServiciosException {
		Departamento dep = em.find(Departamento.class, ID);
		em.remove(dep);
		em.flush();
	}

	@Override
	public List<Departamento> GetALL() throws ServiciosException {
		TypedQuery<Departamento> query = em.createQuery("SELECT d FROM Departamento d",Departamento.class);
		em.flush();
		return query.getResultList();
	}

}
