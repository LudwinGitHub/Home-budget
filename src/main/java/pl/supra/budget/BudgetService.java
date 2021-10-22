package pl.supra.budget;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class BudgetService {
    private BudgetItemDao budgetItemDao = new BudgetItemDao();

    private void addIncome(BudgetItemDTO budgetItem){
        addBudgetItem(budgetItem, BudgetItemType.INCOME);
    }
    private void addExpense(BudgetItemDTO budgetItem){
        addBudgetItem(budgetItem, BudgetItemType.EXPENSE);
    }

    private void addBudgetItem(BudgetItemDTO budgetItemDTO, BudgetItemType type) {
        BudgetItem budgetItem = BudgetItemMapper.toEntity(budgetItemDTO, type);
    }
    public List<BudgetItemDTO> findAllExpenses(){
        return findAllItemsByType(BudgetItemType.EXPENSE)
                .stream()
                .map(BudgetItemMapper::fromEntity)
                .collect(Collectors.toList());

    }
    public List<BudgetItemDTO> findAllIncomes(){
        return findAllItemsByType(BudgetItemType.INCOME)
                .stream()
                .map(BudgetItemMapper::fromEntity)
                .collect(Collectors.toList());
    }

    private List<BudgetItem> findAllItemsByType(BudgetItemType type) {
        return budgetItemDao.findAllItems(type);
    }
    public BudgetSummaryDTO getSummary(){
        BigDecimal incomesSum = getIncomesSum();
        BigDecimal expensesSum = getExpensesSum();
        BigDecimal balance = incomesSum.subtract(expensesSum);
        return new BudgetSummaryDTO(incomesSum, expensesSum, balance);
    }

    private BigDecimal getExpensesSum() {
        return sumItemsValue(findAllItemsByType(BudgetItemType.EXPENSE));
    }

    private BigDecimal getIncomesSum() {
        return sumItemsValue(findAllItemsByType(BudgetItemType.INCOME));
    }
    private BigDecimal sumItemsValue(List<BudgetItem> items){
        return items.stream()
                .map(BudgetItem::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
