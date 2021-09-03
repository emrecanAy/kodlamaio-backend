package kodlamaio.newnorthwind.business.abstracts;

import kodlamaio.newnorthwind.core.entities.User;
import kodlamaio.newnorthwind.core.utilities.results.DataResult;
import kodlamaio.newnorthwind.core.utilities.results.Result;

public interface UserService {
	
	Result add(User user);
	
	DataResult<User> getByEmail(String email);

}
