package practice20240612;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class RevenueCalculator implements Callable<Double> {
    private List<Cafe> cafes;

    public RevenueCalculator(List<Cafe> cafes) {
        this.cafes = cafes;
    }

    @Override
    public Double call() {
        return cafes.stream().mapToDouble(Cafe::getSum).sum();
    }
}

class AlcoholRevenueCalculator implements Callable<Double> {
    private List<Cafe> cafes;

    public AlcoholRevenueCalculator(List<Cafe> cafes) {
        this.cafes = cafes;
    }

    @Override
    public Double call() {
        return cafes.stream().filter(cafe -> cafe.getMenu() == Menu.ALCOHOL).mapToDouble(Cafe::getSum).sum();
    }
}

class SnackRevenueCalculator implements Callable<Double> {
    private List<Cafe> cafes;

    public SnackRevenueCalculator(List<Cafe> cafes) {
        this.cafes = cafes;
    }

    @Override
    public Double call() {
        return cafes.stream().filter(cafe -> cafe.getMenu() == Menu.SNACK).mapToDouble(Cafe::getSum).sum();
    }
}

class KitchenRevenueCalculator implements Callable<Double> {
    private List<Cafe> cafes;

    public KitchenRevenueCalculator(List<Cafe> cafes) {
        this.cafes = cafes;
    }

    @Override
    public Double call() {
        return cafes.stream().filter(cafe -> cafe.getMenu() == Menu.KITCHEN).mapToDouble(Cafe::getSum).sum();
    }
}

class DeductionsCalculator implements Callable<Deductions> {
    private double totalRevenue;
    private double alcoholRevenue;
    private double snackRevenue;
    private double kitchenRevenue;

    public DeductionsCalculator(double totalRevenue, double alcoholRevenue, double snackRevenue, double kitchenRevenue) {
        this.totalRevenue = totalRevenue;
        this.alcoholRevenue = alcoholRevenue;
        this.snackRevenue = snackRevenue;
        this.kitchenRevenue = kitchenRevenue;
    }

    @Override
    public Deductions call() {
        double vat = totalRevenue * 0.15;
        double alcoholExcise = alcoholRevenue * 0.02;
        double snackTax = snackRevenue * 0.01;
        double kitchenPay = kitchenRevenue * 0.10;
        double employeeSalary = totalRevenue * 0.20;
        double investorPayout = totalRevenue * 0.10;
        double totalDeductions = vat + alcoholExcise + snackTax + kitchenPay + employeeSalary + investorPayout;
        return new Deductions(vat, alcoholExcise, snackTax, kitchenPay, employeeSalary, investorPayout, totalDeductions);
    }
}

class Deductions {
    double vat;
    double alcoholExcise;
    double snackTax;
    double kitchenPay;
    double employeeSalary;
    double investorPayout;
    double totalDeductions;

    public Deductions(double vat, double alcoholExcise, double snackTax, double kitchenPay, double employeeSalary, double investorPayout, double totalDeductions) {
        this.vat = vat;
        this.alcoholExcise = alcoholExcise;
        this.snackTax = snackTax;
        this.kitchenPay = kitchenPay;
        this.employeeSalary = employeeSalary;
        this.investorPayout = investorPayout;
        this.totalDeductions = totalDeductions;
    }
}

class NetIncomeCalculator implements Callable<NetIncome> {
    private double totalRevenue;
    private double totalDeductions;

    public NetIncomeCalculator(double totalRevenue, double totalDeductions) {
        this.totalRevenue = totalRevenue;
        this.totalDeductions = totalDeductions;
    }

    @Override
    public NetIncome call() {
        double netIncome = totalRevenue - totalDeductions;
        double netIncomePercentage = (netIncome / totalRevenue) * 100;
        return new NetIncome(netIncome, netIncomePercentage);
    }
}

class NetIncome {
    double netIncome;
    double netIncomePercentage;

    public NetIncome(double netIncome, double netIncomePercentage) {
        this.netIncome = netIncome;
        this.netIncomePercentage = netIncomePercentage;
    }
}

public class Main {
    private static final int NUM_ITEMS = 300; // Number of items for the revenue generation
    private static final int NUM_THREADS = 6;

    public static void main(String[] args) {
        List<Cafe> cafes = generateRevenue();

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        try {
            Future<Double> totalRevenueFuture = executor.submit(new RevenueCalculator(cafes));
            Future<Double> alcoholRevenueFuture = executor.submit(new AlcoholRevenueCalculator(cafes));
            Future<Double> snackRevenueFuture = executor.submit(new SnackRevenueCalculator(cafes));
            Future<Double> kitchenRevenueFuture = executor.submit(new KitchenRevenueCalculator(cafes));

            double totalRevenue = totalRevenueFuture.get();
            double alcoholRevenue = alcoholRevenueFuture.get();
            double snackRevenue = snackRevenueFuture.get();
            double kitchenRevenue = kitchenRevenueFuture.get();

            Future<Deductions> deductionsFuture = executor.submit(new DeductionsCalculator(totalRevenue, alcoholRevenue, snackRevenue, kitchenRevenue));
            Deductions deductions = deductionsFuture.get();

            Future<NetIncome> netIncomeFuture = executor.submit(new NetIncomeCalculator(totalRevenue, deductions.totalDeductions));
            NetIncome netIncome = netIncomeFuture.get();

            System.out.println("Total Revenue: $" + totalRevenue);
            System.out.println("VAT (15%): $" + deductions.vat);
            System.out.println("Alcohol Excise (2%): $" + deductions.alcoholExcise);
            System.out.println("Snack Tax (1%): $" + deductions.snackTax);
            System.out.println("Kitchen Pay (10%): $" + deductions.kitchenPay);
            System.out.println("Employee Salary (20%): $" + deductions.employeeSalary);
            System.out.println("Investor Payout (10%): $" + deductions.investorPayout);
            System.out.println("Net Income: $" + netIncome.netIncome);
            System.out.println("Net Income Percentage: " + netIncome.netIncomePercentage + "%");

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    private static List<Cafe> generateRevenue() {
        List<Cafe> cafes = new ArrayList<>();
        for (int i = 0; i < NUM_ITEMS; i++) {
            cafes.add(new Cafe());
        }
        return cafes;
    }
}