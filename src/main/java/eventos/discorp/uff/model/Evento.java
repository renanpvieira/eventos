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
import javax.validation.constraints.Size;

/**
 *
 * @author pc_renan
 */
@Entity
@Table(name="Evento")
public class Evento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int EventoId;
    
    @Size(min=3, max=50)
    @Column(name = "Descricao", nullable = false)
    private String Descricao;
    
    @Size(max=1500)
    @Column(name = "DescricaoLonga", nullable = true)
    private String DescricaoLonga;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "DataInicio", nullable = false)
    private Date DataInicio;
    
    @Temporal(TemporalType.TIME)
    @Column(name = "HoraInicio", nullable = false)
    private Date HoraInicio;
    
    @Size(max=500)
    @Column(name = "Pessoa", nullable = true)
    private String Pessoa;
    
    @Column(name = "Duracao", nullable = true)
    private int Duracao;
    
    @ManyToOne
    @JoinColumn(name="EventoCategoriaId")
    private EventoCategoria Categoria;
    
    @ManyToOne
    @JoinColumn(name="AmbienteId")
    private Ambiente Ambiente;
    
    

    /**
     * @return the EventoId
     */
    public int getEventoId() {
        return EventoId;
    }

    /**
     * @param EventoId the EventoId to set
     */
    public void setEventoId(int EventoId) {
        this.EventoId = EventoId;
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
     * @return the DescricaoLonga
     */
    public String getDescricaoLonga() {
        return DescricaoLonga;
    }

    /**
     * @param DescricaoLonga the DescricaoLonga to set
     */
    public void setDescricaoLonga(String DescricaoLonga) {
        this.DescricaoLonga = DescricaoLonga;
    }

    /**
     * @return the DataInicio
     */
    public Date getDataInicio() {
        return DataInicio;
    }

    /**
     * @param DataInicio the DataInicio to set
     */
    public void setDataInicio(Date DataInicio) {
        this.DataInicio = DataInicio;
    }

    /**
     * @return the HoraInicio
     */
    public Date getHoraInicio() {
        return HoraInicio;
    }
    
    
    public String getDataInicioFormatado() {
        return (new SimpleDateFormat("dd/MM/yyyy")).format(DataInicio) + " às " + (new SimpleDateFormat("HH:mm")).format(HoraInicio) ;
    }
    
    

    /**
     * @param HoraInicio the HoraInicio to set
     */
    public void setHoraInicio(Date HoraInicio) {
        this.HoraInicio = HoraInicio;
    }

    /**
     * @return the Pessoa
     */
    public String getPessoa() {
        return Pessoa;
    }

    /**
     * @param Pessoa the Pessoa to set
     */
    public void setPessoa(String Pessoa) {
        this.Pessoa = Pessoa;
    }

    /**
     * @return the Duracao
     */
    public int getDuracao() {
        return Duracao;
    }

    /**
     * @param Duracao the Duracao to set
     */
    public void setDuracao(int Duracao) {
        this.Duracao = Duracao;
    }
    
    
    /**
     * @return the Categoria
     */
    public EventoCategoria getCategoria() {
        return Categoria;
    }

    /**
     * @param Categoria the Categoria to set
     */
    public void setCategoria(EventoCategoria Categoria) {
        this.Categoria = Categoria;
    }
    
     /**
     * @return the Ambiente
     */
    public Ambiente getAmbiente() {
        return Ambiente;
    }

    /**
     * @param Ambiente the Ambiente to set
     */
    public void setAmbiente(Ambiente Ambiente) {
        this.Ambiente = Ambiente;
    }
    
    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Evento))
			return false;
		Evento other = (Evento)obj;
		if (EventoId != other.EventoId)
			return false;
		
		return true;
	}

	@Override
	public String toString() {
   	      return String.format("Evento [EventoId=%s, Descricao=%s]", this.EventoId, this.Descricao);
	}

   

    
    
}
