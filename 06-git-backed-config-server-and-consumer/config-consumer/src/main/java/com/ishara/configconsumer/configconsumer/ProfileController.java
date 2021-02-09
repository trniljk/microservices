package com.ishara.configconsumer.configconsumer;

import com.ishara.configconsumer.configconsumer.model.LoyaltyMemberProfileConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController

@Controller
public class ProfileController {

    @Autowired
    LoyaltyMemberProfileConfiguration loyaltyMemberProfileConfiguration;

//    @RequestMapping("/profile")
//    public LoyaltyMemberProfileConfiguration getConfig(){
//        return loyaltyMemberProfileConfiguration;
//    }


    @RequestMapping("/profile")
    public String getConfig(Model model){

        model.addAttribute("model",loyaltyMemberProfileConfiguration.getDefaultType());
        model.addAttribute("min",loyaltyMemberProfileConfiguration.getMinBookingPeriod());
        model.addAttribute("offer",loyaltyMemberProfileConfiguration.getRewardedOffers());
        return "memberProfile";

    }

}
