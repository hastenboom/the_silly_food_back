package org.student.backend.creditcard;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.student.backend.cart.CreditCardDTO;
import org.student.backend.login.UserDTOHolder;
import org.student.backend.mapper.CreditCardMapper;
import org.student.backend.mapper.IssuerMapper;
import org.student.backend.pojo.common.Result;
import org.student.backend.pojo.entity.CreditCard;
import org.student.backend.pojo.entity.Issuer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Student
 */
@Service
public class CreditCardServiceImpl implements CreditCardService {

    @Resource
    private CreditCardMapper creditCardMapper;

    @Resource
    private IssuerMapper issuerMapper;

    @Override
    @Transactional
    public Result getCreditCardListByUserId() {
        Long userId = UserDTOHolder.getUser().getId();

        List<CreditCard> creditCardList = creditCardMapper.selectList(
                new QueryWrapper<CreditCard>()
                        .eq("user_id", userId)
        );

        List<CreditCardDTO> creditCardDTOList = new ArrayList<>(creditCardList.size());

        for (CreditCard creditCard : creditCardList) {
            Issuer issuer = issuerMapper.selectById(
                    creditCard.getIssuerId()
            );

            CreditCardDTO creditCardDTO = BeanUtil.copyProperties(creditCard, CreditCardDTO.class);
            creditCardDTO.setIssuerName(issuer.getName());
            creditCardDTO.setIssuerLogoUrl(issuer.getLogoUrl());

            creditCardDTOList.add(creditCardDTO);

        }

        return Result.ok(creditCardDTOList);
    }
}
