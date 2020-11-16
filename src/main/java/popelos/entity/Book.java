/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popelos.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author popelos
 */
@Entity
@Table(name = "book")
@XmlRootElement
@NamedQueries({
      @NamedQuery(name = "Book.findAll",    query = "SELECT b FROM Book b")
    , @NamedQuery(name = "Book.findById",   query = "SELECT b FROM Book b WHERE b.id = :id")
    , @NamedQuery(name = "Book.removeById", query = "Delete From Book b WHERE b.id = :id")    
    , @NamedQuery(name = "Book.findByTitle",query = "SELECT b FROM Book b WHERE b.title = :title")
    , @NamedQuery(name = "Book.findByIsbn", query = "SELECT b FROM Book b WHERE b.isbn = :isbn")
    , @NamedQuery(name = "Book.findByPrice",query = "SELECT b FROM Book b WHERE b.price = :price")})
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "isbn")
    private String isbn;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private BigDecimal price;
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "aid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Author aid;
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "cid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Category cid;

    public Book() {
    }

    public Book(Integer id) {
        this.id = id;
    }

    public Book(Integer id, String title, String isbn, BigDecimal price) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Author getAid() {
        return aid;
    }

    public void setAid(Author aid) {
        this.aid = aid;
    }

    public Category getCid() {
        return cid;
    }

    public void setCid(Category cid) {
        this.cid = cid;
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
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "popelos.entity.Book[ id=" + id + " ]";
    }

}
