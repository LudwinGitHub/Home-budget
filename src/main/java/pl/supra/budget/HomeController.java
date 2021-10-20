package pl.supra.budget;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("")
public class HomeController extends HttpServlet {
    private BudgetItemDao budgetItemDao = new BudgetItemDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BudgetItem> incomes = budgetItemDao.findAllItems(BudgetItemType.INCOME);
        List<BudgetItem> expenses = budgetItemDao.findAllItems(BudgetItemType.EXPENSE);
        BigDecimal incomesSum = getSum(incomes);
        BigDecimal expensesSum = getSum(expenses);
        BigDecimal balance = incomesSum.subtract(expensesSum);
        request.setAttribute("incomes", incomes);
        request.setAttribute("expenses", expenses);
        request.setAttribute("incomeSum", incomesSum);
        request.setAttribute("expensesSum", expensesSum);
        request.setAttribute("balance", balance);
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);

    }
    private BigDecimal getSum(List<BudgetItem> items){
        return items.stream()
                .map(BudgetItem::getValue)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
