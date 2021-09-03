package kodlamaio.newnorthwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.newnorthwind.business.abstracts.UserService;
import kodlamaio.newnorthwind.core.dataAccess.UserDao;
import kodlamaio.newnorthwind.core.entities.User;
import kodlamaio.newnorthwind.core.utilities.results.DataResult;
import kodlamaio.newnorthwind.core.utilities.results.Result;
import kodlamaio.newnorthwind.core.utilities.results.SuccessDataResult;
import kodlamaio.newnorthwind.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService {
	
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		// business codes
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı başarıyla eklendi!");
	}

	@Override
	public DataResult<User> getByEmail(String email) {
		// business codes
		return new SuccessDataResult<User>(this.userDao.getByEmail(email), "Kullanıcı bulundu!");
	}

	
	
}
