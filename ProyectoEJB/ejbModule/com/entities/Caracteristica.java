package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CARACTERISTICAS database table.
 * 
 */
@Entity
@Table(name="CARACTERISTICAS")
@NamedQuery(name="Caracteristica.findAll", query="SELECT c FROM Caracteristica c")
public class Caracteristica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CARACTERISTICAS_IDCARACTERISTICAS_GENERATOR", sequenceName="SQL_ID_CARACTERISTICAS",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CARACTERISTICAS_IDCARACTERISTICAS_GENERATOR")
	@Column(name="ID_CARACTERISTICAS", unique=true, nullable=false, precision=19)
	private long idCaracteristicas;

	@Column(nullable=false, length=25)
	private String etiqueta;

	@Column(nullable=false, length=25)
	private String nombre;

	@Column(nullable=false, length=25)
	private String tipo;

	//bi-directional many-to-one association to Fenomeno
	@ManyToOne
	@JoinColumn(name="ID_FENOMENO", nullable=false)
	private Fenomeno fenomeno;

	//bi-directional many-to-one association to Detalle
	@OneToMany(mappedBy="caracteristica")
	private List<Detalle> detalles;

	public Caracteristica() {
	}

	public long getIdCaracteristicas() {
		return this.idCaracteristicas;
	}

	public void setIdCaracteristicas(long idCaracteristicas) {
		this.idCaracteristicas = idCaracteristicas;
	}

	public String getEtiqueta() {
		return this.etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Fenomeno getFenomeno() {
		return this.fenomeno;
	}

	public void setFenomeno(Fenomeno fenomeno) {
		this.fenomeno = fenomeno;
	}

	public List<Detalle> getDetalles() {
		return this.detalles;
	}

	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}

	public Detalle addDetalle(Detalle detalle) {
		getDetalles().add(detalle);
		detalle.setCaracteristica(this);

		return detalle;
	}

	public Detalle removeDetalle(Detalle detalle) {
		getDetalles().remove(detalle);
		detalle.setCaracteristica(null);

		return detalle;
	}

}