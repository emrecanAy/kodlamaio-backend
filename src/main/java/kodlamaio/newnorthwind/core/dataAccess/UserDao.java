package kodlamaio.newnorthwind.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.newnorthwind.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer>{

	User getByEmail(String email); //findByEmail de diyebiliriz.
 	
}
