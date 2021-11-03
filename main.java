import javax.swing.*;

/**
 * @author Sebastian DSouza 
 * @version November 2nd, 2021
 */
public class main {
    public static void main(String[] args) {
        int weeksLeft = 0;
        double diningDollars = 0;
        double boilerExpress = 0;
        String budgetingInput;
        String dayOrWeekInput;
        String output = "";

        showWelcomeMessageDialog();
        weeksLeft = showWeeksLeftInputDialog();
        diningDollars = showDiningDollarsInputDialog();
        budgetingInput = showBudgetingOptionsInputDialog();
        boilerExpress = showBoilerExpressInputDialog();
        dayOrWeekInput = showDayOrWeekOptionInputDialog();

        output += "User Input: \n";
        output += "Weeks Left: " + weeksLeft + "\n";
        output += "Dining Dollars: " + diningDollars + "0\n";
        output += "Boiler Express: " + boilerExpress + "0\n\n";

        output += "Program Output: \n";
        if (dayOrWeekInput.equals("Day")) {
            output += "You can spend " + (Math.round(diningDollars / weeksLeft / 7)) + " dollars per day on dining using dining dollars.\n";
            if (budgetingInput.equals("Laundry")) {
                output += "You have " + (Math.floor(boilerExpress / 3.50)) + " loads of laundry left on your Boiler Express\n";
            } else if (budgetingInput.equals("Dining")) {
                output += "You can spend " + (Math.round(boilerExpress / weeksLeft / 7)) + " dollars per day on dining using Boiler Express.\n";
            } else if (budgetingInput.equals("Both")) {
                output += "You can spend " + (Math.floor(boilerExpress - (3.50 * weeksLeft)) / weeksLeft / 7) + " dollars per day on both.\n";
            }
        } else {
            output += "You can spend " + (Math.round(diningDollars / weeksLeft)) + ".00 dollars per week on dining using dining dollars.\n";
            if (budgetingInput.equals("Laundry")) {
                output += "You have " + (Math.floor(boilerExpress / 3.50)) + " loads of laundry left on your Boiler Express\n";
            } else if (budgetingInput.equals("Dining")) {
                output += "You can spend " + (Math.round(boilerExpress / weeksLeft)) + " dollars per week on dining using Boiler Express.\n";
            } else if (budgetingInput.equals("Both")) {
                output += "You can spend " + (Math.floor(boilerExpress - (3.50 * weeksLeft)) / weeksLeft) + "0 dollars per week on dining using Boiler Express\n and have enough to pay for laundry every week for the rest of the semester\n";
            }
        }



        showPrintingDetailsDialog(output);
    }


    public static void showWelcomeMessageDialog() {
        JOptionPane.showMessageDialog(null, "Welcome to Sebastian's Meal Plan/Laundry Budgeting App\n\nBuilt by a Purdue Student, for Purdue Students",
                "", JOptionPane.INFORMATION_MESSAGE);
    }

    public static int showWeeksLeftInputDialog() {
        int weeks = 0;
        do {
            weeks = Integer.parseInt(JOptionPane.showInputDialog(null, "How many weeks are left in the semester?", 
                    "Weeks", JOptionPane.QUESTION_MESSAGE));
            if ((weeks == 0)) {
                JOptionPane.showMessageDialog(null, "Cannot be empty!", "Sebastian's Meal Plan/Laundry Budgeting App",
                        JOptionPane.ERROR_MESSAGE);
            }
            return weeks;
        } while ((weeks == 0));
    } 

    public static int showDiningDollarsInputDialog() {
        int dollars = 0;
        do {
            dollars = Integer.parseInt(JOptionPane.showInputDialog(null, "How many dining dollars do you have left?", 
                    "Dining Dollars", JOptionPane.QUESTION_MESSAGE));
            if ((dollars == 0)) {
                JOptionPane.showMessageDialog(null, "Cannot be empty!", "Sebastian's Meal Plan/Laundry Budgeting App",
                        JOptionPane.ERROR_MESSAGE);
            }
            return dollars;
        } while ((dollars == 0));
    }
    
    public static int showBoilerExpressInputDialog() {
        int dollars = 0;
        do {
            dollars = Integer.parseInt(JOptionPane.showInputDialog(null, "How many dollars in Boiler Express do you have left?", 
                    "Boiler Express", JOptionPane.QUESTION_MESSAGE));
            if ((dollars == 0)) {
                JOptionPane.showMessageDialog(null, "Cannot be empty!", "Sebastian's Meal Plan/Laundry Budgeting App",
                        JOptionPane.ERROR_MESSAGE);
            }
            return dollars;
        } while ((dollars == 0));
    } 

    public static String showBudgetingOptionsInputDialog() {
        String[] budgetingOptions = {"Laundry", "Dining", "Both"};
        String selectedBudgetingOptions = JOptionPane.showInputDialog(null, "What do you use Boiler Express for?", 
                "Sebastian's Meal Plan/Laundry Budgeting App", JOptionPane.QUESTION_MESSAGE, null, budgetingOptions, budgetingOptions[0]).toString();
        return selectedBudgetingOptions;
    }

    public static String showDayOrWeekOptionInputDialog() {
        String[] dayOrWeek = {"Day", "Week"};
        String selectedDayOrWeek = JOptionPane.showInputDialog(null, "Do you want to budget on a day or a week basis?", 
                "Sebastian's Meal Plan/Laundry Budgeting App", JOptionPane.QUESTION_MESSAGE, null, dayOrWeek, dayOrWeek[0]).toString();
        return selectedDayOrWeek;
    }

    /**
     * Displays a Message Dialog with the following text: "Printing Details to Terminal..."
     */
    public static void showPrintingDetailsDialog(String output) {
        JOptionPane.showMessageDialog(null, output,
                "", JOptionPane.INFORMATION_MESSAGE);
    } //showPrintingDetailsDialog
} //UniversityCard