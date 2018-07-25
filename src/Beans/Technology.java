/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author zoran.milicevic
 */
@Entity
@Table(name = "technology")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Technology.findAll", query = "SELECT t FROM Technology t")
    , @NamedQuery(name = "Technology.findById", query = "SELECT t FROM Technology t WHERE t.id = :id")
    , @NamedQuery(name = "Technology.findByText", query = "SELECT t FROM Technology t WHERE t.text = :text")})
public class Technology implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "text")
    private String text;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTechnology")
    private Collection<Result> resultCollection;
    @OneToMany(mappedBy = "idTechnology")
    private Collection<CandidateTechnology> candidateTechnologyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTechnology")
    private Collection<Question> questionCollection;

    public Technology() {
    }

    public Technology(Integer id) {
        this.id = id;
    }

    public Technology(Integer id, String text) {
        this.id = id;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @XmlTransient
    public Collection<Result> getResultCollection() {
        return resultCollection;
    }

    public void setResultCollection(Collection<Result> resultCollection) {
        this.resultCollection = resultCollection;
    }

    @XmlTransient
    public Collection<CandidateTechnology> getCandidateTechnologyCollection() {
        return candidateTechnologyCollection;
    }

    public void setCandidateTechnologyCollection(Collection<CandidateTechnology> candidateTechnologyCollection) {
        this.candidateTechnologyCollection = candidateTechnologyCollection;
    }

    @XmlTransient
    public Collection<Question> getQuestionCollection() {
        return questionCollection;
    }

    public void setQuestionCollection(Collection<Question> questionCollection) {
        this.questionCollection = questionCollection;
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
        if (!(object instanceof Technology)) {
            return false;
        }
        Technology other = (Technology) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Beans.Technology[ id=" + id + " ]";
    }
    
}
