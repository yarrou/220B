package by.v.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Currency {
    @JsonProperty("Cur_ID")
    private int cur_ID;
    @JsonProperty("Date")
    private String date;
    @JsonProperty("Cur_Abbreviation")
    private String cur_Abbreviation;
    @JsonProperty("Cur_Scale")
    private int cur_Scale;
    @JsonProperty("Cur_Name")
    private String cur_Name;
    @JsonProperty("Cur_OfficialRate")
    private double cur_OfficialRate;
}