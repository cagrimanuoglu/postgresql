package com.example.springPostgres.springPostgresql.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.Id;

@Entity
@Table(name="kisi_adres")
public class Address  {
	
	@Id
	@SequenceGenerator(name="seq_kisi_adres",allocationSize=1)
	@GeneratedValue(generator="seq_kisi_adres",strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name="address")
	private String address;
	
	@Enumerated
	private AdresTip adrestip;
	@Column(name="aktif")
	private Boolean aktif;
	
	@ManyToOne
	@JoinColumn(name="kisi_adres_id")
	private User user;
	
	public enum AdresTip
	{
		ev_adresi,
		is_adresi,
		diger
	}
	
	public Address()
	{
		
	}

	public Address(Long id, String address, AdresTip adrestip, Boolean aktif) {
		super();
		this.id = id;
		this.address = address;
		this.adrestip = adrestip;
		this.aktif = aktif;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public AdresTip getAdrestip() {
		return adrestip;
	}

	public void setAdrestip(AdresTip adrestip) {
		this.adrestip = adrestip;
	}

	public Boolean getAktif() {
		return aktif;
	}

	public void setAktif(Boolean aktif) {
		this.aktif = aktif;
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		Address other = (Address) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", address=" + address + ", adrestip=" + adrestip + ", aktif=" + aktif + "]";
	}
	
	
	
	

}
