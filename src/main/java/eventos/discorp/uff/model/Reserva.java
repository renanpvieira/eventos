/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos.discorp.uff.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author pc_renan
 */

@Entity
@Table(name="Reserva")
public class Reserva {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ReservaId;
        
    @ManyToOne
    @JoinColumn(name="UsuarioId")
    private Usuario Usuario;
    
    @ManyToOne
    @JoinColumn(name="EventoId")
    private Evento Evento;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "DataReserva", nullable = false)
    private Date DataReserva;
    
    @Temporal(TemporalType.TIME)
    @Column(name = "HoraReserva", nullable = false)
    private Date HoraReserva;
    
    @Column(name = "Estatus", nullable = false)
    private int Estatus;
    
    
    

    /**
     * @return the ReservaId
     */
    public int getReservaId() {
        return ReservaId;
    }

    /**
     * @param ReservaId the ReservaId to set
     */
    public void setReservaId(int ReservaId) {
        this.ReservaId = ReservaId;
    }

    /**
     * @return the Usuario
     */
    public Usuario getUsuario() {
        return Usuario;
    }

    /**
     * @param Usuario the Usuario to set
     */
    public void setUsuario(Usuario Usuario) {
        this.Usuario = Usuario;
    }

    /**
     * @return the Evento
     */
    public Evento getEvento() {
        return Evento;
    }

    /**
     * @param Evento the Evento to set
     */
    public void setEvento(Evento Evento) {
        this.Evento = Evento;
    }

    /**
     * @return the DataReserva
     */
    public Date getDataReserva() {
        return DataReserva;
    }

    /**
     * @param DataReserva the DataReserva to set
     */
    public void setDataReserva(Date DataReserva) {
        this.DataReserva = DataReserva;
    }

    /**
     * @return the HoraReserva
     */
    public Date getHoraReserva() {
        return HoraReserva;
    }

    /**
     * @param HoraReserva the HoraReserva to set
     */
    public void setHoraReserva(Date HoraReserva) {
        this.HoraReserva = HoraReserva;
    }

    /**
     * @return the Estatus
     */
    public int getEstatus() {
        return Estatus;
    }

    /**
     * @param Estatus the Estatus to set
     */
    public void setEstatus(int Estatus) {
        this.Estatus = Estatus;
    }
    
    public String getDataReservaFormatado() {
        return (new SimpleDateFormat("dd/MM/yyyy")).format(DataReserva) + " às " + (new SimpleDateFormat("HH:mm")).format(HoraReserva) ;
    }
    
    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Reserva))
			return false;
		Reserva other = (Reserva)obj;
		if (getReservaId() != other.getReservaId())
			return false;
		
		return true;
	}

	@Override
	public String toString() {
   	      return String.format("Reserva [ReservaId=%s]", this.getReservaId());
	}

    
}
