package com.kiran.artcollectorregistration.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	 @Column(nullable = false, unique=true)
    private String name;
	 
    @ManyToMany(mappedBy ="roles", fetch = FetchType.EAGER)
    private List<ArtCollector> artcollector = new ArrayList<>();

	public Role(String name, List<ArtCollector> artcollector) {
		super();
		this.name = name;
		this.artcollector = artcollector;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(artcollector, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		return Objects.equals(artcollector, other.artcollector) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", artcollector=" + artcollector + "]";
	}

	public Role(String name) {
		//super();
		this.name = name;
	}
    
   
    

}
