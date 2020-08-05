package com.example.springPostgres.springPostgresql.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.Id;

@Entity
@Table(name = "kisi")
public class User {
	
	
	
	@Id
	@SequenceGenerator(name="seq_kisi",allocationSize = 1)
	@GeneratedValue(generator = "seq_kisi",strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name="adi")
	private String adi;
	@Column(name="soyadi")
	private String soyadi;
	
	@OneToMany
	@JoinColumn(name="kisi_adres_id")
	private List<Address> adresleri;
	
	public User()
	{
		
	}

	public User(Long id, String adi, String soyadi, List<Address> adresleri) {
		super();
		this.id = id;
		this.adi = adi;
		this.soyadi = soyadi;
		this.adresleri = adresleri;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	public String getSoyadi() {
		return soyadi;
	}

	public void setSoyadi(String soyadi) {
		this.soyadi = soyadi;
	}

	public List<Address> getAdresleri() {
		return adresleri;
	}

	public void setAdresleri(List<Address> adresleri) {
		this.adresleri = adresleri;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
}
