import java.util.ArrayList;
import java.util.HashMap;

public class ExpensesManager {
    HashMap<String, ArrayList<Double>> expensesByCategories;

    ExpensesManager() {
        expensesByCategories = new HashMap<>();
    }
    ArrayList<Double> expenses;
    double saveExpense(double moneyBeforeSalary, String category, double expense) {
        moneyBeforeSalary = moneyBeforeSalary - expense;
        System.out.println("Значение сохранено! Ваш текущий баланс в рублях: " + moneyBeforeSalary);
        if (expensesByCategories.containsKey(category)) {
           expenses = expensesByCategories.get(category);
            expenses.add(expense);
        } else {
           expenses = new ArrayList<>();
            expenses.add(expense);
            expensesByCategories.put(category, expenses);
        }
        if (moneyBeforeSalary < 1000) {
            System.out.println("На вашем счету осталось совсем немного. Стоит начать экономить!");
        }
        return moneyBeforeSalary;
    }

    void printAllExpensesByCategories() {
        for (String category : expensesByCategories.keySet()) {
            System.out.println(category);
           expenses = expensesByCategories.get(category);
            for (Double expense : expenses) {
                System.out.println(expense);
            }
        }
    }

    double findMaxExpenseInCategory(String category) {
        double maxExpense = 0;
        if (expensesByCategories.containsKey(category)) {
          expenses = expensesByCategories.get(category);
            for (Double expense : expenses) {
                if (expense > maxExpense) {
                    maxExpense = expense;
                }
            }
        } else {
            System.out.println("Такой категории пока нет.");
        }
        return maxExpense;
    }

    void removeAllExpenses() {
        expensesByCategories.clear();
        System.out.println("Траты удалены.");
    }

    double getExpensesSum(){

        double max =0;

        for (String str : expensesByCategories.keySet()) {
            expenses = expensesByCategories.get(str);
            for (Double expens : expenses) {
                max += expens;
            }
        }

    return max;
    } // Напишите метод для получения суммы всех трат

    void removeCategory(String category) {
        expensesByCategories.remove(category);
    } // Напишите метод для удаления категории



            String getMaxCategoryName() {

                double maxCategorySum = 0;
                String maxCategoryName = "";

                for (String str : expensesByCategories.keySet()){
                    expenses = expensesByCategories.get(str);

                    for (Double max : expenses){
                        if (max > maxCategorySum){
                            maxCategorySum = max;
                            maxCategoryName = str;
                        }
                         }
                }
                return maxCategoryName;
            }
}