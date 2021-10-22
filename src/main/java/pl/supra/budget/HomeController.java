package pl.supra.budget;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("")
public class HomeController extends HttpServlet {
    private BudgetService budgetService = new BudgetService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BudgetItemDTO> incomes = budgetService.findAllIncomes();
        List<BudgetItemDTO> expenses = budgetService.findAllExpenses();
        BudgetSummaryDTO summary = budgetService.getSummary();
        request.setAttribute("incomes", incomes);
        request.setAttribute("expenses", expenses);
        request.setAttribute("summary", summary);
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }
}
