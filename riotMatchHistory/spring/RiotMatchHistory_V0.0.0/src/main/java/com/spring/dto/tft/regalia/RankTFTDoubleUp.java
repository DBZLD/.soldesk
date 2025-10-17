package com.spring.dto.tft.regalia;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RankTFTDoubleUp {
    @JsonProperty("Bronze")
    public Bronze BRONZE;

    @JsonProperty("Challenger")
    public Challenger CHALLENGER;

    @JsonProperty("Diamond")
    public Diamond DIAMOND;

    @JsonProperty("Emerald")
    public Emerald EMERALD;

    @JsonProperty("Gold")
    public Gold GOLD;

    @JsonProperty("Grandmaster")
    public Grandmaster GRANDMASTER;

    @JsonProperty("Iron")
    public Iron IRON;

    @JsonProperty("Master")
    public Master MASTER;

    @JsonProperty("Platinum")
    public Platinum PLATINUM;

    @JsonProperty("Provisional")
    public Provisional PROVISIONAL;

    @JsonProperty("Silver")
    public Silver SILVER;
}
