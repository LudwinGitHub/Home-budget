package pl.supra.budget;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/add")
public class BudgetAddController extends HttpServlet {
    private BudgetItemDao budgetItemDao = new BudgetItemDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/addform.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        BigDecimal value = new BigDecimal(request.getParameter("value"));
        BudgetItemType type = BudgetItemType.valueOf(request.getParameter("type"));
        BudgetItem budgetItem = new BudgetItem(description, value, type);
        budgetItemDao.save(budgetItem);
        response.sendRedirect(request.getContextPath() + "/");
    }
}
