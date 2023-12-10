package ma.khardali.voiture.Service;

import ma.khardali.voiture.Model.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Service
@FeignClient(name="SERVICE-CLIENT")
public interface ClientServiceVoiture {
    @GetMapping("/clients/{id}")
    Client clientById(@PathVariable Long id);
}
