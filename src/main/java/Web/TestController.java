package Web;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping()
@RequiredArgsConstructor
public class TestController {

@GetMapping()
public ResponseEntity<Map<String, String>> test() {
	return ResponseEntity.ok().body(Map.of("Testing", "Up and running"));
}
}
