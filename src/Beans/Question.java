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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "question")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Question.findAll", query = "SELECT q FROM Question q")
    , @NamedQuery(name = "Question.findById", query = "SELECT q FROM Question q WHERE q.id = :id")
    , @NamedQuery(name = "Question.findByText", query = "SELECT q FROM Question q WHERE q.text = :text")
    , @NamedQuery(name = "Question.findByMultiAnswer", query = "SELECT q FROM Question q WHERE q.multiAnswer = :multiAnswer")
    , @NamedQuery(name = "Question.findByPoints", query = "SELECT q FROM Question q WHERE q.points = :points")})
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "text")
    private String text;
    @Column(name = "multi_answer")
    private Boolean multiAnswer;
    @Column(name = "points")
    private Integer points;
    @JoinColumn(name = "id_technology", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Technology idTechnology;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idQuestion", fetch = FetchType.EAGER)
    private Collection<Answers> answersCollection;

    public Question() {
    }

    public Question(Integer id) {
        this.id = id;
    }

    public Question(Integer id, String text) {
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

    public Boolean getMultiAnswer() {
        return multiAnswer;
    }

    public void setMultiAnswer(Boolean multiAnswer) {
        this.multiAnswer = multiAnswer;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Technology getIdTechnology() {
        return idTechnology;
    }

    public void setIdTechnology(Technology idTechnology) {
        this.idTechnology = idTechnology;
    }

    @XmlTransient
    public Collection<Answers> getAnswersCollection() {
        return answersCollection;
    }

    public void setAnswersCollection(Collection<Answers> answersCollection) {
        this.answersCollection = answersCollection;
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
        if (!(object instanceof Question)) {
            return false;
        }
        Question other = (Question) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Beans.Question[ id=" + id + " ]";
    }
    
}
