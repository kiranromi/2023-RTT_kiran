package com.kiran.artcollectorregistration.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
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
@Table(name= "artcollectors")
public class ArtCollector {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(nullable = false)
	  private Long id;
	
	
	private String country;
	
        @Column(nullable = false, unique=true)
	    private String username;
        
        @Column(nullable = false, unique=true)
	    private String email;
        
        @Column(nullable = false)
	    private String password;
	    
	    @ManyToMany(fetch = FetchType.EAGER, cascade= CascadeType.ALL)
	    @JoinTable(name= "artcollector_roles",
		joinColumns= {@JoinColumn(name= "artcollector_id", referencedColumnName= "id")},
				inverseJoinColumns = {@JoinColumn(name= "role_id", referencedColumnName= "id")})
		 public  List<Role>roles = new ArrayList<>();
	    
	  
	    

		public ArtCollector(String username, String email, String password, String country,List<Role> roles) {
			super();
			this.username = username;
			this.email = email;
			this.password = password;
			this.country = country;
			this.roles = roles;
		}
					

		public ArtCollector(String username, String email, String password, String country) {
			super();
			this.username = username;
			this.email = email;
			this.password = password;
			this.country = country;
		}


		@Override
		public int hashCode() {
			return Objects.hash(country, email, id, password, roles, username);
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ArtCollector other = (ArtCollector) obj;
			return Objects.equals(country, other.country) && Objects.equals(email, other.email)
					&& Objects.equals(id, other.id) && Objects.equals(password, other.password)
					&& Objects.equals(roles, other.roles) && Objects.equals(username, other.username);
		}


		@Override
		public String toString() {
			return "ArtCollector [id=" + id + ", country=" + country + ", username=" + username + ", email=" + email
					+ ", password=" + password + ", roles=" + roles + "]";
		}
		
		

		
	    
	    

}
