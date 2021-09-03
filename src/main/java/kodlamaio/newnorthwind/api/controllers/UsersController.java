package kodlamaio.newnorthwind.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.newnorthwind.business.abstracts.UserService;
import kodlamaio.newnorthwind.core.entities.User;
import kodlamaio.newnorthwind.core.utilities.results.ErrorDataResult;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("/add")         //bu Valid, User user'i validasyondan geçir demek.
	public ResponseEntity<?> add(@Valid @RequestBody User user) {    //normalde Result yazıyorduk generice. ? yazma sebebi, her zaman okey donmeyebilir, hata da dönebilir. gelen sonuca göre değişir. 
		return ResponseEntity.ok(this.userService.add(user));
	}
	
	//aop yapacağız, global hata yakalama.
	//aop örneğin add operasyonunda bir hata olursa önüne global exception handler koyuyor.
	//tüm metodlara ayrı ayrı try catch yerine bir tane trycatch yazıp tüm operasyonları oraya yollarız.
	// bu yapı da spring bootle hazır olarak karşımıza çıkıyor.
	
	//bu yapının mantigini bilmek yeterli. spring dökümantasyonundan bakabiliriz.
	@ExceptionHandler(MethodArgumentNotValidException.class) //bu sistemde şu türde hata olursa bu metodu devreye sok diyoruz. bu class butun validation hatalarına sahip.
	@ResponseStatus(HttpStatus.BAD_REQUEST) //default olarak 500 dönsün.
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) { //neden object? çünkü dönen hata her şey olabilir. validation kuralları, sistem hataları vs. o yüzden genel bir veritipi olan object diyoruz. her şeyin base'i objecttir. 
		//hangi alanda hata oldu ve hata ne? email alanında hata oldu, email formatı uygun mu vs.
		//dolayısıyla burada iki alanı vereceğimiz için Map yapısını kullanacağız. dictionary mantıgı
		
		Map<String, String> validationErrors = new HashMap<String, String>();
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Doğrulama hataları");
		return errors;
	}
	
	
	
	
}
//200 get, 201 add
//300
//400
//500
