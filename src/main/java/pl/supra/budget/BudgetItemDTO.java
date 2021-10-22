package pl.supra.budget;

import java.math.BigDecimal;

public class BudgetItemDTO {
    private final String description;
    private final BigDecimal value;

    public BudgetItemDTO(String description, BigDecimal value) {
        this.description = description;
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getValue() {
        return value;
    }
}
