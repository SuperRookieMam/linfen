package ttt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.security.annotation.CurrentUser;
import com.dm.security.core.userdetails.UserDetailsDto;

@RestController
@RequestMapping("tc")
public class TcController {

	@GetMapping
	public String gg(@CurrentUser UserDetailsDto user) {
		System.out.println("let us go die!");
		return "";
	}
}
