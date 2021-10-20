package pl.supra.budget;

import java.math.BigDecimal;

public class BudgetItem {
    private String description;
    private BigDecimal value;
    private BudgetItemType budgetItemType;

    public BudgetItem(String description, BigDecimal value, BudgetItemType budgetItemType) {
        this.description = description;
        this.value = value;
        this.budgetItemType = budgetItemType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BudgetItemType getBudgetItemType() {
        return budgetItemType;
    }

    public void setBudgetItemType(BudgetItemType budgetItemType) {
        this.budgetItemType = budgetItemType;
    }
}
