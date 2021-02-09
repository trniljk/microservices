package com.ishara.configconsumer.configconsumer.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


@Component
public class LoyaltyMemberProfileConfiguration {
    @Autowired
    Environment environment;


    public String getDefaultType(){
        return environment.getProperty("room.default.type");
    }
    public String getMinBookingPeriod(){
        return environment.getProperty("member.booking.min");
    }
    public String getRewardedOffers(){
        return environment.getProperty("member.reward.offers");
    }
}
