/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.Prak.API.consume.demo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PAVILION GAMING
 */
@Entity
@Table(name = "datamhsti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Datamhsti.findAll", query = "SELECT d FROM Datamhsti d"),
    @NamedQuery(name = "Datamhsti.findById", query = "SELECT d FROM Datamhsti d WHERE d.id = :id"),
    @NamedQuery(name = "Datamhsti.findByNama", query = "SELECT d FROM Datamhsti d WHERE d.nama = :nama"),
    @NamedQuery(name = "Datamhsti.findByAlamat", query = "SELECT d FROM Datamhsti d WHERE d.alamat = :alamat"),
    @NamedQuery(name = "Datamhsti.findByProgramstudi", query = "SELECT d FROM Datamhsti d WHERE d.programstudi = :programstudi"),
    @NamedQuery(name = "Datamhsti.findByFakultas", query = "SELECT d FROM Datamhsti d WHERE d.fakultas = :fakultas")})
public class Datamhsti implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Column(name = "nama")
    private String nama;
    @Column(name = "alamat")
    private String alamat;
    @Column(name = "programstudi")
    private String programstudi;
    @Column(name = "fakultas")
    private String fakultas;

    public Datamhsti() {
    }

    public Datamhsti(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getProgramstudi() {
        return programstudi;
    }

    public void setProgramstudi(String programstudi) {
        this.programstudi = programstudi;
    }

    public String getFakultas() {
        return fakultas;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
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
        if (!(object instanceof Datamhsti)) {
            return false;
        }
        Datamhsti other = (Datamhsti) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ws.Prak.API.consume.demo.Datamhsti[ id=" + id + " ]";
    }
    
}
