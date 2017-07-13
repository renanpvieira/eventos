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
 * @author Renan.Vieira
 */
@Entity
@Table(name="Ambiente")
public class Ambiente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int AmbienteId;

    @Size(min=3, max=255)
    @Column(name = "Descricao", nullable = false)
    private String Descricao;
    
    @Size(min=3, max=500)
    @Column(name = "Endereco", nullable = false)
    private String Endereco;
    
     
    @Column(name = "OcupacaoMaxima", nullable = false)
    private int OcupacaoMaxima;
    
    @OneToMany(mappedBy = "Ambiente", targetEntity = Evento.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Evento> Eventos;

    /**
     * @return the AmbienteId
     */
    public int getAmbienteId() {
        return AmbienteId;
    }

    /**
     * @param AmbienteId the AmbienteId to set
     */
    public void setAmbienteId(int AmbienteId) {
        this.AmbienteId = AmbienteId;
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
     * @return the Endereco
     */
    public String getEndereco() {
        return Endereco;
    }

    /**
     * @param Endereco the Endereco to set
     */
    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    /**
     * @return the OcupacaoMaxima
     */
    public int getOcupacaoMaxima() {
        return OcupacaoMaxima;
    }

    /**
     * @param OcupacaoMaxima the OcupacaoMaxima to set
     */
    public void setOcupacaoMaxima(int OcupacaoMaxima) {
        this.OcupacaoMaxima = OcupacaoMaxima;
    }
    
     /**
     * @return the Eventos
     */
    public List<Evento> getEventos() {
        return Eventos;
    }

    /**
     * @param Eventos the Eventos to set
     */
    public void setEventos(List<Evento> Eventos) {
        this.Eventos = Eventos;
    }
    
    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Ambiente))
			return false;
		Ambiente other = (Ambiente)obj;
		if (AmbienteId != other.AmbienteId)
			return false;
		
		return true;
	}

	@Override
	public String toString() {
   	      return String.format("Ambiente [AmbienteId=%s, Descricao=%s]", this.AmbienteId, this.Descricao);
	}

   
    
}
