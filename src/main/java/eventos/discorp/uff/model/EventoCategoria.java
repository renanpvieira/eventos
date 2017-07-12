/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos.discorp.uff.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author pc_renan
 */
@Entity
@Table(name="EventoCategoria")
public class EventoCategoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int EventoCategoriaId;
    
    @Size(min=3, max=50)
    @Column(name = "Descricao", nullable = false)
    private String Descricao;
    
    @Size(max=10)
    @Column(name = "Acronimo", nullable = true)
    private String Acronimo;
    
    @OneToMany(mappedBy = "Categoria", targetEntity = Evento.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Evento> Eventos;

    /**
     * @return the EventoCategoriaId
     */
    public int getEventoCategoriaId() {
        return EventoCategoriaId;
    }

    /**
     * @param EventoCategoriaId the EventoCategoriaId to set
     */
    public void setEventoCategoriaId(int EventoCategoriaId) {
        this.EventoCategoriaId = EventoCategoriaId;
    }

    /**
     * @return the Descricao
     */
    public String getDescricao() {
        return Descricao;
    }

    /**
     * @param Descricao the Descricao to set
     */
    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    /**
     * @return the Acronimo
     */
    public String getAcronimo() {
        return Acronimo;
    }

    /**
     * @param Acronimo the Acronimo to set
     */
    public void setAcronimo(String Acronimo) {
        this.Acronimo = Acronimo;
    }
    
     @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof EventoCategoria))
			return false;
		EventoCategoria other = (EventoCategoria)obj;
		if (EventoCategoriaId != other.EventoCategoriaId)
			return false;
		
		return true;
	}

	@Override
	public String toString() {
   	      return String.format("Evento [EventoId=%s, Descricao=%s]", this.EventoCategoriaId, this.Descricao);
	}
    
}
