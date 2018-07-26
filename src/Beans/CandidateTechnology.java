/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zoran.milicevic
 */
@Entity
@Table(name = "candidate_technology")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CandidateTechnology.findAll", query = "SELECT c FROM CandidateTechnology c")
    , @NamedQuery(name = "CandidateTechnology.findById", query = "SELECT c FROM CandidateTechnology c WHERE c.id = :id")})
public class CandidateTechnology implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_candidate", referencedColumnName = "id")
    private Candidate idCandidate;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_technology", referencedColumnName = "id")
    private Technology idTechnology;

    public CandidateTechnology() {
    }

    public CandidateTechnology(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Candidate getIdCandidate() {
        return idCandidate;
    }

    public void setIdCandidate(Candidate idCandidate) {
        this.idCandidate = idCandidate;
    }

    public Technology getIdTechnology() {
        return idTechnology;
    }

    public void setIdTechnology(Technology idTechnology) {
        this.idTechnology = idTechnology;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CandidateTechnology)) {
            return false;
        }
        CandidateTechnology other = (CandidateTechnology) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Beans.CandidateTechnology[ id=" + id + " ]";
    }
    
}
