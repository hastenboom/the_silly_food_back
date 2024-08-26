package org.student.backend.creditcard;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.student.backend.pojo.common.Result;

/**
 * @author Student
 */
@RestController
@RequestMapping("/creditcard")
public class CreditCardController {

    @Resource
    private CreditCardService creditCardService;

    @GetMapping
    public Result getCreditCardListByUserId(){
        return creditCardService.getCreditCardListByUserId();
    }

}
