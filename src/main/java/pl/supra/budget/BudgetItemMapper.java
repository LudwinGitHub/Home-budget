package pl.supra.budget;

public class BudgetItemMapper {
    static BudgetItemDTO fromEntity(BudgetItem budgetItem){
        return new BudgetItemDTO(budgetItem.getDescription(), budgetItem.getValue());
    }
    static BudgetItem toEntity(BudgetItemDTO dto, BudgetItemType type){
        return new BudgetItem(dto.getDescription(), dto.getValue(), type);
    }
}
