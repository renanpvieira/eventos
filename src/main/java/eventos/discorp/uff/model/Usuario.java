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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

/**
 *
 * @author pc_renan
 */

@Entity
@Table(name="Usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int UsuarioId;
    
    @Size(min=3, max=60)
    @Column(name = "Nome", nullable = false)
    private String Nome;
    
    @Size(min=12, max=255)
    @Column(name = "Login", nullable = false)
    private String Login;
    
    @Size(min=6, max=12)
    @Column(name = "Senha", nullable = false)
    private String Senha;
    
    @OneToMany(mappedBy = "Usuario", targetEntity = Reserva.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Reserva> Reservas;
    
    @OneToMany(mappedBy = "Usuario", targetEntity = Evento.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Evento> Eventos;
        
    @Column(name = "UsaAdmin", nullable = false)
    private int UsaAdmin;
    
    @Column(name = "Estatus", nullable = false)
    private int Estatus;
    
    @Transient
    private boolean isGerente;
    

    /**
     * @return the UsuarioId
     */
    public int getUsuarioId() {
        return UsuarioId;
    }

    /**
     * @param UsuarioId the UsuarioId to set
     */
    public void setUsuarioId(int UsuarioId) {
        this.UsuarioId = UsuarioId;
    }

    /**
     * @return the Nome
     */
    public String getNome() {
        return Nome;
    }

    /**
     * @param Nome the Nome to set
     */
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    /**
     * @return the Login
     */
    public String getLogin() {
        return Login;
    }

    /**
     * @param Login the Login to set
     */
    public void setLogin(String Login) {
        this.Login = Login;
    }

    /**
     * @return the Senha
     */
    public String getSenha() {
        return Senha;
    }

    /**
     * @param Senha the Senha to set
     */
    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
    
     /**
     * @return the Reservas
     */
    public List<Reserva> getReservas() {
        return Reservas;
    }

    /**
     * @param Reservas the Reservas to set
     */
    public void setReservas(List<Reserva> Reservas) {
        this.Reservas = Reservas;
    }
    
    /**
     * @return the UsaAdmin
     */
    public int getUsaAdmin() {
        return UsaAdmin;
    }

    /**
     * @param UsaAdmin the UsaAdmin to set
     */
    public void setUsaAdmin(int UsaAdmin) {
        this.UsaAdmin = UsaAdmin;
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
    
    
    /**
     * @return the isGerente
     */
    public boolean getIsGerente() {
        return isGerente;
    }

    /**
     * @param isGerente the isGerente to set
     */
    public void setIsGerente(boolean isGerente) {
        this.isGerente = isGerente;
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
    
    
    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Aluno))
			return false;
		Usuario other = (Usuario)obj;
		if (UsuarioId != other.UsuarioId)
			return false;
		
		return true;
	}

	@Override
	public String toString() {
   	      return String.format("Recurso [RecursoId=%s, Descricao=%s]", this.UsuarioId, this.Nome);
	}

    

    

    

    

   
    
}
