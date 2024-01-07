package com.kiran.artcollectorregistration.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 Long id;

	@Column(nullable = false, unique = true)
	 String name;

	@ManyToMany(mappedBy = "roles")
	 List<ArtCollector> artCollector = new ArrayList<>();

	public Role(String name, List<ArtCollector> artCollector) {
		super();
		this.name = name;
		this.artCollector = artCollector;
	}

	@Override
	public int hashCode() {
		return Objects.hash(artCollector, id, name);
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
		return Objects.equals(artCollector, other.artCollector) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}

}
