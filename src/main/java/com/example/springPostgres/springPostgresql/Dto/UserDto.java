package com.example.springPostgres.springPostgresql.Dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Benim User nesnem",description = "Benim user")
public class UserDto {
	
	@ApiModelProperty(value = "User nesnesinin tekil id alanı")
	private Long id;
	@ApiModelProperty(value = "User nesnesinin adi alanı")
	private String adi;
	@ApiModelProperty(value = "User nesnesinin soyadi alanı")
	private String soyadi;
	@ApiModelProperty(value = "User nesnesinin adresler alanı")
	private List<String> adresler;

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

	public List<String> getAdresler() {
		return adresler;
	}

	public void setAdresler(List<String> adresler) {
		this.adresler = adresler;
	}
	public UserDto()
	{
		
	}

	public UserDto(Long id, String adi, String soyadi, List<String> adresler) {
		super();
		this.id = id;
		this.adi = adi;
		this.soyadi = soyadi;
		this.adresler = adresler;
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
		UserDto other = (UserDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", adi=" + adi + ", soyadi=" + soyadi + ", adresler=" + adresler + "]";
	}
	
	
}
