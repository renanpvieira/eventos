/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos.discorp.uff.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author pc_renan
 */

@Entity
@Table(name="Professor")
@PrimaryKeyJoinColumn(name="UsuarioId")
public class Professor extends Usuario {
    
    @Size(min=12, max=255)
    @Column(name = "EmailContato", nullable = true)
    private String EmailContato;
    
    
}
