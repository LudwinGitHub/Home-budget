package pl.supra.budget;

import java.math.BigDecimal;

public class BudgetSummaryDTO {
    private final BigDecimal incomes;
    private final BigDecimal expenses;
    private final BigDecimal balance;

    public BudgetSummaryDTO(BigDecimal incomes, BigDecimal expenses, BigDecimal balance) {
        this.incomes = incomes;
        this.expenses = expenses;
        this.balance = balance;
    }

    public BigDecimal getIncomes() {
        return incomes;
    }

    public BigDecimal getExpenses() {
        return expenses;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
