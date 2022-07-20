package spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/spel")
public class Controller {

    @Value("#{'${MODE}' == 'dev' ? 'devValue' : '${MODE}' == 'prod' ? 'prodValue' : 'another'}")
    private String stringValue;

    @Value("#{'valid alphabetic string' matches '[a-zA-Z\\s]+' }") // true
    private boolean validAlphabeticStringResult;

    @Value("#{workersHolder.salaryByWorkers['John']}") // 35000
    private Integer johnSalary;

    @Value("#{workersHolder.workers[0]}") // John
    private String firstWorker;

    @Value("#{workersHolder.salaryByWorkers[workersHolder.workers[0]]}") // 35000
    private Integer firstWorkerSalary;

    @GetMapping("/string")
    public String getKyivWarehouse() {
        return stringValue;
    }

    @GetMapping("/validAlphabetic")
    public boolean getValidAlphabetic(){
        return validAlphabeticStringResult;
    }

    @GetMapping("/workers")
    public String getWorkersInfo(){
        return firstWorker + " " + firstWorkerSalary + " " + johnSalary;
    }
}
