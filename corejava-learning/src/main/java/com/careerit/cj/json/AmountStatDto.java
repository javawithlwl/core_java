package com.careerit.cj.json;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AmountStatDto {

    private int count;
    private double maxAmount;
    private double minAmount;
    private double totalAmount;
    private double avgAmount;

}
